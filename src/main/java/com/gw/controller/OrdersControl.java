package com.gw.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.mapping.results.Success;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gw.model.Customers;
import com.gw.model.Evaluations;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainUsers;
import com.gw.model.Orders;
import com.gw.model.Products;
import com.gw.model.Shops;
import com.gw.model.WeixinUser;
import com.gw.model.WeixinUserTerminals;
import com.gw.security.MyUserDetails;
import com.gw.services.CustomersSer;
import com.gw.services.MainUsersSer;
import com.gw.services.OrdersSer;
import com.gw.services.ProductsSer;
import com.gw.services.ShopsSer;
import com.gw.services.WeixinUserSer;

@Controller
public class OrdersControl {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private OrdersSer ordersSer;
	@Autowired
	private MainUsersSer mainUsersSer;
	@Autowired
	private CustomersSer customersSer;
	@Autowired
	private ProductsSer productsSer;
	@Autowired
	private ShopsSer shopsSer;
	@Autowired
	private WeixinUserSer weixinUserSer;
	@RequestMapping(value = { "/orderAdd", "/android/orderAdd" })
	  @ResponseBody
	  /**
	   * android 下单
	   * @param order
	   * @return
	   */
	public String orderAdd(@ModelAttribute("order")Orders order) {
		if(order.getUsersId()==null){
			return "请先登录！";
		}
		Orders o=order;
		o.setState(1);
		o.setBuildTime(new Date());
		Products products=productsSer.getById(order.getProductId());
		o.setShopsId(products.getShopsId());
		int i=(Integer) ordersSer.save(o);
		Shops shops=shopsSer.getById(order.getShopsId());
		MainUsers mainUsers=mainUsersSer.getById(shops.getUsersId());
		if(mainUsers.getWeixinUserId()!=null){
			WeixinUser weixinUser=weixinUserSer.getById(mainUsers.getWeixinUserId());
			Customers customers=customersSer.getByUserId(mainUsers.getId());
			SendToWeixin sendToWeixin=new SendToWeixin(weixinUser, customers,products);
		} else {
		}
		if(i>1){
			
			return "success";
		}
		return "faile";
		
	}

	 @RequestMapping ({"ordersList","background/ordersList","meina/ordersList","android/ordersList"}) 
	  @ResponseBody
	    public Map<String, Object> ordersList(@ModelAttribute("jqpage")Jqpage jqpage ) {  
				 
		  Map<String, Object> arts=ordersSer.findByPage(jqpage);
	           return arts;  
	    }  
//	 @RequestMapping ({"OrdersById","background/OrdersById","meina/OrdersById","android/OrdersById"}) 
//	  @ResponseBody
//	    public Orders OrdersById(@ModelAttribute("couponId")String couponId ) {  
//				 
//		  Orders arts=ordersSer.getById(Integer.parseInt(couponId));
//	           return arts;  
//	    }  
	 @RequestMapping ({"ordersByJqgrid","background/ordersByJqgrid"}) 
	@ResponseBody
	public Map<String, Object> ordersByJqgrid( @ModelAttribute("jqpage") JqgridPage jqgridPage) {  

		 Map<String, Object> arts=ordersSer.findByJqgrid(jqgridPage);
		 Map<String, Object> res=new HashMap<String, Object>();
		 res.put("jqgridPage", arts.get("jqgridPage"));
		 
		 List<Orders> orders=(List<Orders>) arts.get("entity");
		 List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
//		 List<MainUsers> users=new ArrayList<MainUsers>();
		 for(int i=0;i<orders.size();i++){
			 MainUsers u=mainUsersSer.getById(orders.get(i).getUsersId());
			 Customers c=customersSer.getByUserId(u.getId());
			 
			 Map<String, Object> or=new HashMap<String, Object>();
			 or.put("order", orders.get(i));
			 or.put("custom", c);
			 Products products2=productsSer.getById(orders.get(i).getProductId());
			 or.put("products",products2);
			 list.add( or);
		 }
		 res.put("entity", list);
		 
		 return res;  
	}  
	 @RequestMapping ({"ordersByJqgridAndShopid","shop/ordersByJqgridAndShopid"}) 
	 @ResponseBody
	 public Map<String, Object> ordersByJqgridAndShopid( @ModelAttribute("jqgridPage") JqgridPage jqgridPage,HttpServletRequest request,HttpServletResponse response) {  
		 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
		 Shops shops=shopsSer.getByUserId(myUserDetails.getId());
		 Map<String, Object> arts=ordersSer.findByJqgridAndShopId(jqgridPage,shops.getId());
		 Map<String, Object> res=new HashMap<String, Object>();
		 res.put("jqgridPage", arts.get("jqgridPage"));
		 
		 List<Orders> orders=(List<Orders>) arts.get("entity");
		 List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
//		 List<MainUsers> users=new ArrayList<MainUsers>();
		 for(int i=0;i<orders.size();i++){
			 MainUsers u=mainUsersSer.getById(orders.get(i).getUsersId());
			 Customers c=customersSer.getByUserId(u.getId());
			 
			 Map<String, Object> or=new HashMap<String, Object>();
			 or.put("order", orders.get(i));
			 or.put("custom", c);
			 Products products2=productsSer.getById(orders.get(i).getProductId());
			 or.put("products",products2);
			 list.add( or);
		 }
		 res.put("entity", list);
		 
		 return res;  
	 }  
	 
	 @RequestMapping ({"ordersByJqgridAndUserid","background/ordersByJqgridAndUserid","android/ordersByJqgridAndUserid"}) 
	 @ResponseBody
	 public Map<String, Object> ordersByJqgridAndUserid( @ModelAttribute("jqgridPage") JqgridPage jqgridPage,int userid) {  
		 
		 Map<String, Object> arts=ordersSer.findByJqgridAndUserId(jqgridPage,userid);
		 Map<String, Object> res=new HashMap<String, Object>();
		 res.put("jqgridPage", arts.get("jqgridPage"));
		 
		 List<Orders> orders=(List<Orders>) arts.get("entity");
		 List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
//		 List<MainUsers> users=new ArrayList<MainUsers>();
		 for(int i=0;i<orders.size();i++){
			 MainUsers u=mainUsersSer.getById(orders.get(i).getUsersId());
			 Customers c=customersSer.getByUserId(u.getId());
			 
			 Map<String, Object> or=new HashMap<String, Object>();
			 or.put("order", orders.get(i));
			 or.put("custom", c);
			 Products products2=productsSer.getById(orders.get(i).getProductId());
			 or.put("products",products2);
			 list.add( or);
		 }
		 res.put("entity", list);
		 
		 return res;  
	 }  
	 
	 @RequestMapping ({"ordersByJqpageAndUserId","background/ordersByJqpageAndUserId","android/ordersByJqpageAndUserId"}) 
	 @ResponseBody
	 public Map<String, Object> ordersByJqpageAndUserid( @ModelAttribute("jqpage") Jqpage jqpage,HttpServletRequest request,HttpServletResponse response) {  
		 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
		// Shops shops=shopsSer.getByUserId(myUserDetails.getId());
		 Map<String, Object> arts=ordersSer.findByJqpageAndUserId(jqpage,myUserDetails.getId());
		 Map<String, Object> res=new HashMap<String, Object>();
		 res.put("jqpage", arts.get("jqpage"));
		 
		 List<Orders> orders=(List<Orders>) arts.get("entity");
		 List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
//		 List<MainUsers> users=new ArrayList<MainUsers>();
		 for(int i=0;i<orders.size();i++){
			 MainUsers u=mainUsersSer.getById(orders.get(i).getUsersId());
			 Customers c=customersSer.getByUserId(u.getId());
			 
			 Map<String, Object> or=new HashMap<String, Object>();
			 or.put("order", orders.get(i));
			 or.put("custom", c);
			 Products products2=productsSer.getById(orders.get(i).getProductId());
			 or.put("products",products2);
			 list.add( or);
		 }
		 res.put("entity", list);
		 
		 return res;  
	 }  
	 @RequestMapping ({"ordersEditByJqgridAndShopId","shop/ordersEditByJqgridAndShopId"})
	 @ResponseBody
	 public String ordersEditByJqgridAndShopId( @ModelAttribute("jqgridPage") JqgridPage jqgridPage,@ModelAttribute("orders") Orders orders,HttpServletRequest request,HttpServletResponse response) {  
		 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
		 Shops shops=shopsSer.getByUserId(myUserDetails.getId());
		 orders.setShopsId(shops.getId());
	 	  if(orders.getId()==0){
//	 		  article.setId();
	 		  jqgridPage.setOper("add");
	 	  }
//	 	 Orders.setAddtime(new Timestamp(System.currentTimeMillis())); 
	 			 Serializable i= ordersSer.edit(orders, jqgridPage);
	 	  return "success";
	 }  
	 @RequestMapping ({"ordersEditByJqgrid","background/ordersEditByJqgrid"})
	 @ResponseBody
	 public String ordersEditByJqgrid( @ModelAttribute("jqgridPage") JqgridPage jqgridPage,@ModelAttribute("orders") Orders orders){
	 	  if(orders.getId()==0){
//	 		  article.setId();
	 		  jqgridPage.setOper("add");
	 	  }
//	 	 Orders.setAddtime(new Timestamp(System.currentTimeMillis())); 
	 			 Serializable i= ordersSer.edit(orders, jqgridPage);
	 	  return "success";
	 }  
	 @RequestMapping({"ordersById","background/ordersById","shop/ordersById"}) 
	 @ResponseBody
	 public Orders OrdersById(@RequestParam("id") int id) {  
		 Orders arts=ordersSer.getById(id);
//	 				  for(int i=0;i<arts.size();i++){
//	 					  arts.get(i).setData(null);
//	 				  }
	 	return arts;
	 }
}
