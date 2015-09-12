package com.gw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
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





import com.google.code.kaptcha.servlet.KaptchaExtend;
import com.gw.model.BbsUser;
import com.gw.model.Customers;
import com.gw.model.MainUsers;
import com.gw.model.MainUsersRoles;
import com.gw.model.Shops;
import com.gw.model.WeixinUserTerminals;
import com.gw.security.LoginInfo;
import com.gw.security.MyProvider;
import com.gw.security.MyUserDetails;
import com.gw.services.BbsUserSer;
import com.gw.services.CustomersSer;
import com.gw.services.MainUsersRolesSer;
import com.gw.services.MainUsersSer;
import com.gw.services.ShopsSer;
import com.gw.services.WeixinUserTerminalsSer;

@Controller
public class LoginControl  extends KaptchaExtend {

	private Logger logger = LoggerFactory.getLogger(LoginControl.class);
	@Autowired
	private WeixinUserTerminalsSer hquserTerminalsSer;
	// @Autowired
	private AuthenticationManager myAuthenticationManager;
	@Autowired
	private MainUsersRolesSer mainUsersRolesSer;
	@Autowired
	private MyProvider myProvider;
@Autowired
private MainUsersSer mainUsersSer;
@Autowired
private ShopsSer shopsSer;
@Autowired
private CustomersSer customersSer;
@Autowired
private BbsUserSer bbsUserSer;

@RequestMapping(value = "/captcha", method = RequestMethod.GET)
public void captcha(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.captcha(req, resp);
}
/**
 * 商户登陆页面
 * @param error
 * @param logout
 * @param request
 * @param response
 * @return
 */
@RequestMapping(value = { "/shop", "/shop/shop" })
public ModelAndView shop(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout,HttpServletRequest request,
		HttpServletResponse response) {
//logger.info(request.getHeader("User-Agent").toString());
	
	ModelAndView model =  new ModelAndView("register-post");
	if (error != null) {
		if (error.equals("1")) {
			model.addObject("msg", "没有找到用户！");
		}else if (error.equals("2")) {
			model.addObject("msg", "用户或者密码错误！");
		}else if (error.equals("3")) {
			model.addObject("msg", "验证码错误！");
		}else if (error.equals("4")) {
			model.addObject("msg", "账户审核中！");
		}else{
			model.addObject("msg", "用户或者密码错误！");
		}
	}
	model.setViewName("shop/login");
	return model;
}
/**
 * 管理员登录页面
 * @param error
 * @param logout
 * @param request
 * @param response
 * @return
 */
@RequestMapping(value = { "/admin", "/admin/admin" })
public ModelAndView admin(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout,HttpServletRequest request,
		HttpServletResponse response) {
//logger.info(request.getHeader("User-Agent").toString());
	
//	ModelAndView model =  new ModelAndView("register-post");
	ModelAndView model =  new ModelAndView();
	if (error != null) {
		if (error.equals("1")) {
			model.addObject("msg", "没有找到用户！");
		}else if (error.equals("2")) {
			model.addObject("msg", "用户或者密码错误！");
		}else if (error.equals("3")) {
			model.addObject("msg", "验证码错误！");
		}else if (error.equals("4")) {
			model.addObject("msg", "账户审核中！");
		}else{
			model.addObject("msg", "用户或者密码错误！");
		}
	}
	model.setViewName("admin/login");
	return model;
}
/**
 * 顾客登陆页面
 * @param error
 * @param logout
 * @param request
 * @param response
 * @return
 */
@RequestMapping(value = { "/customer", "/background/customer" })
public ModelAndView customer(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout,HttpServletRequest request,
		HttpServletResponse response) {
//logger.info(request.getHeader("User-Agent").toString());
	
	ModelAndView model =  new ModelAndView("register-post");
	if (error != null) {
		if (error.equals("1")) {
			model.addObject("msg", "没有找到用户！");
		}else if (error.equals("2")) {
			model.addObject("msg", "用户或者密码错误！");
		}else if (error.equals("3")) {
			model.addObject("msg", "验证码错误！");
		}else if (error.equals("4")) {
			model.addObject("msg", "账户审核中！");
		}else{
			model.addObject("msg", "用户或者密码错误！");
		}
	}
	model.setViewName("customer/login");
	return model;
}
/**
 * 商户注册页面
 * @param error
 * @param logout
 * @param request
 * @param response
 * @return
 */
@RequestMapping(value = { "/shopRegister", "/background/shopRegister" })
public ModelAndView shopRegister(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout,HttpServletRequest request,
		HttpServletResponse response) {
//logger.info(request.getHeader("User-Agent").toString());
	
	ModelAndView model =  new ModelAndView("register-post");
	if (error != null) {
		if (error.equals("1")) {
			model.addObject("msg", "用户已经存在！");
		}else if (error.equals("2")) {
			model.addObject("msg", "账户名、密码、店铺名请勿为空！");
		}else if (error.equals("3")) {
			model.addObject("msg", "验证码错误！");
		}else{
			model.addObject("msg", "用户或者密码错误！");
		}
	}
	model.setViewName("shop/shopRegister");
	return model;
}
/**
 * 顾客注册页面
 * @param error
 * @param logout
 * @param request
 * @param response
 * @return
 */
@RequestMapping(value = { "/customerRegister", "/background/customerRegister" })
public ModelAndView customerRegister(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout,HttpServletRequest request,
		HttpServletResponse response) {
//logger.info(request.getHeader("User-Agent").toString());
	
	ModelAndView model =  new ModelAndView("register-post");
	if (error != null) {
		if (error.equals("1")) {
			model.addObject("msg", "用户已经存在！");
		}else if (error.equals("2")) {
			model.addObject("msg", "账户名、密码、店铺名请勿为空！");
		}else if (error.equals("3")) {
			model.addObject("msg", "验证码错误！");
		}else{
			model.addObject("msg", "用户或者密码错误！");
		}
	}
	model.setViewName("customer/customerRegister");
	return model;
}
	/**
	 * 登录页面
	 * 
	 * @param error
	 * @param logout
	 * @return
	 */
	@RequestMapping(value = { "/login", "/background/login" })
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,HttpServletRequest request,
			HttpServletResponse response) {
//logger.info(request.getHeader("User-Agent").toString());
		
		ModelAndView model =  new ModelAndView("register-post");
		if (error != null) {
			if (error.equals("1")) {
				model.addObject("msg", "没有找到用户！");
			}else if (error.equals("2")) {
				model.addObject("msg", "用户或者密码错误！");
			}else if (error.equals("4")) {
				model.addObject("msg", "账户审核中！");
			}else{
				model.addObject("msg", "用户或者密码错误！");
			}

		}
		
		if (logout != null) {
		/*	SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
					.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
			securityContextImpl.getAuthentication().setAuthenticated(false);*/
			model.addObject("msg", "您已经成功退出！");
		}
		
		if(request.getHeader("User-Agent").toString().contains("Windows")){
			model.setViewName("background/login");
		}else if(request.getHeader("User-Agent").toString().contains("Android")||request.getHeader("User-Agent").toString().contains("iPhone")){
			model.setViewName("customer/login/login");
		}else{
			model.setViewName("background/login");
			
		}
		
		return model;

	}

	/**
	 * 登陆时不同的权限跳转到不同的页面
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/back", "/background/back" }, method = RequestMethod.GET)
	public ModelAndView back(HttpServletRequest request,
			HttpServletResponse response) {

		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
				.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		ModelAndView model = new ModelAndView();
		MainUsers mainUsers= mainUsersSer.findByUsername(securityContextImpl.getAuthentication().getName()).get(0);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("id", mainUsers.getId());
		Set<String> roles = AuthorityUtils.authorityListToSet(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		if (roles.contains("ROLE_ADMIN")) {
			model.setViewName("admin/admin");
//			return new RedirectView( "admin/admin.jsp"); 
		} else if (roles.contains("ROLE_SHOP")){
			Shops shops=shopsSer.getByUserId( mainUsers.getId());
			map2.put("shopid", shops.getId());
			map2.put("shopTitle", shops.getTitle());
			model.setViewName("shop/admin");
//			return new RedirectView( "shop/shop.jsp"); 
		}else if (roles.contains("ROLE_CUSTOM")){
			Customers customers=customersSer.getByUserId(mainUsers.getId());
			map2.put("customer", customers);
//			return new RedirectView( "meina/shop.jsp"); 
			model.setViewName("customer/home/home");
		}else{
			
		}
		model.addObject("info", JSONObject.fromObject(map2));
		
		return model;
//		 	return new RedirectView( "www.baidu.com"); 


	}
	/**
	 * Admin登录以后页面
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/admin/adminBack" , "/adminBack" }, method = RequestMethod.GET)
	public ModelAndView adminBack(HttpServletRequest request,HttpServletResponse response) {

		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		ModelAndView model = new ModelAndView();
		if(securityContextImpl!=null){
		MainUsers mainUsers= mainUsersSer.findByUsername(securityContextImpl.getAuthentication().getName()).get(0);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("id", mainUsers.getId());
		model.addObject("info", JSONObject.fromObject(map2));
		}else{
		}
		model.setViewName("admin/admin");
		return model;
	}
	/**
	 * SHOP登录以后页面
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/shopBack", "/shop/shopBack" }, method = RequestMethod.GET)
	public ModelAndView shopBack(HttpServletRequest request,HttpServletResponse response) {

		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		ModelAndView model = new ModelAndView();
		if(securityContextImpl!=null){
			MainUsers mainUsers= mainUsersSer.findByUsername(securityContextImpl.getAuthentication().getName()).get(0);
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("id", mainUsers.getId());
				Shops shops=shopsSer.getByUserId( mainUsers.getId());
				map2.put("shopid", shops.getId());
				map2.put("shopTitle", shops.getTitle());
			model.addObject("info", JSONObject.fromObject(map2));
		}else{
		}
		model.setViewName("shop/admin");
		return model;
	}
	/**
	 * CUSTOMER登录以后页面
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/customerBack", "/shop/customerBack" }, method = RequestMethod.GET)
	public ModelAndView customerBack(HttpServletRequest request,HttpServletResponse response) {

		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		ModelAndView model = new ModelAndView();
		MainUsers mainUsers= mainUsersSer.findByUsername(securityContextImpl.getAuthentication().getName()).get(0);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("id", mainUsers.getId());

			Customers customers=customersSer.getByUserId(mainUsers.getId());
			map2.put("customer", customers);
			model.setViewName("customer/home/home");

		model.addObject("info", JSONObject.fromObject(map2));
		
		return model;
	}
	@RequestMapping(value = { "/loginR", "/background/loginR" }, method = RequestMethod.POST)
	@ResponseBody
	public View   loginR(@RequestParam(defaultValue = "") String username,
			@RequestParam(defaultValue = "") String password,
			HttpServletRequest request) {
//		if(!checkValidateCode(request)){
////		      return new LoginInfo().failed().msg("验证码错误！");
//		    }
	//	System.out.println(request.getRequestURL()getServletPath());
		if(mainUsersSer.checkNameAndPassword(username,password)){
		    username = username.trim();
		    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
			try {
		      Authentication authentication = myProvider.authenticate(authRequest); //调用loadUserByUsername
		      if(((MyUserDetails)authentication.getPrincipal()).isEnabled()){
			      SecurityContextHolder.getContext().setAuthentication(authentication);
			      HttpSession session = request.getSession();
			      session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); // 这个非常重要，否则验证后将无法登陆
//			      return new LoginInfo().success().msg(authentication.getName());
//			      return authentication.getName();
			      session.setAttribute("MainUserID", ((MyUserDetails)authentication.getPrincipal()).getId());
			      BbsUser bbsUser=bbsUserSer.findByUserId(((MyUserDetails)authentication.getPrincipal()).getId());
			      if(bbsUser!=null){
			    	  session.setAttribute("user", bbsUser);
				      session.setAttribute("userID",bbsUser.getId());
				      return new RedirectView( "customerBack.do"); 
			      }
			    
			      return new RedirectView( "back.do"); 
		      }else{
		    	  //账户审核中
		    		return new RedirectView( "login.do?error=4"); 
		      }

		    } catch (AuthenticationException ex) {
//		      return new LoginInfo().failed().msg("用户名或密码错误");
//		      return ("没有找到用户");
		    	return new RedirectView( "login.do?error=1"); 
		    }
		}else{
//			 return ("用户名或密码错误");
			return new RedirectView( "login.do?error=2"); 
		}

	}
	/**
	 * 商户登陆认证
	 * @param username
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/loginShop", "/background/loginShop" }, method = RequestMethod.POST)
	@ResponseBody
	public View   loginShop(@RequestParam(defaultValue = "") String username,
			@RequestParam(defaultValue = "") String password,
			HttpServletRequest request) {
		if(!checkValidateCode(request)){
//		      return new LoginInfo().failed().msg("验证码错误！");
			return new RedirectView( "shop.do?error=3"); 
		    }
	//	System.out.println(request.getRequestURL()getServletPath());
		if(mainUsersSer.checkNameAndPassword(username,password)){
		    username = username.trim();
		    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
		    
		    
			try {
			      Authentication authentication = myProvider.authenticate(authRequest); //调用loadUserByUsername
			      if(((MyUserDetails)authentication.getPrincipal()).isEnabled()){
				      SecurityContextHolder.getContext().setAuthentication(authentication);
				      HttpSession session = request.getSession();
				      session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); // 这个非常重要，否则验证后将无法登陆
//				      return new LoginInfo().success().msg(authentication.getName());
//				      return authentication.getName();
				      return new RedirectView( "shopBack.do"); 
			      }else{
			    	  //账户审核中
			    		return new RedirectView( "shop.do?error=4"); 
			      }
		    } catch (AuthenticationException ex) {
//		      return new LoginInfo().failed().msg("用户名或密码错误");
//		      return ("获取权限失败");
		    	return new RedirectView( "shop.do?error=1"); 
		    }
		}else{
//			 return ("用户名或密码错误");
			return new RedirectView( "shop.do?error=2"); 
		}

	}
	/**
	 * 商户登陆认证
	 * @param username
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/loginAdmin", "/admin/loginAdmin" }, method = RequestMethod.POST)
	@ResponseBody
	public View   loginAdmin(@RequestParam(defaultValue = "") String username,
			@RequestParam(defaultValue = "") String password,
			HttpServletRequest request) {
		if(!checkValidateCode(request)){
//		      return new LoginInfo().failed().msg("验证码错误！");
			return new RedirectView( "admin.do?error=3"); 
		    }
	//	System.out.println(request.getRequestURL()getServletPath());
		if(mainUsersSer.checkNameAndPassword(username,password)){
		    username = username.trim();
		    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
		    
		    
			try {
			      Authentication authentication = myProvider.authenticate(authRequest); //调用loadUserByUsername
			      if(((MyUserDetails)authentication.getPrincipal()).isEnabled()){
				      SecurityContextHolder.getContext().setAuthentication(authentication);
				      HttpSession session = request.getSession();
				      session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); // 这个非常重要，否则验证后将无法登陆
//				      return new LoginInfo().success().msg(authentication.getName());
//				      return authentication.getName();
				      return new RedirectView( "adminBack.do"); 
			      }else{
			    	  //账户审核中
			    		return new RedirectView( "admin.do?error=4"); 
			      }
		    } catch (AuthenticationException ex) {
//		      return new LoginInfo().failed().msg("用户名或密码错误");
//		      return ("获取权限失败");
		    	return new RedirectView( "admin.do?error=1"); 
		    }
		}else{
//			 return ("用户名或密码错误");
			return new RedirectView( "admin.do?error=2"); 
		}

	}
	/**
	 * 顾客登陆认证
	 * @param username
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/loginCustomer", "/background/loginCustomer" }, method = RequestMethod.POST)
	@ResponseBody
	public View   loginCustomer(@RequestParam(defaultValue = "") String username,
			@RequestParam(defaultValue = "") String password,
			HttpServletRequest request) {
		if(!checkValidateCode(request)){
//		      return new LoginInfo().failed().msg("验证码错误！");
			return new RedirectView( "customer.do?error=3"); 
		    }
	//	System.out.println(request.getRequestURL()getServletPath());
		if(mainUsersSer.checkNameAndPassword(username,password)){
		    username = username.trim();
		    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
		    
		    
			try {
			      Authentication authentication = myProvider.authenticate(authRequest); //调用loadUserByUsername
//			      if(((MyUserDetails)authentication.getPrincipal()).isEnabled()){
				      SecurityContextHolder.getContext().setAuthentication(authentication);
				      HttpSession session = request.getSession();
				      session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); // 这个非常重要，否则验证后将无法登陆
//			            String bbsID = username + Const.BBS_ID_SEPARATOR + password;
//			            setCookie("bbsID", bbsID, 3600*24*30);
				     // session.setSessionAttr("user", (MyUserDetails)authentication.getPrincipal());
				      
				/*      SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
						ModelAndView model = new ModelAndView();
						MainUsers mainUsers= mainUsersSer.findByUsername(securityContextImpl.getAuthentication().getName()).get(0);
						Map<String, Object> map2 = new HashMap<String, Object>();
						map2.put("id", mainUsers.getId());

							Customers customers=customersSer.getByUserId(mainUsers.getId());*/
//				      MainUsers mainUsers= mainUsersSer.findByUsername(authentication.getName()).get(0);
				      BbsUser bbsUser=bbsUserSer.findByUserId(((MyUserDetails)authentication.getPrincipal()).getId());
				      session.setAttribute("user", bbsUser);
				      session.setAttribute("MainUserID", ((MyUserDetails)authentication.getPrincipal()).getId());
				      session.setAttribute("userID",bbsUser.getId());
				      return new RedirectView( "customerBack.do"); 
//			      }else{
//			    	  //账户审核中
//			    		return new RedirectView( "customer.do?error=4"); 
//			      }
		    } catch (AuthenticationException ex) {
//		      return new LoginInfo().failed().msg("用户名或密码错误");
//		      return ("获取权限失败");
		    	return new RedirectView( "customer.do?error=1"); 
		    }
		}else{
//			 return ("用户名或密码错误");
			return new RedirectView( "customer.do?error=2"); 
		}

	}
	/**
	 * android顾客登陆认证
	 * @param username
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/androidloginCustomer", "/android/androidloginCustomer" })
	@ResponseBody
	public String   androidloginCustomer(@RequestParam(defaultValue = "") String username,
			@RequestParam(defaultValue = "") String password,
			HttpServletRequest request) {
/*		if(!checkValidateCode(request)){
//		      return new LoginInfo().failed().msg("验证码错误！");
			return new RedirectView( "customer.do?error=3"); 
		    }*/
	//	System.out.println(request.getRequestURL()getServletPath());
		if(mainUsersSer.checkNameAndPassword(username,password)){
		    username = username.trim();
		    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
			try {
			      Authentication authentication = myProvider.authenticate(authRequest); //调用loadUserByUsername
//			      if(((MyUserDetails)authentication.getPrincipal()).isEnabled()){
				      SecurityContextHolder.getContext().setAuthentication(authentication);
				      HttpSession session = request.getSession();
				      session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext()); // 这个非常重要，否则验证后将无法登陆
				      BbsUser bbsUser=bbsUserSer.findByUserId(((MyUserDetails)authentication.getPrincipal()).getId());
				      session.setAttribute("user", bbsUser);
				      session.setAttribute("MainUserID", ((MyUserDetails)authentication.getPrincipal()).getId());
				      session.setAttribute("userID",bbsUser.getId());
				      return "success";
//			      }else{
//			    	  //账户审核中
//			    		return new RedirectView( "customer.do?error=4"); 
//			      }
		    } catch (AuthenticationException ex) {
//		      return new LoginInfo().failed().msg("用户名或密码错误");
//		      return ("获取权限失败");
		    	//  return "用户名或者密码错误";
		    	  return "wrong";
		    }
		}else{
//			 return ("用户名或密码错误");
			 return "wrong";
		}

	}
	  /**
	   * 验证码判断
	   * @param request
	   * @return
	   */
	  protected boolean checkValidateCode(HttpServletRequest request) {
	        String captcha = request.getParameter("captcha");
	        if (!captcha.equals(getGeneratedKey(request))){
	        	return false;
	        }else{
	        	  return true;
	        }
	         //   throw new RuntimeException("bad captcha");
		  
	  /*  String result_verifyCode = request.getSession().getAttribute("verifyResult").toString(); // 获取存于session的验证值
	     // request.getSession().setAttribute("verifyResult", null);  
	    String user_verifyCode = request.getParameter("verifyCode");// 获取用户输入验证码
	    if (null == user_verifyCode || !result_verifyCode.equalsIgnoreCase(user_verifyCode)) {
	      return false;
	    }
	    return true;*/
	  }
	  
	  @RequestMapping(value = { "/register", "/background/register", "/android/register" }, method = RequestMethod.POST)
		@ResponseBody
		public String   register(@RequestParam("username") String username,@RequestParam( "password") String password,
				HttpServletRequest request) {
		  if(mainUsersSer.findByUsername(username).isEmpty()){
			  MainUsers mainUsers=new MainUsers();
			  mainUsers.setUsername(username);
			  mainUsers.setPassword(password);
			  int id=(Integer) mainUsersSer.save(mainUsers);
			  MainUsersRoles mainUsersRoles=new MainUsersRoles();
			  mainUsersRoles.setUsersId(id);
			  mainUsersRoles.setRolesId(3);
			  mainUsersRolesSer.save(mainUsersRoles);
			  Customers customers=new Customers();
			  customers.setUsername(username);
			  customers.setUserId(id);
			  customersSer.save(customers);
			  return "success"; 
		  }else{
			  return "failed"; //用户已经存在
		  }

		}
	  /**
	   * 商户注册页面
	   * @param username
	   * @param password
	   * @param title
	   * @param phone
	   * @param request
	   * @return
	   */
	  @RequestMapping(value = { "/registerShop","/shop/registerShop"}, method = RequestMethod.POST)
		@ResponseBody
		public RedirectView   registerShop(String username,String password,String title,String phone,HttpServletRequest request) {
		  if(!checkValidateCode(request)){
//		      return new LoginInfo().failed().msg("验证码错误！");
//				 return ("用户名或密码错误");
				return new RedirectView( "shopRegister.do?error=3"); 
		    }
		  if(username==null||password==null||title==null){
			  return new RedirectView( "shopRegister.do?error=2"); 
		  }
		  if(mainUsersSer.findByUsername(username).isEmpty()){
			  MainUsers mu=new MainUsers();
			  mu.setUsername(username);
			  mu.setPassword(password);
			  int id=(Integer) mainUsersSer.save(mu);
			  MainUsersRoles mainUsersRoles=new MainUsersRoles();
			  mainUsersRoles.setUsersId(id);
			  mainUsersRoles.setRolesId(2);//1admin;2shop;3customer
			  mainUsersRolesSer.save(mainUsersRoles);
			  Shops shops=new Shops();
			  shops.setTitle(title);
			  shops.setPhone(phone);
			  shops.setUsersId(id);
			  shopsSer.save(shops);
//			  Customers customers=new Customers();
//			  customers.setUsername(title);
//			  customers.setUserId(id);
//			  customersSer.save(customers);
			  return new RedirectView( "shop.do"); 
		  }else{
			  //return "用户名已经存在"; //用户已经存在
			  return new RedirectView( "shopRegister.do?error=1"); 
		  }

		}
	  //customerRegister.jsp
	  /**
	   * 顾客注册请求
	   * @param username
	   * @param password
	   * @param title
	   * @param phone
	   * @param request
	   * @return
	   */
	  @RequestMapping(value = { "/registerCustomer","/customer/registerCustomer"}, method = RequestMethod.POST)
			@ResponseBody
			public RedirectView   registerCustomer(String username,String password,String title,String phone,HttpServletRequest request) {
			  if(!checkValidateCode(request)){
//			      return new LoginInfo().failed().msg("验证码错误！");
//					 return ("用户名或密码错误");
					return new RedirectView( "customerRegister.do?error=3"); 
			    }
			  if(username==null||password==null||title==null){
				  return new RedirectView( "customerRegister.do?error=2"); 
			  }
			  if(mainUsersSer.findByUsername(username).isEmpty()){
				  MainUsers mu=new MainUsers();
				  mu.setUsername(username);
				  mu.setPassword(password);
				  int id=(Integer) mainUsersSer.save(mu);
				  MainUsersRoles mainUsersRoles=new MainUsersRoles();
				  mainUsersRoles.setUsersId(id);
				  mainUsersRoles.setRolesId(3);//1admin;2shop;3customer
				  mainUsersRolesSer.save(mainUsersRoles);
//				  Shops shops=new Shops();
//				  shops.setTitle(title);
//				  shops.setPhone(phone);
//				  shops.setUsersId(id);
//				  shopsSer.save(shops);
				  Customers customers=new Customers();
				  customers.setUsername(title);
				  customers.setPhone(phone);
				  customers.setUserId(id);
				  customersSer.save(customers);
				  
				  
				  
				  
				  return new RedirectView( "customer.do"); 
			  }else{
				  //return "用户名已经存在"; //用户已经存在
				  return new RedirectView( "customerRegister.do?error=1"); 
			  }

			}
	  /**
	   * 安卓顾客注册请求
	   * @param username
	   * @param password
	   * @param title
	   * @param phone
	   * @param request
	   * @return
	   */
	  @RequestMapping(value = { "android/androidRegisterCustomer"}, method = RequestMethod.POST)
			@ResponseBody
			public Map<String,Object>   androidRegisterCustomer(String username,String password,String title,String phone,HttpServletRequest request) {
			/*
			 *   result_code: 
			 * 0 用户名不存在，可以正常注册
			 * 1  用户名已存在
			 * 2 数据库操作异常
			 * 3 用户名\密码\登录名不能为空
			 * */

		  Map<String,Object> result=new HashMap<String, Object>();
			  if(username==null||password==null||title==null){
				  result.put("result_code", 3);
				  return result;
			  }
			  if(mainUsersSer.findByUsername(username).isEmpty()){
				  MainUsers mu=new MainUsers();
				  mu.setUsername(username);
				  mu.setPassword(password);
				  int id=(Integer) mainUsersSer.save(mu);
				  MainUsersRoles mainUsersRoles=new MainUsersRoles();
				  mainUsersRoles.setUsersId(id);
				  mainUsersRoles.setRolesId(3);//1admin;2shop;3customer
				  mainUsersRolesSer.save(mainUsersRoles);
//				  Shops shops=new Shops();
//				  shops.setTitle(title);
//				  shops.setPhone(phone);
//				  shops.setUsersId(id);
//				  shopsSer.save(shops);
				  Customers customers=new Customers();
				  customers.setUsername(title);
				  customers.setPhone(phone);
				  customers.setUserId(id);
				  customersSer.save(customers);
				  
				  
				  BbsUser bbsUser=new BbsUser();
				  bbsUser.setUsername(customers.getUsername());
				  bbsUser.setMainUsersId(id);
				  bbsUser.setPassword(password);
				  bbsUser.setSex(true);
				  bbsUser.setRegistDate(new Date());
				  bbsUserSer.save(bbsUser);
				  
				  result.put("result_code", 0);
			  }else{
				  //return "用户名已经存在"; //用户已经存在
				  result.put("result_code", 1);
			  }
			  return result;

			}
}
