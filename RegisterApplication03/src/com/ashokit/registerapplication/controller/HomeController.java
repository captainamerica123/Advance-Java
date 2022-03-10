package com.ashokit.registerapplication.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashokit.resiterapplication.dao.RegisterDao;

/**
 * Servlet implementation class HomeController
 */
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=(String)request.getSession().getAttribute("USER_NAME");
		if(null!=userName) {
			String tempAddress=request.getParameter("tempAddress");
			String permAddress=request.getParameter("permAddress");
			RegisterDao dao= new RegisterDao();
			try {
				String message=dao.inserAddressDate(userName, tempAddress, permAddress);
				if(message.equalsIgnoreCase("Address is successful")) {
				RequestDispatcher rd = request.getRequestDispatcher("/addressSuccess.jsp");
		        rd.forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
