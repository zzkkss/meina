package com.gw.controller.websocket;
  
  
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;  
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;  
import org.springframework.web.socket.handler.TextWebSocketHandler;  

import com.gw.model.WeixinUserTerminals;
public class WebsocketEndPoint implements WebSocketHandler {
	Logger logger=LoggerFactory.getLogger(WebsocketEndPoint.class);
  private static final ArrayList<WebSocketSession> users;
  static {
      users = new ArrayList<WebSocketSession>();
  }
  private WeixinUserTerminals userTerminals=new WeixinUserTerminals();
  public WebsocketEndPoint() {
		// TODO Auto-generated constructor stub
			
	}
	public WebsocketEndPoint(WeixinUserTerminals hquserTerminals) {
	// TODO Auto-generated constructor stub
		this.userTerminals=hquserTerminals;
}

	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
      if(users.contains(session)){
    	logger.info("already in"+session.getPrincipal().getName());
    }else{
    	users.add(session);
    	logger.info("new in"+session.getPrincipal().getName());
    }
	}

	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		logger.info(message.getPayload().toString());
//       TextMessage returnMessage = new TextMessage(message.getPayload()+" received at server");  
//       session.sendMessage(returnMessage);  

              for(WebSocketSession us:users){
            	  if(us.getPrincipal().getName().equals(userTerminals.getOpenid())||us.getPrincipal().getName().equals("admin")){
            	    	try {
            				if(us.isOpen()){
            					us.sendMessage( new TextMessage(message.getPayload().toString()));
            				}
            			} catch (Exception e) {
            				// TODO: handle exception
            			}
            	  }
   
       }
	}

	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
//public class WebsocketEndPoint extends TextWebSocketHandler {  
//  private static final ArrayList<WebSocketSession> users;
//  static {
//      users = new ArrayList<WebSocketSession>();
//  }
//    @Override  
//    public void handleTextMessage(WebSocketSession session,  
//            TextMessage message) throws Exception {  
//        super.handleTextMessage(session, message);  
//        System.out.println(message.getPayload()+" received at server");
////        TextMessage returnMessage = new TextMessage(message.getPayload()+" received at server");  
//        if(users.contains(session)){
//        	
//        }else{
//        	users.add(session);
//        }
//        for(WebSocketSession us:users){
//        	try {
//				if(us.isOpen()){
//					us.sendMessage( new TextMessage(message.getPayload()+" received at server"));
//				}
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//        }
////        session.sendMessage(returnMessage);  
//    }  
//}  