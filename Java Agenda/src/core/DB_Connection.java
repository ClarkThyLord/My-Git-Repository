package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_Connection {

	static public String line = System.getProperty("line.separator");

	public static Boolean connection = false;

	public static String year_s,month_s,day_s, name_db, year, month, day, hour, minute, action;

	//MYSQL DATABASE VARIABLES
	public static String DB_URL = "jdbc:mysql://localhost:3306/agenda database";
	
	public static Connection DB_connection;
	public static Statement DB_statement;

	public static void DB_startup(){
	
		try{
		
			Connection DB_connection = DriverManager.getConnection(DB_URL, "root", "");
		
			connection = true;
			
			Main.stage = 1;
		
		}catch(Exception e){ System.out.println("Error: " + e ); connection = false; Main.stage = 2;}finally{Main.stage_check();}
	
		return;
	
	}

	public static void fetch(){
	try{
		Connection DB_connection = DriverManager.getConnection(DB_URL, "root", "");
		Statement DB_statement = DB_connection.createStatement();
		ResultSet DB_results = DB_statement.executeQuery("SELECT `name`, `year`, `month`, `day`, `hour`, `minute` FROM `time` WHERE 1");
		
		GUI.textArea.append("Hello, here is your agenda...");
	
		while(DB_results.next()){
		
			GUI.textArea.append(line + "Appoinment ~ Name: " + DB_results.getString("name") + line + DB_results.getString("month") + "," + DB_results.getString("day") + "," +DB_results.getString("year") + "," + DB_results.getString("hour") + ":" + DB_results.getString("minute"));
		
		}
	
	}catch(Exception e){System.out.println("Eror: " + e);}
	
	}

	public static void DB_search(){
	try{
		Connection DB_connection = DriverManager.getConnection(DB_URL, "root", "");
		Statement DB_statement = DB_connection.createStatement();
	
		action = "";
	
		
	
	}catch(Exception e){System.out.println("Eror: " + e);}
	
	}
	
	public static void DB_adding(){
	try{
		Connection DB_connection = DriverManager.getConnection(DB_URL, "root", "");
		Statement DB_statement = DB_connection.createStatement();
	
		action = "INSERT INTO `time` (`name`, `year`, `month`, `day`, `hour`, `minute`) VALUES ('" + name_db + "', '" + year + "', '" + month + "', '" + day + "', '" + hour + "', '" + minute + "');";
		System.out.println(action);
	
		DB_statement.executeUpdate(action);
		
	}catch(Exception e){System.out.println("Eror: " + e);}
	
	}
	
	public static void DB_subtracting(){
	try{
		Connection DB_connection = DriverManager.getConnection(DB_URL, "root", "");
		Statement DB_statement = DB_connection.createStatement();
	
		action = "DELETE FROM `time` WHERE `name` = " + name_db +  " AND `year` = " + year + " AND `month` = " + month + " AND`day` = " + day + " AND `hour` = " + hour + " AND `minute` = " + minute;
		System.out.println(action);
	
		DB_statement.executeUpdate(action);
	
	}catch(Exception e){}
	
	}

}
