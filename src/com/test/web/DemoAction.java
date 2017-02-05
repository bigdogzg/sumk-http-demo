package com.test.web;

import java.util.Map;

import org.yx.bean.Box;
import org.yx.db.DB;
import org.yx.exception.BizException;
import org.yx.http.HttpSessionHolder;
import org.yx.http.Web;

import com.test.pojo.DemoUser;

public class DemoAction {

	@Web
	@Box
	public Long insert(DemoUser user) {
		System.out.println(user);
		DB.insert(user).execute();
		return user.getId();
	}


	@Web
	@Box
	public DemoUser query(long id) {
		DemoUser user=DB.select().tableClass(DemoUser.class).byPrimaryId(id).queryOne();
		if(user==null){
			BizException.throwException(3242, "用户没找到");
		}
		return user;
	}
	
	//获取当前用户信息
	@Web
	public Object userInfo() {
		return HttpSessionHolder.getUserObject(Map.class);
	}

}
