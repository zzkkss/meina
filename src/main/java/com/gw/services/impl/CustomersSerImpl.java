package com.gw.services.impl;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.BaseDao;
import com.gw.dao.CustomersDao;
import com.gw.model.Customers;
import com.gw.services.CustomersSer;
@Service("customersSer")
@Transactional 
public class CustomersSerImpl extends BaseSerImpl<Customers> implements CustomersSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "customersDao")  
    public void setDao(BaseDao<Customers> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private CustomersDao  customersDao;
	public Customers getByUserId(Integer id) {
		// TODO Auto-generated method stub
		return customersDao.getbyUserId(id);
	}
}
