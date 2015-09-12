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
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gw.model.Citylist;
import com.gw.model.JqgridPage;
import com.gw.model.WeixinUserTerminals;
import com.gw.services.CitylistSer;
@Controller
public class CitylistControl {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CitylistSer citylistSer;
	 @RequestMapping ({"citylist","background/citylist","android/citylist"}) 
		@ResponseBody
		public List<Citylist> citylist( ) {  
			
			List<Citylist> arts=citylistSer.findAll();
			return arts;  
		}  
	 @RequestMapping ({"citylistByParentId","background/citylistByParentId","android/citylistByParentId"}) 
		@ResponseBody
		public List<Citylist> citylistByParentId( int parentId) {  
			
			List<Citylist> arts=citylistSer.findByParentId(parentId);
			return arts;  
		}  
	 @RequestMapping ({"citylistByCitycode","background/citylistByCitycode","android/citylistByCitycode"}) 
		@ResponseBody
		public Citylist citylistByCitycode( int code) {  
			
			Citylist arts=citylistSer.findByCitycode(code);
			return arts;  
		}  
	 @RequestMapping ({"citylistByName","background/citylistByName","android/citylistByName"}) 
		@ResponseBody
		public Citylist citylistByName( String name) {  
			
			Citylist arts=citylistSer.findByName(name);
			return arts;  
		}  
}
