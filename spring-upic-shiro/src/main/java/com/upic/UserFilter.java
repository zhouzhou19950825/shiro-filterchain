package com.upic;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.stereotype.Component;

@Component
@WebFilter(urlPatterns = "/*", filterName = "authFilter")
public class UserFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		HttpServletRequest req=(HttpServletRequest) request;
//		String header = req.getHeader("token");
//		Subject subject = SecurityUtils.getSubject();
//		Object attribute = subject.getSession().getAttribute(header);
//		System.out.println("look look =============:"+attribute);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}

}
