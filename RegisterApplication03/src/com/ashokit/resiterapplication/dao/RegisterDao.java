package com.ashokit.resiterapplication.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ashokit.registerapplication.model.RegisterModel;



public class RegisterDao {

			
	public int id=123;
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
	
	public String insertData(RegisterModel model) throws Exception{
		PreparedStatement preparedStatement = null; 
		try{
			StringBuffer s= new StringBuffer();
			s.append("INSERT INTO REGISTER_USER_DETAILS (FIRST_NAME,MID_NAME,LAST_NAME,EMAIL,MOBILE_NUMBER,USER_NAME,USER_PASSWORD)");
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
				throw e;
			}
            if(result>0) {
            	return "Registration is successful";
            }
            
            System.out.println("Query after prepare statement"+s.toString());
			
		}catch (Exception e) {
			System.out.println("exception occured "+e);
			throw e;
		}finally {
			
		}
		return null;
	}
	
	
	public String searchUser(RegisterModel model){
		Statement stmt = null; 
		ResultSet rs=null;
		try{
			StringBuffer s= new StringBuffer();
			//s.append("SELECT * FROM REGISTER_USER_DETAILS WHERE USER_NAME=? AND user_password=?");
			  String query = "select * from REGISTER_USER_DETAILS where user_name='"+model.getUserName()+"' and user_password='"+model.getPassword()+"'"; //Insert user details into the table 'USERS'
			
			Connection con=RegisterDao.createConnection();
			stmt=con.createStatement();		
			System.out.println("Query after prepare statement"+query.toString());
			
			
            int result=0;
            try {
            	rs =stmt.executeQuery(query);
            	
            	if(rs!=null && rs.next()) {
            		return "User Found";
            	}else {
            		return "User not Found";
            	}
            }catch (Exception e) {
				System.out.println("exception"+e);
			}
            
            System.out.println("Query after prepare statement"+s.toString());
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		return null;
	}
	
	public List getUserDetails(){
		Statement stmt = null; 
		ResultSet rs=null;
		List<RegisterModel> userList=null;
		try{
			StringBuffer s= new StringBuffer();
			//s.append("SELECT * FROM REGISTER_USER_DETAILS WHERE USER_NAME=? AND user_password=?");
			  String query = "select * from REGISTER_USER_DETAILS";
			
			Connection con=RegisterDao.createConnection();
			stmt=con.createStatement();		
			System.out.println("Query after prepare statement"+query.toString());
			
			
            int result=0;
            try {
            	rs =stmt.executeQuery(query);
            	if(rs!=null) {
            		userList= new ArrayList<>();
            		while(rs.next()) {
            			RegisterModel model=new RegisterModel();
            			model.setFirstName(rs.getString("FIRST_NAME"));
            			model.setMidName(rs.getString("MID_NAME"));
            			model.setLastName(rs.getString("LAST_NAME"));
            			model.setEmail(rs.getString("EMAIL"));
            			model.setMobileNumber(rs.getInt("MOBILE_NUMBER"));
            			model.setUserName(rs.getString("USER_NAME"));
            			userList.add(model);//5
            		}
            	}
            	
            }catch (Exception e) {
				System.out.println("exception"+e);
			}
            
            System.out.println("Query after prepare statement"+s.toString());
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		return userList;
	}
	
	
	
	
	public String inserAddressDate(String userName, String tempAdd,String permAdd) throws Exception{
		PreparedStatement preparedStatement = null; 
		try{
			StringBuffer s= new StringBuffer();
			s.append("INSERT INTO REGISTER_ADDR_DETAILS (TEMP_ADDRESS,PERM_ADDRESS,ADDR_ID,USER_NAME)");
			s.append("values(?,?,?,?)");
			Connection con=RegisterDao.createConnection();
			preparedStatement=con.prepareStatement(s.toString());		
			System.out.println("Query after prepare statement"+s.toString());
			
			preparedStatement.setString(1, tempAdd);
            preparedStatement.setString(2, permAdd);
           
            preparedStatement.setInt(3,++id);
            preparedStatement.setString(4,userName);
            
            int result=0;
            try {
            result =preparedStatement.executeUpdate();
            }catch (Exception e) {
				System.out.println("exception"+e);
				throw e;
			}
            if(result>0) {
            	return "Address is successful";
            }
            
            System.out.println("Query after prepare statement"+s.toString());
			
		}catch (Exception e) {
			System.out.println("exception occured "+e);
			throw e;
		}finally {
			
		}
		return null;
	}
	


}
