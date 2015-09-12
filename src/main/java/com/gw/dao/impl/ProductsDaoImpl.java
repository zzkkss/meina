package com.gw.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gw.dao.ProductsDao;
import com.gw.dao.ShopsDao;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Products;

@Repository("productsDao")
public class ProductsDaoImpl extends BaseDaoImpl<Products> implements ProductsDao {

	public Map<String, Object> getByPageAndShopid(Jqpage jqpage, int shopid) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(Products.class);
		Map<String, Object> map=new HashMap<String, Object>();
		criteria.add(Expression.eq("ShopsId", shopid));
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
			List<Products> list= criteria.list();
			
		map.put("entity", list);
		map.put("jqpage", jqpage);
		return map;
	}

	public Map<String, Object> findByJqgridAndShopid(JqgridPage jqgridPage,
			int shopid) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(Products.class);
			criteria.add(Expression.eq("ShopsId", shopid));
		jqgridPage.setTotalRecords(criteria.list().size());
		Map<String, Object> map=new HashMap<String, Object>();
			criteria.setFirstResult((jqgridPage.getPage()-1)*jqgridPage.getRows());
			criteria.setMaxResults(jqgridPage.getRows());
			if(jqgridPage.getOrder().equals("asc")){
				criteria.addOrder(Order.asc(jqgridPage.getSort()));
			}else{
				criteria.addOrder(Order.desc(jqgridPage.getSort()));
			}
			List<Products> list= criteria.list();
			
		map.put("entity", list);
		jqgridPage.setTotalPages(jqgridPage.getTotalRecords()/jqgridPage.getRows()+1);
		map.put("jqgridPage", jqgridPage);
		return map;
	}



}
