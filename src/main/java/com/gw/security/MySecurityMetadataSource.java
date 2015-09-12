package com.gw.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.gw.dao.MainAuthoritiesDao;
import com.gw.dao.MainAuthoritiesResourcesDao;
import com.gw.dao.MainResourcesDao;
import com.gw.model.MainAuthorities;
import com.gw.model.MainAuthoritiesResources;
import com.gw.model.MainResources;
import com.gw.services.MainAuthoritiesResourcesSer;
import com.gw.services.MainAuthoritiesSer;
import com.gw.services.MainResourcesSer;

/**
 * 对于资源的访问权限的定义，我们通过实现FilterInvocationSecurityMetadataSource这个接口来初始化数据。
 * 看看loadResourceDefine方法，我在这里，假定index.jsp和i.jsp这两个资源，需要ROLE_ADMIN角色的用户才能访问。
这个类中，还有一个最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。
注意，我例子中使用的是AntUrlPathMatcher这个path matcher来检查URL是否与资源定义匹配，
事实上你还要用正则的方式来匹配，或者自己实现一个matcher。
 */
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {  
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;  
    Logger logger=LoggerFactory.getLogger(this.getClass());
//    public MySecurityMetadataSource() {  
//         loadResourceDefine();  
//     }  

    //由spring调用  
    private MainResourcesDao mainResourcesDao;
    private MainAuthoritiesResourcesDao mainAuthoritiesResourcesDao;
    private MainAuthoritiesDao mainAuthoritiesDao;
    public MySecurityMetadataSource(MainResourcesDao mainResourcesDao,MainAuthoritiesResourcesDao mainAuthoritiesResourcesDao,MainAuthoritiesDao mainAuthoritiesDao) {  
        this.mainResourcesDao = mainResourcesDao;  
        this.mainAuthoritiesResourcesDao = mainAuthoritiesResourcesDao;  
        this.mainAuthoritiesDao = mainAuthoritiesDao;  
        loadResourceDefine();  
    }  
    private void loadResourceDefine() {  //开始时加载全部资源。
    	 logger.info("当前调用的"+this.getClass().getName());
         resourceMap = new HashMap<String, Collection<ConfigAttribute>>();  
       
//     	WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
//     	WebApplicationContext wac = (WebApplicationContext) new ClassPathXmlApplicationContext( "classpath:applicationContext.xml");
//     	MainResourcesSer mainResourcesSer=wac.getBean(MainResourcesSer.class);
//     	MainAuthoritiesResourcesSer mainAuthoritiesResourcesSer=wac.getBean(MainAuthoritiesResourcesSer.class);
//     	MainAuthoritiesSer mainAuthoritiesSer=wac.getBean(MainAuthoritiesSer.class);
     	List<MainResources> mainResources=mainResourcesDao.findAll();
     	for(MainResources mr:mainResources){
     		List<MainAuthoritiesResources> mars=mainAuthoritiesResourcesDao.findByResources(mr);
     		for(MainAuthoritiesResources mar:mars){
     			MainAuthorities mainAuthorities=mainAuthoritiesDao.findByMainAuthoritiesResources(mar);
     			  Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();  
     	         ConfigAttribute ca = new SecurityConfig(mainAuthorities.getName());  
     	         atts.add(ca);  
     			resourceMap.put(mr.getUrl(), atts);
     			logger.info("发现权限"+mr.getUrl()+"   "+mainAuthorities.getName());
     		}
     	}
//		WeixinUserSer weixinUserSer=wac.getBean(WeixinUserSer.class);
//		List<WeixinUser> arts=weixinUserSer.getByUnionid(unionid);
     	
//         resourceMap.put("/index.jsp", atts);
//         resourceMap.put("/admintest.jsp",atts);
         
//         Collection<ConfigAttribute> atts2 = new ArrayList<ConfigAttribute>();
//         ConfigAttribute ca2 = new SecurityConfig("ROLE_USER");
//         //resourceMap.put("/index.jsp", atts2);
//         resourceMap.put("/usertest.jsp", atts2);
     }  
  
    // According to a URL, Find out permission configuration of this URL.  访问时使用的方法
    public Collection<ConfigAttribute> getAttributes(Object object)  
            throws IllegalArgumentException {  
    	logger.info("当前调用的"+this.getClass().getName());
    	
    	FilterInvocation filterInvocation = (FilterInvocation) object;
        // guess object is a URL.根据请求的url找到其需要的相应的权限  
//         String url = ((FilterInvocation)object).getRequestUrl();  
         HttpServletRequest url = ((FilterInvocation)object).getRequest();  
         Iterator<String> ite = resourceMap.keySet().iterator();  
        while (ite.hasNext()) {  
             String resURL = ite.next();  
//             UrlMatcher urlMatcher = new AntUrlPathMatcher();
             RequestMatcher requestMatcher = new AntPathRequestMatcher(resURL);
             if(requestMatcher.matches(url)) {
//             if(requestMatcher.(url)) {
                 return resourceMap.get(resURL);
             }
         }  
        return null;  
     }  
  
    public boolean supports(Class<?> clazz) {  
        return true;  
     }  
      
    public Collection<ConfigAttribute> getAllConfigAttributes() {  
        return null;  
     }  
  
}  
