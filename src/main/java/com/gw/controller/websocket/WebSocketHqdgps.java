package com.gw.controller.websocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketExtension;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.gw.model.Terminals;
import com.gw.model.TerminalsXingzhe;
import com.gw.model.WeixinUserTerminals;

public class WebSocketHqdgps implements WebSocketSession{
private Map<String, Object> m=new HashMap<String, Object>();
/**
 * 构造大宝的结构体
 * @param terminals
 * @param hquserTerminals
 */
	public WebSocketHqdgps(Terminals terminals, WeixinUserTerminals hquserTerminals) {
		// TODO Auto-generated constructor stub
		m.put("Tname", terminals.getTname());
		m.put("terminal",terminals);
		m.put("Uoid", hquserTerminals.getOpenid());
		
	}
/**
 * 构造行者的构造体
 * @param terminals
 * @param hquserTerminals
 */
	public WebSocketHqdgps(TerminalsXingzhe terminals, WeixinUserTerminals hquserTerminals) {
		// TODO Auto-generated constructor stub
		m.put("Tname", terminals.getTname());
		m.put("terminal",terminals);
		m.put("Uoid", hquserTerminals.getOpenid());
	}

	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void close(CloseStatus arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public String getAcceptedProtocol() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return m;
	}

	public int getBinaryMessageSizeLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<WebSocketExtension> getExtensions() {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpHeaders getHandshakeHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public InetSocketAddress getLocalAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	public Principal getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}

	public InetSocketAddress getRemoteAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getTextMessageSizeLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public URI getUri() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	public void sendMessage(WebSocketMessage<?> arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}

	public void setBinaryMessageSizeLimit(int arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setTextMessageSizeLimit(int arg0) {
		// TODO Auto-generated method stub
		
	}

}
