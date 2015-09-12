package com.gw.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gw.dao.CitylistDao;
import com.gw.model.Citylist;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;

@Repository("citylistDao")
public class CitylistDaoImpl extends BaseDaoImpl<Citylist> implements CitylistDao {

	public List<Citylist> findByParentId(int id) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(Citylist.class);
//		criteria.add(Expression.eq("Type", strings[0]));
		criteria.add(Restrictions.eq("ParentId", id));
		criteria.addOrder(Order.asc("Sort"));
		List<Citylist> a=criteria.list();
			return a;
	}

	public Citylist findByCitycode(int code) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(Citylist.class);
//		criteria.add(Expression.eq("Type", strings[0]));
		criteria.add(Restrictions.eq("CityCode", code));
		criteria.addOrder(Order.desc("Id"));
		List<Citylist> a=criteria.list();
		if(a.size()>0){
			return a.get(0);
		}else{
			return null;
		}
	}

	public Citylist findByName(String name) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(Citylist.class);
//		criteria.add(Expression.eq("Type", strings[0]));
		criteria.add(Restrictions.like("Name", name));
		criteria.addOrder(Order.desc("Id"));
		List<Citylist> a=criteria.list();
		if(a.size()>0){
			return a.get(0);
		}else{
			return null;
		}
	}




}
