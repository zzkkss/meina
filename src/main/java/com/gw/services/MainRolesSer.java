package com.gw.services;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainRoles;
import com.gw.model.MainUsersRoles;


public interface MainRolesSer extends BaseSer<MainRoles> {

	List<MainRoles> lastUser(int num);

	public Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
	  public Map<String,Object>  findByPage(Jqpage jqpage,String...strings );

	List<MainRoles> findByMainUsersRoles(List<MainUsersRoles> mainUsersRoles);

}
