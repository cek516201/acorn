package frame01;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public MyFrame() {
		// 제목설정
		this.setTitle("MyFrame");

		// 위치와 크기 설정
		this.setBounds(100, 100, 500, 500);

		// 종료했을 때 프로세스 전체가 종료되도록 한다
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 화면상에 보이도록 한다
		this.setVisible(true);
	}
}