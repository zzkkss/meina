package com.gw.services.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.BaseDao;
import com.gw.dao.BbsUserDao;
import com.gw.model.BbsUser;
import com.gw.services.BbsUserSer;
@Service("bbsUserSer")
@Transactional 
public class BbsUserSerImpl extends BaseSerImpl<BbsUser> implements BbsUserSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "bbsUserDao")  
    public void setDao(BaseDao<BbsUser> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private BbsUserDao  bbsUserDao;
	public BbsUser findByUserId(int id) {
		// TODO Auto-generated method stub
		return bbsUserDao.findByUserId( id);
	}
}
