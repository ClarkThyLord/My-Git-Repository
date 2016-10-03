package source;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;

public class Source_panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public Source_panel() {
		setBackground(Color.GRAY);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JTextArea output = new JTextArea();
		springLayout.putConstraint(SpringLayout.NORTH, output, 10, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, output, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, output, -111, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, output, -10, SpringLayout.EAST, this);
		output.setEnabled(false);
		output.setLineWrap(true);
		add(output);
		
		JLabel label0 = new JLabel("Source Showing ~");
		springLayout.putConstraint(SpringLayout.WEST, label0, 10, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, label0, -86, SpringLayout.SOUTH, this);
		label0.setFont(new Font("Times New Roman", Font.BOLD, 16));
		add(label0);
		
		JRadioButton text_toggle = new JRadioButton("Text");
		springLayout.putConstraint(SpringLayout.NORTH, text_toggle, 6, SpringLayout.SOUTH, label0);
		springLayout.putConstraint(SpringLayout.WEST, text_toggle, 10, SpringLayout.WEST, this);
		text_toggle.setBackground(Color.GRAY);
		text_toggle.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(text_toggle);
		
		JRadioButton sentences_toggle = new JRadioButton("Sentences");
		springLayout.putConstraint(SpringLayout.NORTH, sentences_toggle, 6, SpringLayout.SOUTH, label0);
		springLayout.putConstraint(SpringLayout.WEST, sentences_toggle, 6, SpringLayout.EAST, text_toggle);
		sentences_toggle.setBackground(Color.GRAY);
		sentences_toggle.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(sentences_toggle);
		
		JRadioButton words_toggle = new JRadioButton("Words");
		springLayout.putConstraint(SpringLayout.NORTH, words_toggle, 0, SpringLayout.NORTH, text_toggle);
		springLayout.putConstraint(SpringLayout.WEST, words_toggle, 6, SpringLayout.EAST, sentences_toggle);
		words_toggle.setBackground(Color.GRAY);
		words_toggle.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(words_toggle);
		
		JRadioButton commands_toggle = new JRadioButton("Commands");
		springLayout.putConstraint(SpringLayout.NORTH, commands_toggle, 6, SpringLayout.SOUTH, sentences_toggle);
		springLayout.putConstraint(SpringLayout.WEST, commands_toggle, 0, SpringLayout.WEST, sentences_toggle);
		commands_toggle.setFont(new Font("Tahoma", Font.BOLD, 13));
		commands_toggle.setBackground(Color.GRAY);
		add(commands_toggle);
		
		JButton update = new JButton("Update");
		springLayout.putConstraint(SpringLayout.NORTH, update, 0, SpringLayout.NORTH, text_toggle);
		springLayout.putConstraint(SpringLayout.WEST, update, -169, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, update, -30, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, update, 0, SpringLayout.EAST, output);
		add(update);

	}
}
