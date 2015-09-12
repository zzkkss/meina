package com.gw.services.impl;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.gw.dao.BaseDao;
import com.gw.dao.EvaluationsDao;
import com.gw.dao.ProductsDao;
import com.gw.model.Evaluations;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Products;
import com.gw.services.EvaluationsSer;
import com.gw.services.ProductsSer;
@Service("evaluationsSer")
@Transactional 
public class EvaluationsSerImpl extends BaseSerImpl<Evaluations> implements EvaluationsSer{
	  /** 
     * 注入DAO 
     */  
    @Resource(name = "evaluationsDao")  
    public void setDao(BaseDao<Evaluations> dao) {  
        super.setDao(dao);  
    }
    @Autowired
private EvaluationsDao  evaluationsDao;
	public Map<String, Object> findByJqgridJqgridAndProductId(
			Jqpage jqpage, int productId) {
		// TODO Auto-generated method stub
		return evaluationsDao.getByPageAndProductId(jqpage,productId);
	}
}
