package com.gw.services.impl;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.gw.dao.BaseDao;
import com.gw.dao.MainUsersDao;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainAuthorities;
import com.gw.model.MainRoles;
import com.gw.model.MainRolesAuthorities;
import com.gw.model.MainUsers;
import com.gw.model.MainUsersRoles;
import com.gw.services.MainAuthoritiesSer;
import com.gw.services.MainRolesAuthoritiesSer;
import com.gw.services.MainRolesSer;
import com.gw.services.MainUsersRolesSer;
import com.gw.services.MainUsersSer;
import com.gw.services.WeixinUserSer;
@Service("mainUsersSer")
@Transactional 
public class MainUsersSerImpl extends BaseSerImpl<MainUsers> implements MainUsersSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "mainUsersDao")  
    public void setDao(BaseDao<MainUsers> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private MainUsersDao mainUsersDao;
	public Map<String, Object> findByPage(Jqpage jqpage, String... strings) {
		// TODO Auto-generated method stub
		return mainUsersDao.getByPage(jqpage, strings);
	}
	public Map<String, Object> getByJgridType(JqgridPage jqgridPage, String type) {
		// TODO Auto-generated method stub
		return mainUsersDao.getByJgridType(jqgridPage, type);
	}
	public List<MainUsers> lastUser(int num) {
		// TODO Auto-generated method stub
		return 	mainUsersDao.lastUser(num);
		}
	public List<MainUsers> getByUnionid(String unionid) {
		// TODO Auto-generated method stub
		return null;
	}
	public Collection<GrantedAuthority> loadUserAuthoritiesByName(String username) {
		// TODO Auto-generated method stub
		  List<MainUsers> list = this.findByUsername(username);  
          
	        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();  
	          
	        for (MainUsers authority : list) {  //找到用户
	        	WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
	        	MainUsersRolesSer mainUsersRolesSer=wac.getBean(MainUsersRolesSer.class);
	        	List<MainUsersRoles> mainUsersRoles=mainUsersRolesSer.findByUsers(authority);//根据USER获取ROLE；
	        	for(MainUsersRoles mainUsersRoles2:mainUsersRoles){//根据ROLE获取Authorities
		        	MainRolesAuthoritiesSer mainRolesAuthoritiesSer=wac.getBean(MainRolesAuthoritiesSer.class);
		        	List<MainRolesAuthorities> mainRolesAuthorities=mainRolesAuthoritiesSer.findByRoles(mainUsersRoles2);//根据USER获取ROLE；
		        	for(MainRolesAuthorities mainRolesAuthorities2:mainRolesAuthorities){//权限加入列表
		        		MainAuthoritiesSer mainAuthoritiesSer=wac.getBean(MainAuthoritiesSer.class);
			        	List<MainAuthorities> mainAuthorities=mainAuthoritiesSer.findByRoles(mainRolesAuthorities2);//根据RolesAuthorities获取Authorities；
			        	for(MainAuthorities mainAuthorities2:mainAuthorities){
			        		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(mainAuthorities2.getName());  
				            auths.add(grantedAuthority);  
			        	}
		              
		        	}
		  
	        	}
	        	
	            
	        }  
	  
	        return auths;  
	}
	public String getPasswordByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<MainUsers> findByUsername(String username) {
		// TODO Auto-generated method stub
		return mainUsersDao.findByUsername( username);
	}
	public boolean checkNameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return mainUsersDao.checkNameAndPassword( username,  password);
	}  
  
}
