package com.gw.services.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.BaseDao;
import com.gw.dao.MainRolesDao;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainRoles;
import com.gw.model.MainUsersRoles;
import com.gw.services.MainRolesSer;
@Service("mainRolesSer")
@Transactional 
public class MainRolesSerImpl extends BaseSerImpl<MainRoles> implements MainRolesSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "mainRolesDao")  
    public void setDao(BaseDao<MainRoles> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private MainRolesDao mainRolesDao;
	public Map<String, Object> findByPage(Jqpage jqpage, String... strings) {
		// TODO Auto-generated method stub
		return mainRolesDao.getByPage(jqpage, strings);
	}
	public Map<String, Object> getByJgridType(JqgridPage jqgridPage, String type) {
		// TODO Auto-generated method stub
		return mainRolesDao.getByJgridType(jqgridPage, type);
	}
	public List<MainRoles> lastUser(int num) {
		// TODO Auto-generated method stub
		return 	mainRolesDao.lastUser(num);
		}
	public List<MainRoles> findByMainUsersRoles(
			List<MainUsersRoles> mainUsersRoles) {
		// TODO Auto-generated method stub
		 List<MainRoles> mmm=new ArrayList<MainRoles>();
		for(MainUsersRoles m:mainUsersRoles){
			List<MainRoles> m2=mainRolesDao.findByMainUsersRoles(m);
			mmm.addAll(m2);
		}
		return mmm;
	}
  
}
