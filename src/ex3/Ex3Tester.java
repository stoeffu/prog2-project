package ex3;

public class Ex3Tester {

	public static void main(String[] args) {
		GUI cardGUI = new GUI("Credit Card Number Checker");
		cardGUI.setVisible(true);
		
		while(true) {
			cardGUI.cleanseNumber();
		}
	}

}
