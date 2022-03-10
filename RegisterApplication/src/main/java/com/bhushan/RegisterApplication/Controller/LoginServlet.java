package com.bhushan.RegisterApplication.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bhushan.RegisterApplication.Model.RegisterModel;
import com.bhushan.RegistrationApplication.dao.RegisterDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
	 * @see HttpServlet#doPost(HttpServlet
	 * Request request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		RegisterModel r=new RegisterModel();
		r.setUserid(userid);
		r.setpassword(password);
		
		RegisterDao dao=new RegisterDao();
		String validateUser=null;
		try {
			validateUser = dao.searchUser(r);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (validateUser!=null && validateUser.equalsIgnoreCase("User found!"))
				{
					//store userid using session.
					/*
					 * HttpSession session=request.getSession(false);
					 * session.setAttribute("User_Id", userid);
					 * session.setMaxInactiveInterval(15*60); session.invalidate();
					 */
					//store userid using cookies.
					Cookie loginCookie=new Cookie("User_Id",userid);
					loginCookie.setMaxAge(30*60);
					response.addCookie(loginCookie);
					
					RequestDispatcher rd=request.getRequestDispatcher("/Address.jsp");
					rd.forward(request, response);
				}
		else {
			throw new ServletException("Invalid credential,pls try with proper credentials.");
		}
				
	}

}
