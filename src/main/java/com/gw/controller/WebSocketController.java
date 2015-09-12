package com.gw.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gw.model.WeixinUserTerminals;
import com.gw.services.WeixinUserTerminalsSer;

@Controller
public class WebSocketController {
	private Logger logger = LoggerFactory.getLogger(WebSocketController.class);
	@Autowired
	private WeixinUserTerminalsSer hquserTerminalsSer;
///**
// * Map
// * @param request
// * @param response
// * @return
// */
//	@RequestMapping(value = { "/map", "/map/map" }, method = RequestMethod.GET)
//	public ModelAndView map(HttpServletRequest request, HttpServletResponse response) {
//		
//		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
//		ModelAndView model = new ModelAndView();
//		if(securityContextImpl!=null){
//			logger.info("Username:" + securityContextImpl.getAuthentication().getName()); 
//			
//			model.addObject(securityContextImpl.getAuthentication());
//			
//			  List<WeixinUserTerminals> hquserTerminals=hquserTerminalsSer.findByOpenId( securityContextImpl.getAuthentication().getName());
//Map<String, Object> map=new HashMap<String, Object>();
////String[] strings=new String[hquserTerminals.size()];
////String[] strings=new String[hquserTerminals.size()];
//
//List<Map<String, Object> > list=new ArrayList<Map<String,Object>>();
//
//			for( WeixinUserTerminals wt:hquserTerminals){
//				Map<String, Object> map2=new HashMap<String, Object>();
//				map2.put("tn",wt.getTname());
//				map2.put("nn",wt.getNickName());
//				list.add(map2);
//				
//			}
//			
//			map.put("t", list);
//			
//			model.addObject("t",JSONObject.fromObject( map));
//		}
//
//		model.setViewName("map/baidu");
//		return model;
//
//	}
//	/**
//	 * MapAdmin
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//		@RequestMapping(value = { "/mapadmin", "/map/mapadmin" }, method = RequestMethod.GET)
//		public ModelAndView mapadmin(HttpServletRequest request, HttpServletResponse response) {
//			
//			SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
//			ModelAndView model = new ModelAndView();
//			if(securityContextImpl!=null){
//				logger.info("Username:" + securityContextImpl.getAuthentication().getName()); 
//				
//				model.addObject(securityContextImpl.getAuthentication());
//				
//				  List<WeixinUserTerminals> hquserTerminals=hquserTerminalsSer.findByOpenId( securityContextImpl.getAuthentication().getName());
//	Map<String, Object> map=new HashMap<String, Object>();
//	//String[] strings=new String[hquserTerminals.size()];
//	//String[] strings=new String[hquserTerminals.size()];
//
//	List<Map<String, Object> > list=new ArrayList<Map<String,Object>>();
//
//				for( WeixinUserTerminals wt:hquserTerminals){
//					Map<String, Object> map2=new HashMap<String, Object>();
//					map2.put("tn",wt.getTname());
//					map2.put("nn",wt.getNickName());
//					list.add(map2);
//					
//				}
//				
//				map.put("t", list);
//				
//				model.addObject("t",JSONObject.fromObject( map));
//			}
//
//			model.setViewName("map/baiduAdmin");
//			return model;
//
//		}
}
