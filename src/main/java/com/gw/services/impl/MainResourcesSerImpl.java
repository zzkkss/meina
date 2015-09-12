package com.gw.services.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.BaseDao;
import com.gw.dao.MainResourcesDao;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainResources;
import com.gw.services.MainResourcesSer;
@Service("mainResourcesSer")
@Transactional 
public class MainResourcesSerImpl extends BaseSerImpl<MainResources> implements MainResourcesSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "mainResourcesDao")  
    public void setDao(BaseDao<MainResources> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private MainResourcesDao mainResourcesDao;
	public Map<String, Object> findByPage(Jqpage jqpage, String... strings) {
		// TODO Auto-generated method stub
		return mainResourcesDao.getByPage(jqpage, strings);
	}
	public Map<String, Object> getByJgridType(JqgridPage jqgridPage, String type) {
		// TODO Auto-generated method stub
		return mainResourcesDao.getByJgridType(jqgridPage, type);
	}
	public List<MainResources> lastUser(int num) {
		// TODO Auto-generated method stub
		return 	mainResourcesDao.lastUser(num);
		}
	public List<MainResources> getByUnionid(String unionid) {
		// TODO Auto-generated method stub
		return null;
	}  
  
}
