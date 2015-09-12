package com.gw.security;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.gw.controller.WeixinUserTerminalsControl;
import com.gw.model.WeixinUser;
import com.gw.services.WeixinUserSer;

public class WeixinUserDetailService implements UserDetailsService{
	private Logger logger=LoggerFactory.getLogger(WeixinUserDetailService.class);
	private String mode="";
	public WeixinUserDetailService(String m){
		this.mode=m;
	}
	public UserDetails loadUserByUsername(String code) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
//		if(unionid.equals("weixin")){
//			
//		}
		ArrayList<SimpleGrantedAuthority> l = new ArrayList<SimpleGrantedAuthority>();
		l.add(new SimpleGrantedAuthority("ROLE_NONE"));
		User details = new User("username", "password", l);
		if(mode.equals("weixin")){
			 String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx3be55e7ef7346f02&secret=d743cb81ac370daa1ec67914f43dc7cf&code="+code+"&grant_type=authorization_code";
			 String unionid=null;
			  try {
				String cc=HttpGet(url);
				JSONObject js=JSONObject.fromObject(cc);
				unionid= js.getString("unionid");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
//				return "faile";
			}
			  
			logger.info(code+"    "+unionid);
			WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
			WeixinUserSer weixinUserSer=wac.getBean(WeixinUserSer.class);
			List<WeixinUser> arts=weixinUserSer.getByUnionid(unionid);
			if(arts.size()>0){
				ArrayList<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
				list.add(new SimpleGrantedAuthority("ROLE_WEIXIN"));
				String uname=arts.get(0).getOpenid();
				Map<String, Object> un=new HashMap<String, Object>();
				un.put("oid", arts.get(0).getOpenid());
				try {
					un.put("nn", new String(arts.get(0).getNickname(),"UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JSONObject jj=JSONObject.fromObject(un);
				details = new User(jj.toString(), "password", list);
			}else{
			}
			
		}else{
		}
		return details;
	}
	 /**
	   * 获取微信开放平台通过code获取access_token
	   * @param url
	   * @return
	   * @throws Exception
	   */
	  private String HttpGet(String url) throws Exception {
			String result = "";
			BufferedReader in = null;
			try {

				URL realUrl = new URL(url);
				// 打开和URL之间的连接
				URLConnection connection = realUrl.openConnection();
				// 设置通用的请求属性
				connection.setDoInput(true);
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

				in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
				String line;
				while ((line = in.readLine()) != null) {
					result += line;
				}
				logger.info(result);
				return result;
			} catch (Exception e) {
				System.out.println("发送GET请求出现异常！" + e);
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
}
