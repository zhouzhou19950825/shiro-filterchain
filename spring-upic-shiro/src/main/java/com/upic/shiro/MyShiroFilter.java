package com.upic.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

public class MyShiroFilter extends AccessControlFilter{

	@Override
	protected boolean isAccessAllowed(ServletRequest arg0, ServletResponse arg1, Object arg2) throws Exception {
		return false;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest req=(HttpServletRequest) request;
		String header = req.getHeader("token");
		Subject subject = SecurityUtils.getSubject();
		Object attribute = subject.getSession().getAttribute(header);
		System.out.println("look look =============:"+attribute);
		//WebUtils.issueRedirect(request, response, "");
		//WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
		return true;
	}

}
