package com.test.web;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.yx.bean.Box;
import org.yx.http.Login;
import org.yx.http.filter.AbstractSessionFilter;
import org.yx.http.filter.LoginObject;
import org.yx.util.DateUtils;
import org.yx.util.SBuilder;

@Login
public class LoginServlet extends AbstractSessionFilter {

	@Box
	protected LoginObject login(String token, String user, HttpServletRequest req) {

		String password = req.getParameter("password");
//		String validCode = req.getParameter("code");//验证码
//		if (!"9999".equals(validCode)) {
//			return LoginObject.error("验证码错误");
//		}
		if ("admin".equals(user) && "123456".equals(password)) {
			Map<String,Object> map=SBuilder.map("name", "admin").put("login", DateUtils.toDateTimeString(new Date())).toMap();
			this.userSession().setSession(token, map);
			return LoginObject.success(null);
		}

		return LoginObject.error("用户名或密码错误");
	}

}
