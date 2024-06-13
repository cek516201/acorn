package frame07;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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

		inputMsg = new JTextField(10);
		add(inputMsg);

		JButton sendBtn = new JButton("전송");
		sendBtn.addActionListener(this);
		add(sendBtn);

		// 화면상에 보이도록 한다
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, inputMsg);
	}

	private JTextField inputMsg;
}