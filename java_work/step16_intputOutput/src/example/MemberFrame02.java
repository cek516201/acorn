package example;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dto.MemberDto;

public class MemberFrame02 extends JFrame {
	public static void main(String[] args) {
		MemberFrame02 f = new MemberFrame02("회원정보 관리");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}

	public MemberFrame02(String title) {
		super(title);
		setLayout(new BorderLayout());

		initUIs();
		addEvents();
		OpenFile();
		refreshTable();
	}

	private void initUIs() {
		// JLable 3개
		JLabel label1 = new JLabel("번호");
		JLabel label2 = new JLabel("이름");
		JLabel label3 = new JLabel("주소");

		// JTextField 3개
		inputNum = new JTextField(10);
		inputName = new JTextField(10);
		inputAddr = new JTextField(10);

		// JButton
		addBtn = new JButton("추가");
		// 버튼에 ActionCommand 설정을 할수가 있다.
		deleteBtn = new JButton("삭제");

		// 페널에 UI 배치
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(inputNum);
		panel.add(label2);
		panel.add(inputName);
		panel.add(label3);
		panel.add(inputAddr);
		panel.add(addBtn);
		panel.add(deleteBtn);

		// 페널을 프레임의 위쪽에 배치
		add(panel, BorderLayout.NORTH);

		// 테이블
		table = new JTable();
		// 테이블의 칼럼명을 배열로 미리 준비한다.
		String[] colNames = { "번호", "이름", "주소" };
		// 테이블에 연결할 모델
		model = new DefaultTableModel(colNames, 0);
		// 모델을 테이블에 연결
		table.setModel(model);
		// 스크롤이 가능 하도록 테이블을 JScrollPane 에 감싼다.
		JScrollPane scroll = new JScrollPane(table);
		// JScrollPane 을 프레임의 가운데에 배치하기
		add(scroll, BorderLayout.CENTER);
	}

	private void addEvents() {
		addBtn.addActionListener((e) -> {
			list.add(new MemberDto(Integer.parseInt(inputNum.getText()), inputName.getText(), inputAddr.getText()));
			refreshTable();
			saveFile();
		});

		deleteBtn.addActionListener((e) -> {
			int selectedRow = table.getSelectedRow();
			// 선택된 JTable Row 가 있다면 몇번째 row 가 선택되었는지를 읽어와서
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(this, "삭제할 row 를 선택하세요");
				return; // 메소드를 여기서 리턴시켜라(끝내라)
			} else {
				list.remove(selectedRow);
			}

			refreshTable();
			saveFile();
		});
	}

	private void saveFile() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			File file = new File(
					"C:\\Users\\user\\playground\\java_work\\step16_intputOutput\\src\\example\\members.dat");
			// 만일 해당 파일이 존재 하지 않으면
			if (!file.exists()) {
				// 새로 만든다
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			// List<MemberDto> 객체를 파일에 출력하기
			oos.writeObject(list);
			// oos.flush(); //close() 될때 auto flush 가 된다.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
				if (fos != null)
					fos.close();
			} catch (Exception e) {
			}
		}
	}

	private void OpenFile() {
		// 필요한 객체를 담을 지역변수 미리 만들기
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			File file = new File(
					"C:\\Users\\user\\playground\\java_work\\step16_intputOutput\\src\\example\\members.dat");
			if (!file.exists()) {
				file.createNewFile();
			}
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			// 저장된 데이터가 있는지 읽어와 본다.
			List<MemberDto> list = (List<MemberDto>) ois.readObject();
			this.list = list;// 읽어온 데이터를 필드에 넣어준다.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
				if (fis != null)
					fis.close();
			} catch (Exception e) {
			}
		}
	}

	private void refreshTable() {
		// 기존에 출력된 내용은 한번 지워준다.
		model.setRowCount(0);
		// 반복문 돌면서
		for (MemberDto tmp : list) {
			// MemberDto 객체를 순서대로 참조하면서 Object[] 객체를 만들어 준다.
			Object[] row = { tmp.getNum(), tmp.getName(), tmp.getAddr() };
			// 만든 Object[] 객체를 DefaultTableModel 객체에 추가하면 테이블 row 가 출력된다.
			model.addRow(row);
		}
	}

	private JButton addBtn = null;
	private JButton deleteBtn = null;
	private List<MemberDto> list = new ArrayList<MemberDto>();
	private JTextField inputNum = null;
	private JTextField inputName = null;
	private JTextField inputAddr = null;
	private JTable table = null;
	private DefaultTableModel model = null;
}