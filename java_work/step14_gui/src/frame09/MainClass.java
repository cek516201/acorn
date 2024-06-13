package frame09;

import javax.swing.JFrame;

public class MainClass {
	public static void main(String[] args) {
		MyFrame f = new MyFrame("MyFrame");
		// f.setTitle("MyFrame");
		f.setBounds(500, 250, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
