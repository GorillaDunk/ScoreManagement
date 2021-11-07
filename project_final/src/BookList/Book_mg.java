package BookList;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import Model.MemberDAO;
import Teacher.MainDTO;
import Teacher.Teacher_main;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Book_mg {

	JFrame frame;
	private JTextField txt_search;
	private JTable table;

	private String book_id;
	private String lev;
	private String book_name;
	private String writer;
	private String publisher;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Book_mg window = new Book_mg();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Book_mg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 727, 354);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C \uBAA9\uB85D");
		lblNewLabel.setBounds(20, 10, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		txt_search = new JTextField();
		txt_search.setBounds(128, 37, 124, 21);
		frame.getContentPane().add(txt_search);
		txt_search.setColumns(10);
		
		
		String[] book_select = { "책 이름", "책 코드", "저자", "출판사", "레벨"
				
		};
		
		JComboBox comboBox = new JComboBox(book_select);
		comboBox.setBounds(46, 35, 66, 24);
		frame.getContentPane().add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 105, 557, 167);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel());
		scrollPane.setViewportView(table);
		
		
		MemberDAO dao = new MemberDAO();
		BookDTO dto = new BookDTO(book_id, book_name, writer, publisher, lev);

		ArrayList<BookDTO> list = dao.show_book_table(); // sql문을 실행시켜서 객체를 가져왔고 그것을 list라는 변수에 배열로 저장

		String header[] = { // 속성 컬럼 지정

				 "책 코드", "제목", "저자", "출판사", "레벨" };

		Object[][] content = new Object[list.size()][header.length]; // ArrayList를 2차 객체 배열로 변형 --> Jtable 안에 넣어주기 위해서

		for (int i = 0; i < list.size(); i++) {
			content[i][0] = list.get(i).getBook_id();
			content[i][1] = list.get(i).getBook_name();
			content[i][2] = list.get(i).getWriter();
			content[i][3] = list.get(i).getPublisher();
			content[i][4] = list.get(i).getLev();
			

		}
		;

		DefaultTableModel model = new DefaultTableModel(content, header); // Jtable안에 넣어주기 위해서 디폴트 테이블 모델 생성
		table.setModel(model);
		
		
		
		
		JButton btnNewButton_4 = new JButton("\uAC80\uC0C9");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				ArrayList<BookDTO> list1 = dao.Search_book_name(txt_search.getText()); // sql문을 실행시켜서 객체를 가져왔고 그것을 list라는 변수에 배열로 저장

				Object[][] content1 = new Object[list1.size()][header.length]; // ArrayList를 2차 객체 배열로 변형 --> Jtable 안에 넣어주기 위해서

				for (int i = 0; i < list1.size(); i++) {
					content1[i][0] = list1.get(i).getBook_id();
					content1[i][1] = list1.get(i).getBook_name();
					content1[i][2] = list1.get(i).getWriter();
					content1[i][3] = list1.get(i).getPublisher();
					content1[i][4] = list1.get(i).getLev();
					

				};
				
				DefaultTableModel model = new DefaultTableModel(content1, header); // Jtable안에 넣어주기 위해서 디폴트 테이블 모델 생성
				table.setModel(model);
				
			}
				
				
				
		});
		
		btnNewButton_4.setBounds(264, 37, 74, 21);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("\uB3C4\uC11C\uCD94\uAC00");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAdd bookadd = new BookAdd();
				bookadd.main(null);
			}
		});
		btnNewButton.setBounds(548, 282, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uBA54\uC778\uC73C\uB85C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Teacher_main teacher_m = new Teacher_main();
				teacher_m.main(null);
				frame.dispose();
			}
		});
			
		btnNewButton_1.setBounds(602, 6, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
	
	}
}
