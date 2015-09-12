package com.gw.security;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * 
 * @author tingfeng
 * 剩下的就是最终的决策了，make a decision，其实也很容易，呵呵。
 *在这个类中，最重要的是decide方法，如果不存在对该资源的定义，直接放行；
 *否则，如果找到正确的角色，即认为拥有权限，并放行，
 *否则throw new AccessDeniedException("no right");
 *这样，就会进入上面提到的403.jsp页面//找到了需要访问的路径权限后
 */
public class MyAccessDecisionManager implements AccessDecisionManager {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
		logger.info("当前调用的"+this.getClass().getName());
		if(configAttributes == null) {
			return;
		}
		//所请求的资源拥有的权限(一个资源对多个权限)
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();
		
		while(iterator.hasNext()) {
			ConfigAttribute configAttribute = iterator.next();
			//访问所请求资源所需要的权限
			String needPermission = configAttribute.getAttribute();
			logger.info("needPermission is " + needPermission);
			//用户所拥有的权限authentication
			for(GrantedAuthority ga : authentication.getAuthorities()) {
				if(needPermission.equals(ga.getAuthority())) {
					logger.info("findPermission is " + ga.getAuthority());
					return;
				}
			}
		}
		//没有权限
		logger.info("没有权限访问 is ");
		throw new AccessDeniedException(" 没有权限访问！ ");
	}

	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}
	
} 