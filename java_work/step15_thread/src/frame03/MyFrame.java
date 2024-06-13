package frame03;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener {
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
		var startBtn = new JButton("countdown");
		startBtn.addActionListener(this);
		add(startBtn);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// new Thread(new CountRunnable()).start();

//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				int count = 10;
//				while (true) {
//					System.out.println(count);
//					if (count <= 0) {
//						break;
//					}
//
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					count--;
//				}
//
//				// Runnable a = this;
//			}
//		}).start();

		new Thread(() -> {
			int count = 10;
			while (true) {
				System.out.println(count);
				if (count <= 0) {
					break;
				}

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				count--;
			}

			// MyFrame a = this;
		}).start();
	}
}