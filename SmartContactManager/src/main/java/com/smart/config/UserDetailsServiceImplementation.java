package com.smart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.dao.UserDao;
import com.smart.entities.User;

public class UserDetailsServiceImplementation implements UserDetailsService 
{
	@Autowired
	private UserDao userdao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userdao.getUserByEmail(username);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("Could not found the specified user");
		}
		
		UserDetailsImplementation userDetails = new UserDetailsImplementation(user);
		
		return userDetails;
	}
	
}
