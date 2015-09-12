package com.gw.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.util.WebUtils;

public class Initweb implements ServletContextListener {

	Logger logger = LoggerFactory.getLogger(Initweb.class);
	// public static String imgPath="";
	private String loctionOfinit = "initwebConfigLocation";

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("contextDestroyed init success");
		logger.info("contextDestroyed init success");
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO 加载微信
		logger.info("start init success");
//		initStaticProperty(arg0);
//		TimerTask weixin = new Weixin();
//		Timer timer = new Timer();
//		timer.schedule(weixin, 0, 3600 * 1000);
		
		
		InitImg(arg0);//所有数据库的图片加载到本地。
	}

	private void initStaticProperty(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		ServletContext servletContext = arg0.getServletContext();
		// Only perform custom log4j initialization in case of a config file.
		String location = servletContext.getInitParameter(loctionOfinit);
		if (location != null) {
			try {
				location = SystemPropertyUtils.resolvePlaceholders(location);
				if (!ResourceUtils.isUrl(location)) {
					location = WebUtils.getRealPath(servletContext, location);
				}
				String resolvedLocation = SystemPropertyUtils.resolvePlaceholders(location);
				URL url = ResourceUtils.getURL(resolvedLocation);

				InputStream in = null;
				try {
					in = url.openStream();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Properties properties = new Properties();
				try {
					properties.load(in);
					// String a=properties.getProperty("imgPath").trim();
					// System.out.println(a);
					// imgPath=a;
					String u = properties.getProperty("web.url").trim();
					logger.debug(u);
					StaticProperty.Url = u;
				} catch (Exception e) {
					// TODO: handle exception
				}
			} catch (FileNotFoundException ex) {
				throw new IllegalArgumentException("Invalid 'log4jConfigLocation' parameter: " + ex.getMessage());
			}
		}
	}

	private  void InitImg(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("start init success");
		ServletContext servletContext =arg0.getServletContext();
		// Only perform custom log4j initialization in case of a config file.
		String location = servletContext.getInitParameter(loctionOfinit);
		if (location != null) {
			try {
				location = SystemPropertyUtils.resolvePlaceholders(location);
				if (!ResourceUtils.isUrl(location)) {
					location = WebUtils.getRealPath(servletContext, location);
				}
				String resolvedLocation = SystemPropertyUtils.resolvePlaceholders(location);
				URL url = ResourceUtils.getURL(resolvedLocation);
				
				InputStream in=null;
				try {
					in = url.openStream();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Properties properties=new Properties();
				try {
					properties.load(in);
					System.out.println(properties.getProperty("datasource.url").trim());
					readImgFromSql(properties.getProperty("datasource.url").trim(),properties.getProperty("datasource.username").trim(),properties.getProperty("datasource.password").trim());
				} catch (Exception e) {
					// TODO: handle exception
				}
				}catch (FileNotFoundException ex) {
					throw new IllegalArgumentException("Invalid 'log4jConfigLocation' parameter: " + ex.getMessage());
				}
		}
		
		
	}
	
	   private void readImgFromSql(String url,String username,String password) {
		// TODO Auto-generated method stub
		   Connection con = null; //定义一个MYSQL链接对象
		   Statement stmt = null; //创建声明
		   try {
			   System.out.println("==================downloading img=========");
	            Class.forName("com.mysql.jdbc.Driver").newInstance(); //MYSQL驱动
	            con = DriverManager.getConnection(url, username, password); //链接本地MYSQL
	            //System.out.println("yes");
	            stmt = con.createStatement();
				String path	=this.getClass().getResource("").getPath();  
				if(path.contains("WEB-INF")){
					//查找“WEB-INF”在该字符串的位置  
					int num = path.indexOf("WEB-INF");  
					//截取即可  
					path=path.substring(0, num+"WEB-INF".length()-7)+"uploadimg";
				}else if(path.contains("target")){
					//查找“WEB-INF”在该字符串的位置  
					int num = path.indexOf("target");  
					//截取即可  
					path=path.substring(0, num+"target".length()-6)+"uploadimg";
				}
			      File targetdirectory = new File(path);
			   	if(!targetdirectory.exists()){  
		       		targetdirectory.mkdirs();  
				} 
	            //查询数据并输出
	            String selectSql = "SELECT * FROM images";
	            ResultSet selectRes = stmt.executeQuery(selectSql);
	            while (selectRes.next()) { //循环输出结果集
	                String name = selectRes.getString("name");
	                InputStream img = selectRes.getBinaryStream("img");
	                  BufferedInputStream bin = new BufferedInputStream(img);
//	                  
	                  PrintStream pout = new PrintStream(targetdirectory.getAbsolutePath()+"/"+name);
	                  BufferedOutputStream bout = new BufferedOutputStream(pout);
	                  int count;
	                  while((count = bin.available())!= 0){
	                 	 int c = bin.read();  //从输入流中读一个字节
	                 	 bout.write((char)c);  //将字节（字符）写到输出流中     
	                  }
	                  System.out.print("+"+selectRes.getRow());
	                  bout.close();
	                  pout.close();
	                  bin.close();
	                  
	            }
	            selectRes.close();
	            System.out.println();
	        } catch (Exception  e) {
	            System.out.print("MYSQL ERROR:" + e.getMessage());
	            
	        }finally{
	        	try {
	        		 System.out.println("==================downloadEEND=========");
					stmt.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	}

}
