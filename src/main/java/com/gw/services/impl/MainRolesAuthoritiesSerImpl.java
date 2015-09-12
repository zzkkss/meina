package com.gw.services.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.BaseDao;
import com.gw.dao.MainRolesAuthoritiesDao;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainRoles;
import com.gw.model.MainRolesAuthorities;
import com.gw.model.MainUsersRoles;
import com.gw.services.MainRolesAuthoritiesSer;
@Service("mainRolesAuthorities")
@Transactional 
public class MainRolesAuthoritiesSerImpl extends BaseSerImpl<MainRolesAuthorities> implements MainRolesAuthoritiesSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "mainRolesAuthoritiesDao")  
    public void setDao(BaseDao<MainRolesAuthorities> dao) {  
        super.setDao(dao);  
    }
@Autowired
private MainRolesAuthoritiesDao mainRolesAuthoritiesDao;
	public List<MainRolesAuthorities> findByRoles(MainUsersRoles mainUsersRoles2) {
		// TODO Auto-generated method stub
		return  mainRolesAuthoritiesDao.findByRoles( mainUsersRoles2) ;
	}
	public List<MainRolesAuthorities> findByMainRoles(List<MainRoles> mainRoles) {
		// TODO Auto-generated method stub
//		return null;
		List<MainRolesAuthorities> list=new ArrayList<MainRolesAuthorities>();
		for(MainRoles m:mainRoles){
			list.addAll(mainRolesAuthoritiesDao.findByMainRoles( m) );
		}
		return  list;
	}
	public List<MainRolesAuthorities> findByMainUsersRoles(
			List<MainUsersRoles> mainUsersRoles) {
		// TODO Auto-generated method stub
		List<MainRolesAuthorities> list=new ArrayList<MainRolesAuthorities>();
		for(MainUsersRoles m:mainUsersRoles){
			List<MainRolesAuthorities> l=mainRolesAuthoritiesDao.findByMainUsersRoles(m);
			list.addAll(l);
		}
		return  list;
	}
   
  
}
