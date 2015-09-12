package com.gw.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class WeixinProvider implements AuthenticationProvider{
	private Logger logger=LoggerFactory.getLogger(WeixinProvider.class);
	WeixinUserDetailService userDetailService=new WeixinUserDetailService("weixin");
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		logger.info("user name: "+authentication.getName());
        //password
		logger.info("password: "+authentication.getCredentials());
		logger.info("getPrincipal: "+authentication.getPrincipal());
		logger.info("getAuthorities: "+authentication.getAuthorities());
		logger.info("getDetails: "+authentication.getDetails());
        UserDetails userDetails = (UserDetails)this.userDetailService.loadUserByUsername(authentication.getName());
        
        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
                userDetails, authentication.getCredentials(),userDetails.getAuthorities());
		return result;
	}

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
