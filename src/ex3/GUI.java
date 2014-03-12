package ex3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JFrame {
	private JLabel labelTitle;
	private JLabel labelText;
	private JTextField textField;
	private JButton button;
	private int creditCardNumber;
	
	
	public GUI (String title) {
		super(title);
		setSize(400,180);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
				
		setLayout(new FlowLayout());
		labelTitle = new JLabel("Credit Card Checker");
		labelTitle.setForeground(Color.BLUE);
		labelTitle.setFont(new Font("Verdana", Font.BOLD, 20));
		add(labelTitle);
		
		labelText = new JLabel("Enter credit card number: ");
		add(labelText);
		
		textField = new JTextField(20);
		add(textField);
		
		button = new JButton("Check");
		add(button);
	}
	
	public void cleanseNumber() {
		String test = textField.getText();
		int posOk=0;
		
		
		for (int i=0; i<test.length(); i++) {
			if(Character.isDigit(test.charAt(i))) posOk=i;
		}
		
		if (test.length()>0) textField.setText(test.substring(0,posOk+1));
		
	}
}
