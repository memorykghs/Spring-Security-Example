package com.security.springSecurityExample.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.security.springSecurityExample.security.CustomUserDetailsService;

@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/", "/home","/test").permitAll()
			.anyRequest().authenticated()
			.and()
//		.formLogin()
//			.loginPage("/login")
//			.failureUrl("/error")
//			.and()
			.httpBasic()
			.and()
		.logout()
			.permitAll();
	}
	
	/**
	 * JDBC 設定
	 * @param auth
	 * @throws Exception
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.jdbcAuthentication()
			.dataSource(dataSource)
//			.withDefaultSchema();
			.usersByUsernameQuery("select username, password, enabled form users where username = :?");
//			.withUser("user").password("password").roles("USER");
//		auth
//			.userDetailsService(customUserDetailsService)
//			.passwordEncoder(getPasswordEncoder());
	}
	
	/**
	 * 指定 PasswordEncoder
	 * @return
	 */
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * InMemory 設定
	 * @param auth
	 * @throws Exception
	 */
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//		.inMemoryAuthentication()
//			.withUser("user").password("password").roles("USER");
//	}
}
