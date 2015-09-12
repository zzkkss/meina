package com.gw.services.impl;



import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gw.dao.BaseDao;
import com.gw.dao.OrdersDao;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Orders;
import com.gw.services.OrdersSer;
@Service("ordersSer")
@Transactional 
public class OrdersSerImpl extends BaseSerImpl<Orders> implements OrdersSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "ordersDao")  
    public void setDao(BaseDao<Orders> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private OrdersDao  ordersDao;
	public Map<String, Object> findByJqgridAndShopId(JqgridPage jqgridPage,
			int userid) {
		// TODO Auto-generated method stub
		return ordersDao.findByJqgridAndShopId( jqgridPage, userid);
	}
	public Map<String, Object> findByJqgridAndUserId(JqgridPage jqgridPage,
			int userid) {
		// TODO Auto-generated method stub
		return ordersDao.findByJqgridAndUserId( jqgridPage, userid);
	}
	public Map<String, Object> findByJqpageAndUserId(Jqpage jqpage, int userid) {
		// TODO Auto-generated method stub
		return ordersDao.findByJqpageAndUserId( jqpage, userid);
	}
}
