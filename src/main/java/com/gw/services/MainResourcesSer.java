package com.gw.services;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainResources;


public interface MainResourcesSer extends BaseSer<MainResources> {

	List<MainResources> lastUser(int num);

	public Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
	  public Map<String,Object>  findByPage(Jqpage jqpage,String...strings );

	public List<MainResources> getByUnionid(String unionid);
}
