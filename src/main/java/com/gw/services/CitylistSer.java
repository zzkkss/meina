package com.gw.services;

import java.util.List;

import com.gw.model.Citylist;
import com.gw.model.Images;




public interface CitylistSer extends BaseSer<Citylist> {

	List<Citylist> findByParentId(int id);

	Citylist findByCitycode(int code);

	Citylist findByName(String name);



}
