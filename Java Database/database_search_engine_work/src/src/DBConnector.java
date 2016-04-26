package src;

import java.sql.*;

public class DBConnector {

	//VARIABLES
	static public String DBName, DBData, name, id, date_1, date_2, output;
	static public String line = System.getProperty("line.separator");//Line Separator
	//VARIABLES FOR PASSWORD CHECK
	static public String username;
	static public char[] password;
	static public boolean username_check = false, password_check = false;

	static public boolean connection_check = false, login = false;
	//DATABASE VARIABLES
	static public Connection connection;
	static public PreparedStatement statement;
	static public ResultSet DB_result;

	public static void DBConnection(){
	
		System.out.println("Connecting to database...");
	
		try{
		
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_database", "root", "");
		
			connection_check = true;
			System.out.println("Retrieving data from database.....");
			System.out.println("Connection: " +  connection_check);
			System.out.println("Database Name: " + DBName + line + "Data: " + DBData);
		
		}catch(Exception e){  connection_check = false; System.out.println("Error:" + line +  "Connection: " + connection_check + line + e);}finally { GUI_Core.start_window(); /*If you fail to connect to a Database GUI_Core will continue to run*/}
	
}

	public static void login_check(){
	
		if(username.equals("gomuk-9399@hotmail.com")){ username_check = true; System.out.println("Username corresponds...");}else { username_check = false; System.out.println("Username doesn't corresponds...");} 
		if(password.equals("creater")){ password_check = true; System.out.println("Password corresponds...");}else { password_check = false; System.out.println("Password dosen't corresponds...");}
		if(username_check = true) { if(password_check = true) { login = true; System.out.println("Login was sucesfull...");}else { login = false; System.out.println("Login wasen't sucesfull...");}}
	
		//statement = connection.prepareStatement();
	
		return;
	
	}

	public static void DBSearch(){
	
		try{
		statement = connection.prepareStatement("SELECT * FROM `main`");//what you want to search for
		DB_result = statement.executeQuery();
	
		//output = DB_result;
	
		}catch(Exception e){ output = ("Error:" + line +  "Connection: " + connection_check + line + e);}finally{ GUI_Core.update = true;}
	}

}