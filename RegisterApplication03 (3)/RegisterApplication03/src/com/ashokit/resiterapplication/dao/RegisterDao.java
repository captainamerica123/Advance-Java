package com.ashokit.resiterapplication.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ashokit.registerapplication.model.RegisterModel;



public class RegisterDao {

			
	public static Connection createConnection() throws ClassNotFoundException{
		 String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		 Connection con=null;
		try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 
		  con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "XE", "root"); //attempting to connect to MySQL database
		 		 
		}catch (Exception e) {
			System.out.println("Exception is "+e);
		}
		return con;
	}
	
	public String insertData(RegisterModel model){
		PreparedStatement preparedStatement = null; 
		try{
			StringBuffer s= new StringBuffer();
			s.append("INSERT INTO REGISTER_USER_DETAILS (FIRST_NAME,LAST_NAME,EMAIL,AGE,MOBILE_NUMBER,USER_ID,USER_PASSWORD)");
			s.append("values(?,?,?,?,?,?,?)");
			Connection con=RegisterDao.createConnection();
			preparedStatement=con.prepareStatement(s.toString());		
			System.out.println("Query after prepare statement"+s.toString());
			
			preparedStatement.setString(1, model.getFirstName());
            preparedStatement.setString(2, model.getMidName());
            preparedStatement.setString(3, model.getLastName());            
            preparedStatement.setString(4, model.getEmail());
            preparedStatement.setInt(5,model.getMobileNumber());
            preparedStatement.setString(6, model.getUserName());
            preparedStatement.setString(7, model.getPassword());
            int result=0;
            try {
            result =preparedStatement.executeUpdate();
            }catch (Exception e) {
				System.out.println("exception"+e);
			}
            if(result>0) {
            	return "Registration is successful";
            }
            
            System.out.println("Query after prepare statement"+s.toString());
			
		}catch (Exception e) {
			System.out.println("exception occured "+e);
		}finally {
			
		}
		return null;
	}
	
	

	


}
