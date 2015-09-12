package com.gw.services.impl;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.BaseDao;
import com.gw.dao.ImagesDao;
import com.gw.dao.ShopsHotDao;
import com.gw.model.Images;
import com.gw.model.ShopsHot;
import com.gw.services.ImagesSer;
import com.gw.services.ShopsHotSer;
@Service("shopsHotSer")
@Transactional 
public class ShopsHotSerImpl extends BaseSerImpl<ShopsHot> implements ShopsHotSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "shopsHotDao")  
    public void setDao(BaseDao<ShopsHot> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private ShopsHotDao shopsHotDao;
	public List<ShopsHot> getByCityCode(int cityCode) {
		// TODO Auto-generated method stub
		return shopsHotDao.getByCityCode( cityCode) ;
	}
	public ShopsHot getByShopsId(int id) {
		// TODO Auto-generated method stub
		return shopsHotDao.getByShopsId( id) ;
	}
}
