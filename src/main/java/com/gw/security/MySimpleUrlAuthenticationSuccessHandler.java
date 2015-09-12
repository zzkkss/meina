package com.gw.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.thoughtworks.xstream.InitializationException;


public class MySimpleUrlAuthenticationSuccessHandler implements  AuthenticationSuccessHandler,InitializingBean{  
    
  protected Logger logger = LoggerFactory.getLogger(this.getClass());  
    
  private String defaultTargetUrl;  
    
  private boolean forwardToDestination = false;  
    
  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();  
    
//  @Autowired  
//  private SysUsersRepository sysUsersRepository;  
    
  /* (non-Javadoc) 
   * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication) 
   */  
  @Transactional(readOnly=false,propagation= Propagation.REQUIRED,rollbackFor={Exception.class})  
  public void onAuthenticationSuccess(HttpServletRequest request,  
          HttpServletResponse response, Authentication authentication)  
          throws IOException, ServletException {  
        
      this.saveLoginInfo(request, authentication);  
        
      if(this.forwardToDestination){  
          logger.info("Login success,Forwarding to "+this.defaultTargetUrl);  
            
          request.getRequestDispatcher(this.defaultTargetUrl).forward(request, response);  
      }else{  
          logger.info("Login success,Redirecting to "+this.defaultTargetUrl);  
            
          this.redirectStrategy.sendRedirect(request, response, this.defaultTargetUrl);  
      }  
  }  
    
  @Transactional(readOnly=false,propagation= Propagation.REQUIRED,rollbackFor={Exception.class})  
  public void saveLoginInfo(HttpServletRequest request,Authentication authentication){  
  /*    SysUsers user = (SysUsers)authentication.getPrincipal();  
      try {  
          String ip = this.getIpAddress(request);  
          Date date = new Date();  
          user.setLastLogin(date);  
          user.setLoginIp(ip);  
          this.sysUsersRepository.saveAndFlush(user);  
      } catch (DataAccessException e) {  
          if(logger.isWarnEnabled()){  
              logger.info("无法更新用户登录信息至数据库");  
          }  
      }  */
  }  
    
  public String getIpAddress(HttpServletRequest request){    
      String ip = request.getHeader("x-forwarded-for");    
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
          ip = request.getHeader("Proxy-Client-IP");    
      }    
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
          ip = request.getHeader("WL-Proxy-Client-IP");    
      }    
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
          ip = request.getHeader("HTTP_CLIENT_IP");    
      }    
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
          ip = request.getHeader("HTTP_X_FORWARDED_FOR");    
      }    
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
          ip = request.getRemoteAddr();    
      }    
      return ip;    
  }  

  public void setDefaultTargetUrl(String defaultTargetUrl) {  
      this.defaultTargetUrl = defaultTargetUrl;  
  }  

  public void setForwardToDestination(boolean forwardToDestination) {  
      this.forwardToDestination = forwardToDestination;  
  }  

  /* (non-Javadoc) 
   * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet() 
   */  
  public void afterPropertiesSet() throws Exception {  
      if(StringUtils.isEmpty(defaultTargetUrl))  
          throw new InitializationException("You must configure defaultTargetUrl");  
        
  }    
    
}  