package com.security.springSecurityExample.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private DataSource dataSource;

//	@Autowired
//	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/", "/test", "/login").permitAll()
			.anyRequest()
			.authenticated()
			.and()
		.formLogin()
//			.loginPage("/home")
//			.loginProcessingUrl("/loginProcess")
//			.usernameParameter("username")
//			.passwordParameter("password")
			.defaultSuccessUrl("https:///google.com")
			.failureUrl("/error")
//			.successForwardUrl("https:///google.com")
//			.permitAll();
			.and();
//		.httpBasic()
//			.and()
//		.exceptionHandling()
//			.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//			.and()
//		.logout()
//			.permitAll();
	}
	
	// 設定需要驗證的url
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
	//
//			http.authorizeRequests()
//			.anyRequest()
//				.authenticated()
//				.and()
//			.csrf().disable() // 防止csrf
//			.formLogin()
//				.loginPage("/customLoginPage")
//				.loginProcessingUrl("/loginProcess") // 當傳送request到這個url時，
//				.permitAll();
//		}

	/**
	 * JDBC 設定
	 * 
	 * @param auth
	 * @throws Exception
	 */
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//		.jdbcAuthentication()
//			.dataSource(dataSource);
//			.withDefaultSchema()
//			.usersByUsernameQuery("select username, password, enabled from users where username = :?")
//			.authoritiesByUsernameQuery("select username, authorities from authorities where username = :?");

//		auth
//			.userDetailsService(customUserDetailsService)
//			.passwordEncoder(getPasswordEncoder());
//	}

	/**
	 * 忽略靜態資源標籤
	 */
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/js/**", "/css/**", "http://localhost:8080/swagger-ui.htm/**");
//	}

	/**
	 * 指定 PasswordEncoder
	 * 
	 * @return
	 */
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * InMemory 設定
	 * 
	 * @param auth
	 * @throws Exception
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		String password = getPasswordEncoder().encode("test");
		auth.inMemoryAuthentication().withUser("test").password(password).roles("ADMIN");
	}

}
