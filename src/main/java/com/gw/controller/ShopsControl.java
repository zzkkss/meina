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
import com.gw.services.ShopsHotSer;
import com.gw.services.ShopsSer;
import com.gw.services.WeixinUserTerminalsSer;

@Controller
public class ShopsControl {

	private Logger logger = LoggerFactory.getLogger(ShopsControl.class);
	@Autowired
	private ShopsSer shopsSer;
	@Autowired
	private MainUsersSer mainUsersSer;
	@Autowired
	private CitylistSer citylistSer;
	@Autowired
	private CollectShopsSer collectShopsSer;
	@Autowired
	private ShopsHotSer shopsHotSer;
	/**首页按照距离返回店铺列表
	 * 
	 * @param jqpage
	 * @return
	 */
	 @RequestMapping ({"shopsListBydistance","background/shopsListBydistance","android/shopsListBydistance"}) 
	  @ResponseBody
	    public Map<String, Object> shopsListBydistance( @ModelAttribute("jqpage")Jqpage jqpage) {  
				 
		  Map<String, Object> arts=shopsSer.findByPage(jqpage);
	           return arts;  
	    }  
	 /**首页按照距离以及所在城市返回店铺列表
		 * 
		 * @param jqpage
		 * @return
		 */
	 @Deprecated
		 @RequestMapping ({"shopsListBydistanceAndCityCode","background/shopsListBydistanceAndCityCode","android/shopsListBydistanceAndCityCode"}) 
		  @ResponseBody
		    public Map<String, Object> shopsListBydistanceAndCityCode( @ModelAttribute("jqpage")Jqpage jqpage,int cityCode) {  
					 Citylist citylist=citylistSer.findByCitycode(cityCode);
					 if(citylist!=null){
						 Map<String, Object> arts=shopsSer.shopsListBydistanceAndCityCode(jqpage,citylist.getId());
						 return arts;  
					 }else{
						 return null;
					 }
		    }  
		 /**首页按照距离以及所在城市返回店铺列表
			 * 
			 * @param jqpage
			 * @return
			 */
			 @RequestMapping ({"shopsListByDistanceAndCityCode","background/shopsListByDistanceAndCityCode","android/shopsListByDistanceAndCityCode"}) 
			  @ResponseBody
			    public Map<String, Object> shopsListByDistanceAndCityCode( @ModelAttribute("jqpage")Jqpage jqpage,int cityCode,String coordinate) {  
						 Citylist citylist=citylistSer.findByCitycode(cityCode);
						 if(citylist!=null){
							 Map<String, Object> arts=shopsSer.shopsListBydistanceAndCityCode(jqpage,citylist.getId(),coordinate);
							 return arts;  
						 }else{
							 return null;
						 }
			    }  
		 /**首页返回热门店铺列表
			 * 
			 * @param jqpage
			 * @return
			 */
			 @RequestMapping ({"shopsListByHotAndCityCode","background/shopsListByHotAndCityCode","android/shopsListByHotAndCityCode"}) 
			  @ResponseBody
			    public List<Shops> shopsListByHotAndCityCode( int cityCode) {  
						 Citylist citylist=citylistSer.findByCitycode(cityCode);
						 List<ShopsHot> shopsHots=shopsHotSer.getByCityCode(citylist.getId());
						 List<Shops> list=new ArrayList<Shops>();
						 for(ShopsHot sh:shopsHots){
							 Shops shop=shopsSer.getById(sh.getShopsId());
							 list.add(shop);
						 }
						 return list;
			    }  
	 @RequestMapping ({"shopsList","background/shopsList","meina/shopsList","android/shopsList"}) 
	  @ResponseBody
	    public Map<String, Object> shopsList( @ModelAttribute("jqpage")Jqpage jqpage,int shoptype) {  
				 
		  Map<String, Object> arts=shopsSer.findByPageAndShoptype(jqpage,shoptype);
	           return arts;  
	    }  
	 
	 /**首页按照距离以及店铺类型返回店铺列表
		 * 
		 * @param jqpage
		 * @return
		 */
		 @RequestMapping ({"shopsListBydistanceAndType","background/shopsListBydistanceAndType","android/shopsListBydistanceAndType"}) 
		  @ResponseBody
		    public Map<String, Object> shopsListBydistanceAndType( @ModelAttribute("jqpage")Jqpage jqpage,int type) {  
					 
			  Map<String, Object> arts=shopsSer.shopsListBydistanceAndType(jqpage,type);
		           return arts;  
		    }  
	 
	 @RequestMapping ({"shopsByJqgrid","background/shopsByJqgrid","android/shopsByJqgrid"}) 
	@ResponseBody
	public Map<String, Object> shopsByJqgrid( @ModelAttribute("jqpage") JqgridPage jqgridPage) {  
		
		Map<String, Object> arts=shopsSer.findByJqgrid(jqgridPage);
		 Map<String, Object> abcd=new HashMap<String, Object>();
		  JqgridPage  jq=(JqgridPage) arts.get("jqgridPage");
		  List<Shops>  sp= (List<Shops>) arts.get("entity");
		  List<Map<String, Object>>  mu= new ArrayList<Map<String, Object>>();
		  for(int i=0;i<sp.size();i++){
			  Map<String,Object> spp=new HashMap<String, Object>();
			  spp.put("shop", sp.get(i));
			  MainUsers mm=mainUsersSer.getById(sp.get(i).getUsersId());
			  spp.put("mainuser", mm);
			  ShopsHot sh=shopsHotSer.getByShopsId(sp.get(i).getId());
			  spp.put("hot", sh);
			  mu.add(spp);
		  }
		  abcd.put("jqgridPage", jq);
		  abcd.put("entity", mu);
//		  abcd.put("entityM", mu);
		  
	           return abcd;  
		
	}  
	 @RequestMapping ({"shopsEditByJqgrid","background/shopsEditByJqgrid","android/shopsEditByJqgrid"})
	 @ResponseBody
	 public String shopsEditByJqgrid( @ModelAttribute("jqpage") JqgridPage jqgridPage,@ModelAttribute("shops") Shops shops) {  
	 	  if(shops.getId()==0){
//	 		  article.setId();
	 		  jqgridPage.setOper("add");
	 	  }
//	 	 shops.setAddtime(new Timestamp(System.currentTimeMillis())); 
	 			 Serializable i= shopsSer.edit(shops, jqgridPage);
	 	  return "success";
	 }  
	 @RequestMapping({"shopsById","background/shopsById","android/shopsById"}) 
	 @ResponseBody
	 public Shops shopsById(@RequestParam("id") int id) {  
		 Shops arts=shopsSer.getById(id);
//	 				  for(int i=0;i<arts.size();i++){
//	 					  arts.get(i).setData(null);
//	 				  }
	 	return arts;
	 }
	 @RequestMapping({"shopsByUserId","background/shopsByUserId","shop/shopsByUserId"}) 
	 @ResponseBody
	 public Shops shopsByUserId(HttpServletRequest request,HttpServletResponse response) {  
	 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
	 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
		 Shops arts=shopsSer.getByUserId(myUserDetails.getId());
	 	return arts;
	 }
	 /**
	  * 好像是shop权限下自行更新信息
	  * @param shops
	  * @param request
	  * @param response
	  * @return
	  */
	 @RequestMapping({"shop/shopsEditAdd","background/shopsEditAdd"}) 
	 @ResponseBody
	 public String shopsEditAdd(@ModelAttribute("shops") Shops shops,HttpServletRequest request,HttpServletResponse response) {  
		 Shops sp=new Shops();
		 sp=shops;
		 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
		 sp.setUsersId(myUserDetails.getId());
		 shopsSer.update(sp);
		 return "success";
	 }
	 /**
	  * admin更新店铺信息
	  * @param shops
	  * @param request
	  * @param response
	  * @return
	  */
	 @RequestMapping({"admin/shopsEdit","background/shopsEdit"}) 
	 @ResponseBody
	 public String shopsEdit(@ModelAttribute("shops") Shops shops,HttpServletRequest request,HttpServletResponse response) {  
//		 Shops sp=new Shops();
//		 sp=shops;
//		 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
//		 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
//		 sp.setUsersId(myUserDetails.getId());
		 Shops sp=shopsSer.getById(shops.getId());
		 sp.setEvaluate(shops.getEvaluate());
		 shopsSer.update(sp);
		 return "success";
	 }
	 /**
	  * 地图根据坐标返回数据
	  * 过时的算法，这个没有涉及城市
	  * @param center
	  * @param leftbttom
	  * @param righttop
	  * @return
	  */
	 @Deprecated
	 @RequestMapping ({"shopsListByCoordinate","background/shopsListByCoordinate","android/shopsListByCoordinate"}) 
	  @ResponseBody
	    public List<Shops> shopsListByCoordinate( String center,String leftbttom,String righttop) { 
		 //" + bssw.lng + "," + bssw.lat + "到" + bsne.lng + "," + bsne.lat)
//		 " + bssw.lng + "," + bssw.lat + "到" + bsne.lng + "," + bsne.lat)
				 List<Shops> list=shopsSer.shopsListByCoordinate(  center, leftbttom, righttop);
	           return list;  
	    }  
	 /**
	  * 地图根据坐标返回数据
	  * @param center
	  * @param leftbttom
	  * @param righttop
	  * @return
	  */
	 @RequestMapping ({"shopsListByCoordinateAndCityCode","background/shopsListByCoordinateAndCityCode","android/shopsListByCoordinateAndCityCode"}) 
	  @ResponseBody
	    public List<Shops> shopsListByCoordinateAndCityCode( String center,String leftbttom,String righttop,int cityCode) { 
		 //" + bssw.lng + "," + bssw.lat + "到" + bsne.lng + "," + bsne.lat)int cityCode) {  
		 Citylist citylist=citylistSer.findByCitycode(cityCode);
		// List<ShopsHot> shopsHots=shopsHotSer.getByCityCode(citylist.getId());
//		 " + bssw.lng + "," + bssw.lat + "到" + bsne.lng + "," + bsne.lat)
				 List<Shops> list=shopsSer.shopsListByCoordinateAndCityCode(  center, leftbttom, righttop,citylist.getId());
	           return list;  
	    }  
	 /**
	  * 根据店名的关键词返回店铺列表
	  * @param keyWords
	  * @return
	  */
	 @RequestMapping ({"shopsListBySearch","background/shopsListBySearch","android/shopsListBySearch"}) 
	  @ResponseBody
	    public List<Shops> shopsListBySearch( String keyWords) { 
		 //" + bssw.lng + "," + bssw.lat + "到" + bsne.lng + "," + bsne.lat)
//		 " + bssw.lng + "," + bssw.lat + "到" + bsne.lng + "," + bsne.lat)
				 List<Shops> list=shopsSer.shopsListBySearch(  keyWords);
	           return list;  
	    }  
	 @RequestMapping({"shopsToMyCollect","shop/shopsToMyCollect","android/shopsToMyCollect"}) 
	 @ResponseBody
	 /**
	  * 增加shop到我的收藏
	  * @param couponsId
	  * @param request
	  * @param response
	  * @return
	  */
	 public  String shopsToMyCollect( int shopsId,HttpServletRequest request,HttpServletResponse response) {  
		 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		
		 if(securityContextImpl==null){
			 return "请先登录！".toString();
		 }else{
			 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
//			 Shops shops=shopsSer.getByUserId(myUserDetails.getId());
			 MainUsers mainUsers=mainUsersSer.getById(myUserDetails.getId());
//			 CollectCoupons collectCoupons=new CollectCoupons();
//			 collectCoupons.setUsersId(mainUsers.getId());
//			 collectCoupons.setCouponsId(couponsId);
//			 collectCoupons.setState(0);
//			 CollectCoupons cc= collectCouponsSer.findByUserIdAndCouponId(collectCoupons);
			 CollectShops collectShops=new CollectShops();
			 collectShops.setShopsId(shopsId);
			 collectShops.setUsersId(mainUsers.getId());
			 CollectShops cs=collectShopsSer.findByUserIdAndShopsId(collectShops);
			 if(cs!=null){
				 return "您已经获收藏了该店铺！".toString();
			 }else{
				 Serializable dd= collectShopsSer.save(collectShops);
				 return "success";
			 }
		 }
	 }
	 @RequestMapping({"collectShopsByJqpageAndUserId","background/collectShopsByJqpageAndUserId","android/collectShopsByJqpageAndUserId"}) 
	 @ResponseBody
	 public Map<String, Object> collectShopsByJqpageAndUserId(@ModelAttribute("jqpage")Jqpage jqpage,HttpServletRequest request,HttpServletResponse response) {  
	 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
	 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
	 Map<String, Object> cs=collectShopsSer.findByJqpageAndUserId(jqpage,myUserDetails.getId());
	 Map<String, Object> res=new HashMap<String, Object>();
	 res.put("jqpage", cs.get("jqpage"));
//	 List<Orders> orders=(List<Orders>) arts.get("entity");
	 List<CollectShops> css=(List<CollectShops>) cs.get("entity");
	 List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
	 for(int i=0;i<css.size();i++){
		Shops shops=shopsSer.getById(css.get(i).getShopsId());
//		 MainUsers u=mainUsersSer.getById(orders.get(i).getUsersId());
//		 Customers c=customersSer.getByUserId(u.getId());
//		 
		 Map<String, Object> or=new HashMap<String, Object>();
//		 or.put("order", orders.get(i));
		 or.put("shop", shops);
//		 Products products2=productsSer.getById(orders.get(i).getProductId());
//		 or.put("products",products2);
		 list.add( or);
	 }
	 res.put("entity", list);
//	 
	 return res;  
	 }
}
