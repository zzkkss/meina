package com.gw.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/*
 * 最核心的代码就是invoke方法中的InterceptorStatusToken token = super.beforeInvocation(fi);
 * 这一句，即在执行doFilter之前，进行权限的检查，而具体的实现已经交给accessDecisionManager了。
 */
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor  
implements Filter {  

private FilterInvocationSecurityMetadataSource securityMetadataSource;  
Logger logger=LoggerFactory.getLogger(this.getClass());
/** 
* Method that is actually called by the filter chain. Simply delegates to 
* the {@link #invoke(FilterInvocation)} method. 
* @param chain the filter chain 
* @throws IOException if the filter chain fails 
* @throws ServletException  if the filter chain fails 
*/  
public void doFilter(ServletRequest request, ServletResponse response,  
     FilterChain chain) throws IOException, ServletException {  
	logger.info("当前调用的"+this.getClass().getName());
	
 FilterInvocation fi = new FilterInvocation(request, response, chain);  
 invoke(fi);  
 
}  

public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {  
return this.securityMetadataSource;  
}  

public Class<? extends Object> getSecureObjectClass() {  
return FilterInvocation.class;  
}  

public void invoke(FilterInvocation fi) throws IOException,  
     ServletException {  
 InterceptorStatusToken token = super.beforeInvocation(fi);  
try {  
     fi.getChain().doFilter(fi.getRequest(), fi.getResponse());  
 } finally {  
    super.afterInvocation(token, null);  
 }  
}  

public SecurityMetadataSource obtainSecurityMetadataSource() {  
return this.securityMetadataSource;  
}  

public void setSecurityMetadataSource(  
     FilterInvocationSecurityMetadataSource newSource) {  
this.securityMetadataSource = newSource;  
}  

public void destroy() {  
}  

public void init(FilterConfig arg0) throws ServletException {  
}  

}  