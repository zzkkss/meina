package com.gw.services.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.BaseDao;
import com.gw.dao.MainAuthoritiesResourcesDao;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainAuthorities;
import com.gw.model.MainAuthoritiesResources;
import com.gw.model.MainResources;
import com.gw.services.MainAuthoritiesResourcesSer;
@Service("mainAuthoritiesResourcesSer")
@Transactional 
public class MainAuthoritiesResourcesSerImpl extends BaseSerImpl<MainAuthoritiesResources> implements MainAuthoritiesResourcesSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "mainAuthoritiesResourcesDao")  
    public void setDao(BaseDao<MainAuthoritiesResources> dao) {  
        super.setDao(dao);  
    }
@Autowired
private MainAuthoritiesResourcesDao mainAuthoritiesResourcesDao;
	public List<MainAuthoritiesResources> findByAuthorities(
			MainAuthorities mainAuthorities) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<MainAuthoritiesResources> findByResources(MainResources mr) {
		// TODO Auto-generated method stub
		return mainAuthoritiesResourcesDao.findByResources( mr) ;
	}
   
  
}
