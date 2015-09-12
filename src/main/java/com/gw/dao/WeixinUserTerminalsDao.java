package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.Terminals;
import com.gw.model.TerminalsXingzhe;
import com.gw.model.WeixinUserTerminals;


public interface WeixinUserTerminalsDao extends BaseDao<WeixinUserTerminals> {
Map<String,Object>  getByPage(Jqpage jqpage,String...strings );
Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
List<WeixinUserTerminals> getLastBindByTerminalsTname(Terminals terminals);
List<WeixinUserTerminals> findByOpenId(String openid);
WeixinUserTerminals findByOpenIdAndTname(String openid, String tname);
List<WeixinUserTerminals> getLastBindByTerminalsTname(TerminalsXingzhe terminalsXingzhe);
}
