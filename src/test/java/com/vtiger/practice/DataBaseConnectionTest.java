package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseConnectionTest 
{
public static void main(String[] args) throws SQLException 
{
	

	//Step1: Create Object for implemention class
	
			Driver driver = new Driver();
			
			//Step2: Register the driver with JDBC
			
			DriverManager.registerDriver(driver);
			
			//Step3: Establish the database connection
			
			 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet34","root","root");
			
			//Step4: Create statement
			
			 Statement statement = connection.createStatement();
					
			//Step5: Execute Query
					
			ResultSet result = statement.executeQuery("select * from emp_details;");
			
			//Step6: Validate (based on testcase)
			
			while(result.next())
			{
				System.out.println(result.getString(1));
				System.out.println(result.getString(2));
				System.out.println(result.getString(3));
				
				
			}
			
			//Step7: Close the connection
			
			connection.close();
}
}