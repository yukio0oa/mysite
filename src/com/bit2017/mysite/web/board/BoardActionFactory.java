package com.bit2017.mysite.web.board;

import com.bit2017.web.Action;
import com.bit2017.web.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if( "writeform".equals( actionName ) ) {
			
		} else {
			action = new ListAction();
		}
		
		return action;
	}

}
