package com.gw.services;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;

import com.gw.model.Coupons;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Products;


public interface CouponsSer extends BaseSer<Coupons> {

	Map<String, Object> findByJqgridAndShopId(JqgridPage jqgridPage, int shopid);

	Map<String, Object> findByPageAndShopid(Jqpage jqpage, int shopid);



}
