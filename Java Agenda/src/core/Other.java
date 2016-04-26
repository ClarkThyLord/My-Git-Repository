package core;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Other extends JPanel {

	/**
	 * Create the panel.
	 */
	public Other() {
		setLayout(null);
		
		JLabel lblConnectionToDatabse = new JLabel("Connection to databse was not possible....");
		lblConnectionToDatabse.setVerticalAlignment(SwingConstants.TOP);
		lblConnectionToDatabse.setHorizontalAlignment(SwingConstants.CENTER);
		lblConnectionToDatabse.setBounds(0, 0, 800, 22);
		add(lblConnectionToDatabse);
		
		JButton btnReconnect = new JButton("Reconnect");
		btnReconnect.setBounds(311, 33, 175, 35);
		add(btnReconnect);

	}
}
