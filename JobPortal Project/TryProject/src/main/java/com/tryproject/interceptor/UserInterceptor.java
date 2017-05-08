package com.tryproject.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tryproject.pojo.User;

public class UserInterceptor extends HandlerInterceptorAdapter {
		String errorPage="login";

		public String getErrorPage() {
			return errorPage;
		}

		public void setErrorPage(String errorPage) {
			this.errorPage = errorPage;
		}
		
		@Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	            throws Exception {

	        HttpSession session = (HttpSession) request.getSession();
	        
	        if(session.getAttribute("user") != null){
	            System.out.println("in interceptor");
	            return true;
	        }
	        if(session.getAttribute("user") == null){
	        System.out.println("no user");
	        ModelAndView mav = new ModelAndView("login", "user", new User());
            // eventually populate the model
            throw new ModelAndViewDefiningException(mav);
	        }
	        //response.sendRedirect(errorPage);
	        return false;
	        
	        
	        
	        
	    }
		
}
