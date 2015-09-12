package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainRoles;
import com.gw.model.MainUsers;
import com.gw.model.MainUsersRoles;


public interface MainRolesDao extends BaseDao<MainRoles> {
List<MainRoles> lastUser(int num);
Map<String,Object>  getByPage(Jqpage jqpage,String...strings );
Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
List<MainRoles> findByMainUsersRoles(MainUsersRoles mainUsersRoles);
}
