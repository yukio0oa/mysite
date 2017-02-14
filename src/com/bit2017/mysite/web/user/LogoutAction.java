package com.bit2017.mysite.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit2017.web.Action;
import com.bit2017.web.util.WebUtil;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession( false );
		
		if( session != null ) {
			// logout 처리
			session.removeAttribute( "authUser" );
			session.invalidate();
		}
		
		WebUtil.redirect(
				request.getContextPath() + "/main", 
				request, 
				response );		
	}
}
