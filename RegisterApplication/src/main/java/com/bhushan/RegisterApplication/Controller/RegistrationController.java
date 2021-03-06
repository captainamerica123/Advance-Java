package com.bhushan.RegisterApplication.Controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhushan.RegisterApplication.Model.RegisterModel;
import com.bhushan.RegistrationApplication.dao.RegisterDao;

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
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");

		String email=request.getParameter("email");

		String age=request.getParameter("age");

		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		
		RegisterModel r=new RegisterModel();
		r.setFirstname(firstname);
		r.setLastname(lastname);
		r.setEmail(email);
		r.setAge(age);
		r.setUserid(userid);
		r.setpassword(password);
		
		RegisterDao dao= new RegisterDao();
		String result=null;
		String message=null;
		try {
		result = dao.insertData(r);
		}catch(Exception e)
		{
			if(e.getMessage().contains("_pk"))
			{
				message="Primary key is voileted,user_id cannot be dublicated";
			}
			throw new ServletException(message);
			
		}
		
		if(result!=null)
		{
			System.out.println("result is "+result);
			RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
		
	}

	

}
