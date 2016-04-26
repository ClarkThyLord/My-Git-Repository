package core;

public class Main {

	public static Boolean running = false;

	public static void main(String[] args) {
	
		running = true;
	
		GUI.first_stage();
		//DB_Connection.DB_startup();
		
		if(DB_Connection.connection = true){GUI.secound_stage();}if(DB_Connection.connection = false){GUI.third_stage();}
	
	}

}
