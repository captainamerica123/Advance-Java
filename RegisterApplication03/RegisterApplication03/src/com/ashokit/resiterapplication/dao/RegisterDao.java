package com.ashokit.resiterapplication.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.ashokit.registerapplication.model.RegisterModel;



public class RegisterDao {

			
	public static Connection createConnection() throws ClassNotFoundException{
		 String url = "jdbc:oracle:thin:@localhost:1524:xe"; 
		 Connection con=null;
		try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 
		  con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1524:xe", "demo_db", "demo_db"); //attempting to connect to MySQL database
		 		 
		}catch (Exception e) {
			System.out.println("Exception is "+e);
		}
		return con;
	}
	
	public String insertData(RegisterModel model){
		PreparedStatement preparedStatement = null; 
		try{
			StringBuffer s= new StringBuffer();
			s.append("INSERT INTO REGISTER_USER_DETAILS (FIRST_NAME,MID_NAME,LAST_NAME,EMAIL,MOBILE_NUMBER,USER_NAME,USER_PASSWORD)");
			s.append("values(?,?,?,?,?,?,?')");
			Connection con=RegisterDao.createConnection();
			Statement stmt=con.prepareStatement(s.toString());		
			System.out.println("Query after prepare statement"+s.toString());
			
			preparedStatement.setString(1, model.getFirstName());
            preparedStatement.setString(2, model.getMidName());
            preparedStatement.setString(3, model.getLastName());            
            preparedStatement.setString(4, model.getEmail());
            preparedStatement.setInt(5,model.getMobileNumber());
            preparedStatement.setString(6, model.getUserName());
            preparedStatement.setString(7, model.getPassword());
            
            int result=stmt.executeUpdate(s.toString());
            if(result>0) {
            	return "Registration is successful";
            }
            
            System.out.println("Query after prepare statement"+s.toString());
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		return null;
	}


}
