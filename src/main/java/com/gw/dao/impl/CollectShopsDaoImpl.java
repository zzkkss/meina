package com.gw.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gw.dao.CollectShopsDao;
import com.gw.dao.ImagesDao;
import com.gw.model.CollectShops;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;

@Repository("collectShopsDao")
public class CollectShopsDaoImpl extends BaseDaoImpl<CollectShops> implements CollectShopsDao {

	public CollectShops findByUserIdAndShopsId(CollectShops collectShops) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(CollectShops.class);
//		criteria.add(Expression.eq("Type", strings[0]));
		criteria.add(Restrictions.eq("UsersId", collectShops.getUsersId()));
		criteria.add(Restrictions.eq("ShopsId", collectShops.getShopsId()));
		criteria.addOrder(Order.desc("Id"));
		List<CollectShops> a=criteria.list();
		if(a.size()>0){
			return a.get(0);
		}else{
			return null;
		}
	}

	public Map<String, Object> findByJqpageAndUserId(Jqpage jqpage, int id) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(CollectShops.class);
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
			List<CollectShops> list= criteria.list();
			
		map.put("entity", list);
		map.put("jqpage", jqpage);
		return map;
	}




}
