package com.gw.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gw.dao.CollectCouponsDao;
import com.gw.dao.ImagesDao;
import com.gw.model.CollectCoupons;
import com.gw.model.Jqpage;

@Repository("collectCouponsDao")
public class CollectCouponsDaoImpl extends BaseDaoImpl<CollectCoupons> implements CollectCouponsDao {

	public CollectCoupons findByUserIdAndCouponId(CollectCoupons collectCoupons) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(CollectCoupons.class);
//		criteria.add(Expression.eq("Type", strings[0]));
		criteria.add(Restrictions.eq("UsersId", collectCoupons.getUsersId()));
		criteria.add(Restrictions.eq("CouponsId", collectCoupons.getCouponsId()));
		criteria.addOrder(Order.desc("Id"));
		List<CollectCoupons> a=criteria.list();
		if(a.size()>0){
			return a.get(0);
		}else{
			return null;
		}
	}

	public Map<String, Object> findByJqpageAndUserId(Jqpage jqpage, int id) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(CollectCoupons.class);
		Map<String, Object> map=new HashMap<String, Object>();
		criteria.add(Expression.eq("UsersId", id));
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
			List<CollectCoupons> list= criteria.list();
			
		map.put("entity", list);
		map.put("jqpage", jqpage);
		return map;
	}




}
