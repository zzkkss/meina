package com.gw.listener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.gw.model.WeixinUser;
import com.gw.services.WeixinUserSer;
@Component
public class InitData implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	private WeixinUserSer hquserSer;
	private Logger logger=LoggerFactory.getLogger(InitData.class);
	public void onApplicationEvent(ContextRefreshedEvent evt) {
		// TODO Auto-generated method stub
		 if (evt.getApplicationContext().getParent() == null) {
//			 List<Hquser> arts=articleSer.lastUser(2);
//			 System.out.println(arts.get(0).getNickname());
//			 System.out.println(evt.getApplicationContext().getParent());
//			 OpenidGet();//微信获取
	        }
	}
	private void OpenidGet(){
		try {
			String r=HttpGet("https://api.weixin.qq.com/cgi-bin/user/get?access_token="+Weixin.weixinACCESS_TOKEN+"&next_openid=");
			JSONObject jsonObject=JSONObject.fromObject(r);
			JSONArray jsonArray=jsonObject.getJSONObject("data").getJSONArray("openid");
			for(int i=0;i<jsonArray.size();i++){
				UserGet(jsonArray.getString(i));
			logger.info("openid "+jsonArray.getString(i));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void UserGet(String openid){
//		Hquser hquser=new Hquser();
//		hquser.setOpenid(jsonArray.getString(i));
//		hquserSer.saveOrUpdate(hquser);
		try {
			//https://api.weixin.qq.com/cgi-bin/user/info?access_token=rbuFpPASNR661nsd7vGGlYZk4BpWnqkjSj5pmJ7kVSHYJFFiDexhW-UJEZfJtFGr4_XyN03YhP4JP4an6KAeSvQ271mX6EI6QddfOueRioc
			//&openid=ow-VquPbc-BDmlqzNkjIqaxGP123
			String r=HttpGet("https://api.weixin.qq.com/cgi-bin/user/info?access_token="+Weixin.weixinACCESS_TOKEN+"&openid="+openid);
			
			JSONObject jsonObject=JSONObject.fromObject(r);
			
				WeixinUser hquser=new WeixinUser();
				hquser.setSubscribe(jsonObject.getString("subscribe"));
				hquser.setOpenid(jsonObject.getString("openid"));
				hquser.setCity(jsonObject.getString("city"));
				hquser.setCountry(jsonObject.getString("country"));
				hquser.setHeadimgurl(jsonObject.getString("headimgurl"));
				hquser.setLanguage(jsonObject.getString("language"));
				hquser.setNickname(jsonObject.getString("nickname").getBytes("UTF-8"));
//				System.out.println(jsonObject.get("nickname"));
				hquser.setProvince(jsonObject.getString("province"));
				hquser.setSex(jsonObject.getString("sex"));
				hquser.setSubscribeTime(jsonObject.getString("subscribe_time"));
//				{"subscribe":1,"openid":"ow-VquOX4ewGpvAuzTIoc5hCA7pQ","nickname":"某大明","sex":2,"language":"zh_CN","city":"厦门","province":"福建","country":"中国","headimgurl":"http:\/\/wx.qlogo.cn\/mmopen\/PiajxSqBRaEJIcmib8RbeynH9UibBjfMZRuZbb6Rv7vB7icMxXibn4ekEfQumVn4raOzMr7jVSG8HH3tqw6EyiawM0iaQ\/0","subscribe_time":1421759133,"remark":""}
//
				try {
					hquser.setUnionid(jsonObject.getString("unionid"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				hquserSer.saveOrUpdate(hquser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
}
