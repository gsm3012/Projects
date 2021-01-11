package com.smart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class UserConfig extends WebSecurityConfigurerAdapter
{
	@Bean
	public UserDetailsService getUserService()
	{
		return new UserDetailsServiceImplementation();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthProvider()
	{
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		
		authProvider.setUserDetailsService(this.getUserService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/**").hasRole("Admin")
		.antMatchers("/user/**").hasRole("USER")
		.antMatchers("/**").permitAll().and().formLogin().loginPage("/login")
		.loginProcessingUrl("/do_login")
		.defaultSuccessUrl("/user/user_dashboard")
		.and().csrf().disable();
	}
}
