package frame02;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public static void main(String[] args) {
		new MyFrame();
	}

	public MyFrame() {
		// 제목설정
		this.setTitle("MyFrame");

		// 위치와 크기 설정
		this.setBounds(100, 100, 500, 500);

		// 종료했을 때 프로세스 전체가 종료되도록 한다
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		setLayout(layout);

		JButton btn1 = new JButton("버튼1");
		this.add(btn1);
		this.add(new JButton());
		this.add(new JButton());

		// 화면상에 보이도록 한다
		this.setVisible(true);
	}
}