package frame05;

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

		saveBtn = new JButton("저장");
		saveBtn.addActionListener(this);
		this.add(saveBtn);

		updateBtn = new JButton("수정");
		updateBtn.addActionListener(this);
		this.add(updateBtn);

		deleteBtn = new JButton("삭제");
		deleteBtn.addActionListener(this);
		this.add(deleteBtn);

		// 화면상에 보이도록 한다
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 눌려진 버튼의 참조값 얻어내기
		Object which = e.getSource();
		if (which == saveBtn) {
			System.out.println("save");
		} else if (which == updateBtn) {
			System.out.println("update");
		} else if (which == deleteBtn) {
			System.out.println("delete");
		}
	}

	private JButton saveBtn, updateBtn, deleteBtn;
}