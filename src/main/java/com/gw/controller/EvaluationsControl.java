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

import com.gw.model.Customers;
import com.gw.model.JqgridPage;
import com.gw.model.Evaluations;
import com.gw.model.Jqpage;
import com.gw.model.MainUsers;
import com.gw.model.Orders;
import com.gw.model.Products;
import com.gw.model.Shops;
import com.gw.model.WeixinUserTerminals;
import com.gw.security.LoginInfo;
import com.gw.security.MyProvider;
import com.gw.security.MyUserDetails;
import com.gw.services.CustomersSer;
import com.gw.services.EvaluationsSer;
import com.gw.services.MainUsersSer;
import com.gw.services.OrdersSer;
import com.gw.services.ProductsSer;
import com.gw.services.ShopsSer;
import com.gw.services.WeixinUserTerminalsSer;

@Controller
public class EvaluationsControl {

	private Logger logger = LoggerFactory.getLogger(EvaluationsControl.class);
	@Autowired
	private EvaluationsSer evaluationsSer;
@Autowired
private CustomersSer customersSer;
@Autowired
private MainUsersSer mainUsersSer;
@Autowired
private OrdersSer ordersSer;
@Autowired
private ShopsSer shopsSer;
@Autowired
private ProductsSer productsSer;
	 @RequestMapping ({"evaluationsList","background/evaluationsList","android/evaluationsList"}) 
	  @ResponseBody
	    public List<Evaluations> shopList( ) {  
				 
		  List<Evaluations> arts=evaluationsSer.findAll();
	           return arts;  
	    }  
	 @RequestMapping ({"evaluationsByJqgrid","background/evaluationsByJqgrid"}) 
	@ResponseBody
	public Map<String, Object> evaluationsByJqgrid( @ModelAttribute("jqpage") JqgridPage jqgridPage) {  
		
		Map<String, Object> arts=evaluationsSer.findByJqgrid(jqgridPage);
		return arts;  
	}  
	 @RequestMapping ({"evaluationsByJqgridAndProductId","background/evaluationsByJqgridAndProductId","android/evaluationsByJqgridAndProductId"}) 
		@ResponseBody
		public Map<String, Object> evaluationsByJqgridAndProductId( @ModelAttribute("jqpage") Jqpage jqpage,int productId) {  
			
			Map<String, Object> arts=evaluationsSer.findByJqgridJqgridAndProductId(jqpage,productId);
			
			List<Evaluations> list=(List<Evaluations>) (arts.get("entity"));
			List<Customers> list2=new ArrayList<Customers>();
			for(int i=0;i<list.size();i++){
				MainUsers mainUsers=mainUsersSer.getById(list.get(i).getUserId());
				Customers customers=customersSer.getByUserId(mainUsers.getId());
				list2.add(customers);
			}
			Map<String, Object> map=new HashMap<String, Object>();
			arts.put("entityC",list2);
			
			return arts;  
		}  
	 @RequestMapping ({"evaluationsEditByJqgrid","background/evaluationsEditByJqgrid"})
	 @ResponseBody
	 public String productEditByJqgrid( @ModelAttribute("jqpage") JqgridPage jqgridPage,@ModelAttribute("evaluations") Evaluations evaluations) {  
	 	  if(evaluations.getId()==0){
//	 		  article.setId();
	 		  jqgridPage.setOper("add");
	 	  }
//	 	 evaluations.setAddtime(new Timestamp(System.currentTimeMillis())); 
	 			 Serializable i= evaluationsSer.edit(evaluations, jqgridPage);
	 	  return "success";
	 }  
	 @RequestMapping({"evaluationsById","background/evaluationsById"}) 
	 @ResponseBody
	 public Evaluations evaluationsById(@RequestParam("id") int id) {  
		 Evaluations arts=evaluationsSer.getById(id);
//	 				  for(int i=0;i<arts.size();i++){
//	 					  arts.get(i).setData(null);
//	 				  }
	 	return arts;
	 }
	 //] "POST /android/evaluationsByCustomer.do?productId=19&orderId=56&score=3&title=5hb&content=Yhbb HTTP/1.1" 404 379
	 @RequestMapping({"evaluationsByCustomer","android/evaluationsByCustomer"}) 
	 @ResponseBody
	 public String evaluationsById(@ModelAttribute("evaluations") Evaluations evaluations,HttpServletRequest request,HttpServletResponse response) {  
		 SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		 MyUserDetails myUserDetails=(MyUserDetails) securityContextImpl.getAuthentication().getPrincipal();
		 evaluations.setUserId(myUserDetails.getId());
		 int arts=(Integer) evaluationsSer.save(evaluations);
		 
//	 				  for(int i=0;i<arts.size();i++){
//	 					  arts.get(i).setData(null);
//	 				  }
		 
		 Orders a=ordersSer.getById(evaluations.getOrderId());
		 a.setState(3);
		 ordersSer.update(a);//修改订单状态为以评价；
		 
		Products products=productsSer.getById(evaluations.getProductId());
		List<Evaluations> evaluations2=evaluationsSer.findByProductId(evaluations);
		int sum=0;
		for(int i=0;i<evaluations2.size();i++){
			sum+=evaluations2.get(i).getScore();
		}
		int fen=(int) Math.round((double)(sum+evaluations.getScore())/(evaluations2.size()+1));
		products.setEvaluate(fen);
		productsSer.update(products);	//修改商品平均评分；
		// Shops shops=shopsSer.getById(products.getShopsId()); //修改店铺平均评分,放到店铺管理中；
		 
		 if(arts>0){
			 return "success";
		 }else{
			 return "falied";
		 }
	 }
}
