package Teacher;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.MemberDAO;
import Score.ScoreDTO;

public class Teacher_student_mg{

	private JFrame frame;
	private JLabel lblNewLabel_1;
	private JLabel lbl_6;
	private JTextField txt_6;
	private JTextField txt_search;
	private JButton btnNewButton_1;
	private JTable table;

	
	
	private String std_id;
	private String std_pw;
	private String std_name;
	private String join_date;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher_student_mg window = new Teacher_student_mg();
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
	public Teacher_student_mg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 687, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel_1 = new JLabel("\uD559\uC0DD\uAC80\uC0C9");
		lblNewLabel_1.setBounds(92, 70, 89, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		lbl_6 = new JLabel("\uBE44\uACE0");
		lbl_6.setBounds(74, 357, 82, 21);
		frame.getContentPane().add(lbl_6);
		
		txt_6 = new JTextField();
		txt_6.setBounds(74, 373, 530, 128);
		frame.getContentPane().add(txt_6);
		txt_6.setColumns(10);
		
		txt_search = new JTextField();
		txt_search.setBounds(182, 67, 209, 21);
		frame.getContentPane().add(txt_search);
		txt_search.setColumns(10);
		
		JButton btnNewButton = new JButton("\uBA54\uC778\uC73C\uB85C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Teacher_main teacher_m = new Teacher_main();
				teacher_m.main(null);
				frame.dispose();
			}
		});
		
		
		
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 99, 537, 248);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		MemberDAO dao = new MemberDAO();
		MainDTO dto = new MainDTO(std_id, std_pw, std_name, join_date);

		ArrayList<MainDTO> list = dao.show_student_table(); // sql문을 실행시켜서 객체를 가져왔고 그것을 list라는 변수에 배열로 저장

		String header[] = { // 속성 컬럼 지정

				 "학생 id", "학생 pw", "학생 이름", "등록일자" };

		Object[][] content = new Object[list.size()][header.length]; // ArrayList를 2차 객체 배열로 변형 --> Jtable 안에 넣어주기 위해서

		for (int i = 0; i < list.size(); i++) {
			content[i][0] = list.get(i).getStd_id();
			content[i][1] = list.get(i).getStd_pw();
			content[i][2] = list.get(i).getStd_name();
			content[i][3] = list.get(i).getJoin_date();
			

		}
		;

		DefaultTableModel model = new DefaultTableModel(null, header); // Jtable안에 넣어주기 위해서 디폴트 테이블 모델 생성
		table.setModel(model);
		
		
		
		btnNewButton.setBounds(562, 10, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("\uAC80\uC0C9");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				ArrayList<MainDTO> list1 = dao.Search_student(txt_search.getText());

				Object[][] content1 = new Object[list1.size()][header.length]; // ArrayList를 2차 객체 배열로 변형 --> Jtable 안에
																				// 넣어주기 위해서

				for (int i = 0; i < list1.size(); i++) {
					content1[i][0] = list1.get(i).getStd_id();
					content1[i][1] = list1.get(i).getStd_pw();
					content1[i][2] = list1.get(i).getStd_name();
					content1[i][3] = list1.get(i).getJoin_date();

				}
				;

				DefaultTableModel model = new DefaultTableModel(content1, header); // Jtable안에 넣어주기 위해서 디폴트 테이블 모델 생성
				table.setModel(model);

			}

			}
		);
		

		btnNewButton_1.setBounds(403, 66, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		JButton btnNewButton_2 = new JButton("\uCD94\uAC00");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_add studentadd = new Student_add();
				studentadd.main(null);
			}
		});
		btnNewButton_2.setBounds(507, 66, 97, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
