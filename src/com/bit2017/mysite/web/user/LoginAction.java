package com.bit2017.mysite.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit2017.mysite.dao.UserDao;
import com.bit2017.mysite.vo.UserVo;
import com.bit2017.web.Action;
import com.bit2017.web.util.WebUtil;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter( "email" );
		String password = request.getParameter( "password" );
		
		UserVo userVo = new UserDao().get( email, password );
		if( userVo == null ) {
			//로그인 실패 처리(리다이렉트방식)
			WebUtil.redirect( "/mysite/user?a=loginform&result=fail", request, response);
			//로그인 실패 처리(포워드방식)
			//WebUtil.forward( "/WEB-INF/views/user/loginform_error.jsp", request, response);
			return;
		}
		
		// 로그인 처리(세션 처리)
		HttpSession session = request.getSession( true );
		session.setAttribute( "authUser", userVo );
		
		WebUtil.redirect( "/mysite/main", request, response);
		
	}

}
