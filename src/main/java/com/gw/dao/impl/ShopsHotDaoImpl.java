package com.gw.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gw.dao.ShopsHotDao;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.ShopsHot;

@Repository("shopsHotDao")
public class ShopsHotDaoImpl extends BaseDaoImpl<ShopsHot> implements ShopsHotDao {

	public List<ShopsHot> getByCityCode(int cityCode) {
		// TODO Auto-generated method stub
		
		Criteria criteria=this.getSession().createCriteria(ShopsHot.class);
		criteria.add(Restrictions.eq("CityCode",cityCode));
		criteria.addOrder(Order.asc("HotSort"));
		List<ShopsHot> a=criteria.list();
			return a;
	}

	public ShopsHot getByShopsId(int id) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(ShopsHot.class);
		criteria.add(Restrictions.eq("ShopsId",id));
		criteria.addOrder(Order.desc("Id"));
		List<ShopsHot> a=criteria.list();
		if(a.isEmpty()){
			return null;
		}
			return a.get(0);
	}




}
