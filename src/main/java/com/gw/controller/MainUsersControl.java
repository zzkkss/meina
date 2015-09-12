package com.gw.controller;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gw.model.JqgridPage;
import com.gw.model.MainUsers;
import com.gw.model.Shops;
import com.gw.model.ShopsHot;
import com.gw.security.MyUserDetails;
import com.gw.services.MainUsersSer;
import com.gw.services.ShopsHotSer;
import com.gw.services.ShopsSer;

@Controller
public class MainUsersControl {

	private Logger logger = LoggerFactory.getLogger(MainUsersControl.class);
	@Autowired
	private MainUsersSer mainUsersSer;
	@Autowired
	private ShopsHotSer shopsHotSer;
	@Autowired 
	private ShopsSer shopsSer;
	/**
	 * 禁用账户
	 * @param id
	 * @param tf
	 * @return
	 */
	 @RequestMapping ({"mainUsersEdit","background/mainUsersEdit"})
	 @ResponseBody
	 public String mainUsersEdit( int id,int tf) {  
		 MainUsers mu=mainUsersSer.getById(id);
		 if(tf==0){
			 mu.setEnabled(false);
			 mainUsersSer.saveOrUpdate(mu);
			Shops shops= shopsSer.getByUserId(id);
			if(shops!=null){
				ShopsHot as= shopsHotSer.getByShopsId(shops.getId());
				if(as!=null){
					shopsHotSer.delete(as);
				}
			}
			
		 }else{
			 mu.setEnabled(true);
			 mainUsersSer.saveOrUpdate(mu);
		 }
	 	  return "success";
	 }  
	 @RequestMapping ({"changePassword","background/changePassword","shop/changePassword"})
	 @ResponseBody
	 /**
	  * 修改密码
	  * @param password
	  * @param request
	  * @param response
	  * @return
	  */
	 public String changePassword( String password,HttpServletRequest request,HttpServletResponse response) {  
		 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
		 MainUsers mainUsers=mainUsersSer.getById(myUserDetails.getId());
		 mainUsers.setPassword(password);
			 int i=(Integer) mainUsersSer.saveOrUpdate(mainUsers);
				 return "success";
	 }
}
