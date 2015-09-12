package com.gw.services;

import java.util.Map;

import com.gw.model.Images;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Orders;




public interface OrdersSer extends BaseSer<Orders> {


	Map<String, Object> findByJqgridAndShopId(JqgridPage jqgridPage, int shopid);

	Map<String, Object> findByJqgridAndUserId(JqgridPage jqgridPage, int userid);

	Map<String, Object> findByJqpageAndUserId(Jqpage jqpage, int userid);



}
