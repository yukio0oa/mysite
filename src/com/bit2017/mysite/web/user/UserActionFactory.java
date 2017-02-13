package com.bit2017.mysite.web.user;

import com.bit2017.mysite.web.main.IndexAction;
import com.bit2017.web.Action;
import com.bit2017.web.ActionFactory;

public class UserActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if( "joinform".equals( actionName ) ) {
			action = new JoinFormAction();
		} else if( "join".equals( actionName ) ) {
			action = new JoinAction();
		} else if( "joinsuccess".equals( actionName ) ) {
			action = new JoinSuccessAction();
		} else if( "loginform".equals( actionName )) {
			action = new LoginFormAction();
		} else if( "login".equals( actionName )) {
			action = new LoginAction();
		} else {
			action = new IndexAction();
		}
		
		return action;
	}

}
