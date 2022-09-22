package com.project.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
	//인가되지 않은사용자에게 에러를 보냄
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
	AuthenticationException authException) throws IOException, ServletException {
	response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	
	}
}