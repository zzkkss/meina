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
public class ShopsHotControl {

	private Logger logger = LoggerFactory.getLogger(ShopsHotControl.class);
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
	
	///"http://localhost:8080/background/shopsHotEdit.do?id=1009&sort=1&cityCode=&operate=1&_=1440807604882"
	
	 @RequestMapping ({"shopsHotEdit","background/shopsHotEdit"})
	 @ResponseBody
	 public String shopsHotEdit( int id,int sort,int cityCode,int operate) {  
		 if(sort>6||sort<0){
			 return "请输入数值为1-5的数字。";
		 }
		 List<ShopsHot> shopsHots=shopsHotSer.getByCityCode(cityCode);
		 if(operate==1){
			 if(shopsHots.size()>=5){
				 return "该城市已经有5个热门店铺，不能再增加新店铺！";
			 }else{
				 if(sortIsInList(sort,shopsHots)){
					 return "排名第"+sort+"的店铺已经存在，请重新选择！";
				 }else{
					 ShopsHot hot=new ShopsHot();
					 hot.setShopsId(id);
					 hot.setHotSort(sort);
					 hot.setCityCode(cityCode);
					 shopsHotSer.save(hot);
					 return "success";
				 }

			 }
		 }
		 if(operate==2){
			 ShopsHot sh=idIsInList(id,shopsHots);
			 if(sh!=null){
				 if(sort==sh.getHotSort()){
					 return "没有发生修改！";
				 }
				 if(sortIsInList(sort,shopsHots)){
					 return "排名第"+sort+"的店铺已经存在，请重新选择！";
				 }else{
					 sh.setHotSort(sort);
					 shopsHotSer.update(sh);
					 return "success";
				 }
			
			 }else{
				 return "没有找到该店铺，修改失败。";
			 }
		 }
		 if(operate==0){
			 ShopsHot shopsHot=shopsHotSer.getByShopsId(id);
			 if(shopsHot!=null){
				 shopsHotSer.delete(shopsHot);
				 return "success";
			 }else{
				 return "没有找到该店铺，修改失败。";
			 }
		 }
		 
	 	  return "failed";
	 }
	private boolean sortIsInList(int sort, List<ShopsHot> shopsHots) {
		// TODO Auto-generated method stub
		for(int i=0;i<shopsHots.size();i++){
			if(sort==shopsHots.get(i).getHotSort()){
				return true;
			}
		}
		return false;
	}
	private ShopsHot idIsInList(int id, List<ShopsHot> shopsHots) {
		// TODO Auto-generated method stub
		for(int i=0;i<shopsHots.size();i++){
			if(id==shopsHots.get(i).getShopsId()){
				return shopsHots.get(i);
			}
		}
		return null;
	}  
	
}
