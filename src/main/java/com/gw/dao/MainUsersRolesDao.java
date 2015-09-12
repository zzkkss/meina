package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainUsers;
import com.gw.model.MainUsersRoles;


public interface MainUsersRolesDao extends BaseDao<MainUsersRoles> {
List<MainUsersRoles> lastUser(int num);
Map<String,Object>  getByPage(Jqpage jqpage,String...strings );
Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
List<MainUsersRoles> findByUsers(MainUsers authority);
}
