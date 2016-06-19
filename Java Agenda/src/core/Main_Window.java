package core;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollBar;
import java.awt.Font;
import javax.swing.JMenuBar;

public class Main_Window extends JFrame {

	private JPanel contentPane;
	private JTextField year;
	private JTextField month;
	private JTextField day;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Window frame = new Main_Window();
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
	public Main_Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton year_less = new JButton("<");
		year_less.setBounds(10, 11, 50, 23);
		contentPane.add(year_less);
		
		year = new JTextField();
		year.setHorizontalAlignment(SwingConstants.CENTER);
		year.setEditable(false);
		year.setText("year");
		year.setBounds(70, 12, 126, 20);
		contentPane.add(year);
		year.setColumns(10);
		
		JButton year_more = new JButton(">");
		year_more.setBounds(206, 11, 50, 23);
		contentPane.add(year_more);
		
		JButton month_less = new JButton("<");
		month_less.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		month_less.setBounds(266, 11, 50, 23);
		contentPane.add(month_less);
		
		month = new JTextField();
		month.setHorizontalAlignment(SwingConstants.CENTER);
		month.setEditable(false);
		month.setText("month");
		month.setBounds(326, 12, 126, 20);
		contentPane.add(month);
		month.setColumns(10);
		
		JButton month_more = new JButton(">");
		month_more.setBounds(462, 11, 50, 23);
		contentPane.add(month_more);
		
		JButton day_less = new JButton("<");
		day_less.setBounds(522, 11, 50, 23);
		contentPane.add(day_less);
		
		day = new JTextField();
		day.setHorizontalAlignment(SwingConstants.CENTER);
		day.setEditable(false);
		day.setText("day");
		day.setBounds(582, 12, 126, 20);
		contentPane.add(day);
		day.setColumns(10);
		
		JButton day_more = new JButton(">");
		day_more.setBounds(718, 11, 56, 23);
		contentPane.add(day_more);
		
		JButton clear = new JButton("Clear");
		clear.setBounds(10, 45, 246, 30);
		contentPane.add(clear);
		
		JButton enter = new JButton("Enter");
		enter.setBounds(522, 45, 252, 30);
		contentPane.add(enter);
		
		JLabel information = new JLabel("Information");
		information.setHorizontalAlignment(SwingConstants.CENTER);
		information.setBounds(266, 45, 246, 30);
		contentPane.add(information);
		
		JLabel lblConnection = new JLabel("Connection:");
		lblConnection.setBounds(10, 515, 764, 25);
		contentPane.add(lblConnection);
		
		JButton btnNewButton = new JButton("+/-");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(729, 86, 50, 50);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		textArea.setEditable(false);
		textArea.setBackground(Color.GRAY);
		textArea.setBounds(10, 86, 709, 430);
		contentPane.add(textArea);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBackground(Color.WHITE);
		scrollBar.setBounds(739, 147, 35, 369);
		contentPane.add(scrollBar);
	}
}
