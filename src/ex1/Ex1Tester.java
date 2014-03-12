package ex1;

public class Ex1Tester {
	private static boolean finished;
	
	public static void main(String[] args) {
		GUI gui = new GUI("E-Mail Printer");
		gui.setVisible(true);
		while (!finished) {
			finished = gui.run();
		}
	}

}
