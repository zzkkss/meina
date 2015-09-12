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
import com.gw.dao.ShopsDao;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Shops;
import com.gw.services.ShopsSer;
@Service("shopsSer")
@Transactional 
public class ShopsSerImpl extends BaseSerImpl<Shops> implements ShopsSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "shopsDao")  
    public void setDao(BaseDao<Shops> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private ShopsDao  shopsDao;
	public List<Shops> shopsListByCoordinate(String center, String leftbttom,
			String righttop) {
		// TODO Auto-generated method 
		return shopsDao.shopsListByCoordinate( center,  leftbttom, righttop) ;
	}
	public Map<String, Object> findByPageAndShoptype(Jqpage jqpage, int shoptype) {
		// TODO Auto-generated method stub
		return shopsDao. findByPageAndShoptype( jqpage,  shoptype);
	}
	public Shops getByUserId(int userId) {
		// TODO Auto-generated method stub
		return shopsDao.getByUserId(userId);
	}
	public List<Shops> shopsListBySearch(String keyWords) {
		// TODO Auto-generated method stub
		return shopsDao.shopsListBySearch( keyWords);
	}
	@Deprecated
	public Map<String, Object> shopsListBydistanceAndCityCode(Jqpage jqpage, int cityCode) {
		// TODO Auto-generated method stub
		return shopsDao.findBydistanceAndCityCode( jqpage,  cityCode);
	}
	
	public Map<String, Object> shopsListBydistanceAndType(Jqpage jqpage, int type) {
		// TODO Auto-generated method stub
		return shopsDao.findBydistanceAndType( jqpage,  type);
	}
	public Map<String, Object> shopsListBydistanceAndCityCode(Jqpage jqpage, Integer id, String coordinate) {
		// TODO Auto-generated method stub
		return shopsDao.findBydistanceAndCityCode( jqpage,  id,coordinate);
	}
	public List<Shops> shopsListByCoordinateAndCityCode(String center, String leftbttom, String righttop, Integer id) {
		// TODO Auto-generated method stub
		return shopsDao.shopsListByCoordinateAndCityCode( center,  leftbttom, righttop,id) ;
	}
}
