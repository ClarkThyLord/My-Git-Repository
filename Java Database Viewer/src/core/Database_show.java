package core;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.table.TableColumn;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class Database_show extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Database_show() {
		setBackground(Color.BLACK);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		
		
		table = new JTable();
		springLayout.putConstraint(SpringLayout.NORTH, table, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, table, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, table, -45, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, table, -10, SpringLayout.EAST, this);
		add(table);
		
		JButton update = new JButton("UPDATE");
		update.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				update.enable(false);
				System.out.println("Updating table...");
				Vector<String> columns = DB_Connection.DB_getColums();
				for(int i = 0; i <= columns.size(); i++){
					
					System.out.println("Adding elemnt " + i + ", " + columns.elementAt(i) + ", from columns...");
					
				}
				update.enable(true);
				
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, update, 6, SpringLayout.SOUTH, table);
		springLayout.putConstraint(SpringLayout.WEST, update, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, update, 35, SpringLayout.SOUTH, table);
		springLayout.putConstraint(SpringLayout.EAST, update, 0, SpringLayout.EAST, table);
		add(update);

	}
}
