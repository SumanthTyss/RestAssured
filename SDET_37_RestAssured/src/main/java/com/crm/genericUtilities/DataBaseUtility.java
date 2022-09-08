package com.crm.genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

/**
 * 
 * @author SanjayBabu
 *
 */
public class DataBaseUtility {
	static Connection connection;
	/**
	 * connection to DB
	 * @throws SQLException 
	 */
	public void connectToDB() throws SQLException
	{
		Driver driref=new Driver();
		DriverManager.registerDriver(driref);
	Connection connection = DriverManager.getConnection(IConstants.DbUrl+IConstants.DBname,IConstants.DBUsername,IConstants.DBPassword);
		
		System.out.println("database connection is successful");
	}
	/**
	 * Closing DB
	 * @throws Throwable 
	 */
	public void closeDB() throws SQLException
	{
		connection.close();
		System.out.println("close DB connection");
	}
}
