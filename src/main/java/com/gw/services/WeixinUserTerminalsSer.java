package com.gw.services;


import java.util.List;
import java.util.Map;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Terminals;
import com.gw.model.TerminalsXingzhe;
import com.gw.model.WeixinUserTerminals;


public interface WeixinUserTerminalsSer extends BaseSer<WeixinUserTerminals> {

	public Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
	  public Map<String,Object>  findByPage(Jqpage jqpage,String...strings );
	  public List<WeixinUserTerminals> getLastBindByTerminalsTname(Terminals terminals);
	public List<WeixinUserTerminals> getLastBindByTerminalsTname(TerminalsXingzhe terminalsXingzhe);
	public List<WeixinUserTerminals> findByOpenId(String openid);
	public WeixinUserTerminals findByOpenIdAndTname(String openid, String tname);
}
	