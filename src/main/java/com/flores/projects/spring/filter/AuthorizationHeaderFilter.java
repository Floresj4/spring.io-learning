package com.flores.projects.spring.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

/**
 * A filter class registered to spring HttpSecurity providing the
 * authorization header as principal to the authentication manager.
 * @author Jason
 */
public class AuthorizationHeaderFilter extends AbstractPreAuthenticatedProcessingFilter {
	
	@Override
	protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
		return request.getHeader("authorization");
	}
	
	@Override
	protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
		return null;
	}
}
