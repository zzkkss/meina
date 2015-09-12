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
import com.gw.model.Products;
import com.gw.model.Shops;
import com.gw.model.WeixinUserTerminals;
import com.gw.security.LoginInfo;
import com.gw.security.MyProvider;
import com.gw.security.MyUserDetails;
import com.gw.services.ProductsSer;
import com.gw.services.ShopsSer;
import com.gw.services.WeixinUserTerminalsSer;

@Controller
public class ProductsControl {

	private Logger logger = LoggerFactory.getLogger(ProductsControl.class);
	@Autowired
	private ProductsSer productsSer;
@Autowired
private ShopsSer shopsSer;
	 @RequestMapping ({"productsList","background/productsList","android/productsList"}) 
	  @ResponseBody
	    public Map<String, Object> productsList(@ModelAttribute("jqpage")Jqpage jqpage ) {  
				 
		  Map<String, Object> arts=productsSer.findByPage(jqpage);
	           return arts;  
	    }  
	 @RequestMapping ({"productsListByShopid","background/productsListByShopid","android/productsListByShopid"}) 
	  @ResponseBody
	    public Map<String, Object> productsListByShopid(@ModelAttribute("jqpage")Jqpage jqpage,int shopid ) {  
				 
		  Map<String, Object> arts=productsSer.findByPageAndShopid(jqpage,shopid);
	           return arts;  
	    }  
	/* @RequestMapping ({"productsById","background/productsById","meina/productsById","android/productsById"}) 
	  @ResponseBody
	    public Products productsById(@ModelAttribute("productId")String productId ) {  
				 
		  Products arts=productsSer.getById(Integer.parseInt(productId));
	           return arts;  
	    }  */
	 @RequestMapping ({"productsByJqgrid","background/productsByJqgrid","android/productsByJqgrid"}) 
	@ResponseBody
	public Map<String, Object> productsByJqgrid( @ModelAttribute("jqpage") JqgridPage jqgridPage) {  
		
		Map<String, Object> arts=productsSer.findByJqgrid(jqgridPage);
		return arts;  
	}  
	 @RequestMapping ({"productsByJqgridAndShopid","shop/productsByJqgridAndShopid","android/productsByJqgridAndShopid"}) 
	@ResponseBody
	public Map<String, Object> productsByJqgridAndShopid( @ModelAttribute("jqgridPage") JqgridPage jqgridPage,HttpServletRequest request,HttpServletResponse response) {  
		 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
		 Shops shops=shopsSer.getByUserId(myUserDetails.getId());
		Map<String, Object> arts=productsSer.findByJqgridAndShopid(jqgridPage,shops.getId());
		return arts;  
	}  
	 @RequestMapping ({"productsEditByJqgridAndShopid","background/productsEditByJqgridAndShopid","shop/productsEditByJqgridAndShopid","android/productsEditByJqgridAndShopid"})
	 @ResponseBody
	 public String productEditByJqgrid( @ModelAttribute("jqgridPage") JqgridPage jqgridPage,@ModelAttribute("products") Products products,HttpServletRequest request,HttpServletResponse response) {  
		 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
		 Shops shops=shopsSer.getByUserId(myUserDetails.getId());
		 products.setShopsId(shops.getId());
	 	  if(products.getId()==0){
//	 		  article.setId();
	 		  jqgridPage.setOper("add");
	 		  products.setEvaluate(5);
	 	  }else{
	 		  Products products2=productsSer.getById(products.getId());
	 		 products.setEvaluate(products2.getEvaluate());
	 	  }
//	 	 products.setAddtime(new Timestamp(System.currentTimeMillis())); 
	 			 Serializable i= productsSer.edit(products, jqgridPage);
	 	  return "success";
	 }  
	 @RequestMapping ({"productsEditByJqgrid","background/productsEditByJqgrid","android/productsEditByJqgrid"})
	 @ResponseBody
	 public String productEditByJqgrid( @ModelAttribute("jqgridPage") JqgridPage jqgridPage,@ModelAttribute("products") Products products) {  
	 	  if(products.getId()==0){
//	 		  article.setId();
	 		  jqgridPage.setOper("add");
	 		  products.setEvaluate(5);
	 	  }else{
	 		  Products products2=productsSer.getById(products.getId());
	 		 products.setEvaluate(products2.getEvaluate());
	 	  }
//	 	 products.setAddtime(new Timestamp(System.currentTimeMillis())); 
	 			 Serializable i= productsSer.edit(products, jqgridPage);
	 	  return "success";
	 }  
	 @RequestMapping({"productsById","background/productsById","android/productsById","shop/productsById"}) 
	 @ResponseBody
	 public Products productsById(@RequestParam("id") int id) {  
		 Products arts=productsSer.getById(id);
//	 				  for(int i=0;i<arts.size();i++){
//	 					  arts.get(i).setData(null);
//	 				  }
	 	return arts;
	 }
}
