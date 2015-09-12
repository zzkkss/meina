package com.gw.services.impl;



import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.BaseDao;
import com.gw.dao.CollectCouponsDao;
import com.gw.dao.CollectShopsDao;
import com.gw.dao.ImagesDao;
import com.gw.model.CollectCoupons;
import com.gw.model.CollectShops;
import com.gw.model.Images;
import com.gw.model.Jqpage;
import com.gw.services.CollectCouponsSer;
import com.gw.services.CollectShopsSer;
import com.gw.services.ImagesSer;
@Service("collectCouponsSer")
@Transactional 
public class CollectCouponsSerImpl extends BaseSerImpl<CollectCoupons> implements CollectCouponsSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "collectCouponsDao")  
    public void setDao(BaseDao<CollectCoupons> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private CollectCouponsDao  collectCouponsDao;
	public CollectCoupons findByUserIdAndCouponId(CollectCoupons collectCoupons) {
		// TODO Auto-generated method stub
		return collectCouponsDao.findByUserIdAndCouponId(collectCoupons);
	}
	public Map<String, Object> findByJqpageAndUserId(Jqpage jqpage, int id) {
		// TODO Auto-generated method stub
		return collectCouponsDao.findByJqpageAndUserId( jqpage,  id);
	}
}
