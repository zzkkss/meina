package com.gw.services;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Products;


public interface ProductsSer extends BaseSer<Products> {

	Map<String, Object> findByPageAndShopid(Jqpage jqpage, int shopid);

	Map<String, Object> findByJqgridAndShopid(JqgridPage jqgridPage, int shopid);



}
