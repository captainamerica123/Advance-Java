package com.bhushan.RegistrationApplication.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bhushan.RegisterApplication.Model.RegisterModel;


public class RegisterDao 
{
	public int id=1;
	public static Connection createConnection() throws ClassNotFoundException
		{
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			 Connection conn=null;

			try 
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","XE","xe");
				
			}catch(Exception e)
			{
				System.out.println("Exception is"+e);
			}
			return conn;
		}
	public String insertData(RegisterModel model) throws Exception
	{
		PreparedStatement preparedStatement = null; 
		Connection con=null;
		try{
			StringBuffer s= new StringBuffer();
			s.append("INSERT INTO REGISTER_USER_DETAILS (FIRST_NAME,LAST_NAME,EMAIL,AGE,USER_ID,USER_PASSWORD)");
			s.append("values(?,?,?,?,?,?)");
			 con=RegisterDao.createConnection();
			preparedStatement=con.prepareStatement(s.toString());		
			System.out.println("Query after prepare statement"+s.toString());
			
			preparedStatement.setString(1, model.getFirstname());
            preparedStatement.setString(2, model.getLastname());
            preparedStatement.setString(3, model.getEmail());            
            preparedStatement.setString(4, model.getAge());
            preparedStatement.setString(5, model.getUserid());
            preparedStatement.setString(6, model.getPassword());
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
			//System.out.println("exception occured "+e);
			
		}finally {
			if(con!=null)
			{
				con.close();
			}
			if(preparedStatement!=null)
			{
				con.close();
			}
			
		}
		return null;
	}
	public String searchUser(RegisterModel model) throws Exception
	{
		PreparedStatement preparedStatement = null; 
		ResultSet rs=null;
		Connection con=null;
		try{
			StringBuffer s= new StringBuffer();
			s.append("select * from register_user_details where user_id=? and user_password=?");
			 con=RegisterDao.createConnection();
			preparedStatement=con.prepareStatement(s.toString());		
			System.out.println("Query after prepare statement"+s.toString());
            preparedStatement.setString(1, model.getUserid());
            preparedStatement.setString(2, model.getPassword());
            int result=0;
            try {
            rs =preparedStatement.executeQuery();
            if(rs!=null && rs.next())
            {
            	return "User found!";
            }else {
            	return "User not found";
            }
            }catch (Exception e) {
				System.out.println("exception"+e);
			}
            System.out.println("Query after prepare statement"+s.toString());
			
		}catch (Exception e) {
			
		}finally {
			if(con!=null)
			{
				con.close();
			}
			if(preparedStatement!=null)
			{
				con.close();
			}
			if(rs!=null)
			{
				con.close();
			}
			
		}
		return null;
	}
		public List getUserDetails() throws Exception
		{
			Connection con=null;
			PreparedStatement preparedStatement = null; 
			ResultSet rs=null;
			List<RegisterModel>userList=null;
			try{
				StringBuffer s= new StringBuffer();
				s.append("select * from register_user_details");
				
				 con=RegisterDao.createConnection();
				preparedStatement=con.prepareStatement(s.toString());		
				System.out.println("Query after prepare statement"+s.toString());
	           
	            int result=0;
	            try {
	            rs =preparedStatement.executeQuery();
	            if(rs!=null)
	            {
	            	userList=new ArrayList<>();
	            	while(rs.next())
	            	{
	            		RegisterModel model=new RegisterModel();
	            		model.setFirstname(rs.getString("FIRST_NAME"));
	            		model.setLastname(rs.getString("LAST_NAME"));
	            		model.setEmail(rs.getString("EMAIL"));
	            		model.setAge(rs.getString("AGE"));
	            		model.setUserid(rs.getString("USER_ID"));
	            		model.setpassword(rs.getString("USER_PASSWORD"));
	            		userList.add(model);
	            	}
	            
	            }
	            }catch (Exception e) {
					System.out.println("exception"+e);
				}
				
			}catch (Exception e) {
				
			}finally {
				if(con!=null)
				{
					con.close();
				}
				if(preparedStatement!=null)
				{
					con.close();
				}
				if(rs!=null)
				{
					con.close();
				}
			}
			return userList;
			
	}
		public String insertAddressData(String userId,String tempaddress,String peraddress) throws Exception
		{
			PreparedStatement preparedStatement = null; 
			Connection con=null;
			try{
				StringBuffer s= new StringBuffer();
				s.append("INSERT INTO ADDRESS (address_id,temp_address,per_address,user_id)");
				s.append("values(?,?,?,?)");
				 con=RegisterDao.createConnection();
				preparedStatement=con.prepareStatement(s.toString());		
				System.out.println("Query after prepare statement"+s.toString());
				
				preparedStatement.setInt(1, this.getAddIdFromseq());
	            preparedStatement.setString(2, tempaddress);
	            preparedStatement.setString(3, peraddress);            
	            preparedStatement.setString(4,userId);
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
				//System.out.println("exception occured "+e);
				
			}finally {
				if(con!=null)
				{
					con.close();
				}
				if(preparedStatement!=null)
				{
					con.close();
				}
				
			}
			return null;
		}
		public int getAddIdFromseq() throws Exception
		{
			PreparedStatement preparedStatement = null; 
			ResultSet rs=null;
			int addidseqval=0;
			Connection con=null;
			try{
				StringBuffer s= new StringBuffer();
				s.append("select address_seq.nextval from dual");
				 con=RegisterDao.createConnection();
				preparedStatement=con.prepareStatement(s.toString());		
				System.out.println("Query after prepare statement"+s.toString());
	          
	            int result=0;
	            try {
	            rs =preparedStatement.executeQuery();
	            if(rs.next())
	            {
	            	addidseqval=rs.getInt("NEXTVAL");
	            }
	            }catch (Exception e) {
					System.out.println("exception"+e);
				}				
			}catch (Exception e) {
				
			}finally {
				if(con!=null)
				{
					con.close();
				}
				if(preparedStatement!=null)
				{
					con.close();
				}
				if(rs!=null)
				{
					con.close();
				}
			}
			return addidseqval;
		}
		
}
	


