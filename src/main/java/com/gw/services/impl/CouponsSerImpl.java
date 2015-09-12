package com.gw.services.impl;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.BaseDao;
import com.gw.dao.CouponsDao;
import com.gw.model.Coupons;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.services.CouponsSer;
@Service("couponsSer")
@Transactional 
public class CouponsSerImpl extends BaseSerImpl<Coupons> implements CouponsSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "couponsDao")  
    public void setDao(BaseDao<Coupons> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private CouponsDao  couponsDao;
	public Map<String, Object> findByJqgridAndShopId(JqgridPage jqgridPage,
			int shopid) {
		// TODO Auto-generated method stub
		return couponsDao.findByJqgridAndShopId( jqgridPage, shopid) ;
	}
	public Map<String, Object> findByPageAndShopid(Jqpage jqpage, int shopid) {
		// TODO Auto-generated method stub
		return couponsDao.findByPageAndShopid( jqpage,  shopid);
	}
}
