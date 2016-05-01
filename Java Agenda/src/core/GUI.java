package core;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

public class GUI {

	public static JFrame main_window = new JFrame("Java Agenda");
	public static JFrame DB_window = new JFrame("Add Appointment to Agenda");
	public static JPanel panel = new JPanel();
	public static JPanel panel_1 = new JPanel();
	public static JPanel panel_2= new JPanel();
	public static JPanel panel_3= new JPanel();
	public static JPanel panel_4 = new JPanel();

	public static JButton DB_portal = new JButton("+/-");

	//VARIABLES FOR PANEL NUMER ONE

	public static JLabel starup_label = new JLabel("Initiating...");

	//VARIABLES FOR PANEL NUMER TWO

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
	public static JButton enter_1 = new JButton("Enter");
	
	public static JTextArea textArea = new JTextArea();
	public static JScrollBar scrollBar = new JScrollBar();
	
	public static JLabel connection = new JLabel("Connection: " + DB_Connection.connection);

	//VARIABLES FOR PANEL NUMER THREE

	public static JLabel false_connection = new JLabel("Connection to the database wasn't possible, or connection was lost to the database...");
	public static JButton reconnect = new JButton("Reconnect");

	//VARIABLES FOR DB WINDOW
	public static JLabel operation = new JLabel("Adding an Appointment to Agenda");
	public static JButton add = new JButton("Add");
	public static JButton subtract = new JButton("Subtract");
	public static JLabel name_l = new JLabel("Name:");
	public static JTextField name_t = new JTextField();
	public static JLabel year_l = new JLabel("Year:");
	public static JTextField year_t = new JTextField();
	public static JLabel month_l = new JLabel("Month:");
	public static JTextField month_t = new JTextField();
	public static JLabel day_l = new JLabel("Day:");
	public static JTextField day_t = new JTextField();
	public static JLabel hour_l = new JLabel("Hour:");
	public static JTextField hour_t = new JTextField();
	public static JLabel minute_l = new JLabel("Minute:");
	public static JTextField minute_t = new JTextField();
	public static JButton enter_2 = new JButton("Enter");

	public static int DBchange = 0;

	public static void startup(){
	
		main_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_window.setSize( 800, 600);
		main_window.setVisible(true);
	
		main_window.setResizable(false);
		DB_window.setResizable(false);
	
		//PANEL PROPERTIES
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBounds(0, 0, 800, 600);
		main_window.setContentPane(panel);
		panel.setVisible(true);	
	
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 800, 600);
		panel.add(panel_1);
		panel_1.setVisible(false);
	
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		panel_2.setBounds(0, 0, 800, 600);
		panel.add(panel_2);
		panel_2.setVisible(false);
	
		panel_3.setBackground(Color.WHITE);
		panel_3.setLayout(null);
		panel_3.setBounds(0, 0, 800, 600);
		panel.add(panel_3);
		panel_3.setVisible(false);
	
		//OBJECT PROPERTIES
		//FIRST PANEL
		starup_label.setBounds(0, 0, 800, 600);
		starup_label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(starup_label);
		starup_label.setVisible(true);
	
		panel_1.setVisible(true);
	
		//SECOUND PANEL
		panel_1.setVisible(false);
		panel_3.setVisible(false);
	
		year_less.setBounds(10, 11, 50, 23);
		year_less.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {	}});
		year_less.setVisible(true);
	
		year.setHorizontalAlignment(SwingConstants.CENTER);
		year.setEditable(true);
		year.setBackground(Color.WHITE);
		year.setBorder(border);
		year.setBounds(70, 12, 126, 20);
		year.setVisible(true);
	
		year_more.setBounds(206, 11, 50, 23);
		year_more.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {	}});
		year_more.setVisible(true);
	
		month_less.setBounds(266, 11, 50, 23);
		month_less.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {	}});
		month_less.setVisible(true);
	
		month.setHorizontalAlignment(SwingConstants.CENTER);
		month.setEditable(true);
		month.setBackground(Color.WHITE);
		month.setBorder(border);
		month.setBounds(326, 12, 126, 20);
		month.setVisible(true);
	
		month_more.setBounds(462, 11, 50, 23);
		month_more.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {	}});
		month_more.setVisible(true);
	
		day_less.setBounds(522, 11, 50, 23);
		day_less.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {	}});
		day_less.setVisible(true);
	
		day.setHorizontalAlignment(SwingConstants.CENTER);
		day.setEditable(true);
		day.setBackground(Color.WHITE);
		day.setBorder(border);
		day.setBounds(582, 12, 126, 20);
		day.setVisible(true);
	
		day_more.setBounds(718, 11, 56, 23);
		day_more.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {	}});
		day_more.setVisible(true);
	
		clear.setBounds(10, 45, 246, 30);
		clear.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {	year.setText(""); month.setText(""); day.setText("");}});
		clear.setVisible(true);
	
		information.setHorizontalAlignment(SwingConstants.CENTER);
		information.setBorder(border);
		information.setBounds(266, 45, 246, 30);
		information.setVisible(true);
	
		enter_1.setBounds(522, 45, 252, 30);
		enter_1.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {	DB_Connection.year_s = year.getText();DB_Connection.month_s = month.getText();DB_Connection.day_s = day.getText(); DB_Connection.DB_search();}});
		enter_1.setVisible(true);
	
		DB_portal.setBounds(729, 86, 50, 50);
		DB_portal.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {	DB_window();}});
	
		textArea.setEditable(false);
		textArea.setBackground(Color.GRAY);
		textArea.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		textArea.setBounds(10, 86, 709, 430);
		textArea.setVisible(true);
	
		scrollBar.setBackground(Color.WHITE);
		scrollBar.setBounds(739, 147, 35, 369);
		scrollBar.setVisible(true);
	
		connection.setBounds(7, 545, 764, 25);
		connection.setVisible(true);
	
		panel_2.add(year_less);
		panel_2.add(year);
		panel_2.add(year_more);
		panel_2.add(month_less);
		panel_2.add(month);
		panel_2.add(month_more);
		panel_2.add(day_less);
		panel_2.add(day);
		panel_2.add(day_more);
		panel_2.add(clear);
		panel_2.add(information);
		panel_2.add(enter_1);
		panel_2.add(DB_portal);
		panel_2.add(textArea);
		panel_2.add(scrollBar);
		panel_2.add(connection);
	
		//THIRD PANEL
		false_connection.setVerticalAlignment(SwingConstants.TOP);
		false_connection.setHorizontalAlignment(SwingConstants.CENTER);
		false_connection.setBounds(0, 0, 800, 22);
		false_connection.setVisible(true);
	
		reconnect.setBounds(311, 33, 175, 35);
		reconnect.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {	DB_Connection.DB_startup();}});
		reconnect.setVisible(true);
	
		panel_3.add(false_connection);
		panel_3.add(reconnect);
	
	}

	public static void DB_window(){
	
		DB_window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		DB_window.setBounds(100, 100, 450, 270);
		panel_4.setSize(450,270);
		panel_4.setLayout(null);
		DB_window.setContentPane(panel_4);
		panel_4.setVisible(true);
	
		operation.setBounds(10, 11, 414, 14);
		operation.setVisible(true);
	
		add.setBounds(10, 36, 89, 23);
		add.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {	DB_window.setTitle("Adding an Appointment to Agenda");operation.setText("Adding an Appointment to Agenda"); DBchange =0;}});
		add.setVisible(true);
	
		subtract.setBounds(109, 36, 89, 23);
		subtract.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {	DB_window.setTitle("Subtracting an Appointment to Agenda");operation.setText("Subtracting an Appointment to Agenda"); DBchange = 1;}});
		subtract.setVisible(true);
	
		name_l.setBounds(201, 26, 46, 14);
		name_t.setBounds(233, 8, 191, 51);
	
		enter_2.setBounds(343, 69, 81, 151);
		enter_2.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {	
		DB_Connection.name_db = name_t.getText();DB_Connection.year = year_t.getText();DB_Connection.month = month_t.getText();DB_Connection.day = day_t.getText();DB_Connection.hour = hour_t.getText();DB_Connection.minute = minute_t.getText();
		if(DBchange == 0){	DB_Connection.DB_adding();} if(DBchange == 1){	DB_Connection.DB_subtracting();
		
		}}});
		enter_2.setVisible(true);
	
		year_l.setBounds(10, 86, 46, 14);
		year_l.setVisible(true);
	
		month_l.setBounds(10, 111, 46, 14);
		month_l.setVisible(true);
	
		day_l.setBounds(10, 136, 46, 14);
		day_l.setVisible(true);
	
		hour_l.setBounds(10, 161, 46, 14);
		hour_l.setVisible(true);
	
		minute_l.setBounds(10, 186, 46, 14);
		minute_l.setVisible(true);
	
		year_t.setBounds(66, 83, 267, 20);
		year_t.setVisible(true);
	
		month_t.setBounds(66, 108, 267, 20);
		month_t.setVisible(true);
	
		day_t.setBounds(66, 133, 267, 20);
		day_t.setVisible(true);
	
		hour_t.setBounds(66, 158, 267, 20);
		hour_t.setVisible(true);
	
		minute_t.setBounds(66, 183, 267, 20);
		minute_t.setVisible(true);
	
		panel_4.add(operation);
		panel_4.add(add);
		panel_4.add(subtract);
		panel_4.add(name_l);
		panel_4.add(name_t);
		panel_4.add(enter_2);
		panel_4.add(year_l);
		panel_4.add(month_l);
		panel_4.add(day_l);
		panel_4.add(hour_l);
		panel_4.add(minute_l);
		panel_4.add(year_t);
		panel_4.add(month_t);
		panel_4.add(day_t);
		panel_4.add(hour_t);
		panel_4.add(minute_t);
	
		panel_4.setVisible(true);
		DB_window.setVisible(true);
	
	}

}
