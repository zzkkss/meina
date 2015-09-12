package com.gw.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gw.dao.BbsUserDao;
import com.gw.dao.ImagesDao;
import com.gw.model.BbsUser;
import com.gw.model.Images;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;

@Repository("bbsUserDao")
public class BbsUserDaoImpl extends BaseDaoImpl<BbsUser> implements BbsUserDao {

	public BbsUser findByUserId(int id) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(BbsUser.class);
//		criteria.add(Expression.eq("Type", strings[0]));
		criteria.add(Restrictions.eq("MainUsersId", id));
		criteria.addOrder(Order.desc("Id"));
		List<BbsUser> a=criteria.list();
		if(a.size()>0){
			return a.get(0);
		}else{
			return null;
		}
	}




}
