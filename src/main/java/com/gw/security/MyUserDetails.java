package com.gw.security;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
/**
 * 
 * @author tingfeng
 *String getUsername()：获取用户名； 

String getPassword()：获取密码； 

boolean isAccountNonExpired()：用户帐号是否过期； 

boolean isAccountNonLocked()：用户帐号是否锁定； 

boolean isCredentialsNonExpired()：用户的凭证是否过期； 

boolean isEnabled()：用户是否处于激活状态。
 */
public class MyUserDetails implements UserDetails {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private int id=0;
	private String username=null;
	private String password=null;
	private boolean enabled=true;
	private boolean accountNonExpired=true;
	private boolean credentialsNonExpired=true;
	private boolean accountNonLocked=true;
	//Collection<GrantedAuthority>中装的是用户的角色名称的集合,相当于Collection<String>
	private Collection<GrantedAuthority> authorities;
	public MyUserDetails(int id,String username, String password, boolean enabled, boolean accountNonExpired,  
          boolean credentialsNonExpired, boolean accountNonLocked, Collection<GrantedAuthority> authorities)
          {
		this.id=id;
		this.username=username;
          this.password=password;
          this.enabled=enabled;
          this.accountNonExpired=accountNonExpired;
          this.credentialsNonExpired=credentialsNonExpired;
          this.accountNonLocked=accountNonExpired;
          this.authorities=authorities;		
          logger.info("当前调用的"+this.getClass().getName());		
          }
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}
	
	public int getId() {
		return id;
	}
/*	public void setId(int id) {
		this.id = id;
	}*/
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return this.accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return this.accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return this.credentialsNonExpired;
	}
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.enabled;
	}
}
