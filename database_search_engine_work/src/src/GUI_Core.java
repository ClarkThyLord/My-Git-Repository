package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI_Core {

	//VARIABLES
	public static String new_information, old_information;
	private static boolean correction_1 = false;

	//FRAME #1
	static JFrame window_1 = new JFrame("Log-In");
	//COMPONENTS:
	static JPanel content_1 = new JPanel();
	static JLabel title_label = new JLabel("Welcome To A Java Database Search Engine");
	static JLabel username_label = new JLabel("Name:");
	static JTextField username = new JTextField();
	static JLabel password_label = new JLabel("Password:");
	static JPasswordField password_field = new JPasswordField();
	static JLabel description_label = new JLabel("pleas sign in to proceed");
	static JButton enter_button = new JButton("Enter");

	 //FRAME #2
	static JFrame window_2 = new JFrame("Database Search Engine");
	//COMPONENTS:
	static JPanel content_2 = new JPanel();
	static JLabel filter_label = new JLabel("~ Filters: ~");
	static JLabel name_label = new JLabel("Name:");
	static JTextField name = new JTextField();
	static JLabel date_label = new JLabel("Date(s):");
	static JTextField date_1 = new JTextField();
	static JLabel sign = new JLabel("-");
	static JTextField date_2 = new JTextField();
	static JLabel id_label = new JLabel("ID:");
	static JTextField ID = new JTextField();
	static JButton clear = new JButton("Clear All Filters");
	static JButton entre = new JButton("Enter");
	public static JLabel information_panel = new JLabel("Search for something....");

	//CODE*************************************************
	public static void start_window(){
	
		window_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window_1.setResizable(false);
		window_1.setSize( 450, 350);
		window_1.setVisible(true);
		window_1.setContentPane(content_1);
		content_1.setLayout(null);
	
		title_label.setBounds(90, 93, 280, 25);
		content_1.add(title_label);
		
		username_label.setBounds(50, 129, 62, 14);
		content_1.add(username_label);
		
		username.setBounds(111, 125, 250, 25);
		content_1.add(username);
		
		password_label.setBounds(35, 166, 100, 14);
		content_1.add(password_label);
		
		password_field.setBounds(111, 161, 250, 25);
		content_1.add(password_field);
		
		description_label.setBounds(50, 191, 201, 41);
		content_1.add(description_label);
		
		enter_button.setBounds(261, 197, 100, 35);
		content_1.add(enter_button);
		enter_button.addActionListener(new ActionListener(){   public void actionPerformed(ActionEvent e) {
			
			window_1.dispose();
			main_window();
			
		}});
	
		return;
	
	}

	public static void main_window(){
	
		window_2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window_2.setResizable(false);
		window_2.setSize( 800, 600);
		window_2.setVisible(true);
		window_2.setContentPane(content_2);
		content_2.setLayout(null);
		
		filter_label.setBounds(10, 11, 60, 14);
		content_2.add(filter_label);
	
		name_label.setBounds(20, 36, 50, 14);
		content_2.add(name_label);
		
		name.setBounds(63, 31, 400, 25);
		content_2.add(name);
		
		date_label.setBounds(20, 73, 46, 14);
		content_2.add(date_label);
		
		date_1.setBounds(73, 67, 200, 25);
		content_2.add(date_1);

		sign.setBounds(280, 73, 15, 14);
		content_2.add(sign);
		
		date_2.setBounds(293, 67, 200, 25);
		content_2.add(date_2);
		
		id_label.setBounds(473, 36, 15, 14);
		content_2.add(id_label);
		
		
		ID.setBounds(498, 31, 99, 25);
		content_2.add(ID);
		
		clear.setBounds(607, 32, 167, 23);
		content_2.add(clear);
		clear.addActionListener(new ActionListener(){   public void actionPerformed(ActionEvent e) {
		
			//to clear all filters
			name.setText("");
			date_1.setText("");
			date_2.setText("");
			ID.setText("");
		
		}});
		
		//ALL OF THE SEARCH HANDELERS
	
		while(correction_1 = false){
		old_information = information_panel.getText();
		new_information = information_panel.getText();
		correction_1 = true;
		}
		if(new_information.equals(old_information)){ }else{ old_information = new_information;}//trying to update the information panel
	
		entre.setBounds(607, 66, 167, 38);
		content_2.add(entre);
		entre.addActionListener(new ActionListener(){   public void actionPerformed(ActionEvent e) {
		
			//uses the filters to search the database
			DBConnector.id = ID.getText();
			DBConnector.name = name.getText();
			DBConnector.date_1 = date_1.getText();
			DBConnector.date_2 = date_2.getText();
		
			//runs a DBSearch
			DBConnector.DBSearch();
		
		}});
		
		information_panel.setVerticalAlignment(SwingConstants.TOP);
		information_panel.setBounds(10, 112, 764, 335);
		content_2.add(information_panel);
	
		//WILL NOW START CHEKING FOR INFORMATION
		information_panel.setText(old_information);
	
	}

}
