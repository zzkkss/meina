package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Shops;


public interface ShopsDao extends BaseDao<Shops> {
List<Shops> lastUser(int num);
Map<String,Object>  getByPage(Jqpage jqpage,String...strings );
Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
List<Shops> shopsListByCoordinate(String center, String leftbttom,
		String righttop);
Map<String, Object> findByPageAndShoptype(Jqpage jqpage, int shoptype);
Shops getByUserId(int userId);
List<Shops> shopsListBySearch(String keyWords);
Map<String, Object> findBydistanceAndCityCode(Jqpage jqpage, int cityCode);
Map<String, Object> findBydistanceAndType(Jqpage jqpage, int type);
Map<String, Object> findBydistanceAndCityCode(Jqpage jqpage, Integer id, String coordinate);
List<Shops> shopsListByCoordinateAndCityCode(String center, String leftbttom, String righttop, Integer id);
}
