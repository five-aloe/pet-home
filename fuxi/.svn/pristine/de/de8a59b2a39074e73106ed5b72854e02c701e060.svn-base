/**
 * Copyright (c) 2017, 满兜 . All rights reserved. Use is subject to license terms.
 */
package com.zhonglian.fuxi.web.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zhonglian.fuxi.web.filter.LoginInterceptor;

/**
 * SPRING mvc WEB层配置
 * 
 * @author zyf
 *
 */
@Configuration  
@EnableWebMvc
@ComponentScan({"com.zhonglian.fuxi.web"})
public class SpringWebConfig extends WebMvcConfigurerAdapter {

	@Resource
	private LoginInterceptor loginInterceptor;
	
	@Bean
	@Autowired
	public RedisHttpSessionConfiguration redisHttpSessionConfiguration() {
		
		RedisHttpSessionConfiguration config = new RedisHttpSessionConfiguration();
		config.setMaxInactiveIntervalInSeconds(3600);
		
		return config;
	}
	
	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(loginInterceptor)
			.addPathPatterns("/**")
			.excludePathPatterns("*.js", "*.png", "*.css");
		
		super.addInterceptors(registry);
	}
	
}
