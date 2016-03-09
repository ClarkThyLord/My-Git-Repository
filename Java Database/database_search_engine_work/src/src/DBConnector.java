package src;

import java.sql.*;

public class DBConnector {

	//VARIABLES
	static public String DBName, name, id, date_1, date_2, output;
	static public String line = System.getProperty("line.separator");//Line Separator

	static public boolean connection_check;
	//DATABASE VARIABLES
	static public Connection connection;
	static public Statement statement;
	static public ResultSet DB_result;

	public static void DBConnection(){
	
		System.out.println("Retrieving data fron database...");
	
		try{
		
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school_data_base", "root", "");
		
			System.out.println("Database Name: " + DBName + line + "Data:");
			connection_check = true;
		
		}catch(Exception e){  connection_check = false; System.out.println("Error:" + line +  "Connection: " + connection_check + line + e);}finally { GUI_Core.start_window(); /*If you fail to connect to a Database GUI_Core will continue to run*/}
	
}

	public static void DBSearch(){
	
		try{
		statement = connection.prepareStatement("");//what you want to search for
		DB_result = statement.executeQuery();
	
		//output = DB_result;
	
		}catch(Exception e){ output = ("Error:" + line +  "Connection: " + connection_check + line + e);}finally{ GUI_Core.update = true;}
	}

}