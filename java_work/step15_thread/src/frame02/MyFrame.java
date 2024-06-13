package frame02;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame {
	// Main Thread
	public static void main(String[] args) {
		MyFrame f = new MyFrame("MyFrame");
		f.setBounds(500, 250, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public MyFrame(String title) {
		super(title);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		// type 추론이 가능하다면 지역변수 type 대신 선언 가능
		// java 10에서 추가된 문법, 실무에서 1.8버전을 쓰는 곳이 많아서 주의 필요
		// 지역변수에만 가능, 필드는 안됨
		// null로 초기화 불가
		var startBtn = new JButton("작업시작");
		startBtn.addActionListener((e) -> {
			System.out.println("sleep 10초");
			try {
				Thread.sleep(1000 * 10);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("sleep 끝");
		});
		add(startBtn);

		var startBtn2 = new JButton("작업시작2");
		startBtn2.addActionListener((e) -> {
			new WorkThread().start();
		});
		add(startBtn2);
	}

	class WorkThread extends Thread {
		@Override
		public void run() {
			System.out.println("sleep 3초");
			try {
				Thread.sleep(1000 * 3);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(MyFrame.this, "작업 종료");
		}
	}
}