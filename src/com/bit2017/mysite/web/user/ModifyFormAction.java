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

public class ModifyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession( false );
		if( session == null ) {
			WebUtil.redirect(
				request.getContextPath() + "/main", 
				request, 
				response);
			return;
		}
		
		UserVo authUser = (UserVo)session.getAttribute( "authUser" );
		
		UserVo userVo = new UserDao().get( authUser.getNo() );
		
		request.setAttribute( "userVo", userVo );
		WebUtil.forward(
			"/WEB-INF/views/user/modifyform.jsp", 
			request, 
			response);
	}
}
