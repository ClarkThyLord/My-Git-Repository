package src;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUI_2 extends JFrame {

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
					GUI_2 frame = new GUI_2();
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
	public GUI_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(20, 36, 31, 14);
		contentPane.add(lblName);
		
		JLabel lblfilters = new JLabel("~Filters~");
		lblfilters.setBounds(10, 11, 46, 14);
		contentPane.add(lblfilters);
		
		textField = new JTextField();
		textField.setBounds(63, 31, 400, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(473, 36, 15, 14);
		contentPane.add(lblId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(498, 31, 99, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Clear All Filters");
		btnNewButton.setBounds(607, 32, 167, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Date(s):");
		lblNewLabel.setBounds(20, 73, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(73, 67, 200, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(293, 67, 200, 25);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label = new JLabel("-");
		label.setBounds(280, 73, 15, 14);
		contentPane.add(label);
		
		JButton btnEntre = new JButton("Enter");
		btnEntre.setBounds(607, 66, 167, 38);
		contentPane.add(btnEntre);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(534, 0, 250, 15);
		contentPane.add(label_1);
	}

}
