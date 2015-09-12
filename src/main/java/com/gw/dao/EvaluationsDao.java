package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.Evaluations;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Products;
import com.gw.model.Shops;


public interface EvaluationsDao extends BaseDao<Evaluations> {

	Map<String, Object> getByPageAndProductId(Jqpage jqpage, int productId);

	List<Evaluations> findByProductId(Evaluations evaluations);
}
