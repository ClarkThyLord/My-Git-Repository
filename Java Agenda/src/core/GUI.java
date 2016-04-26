package core;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.Border;

public class GUI {

	public static JFrame window = new JFrame("Java Agenda");

	//VARIABLES FOR PANEL NUMER ONE
	public static JPanel one = new JPanel();

	public static JLabel text = new JLabel("Initiating...");

	//VARIABLES FOR PANEL NUMER TWO
	public static JPanel two = new JPanel();

	public static Border border = BorderFactory.createLineBorder(Color.BLACK);

	public static JButton year_less = new JButton("<");
	public static JTextField year = new JTextField("Year");
	public static JButton year_more = new JButton(">");
	public static JButton month_less = new JButton("<");
	public static JTextField month = new JTextField("Month");
	public static JButton month_more = new JButton(">");
	public static JButton day_less = new JButton("<");
	public static JTextField day = new JTextField("Day");
	public static JButton day_more = new JButton(">");
	
	public static JButton clear = new JButton("Clear All");
	public static JLabel information = new JLabel("Information:");
	public static JButton enter = new JButton("Enter");
	
	public static JLabel connection = new JLabel("Connection: " + DB_Connection.connection);

	//VARIABLES FOR PANEL NUMER THREE
	public static JPanel three = new JPanel();

	public static JLabel false_connection = new JLabel("Connection to the database wasn't possible, or connection was lost to the database...");
	public static JButton reconnect = new JButton("Reconnect");

	public static void first_stage(){
	
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize( 800, 600);
		window.setResizable(false);
		window.setVisible(true);
	
		window.setContentPane(one);
		one.setBackground(Color.WHITE);
		one.setVisible(true);
	
		text.setBounds(0, 0, 800, 600);
		one.add(text);
		text.setVisible(true);
	
		return;
	
	}

	public static void secound_stage(){
	
		two.setBounds(100, 100, 800, 600);
		two.setLayout(null);
	
		year_less.setBounds(10, 11, 50, 23);
	
		year.setHorizontalAlignment(SwingConstants.CENTER);
		year.setEditable(false);
		year.setBackground(Color.WHITE);
		year.setBorder(border);
		year.setBounds(70, 12, 126, 20);
	
		year_more.setBounds(206, 11, 50, 23);
	
		month_less.setBounds(266, 11, 50, 23);
	
		month.setHorizontalAlignment(SwingConstants.CENTER);
		month.setEditable(false);
		month.setBackground(Color.WHITE);
		month.setBorder(border);
		month.setBounds(326, 12, 126, 20);
	
		month_more.setBounds(462, 11, 50, 23);
	
		day_less.setBounds(522, 11, 50, 23);
	
		day.setHorizontalAlignment(SwingConstants.CENTER);
		day.setEditable(false);
		day.setBackground(Color.WHITE);
		day.setBorder(border);
		day.setBounds(582, 12, 126, 20);
	
		day_more.setBounds(718, 11, 56, 23);
	
		clear.setBounds(10, 45, 246, 30);
	
		information.setHorizontalAlignment(SwingConstants.CENTER);
		information.setBorder(border);
		information.setBounds(266, 45, 246, 30);
	
		enter.setBounds(522, 45, 252, 30);
	
		connection.setBounds(7, 545, 764, 25);
	
		two.add(year_less);
		two.add(year);
		two.add(year_more);
		two.add(month_less);
		two.add(month);
		two.add(month_more);
		two.add(day_less);
		two.add(day);
		two.add(day_more);
		two.add(clear);
		two.add(information);
		two.add(enter);
		two.add(connection);
	
		one.setVisible(false);
		three.setVisible(false);
		window.setContentPane(two);
		two.setVisible(true);
	
		return;
	
	}

	public static void third_stage() {
	
		three.setBounds(100, 100, 800, 600);
		three.setLayout(null);
	
		false_connection.setVerticalAlignment(SwingConstants.TOP);
		false_connection.setHorizontalAlignment(SwingConstants.CENTER);
		false_connection.setBounds(0, 0, 800, 22);
	
		reconnect.setBounds(311, 33, 175, 35);
	
		three.add(false_connection);
		three.add(reconnect);
	
		one.setVisible(false);
		two.setVisible(false);
		window.setContentPane(three);
		three.setVisible(true);
	
	}

}
