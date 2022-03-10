package com.security.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/*
 * @Configuration
 * 
 * @EnableWebSecurity public class LogoutConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * 
 * http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic().
 * and().logout() .logoutRequestMatcher(new
 * AntPathRequestMatcher("/RoxaneWeb/logout")).invalidateHttpSession(true)
 * .deleteCookies("JSESSIONID").logoutSuccessUrl("/login"); }
 * 
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic().
 * and() .logout(logout ->
 * logout.logoutUrl("/logout").deleteCookies("JSESSIONID").logoutSuccessUrl(
 * "/login")); }
 * 
 * }
 */