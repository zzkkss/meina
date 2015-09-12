package com.gw.services.impl;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.gw.dao.BaseDao;
import com.gw.dao.ProductsDao;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Products;
import com.gw.services.ProductsSer;
@Service("productsSer")
@Transactional 
public class ProductsSerImpl extends BaseSerImpl<Products> implements ProductsSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "productsDao")  
    public void setDao(BaseDao<Products> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private ProductsDao  productsDao;
	public Map<String, Object> findByPageAndShopid(Jqpage jqpage, int shopid) {
		// TODO Auto-generated method stub
		Map<String, Object> r1=productsDao.getByPageAndShopid(jqpage,shopid);
		return r1;
	}
	public Map<String, Object> findByJqgridAndShopid(JqgridPage jqgridPage,
			int shopid) {
		// TODO Auto-generated method stub
		return productsDao.findByJqgridAndShopid(jqgridPage,shopid);
	}
}
