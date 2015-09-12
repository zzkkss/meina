package com.gw.weixin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gw.tools.WeixinUtils;
import com.gw.weixin.service.WeixinService;

public class WeixinServlet extends HttpServlet {
	private Logger logger=LoggerFactory.getLogger(WeixinServlet.class);
	public void init() throws ServletException {
		System.out.println("我是init()方法！用来进行初始化工作");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   // 微信加密签名    p9jgSdqBgQ6sAXyGLo84tiSt9DJeRNa5U4kk6w3RSqI
//		new_msg=
//				<xml>
//					<ToUserName><![CDATA[toUser]]></ToUserName>
//					<FromUserName><![CDATA[fromUser]]></FromUserName> 
//					<CreateTime>1348831860</CreateTime>
//					<MsgType><![CDATA[text]]></MsgType>
//					<Content><![CDATA[this is a test]]></Content>
//					<MsgId>1234567890123456</MsgId>
//					<Encrypt><![CDATA[msg_encrypt]]</Encrypt>
//				</xml>
		
		
        String signature = request.getParameter("signature");  
        // 时间戳  
        String timestamp = request.getParameter("timestamp");  
        // 随机数  
        String nonce = request.getParameter("nonce");  
        // 随机字符串  
        String echostr = request.getParameter("echostr");  
  
        PrintWriter out = response.getWriter();  
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
        if (WeixinUtils.checkSignature(signature, timestamp, nonce)) {  
            out.print(echostr);  
            logger.info("get收到请求，来自微信");
        }  
        out.close();  
        out = null;  
        
        
	}

	   /** 
     * 处理微信服务器发来的消息 
     */  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
        logger.info("post收到请求，来自微信");
        // 调用核心业务类接收消息、处理消息  
        WeixinService weixinService=new WeixinService();
        String respMessage = weixinService.processRequest(request);  
          
        // 响应消息  
        PrintWriter out = response.getWriter();  
        out.print(respMessage);  
        out.close();  
    }  

	public void destroy() {
		super.destroy();
		System.out.println("我是destroy()方法！用来进行销毁实例的工作");
	}
}