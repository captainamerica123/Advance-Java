package com.ashokit.registerapplication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashokit.registerapplication.model.RegisterModel;
import com.ashokit.resiterapplication.dao.RegisterDao;

/**
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
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
		
		String firstName=request.getParameter("firstName");
		String midName=request.getParameter("midName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String mobileNumber=request.getParameter("mobileNumber");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		RegisterModel r= new RegisterModel();
		r.setFirstName(firstName);
		r.setMidName(midName);
		r.setLastName(lastName);
		r.setEmail(email);
		r.setMobileNumber(Integer.parseInt(mobileNumber));
		r.setUserName(userName);
		r.setPassword(password);
		
		RegisterDao dao= new RegisterDao();
		String result=dao.insertData(r);
		System.out.println("result is "+result);
        

		
	}

}
