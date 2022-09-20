package com.project.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.project.service.MemberService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class.getName());
	
	@Autowired
	MemberService memberService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
		.loginPage("/member/login") // 로그인 페이지 url을 설정
		.defaultSuccessUrl("/main") // 로그인 성공 시 이동할 url
		.usernameParameter("username") // 로그인 시 사용할 파라미터 이름으로 username을 지정
		.failureUrl("/member/login/error") // 로그인 실패 시 이동할 url을 설정
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout")) // 로그아웃 url을 설정
		.logoutSuccessUrl("/main") // 로그아웃 성공 시 이동할 url을 설정
		;

		
		http.authorizeRequests()
		.mvcMatchers("/", "/member/**","/main").permitAll() // 모든 사용자 인증없이 해당경로에 접근하도록 설정
		.mvcMatchers("/admin/**").hasRole("ADMIN") // /admin 경로 접근자는 ADMIN Role일 경우만 접근가능하도록 설정
//		.anyRequest().authenticated() // 나머지 경로들은 모두 인증을 요구하도록 설정
		;
		
		http.exceptionHandling() // 인증되지 않은 사용자가 리소스에 접근하였을 때 수행되는 핸들러 등록
		.authenticationEntryPoint(new CustomAuthenticationEntryPoint())
		;

	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(memberService)//서비스에서 가입된 사용자인지 확인함
		.passwordEncoder(passwordEncoder());
	}
	
	
	

}
