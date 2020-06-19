package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

/**
 * @author czq
 * @Date 2020-06-19 13:38:54
 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.anyRequest()
//		.authenticated()
//		.and()
//		.formLogin()
//		.loginPage("/myLogin.html")
//		.loginProcessingUrl("/login")
//		.permitAll()//登录页不设限访问
//		.and()
//		.csrf()
//		.disable();
//	}
	
	@Autowired
	public DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin/api/**").hasRole("ADMIN")
		.antMatchers("/user/api/**").hasRole("USER")
		.antMatchers("/app/api/**").permitAll()
		.anyRequest().authenticated()
		.and().formLogin()
		.and()
		.sessionManagement().maximumSessions(1);
	}
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth.inMemoryAuthentication()
//        .withUser("user").password("{noop}password").roles("USER")
//        .and()
//        .withUser("admin").password("{noop}password").roles("ADMIN");
//		
//		auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("admin").password("123").roles("ADMIN");
//		auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("user").password("123").roles("USER");
//	}
	

//	@Bean
//	public UserDetailsService userDetailsService() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(User.withUsername("user").password("123").roles("USER").build());
//		manager.createUser(User.withUsername("admin").password("123").roles("USER", "ADMIN").build());
//		return manager;
//	}
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
//		manager.setDataSource(dataSource);
//		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		
//		manager.createUser(User.withUsername("user").password(passwordEncoder.encode("123")).roles("USER").build());
//		manager.createUser(User.withUsername("admin").password(passwordEncoder.encode("123")).roles("USER", "ADMIN").build());
//		return manager;
//	}
	

}
