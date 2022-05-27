package com.rmgyantra.practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.sdet34l1.genericUtility.GeneralDatabaseUtility;
import com.sdet34l1.genericUtility.GeneralFileUtility;
import com.sdet34l1.genericUtility.GeneralIConstantUtility;

public class DataBaseConnectionTest 
{
public static void main(String[] args) throws SQLException, IOException 
{
	GeneralFileUtility.ToOpenPropertyfile(GeneralIConstantUtility.RMGYANTRAPROPERTYFILE);	
	GeneralDatabaseUtility.openDBConnection(GeneralIConstantUtility.DATABASEURL+"sdet34", GeneralFileUtility.getDataFromPropertyFile("dBUserName"),GeneralFileUtility.getDataFromPropertyFile("dBPassword"));
	GeneralDatabaseUtility.getDataFromDataBase("select * from emp_details;", "Name");
	GeneralDatabaseUtility.validateDataInDatabase("select * from emp_details;", "Name", "Ravi");
	GeneralDatabaseUtility.closeDBConnection();
}
}