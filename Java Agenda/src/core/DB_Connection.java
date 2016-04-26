package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB_Connection {

	public static Boolean connection = false;

	public static void DB_startup(){
	
		try{
		
			
		
			connection = true;
		
		}catch(Exception e){ }
	
		return;
	
	}

}
