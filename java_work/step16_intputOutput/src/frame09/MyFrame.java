package frame09;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyFrame extends JFrame {
	JMenuItem newItem = null;
	JMenuItem openItem = null;
	JMenuItem saveItem = null;
	JMenuItem saveAsItem = null;

	JTextArea ta = null;
	File openedFile = null;

	public static void main(String[] args) {
		MyFrame f = new MyFrame("MyFrame");
		// f.setTitle("MyFrame");
		f.setBounds(500, 250, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public MyFrame(String title) {
		super(title);
		setLayout(new BorderLayout());

		initUIs();
		addActionListeners();
	}

	public void initUIs() {
		JMenu menu = new JMenu("File");

		newItem = new JMenuItem("New");
		menu.add(newItem);
		openItem = new JMenuItem("Open");
		menu.add(openItem);
		saveItem = new JMenuItem("Save");
		saveItem.setEnabled(false);
		menu.add(saveItem);
		saveAsItem = new JMenuItem("Save As");
		saveAsItem.setEnabled(false);
		menu.add(saveAsItem);

		JMenuBar mb = new JMenuBar();
		mb.add(menu);
		setJMenuBar(mb);

		ta = new JTextArea();
		ta.setFont(new Font("Serif", Font.PLAIN, 20));
		ta.setVisible(false);
		add(ta, BorderLayout.CENTER);

		JScrollPane sp = new JScrollPane(ta);
		add(sp, BorderLayout.CENTER);
	}

	public void addActionListeners() {
		newItem.addActionListener((e) -> {
			ta.setVisible(true);
			setTitle("제목 없음");
			saveItem.setEnabled(false);
			saveAsItem.setEnabled(true);
			ta.setText("");
		});

		openItem.addActionListener((e) -> {
			JFileChooser fc = new JFileChooser(
					"C:\\Users\\user\\playground\\java_work\\step16_intputOutput\\src\\test\\main");
			int result = fc.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				openedFile = fc.getSelectedFile();
				openFile();
			}
		});

		saveItem.addActionListener((e) -> {
			saveToFile();
		});

		saveAsItem.addActionListener((e) -> {
			// 파일 선택을 도와주는 객체 생성
			JFileChooser fc = new JFileChooser(
					"C:\\Users\\user\\playground\\java_work\\step16_intputOutput\\src\\test\\main");
			int result = fc.showSaveDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
				openedFile = fc.getSelectedFile();
				setTitle(openedFile.getName());
				try {
					openedFile.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				saveToFile();
			}
		});
	}

	public void openFile() {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(openedFile);
			br = new BufferedReader(fr);
			ta.setText("");
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;

				ta.append(line + System.lineSeparator());
			}
			setTitle(openedFile.getName());
			saveItem.setEnabled(true);
			saveAsItem.setEnabled(true);
			ta.setVisible(true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void saveToFile() {
		FileWriter fw = null;

		try {
			fw = new FileWriter(openedFile);

			fw.write(ta.getText());
			fw.flush();
			JOptionPane.showMessageDialog(this, "저장했습니다");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}