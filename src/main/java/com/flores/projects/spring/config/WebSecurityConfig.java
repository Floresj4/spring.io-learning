package com.flores.projects.spring.config;

import static java.lang.String.valueOf;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

import com.flores.projects.spring.filter.AuthorizationHeaderFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
    	//initialize the authorization filter and register with HttpSecurity
    	AuthorizationHeaderFilter authHeaderFilter = new AuthorizationHeaderFilter();
    	authHeaderFilter.setAuthenticationManager(new AuthenticationManager() {

			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				String principal = valueOf(authentication.getPrincipal());
				authentication.setAuthenticated(principal != null);
				return authentication;
			}
    	});
    	
    	http.authorizeRequests()
    		.antMatchers("/public/**").permitAll()
    		.and()
    			.sessionManagement()
    				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    		.and()
    			.addFilter(authHeaderFilter)
    			.addFilterBefore(new ExceptionTranslationFilter(
                        new Http403ForbiddenEntryPoint()),
    						authHeaderFilter.getClass()
                    )
    			.authorizeRequests()
    				.anyRequest()
    				.authenticated();
    }
}