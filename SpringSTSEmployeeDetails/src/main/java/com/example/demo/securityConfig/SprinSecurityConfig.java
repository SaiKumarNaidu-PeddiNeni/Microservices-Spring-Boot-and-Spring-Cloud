package com.example.demo.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SprinSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired 
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception 
	
	{ 
		auth.inMemoryAuthentication()
	  .withUser("user").password(passwordEncoder().encode("passwordOne"))
	  .authorities("ROLE_USER"); }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	 http.csrf().disable()
		 .authorizeRequests()
		 .anyRequest().authenticated()
		 .and()
	   //.formLogin().and()
		 .httpBasic();
	  }

	 @Bean 
	 public PasswordEncoder passwordEncoder() 
	 { return new BCryptPasswordEncoder(); }
	/*
	 * import org.springframework.context.annotation.Configuration; import
	 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
	 * import org.springframework.security.config.annotation.web.configuration.
	 * WebSecurityConfigurerAdapter;
	 * 
	 * @Configuration
	 * 
	 * @EnableWebSecurity public class SecurityConfig extends
	 * WebSecurityConfigurerAdapter {
	 * 
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
	 * throws Exception { auth.inMemoryAuthentication()
	 * .withUser("user").password(passwordEncoder().encode("passwordOne"))
	 * .authorities("ROLE_USER"); }
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable() .authorizeRequests() .anyRequest().authenticated()
	 * .and() //.formLogin().and() .httpBasic(); }
	 * 
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 * 
	 * }
	 */
	
}
