package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainRoles;
import com.gw.model.MainRolesAuthorities;
import com.gw.model.MainUsersRoles;


public interface MainRolesAuthoritiesDao extends BaseDao<MainRolesAuthorities> {
List<MainRolesAuthorities> lastUser(int num);
Map<String,Object>  getByPage(Jqpage jqpage,String...strings );
Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
List<MainRolesAuthorities> findByRoles(MainUsersRoles mainUsersRoles2);
List<MainRolesAuthorities> findByMainRoles(MainRoles mainRoles);
List<MainRolesAuthorities> findByMainUsersRoles(MainUsersRoles m);
}
