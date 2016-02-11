package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(130, 19, 36, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(162, 11, 304, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(130, 59, 27, 14);
		contentPane.add(lblDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(162, 52, 150, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("-");
		label.setBounds(199, 51, 15, 14);
		contentPane.add(label);
		
		textField_2 = new JTextField();
		textField_2.setBounds(331, 52, 150, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(486, 19, 15, 14);
		contentPane.add(lblId);
		
		textField_3 = new JTextField();
		textField_3.setBounds(508, 13, 96, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnEntre = new JButton("Enter");
		btnEntre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEntre.setBounds(491, 51, 116, 31);
		contentPane.add(btnEntre);
	}
}
