package com.gw.services;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Shops;


public interface ShopsSer extends BaseSer<Shops> {

	List<Shops> shopsListByCoordinate(String center, String leftbttom,String righttop);

	Map<String, Object> findByPageAndShoptype(Jqpage jqpage, int shoptype);

	Shops getByUserId(int userId);

	List<Shops> shopsListBySearch(String keyWords);
	@Deprecated
	Map<String, Object> shopsListBydistanceAndCityCode(Jqpage jqpage, int cityCode);

	Map<String, Object> shopsListBydistanceAndType(Jqpage jqpage, int type);

	Map<String, Object> shopsListBydistanceAndCityCode(Jqpage jqpage, Integer id, String coordinate);


	List<Shops> shopsListByCoordinateAndCityCode(String center, String leftbttom, String righttop, Integer id);



}
