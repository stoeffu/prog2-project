package ex1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.*;

public class GUI extends JFrame {
	
	JLabel label;
	EmailPanel panel;
	JTextField textField;
	String email;
	JButton button;
	ImagePrinter printer = new ImagePrinter();
	boolean success;
	
	public GUI (String title) {
		super(title);
		setSize(400,160);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		email = "";
		
		setLayout(new FlowLayout());
		label = new JLabel("E-mail address:");
		add(label);
		
		textField = new JTextField(20);
		add(textField);
		
		panel = new EmailPanel(this);
		panel.setPreferredSize(new Dimension(350,50));
		panel.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
		add(panel);
		
		button = new JButton("Save");
		add(button);
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!printer.isEmailValid(email)) {
					JOptionPane.showMessageDialog(panel, "Please enter a valid e-mail address!", "Not valid", JOptionPane.ERROR_MESSAGE);
					clearInputs();
					return;
				}
				
				JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
				int atPos = email.indexOf('@');
				String fileName = email.substring(0, atPos);
				fc.setSelectedFile(new File(fileName + ".PNG"));
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnVal = fc.showSaveDialog(null);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            String outputFilePath = fc.getSelectedFile().getAbsolutePath();
		            success = printer.printPng(email, outputFilePath);
		            if (success) stopProgram();
				}
				
				
			}
			
		});
		
		KeyListener enterListener = new KeyAdapter() {
			public void keyPressed (KeyEvent evt) {
				if (evt.getKeyCode() == KeyEvent.VK_ENTER) button.doClick();
			}
		};
		textField.addKeyListener(enterListener);
		
	}
	
	public String getEmail() {
		return email;
	}
	
	public boolean run () {
		email = textField.getText();
		panel.repaint();
		return success;
	}
	
	public void clearInputs() {
		textField.setText("");
		email="";
	}
	
	public void stopProgram () {
		JOptionPane.showMessageDialog(panel, "The image was successfully created!", "Success", JOptionPane.PLAIN_MESSAGE);
		this.dispose();
	}
	
	public static Graphics2D formatG2(Graphics2D g2) {
		g2.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
		g2.setPaint(Color.black);
		return g2;
	}

}
