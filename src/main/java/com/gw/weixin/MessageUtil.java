package com.gw.weixin;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.gw.model.WeixinArticle;
import com.gw.weixin.model.Article;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;


public class MessageUtil {
	
	private static Logger log = Logger.getLogger(MessageUtil.class);  
	
	//公众账号接收消息---公众账号接收消息---公众账号接收消息---公众账号接收消息---公众账号接收消息---
	
	/**
	 * 接收消息类型：文本
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";
	
	/**
	 * 接收消息类型：图片
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 接收消息类型：语音
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

	/**
	 * 接收消息类型：视频
	 */
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";
	
	/**
	 * 接收消息类型：地理位置
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";
	
	/**
	 * 接收消息类型：链接消息
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";
	
	/**
	 * 接收消息类型：推送
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	
	//事件---事件---事件---事件---事件---事件---事件---事件---事件---事件---事件---事件---
	
	/**
	 * 事件类型：subscribe(订阅)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * 事件类型：unsubscribe(取消订阅)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
	
	/**
	 * 事件类型：SCAN(扫描带参数二维码)
	 */
	public static final String EVENT_TYPE_SCAN = "SCAN";
	
	/**
	 * 事件类型：LOCATION(上报地理位置)
	 */
	public static final String EVENT_TYPE_LOCATION = "LOCATION";

	/**
	 * 事件类型：CLICK(点击菜单拉取消息)
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";
	
	/**
	 * 事件类型：VIEW(点击菜单跳转链接)
	 */
	public static final String EVENT_TYPE_VIEW = "VIEW";
	/**
	 * 事件类型：scancode_push(扫码推事件的事件推送)
	 */
	public static final String EVENT_TYPE_SCANCODE_PUSH = "scancode_push";
	/**
	 * 事件类型：scancode_waitmsg(扫码推事件且弹出“消息接收中”提示框的事件推送)
	 */
	public static final String EVENT_TYPE_SCANCODE_WAITMSG = "scancode_waitmsg";
	/**
	 * 事件类型：pic_sysphoto(弹出系统拍照发图的事件推送)
	 */
	public static final String EVENT_TYPE_PIC_SYSPHOTO = "pic_sysphoto";
	/**
	 * 事件类型：pic_photo_or_album(弹出拍照或者相册发图的事件推送)
	 */
	public static final String EVENT_TYPE_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
	/**
	 * 事件类型：pic_weixin(弹出微信相册发图器的事件推送)
	 */
	public static final String EVENT_TYPE_PIC_WEIXIN= "pic_weixin";
	/**
	 * 事件类型：location_select(弹出地理位置选择器的事件推送)
	 */
	public static final String EVENT_TYPE_LOCATION_SELECT= "location_select";
	/**
	 * 事件类型：TEMPLATESENDJOBFINISH(模版消息发送完成后的事件推送)
	 */
	public static final String EVENT_TYPE_TEMPLATESENDJOBFINISH= "TEMPLATESENDJOBFINISH";
	
	//接收语音识别结果---接收语音识别结果---接收语音识别结果---接收语音识别结果---接收语音识别结果---
	
	

	//公众账号发送消息---公众账号发送消息---公众账号发送消息---公众账号发送消息---公众账号发送消息---
	
	/**
	 * 发送消息类型：文本
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 发送消息类型：图片
	 */
	public static final String RESP_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 发送消息类型：音频
	 */
	public static final String RESP_MESSAGE_TYPE_VOICE = "voice";
	
	/**
	 * 发送消息类型：视频
	 */
	public static final String RESP_MESSAGE_TYPE_VIDEO = "video";
	
	/**
	 * 发送消息类型：音乐
	 */
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";
	
	/**
	 * 发送消息类型：图文
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";

//	事件的Key---事件的Key---
//	public static final String EVENT_TYPE_KEY_
	/**
	 * 解析微信发来的请求（XML）
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
		// 将解析结果存储在HashMap中
		Map<String, String> map = new HashMap<String, String>();

		// 从request中取得输入流
		InputStream inputStream = request.getInputStream();
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		List<Element> elementList = root.elements();

		// 遍历所有子节点
		for (Element e : elementList){
			if("ScanCodeInfo".equals(e.getName())){
				List<Element> sciEles = e.elements();
				for(Element sciEle : sciEles){
					map.put(sciEle.getName(), sciEle.getText());
				}
			} 
			else if("SendPicsInfo".equals(e.getName())){
				List<Element> spiEles = e.elements();
				for(Element spiEle : spiEles){
					if("PicList".equals(spiEle.getName())){
						List<Element> plEles = spiEle.elements();
						String[] PicMd5Sums = new String[]{};
						int i = 0;
						for(Element plEle : plEles){
							Element PicMd5Sum = plEle.element("PicMd5Sum");
//							System.out.println(PicMd5Sum.getName() + "---" + PicMd5Sum.getText());
							PicMd5Sums[i] = PicMd5Sum.getText();
							i++;
						}
						//TODO 2014年12月19日18:04:55 
//						map.put("PicMd5Sum", PicMd5Sums);
					} else {
						map.put(spiEle.getName(), spiEle.getText());
					}
				}
			}
			else if("SendLocationInfo".equals(e.getName())){
				List<Element> sliEles = e.elements();
				for(Element sliEle : sliEles){
					map.put(sliEle.getName(), sliEle.getText());
				}
			}
			else {
				map.put(e.getName(), e.getText());
			}
		}
		// 释放资源
		inputStream.close();
		inputStream = null;

		return map;
	}

	/**
	 * 文本消息对象转换成xml
	 * 
	 * @param textMessage 文本消息对象
	 * @return xml
	 */
	public static String textMessageToXml(TextMessage textMessage) {
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}

//	/**
//	 * 音乐消息对象转换成xml
//	 * 
//	 * @param musicMessage 音乐消息对象
//	 * @return xml
//	 */
//	public static String musicMessageToXml(MusicMessage musicMessage) {
//		xstream.alias("xml", musicMessage.getClass());
//		return xstream.toXML(musicMessage);
//	}

	/**
	 * 图文消息对象转换成xml
	 * 
	 * @param newsMessage 图文消息对象
	 * @return xml
	 */
	public static String newsMessageToXml(NewsMessage newsMessage) {
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsMessage);
	}

	/**
	 * 扩展xstream，使其支持CDATA块
	 * 
	 * @date 2013-05-19
	 */
	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				@SuppressWarnings("unchecked")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});

}
