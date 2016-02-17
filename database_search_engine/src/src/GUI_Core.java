package src;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI_Core {

	//FRAME #1
	static JFrame window_1 = new JFrame("Log-In");
	//COMPONENTS:
	static JPanel content_1 = new JPanel();
	static JLabel title_label = new JLabel("Welcome To A Java Database Search Engine");
	static JLabel name_label = new JLabel("Name:");
	static JTextField name_field = new JTextField();
	static JLabel password_label = new JLabel("Password:");
	static JPasswordField password_field = new JPasswordField();
	static JLabel description_label = new JLabel("pleas sign in to proced");
	static JButton enter_button = new JButton("Enter");

	//FRAME #2
	JFrame window_2 = new JFrame("Database Search Engine");
	//COMPONENTS:
	

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
		
		name_label.setBounds(50, 129, 62, 14);
		content_1.add(name_label);
		
		name_field.setBounds(111, 125, 250, 25);
		content_1.add(name_field);
		
		password_label.setBounds(35, 166, 100, 14);
		content_1.add(password_label);
		
		password_field.setBounds(111, 161, 250, 25);
		content_1.add(password_field);
		
		description_label.setBounds(50, 191, 201, 41);
		content_1.add(description_label);
		
		enter_button.setBounds(261, 197, 100, 35);
		content_1.add(enter_button);
	
		return;
	
	}

	

}
