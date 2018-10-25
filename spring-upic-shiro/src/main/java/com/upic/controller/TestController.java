package com.upic.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.upic.po.UserInfo;

@RestController
public class TestController {
	/**
	 * 登录方法
	 * 
	 * @param userInfo
	 * @return
	 */
	@RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
	public Map<String, String> ajaxLogin(UserInfo userInfo) {
		Map<String, String> jsonObject = new HashMap<>();

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword());
		try {
			subject.login(token);
			jsonObject.put("token", subject.getSession().getId() + "");
			jsonObject.put("msg", "登录成功");
		} catch (IncorrectCredentialsException e) {
			jsonObject.put("msg", "密码错误");
		} catch (LockedAccountException e) {
			jsonObject.put("msg", "登录失败，该用户已被冻结");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

	/**
	 * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/unauth")
	public Object unauth() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "1000000");
		map.put("msg", "未登录");
		return map;
	}

	@RequestMapping(value = "/getUser")
	public Object getDetails(HttpServletRequest req) {
		String header = req.getHeader("token");
		Subject subject = SecurityUtils.getSubject();
		return subject.getSession().getAttribute(header);
	}

}
