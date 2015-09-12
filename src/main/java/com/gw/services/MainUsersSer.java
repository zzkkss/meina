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


public interface MainUsersSer extends BaseSer<MainUsers> {

	List<MainUsers> lastUser(int num);
public List<MainUsers> findByUsername(String username);
	public Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
	  public Map<String,Object>  findByPage(Jqpage jqpage,String...strings );

	public List<MainUsers> getByUnionid(String unionid);

	Collection<GrantedAuthority> loadUserAuthoritiesByName(String username);

	String getPasswordByUsername(String username);
	boolean checkNameAndPassword(String username, String password);

}
