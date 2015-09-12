package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainUsers;


public interface MainUsersDao extends BaseDao<MainUsers> {
List<MainUsers> lastUser(int num);
Map<String,Object>  getByPage(Jqpage jqpage,String...strings );
Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
List<MainUsers> findByUsername(String username);
boolean checkNameAndPassword(String username, String password);
}
