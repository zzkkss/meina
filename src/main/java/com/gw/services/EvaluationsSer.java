package com.gw.services;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;

import com.gw.model.Evaluations;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Products;


public interface EvaluationsSer extends BaseSer<Evaluations> {

	Map<String, Object> findByJqgridJqgridAndProductId(Jqpage jqgridPage,
			int productId);



}
