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
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gw.listener.StaticProperty;
import com.gw.listener.Weixin;
import com.gw.model.Terminals;
import com.gw.model.TerminalsXingzhe;
import com.gw.model.WeixinUserTerminals;
import com.gw.services.WeixinUserTerminalsSer;
import com.gw.services.TerminalsSer;
import com.gw.services.TerminalsXingzheSer;
import com.gw.tools.WeixinUtils;

@Controller
public class WeixinControl {
	private Logger logger = LoggerFactory.getLogger(WeixinControl.class);
	@Autowired
	private WeixinUserTerminalsSer hquserTerminalsSer;
	@Autowired
	private TerminalsSer terminalsSer;
	@Autowired
	private TerminalsXingzheSer terminalsXingzheSer;

	@RequestMapping("weixin")
	@ResponseBody
	public String weixin(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp, @RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr) {
		System.out.println("signature");
		System.out.println("nonce");
		System.out.println("timestamp");
		System.out.println("echostr");
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (WeixinUtils.checkSignature(signature, timestamp, nonce)) {
			return echostr;
		}

		return "false";
	}


	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("bind")
	public String bind(@RequestParam("bind") Map<String, String> bind) {
		logger.info("bind " + bind.get("FromUserName") + " " + bind.get("ScanResult"));
		String tn = bind.get("ScanResult");

		if (terminalsSer.getByTname(tn).size() > 0 || terminalsXingzheSer.getByTname(tn).size() > 0) {
			WeixinUserTerminals hquserTerminals = new WeixinUserTerminals();
			hquserTerminals = hquserTerminalsSer.findByOpenIdAndTname(bind.get("FromUserName"), bind.get("ScanResult"));
			Serializable a = null;
			if (hquserTerminals != null) {
				hquserTerminals.setBind("1");
				a = hquserTerminalsSer.saveOrUpdate(hquserTerminals);
			} else {
				hquserTerminals = new WeixinUserTerminals();
				hquserTerminals.setTname(bind.get("ScanResult"));
				hquserTerminals.setOpenid(bind.get("FromUserName"));

				// hquserTerminals.setNickName("新设备");
				hquserTerminals.setNickName(bind.get("ScanResult").toString().substring(0,12));

				hquserTerminals.setBind("1");
				hquserTerminals.setIntervalSeconds(100);
				hquserTerminals.setLastTime(0);
				hquserTerminals.setCreateTime(Integer.parseInt(bind.get("CreateTime")));
				a = hquserTerminalsSer.save(hquserTerminals);
			}

			if (a != null) {
				SendToWeixin sendToWeixin=new SendToWeixin( hquserTerminals);
//				sendToWinxinBind(hquserTerminals);
				return "绑定成功";
			} else {
				return "绑定失败，请联系售后人员。";
			}
		} else {
			return "未找到该设备:"+bind.get("ScanResult");
		}

	}

	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("unbind")
	public String unbind(@RequestParam("bind") Map<String, String> bind) {
		logger.info("unbind " + bind.get("FromUserName") + " " + bind.get("ScanResult"));

		WeixinUserTerminals hquserTerminals = new WeixinUserTerminals();
		hquserTerminals = hquserTerminalsSer.findByOpenIdAndTname(bind.get("FromUserName"), bind.get("ScanResult"));
		Serializable a = null;
		if (hquserTerminals != null) {
			hquserTerminals.setBind("0");
			hquserTerminals.setCreateTime(Integer.parseInt(bind.get("CreateTime")));
			a = hquserTerminalsSer.saveOrUpdate(hquserTerminals);
		} else {

		}

		if (a != null) {
			SendToWeixin sendToWeixin=new SendToWeixin(hquserTerminals,"unbind");
//			sendToWinxinUnBind(hquserTerminals);
			return "解除绑定成功";
		} else {
			return "未找到该设备:"+bind.get("ScanResult");
		}

	}

	/**
	 * 
	 * @param oid
	 * @param tname
	 * @return
	 */
	@RequestMapping(value = { "unbind", "weixin/unbind" })
	@ResponseBody
	public String unbind(@RequestParam("oid") String oid, @RequestParam("tname") String tname) {
		logger.info("unbind " + oid + " with " + tname);

		WeixinUserTerminals hquserTerminals = new WeixinUserTerminals();
		hquserTerminals = hquserTerminalsSer.findByOpenIdAndTname(oid, tname);
		hquserTerminals.setBind("0");
		hquserTerminals.setCreateTime((int) (System.currentTimeMillis() / 1000));

		Serializable a = hquserTerminalsSer.save(hquserTerminals);
		if (a != null) {
			SendToWeixin sendToWeixin=new SendToWeixin(hquserTerminals,"unbind");
//			sendToWinxinUnBind(hquserTerminals);
			return "解除绑定成功";
		} else {
			return "falie";
		}

	}

	@RequestMapping(value = { "weixinJs", "weixin/weixinJs" })
	@ResponseBody
	public String weixinJs(@RequestParam("timestamp") String timestamp, @RequestParam("noncestr") String noncestr, @RequestParam("web") String web) {
		String wwu = "jsapi_ticket=" + Weixin.weixinJSAPI_TICKET + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url=" + web;
		logger.info("weixinJs " + wwu);
		String signature = sha1(wwu);
		logger.info("weixinJs " + signature);

		return signature;

	}

	private String sha1(String wwu) {
		// TODO Auto-generated method stub
		try {
			MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
			digest.update(wwu.getBytes());
			byte messageDigest[] = digest.digest();
			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

}