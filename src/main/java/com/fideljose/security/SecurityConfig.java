package com.fideljose.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/api/admin/**")
			.hasAnyRole("admin", "user").and().formLogin();
		
		http.csrf().disable().authorizeRequests().antMatchers("/api/any-user/**")
		.hasAnyRole("user").and().formLogin();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("fidejose").password("1234567").roles("user");
		auth.inMemoryAuthentication().withUser("fidejose-admin").password("1234567").roles("admin");
	}
}
