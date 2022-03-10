package com.bhushan.RegisterApplication.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bhushan.RegistrationApplication.dao.RegisterDao;

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
		// TODO Auto-generated method stub
		String userId=(String)request.getSession().getAttribute("User_Id");
		if(null!=userId) {
			String tempaddress=request.getParameter("tempaddress");
			String peraddress=request.getParameter("peraddress");
			RegisterDao dao= new RegisterDao();
			try {
				String message=dao.insertAddressData(userId, tempaddress, peraddress);
				if(message.equalsIgnoreCase("Address is successful")) {
				RequestDispatcher rd = request.getRequestDispatcher("/AddressSuccess.jsp");
		        rd.forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

}
