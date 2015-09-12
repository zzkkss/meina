package com.gw.services.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.WeixinUserDao;
import com.gw.dao.BaseDao;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.WeixinUser;
import com.gw.services.WeixinUserSer;
@Service("weixinUserSer")
@Transactional 
public class WeixinUserSerImpl extends BaseSerImpl<WeixinUser> implements WeixinUserSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "weixinUserDao")  
    public void setDao(BaseDao<WeixinUser> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private WeixinUserDao hquserDao;
	public Map<String, Object> findByPage(Jqpage jqpage, String... strings) {
		// TODO Auto-generated method stub
		return hquserDao.getByPage(jqpage, strings);
	}
	public Map<String, Object> getByJgridType(JqgridPage jqgridPage, String type) {
		// TODO Auto-generated method stub
		return hquserDao.getByJgridType(jqgridPage, type);
	}
	public List<WeixinUser> lastUser(int num) {
		// TODO Auto-generated method stub
		return 	hquserDao.lastUser(num);
		}
	public List<WeixinUser> getByUnionid(String unionid) {
		// TODO Auto-generated method stub
		return hquserDao.getByUnionid(unionid);
	}  
  
}
