package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.Coupons;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Products;
import com.gw.model.Shops;


public interface CouponsDao extends BaseDao<Coupons> {

	Map<String, Object> findByJqgridAndShopId(JqgridPage jqgridPage, int shopid);

	Map<String, Object> findByPageAndShopid(Jqpage jqpage, int shopid);
}
