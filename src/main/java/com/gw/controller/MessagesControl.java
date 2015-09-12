package com.gw.controller;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.gw.model.Citylist;
import com.gw.model.CollectCoupons;
import com.gw.model.CollectShops;
import com.gw.model.Customers;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainUsers;
import com.gw.model.Messages;
import com.gw.model.Orders;
import com.gw.model.Products;
import com.gw.model.Shops;
import com.gw.model.ShopsHot;
import com.gw.model.WeixinUserTerminals;
import com.gw.security.LoginInfo;
import com.gw.security.MyProvider;
import com.gw.security.MyUserDetails;
import com.gw.services.CitylistSer;
import com.gw.services.CollectShopsSer;
import com.gw.services.MainUsersSer;
import com.gw.services.MessagesSer;
import com.gw.services.ShopsHotSer;
import com.gw.services.ShopsSer;
import com.gw.services.WeixinUserTerminalsSer;

@Controller
public class MessagesControl {

	private Logger logger = LoggerFactory.getLogger(MessagesControl.class);
	@Autowired
	private ShopsSer shopsSer;
	@Autowired
	private MainUsersSer mainUsersSer;
	@Autowired
	private CitylistSer citylistSer;
	@Autowired
	private CollectShopsSer collectShopsSer;
	@Autowired
	private MessagesSer	messagesSer;
	
	 @RequestMapping ({"messagesByJqpage","background/messagesByJqpage","android/messagesByJqpage"}) 
	  @ResponseBody
	    public Map<String, Object> messagesByJqpage(@ModelAttribute("jqpage")Jqpage jqpage ) {  
				 
		  Map<String, Object> arts=messagesSer.findByPage(jqpage);
	           return arts;  
	    }  	
	 @RequestMapping ({"messagesByJqgrid","background/messagesByJqgrid","android/messagesByJqgrid"}) 
	@ResponseBody
	public Map<String, Object> productsByJqgrid( @ModelAttribute("jqpage") JqgridPage jqgridPage) {  
		
		Map<String, Object> arts=messagesSer.findByJqgrid(jqgridPage);
		return arts;  
	}  
	 @RequestMapping ({"messagesEditByJqgrid","background/messagesEditByJqgrid","android/messagesEditByJqgrid"})
	 @ResponseBody
	 public String messagesEditByJqgrid( @ModelAttribute("jqgridPage") JqgridPage jqgridPage,@ModelAttribute("messages") Messages messages) {  
	 	  if(messages.getId()==0){
//	 		  article.setId();
	 		  jqgridPage.setOper("add");
	 		//  products.setEvaluate(5);
	 	  }else{
	 	//	  Products products2=messagesSer.getById(products.getId());
	 	//	 products.setEvaluate(products2.getEvaluate());
	 	  }
//	 	 products.setAddtime(new Timestamp(System.currentTimeMillis())); 
	 			 Serializable i= messagesSer.edit(messages, jqgridPage);
	 	  return "success";
	 }  
	 @RequestMapping({"messagesById","background/messagesById","android/messagesById"}) 
	 @ResponseBody
	 public Messages messagesById(@RequestParam("id") int id) {  
		 Messages arts=messagesSer.getById(id);
//	 				  for(int i=0;i<arts.size();i++){
//	 					  arts.get(i).setData(null);
//	 				  }
	 	return arts;
	 }
}
