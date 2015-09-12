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

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Customers;
import com.gw.model.WeixinUserTerminals;
import com.gw.security.LoginInfo;
import com.gw.security.MyProvider;
import com.gw.security.MyUserDetails;
import com.gw.services.CustomersSer;
import com.gw.services.WeixinUserTerminalsSer;

@Controller
public class CustomersControl {

	private Logger logger = LoggerFactory.getLogger(CustomersControl.class);
	@Autowired
	private CustomersSer customersSer;

//	 @RequestMapping ({"customersList","background/customersList","meina/customersList","android/customersList"}) 
//	  @ResponseBody
//	    public Map<String, Object> customersList( @ModelAttribute("jqpage")Jqpage jqpage,int shoptype) {  
//				 
//		  Map<String, Object> arts=customersSer.findByPageAndShoptype(jqpage,shoptype);
//	           return arts;  
//	    }  
	 @RequestMapping ({"customersByJqgrid","background/customersByJqgrid"}) 
	@ResponseBody
	public Map<String, Object> customersByJqgrid( @ModelAttribute("jqgridPage") JqgridPage jqgridPage) {  
		
		Map<String, Object> arts=customersSer.findByJqgrid(jqgridPage);
		return arts;  
	}  
	 @RequestMapping ({"customersEditByJqgrid","background/customersEditByJqgrid"})
	 @ResponseBody
	 public String productEditByJqgrid( @ModelAttribute("jqgridPage") JqgridPage jqgridPage,@ModelAttribute("customers") Customers customers) {  
	 	  if(customers.getId()==0){
//	 		  article.setId();
	 		  jqgridPage.setOper("add");
	 	  }
//	 	 customers.setAddtime(new Timestamp(System.currentTimeMillis())); 
	 			 Serializable i= customersSer.edit(customers, jqgridPage);
	 	  return "success";
	 }  
	 @RequestMapping({"customersById","background/customersById"}) 
	 @ResponseBody
	 public Customers customersById(@RequestParam("id") int id) {  
		 Customers arts=customersSer.getById(id);
//	 				  for(int i=0;i<arts.size();i++){
//	 					  arts.get(i).setData(null);
//	 				  }
	 	return arts;
	 }
	 @RequestMapping({"customersByUserId","background/customersByUserId"}) 
	 @ResponseBody
	 public Customers customersByUserId(@RequestParam("userId") int userId) {  
		 Customers arts=customersSer.getByUserId(userId);
	 	return arts;
	 }
	 @RequestMapping({"customersBySession'","android/customersBySession"}) 
	 @ResponseBody
	 public Customers customersBySession(HttpServletRequest request,HttpServletResponse response) {  
		 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
		 Customers arts=customersSer.getByUserId(myUserDetails.getId());
	 	return arts;
	 }
	 @RequestMapping({"customersEditAdd","background/customersEditAdd"}) 
	 @ResponseBody
	 public String customersEditAdd(@ModelAttribute("customers") Customers customers) {  
		 Customers sp=new Customers();
		 sp=customers;
		 customersSer.update(sp);
		 return "success";
	 }
//	 @RequestMapping ({"customersListByCoordinate","background/customersListByCoordinate","meina/customersListByCoordinate","android/customersListByCoordinate"}) 
//	  @ResponseBody
//	    public List<Customers> customersListByCoordinate( String center,String leftbttom,String righttop) { 
//		 //" + bssw.lng + "," + bssw.lat + "到" + bsne.lng + "," + bsne.lat)
////		 " + bssw.lng + "," + bssw.lat + "到" + bsne.lng + "," + bsne.lat)
//				 List<Customers> list=customersSer.customersListByCoordinate(  center, leftbttom, righttop);
//	           return list;  
//	    }  
}
