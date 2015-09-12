package com.gw.services;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainUsers;
import com.gw.model.MainUsersRoles;


public interface MainUsersRolesSer extends BaseSer<MainUsersRoles> {

	List<MainUsersRoles> lastUser(int num);
public List<MainUsersRoles> findByUsername(String username);
	public Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
	  public Map<String,Object>  findByPage(Jqpage jqpage,String...strings );

	public List<MainUsersRoles> getByUnionid(String unionid);


	String getPasswordByUsername(String username);
	List<MainUsersRoles> findByUsers(MainUsers authority);

}
