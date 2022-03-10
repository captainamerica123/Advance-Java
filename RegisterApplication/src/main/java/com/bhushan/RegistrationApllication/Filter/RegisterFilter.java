package com.bhushan.RegistrationApllication.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.bhushan.RegisterApplication.Model.RegisterModel;
import com.bhushan.RegistrationApplication.dao.RegisterDao;

/**
 * Servlet Filter implementation class RegisterFilter
 */
public class RegisterFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RegisterFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
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
					chain.doFilter(request, response);
				}
		else
		{
			throw new ServletException("Invalid Credentials");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
