package core;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class DB_window extends JFrame {

	private JPanel contentPane;
	private JTextField year_t;
	private JTextField month_t;
	private JTextField day_t;
	private JTextField hour_t;
	private JTextField minute_t;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DB_window frame = new DB_window();
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
	public DB_window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel operation = new JLabel("Adding Appointment");
		operation.setBounds(10, 11, 414, 14);
		contentPane.add(operation);
		
		JButton add = new JButton("Add");
		add.setBounds(10, 36, 89, 23);
		contentPane.add(add);
		
		JButton subtract = new JButton("Subtract");
		subtract.setBounds(109, 36, 89, 23);
		contentPane.add(subtract);
		
		JButton enter = new JButton("Enter");
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		enter.setBounds(343, 69, 81, 151);
		contentPane.add(enter);
		
		JLabel year_l = new JLabel("Year:");
		year_l.setBounds(10, 86, 46, 14);
		contentPane.add(year_l);
		
		JLabel month_l = new JLabel("Month:");
		month_l.setBounds(10, 111, 46, 14);
		contentPane.add(month_l);
		
		JLabel day_l = new JLabel("Day:");
		day_l.setBounds(10, 136, 46, 14);
		contentPane.add(day_l);
		
		JLabel hour_l = new JLabel("Hour:");
		hour_l.setBounds(10, 161, 46, 14);
		contentPane.add(hour_l);
		
		JLabel minute_l = new JLabel("Minute:");
		minute_l.setBounds(10, 186, 46, 14);
		contentPane.add(minute_l);
		
		year_t = new JTextField();
		year_t.setBounds(66, 83, 267, 20);
		contentPane.add(year_t);
		year_t.setColumns(10);
		
		month_t = new JTextField();
		month_t.setColumns(10);
		month_t.setBounds(66, 108, 267, 20);
		contentPane.add(month_t);
		
		day_t = new JTextField();
		day_t.setColumns(10);
		day_t.setBounds(66, 133, 267, 20);
		contentPane.add(day_t);
		
		hour_t = new JTextField();
		hour_t.setColumns(10);
		hour_t.setBounds(66, 158, 267, 20);
		contentPane.add(hour_t);
		
		minute_t = new JTextField();
		minute_t.setColumns(10);
		minute_t.setBounds(66, 183, 267, 20);
		contentPane.add(minute_t);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(208, 26, 46, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(233, 8, 191, 51);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
