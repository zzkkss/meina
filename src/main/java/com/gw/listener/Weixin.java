package com.gw.listener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





import net.sf.json.JSONObject;

public class Weixin extends TimerTask  {
	private Logger logger = LoggerFactory.getLogger(Weixin.class);
	public static String weixinACCESS_TOKEN = "";
	public static String weixinJSAPI_TICKET = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Weixin();
	}

	public Weixin() {
//		try {
//			String r = HttpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx34a9a4dc4501b510&secret=451c72c74ad6522e0d339c54c2ff5dd7");
//			JSONObject jsonObject = JSONObject.fromObject(r);
//			weinxiACCESS_TOKEN = jsonObject.getString("access_token");
//			logger.info("wwwwwww:" + weinxiACCESS_TOKEN);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	private String HttpGet(String url) throws Exception {
		String result = "";
		BufferedReader in = null;
		try {

			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性

			// 建立实际的连接
			connection.connect();
			// // 获取所有响应头字段
			// Map<String, List<String>> map = connection.getHeaderFields();
			// // 遍历所有的响应头字段
			// for (String key : map.keySet()) {
			// System.out.println(key + "--->" + map.get(key));
			// }
			// 定义 BufferedReader输入流来读取URL的响应
			// {"status":0,"result":{"location":{"lng":116.33573785189,"lat":39.99044903259},"formatted_address":"北京市海淀区中关村南三街8号","business":"中关村,五道口,清华大学","addressComponent":{"city":"北京市","district":"海淀区","province":"北京市","street":"中关村南三街","street_number":"8号"},"cityCode":131}}

			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
			logger.info(result);
			return result;
		} catch (Exception e) {
			logger.info("发送GET请求出现异常！" + e);
			e.printStackTrace();
			return null;
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	private String HttpPost(String u,Object object) throws Exception{
			    try {
			        //创建连接
			        URL url = new URL(u);
			        HttpURLConnection connection = (HttpURLConnection) url
			                .openConnection();
			        connection.setDoOutput(true);
			        connection.setDoInput(true);
			        connection.setRequestMethod("POST");
			        connection.setUseCaches(false);
			        connection.setInstanceFollowRedirects(true);
			        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

			        connection.connect();

			        //POST请求
//			        DataOutputStream out = new DataOutputStream(
//			                connection.getOutputStream());
			        OutputStreamWriter out = new OutputStreamWriter(  
		                    connection.getOutputStream(), "UTF-8"); // utf-8编码
			        out.write(object.toString());
			        out.flush();
			        out.close();

			        //读取响应
			        BufferedReader reader = new BufferedReader(new InputStreamReader(
			                connection.getInputStream()));
			        String lines;
			        StringBuffer sb = new StringBuffer("");
			        while ((lines = reader.readLine()) != null) {
			            lines = new String(lines.getBytes(), "utf-8");
			            sb.append(lines);
			        }
			        reader.close();
			        // 断开连接
			        connection.disconnect();
//			        System.out.println(sb);
			        return sb.toString();
			    } catch (MalformedURLException e) {
			        // TODO Auto-generated catch block
			        e.printStackTrace();
			    } catch (UnsupportedEncodingException e) {
			        // TODO Auto-generated catch block
			        e.printStackTrace();
			    } catch (IOException e) {
			        // TODO Auto-generated catch block
			        e.printStackTrace();
			    }
				return null;
			}
	public void run() {
		// TODO Auto-generated method stub
		
		AccessTokenGet();//获取微信的accessTK
		Jspai_TicktGet();//微信JS的TK
//		menuCreate();//微信创建菜单
	}
	private void menuCreate() {
		// TODO Auto-generated method stub
		try {
			
			JSONObject jsonObject = JSONObject
					.fromObject("{'button':["
//							+ "{'type':'click','name':'查看位置','key':'location','sub_button':[]},"
//							+ "{'type':'click','name':'健康记录','key':'health','sub_button':[]},"
//							+ "{'name':'设备查询','sub_button':["
//							+ "{'type':'view','name':'轨迹查询','url':'http://www.hongqitech.com','sub_button':[]},"
//							+ "{'type':'click','name':'设备查询','key':'select','sub_button':[]},"
//							+ "{'type':'scancode_waitmsg','name':'设备绑定','key':'bind','sub_button':[]},"
//							+ "{'type':'scancode_waitmsg','name':'解除绑定','key':'unbind','sub_button':[]}"
							+ "{'type':'scancode_waitmsg','name':'设备绑定','key':'bind','sub_button':[]},"
							+ "{'type':'scancode_waitmsg','name':'解除绑定','key':'unbind','sub_button':[]},"
							+ "{'type':'click','name':'设备查询','key':'select','sub_button':[]}"
							
							+ "]}");
			String r = HttpPost(
					"https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
							+ weixinACCESS_TOKEN, jsonObject);
			if(r!=null){
				logger.info("creatMenu success"+r);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void AccessTokenGet(){
		try {
			//戏梦--测试
//			String r=HttpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxd14e69fef6e96d49&secret=309ef60e8aaa1d793aedb94a77537b50");//戏梦-测试
//			String r=HttpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx7232a586536e8c22&secret=4537a42b0d45a75e23af99290e784629");//美哪
			//红旗
			String r=HttpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx34a9a4dc4501b510&secret=451c72c74ad6522e0d339c54c2ff5dd7");
			JSONObject jsonObject=JSONObject.fromObject(r);
			weixinACCESS_TOKEN=jsonObject.getString("access_token");
			logger.info("access_token:"+weixinACCESS_TOKEN);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void Jspai_TicktGet(){
		try {
			String r=HttpGet("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+weixinACCESS_TOKEN+"&type=jsapi");
//			String r=HttpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx34a9a4dc4501b510&secret=451c72c74ad6522e0d339c54c2ff5dd7");
			JSONObject jsonObject=JSONObject.fromObject(r);
			weixinJSAPI_TICKET=jsonObject.getString("ticket");
			logger.info("jsjsjsjsjsjs:"+weixinJSAPI_TICKET);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
