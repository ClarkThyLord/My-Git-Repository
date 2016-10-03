package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.SpringLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sync_Frame extends JFrame {

	private JPanel root_panel;

	/**
	 * Launch the application.
	 */
	public static void creat_window() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sync_Frame frame = new Sync_Frame();
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
	public Sync_Frame() {
		setTitle("Sync");
		setMinimumSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		JMenu modes = new JMenu("Mode");
		menu.add(modes);
		
		JMenuItem text_mode = new JMenuItem("Text");
		modes.add(text_mode);
		
		JMenuItem source_mode = new JMenuItem("Source");
		modes.add(source_mode);
		
		JMenuItem command_mode = new JMenuItem("Command");
		modes.add(command_mode);
		
		root_panel = new JPanel();
		root_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(root_panel);
		SpringLayout sl_root_panel = new SpringLayout();
		root_panel.setLayout(sl_root_panel);
		
		JPanel text_panel = new JPanel();
		text_panel.setAutoscrolls(true);
		sl_root_panel.putConstraint(SpringLayout.NORTH, text_panel, 0, SpringLayout.NORTH, root_panel);
		sl_root_panel.putConstraint(SpringLayout.WEST, text_panel, 0, SpringLayout.WEST, root_panel);
		sl_root_panel.putConstraint(SpringLayout.SOUTH, text_panel, 0, SpringLayout.SOUTH, root_panel);
		sl_root_panel.putConstraint(SpringLayout.EAST, text_panel, 0, SpringLayout.EAST, root_panel);
		text_panel.setBackground(Color.GRAY);
		root_panel.add(text_panel);
		SpringLayout sl_text_panel = new SpringLayout();
		text_panel.setLayout(sl_text_panel);
		
		JTextArea input = new JTextArea();
		sl_text_panel.putConstraint(SpringLayout.SOUTH, input, -130, SpringLayout.SOUTH, text_panel);
		input.setAutoscrolls(false);
		sl_text_panel.putConstraint(SpringLayout.WEST, input, 10, SpringLayout.WEST, text_panel);
		sl_text_panel.putConstraint(SpringLayout.EAST, input, -10, SpringLayout.EAST, text_panel);
		input.setLineWrap(true);
		sl_text_panel.putConstraint(SpringLayout.NORTH, input, 10, SpringLayout.NORTH, text_panel);
		text_panel.add(input);
		
		JLabel info = new JLabel("New label");
		sl_text_panel.putConstraint(SpringLayout.NORTH, info, 15, SpringLayout.SOUTH, input);
		sl_text_panel.putConstraint(SpringLayout.WEST, info, 10, SpringLayout.WEST, text_panel);
		sl_text_panel.putConstraint(SpringLayout.SOUTH, info, -13, SpringLayout.SOUTH, text_panel);
		sl_text_panel.putConstraint(SpringLayout.EAST, info, -139, SpringLayout.EAST, text_panel);
		info.setVerticalAlignment(SwingConstants.TOP);
		info.setForeground(Color.WHITE);
		info.setBackground(Color.WHITE);
		text_panel.add(info);
		
		JButton enter = new JButton("Enter");
		enter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String text = input.getText();
				send_input(text);
				
			}
		});
		sl_text_panel.putConstraint(SpringLayout.NORTH, enter, 0, SpringLayout.NORTH, info);
		sl_text_panel.putConstraint(SpringLayout.WEST, enter, 6, SpringLayout.EAST, info);
		sl_text_panel.putConstraint(SpringLayout.SOUTH, enter, 52, SpringLayout.SOUTH, input);
		sl_text_panel.putConstraint(SpringLayout.EAST, enter, 0, SpringLayout.EAST, input);
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		text_panel.add(enter);
		
		//text_panel.setVisible(false);
		
		JPanel source_panel = new Source_panel();
		sl_root_panel.putConstraint(SpringLayout.NORTH, source_panel, 0, SpringLayout.NORTH, root_panel);
		sl_root_panel.putConstraint(SpringLayout.WEST, source_panel, 0, SpringLayout.WEST, root_panel);
		sl_root_panel.putConstraint(SpringLayout.SOUTH, source_panel, 0, SpringLayout.SOUTH, root_panel);
		sl_root_panel.putConstraint(SpringLayout.EAST, source_panel, 0, SpringLayout.EAST, root_panel);
		root_panel.add(source_panel);
		source_panel.setVisible(false);
		
		text_mode.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				source_panel.setVisible(false);
				text_panel.setVisible(true);
				
			}
		});
		
		source_mode.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				text_panel.setVisible(false);
				source_panel.setVisible(true);
				
			}
		});
		
	}
	
	public static void send_input(String text){
		
		System.out.println("Sending input...\n" + text);
		
		
	}
	
}
