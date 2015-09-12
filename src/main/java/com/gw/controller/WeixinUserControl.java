package com.gw.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.poi.hssf.record.formula.functions.Logest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gw.model.Jqpage;
import com.gw.model.WeixinUser;
import com.gw.services.WeixinUserSer;

@Controller
public class WeixinUserControl {
@Autowired
private WeixinUserSer weixinUserSer;
private Logger logger=LoggerFactory.getLogger(WeixinUserControl.class);
	  @RequestMapping ("lastUser") 
	  @ResponseBody
	    public List<WeixinUser> articleLast(@RequestParam("num") int num ) {  
		  logger.info("lastUser"+num);
		  List<WeixinUser> arts=weixinUserSer.lastUser(num);
	           return arts;  
	    }  
	  
	  @RequestMapping (value = { "weixinUserByUnionid", "weixin/weixinUserByUnionid" }) 
	  @ResponseBody
	    public List<WeixinUser> weixinUserByUnionid(@RequestParam("unionid") String unionid ) {  
		  logger.info("weixinUserByUnionid "+unionid);
//		  List<WeixinUser> arts=weixinUserSer.getByUnionid(unionid);
//	           return arts;  
		  return null;
	    }  
	  
	  @RequestMapping (value = { "wxlogin", "weixin/wxlogin" }) 
	  @ResponseBody
//	    public String wxlogin(@RequestParam("code") String code,@RequestParam("state") String state) {  
//		  String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx3be55e7ef7346f02&secret=d743cb81ac370daa1ec67914f43dc7cf&code="+code+"&grant_type=authorization_code";
//		  try {
//			String cc=HttpGet(url);
//			JSONObject js=JSONObject.fromObject(cc);
//			return js.getString("unionid");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return "faile";
//		}
	    public ModelAndView wxlogin(@RequestParam("code") String code,@RequestParam("state") String state) {  
		  String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx3be55e7ef7346f02&secret=d743cb81ac370daa1ec67914f43dc7cf&code="+code+"&grant_type=authorization_code";
		  ModelAndView model = new ModelAndView();
		  try {
			String cc=HttpGet(url);
			JSONObject js=JSONObject.fromObject(cc);
//			return js.getString("unionid");
			model.addObject("uid", js.getString("unionid"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			return "faile";
		}
		  
		  model.setViewName("background/login");
		  return model;
		  

//		  {"access_token":"OezXcEiiBSKSxW0eoylIeLxzBjGcpWntAPivf3bMPQJEWoY3orb4Q6e7uO1otN715JztC2MyHh4HFqO29AlMq7V959nfEI2BRKFKeMoRjJBptIh2LvT-W3MH3dkZjFoJeFjp6-zs8X1Zat8nmu_qIg"
//			  ,"expires_in":7200,"refresh_token":"OezXcEiiBSKSxW0eoylIeLxzBjGcpWntAPivf3bMPQJEWoY3orb4Q6e7uO1otN71Dism9BlwgwMrlK_pLdJdFlP7FVBa_Ac2E1Sx3Xw4c3Lm-48ofgTLsXoqK6ns-74seGJfVqxBx-LQ9NpBn9P6ZQ"
//			  ,"openid":"oxIQVs3q2gq3zgvCvgZ8Kg2jCvZU","scope":"snsapi_login","unionid":"ogtXbs3owXwO2UH80bfwQqu8dHYc"
//			  }
//https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx3be55e7ef7346f02&secret=d743cb81ac370daa1ec67914f43dc7cf&code=011f1cf8d7fd6795c3b9c0a34829153q&grant_type=authorization_code

	    }  
	  @RequestMapping ("articleByPage") 
	  @ResponseBody
	  public Map<String, Object> articleByPage( @ModelAttribute("jqpage") Jqpage jqpage,@RequestParam("type") String type) {  
		  
		  Map<String, Object> arts=weixinUserSer.findByPage(jqpage,type);
		  return arts;  
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
				System.out.println(result);
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
