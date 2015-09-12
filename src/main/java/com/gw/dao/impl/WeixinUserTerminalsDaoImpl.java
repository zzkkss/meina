package com.gw.dao.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.TypedValue;
import org.springframework.stereotype.Repository;

import com.gw.dao.WeixinUserTerminalsDao;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Terminals;
import com.gw.model.TerminalsXingzhe;
import com.gw.model.WeixinUserTerminals;

@Repository("weixinUserTerminalsDao")
public class WeixinUserTerminalsDaoImpl extends BaseDaoImpl<WeixinUserTerminals> implements WeixinUserTerminalsDao {


	public Map<String, Object> getByPage(Jqpage jqpage, String... strings) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(WeixinUserTerminals.class);
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
			List<WeixinUserTerminals> list= criteria.list();
			
		map.put("entity", list);
		map.put("jqpage", jqpage);
		return map;
	}

	public Map<String, Object> getByJgridType(JqgridPage jqgridPage, String type) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(WeixinUserTerminals.class);
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
			List<WeixinUserTerminals> list= criteria.list();
			
		map.put("entity", list);
		jqgridPage.setTotalPages(jqgridPage.getTotalRecords()/jqgridPage.getRows()+1);
		map.put("jqgridPage", jqgridPage);
		return map;
	}

	public List<WeixinUserTerminals> getLastBindByTerminalsTname(Terminals terminals) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(WeixinUserTerminals.class);
		criteria.add(Restrictions.eq("Bind", "1"));
		criteria.add(Restrictions.eq("Tname", terminals.getTname()).ignoreCase());
		criteria.addOrder(Order.desc("Id"));
			List<WeixinUserTerminals> list= criteria.list();
		return list;
	}

	public List<WeixinUserTerminals> findByOpenId(String openid) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(WeixinUserTerminals.class);
		criteria.add(Restrictions.eq("Bind", "1"));
		criteria.add(Restrictions.eq("Openid", openid));
		criteria.addOrder(Order.desc("Id"));
			List<WeixinUserTerminals> list= criteria.list();
		return list;
	}

	public WeixinUserTerminals findByOpenIdAndTname(String openid, String tname) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(WeixinUserTerminals.class);
		criteria.add(Restrictions.eq("Bind", "1"));
		criteria.add(Restrictions.eq("Openid", openid));
		criteria.add(Restrictions.eq("Tname", tname));
		criteria.addOrder(Order.desc("Id"));
			List<WeixinUserTerminals> list= criteria.list();
			if(list.size()>0){
				return list.get(0);
			}else{
				return null;
			}
	}

	public List<WeixinUserTerminals> getLastBindByTerminalsTname(
			TerminalsXingzhe terminalsXingzhe) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(WeixinUserTerminals.class);
		criteria.add(Restrictions.eq("Bind", "1"));
		criteria.add(Restrictions.eq("Tname", terminalsXingzhe.getTname()).ignoreCase());
		criteria.addOrder(Order.desc("Id"));
			List<WeixinUserTerminals> list= criteria.list();
		return list;
	}

	


}
