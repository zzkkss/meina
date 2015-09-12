package com.gw.services;


import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.TerminalsXingzhe;


public interface TerminalsXingzheSer extends BaseSer<TerminalsXingzhe> {

	public Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
	  public Map<String,Object>  findByPage(Jqpage jqpage,String...strings );
	public List<TerminalsXingzhe> getByTname(String tn);
}
