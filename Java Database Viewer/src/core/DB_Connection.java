package core;

import java.sql.*;
import java.util.Vector;

public class DB_Connection {
	
	public static String URL = "jdbc:mysql://localhost:3306/agenda database", username = "root",password = "", database_name = "time", query;
	
	public static Boolean DB_test(){
		
		Boolean connection = false;
		
		try (Connection DB_connection = DriverManager.getConnection( URL, username, password );){
			
			System.out.println("Connected to database...");
			connection = true;
			
		}catch(Exception e){System.out.println("ERROR:   " + e);}
		
		return connection;
		
	}
	
	public static void create_query(){
		
		query = "SELECT * FROM " + database_name;
		
	}
	
	public static Vector DB_getColums(){
		
		Vector column_names = new Vector();
		
		Boolean connection = DB_test();
		if(connection == false){
			
			System.out.println("Could not retrive columns because connection with database was not possible...");
			
		}
		else if(connection == true){
			
			create_query();
			
			try(Connection DB_connection = DriverManager.getConnection(URL, username, password);
	            Statement statment = DB_connection.createStatement();
	            ResultSet result = statment.executeQuery(query);){
				
				ResultSetMetaData md = result.getMetaData();
	            int columns = md.getColumnCount();

	            //  Get column names
	            for (int i = 1; i <= columns; i++)
	            {
	                column_names.add(md.getColumnName(i));
	            }
				
			}catch(Exception e){System.out.println("Error:   " + e);}
			
		}
		else{
			
			
			System.out.println("Error:   Cannot understand value");
		}
		
		System.out.println("Column Names: " + column_names);
		
		return column_names;
		
	}
	
}
