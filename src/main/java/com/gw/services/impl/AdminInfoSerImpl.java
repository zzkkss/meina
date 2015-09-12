package com.gw.services.impl;



import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.BaseDao;
import com.gw.dao.ImagesDao;
import com.gw.model.Images;
import com.gw.services.ImagesSer;
@Service("imagesSer")
@Transactional 
public class AdminInfoSerImpl extends BaseSerImpl<Images> implements ImagesSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "imagesDao")  
    public void setDao(BaseDao<Images> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private ImagesDao  imagesDao;
}
