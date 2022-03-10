package com.ashokit.registraterapplication.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.ashokit.registerapplication.model.RegisterModel;
import com.ashokit.resiterapplication.dao.RegisterDao;

public class ValidateFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("in destroy method of filter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("in doFilter method of filter");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		RegisterModel r= new RegisterModel();
		r.setUserName(userName);
		r.setPassword(password);
		
		RegisterDao dao= new RegisterDao();
		String validateUser=dao.searchUser(r);
		if(validateUser!=null && validateUser.equalsIgnoreCase("User Found")) {
			chain.doFilter(request, response);

		}else {
			throw new ServletException("Invalid Credentials");
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("in init method of filter");
		
	}

}
