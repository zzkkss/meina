package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.Images;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Orders;


public interface OrdersDao extends BaseDao< Orders> {


	Map<String, Object> findByJqgridAndShopId(JqgridPage jqgridPage, int userid);

	Map<String, Object> findByJqgridAndUserId(JqgridPage jqgridPage, int userid);

	Map<String, Object> findByJqpageAndUserId(Jqpage jqpage, int userid);
}
