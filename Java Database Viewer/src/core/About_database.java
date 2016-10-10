package core;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class About_database extends JFrame {

	private JPanel root_panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	public static void about_database() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About_database frame = new About_database();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public About_database() {
		setTitle("About Database");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		root_panel = new JPanel();
		root_panel.setBackground(Color.LIGHT_GRAY);
		root_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(root_panel);
		root_panel.setLayout(null);
		
		JLabel lblDatabase = new JLabel("Database:");
		lblDatabase.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatabase.setBounds(10, 11, 98, 24);
		root_panel.add(lblDatabase);
		
		JLabel lblDatabaseUrl = new JLabel("Database URL:");
		lblDatabaseUrl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDatabaseUrl.setBounds(10, 65, 98, 24);
		root_panel.add(lblDatabaseUrl);
		
		textField = new JTextField();
		textField.setBounds(107, 65, 377, 24);
		root_panel.add(textField);
		textField.setColumns(10);
		
		JButton btnTestConnection = new JButton("Test Connection");
		btnTestConnection.setBounds(345, 125, 139, 47);
		root_panel.add(btnTestConnection);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(10, 125, 63, 23);
		root_panel.add(lblUsername);
		
		textField_1 = new JTextField();
		textField_1.setBounds(83, 126, 252, 23);
		root_panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(10, 158, 69, 14);
		root_panel.add(lblPassword);
		
		textField_2 = new JTextField();
		textField_2.setBounds(83, 154, 252, 24);
		root_panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblConnection = new JLabel("Connection:");
		lblConnection.setVerticalAlignment(SwingConstants.TOP);
		lblConnection.setBounds(10, 183, 474, 127);
		root_panel.add(lblConnection);
		
		JLabel lblDatabaseName = new JLabel("Database Name:");
		lblDatabaseName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDatabaseName.setBounds(10, 100, 98, 14);
		root_panel.add(lblDatabaseName);
		
		textField_3 = new JTextField();
		textField_3.setBounds(117, 96, 367, 24);
		root_panel.add(textField_3);
		textField_3.setColumns(10);
	}
}
