package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.TerminalsXingzhe;


public interface TerminalsXingzheDao extends BaseDao<TerminalsXingzhe> {
Map<String,Object>  getByPage(Jqpage jqpage,String...strings );
Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
List<TerminalsXingzhe> getByTname(String tn);
}
