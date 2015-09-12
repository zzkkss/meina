package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.Images;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.ShopsHot;


public interface ShopsHotDao extends BaseDao< ShopsHot> {

	List<ShopsHot> getByCityCode(int cityCode);

	ShopsHot getByShopsId(int id);
}
