package com.gw.services;


import java.util.List;
import java.util.Map;

import com.gw.model.Terminals;
import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;


public interface TerminalsSer extends BaseSer<Terminals> {

	public Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
	  public Map<String,Object>  findByPage(Jqpage jqpage,String...strings );
	public List<Terminals> getByTname(String tn);
}
