package com.bit2017.mysite.web.user;

import com.bit2017.web.Action;
import com.bit2017.web.ActionFactory;

public class UserActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if( "joinform".equals( actionName ) ) {
			action = new JoinFormAction();
		}
		
		return action;
	}

}
