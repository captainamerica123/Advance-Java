package com.bhushan.servlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Test 
{
	public static void main(String args[]) throws ClassNotFoundException
	{
		Test t=new Test();
		t.createConnection();
	}
		void createConnection() throws ClassNotFoundException
		{
			String url="jdbc:oracle:thin:@localhost:1524:xe";
			try 
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","XE","root");
				Statement s=conn.createStatement();
				ResultSet rs=s.executeQuery("select * from emp_details");
				if(rs!=null)
				{
					if(rs.next())
					{
						String firstname=rs.getString("FIRST_NAME");
						System.out.println("first name:"+firstname);
						String lasttname=rs.getString("LAST_NAME");
						System.out.println("last name:"+lasttname);
						String email=rs.getString("EMAIL");
						System.out.println("email:"+email);
						String age=rs.getString("AGE");
						System.out.println("age:"+age);
						String userid=rs.getString("USER_ID");
						System.out.println("user id:"+userid);
						String userpassword=rs.getString("USER_PASSWORD");
						System.out.println("user password:"+userpassword);
					}
				}
			}catch(Exception e)
			{
				System.out.println("Exception is"+e);
			}
		}
		
}
	


