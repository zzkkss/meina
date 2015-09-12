package com.gw.dao.impl;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gw.dao.MainAuthoritiesResourcesDao;
import com.gw.exception.ApplyException;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainAuthoritiesResources;
import com.gw.model.MainResources;
import com.gw.model.MainUsersRoles;

@Repository("mainAuthoritiesResourcesDao")
public class MainAuthoritiesResourcesDaoImpl extends BaseDaoImpl<MainAuthoritiesResources> implements MainAuthoritiesResourcesDao {


	public Map<String, Object> getByPage(Jqpage jqpage, String... strings) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(MainAuthoritiesResources.class);
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
			List<MainAuthoritiesResources> list= criteria.list();
			
		map.put("entity", list);
		map.put("jqpage", jqpage);
		return map;
	}

	public Map<String, Object> getByJgridType(JqgridPage jqgridPage, String type) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(MainAuthoritiesResources.class);
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
			List<MainAuthoritiesResources> list= criteria.list();
			
		map.put("entity", list);
		jqgridPage.setTotalPages(jqgridPage.getTotalRecords()/jqgridPage.getRows()+1);
		map.put("jqgridPage", jqgridPage);
		return map;
	}

	public List<MainAuthoritiesResources> lastUser(int num) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(MainAuthoritiesResources.class);
		criteria.setMaxResults(num);
		criteria.addOrder(Order.desc("id"));
		List<MainAuthoritiesResources> a=criteria.list();
	return a;
	}


	public List<MainAuthoritiesResources> findByRoles(MainUsersRoles mainUsersRoles2) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(MainAuthoritiesResources.class);
//		criteria.add(Expression.eq("Type", strings[0]));
		criteria.add(Restrictions.eq("RolesId", mainUsersRoles2.getRolesId()));
		criteria.addOrder(Order.desc("id"));
		List<MainAuthoritiesResources> a=criteria.list();
	return a;
	}

	public List<MainAuthoritiesResources> findByResources(MainResources mr) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(MainAuthoritiesResources.class);
//		criteria.add(Expression.eq("Type", strings[0]));
		criteria.add(Restrictions.eq("ResourcesId", mr.getId()));
		criteria.addOrder(Order.desc("id"));
		List<MainAuthoritiesResources> a=criteria.list();
	return a;
	}


}
