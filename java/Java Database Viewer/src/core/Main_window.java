package core;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JMenuBar;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main_window extends JFrame {

	private JPanel root_panel;

	/**
	 * Launch the application.
	 */
	public static void start(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_window frame = new Main_window();
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
	public Main_window() {
		setTitle("Database Manager");
		setMinimumSize(new Dimension(800, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menu_bar = new JMenuBar();
		setJMenuBar(menu_bar);
		
		JMenu menu_mode = new JMenu("Mode");
		menu_bar.add(menu_mode);
		
		JMenuItem mode_main = new JMenuItem("Main Menu");
		menu_mode.add(mode_main);
		
		JSeparator mode_sep = new JSeparator();
		menu_mode.add(mode_sep);
		
		JMenuItem mode_account = new JMenuItem("Account");
		menu_mode.add(mode_account);
		
		JMenuItem mode_add = new JMenuItem("Add Registry");
		menu_mode.add(mode_add);
		
		JMenuItem mode_view = new JMenuItem("View Database");
		menu_mode.add(mode_view);
		
		JMenuItem mode_update = new JMenuItem("Update Database");
		menu_mode.add(mode_update);
		
		JMenu menu_about = new JMenu("About");
		menu_bar.add(menu_about);
		
		JMenuItem about_database = new JMenuItem("Database");
		about_database.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				//create a new, about_database, object
				About_database.about_database();
				
			}
		});
		menu_about.add(about_database);
		
		JMenuItem about_prefrences = new JMenuItem("Prefrences");
		menu_about.add(about_prefrences);
		
		JSeparator about_sep = new JSeparator();
		menu_about.add(about_sep);
		
		JMenuItem about_logout = new JMenuItem("Log-out");
		menu_about.add(about_logout);
		root_panel = new JPanel();
		root_panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(root_panel);
		SpringLayout sl_root_panel = new SpringLayout();
		root_panel.setLayout(sl_root_panel);
		
		JPanel main = new JPanel();
		main.setBackground(Color.LIGHT_GRAY);
		sl_root_panel.putConstraint(SpringLayout.NORTH, main, 0, SpringLayout.NORTH, root_panel);
		sl_root_panel.putConstraint(SpringLayout.EAST, main, 0, SpringLayout.EAST, root_panel);
		sl_root_panel.putConstraint(SpringLayout.SOUTH, main, 0, SpringLayout.SOUTH, root_panel);
		sl_root_panel.putConstraint(SpringLayout.WEST, main, 0, SpringLayout.WEST, root_panel);
		root_panel.add(main);
		SpringLayout sl_main = new SpringLayout();
		main.setLayout(sl_main);
		
		JPanel view_database = new Database_show();
		view_database.setVisible(false);
		sl_root_panel.putConstraint(SpringLayout.NORTH, view_database, 0, SpringLayout.NORTH, root_panel);
		sl_root_panel.putConstraint(SpringLayout.EAST, view_database, 0, SpringLayout.EAST, root_panel);
		sl_root_panel.putConstraint(SpringLayout.SOUTH, view_database, 0, SpringLayout.SOUTH, root_panel);
		sl_root_panel.putConstraint(SpringLayout.WEST, view_database, 0, SpringLayout.WEST, root_panel);
		root_panel.add(view_database);
		
		JButton button_account = new JButton("Account");
		sl_main.putConstraint(SpringLayout.NORTH, button_account, 30, SpringLayout.NORTH, main);
		sl_main.putConstraint(SpringLayout.WEST, button_account, 10, SpringLayout.WEST, main);
		sl_main.putConstraint(SpringLayout.EAST, button_account, 253, SpringLayout.WEST, main);
		main.add(button_account);
		
		JButton button_add = new JButton("Add Registry");
		sl_main.putConstraint(SpringLayout.NORTH, button_add, 30, SpringLayout.NORTH, main);
		sl_main.putConstraint(SpringLayout.WEST, button_add, 6, SpringLayout.EAST, button_account);
		sl_main.putConstraint(SpringLayout.SOUTH, button_add, 0, SpringLayout.SOUTH, button_account);
		main.add(button_add);
		
		JButton button_view = new JButton("View Database");
		button_view.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				main.setVisible(false);
				view_database.setVisible(true);
				
			}
		});
		sl_main.putConstraint(SpringLayout.SOUTH, button_view, 0, SpringLayout.SOUTH, button_account);
		sl_main.putConstraint(SpringLayout.EAST, button_add, -6, SpringLayout.WEST, button_view);
		sl_main.putConstraint(SpringLayout.NORTH, button_view, 30, SpringLayout.NORTH, main);
		sl_main.putConstraint(SpringLayout.WEST, button_view, -253, SpringLayout.EAST, main);
		main.add(button_view);
		
		JButton button_update = new JButton("Update Database");
		sl_main.putConstraint(SpringLayout.NORTH, button_update, 160, SpringLayout.NORTH, main);
		sl_main.putConstraint(SpringLayout.WEST, button_update, 10, SpringLayout.WEST, main);
		sl_main.putConstraint(SpringLayout.SOUTH, button_update, 300, SpringLayout.NORTH, main);
		sl_main.putConstraint(SpringLayout.EAST, button_update, -10, SpringLayout.EAST, main);
		sl_main.putConstraint(SpringLayout.SOUTH, button_account, -6, SpringLayout.NORTH, button_update);
		sl_main.putConstraint(SpringLayout.EAST, button_view, 0, SpringLayout.EAST, button_update);
		main.add(button_update);
		
		JLabel label_info = new JLabel("Name");
		label_info.setBackground(Color.WHITE);
		sl_main.putConstraint(SpringLayout.NORTH, label_info, 0, SpringLayout.NORTH, main);
		sl_main.putConstraint(SpringLayout.WEST, label_info, 0, SpringLayout.WEST, button_account);
		sl_main.putConstraint(SpringLayout.SOUTH, label_info, -6, SpringLayout.NORTH, button_account);
		sl_main.putConstraint(SpringLayout.EAST, label_info, 0, SpringLayout.EAST, button_view);
		main.add(label_info);
		
		JButton button_database = new JButton("Database");
		button_database.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				//create a new, about_database, object
				About_database.about_database();
				
			}
		});
		sl_main.putConstraint(SpringLayout.NORTH, button_database, 6, SpringLayout.SOUTH, button_update);
		sl_main.putConstraint(SpringLayout.SOUTH, button_database, 40, SpringLayout.SOUTH, button_update);
		sl_main.putConstraint(SpringLayout.EAST, button_database, -10, SpringLayout.EAST, main);
		main.add(button_database);
		
		JButton button_prefrences = new JButton("Prefrences");
		sl_main.putConstraint(SpringLayout.WEST, button_database, 10, SpringLayout.EAST, button_prefrences);
		sl_main.putConstraint(SpringLayout.SOUTH, button_prefrences, 0, SpringLayout.SOUTH, button_database);
		sl_main.putConstraint(SpringLayout.NORTH, button_prefrences, 0, SpringLayout.NORTH, button_database);
		sl_main.putConstraint(SpringLayout.WEST, button_prefrences, 10, SpringLayout.WEST, main);
		sl_main.putConstraint(SpringLayout.EAST, button_prefrences, 386, SpringLayout.WEST, main);
		main.add(button_prefrences);
		
		JButton button_logout = new JButton("Log-out");
		sl_main.putConstraint(SpringLayout.SOUTH, button_logout, -10, SpringLayout.SOUTH, main);
		sl_main.putConstraint(SpringLayout.EAST, button_logout, 0, SpringLayout.EAST, button_view);
		main.add(button_logout);
		
	}
}
