package core;

public class Main {

	public static Boolean running = false;
	public static int stage = 0;

	public static void main(String[] args) {
	
		running = true;
	
		GUI.startup();
		DB_Connection.DB_startup();
	
	}

	public static void stage_check(){
	
		if(stage == 0){GUI.panel_1.setVisible(true);GUI.panel_2.setVisible(false);GUI.panel_3.setVisible(false);}
		if(stage == 1){GUI.panel_1.setVisible(false);GUI.panel_2.setVisible(true);GUI.panel_3.setVisible(false); DB_Connection.fetch();}
		if(stage == 2){GUI.panel_1.setVisible(false);GUI.panel_2.setVisible(false);GUI.panel_3.setVisible(true);}
	
	}

}
