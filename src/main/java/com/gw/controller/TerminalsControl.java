package com.gw.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.Principal;
import java.sql.Timestamp;
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
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketExtension;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.gw.controller.websocket.WebSocketHqdgps;
import com.gw.controller.websocket.WebsocketEndPoint;
import com.gw.listener.StaticProperty;
import com.gw.listener.Weixin;
import com.gw.model.JqgridPage;
import com.gw.model.Terminals;
import com.gw.model.Jqpage;
import com.gw.model.WeixinUserTerminals;
import com.gw.services.WeixinUserTerminalsSer;
import com.gw.services.TerminalsSer;
import com.gw.tools.WeixinUtils;

@Controller
public class TerminalsControl {
@Autowired
private TerminalsSer terminalsSer;
@Autowired
private WeixinUserTerminalsSer hquserTerminalsSer;
private Logger logger=LoggerFactory.getLogger(TerminalsControl.class);
	  @RequestMapping (value = { "terminalsByPage", "background/terminalsByPage" }) 
	  @ResponseBody
	  public Map<String, Object> terminalsByPage( @ModelAttribute("jqpage") JqgridPage jqpage,@RequestParam("type") String type) {  
		  
		  Map<String, Object> arts=terminalsSer.findByJqgrid(jqpage);
		  return arts;  
	  }  
	  @RequestMapping ("terminalsByOpenid") 
	  @ResponseBody
	  public String terminalsByOpenid( @RequestParam("openid") String openid) {  
		  return "aaaa";  
	  }  
	
	  @RequestMapping ({"terminalEditByJqgrid","background/terminalEditByJqgrid"}) 
	  @ResponseBody
	  public String terminalEditByJqgrid( @ModelAttribute("jqpage") JqgridPage jqgridPage,@ModelAttribute("terminal") Terminals terminal) {  
		  if(terminal.getId()==0){
//			  article.setId();
			  jqgridPage.setOper("add");
		  }
				 Serializable i= terminalsSer.edit(terminal, jqgridPage);
		  return "success";
	  }  

		/**
		 * 处理大宝发来的位置信息
		 * 
		 * @param t
		 * @return
		 */
		@RequestMapping(value = { "terminals", "weixin/terminals" })
		@ResponseBody
		public String terminals(@RequestBody JSONObject t) {
			Terminals terminals = (Terminals) JSONObject.toBean(t, Terminals.class);
			logger.info("get " + terminals.getTname());
			// terminalsSer.saveOrUpdate(terminals);
			List<WeixinUserTerminals> hquserTerminalss = hquserTerminalsSer.getLastBindByTerminalsTname(terminals);
			if (hquserTerminalss.size() > 0) {
				for (WeixinUserTerminals hquserTerminals : hquserTerminalss) {
//					WeixinUserTerminals hquserTerminals = hquserTerminalss.get(0);
					sendToWebSocket(terminals,hquserTerminals);//收一条发一条
					int sec = (int) (System.currentTimeMillis() / 1000);
					if (hquserTerminals.getLastTime() + hquserTerminals.getIntervalSeconds() > sec) {

//						return "<getInterval";
					} else {
						hquserTerminals.setLastTime(sec);
						hquserTerminalsSer.saveOrUpdate(hquserTerminals);
						SendToWeixin sendToWeixin=new SendToWeixin(terminals, hquserTerminals);
						
//						sendToWeixin(sendTemplateMessage(terminals, hquserTerminals));
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
		private void sendToWebSocket(Terminals terminals, WeixinUserTerminals hquserTerminals) {
			// TODO 数据发送到WEBSOCKET
			  
			  WebsocketEndPoint endPoint=new WebsocketEndPoint(hquserTerminals);
			  WebSocketHqdgps socketHqdgps=new WebSocketHqdgps(terminals,hquserTerminals);
			  socketHqdgps.getAttributes().get("terminal");
//			  socketHqdgps.getPrincipal().
//			  socketHqdgps.getUri().
			  Map<String,Object> map=new HashMap<String, Object>();
			  map.put("lat", terminals.getLat());
			  map.put("lng", terminals.getLng());
			  map.put("nickname", hquserTerminals.getNickName());
			  map.put("tname", terminals.getTname());
			  JSONObject object=JSONObject.fromObject(map);
			  try {
				endPoint.handleMessage(socketHqdgps, new TextMessage(object.toString()));
//				endPoint.handleMessage(socketHqdgps, new TextMessage(object.toString()),hquserTerminals);
			} catch (Exception e) {
				 //TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
