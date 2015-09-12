package com.gw.services.impl;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.AdminInfoDao;
import com.gw.dao.BaseDao;
import com.gw.dao.ImagesDao;
import com.gw.model.AdminInfo;
import com.gw.model.Images;
import com.gw.services.AdminInfoSer;
import com.gw.services.ImagesSer;
@Service("adminInfoSer")
@Transactional 
public class ImagesSerImpl extends BaseSerImpl<AdminInfo> implements AdminInfoSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "adminInfoDao")  
    public void setDao(BaseDao<AdminInfo> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private AdminInfoDao	adminInfoDao;
}
