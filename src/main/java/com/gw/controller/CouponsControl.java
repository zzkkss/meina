package com.gw.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import com.gw.model.CollectCoupons;
import com.gw.model.CollectShops;
import com.gw.model.Coupons;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainUsers;
import com.gw.model.Shops;
import com.gw.security.MyUserDetails;
import com.gw.services.CollectCouponsSer;
import com.gw.services.CouponsSer;
import com.gw.services.MainUsersSer;
import com.gw.services.ShopsSer;

@Controller
public class CouponsControl {

	private Logger logger = LoggerFactory.getLogger(CouponsControl.class);
	@Autowired
	private CouponsSer couponsSer;
	@Autowired
	private MainUsersSer mainUsersSer;
@Autowired
private ShopsSer shopsSer;
@Autowired
private CollectCouponsSer collectCouponsSer;
	 @RequestMapping ({"couponsList","background/couponsList","shop/couponsList","android/couponsList"}) 
	  @ResponseBody
	    public Map<String, Object> couponsList(@ModelAttribute("jqpage")Jqpage jqpage ) {  
				 
		  Map<String, Object> arts=couponsSer.findByPage(jqpage);
	           return arts;  
	    }  
//	 @RequestMapping ({"couponsById","background/couponsById","meina/couponsById","android/couponsById"}) 
//	  @ResponseBody
//	    public Coupons couponsById(@ModelAttribute("couponId")String couponId ) {  
//				 
//		  Coupons arts=couponsSer.getById(Integer.parseInt(couponId));
//	           return arts;  
//	    }  
	 @RequestMapping ({"couponsByJqgrid","background/couponsByJqgrid"}) 
	@ResponseBody
	public Map<String, Object> couponsByJqgrid( @ModelAttribute("jqpage") JqgridPage jqgridPage) {  
		
		Map<String, Object> arts=couponsSer.findByJqgrid(jqgridPage);
		return arts;  
	}  
	 @RequestMapping ({"couponsByJqgridAndShopid","shop/couponsByJqgridAndShopid"}) 
	 @ResponseBody
	 public Map<String, Object> couponsByJqgridAndShopid( @ModelAttribute("jqgridPage") JqgridPage jqgridPage,HttpServletRequest request,HttpServletResponse response) {  
		 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
		 Shops shops=shopsSer.getByUserId(myUserDetails.getId());
		 Map<String, Object> arts=couponsSer.findByJqgridAndShopId(jqgridPage,shops.getId());
		 return arts;  
	 }  
	 @RequestMapping ({"couponsEditByJqgridAndShopid","shop/couponsEditByJqgridAndShopid"})
	 @ResponseBody
	 public String productEditByJqgridAndShopid( @ModelAttribute("jqpage") JqgridPage jqgridPage,@ModelAttribute("coupons") Coupons coupons ,HttpServletRequest request,HttpServletResponse response) {  
		 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
		 Shops shops=shopsSer.getByUserId(myUserDetails.getId());
		 coupons.setShopsId(shops.getId());
	 	  if(coupons.getId()==0){
//	 		  article.setId();
	 		  jqgridPage.setOper("add");
	 	  }
//	 	 coupons.setAddtime(new Timestamp(System.currentTimeMillis())); 
	 			 Serializable i= couponsSer.edit(coupons, jqgridPage);
	 	  return "success";
	 }  
	 @RequestMapping ({"couponsEditByJqgrid","shop/couponsEditByJqgrid","background/couponsEditByJqgrid"})
	 @ResponseBody
	 public String productEditByJqgrid( @ModelAttribute("jqpage") JqgridPage jqgridPage,@ModelAttribute("coupons") Coupons coupons ){
	 	  if(coupons.getId()==0){
//	 		  article.setId();
	 		  jqgridPage.setOper("add");
	 	  }
//	 	 coupons.setAddtime(new Timestamp(System.currentTimeMillis())); 
	 			 Serializable i= couponsSer.edit(coupons, jqgridPage);
	 	  return "success";
	 }  
	 @RequestMapping({"couponsById","shop/couponsById","background/couponsById"}) 
	 @ResponseBody
	 public Coupons couponsById(@RequestParam("id") int id) {  
		 Coupons arts=couponsSer.getById(id);
//	 				  for(int i=0;i<arts.size();i++){
//	 					  arts.get(i).setData(null);
//	 				  }
	 	return arts;
	 }
	 @RequestMapping({"couponsByShopId","shop/couponsByShopId","background/couponsByShopId","android/couponsByShopId"}) 
	 @ResponseBody
	 public  Map<String, Object> couponsByShopId(@ModelAttribute("jqpage")Jqpage jqpage , int shopid) {  
		 Map<String, Object> arts=couponsSer.findByPageAndShopid(jqpage,shopid);
			return arts;  
	 }
	 @RequestMapping({"couponsToMyCollect","shop/couponsToMyCollect","android/couponsToMyCollect"}) 
	 @ResponseBody
	 public  String couponsToMyCollect( int couponsId,HttpServletRequest request,HttpServletResponse response) {  
		 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		
		 if(securityContextImpl==null){
			 return "请先登录！".toString();
		 }else{
			 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
//			 Shops shops=shopsSer.getByUserId(myUserDetails.getId());
			 MainUsers mainUsers=mainUsersSer.getById(myUserDetails.getId());
			 CollectCoupons collectCoupons=new CollectCoupons();
			 collectCoupons.setUsersId(mainUsers.getId());
			 collectCoupons.setCouponsId(couponsId);
			 collectCoupons.setState(0);
			 CollectCoupons cc= collectCouponsSer.findByUserIdAndCouponId(collectCoupons);
			 if(cc!=null){
				 return "您已经获得了该优惠券！".toString();
			 }else{
				 Serializable dd= collectCouponsSer.save(collectCoupons);
				 return "success";
			 }
		 }
	 }
	 @RequestMapping({"collectCouponsByJqpageAndUserId","background/collectCouponsByJqpageAndUserId","android/collectCouponsByJqpageAndUserId"}) 
	 @ResponseBody
	 public Map<String, Object> collectCouponsByJqpageAndUserId(@ModelAttribute("jqpage")Jqpage jqpage,HttpServletRequest request,HttpServletResponse response) {  
	 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
	 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
	 Map<String, Object> cs=collectCouponsSer.findByJqpageAndUserId(jqpage,myUserDetails.getId());
	 Map<String, Object> res=new HashMap<String, Object>();
	 res.put("jqpage", cs.get("jqpage"));
	 List<CollectCoupons> ccs=(List<CollectCoupons>) cs.get("entity");
	 List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
	 for(int i=0;i<ccs.size();i++){
		 Coupons coupons=couponsSer.getById(ccs.get(i).getCouponsId());
		 Map<String, Object> or=new HashMap<String, Object>();
		 or.put("coupon", coupons);
		 list.add( or);
	 }
	 res.put("entity", list);
 return res;  
	 }
}
