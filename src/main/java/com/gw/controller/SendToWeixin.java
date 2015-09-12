package com.gw.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gw.listener.StaticProperty;
import com.gw.listener.Weixin;
import com.gw.model.Customers;
import com.gw.model.Products;
import com.gw.model.Terminals;
import com.gw.model.TerminalsXingzhe;
import com.gw.model.WeixinUser;
import com.gw.model.WeixinUserTerminals;

public class SendToWeixin {
	private Logger logger = LoggerFactory.getLogger(SendToWeixin.class);
/**
 * 发送收到的terminal信息
 * @param terminals
 * @param hquserTerminals
 */
	public SendToWeixin(Terminals terminals, WeixinUserTerminals hquserTerminals) {
		// TODO 发送收到的terminal信息
		sendToWeixin(sendTemplateMessage(terminals, hquserTerminals));
	}
/**
 *  发送收到的terminalXingzhe信息
 * @param terminals
 * @param hquserTerminals
 */
	public SendToWeixin(TerminalsXingzhe terminals, WeixinUserTerminals hquserTerminals) {
		// TODO 发送收到的terminalXingzhe信息
		sendToWeixin(sendTemplateMessage(terminals, hquserTerminals));
	}
/**
 *  发送收到的绑定信息；
 * @param hquserTerminals
 */
	public SendToWeixin(WeixinUserTerminals hquserTerminals) {
		// TODO 发送收到的绑定信息；
		sendToWinxinBind(hquserTerminals);
	}
/**
 * 发送收到的解除绑定、修改设备信息；
 * @param hquserTerminals
 * @param string
 */
	public SendToWeixin(WeixinUserTerminals hquserTerminals, String string) {
		// TODO 发送收到的解除绑定、修改设备信息；
		if(string.equals("unbind")){
			sendToWinxinUnBind(hquserTerminals);
		}else if(string.equals("update")){
			sendToWinxinUpdate(hquserTerminals);
		}else{
			
		}
	}
public SendToWeixin(WeixinUser weixinUser, Customers customers,
		Products products) {
	// TODO Auto-generated constructor stub
}
/**
 * 调用微信连接，发送修改成成消息
 * @param hquserTerminals
 */
	private void sendToWinxinUpdate(WeixinUserTerminals hquserTerminals) {
		// TODO 调用微信连接，发送修改成成消息
		  try {
				HttpPost("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+Weixin.weixinACCESS_TOKEN,sendUpdateMessage(hquserTerminals));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


/**
 * 调用为微信连接，发送模版消息
 * @param hquserTerminals
 */
	private void sendToWinxinUnBind(WeixinUserTerminals hquserTerminals) {
		// TODO 调用为微信连接，发送模版消息
		try {
			HttpPost("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + Weixin.weixinACCESS_TOKEN, sendUnBindMessage(hquserTerminals));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/**
 * 调用为微信连接，发送模版消息
 * @param hquserTerminals
 */
	private void sendToWinxinBind(WeixinUserTerminals hquserTerminals) {
		// TODO 调用为微信连接，发送模版消息
		try {
			HttpPost("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + Weixin.weixinACCESS_TOKEN, sendBindMessage(hquserTerminals));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/**
 * 调用Http Post方法
 * @param u
 * @param json
 * @throws Exception
 */
	private void HttpPost(String u, JSONObject json) throws Exception {
		logger.info(u);
		try {
			// 创建连接
			URL url = new URL(u);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "application/json");

			connection.connect();

			// POST请求
			// DataOutputStream out = new DataOutputStream(
			// connection.getOutputStream());
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
			out.write(json.toString());
			out.flush();
			out.close();

			// 读取响应
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String lines;
			StringBuffer sb = new StringBuffer("");
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes(), "utf-8");
				sb.append(lines);
			}
			System.out.println(sb);
			reader.close();
			// 断开连接
			connection.disconnect();
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
	}
	/**
	 * 绑定成功的模版 _5mKgYrcG7prFoVrlbKknEU3q6OxSc1me2UXUxeQ5SI
	 * 
	 * @param hquserTerminals
	 * @return
	 */
	private JSONObject sendBindMessage(WeixinUserTerminals hquserTerminals) {
		Map<String, Object> jMap = new HashMap<String, Object>();
		jMap.put("touser", hquserTerminals.getOpenid());
		// jMap.put("template_id",
		// "-rYg3PVigtWE1-rI-SjHUhiF7hRzoF_G25c0S2-NbIM");//测试
		jMap.put("template_id", "_5mKgYrcG7prFoVrlbKknEU3q6OxSc1me2UXUxeQ5SI");
		jMap.put("topcolor", "#FF0000");
		// http://t.hongqitech.com/device/deviceset.html?tn=00:07:80:22:bb:22&oid=o2guttzpAKBbWibLSttk57Nt6V4E&nname=%u5C0F%u5B9D
//		http://t.hongqitech.com/device/deviceset.html?tn=39002D001947333136333331&oid=ow-VquECj9WdxIBmOyuu8HYpGuS8&nname=39002D001947
		jMap.put("url", "http://" + StaticProperty.Url + "/weixin/deviceset.html?tn=" + hquserTerminals.getTname() + "&nname=" + escape(hquserTerminals.getNickName())+"&oid="+hquserTerminals.getOpenid());
		Map<String, String> firstMap = new HashMap<String, String>();
		firstMap.put("value", hquserTerminals.getNickName());
		firstMap.put("color", "#FF0000");
		Map<String, String> keyword1Map = new HashMap<String, String>();
		keyword1Map.put("value", hquserTerminals.getNickName());
		keyword1Map.put("color", "#FF0000");

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
//		String date = df.format(new Date(Long.parseLong("1429010017000")));
		String date = df.format(new Date(Long.parseLong(hquserTerminals.getCreateTime().toString()+"000")));
		Map<String, String> keyword2Map = new HashMap<String, String>();
		keyword2Map.put("value", date.toString());
		keyword2Map.put("color", "#FF0000");

		Map<String, String> remarkMap = new HashMap<String, String>();
		remarkMap.put("value", "绑定成功，点击修改名称======>>");
		remarkMap.put("color", "#FF0000");

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("first", firstMap);
		dataMap.put("keyword1", keyword1Map);
		dataMap.put("keyword2", keyword2Map);
		dataMap.put("remark", remarkMap);

		jMap.put("data", dataMap);

		return JSONObject.fromObject(jMap);
	}

	/**
	 * 解除绑定成功的模版
	 * 
	 * @param hquserTerminals
	 * @return
	 */
	private JSONObject sendUnBindMessage(WeixinUserTerminals hquserTerminals) {
		Map<String, Object> jMap = new HashMap<String, Object>();
		jMap.put("touser", hquserTerminals.getOpenid());
		// jMap.put("template_id",
		// "-rYg3PVigtWE1-rI-SjHUhiF7hRzoF_G25c0S2-NbIM");//测试
		jMap.put("template_id", "_5mKgYrcG7prFoVrlbKknEU3q6OxSc1me2UXUxeQ5SI");
		jMap.put("topcolor", "#FF0000");
		Map<String, String> firstMap = new HashMap<String, String>();
		firstMap.put("value", hquserTerminals.getNickName());
		firstMap.put("color", "#FF0000");

		Map<String, String> keyword1Map = new HashMap<String, String>();
		keyword1Map.put("value", hquserTerminals.getNickName());
		keyword1Map.put("color", "#FF0000");

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		String date = df.format(new Date(Long.parseLong(hquserTerminals.getCreateTime().toString()+"000")));
		Map<String, String> keyword2Map = new HashMap<String, String>();
		keyword2Map.put("value", date.toString());
		keyword2Map.put("color", "#FF0000");

		Map<String, String> remarkMap = new HashMap<String, String>();
		remarkMap.put("value", "解除绑定成功");
		keyword1Map.put("color", "#FF0000");

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("first", firstMap);
		dataMap.put("keyword1", keyword1Map);
		dataMap.put("keyword2", keyword2Map);
		dataMap.put("remark", remarkMap);

		jMap.put("data", dataMap);

		return JSONObject.fromObject(jMap);
	}

	private String escape(String src) {
		int i;
		char j;
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length() * 6);
		for (i = 0; i < src.length(); i++) {
			j = src.charAt(i);
			if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j))
				tmp.append(j);
			else if (j < 256) {
				tmp.append("%");
				if (j < 16)
					tmp.append("0");
				tmp.append(Integer.toString(j, 16));
			} else {
				tmp.append("%u");
				tmp.append(Integer.toString(j, 16));
			}
		}
		return tmp.toString();
	}

	/**
	 * 发送微信模版消息--智能设备状态提醒--大宝
	 * @param terminals
	 * @param hquserTerminals
	 * @return
	 */
	private JSONObject sendTemplateMessage(Terminals terminals, WeixinUserTerminals hquserTerminals) {
		Map<String, Object> jMap = new HashMap<String, Object>();
		jMap.put("touser", hquserTerminals.getOpenid());
		// jMap.put("template_id",
		// "wvvdqZXVYbbU87_zYts2JtBhtwERyR1e7s0X1Go_Cc0");//测试用
		jMap.put("template_id", "Zl6bb5B56IEx-r-aR0obXbFTouVbk4wwEoNcABvIMcg");
		// if(url!=null){
		jMap.put("url", "http://" + StaticProperty.Url + "/weixin/baidu.html?ll=" + terminals.getLng() + "," + terminals.getLat());
		// }
		jMap.put("topcolor", "#FF0000");

		Map<String, String> firstMap = new HashMap<String, String>();
		firstMap.put("value", hquserTerminals.getNickName());
		firstMap.put("color", "#FF0000");

		Map<String, String> keyword1Map = new HashMap<String, String>();
		keyword1Map.put("value", terminals.getDeviceState().toString());
		keyword1Map.put("color", "#FF0000");

		Map<String, String> keyword2Map = new HashMap<String, String>();
		SimpleDateFormat df = new SimpleDateFormat(" HH:mm:ss");// 设置日期格式
		keyword2Map.put("value", df.format(new Date()));
		keyword2Map.put("color", "#FF0000");

		Map<String, String> remarkMap = new HashMap<String, String>();
		remarkMap.put("value", baiduAddr(terminals));
		remarkMap.put("color", "#FF0000");

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("first", firstMap);
		dataMap.put("keyword1", keyword1Map);
		dataMap.put("keyword2", keyword2Map);
		dataMap.put("remark", remarkMap);

		jMap.put("data", dataMap);

		return JSONObject.fromObject(jMap);
	}

	/**
	 * 从百度获取对应的地址
	 * 
	 * @param terminals
	 * @return
	 */
	private String baiduAddr(Terminals terminals) {
		String baiduJson;
		try {
			baiduJson = HttpGet("http://api.map.baidu.com/geocoder/v2/?ak=tHkUgRj9hHQ26hHlBf20X9jg&location=" + terminals.getLat() + "," + terminals.getLng() + "+&output=json&coordtype=wgs84ll");

			JSONObject address = JSONObject.fromObject(baiduJson).getJSONObject("result");
			if (!address.isNullObject()) {

				return address.getString("formatted_address");
			} else {
				return "暂时未找到该坐标地址，坐标为：" + terminals.getLng() + "," + terminals.getLat();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		// http://www.hongqitech.com/hongqitech/baidu.html?ll=116.3433,39.9111
	}

/**
 * 调用http get方法
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

	private void sendToWeixin(JSONObject sendTemplateMessage) {
		// TODO Auto-generated method stub
		try {
			
			HttpPost("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + Weixin.weixinACCESS_TOKEN, sendTemplateMessage);
			logger.debug("to weixin send end");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 发送模板消息-位置信息-智能设备状态提醒-行者
	 * 
	 * @param deviceId
	 * @param deviceState
	 * @param dateTime
	 * @param deviceAddr
	 * @param touser
	 * @param template_id
	 * @param url
	 * @return {"errcode":0,"errmsg":"ok","msgid":209077694}
	 */
	private JSONObject sendTemplateMessage(TerminalsXingzhe terminals, WeixinUserTerminals hquserTerminals) {
		Map<String, Object> jMap = new HashMap<String, Object>();
		jMap.put("touser", hquserTerminals.getOpenid());
		jMap.put("template_id", "Zl6bb5B56IEx-r-aR0obXbFTouVbk4wwEoNcABvIMcg");
		// jMap.put("template_id",
		// "wvvdqZXVYbbU87_zYts2JtBhtwERyR1e7s0X1Go_Cc0");//测试
		// if(url!=null){
		jMap.put("url", "http://" + StaticProperty.Url + "/weixin/baidu.html?ll=" + terminals.getLng() + "," + terminals.getLat());
		// }
		jMap.put("topcolor", "#FF0000");

		Map<String, String> firstMap = new HashMap<String, String>();
		firstMap.put("value", hquserTerminals.getNickName());
		firstMap.put("color", "#FF0000");

		Map<String, String> keyword1Map = new HashMap<String, String>();
		if (terminals.getDeviceType().equals("1")) {// 0:神行太保，1：摇一摇
			// 430031001847333137353438============>39.962143,116.317428,91.000000,     9,9,                9,99,109.589043,460,00,104d,0b16,56
//			> WW. ; G316331L                                            39.962133,116.317437,101.700000, 64,10, 095016.00,99,99,460,00,104d,0b16,99
			keyword1Map.put("value", "摇一摇，当前电量为：" + terminals.getRawData().split(",")[3].split("\\.")[0] + "%");
			keyword1Map.put("color", "#FF0000");
		} else {
			// 2D0048001547333136333331============>39.9621216,116.3174199,86.5000000,
			// 87.95223239, 0.0108627,20.4278860,0, 44.6022415
//			WW. ; G316331I39.9621233,116.3174183,87.2000000,80.3,0.0000000,-20.2757161,0,54.5793914
			keyword1Map.put("value", "第" + terminals.getStepNumber().toString() + "步，本次共计行走" + terminals.getDistance().toString() + "米。剩余电量：" + terminals.getRawData().split(",")[3].split("\\.")[0] + "%。");
			keyword1Map.put("color", "#FF0000");

		}

		Map<String, String> keyword2Map = new HashMap<String, String>();
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");// 设置日期格式
		keyword2Map.put("value", df.format(new Date()));
		keyword2Map.put("color", "#FF0000");

		Map<String, String> remarkMap = new HashMap<String, String>();
		remarkMap.put("value", baiduAddr(terminals));
		remarkMap.put("color", "#FF0000");

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("first", firstMap);
		dataMap.put("keyword1", keyword1Map);
		dataMap.put("keyword2", keyword2Map);
		dataMap.put("remark", remarkMap);

		jMap.put("data", dataMap);

		return JSONObject.fromObject(jMap);
	}
/**
 * 调用百度的地址转化
 * @param terminals
 * @return
 */
	private String baiduAddr(TerminalsXingzhe terminals) {
		String baiduJson;
		try {
			baiduJson = HttpGet("http://api.map.baidu.com/geocoder/v2/?ak=tHkUgRj9hHQ26hHlBf20X9jg&location=" + terminals.getLat() + "," + terminals.getLng() + "+&output=json&coordtype=wgs84ll");

			JSONObject address = JSONObject.fromObject(baiduJson).getJSONObject("result");
			if (!address.isNullObject()) {

				return address.getString("formatted_address");
			} else {
				return "暂时未找到该坐标地址，坐标为：" + terminals.getLng() + "," + terminals.getLat();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		// http://www.hongqitech.com/hongqitech/baidu.html?ll=116.3433,39.9111
	}
	/** 修改成功的模版 7D5e-sh-Wg2SVFGRo4D7gS-jNUCWan1CF3xf5AtxC2w
	 * @param hquserTerminals
	 * @return
	 */
	  private  JSONObject sendUpdateMessage( WeixinUserTerminals hquserTerminals){
	  	Map<String, Object> jMap = new HashMap<String, Object>();
	  	jMap.put("touser", hquserTerminals.getOpenid());
//	  	jMap.put("template_id", "qdd1jO8-UOyqGgg5Et6vj_Miix4AUv5J06Cs4M1PWlo");//测试账号对应
	  	jMap.put("template_id", "7D5e-sh-Wg2SVFGRo4D7gS-jNUCWan1CF3xf5AtxC2w");
	  	jMap.put("topcolor", "#FF0000");
	  	Map<String, String> firstMap = new HashMap<String, String>();
	  	firstMap.put("value", hquserTerminals.getNickName());
	  	firstMap.put("color", "#FF0000");
	  	
//	  	Map<String, String> keyword1Map = new HashMap<String, String>();
//	  	keyword1Map.put("value", terminals.getDeviceState().toString());
//	  	keyword1Map.put("color", "#CCCCCC");
	  	
	  	Map<String, String> keyword2Map = new HashMap<String, String>();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//	  	keyword2Map.put("value", new Date().toString());
	  	keyword2Map.put("value", "当前推送间隔"+hquserTerminals.getIntervalSeconds().toString()+"秒");
	  	keyword2Map.put("color", "#FF0000");
	  	
//	  	Map<String, String> remarkMap = new HashMap<String, String>();
//	  	remarkMap.put("value", baiduAddr(terminals));
//	  	keyword1Map.put("color", "#173177");
	  	
	  	Map<String, Object> dataMap = new HashMap<String, Object>();
	  	dataMap.put("first", firstMap);
//	  	dataMap.put("keyword1", keyword1Map);
	  	dataMap.put("keyword2", keyword2Map);
//	  	dataMap.put("remark", remarkMap);
	  	
	  	jMap.put("data", dataMap);
	  	
	  	return JSONObject.fromObject(jMap);
	  }
	  
}
