package com.upic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringUpicShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringUpicShiroApplication.class, args);
	}
	
//	@Bean
//	public FilterRegistrationBean<UserFilter> myFilter() {
//		FilterRegistrationBean<UserFilter> myFilter = new FilterRegistrationBean<UserFilter>();
//		myFilter.addUrlPatterns("/*");
//		myFilter.setFilter(new UserFilter());
////		myFilter.setOrder(Integer.MAX_VALUE-1);
//		return myFilter;
//	}

}
