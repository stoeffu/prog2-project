package ex1;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.regex.Pattern;

import javax.swing.JPanel;

public class EmailPanel extends JPanel {
	private GUI guiRef;
	private String email;
	
	public EmailPanel(GUI gui) {
		super();
		guiRef=gui;
	}
	
	@Override
	public void paint (Graphics g) {
		super.paint(g);
		email=guiRef.getEmail();
		Graphics2D g2 = (Graphics2D) g;
		g2 = GUI.formatG2(g2);
		g2.drawString(email, 10, 30);
	}
	
	
}
