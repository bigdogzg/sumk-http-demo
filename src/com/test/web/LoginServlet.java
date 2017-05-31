package com.test.web;

import javax.servlet.http.HttpServletRequest;

import org.yx.bean.Bean;
import org.yx.bean.Box;
import org.yx.http.filter.AbstractSessionFilter;
import org.yx.http.filter.LoginObject;

@Bean
public class LoginServlet extends AbstractSessionFilter {

	@Box
	protected LoginObject login(String token, String user, HttpServletRequest req) {

		String password = req.getParameter("password");
//		String validCode = req.getParameter("code");//验证码
//		if (!"9999".equals(validCode)) {
//			return LoginObject.error("验证码错误");
//		}
		if ("admin".equals(user) && "123456".equals(password)) {
			DemoSessionObject so=new DemoSessionObject();
			so.setLoginTime(System.currentTimeMillis());
			so.setUserId("admin");
			this.userSession().setSession(token, so);
			return LoginObject.success(null);
		}

		return LoginObject.error("用户名或密码错误");
	}

}
