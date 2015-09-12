package com.gw.services.impl;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.AdminInfoDao;
import com.gw.dao.BaseDao;
import com.gw.dao.ImagesDao;
import com.gw.dao.MessagesDao;
import com.gw.model.AdminInfo;
import com.gw.model.Images;
import com.gw.model.Messages;
import com.gw.services.AdminInfoSer;
import com.gw.services.ImagesSer;
import com.gw.services.MessagesSer;
@Service("messagesSer")
@Transactional 
public class MessagesSerImpl extends BaseSerImpl<Messages> implements MessagesSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "messagesDao")  
    public void setDao(BaseDao<Messages> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private MessagesDao	messagesDao;
}
