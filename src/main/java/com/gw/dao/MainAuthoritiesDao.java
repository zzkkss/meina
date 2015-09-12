package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainAuthorities;
import com.gw.model.MainAuthoritiesResources;
import com.gw.model.MainRolesAuthorities;


public interface MainAuthoritiesDao extends BaseDao<MainAuthorities> {
List<MainAuthorities> lastUser(int num);
Map<String,Object>  getByPage(Jqpage jqpage,String...strings );
Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
List<MainAuthorities> findByRoles(MainRolesAuthorities mainRolesAuthorities2);
MainAuthorities findByMainAuthoritiesResources(MainAuthoritiesResources mar);
List<MainAuthorities> findByMainRolesAuthorities(MainRolesAuthorities m);
}
