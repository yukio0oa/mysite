package com.bit2017.mysite.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2017.web.Action;
import com.bit2017.web.util.WebUtil;

public class JoinSuccessAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		WebUtil.forward( "/WEB-INF/views/user/joinsuccess.jsp", request, response);

	}

}
