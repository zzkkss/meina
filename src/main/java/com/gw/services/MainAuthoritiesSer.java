package com.gw.services;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainAuthorities;
import com.gw.model.MainAuthoritiesResources;
import com.gw.model.MainRolesAuthorities;


public interface MainAuthoritiesSer extends BaseSer<MainAuthorities> {

	List<MainAuthorities> lastUser(int num);

	public Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
	  public Map<String,Object>  findByPage(Jqpage jqpage,String...strings );


	List<MainAuthorities> findByRoles(MainRolesAuthorities mainRolesAuthorities2);

	MainAuthorities findByMainAuthoritiesResources(MainAuthoritiesResources mar);

	List<MainAuthorities> findByMainRolesAuthorities(
			List<MainRolesAuthorities> mra);
}
