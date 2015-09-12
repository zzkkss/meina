package com.gw.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.gw.dao.ShopsDao;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Shops;

@Repository("shopsDao")
public class ShopsDaoImpl extends BaseDaoImpl<Shops> implements ShopsDao {


	public Map<String, Object> getByPage(Jqpage jqpage, String... strings) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(Shops.class);
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
			List<Shops> list= criteria.list();
			
		map.put("entity", list);
		map.put("jqpage", jqpage);
		return map;
	}

	public Map<String, Object> getByJgridType(JqgridPage jqgridPage, String type) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(Shops.class);
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
			List<Shops> list= criteria.list();
			
		map.put("entity", list);
		jqgridPage.setTotalPages(jqgridPage.getTotalRecords()/jqgridPage.getRows()+1);
		map.put("jqgridPage", jqgridPage);
		return map;
	}

	public List<Shops> lastUser(int num) {
		// TODO Auto-generated method stub
		Criteria criteria=this.getSession().createCriteria(Shops.class);
		criteria.setMaxResults(num);
		criteria.addOrder(Order.desc("Id"));
		List<Shops> a=criteria.list();
	return a;
	}
	public List<Shops> shopsListByCoordinateAndCityCode(String center, String leftbttom, String righttop, Integer cityid) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub stub" + bssw.lng + "," + bssw.lat + "到" + bsne.lng + "," + bsne.lat)
		Double centerX=Double.parseDouble(center.split(",")[0]);
		Double centerY=Double.parseDouble(center.split(",")[1]);
		Double leftBottomX=Double.parseDouble(leftbttom.split(",")[0]);
		Double leftBottomY=Double.parseDouble(leftbttom.split(",")[1]);
		double maxDistance=getDistance(centerX,centerY,leftBottomX,leftBottomY);
		
		String sqlt="select * from shops as sh,main_users as mu where sh.usersid=mu.id  and mu.enabled=1 and sh.cityid= ?  ";
		SQLQuery queryt=this.getSession().createSQLQuery(sqlt);
		queryt.setParameter(0, cityid);//全部
		List<Shops> a= queryt.addEntity(Shops.class).list();
		List<Shops> b=new ArrayList<Shops>();
		for(Shops s:a){
			Double x=Double.parseDouble(s.getCoordinate().split(",")[0]);
			Double y=Double.parseDouble(s.getCoordinate().split(",")[1]);
			double distance=getDistance(centerX,centerY,x,y);
			if(maxDistance<distance){
			}else{
				s.setContent(null);
				s.setImg(null);
				b.add(s);
			}
		}
	return b;
	}
	public List<Shops> shopsListByCoordinate(String center, String leftbttom,
			String righttop) {
		// TODO Auto-generated method stub stub" + bssw.lng + "," + bssw.lat + "到" + bsne.lng + "," + bsne.lat)
		Double centerX=Double.parseDouble(center.split(",")[0]);
		Double centerY=Double.parseDouble(center.split(",")[1]);
		Double leftBottomX=Double.parseDouble(leftbttom.split(",")[0]);
		Double leftBottomY=Double.parseDouble(leftbttom.split(",")[1]);
		double maxDistance=getDistance(centerX,centerY,leftBottomX,leftBottomY);
		
		String sqlt="select * from shops as sh,main_users as mu where sh.usersid=mu.id  and mu.enabled=1 ";
		SQLQuery queryt=this.getSession().createSQLQuery(sqlt);
		List<Shops> a= queryt.addEntity(Shops.class).list();

		List<Shops> b=new ArrayList<Shops>();
		for(Shops s:a){
			Double x=Double.parseDouble(s.getCoordinate().split(",")[0]);
			Double y=Double.parseDouble(s.getCoordinate().split(",")[1]);
			double distance=getDistance(centerX,centerY,x,y);
			if(maxDistance<distance){
			}else{
				s.setContent(null);
				s.setImg(null);
				b.add(s);
			}
		}
	return b;
	}


private double getDistance(double centerX, double centerY,double leftBottomX,double leftBottomY){
double _x = Math.abs(centerX - leftBottomX);
double _y = Math.abs(centerY - leftBottomY);
return Math.sqrt(_x*_x+_y*_y);
}

public Map<String, Object> findByPageAndShoptype(Jqpage jqpage, int shoptype) {
	// TODO Auto-generated method stub
	Criteria criteria=this.getSession().createCriteria(Shops.class);
	Map<String, Object> map=new HashMap<String, Object>();
	criteria.add(Expression.eq("Type", shoptype));
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
		List<Shops> list= criteria.list();
		for(int i=0;i<list.size();i++){
			list.get(i).setContent(null);
			list.get(i).setImg(null);
		}
	map.put("entity", list);
	map.put("jqpage", jqpage);
	return map;
}

public Shops getByUserId(int userId) {
	// TODO Auto-generated method stub
	Criteria criteria=this.getSession().createCriteria(Shops.class);
	criteria.add(Expression.eq("UsersId", userId));
	criteria.addOrder(Order.desc("Id"));
	List<Shops> a=criteria.list();
	if(a.size()>0){
		return a.get(0);
	}else{
		return null;
	}
}

public List<Shops> shopsListBySearch(String keyWords) {
	// TODO Auto-generated method stub
	Criteria criteria=this.getSession().createCriteria(Shops.class);
	criteria.add(Restrictions.like("Title", keyWords,MatchMode.ANYWHERE));
	criteria.addOrder(Order.desc("Id"));
	List<Shops> a=criteria.list();
		return a;
}
@Deprecated
public Map<String, Object> findBydistanceAndCityCode(Jqpage jqpage, int cityid) {
	// TODO Auto-generated method stub
		String sql="select * from shops as sh,main_users as mu where sh.usersid=mu.id  and mu.enabled=1 and sh.cityid= ? order by sh.id limit ?,? ";
		String sqlt="select * from shops as sh,main_users as mu where sh.usersid=mu.id  and mu.enabled=1 and sh.cityid= ?  ";
		SQLQuery query=this.getSession().createSQLQuery(sql);
		SQLQuery queryt=this.getSession().createSQLQuery(sqlt);
		query.setParameter(0, cityid);
		queryt.setParameter(0, cityid);//全部
		
		query.setParameter(1,(jqpage.getPage()-1)*jqpage.getRows() );
		query.setParameter(2,jqpage.getRows() );
		jqpage.setTotalRecords(queryt.list().size());
		
		
			List<Shops> list= query.addEntity(Shops.class).list();
			for(int i=0;i<list.size();i++){
				list.get(i).setContent(null);
				list.get(i).setImg(null);
			}
			Map<String, Object> map=new HashMap<String, Object>();
		map.put("entity", list);
		map.put("jqpage", jqpage);
		return map;
}


public Map<String, Object> findBydistanceAndCityCode(Jqpage jqpage, Integer cityid,String coordinate) {
	// TODO Auto-generated method stub
		//String sql="select * from shops as sh,main_users as mu where sh.usersid=mu.id  and mu.enabled=1 and sh.cityid= ? order by sh.id limit ?,? ";
		String sqlt="select * from shops as sh,main_users as mu where sh.usersid=mu.id  and mu.enabled=1 and sh.cityid= ?  ";
		//SQLQuery query=this.getSession().createSQLQuery(sql);
		SQLQuery queryt=this.getSession().createSQLQuery(sqlt);
		//query.setParameter(0, cityid);
		queryt.setParameter(0, cityid);//全部
		List<Shops> listall= queryt.addEntity(Shops.class).list();
		List<Shops> l=byDistance(listall,coordinate);//按照cooridinate排序后的
		
		//query.setParameter(1,(jqpage.getPage()-1)*jqpage.getRows() );
		//query.setParameter(2,jqpage.getRows() );
		jqpage.setTotalRecords(queryt.list().size());
		List<Shops> rel=new ArrayList<Shops>();
		if(queryt.list().size()<jqpage.getRows()){
			rel=l;
		}else{
			rel=l.subList((jqpage.getPage()-1)*jqpage.getRows() , (jqpage.getPage())*jqpage.getRows() );
		}
		for(int i=0;i<rel.size();i++){
			rel.get(i).setContent(null);
			rel.get(i).setImg(null);
		}
			//List<Shops> list= query.addEntity(Shops.class).list();
			Map<String, Object> map=new HashMap<String, Object>();
		map.put("entity", rel);
		map.put("jqpage", jqpage);
		return map;
}
private List<Shops> distanceCalc(List<Shops> listall,Double x, Double y) {
	// TODO Auto-generated method stub
//	 
//    //直接插入排序
//    for (int i = 1; i < listall.size(); i++) {
//        //待插入元素
//        Shops shps=listall.get(i);
//        double jm=lineSpace(x,y,Double.parseDouble(listall.get(i).getCoordinate().split(",")[0]),Double.parseDouble(listall.get(i).getCoordinate().split(",")[1]));
//        int j;
//        /*for (j = i-1; j>=0 && a[j]>temp; j--) {
//            //将大于temp的往后移动一位
//            a[j+1] = a[j];
//        }*/
//        for (j = i-1; j>=0; j--) {
//            //将大于temp的往后移动一位
//        	double jmj1=lineSpace(x,y,Double.parseDouble(listall.get(j).getCoordinate().split(",")[0]),Double.parseDouble(listall.get(j).getCoordinate().split(",")[1]));
//          if(jmj1>jm){
//        	  listall.add(listall.indexOf(listall.get(j+1)),listall.get(i));
//        	  listall.remove(i);
//            }else{
//                break;
//            }
//        }
//        listall.add(listall.indexOf(listall.get(j+1)),shps);
//  	  listall.remove(i);
//    }
//	return listall;
//	
//	
	
	   List<Shops> tlist = new ArrayList<Shops>() ;
	   for(int i=0 ; i<listall.size() ; i++ ){
	    if( tlist.size()==0 ){
	     tlist.add(listall.get(0)) ;
	    }  else {
	     boolean b = false ;
	     for(int j=0 ; j<tlist.size() ;j++){
	    	 double jm=lineSpace(x,y,Double.parseDouble(listall.get(i).getCoordinate().split(",")[0]),Double.parseDouble(listall.get(i).getCoordinate().split(",")[1]));
	    	 double jmj1=lineSpace(x,y,Double.parseDouble(tlist.get(j).getCoordinate().split(",")[0]),Double.parseDouble(tlist.get(j).getCoordinate().split(",")[1]));
	    //  if(listall.get(i) >= tlist.get(j)){
           if(jm >=jmj1){
	       b = true ;
	      }else{
	       tlist.add(j, listall.get(i)) ;
	       b = false ;
	       break ;
	      }
	     }
	     if(b){
	      tlist.add(listall.get(i)) ;
	     }
	    }
	   }
	   return tlist ;

	
	
	//return ll;
}
private List<Shops> byDistance(List<Shops> listall,String coordinate) {
	// TODO Auto-generated method stub
	
	return distanceCalc(listall,Double.parseDouble(coordinate.split(",")[0]),Double.parseDouble(coordinate.split(",")[1]));
}
/**
 * // 计算两点之间的距离
 * 
 * @param x1
 * @param y1
 * @param x2
 * @param y2
 * @return
 */
private double lineSpace(Double x1, Double y1, Double x2, Double y2) {
	return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
}
public Map<String, Object> findBydistanceAndType(Jqpage jqpage, int type) {
	// TODO Auto-generated method stub
	Criteria criteria=this.getSession().createCriteria(Shops.class);
	Map<String, Object> map=new HashMap<String, Object>();
	criteria.add(Restrictions.eq("Type", type));
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
		List<Shops> list= criteria.list();
		
	map.put("entity", list);
	map.put("jqpage", jqpage);
	return map;
}


}
