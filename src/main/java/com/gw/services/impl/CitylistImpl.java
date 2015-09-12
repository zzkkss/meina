package com.gw.services.impl;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.BaseDao;
import com.gw.dao.CitylistDao;
import com.gw.model.Citylist;
import com.gw.services.CitylistSer;
import com.gw.services.ImagesSer;
@Service("citylistSer")
@Transactional 
public class CitylistImpl extends BaseSerImpl<Citylist> implements CitylistSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "citylistDao")  
    public void setDao(BaseDao<Citylist> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private CitylistDao  citylistDao;
	public List<Citylist> findByParentId(int id) {
		// TODO Auto-generated method stub
		return citylistDao. findByParentId( id) ;
	}
	public Citylist findByCitycode(int code) {
		// TODO Auto-generated method stub
		return citylistDao.findByCitycode( code) ;
	}
	public Citylist findByName(String name) {
		// TODO Auto-generated method stub
		return citylistDao.findByName( name) ;
	}
}
