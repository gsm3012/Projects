package com.smart.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.smart.entities.User;


public class UserDetailsImplementation implements UserDetails
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private User user;
	
	public UserDetailsImplementation(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(user.getUserRole());
		
		List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
		list.add(simpleGrantedAuthority);
		return list;
	}

	@Override
	public String getPassword() {
		
		return user.getUserPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserEmail();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
	
}
