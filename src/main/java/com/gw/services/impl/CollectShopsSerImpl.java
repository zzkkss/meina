package com.gw.services.impl;



import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.BaseDao;
import com.gw.dao.CollectShopsDao;
import com.gw.dao.ImagesDao;
import com.gw.model.CollectShops;
import com.gw.model.Images;
import com.gw.model.Jqpage;
import com.gw.services.CollectShopsSer;
import com.gw.services.ImagesSer;
@Service("collectShopsSer")
@Transactional 
public class CollectShopsSerImpl extends BaseSerImpl<CollectShops> implements CollectShopsSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "collectShopsDao")  
    public void setDao(BaseDao<CollectShops> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private CollectShopsDao  collectShopsDao;
	public CollectShops findByUserIdAndShopsId(CollectShops collectShops) {
		// TODO Auto-generated method stub
		return collectShopsDao.findByUserIdAndShopsId( collectShops);
	}
	public Map<String, Object> findByJqpageAndUserId(Jqpage jqpage, int id) {
		// TODO Auto-generated method stub
		return collectShopsDao.findByJqpageAndUserId( jqpage, id);
	}
}
