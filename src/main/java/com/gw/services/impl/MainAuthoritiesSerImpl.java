package com.gw.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.BaseDao;
import com.gw.dao.MainAuthoritiesDao;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainAuthorities;
import com.gw.model.MainAuthoritiesResources;
import com.gw.model.MainRolesAuthorities;
import com.gw.services.MainAuthoritiesSer;
@Service("mainAuthoritiesSer")
@Transactional
public class MainAuthoritiesSerImpl extends BaseSerImpl<MainAuthorities>
		implements MainAuthoritiesSer {
	/**
	 * 注入DAO
	 */
	@Resource(name = "mainAuthoritiesDao")
	public void setDao(BaseDao<MainAuthorities> dao) {
		super.setDao(dao);
	}

	@Autowired
	private MainAuthoritiesDao mainUsersDao;

	public Map<String, Object> findByPage(Jqpage jqpage, String... strings) {
		// TODO Auto-generated method stub
		return mainUsersDao.getByPage(jqpage, strings);
	}

	public Map<String, Object> getByJgridType(JqgridPage jqgridPage, String type) {
		// TODO Auto-generated method stub
		return mainUsersDao.getByJgridType(jqgridPage, type);
	}

	public List<MainAuthorities> lastUser(int num) {
		// TODO Auto-generated method stub
		return mainUsersDao.lastUser(num);
	}

	public List<MainAuthorities> findByRoles(
			MainRolesAuthorities mainRolesAuthorities2) {
		// TODO Auto-generated method stub
		return mainUsersDao.findByRoles(mainRolesAuthorities2);
	}

	public MainAuthorities findByMainAuthoritiesResources(
			MainAuthoritiesResources mar) {
		// TODO Auto-generated method stub
		return mainUsersDao. findByMainAuthoritiesResources( mar);
	}

	public List<MainAuthorities> findByMainRolesAuthorities(
			List<MainRolesAuthorities> mra) {
		// TODO Auto-generated method stub
		 List<MainAuthorities> list=new ArrayList<MainAuthorities>();
		 for(MainRolesAuthorities m:mra){
			 List<MainAuthorities> l=mainUsersDao.findByMainRolesAuthorities(m);
			 list.addAll(l);
		 }
		return list;
	}

}
