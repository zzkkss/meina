package com.gw.services;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainRoles;
import com.gw.model.MainRolesAuthorities;
import com.gw.model.MainUsersRoles;


public interface MainRolesAuthoritiesSer extends BaseSer<MainRolesAuthorities> {

	List<MainRolesAuthorities> findByRoles(MainUsersRoles mainUsersRoles2);

	List<MainRolesAuthorities> findByMainRoles(List<MainRoles> mainRoles);

	List<MainRolesAuthorities> findByMainUsersRoles(
			List<MainUsersRoles> mainUsersRoles);

}
