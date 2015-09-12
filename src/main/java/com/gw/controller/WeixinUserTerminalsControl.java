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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

import com.gw.listener.Weixin;
import com.gw.model.Jqpage;
import com.gw.model.Terminals;
import com.gw.model.WeixinUserTerminals;
import com.gw.services.WeixinUserTerminalsSer;

@Controller
public class WeixinUserTerminalsControl {
	
@Autowired
private WeixinUserTerminalsSer hquserTerminalsSer;
private Logger logger=LoggerFactory.getLogger(WeixinUserTerminalsControl.class);
	  @RequestMapping ("hquserTerminalsByPage") 
	  @ResponseBody
	  public Map<String, Object> articleByPage( @ModelAttribute("jqpage") Jqpage jqpage,@RequestParam("type") String type) {  
		  
		  Map<String, Object> arts=hquserTerminalsSer.findByPage(jqpage,type);
		  return arts;  
	  }
//	  @RequestMapping(value = { "/advanced/bars", "/advanced/foos" })
	  @RequestMapping (value = { "hquserTerminalsByOpenid","device/device/hquserTerminalsByOpenid","weixin/hquserTerminalsByOpenid"}) 
	  @ResponseBody
	public Map<String, List<WeixinUserTerminals>> hquserTerminalsByOpenid(@RequestParam("openid")String openid) {
		// TODO Auto-generated method stub
		  List<WeixinUserTerminals> hquserTerminals=hquserTerminalsSer.findByOpenId(openid);
		  Map<String, List<WeixinUserTerminals>> map=new HashMap<String, List<WeixinUserTerminals>>();
		  map.put("entity", hquserTerminals);
		return map;
	}  
	  @RequestMapping (value = { "updateHquserTerminals","weixin/updateHquserTerminals"}) 
	  @ResponseBody
	public String updateHquserTerminals(@RequestParam("openid")String openid,@RequestParam("tname")String tname,@RequestParam("nickName")String nickName,@RequestParam("intervalTime")int intervalTime) {
		// TODO Auto-generated method stub
		  WeixinUserTerminals hquserTerminals=hquserTerminalsSer.findByOpenIdAndTname(openid,tname);
		  hquserTerminals.setNickName(nickName);
		  hquserTerminals.setIntervalSeconds(intervalTime);
		  hquserTerminalsSer.saveOrUpdate(hquserTerminals);
		  sendUpdateMsg(hquserTerminals);
		return "success";
	}
	  

	  
	private void sendUpdateMsg(WeixinUserTerminals hquserTerminals) {
		// TODO Auto-generated method stub
		SendToWeixin sendToWeixin=new SendToWeixin( hquserTerminals,"update");
//		sendToWeixin(sendTemplateMessage(hquserTerminals));
	}  


}
