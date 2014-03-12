package ex1;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

public class ImagePrinter {
	
	private final int WIDTH = 350;
	private final int HEIGHT = 100;
	BufferedImage bi;
	Graphics2D g2;
	
	public ImagePrinter() {
		bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
		g2 = bi.createGraphics();
		g2 = GUI.formatG2(g2);
	}
	
	public boolean printPng(String email, String outputFilePath) {
		if (!isEmailValid(email)) return false;
		
		FontMetrics fontMet = g2.getFontMetrics();
		int emailWidth = fontMet.stringWidth(email);
		int emailHeight = fontMet.getAscent();
		g2.drawString(email, (WIDTH-emailWidth)/2, HEIGHT/2 + emailHeight/4);
		
		try {
			if (!outputFilePath.toLowerCase().endsWith(".png")) outputFilePath += ".PNG";
			ImageIO.write(bi, "PNG", new File (outputFilePath));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isEmailValid (String email) {
		final Pattern rfc2822 = Pattern.compile("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
		return rfc2822.matcher(email).matches();
	}
}
