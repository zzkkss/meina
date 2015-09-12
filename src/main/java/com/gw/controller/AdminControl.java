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

import com.gw.model.AdminInfo;
import com.gw.model.Jqpage;
import com.gw.model.Shops;
import com.gw.model.WeixinUserTerminals;
import com.gw.security.MyUserDetails;
import com.gw.services.AdminInfoSer;
import com.gw.services.CollectCouponsSer;
@Controller
public class AdminControl {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private AdminInfoSer adminInfoSer;
		 @RequestMapping({"adminInfo","background/adminInfo","android/adminInfo"}) 
		 @ResponseBody
		 /**
		  * 返回admin信息
		  * @param request
		  * @param response
		  * @return
		  */
		 public AdminInfo shopsByUserId(HttpServletRequest request,HttpServletResponse response) {  
//		 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
//		 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
		 
		 AdminInfo adminInfo=adminInfoSer.getById(1);
		 
		 	return adminInfo;
		 }
		 @RequestMapping({"adminInfoEdit","background/adminInfoEdit"}) 
		 @ResponseBody
		 /**
		  * 返回admin信息
		  * @param shops
		  * @param request
		  * @param response
		  * @return
		  */
		 public String adminInfoEdit(@ModelAttribute("adminInfo") AdminInfo adminInfo,HttpServletRequest request,HttpServletResponse response) {  
			 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
			 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
			 adminInfo.setId(1);
			 adminInfoSer.update(adminInfo);
			 return "success";
		 }
}
