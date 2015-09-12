package com.gw.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gw.dao.CouponsDao;
import com.gw.model.Coupons;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;

@Repository("couponsDao")
public class CouponsDaoImpl extends BaseDaoImpl<Coupons> implements CouponsDao {


	public Map<String, Object> getByPage(Jqpage jqpage, String... strings) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(Coupons.class);
		Map<String, Object> map=new HashMap<String, Object>();
		criteria.add(Expression.eq("Type", strings[0]));
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
			List<Coupons> list= criteria.list();
			
		map.put("entity", list);
		map.put("jqpage", jqpage);
		return map;
	}

	public Map<String, Object> getByJgridType(JqgridPage jqgridPage, String type) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(Coupons.class);
		if(type.equals("0")){
			
		}else{
			criteria.add(Expression.eq("Type", type));
		}
		jqgridPage.setTotalRecords(criteria.list().size());
		Map<String, Object> map=new HashMap<String, Object>();
			criteria.setFirstResult((jqgridPage.getPage()-1)*jqgridPage.getRows());
			criteria.setMaxResults(jqgridPage.getRows());
			if(jqgridPage.getOrder().equals("asc")){
				criteria.addOrder(Order.asc(jqgridPage.getSort()));
			}else{
				criteria.addOrder(Order.desc(jqgridPage.getSort()));
			}
			List<Coupons> list= criteria.list();
			
		map.put("entity", list);
		jqgridPage.setTotalPages(jqgridPage.getTotalRecords()/jqgridPage.getRows()+1);
		map.put("jqgridPage", jqgridPage);
		return map;
	}

	public List<Coupons> lastUser(int num) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(Coupons.class);
		criteria.setMaxResults(num);
		criteria.addOrder(Order.desc("Id"));
		List<Coupons> a=criteria.list();
	return a;
	}

	public Map<String, Object> findByJqgridAndShopId(JqgridPage jqgridPage,
			int shopid) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(Coupons.class);
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
		List<Coupons> list= criteria.list();
		
	map.put("entity", list);
	jqgridPage.setTotalPages(jqgridPage.getTotalRecords()/jqgridPage.getRows()+1);
	map.put("jqgridPage", jqgridPage);
	return map;
	}

	public Map<String, Object> findByPageAndShopid(Jqpage jqpage, int shopid) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(Coupons.class);
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
			List<Coupons> list= criteria.list();
			
		map.put("entity", list);
		map.put("jqpage", jqpage);
		return map;
	}



}
