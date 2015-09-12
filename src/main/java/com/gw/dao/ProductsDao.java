package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Products;
import com.gw.model.Shops;


public interface ProductsDao extends BaseDao<Products> {

	Map<String, Object> getByPageAndShopid(Jqpage jqpage, int shopid);

	Map<String, Object> findByJqgridAndShopid(JqgridPage jqgridPage, int shopid);
}
