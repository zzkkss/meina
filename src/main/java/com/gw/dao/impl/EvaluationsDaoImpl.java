package com.gw.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gw.dao.EvaluationsDao;
import com.gw.dao.ProductsDao;
import com.gw.dao.ShopsDao;
import com.gw.model.Evaluations;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;

@Repository("evaluationsDao")
public class EvaluationsDaoImpl extends BaseDaoImpl<Evaluations> implements EvaluationsDao {

	public Map<String, Object> getByPageAndProductId(Jqpage jqpage,
			int productId) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(Evaluations.class);
		Map<String, Object> map=new HashMap<String, Object>();
		criteria.add(Expression.eq("ProductId", productId));
		jqpage.setTotalRecords(criteria.list().size());
			criteria.setFirstResult((jqpage.getPage()-1)*jqpage.getRows());
			criteria.setMaxResults(jqpage.getRows());
			String sort="";
			if(jqpage.getSort()==null){
				sort="id";
			}else{
				sort=jqpage.getSort();
			}
			if(jqpage.getOrder()!=null&&jqpage.getOrder().equals("asc")){
				criteria.addOrder(Order.asc(sort));
			}else{
				criteria.addOrder(Order.desc(sort));
			}
			List<Evaluations> list= criteria.list();
			
		map.put("entity", list);
		map.put("jqpage", jqpage);
		return map;
	}

	public List<Evaluations> findByProductId(Evaluations evaluations) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(Evaluations.class);
		Map<String, Object> map=new HashMap<String, Object>();
		criteria.add(Restrictions.eq("ProductId", evaluations.getProductId()));
			List<Evaluations> list= criteria.list();
		return list;
	}



}
