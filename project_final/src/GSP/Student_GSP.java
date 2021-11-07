package GSP;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.MemberDAO;
import StudentMain.Student_main;

public class Student_GSP {

	private JFrame frame;
	private JTextField txt_search;
	private JTable table;

	private String std_id;
	private String std_name;
	private String essay;
	private String feedback;
	
	private Object value = null;
	
	private static String login_id = null;
	/**
	 * Launch the application.
	 */
	public static void main(String id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_id = id;
					
					Student_GSP window = new Student_GSP();
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
	public Student_GSP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 656, 655);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txt_search = new JTextField();
		txt_search.setBounds(194, 83, 238, 21);
		frame.getContentPane().add(txt_search);
		txt_search.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uD559\uC0DD\uC774\uB984"}));
		comboBox.setBounds(86, 82, 96, 22);
		frame.getContentPane().add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 126, 467, 372);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		

		MemberDAO dao = new MemberDAO();
		
		GSPDTO dto = new GSPDTO(std_id, std_name, essay, feedback);

		ArrayList<GSPDTO> list = dao.show_GSP_table(); // sql문을 실행시켜서 객체를 가져왔고 그것을 list라는 변수에 배열로 저장

		String header[] = { // 속성 컬럼 지정

				"학생 id", "학생 이름", "에세이", "피드백" };

		Object[][] content = new Object[list.size()][header.length]; // ArrayList를 2차 객체 배열로 변형 --> Jtable 안에 넣어주기 위해서

		for (int i = 0; i < list.size(); i++) {
			content[i][0] = list.get(i).getStd_id();
			content[i][1] = list.get(i).getStd_name();
			content[i][2] = list.get(i).getEssay();
			content[i][3] = list.get(i).getFeedback();
			
			

		}
		;

		
		
		
		
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				ArrayList<GSPDTO> list1 = dao.Search_name_GSP(txt_search.getText());

				Object[][] content1 = new Object[list1.size()][header.length]; // ArrayList를 2차 객체 배열로 변형 --> Jtable 안에
																				// 넣어주기 위해서

				for (int i = 0; i < list1.size(); i++) {
					content1[i][0] = list1.get(i).getStd_id();
					content1[i][1] = list1.get(i).getStd_name();
					content1[i][2] = list1.get(i).getEssay();
					content1[i][3] = list1.get(i).getFeedback();

				}
				;

				DefaultTableModel model = new DefaultTableModel(content1, header); // Jtable안에 넣어주기 위해서 디폴트 테이블 모델 생성
				table.setModel(model);
				scrollPane.setViewportView(table);
			}

				
				
		});
		btnNewButton.setBounds(444, 82, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
	
		
		
		
		JButton btnNewButton_2 = new JButton("\uC5D0\uC138\uC774\uC785\uB825");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
//				value = table.getValueAt(row, 3);
				value = table.getValueAt(row, 2);
				System.out.println(value+"   ");
				
			
				Student_essay_writing essay= new Student_essay_writing();
				//essay.main(login_id);
				
				essay.main(value.toString());
				
				frame.dispose();
			}
				

				
			
				
	
		
				
				
				
				
				
		
			}
		);
		btnNewButton_2.setBounds(444, 525, 113, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("\uACFC\uC81C\uAC8C\uC2DC\uD310");
		lblNewLabel.setBounds(28, 10, 126, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("\uBA54\uC778\uC73C\uB85C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_main studentmanager = new Student_main();
				studentmanager.main(null);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(531, 10, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btn_see_feedback = new JButton("\uD53C\uB4DC\uBC31 \uBCF4\uAE30");
		btn_see_feedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				value = table.getValueAt(row, 3);
				JTextArea jlabel = new JTextArea(value.toString());
				scrollPane.setViewportView(jlabel);
				
				
				
			}
		});
		btn_see_feedback.setBounds(86, 526, 113, 23);
		frame.getContentPane().add(btn_see_feedback);
	}
}
