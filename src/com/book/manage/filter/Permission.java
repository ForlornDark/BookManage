package com.book.manage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.manage.bean.User;

public class Permission implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		StringBuffer buffer= request.getRequestURL();
		String url = buffer.toString();
		System.out.println(request.getRequestURI());
		if(url.endsWith("index.jsp"))
			arg2.doFilter(arg0, arg1);
		else if(url.endsWith("/"))
			arg2.doFilter(arg0, arg1);
		else if(url.endsWith("login.jsp"))
			arg2.doFilter(arg0, arg1);
		else if(url.endsWith("book_query.jsp"))
			arg2.doFilter(arg0, arg1);
		else if(url.endsWith("lend_query.jsp"))
			arg2.doFilter(arg0, arg1);
		else if(url.endsWith("login.action"))
			arg2.doFilter(arg0, arg1);
		else if(url.endsWith("qureyLend.action"))
			arg2.doFilter(arg0, arg1);
		else if(url.endsWith("queryBook.action"))
			arg2.doFilter(arg0, arg1);
		else {
			User u = null;
			HttpSession session = request.getSession(false);
			Cookie[] cookies = request.getCookies();
			if(cookies!=null){
				for(Cookie c:cookies){
					if(c.getName().equals("user"))
						 u =(User)(session.getAttribute(c.getValue()));
					
				}
			}
			if(u!=null)
				arg2.doFilter(arg0, arg1);
			else
				response.sendError(404);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
