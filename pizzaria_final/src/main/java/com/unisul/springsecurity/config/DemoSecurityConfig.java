package com.unisul.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	
	//new overwrite
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		
		http.authorizeRequests()
		.antMatchers("/").hasRole("USER")
		.antMatchers("/admin/**").hasRole("FUNC")
		.antMatchers("/systems/**").hasRole("FUNC")
		.antMatchers("/resources/**").permitAll()
		.and()		
		.formLogin()
			.loginPage("/showMyLoginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");
		
	}

	//add a reference to our security data source
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		

		//use jdbc authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

}
