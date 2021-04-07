package com.kang.FloApiServer.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.kang.FloApiServer.config.auth.AuthFailureHandler;
import com.kang.FloApiServer.config.auth.MyLoginSuccessHandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration 
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();   
		http.authorizeRequests()
		.antMatchers("/user/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") //일단은 다 열도록
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')") //관리자만 들어올 수 있도록	    
		.anyRequest().permitAll()
		.and()
		.formLogin()//x-www-form-urlencoded, formlogin()은 json 던지면 못 받음
		.failureHandler(new AuthFailureHandler()) //이거필요없네.. 근데 일단 적음..
		.loginProcessingUrl("/login")//x-www-form-urlencoded, 시큐리티가 post로 온 /login 이라는 주소가 들어오면 낚아챔
		.successHandler(new MyLoginSuccessHandler());
		
	}
	
	
	
}
