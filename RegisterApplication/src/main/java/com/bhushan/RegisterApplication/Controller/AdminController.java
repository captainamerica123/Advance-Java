package com.bhushan.RegisterApplication.Controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhushan.RegisterApplication.Model.RegisterModel;
import com.bhushan.RegistrationApplication.dao.RegisterDao;

/**
 * Servlet implementation class AdminController
 */
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RegisterDao dao=new RegisterDao();
		List<RegisterModel> userList=dao.getUserDetails();
		request.setAttribute("COMPLETE_USER_DETAILS", userList);
		RequestDispatcher rd=request.getRequestDispatcher("/admin.jsp");
		rd.forward(request, response);
	}

	
}
