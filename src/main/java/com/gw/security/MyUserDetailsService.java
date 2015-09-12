package com.gw.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.gw.model.MainAuthorities;
import com.gw.model.MainRoles;
import com.gw.model.MainRolesAuthorities;
import com.gw.model.MainUsers;
import com.gw.model.MainUsersRoles;
import com.gw.services.MainAuthoritiesSer;
import com.gw.services.MainRolesAuthoritiesSer;
import com.gw.services.MainRolesSer;
import com.gw.services.MainUsersRolesSer;
import com.gw.services.MainUsersSer;

/**
 * 在这个类中，你就可以从数据库中读入用户的密码，角色信息，是否锁定，账号是否过期等，我想这么简单的代码就不再多解释了。
 * 主要功能:根据用户名得到一个用户的相关信息;而其中最重要的就是其角色的名称集合这个信息
 * 因为角色的集合代表的其实就是用户代表的角色的权限的信息,系统会根据角色的权限自动取出可以访问和控制的URL等
 */
@Component("myUserDetailService")
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private MainUsersSer mainUsersSer;
	

	@Autowired
	private MainRolesSer mainRolesSer;
	@Autowired
	private MainUsersRolesSer mainUsersRolesSer;
	@Autowired
	private MainAuthoritiesSer mainAuthoritiesSer;
	@Autowired
	private MainRolesAuthoritiesSer mainRolesAuthoritiesSer;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		logger.info("当前调用的" + this.getClass().getName());

//		// 定义一个角色名的集合(相当于List<String>)
//		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
//		// 定义一个名为ROLE_ADMIN的角色
//		SimpleGrantedAuthority auth1 = new SimpleGrantedAuthority("ROLE_ADMIN");
//		if (username.equals("admin")) {
//			auths = new ArrayList<GrantedAuthority>();
//			auths.add(auth1);
//		}
//		if (username.equals("user")) {
//			auths = new ArrayList<GrantedAuthority>();
//			auths.add(new SimpleGrantedAuthority("ROLE_USER"));
//		}
//
//		// User(String username, String password, boolean enabled, boolean
//		// accountNonExpired,
//		// boolean credentialsNonExpired, boolean accountNonLocked,
//		// Collection<GrantedAuthority> authorities) {
//		MyUserDetails user = new MyUserDetails(username, "admin", true, true, true, true, auths);
//		return user;
	    System.out.println("username is " + username);  
	    WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
	    mainUsersSer=wac.getBean(MainUsersSer.class);
	    MainUsers user = mainUsersSer.findByUsername(username).get(0);//取出username对应的MainUser；
	    mainUsersRolesSer=wac.getBean(MainUsersRolesSer.class);
	    List<MainUsersRoles> mainUsersRoles=mainUsersRolesSer.findByUsers(user);//根据MainUser取出对应的MainUsersRoles
//	    mainRolesSer=wac.getBean(MainRolesSer.class);
//	    List<MainRoles> mainRoles=mainRolesSer.findByMainUsersRoles(mainUsersRoles);
	    mainRolesAuthoritiesSer=wac.getBean(MainRolesAuthoritiesSer.class);
	    List<MainRolesAuthorities> mra=mainRolesAuthoritiesSer.findByMainUsersRoles(mainUsersRoles);
	    mainAuthoritiesSer=wac.getBean(MainAuthoritiesSer.class);
	    List<MainAuthorities> ma=mainAuthoritiesSer.findByMainRolesAuthorities(mra);
	    
//	    for(MainUsersRoles roles:mainUsersRoles){
//	    	mainRolesSer.
//	    }
	    List<GrantedAuthority> authorities = buildUserAuthority(ma);
	    return buildUserForAuthentication(user, authorities);
	}
	/**
	   * 返回验证角色
	   * @param userRoles
	   * @return
	   */
	  private List<GrantedAuthority> buildUserAuthority(List<MainAuthorities> mainRoles){
	    Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
	    for(MainAuthorities userRole:mainRoles){
	      setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
	      logger.info(userRole.getName());
	    }
	    List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
	    return result;
	  }
	  
	  /**
	   * 返回验证用户
	   * @param user
	   * @param authorities
	   * @return
	   */
	  private MyUserDetails buildUserForAuthentication(MainUsers user,List<GrantedAuthority> authorities){
		/*  private int id=0;
			private String username=null;
			private String password=null;
			private boolean enabled=true;
			private boolean accountNonExpired=true;
			private boolean credentialsNonExpired=true;
			private boolean accountNonLocked=true;*/
	    return new MyUserDetails(user.getId(),user.getUsername(),user.getPassword(),user.isEnabled(),true,true,true,authorities);
	  }
}