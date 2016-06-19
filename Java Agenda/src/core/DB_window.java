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
import java.awt.Font;

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
		setBounds(100, 100, 450, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel operation = new JLabel("Adding or Removing Dates");
		operation.setFont(new Font("Yu Mincho Demibold", Font.PLAIN, 18));
		operation.setBounds(107, 11, 235, 30);
		contentPane.add(operation);
		
		JButton add = new JButton("Add");
		add.setBounds(335, 52, 89, 64);
		contentPane.add(add);
		
		JButton subtract = new JButton("Remove");
		subtract.setBounds(335, 127, 89, 64);
		contentPane.add(subtract);
		
		JLabel year_l = new JLabel("Year:");
		year_l.setBounds(10, 77, 46, 14);
		contentPane.add(year_l);
		
		JLabel month_l = new JLabel("Month:");
		month_l.setBounds(10, 102, 46, 14);
		contentPane.add(month_l);
		
		JLabel day_l = new JLabel("Day:");
		day_l.setBounds(10, 127, 46, 14);
		contentPane.add(day_l);
		
		JLabel hour_l = new JLabel("Hour:");
		hour_l.setBounds(10, 152, 46, 14);
		contentPane.add(hour_l);
		
		JLabel minute_l = new JLabel("Minute:");
		minute_l.setBounds(10, 177, 46, 14);
		contentPane.add(minute_l);
		
		year_t = new JTextField();
		year_t.setBounds(58, 74, 267, 20);
		contentPane.add(year_t);
		year_t.setColumns(10);
		
		month_t = new JTextField();
		month_t.setColumns(10);
		month_t.setBounds(58, 99, 267, 20);
		contentPane.add(month_t);
		
		day_t = new JTextField();
		day_t.setColumns(10);
		day_t.setBounds(58, 124, 267, 20);
		contentPane.add(day_t);
		
		hour_t = new JTextField();
		hour_t.setColumns(10);
		hour_t.setBounds(58, 149, 267, 20);
		contentPane.add(hour_t);
		
		minute_t = new JTextField();
		minute_t.setColumns(10);
		minute_t.setBounds(58, 174, 267, 20);
		contentPane.add(minute_t);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 52, 38, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(58, 49, 267, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
