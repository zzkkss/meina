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
import com.gw.dao.MainUsersRolesDao;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainUsers;
import com.gw.model.MainUsersRoles;
import com.gw.services.MainUsersRolesSer;
@Service("mainUsersRolesSer")
@Transactional 
public class MainUsersRolesSerImpl extends BaseSerImpl<MainUsersRoles> implements MainUsersRolesSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "mainUsersRolesDao")  
    public void setDao(BaseDao<MainUsersRoles> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private MainUsersRolesDao mainUsersDao;
	public Map<String, Object> findByPage(Jqpage jqpage, String... strings) {
		// TODO Auto-generated method stub
		return mainUsersDao.getByPage(jqpage, strings);
	}
	public Map<String, Object> getByJgridType(JqgridPage jqgridPage, String type) {
		// TODO Auto-generated method stub
		return mainUsersDao.getByJgridType(jqgridPage, type);
	}
	public List<MainUsersRoles> lastUser(int num) {
		// TODO Auto-generated method stub
		return 	mainUsersDao.lastUser(num);
		}
	public List<MainUsersRoles> getByUnionid(String unionid) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPasswordByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<MainUsersRoles> findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<MainUsersRoles> findByUsers(MainUsers authority) {
		// TODO Auto-generated method stub
		return mainUsersDao.findByUsers( authority);
	}
  
}
