package com.gw.dao;

import java.util.List;
import java.util.Map;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainAuthoritiesResources;
import com.gw.model.MainResources;
import com.gw.model.MainUsersRoles;


public interface MainAuthoritiesResourcesDao extends BaseDao<MainAuthoritiesResources> {
List<MainAuthoritiesResources> lastUser(int num);
Map<String,Object>  getByPage(Jqpage jqpage,String...strings );
Map<String,Object>  getByJgridType(JqgridPage jqgridPage,String type);
List<MainAuthoritiesResources> findByRoles(MainUsersRoles mainUsersRoles2);
List<MainAuthoritiesResources> findByResources(MainResources mr);
}
