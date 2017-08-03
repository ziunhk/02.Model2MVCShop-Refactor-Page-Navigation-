package com.model2.mvc.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;


public class LogoutAction extends Action {

	@Override
	public String execute(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		
		System.out.println("=====LogoutAction start=====");
		
		HttpSession session=request.getSession();
		
		session.invalidate();
		
		System.out.println("=====LogoutAction end....=====");
		
		return "redirect:/index.jsp";
	}
}