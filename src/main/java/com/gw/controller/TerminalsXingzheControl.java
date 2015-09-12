package com.gw.controller;

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
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import com.gw.controller.websocket.WebSocketHqdgps;
import com.gw.controller.websocket.WebsocketEndPoint;
import com.gw.listener.StaticProperty;
import com.gw.listener.Weixin;
import com.gw.model.Terminals;
import com.gw.model.TerminalsXingzhe;
import com.gw.model.WeixinUserTerminals;
import com.gw.services.WeixinUserTerminalsSer;
import com.gw.services.TerminalsXingzheSer;

@Controller
public class TerminalsXingzheControl {
@Autowired
private TerminalsXingzheSer terminalsXingzheSer;

@Autowired
private WeixinUserTerminalsSer hquserTerminalsSer;
private Logger logger=LoggerFactory.getLogger(TerminalsXingzheControl.class);

/**
 * 接收行者的信息
 * 
 * @param t
 * @return
 */
@RequestMapping(value = { "terminalsXingzhe", "weixin/terminalsXingzhe" })
@ResponseBody
public String terminalsXingzhe(@RequestBody JSONObject t) {
	TerminalsXingzhe terminals = (TerminalsXingzhe) JSONObject.toBean(t, TerminalsXingzhe.class);
	logger.info("get " + terminals.getTname());
	// terminalsSer.saveOrUpdate(terminals);
	List<WeixinUserTerminals> hquserTerminalss = hquserTerminalsSer.getLastBindByTerminalsTname(terminals);
	if (hquserTerminalss.size() > 0) {
		for (WeixinUserTerminals hquserTerminals : hquserTerminalss) {
			sendToWebSocket(terminals,hquserTerminals);//收一条发一条
			int sec = (int) (System.currentTimeMillis() / 1000);
			if (hquserTerminals.getLastTime() + hquserTerminals.getIntervalSeconds() > sec) {

				// return "<getInterval";
			} else {
				hquserTerminals.setLastTime(sec);
				hquserTerminalsSer.saveOrUpdate(hquserTerminals);
				SendToWeixin sendToWeixin=new SendToWeixin(terminals, hquserTerminals);
//				sendToWeixin(sendTemplateMessage(terminals, hquserTerminals));
			}
		}
		return "success";
	} else {
		return "nobind";
	}

}

/**
 * 发送数据到websocket
 * @param terminals
 * @param hquserTerminals
 */
	private void sendToWebSocket(TerminalsXingzhe terminals, WeixinUserTerminals hquserTerminals) {
		// TODO 数据发送到WEBSOCKET
		  
		  WebsocketEndPoint endPoint=new WebsocketEndPoint(hquserTerminals);
		  WebSocketHqdgps socketHqdgps=new WebSocketHqdgps(terminals,hquserTerminals);
		  socketHqdgps.getAttributes().get("terminal");
//		  socketHqdgps.getPrincipal().
//		  socketHqdgps.getUri().
		  Map<String,Object> map=new HashMap<String, Object>();
		  map.put("lat", terminals.getLat());
		  map.put("lng", terminals.getLng());
		  map.put("nickname", hquserTerminals.getNickName());
		  map.put("tname", terminals.getTname());
		  JSONObject object=JSONObject.fromObject(map);
		  try {
			endPoint.handleMessage(socketHqdgps, new TextMessage(object.toString()));
//			endPoint.handleMessage(socketHqdgps, new TextMessage(object.toString()),hquserTerminals);
		} catch (Exception e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	  
}
