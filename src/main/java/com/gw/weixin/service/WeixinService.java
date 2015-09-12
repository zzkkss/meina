package com.gw.weixin.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.gw.controller.WeixinUserTerminalsControl;
import com.gw.controller.WeixinArticleControl;
import com.gw.controller.WeixinControl;
import com.gw.listener.StaticProperty;
import com.gw.model.WeixinArticle;
import com.gw.model.WeixinUserTerminals;
import com.gw.weixin.MessageUtil;
import com.gw.weixin.NewsMessage;
import com.gw.weixin.TextMessage;
import com.gw.weixin.model.Article;

/**
 * 核心服务类
 * 
 */
public class WeixinService {
	private Logger logger=LoggerFactory.getLogger(WeixinService.class);
	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public  String processRequest(HttpServletRequest request) {
		String respMessage = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";

			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方帐号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			// 公众帐号
			String toUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");

			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setFuncFlag(0);

			// 文本消息
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
				respContent = "";
				
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 图片消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
//				respContent = "您发送的是图片消息！";
				respContent = "";
				
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 地理位置消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
//				respContent = "您发送的是地理位置消息！";
				respContent = "";
				
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 链接消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
//				respContent = "您发送的是链接消息！";
				respContent = "";
				
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 音频消息
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
//				respContent = "您发送的是音频消息！";
				respContent = "";
				
				textMessage.setContent(respContent);
				respMessage = MessageUtil.textMessageToXml(textMessage);
			}
			// 事件推送
			else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				// 事件类型
				String eventType = requestMap.get("Event");
				// 订阅
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					respContent = "谢谢您的关注！";
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
					String eventkey=requestMap.get("EventKey");
					if(eventkey!=null&&eventkey.equals("bindShop")){
						//处理未版定用户扫描绑定二维码
						respContent = "绑定成功！";
						textMessage.setContent(respContent);
						respMessage = MessageUtil.textMessageToXml(textMessage);
					}
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
				}
				//已关注用户扫描二维码
				else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
			
					String eventkey=requestMap.get("EventKey");
					if(eventkey!=null&&eventkey.equals("bindShop")){
						//处理未版定用户扫描绑定二维码		
					respContent = "绑定成功！";
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
					}
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// TODO 自定义菜单权没有开放，暂不处理该类消息
					respContent = "success"+requestMap.get("FromUserName");
					String oid=requestMap.get("FromUserName");
					logger.info("success:  "+oid);
					if(requestMap.get("EventKey").equals("select")){
						System.out.println(requestMap.get("EventKey"));
						NewsMessage newsMessage=new NewsMessage();
						newsMessage.setToUserName(fromUserName);
						newsMessage.setFromUserName(toUserName);
						newsMessage.setCreateTime(new Date().getTime());
						newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
						newsMessage.setFuncFlag(0);
						newsMessage.setArticleCount(1);
						
						WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
						WeixinUserTerminalsControl hquserTerminalsControl=wac.getBean(WeixinUserTerminalsControl.class);
						WeixinArticleControl weixinArticleControl=wac.getBean(WeixinArticleControl.class);
						List<WeixinUserTerminals> hquserTerminals=(hquserTerminalsControl.hquserTerminalsByOpenid(oid)).get("entity");
						
						List<WeixinArticle> weixinArticles=weixinArticleControl.lastArticles();
//						weixinArticles.get(0).setDescription("您一共绑定有"+hquserTerminals.size()+"台设备");
//						weixinArticles.get(0).setUrl("http://www.hongqitech.com/device/device.html?oid="+oid);
						
						List<Article> articles=new ArrayList<Article>();
						Article article=new Article();
						article.setDescription("您一共绑定有"+hquserTerminals.size()+"台设备");
						article.setPicUrl(weixinArticles.get(0).getPicUrl());
						article.setTitle(weixinArticles.get(0).getTitle());
						article.setUrl("http://"+StaticProperty.Url+"/weixin/device.html?oid="+oid);
						articles.add(article);
						newsMessage.setArticles(articles);

						respMessage = MessageUtil.newsMessageToXml(newsMessage);
					}else{
						respMessage="";
					}
					
				}
				// 自定义扫描事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_SCANCODE_WAITMSG)) {
					// TODO scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框的事件推送
//					WeixinControl weixinControl=new WeixinControl();
				    WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
					WeixinControl weixinControl=wac.getBean(WeixinControl.class);
					if(requestMap.get("EventKey").equals("bind")){
						String a=weixinControl.bind(requestMap);
						respContent = a;
					}else if(requestMap.get("EventKey").equals("unbind")){
						String a=weixinControl.unbind(requestMap);
						respContent = a;
					}else{
						respContent="服务器响应出错，请稍后再试，给您带来不便，敬请谅解。";
					}
					
					textMessage.setContent(respContent);
					respMessage = MessageUtil.textMessageToXml(textMessage);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return respMessage;//回复微信信息
	}
	
	
}
