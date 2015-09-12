package com.gw.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gw.dao.CustomersDao;
import com.gw.model.Customers;
import com.gw.model.Images;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;

@Repository("customersDao")
public class CustomersDaoImpl extends BaseDaoImpl<Customers> implements CustomersDao {

	public Customers getbyUserId(Integer id) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(Customers.class);
//		criteria.add(Expression.eq("Type", strings[0]));
		criteria.add(Restrictions.eq("UserId", id));
		criteria.addOrder(Order.desc("Id"));
		List<Customers> a=criteria.list();
		if(a.size()>0){
			return a.get(0);
		}else{
			return null;
		}
	}




}
