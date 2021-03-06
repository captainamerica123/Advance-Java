package com.ashokit.registerapplication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import com.ashokit.registerapplication.model.RegisterModel;
import com.ashokit.resiterapplication.dao.RegisterDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 2L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String companyName=getServletContext().getInitParameter("Company Name");
		System.out.println("purpose is "+companyName);
		String appName=getServletConfig().getInitParameter("Application Name");
		System.out.println("Application Name is"+appName);
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		RegisterModel r= new RegisterModel();
		r.setUserName(userName);
		r.setPassword(password);
		
		RegisterDao dao= new RegisterDao();
		String validateUser=dao.searchUser(r);
		if(validateUser!=null && validateUser.equalsIgnoreCase("User Found")) {
			request.getSession().setAttribute("USER_NAME", userName);
			RequestDispatcher rd = request.getRequestDispatcher("/homeAddress.jsp");
	        rd.forward(request, response);

		}else {

			throw new ServletException("Invalid Credentials. please try with proper credentials");

		}
	}

}
