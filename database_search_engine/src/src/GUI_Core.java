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
	static JTextField name_button = new JTextField();
	static JLabel name_label = new JLabel();
	static JPasswordField password_button = new JPasswordField();
	static JLabel password_label = new JLabel();
	static JLabel description_label = new JLabel();
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
	
		title_label.setBounds(109, 93, 225, 40);
		content_1.add(title_label);
	
		return;
	
	}

	

}
