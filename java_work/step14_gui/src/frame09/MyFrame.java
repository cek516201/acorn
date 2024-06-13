package frame09;

import java.awt.BorderLayout;
import java.awt.Menu;
import java.awt.desktop.ScreenSleepEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class MyFrame extends JFrame {
	public MyFrame(String title) {
//		// 제목설정
//		this.setTitle("MyFrame");
//
//		// 위치와 크기 설정
//		this.setBounds(100, 100, 500, 500);
//
//		// 종료했을 때 프로세스 전체가 종료되도록 한다
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//		// 화면상에 보이도록 한다
//		this.setVisible(true);

		super(title);

		setLayout(new BorderLayout());

		JMenu menu = new JMenu("File");
		JMenuItem newItem = new JMenuItem("New");
		menu.add(newItem);
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		JMenuItem saveItem = new JMenuItem("Save");
		menu.add(saveItem);

		JMenuBar mb = new JMenuBar();
		mb.add(menu);
		setJMenuBar(mb);

		JTextArea ta = new JTextArea();
		add(ta, BorderLayout.CENTER);
		ta.setVisible(false);

		newItem.addActionListener((e) -> {
			ta.setVisible(!ta.isVisible());
		});

		JButton btn = new JButton("버튼");
		btn.addActionListener((e) -> {
			System.out.println("sleep 10초");
			try {
				Thread.sleep(1000 * 10);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		});
		add(btn, BorderLayout.SOUTH);
	}
}