package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUI_1 extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_1 frame = new GUI_1();
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
	public GUI_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(111, 161, 250, 25);
		contentPane.add(passwordField);
		
		JLabel lblPasword = new JLabel("pasword:");
		lblPasword.setBounds(55, 166, 46, 14);
		contentPane.add(lblPasword);
		
		JLabel lblUserName = new JLabel("user name:");
		lblUserName.setBounds(50, 129, 62, 14);
		contentPane.add(lblUserName);
		
		textField = new JTextField();
		textField.setBounds(111, 125, 250, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblWelcomeToA = new JLabel("Welcome To A Java Database Search Engine");
		lblWelcomeToA.setBounds(109, 93, 225, 25);
		contentPane.add(lblWelcomeToA);
		
		JButton btnEntre = new JButton("Enter");
		btnEntre.setBounds(261, 197, 100, 35);
		contentPane.add(btnEntre);
		
		JLabel label = new JLabel("");
		label.setBounds(50, 191, 201, 41);
		contentPane.add(label);
	}
}
