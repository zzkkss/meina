package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.Citylist;
import com.gw.model.Images;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;


public interface CitylistDao extends BaseDao< Citylist> {

	List<Citylist> findByParentId(int id);

	Citylist findByCitycode(int code);

	Citylist findByName(String name);
}
