package com.gw.services;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;

import com.gw.model.JqgridPage;
import com.gw.model.Jqpage;
import com.gw.model.MainAuthorities;
import com.gw.model.MainAuthoritiesResources;
import com.gw.model.MainResources;


public interface MainAuthoritiesResourcesSer extends BaseSer<MainAuthoritiesResources> {

	List<MainAuthoritiesResources> findByAuthorities(MainAuthorities mainAuthorities);

	List<MainAuthoritiesResources> findByResources(MainResources mr);

}
