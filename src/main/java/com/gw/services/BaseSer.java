package com.gw.services;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;

public interface BaseSer<T> {
	  public Serializable save(T entity);  
	  public Serializable saveOrUpdate(T entity);  
	  
	    public void update(T entity);  
	  
	    public void delete(T entity);  
	    public Serializable edit(T entity,JqgridPage jqgridPage);  
	  
	    public T getById(Integer id);  
	  
	    public List<T> getByHQL(String hql, Object... params);  
	    public List<T> findAll();  
	    public Map<String,Object>  findByPage(Jqpage jqpage);
	    public Map<String,Object>  findByJqgrid(JqgridPage jqgridPage);



}
