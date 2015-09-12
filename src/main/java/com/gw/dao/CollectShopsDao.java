package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.CollectShops;
import com.gw.model.Images;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;


public interface CollectShopsDao extends BaseDao< CollectShops> {

	CollectShops findByUserIdAndShopsId(CollectShops collectShops);

	Map<String, Object> findByJqpageAndUserId(Jqpage jqpage, int id);
}
