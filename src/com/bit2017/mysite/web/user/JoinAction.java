package com.bit2017.mysite.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2017.mysite.dao.UserDao;
import com.bit2017.mysite.vo.UserVo;
import com.bit2017.web.Action;
import com.bit2017.web.util.WebUtil;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter( "name" );
		String email = request.getParameter( "email" );
		String password = request.getParameter( "password" );
		String gender = request.getParameter( "gender" );
		
		UserVo userVo = new UserVo();
		userVo.setName(name);
		userVo.setEmail(email);
		userVo.setPassword(password);
		userVo.setGender(gender);
		
		new UserDao().insert(userVo);
		
		WebUtil.redirect( request.getContextPath() + "/user?a=joinsuccess", request, response);
	}
}
