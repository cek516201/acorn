package frame04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener {
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

		// 레이아웃 매니저 객체 생성
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		this.setLayout(layout);

		JButton btn1 = new JButton("버튼1");
		this.add(btn1);
		btn1.addActionListener(this);

		// 화면상에 보이도록 한다
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("button1");
	}
}