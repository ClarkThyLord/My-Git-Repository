package src;

import java.sql.*;

public class DBConnector {

	//VARIABLES
	static public String DBName;
	static public String line = System.getProperty("line.separator");//Line Separator

	//DATABASE VARIABLES
	static public Connection connection;
	static public Statement statement;
	static public ResultSet DB_result;

	public static void DBConnection(){
	
		System.out.println("Retrieving data fron database...");
	
		try{
		
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_data_base", "root", "");
		
		}catch(Exception e){ System.out.println("Error: " + line + e);}
	
		System.out.println("Database Name: " + DBName + line + "Data:");
	
	}

}
