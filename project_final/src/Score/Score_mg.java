package Score;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.Panel;
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
import javax.swing.table.DefaultTableModel;

import Model.MemberDAO;
import Teacher.MainDTO;
import Teacher.Teacher_main;
import javax.swing.JTextPane;

public class Score_mg {

	private JFrame frame;
	private JTable table;
	
	private String std_name;
	private String ex_date;
	private String weekly_test;
	private String monthly_test;
	private String std_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Score_mg window = new Score_mg();
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
	public Score_mg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 651, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC131\uC801 \uAD00\uB9AC");
		lblNewLabel.setBounds(22, 16, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 96, 456, 283);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		MemberDAO dao = new MemberDAO();
		ScoreDTO dto = new ScoreDTO(std_id, std_name, ex_date, weekly_test, monthly_test);

		ArrayList<ScoreDTO> list = dao.show_score_table(); // sql���� ������Ѽ� ��ü�� �����԰� �װ��� list��� ������ �迭�� ����

		String header[] = { // �Ӽ� �÷� ����

				 "�л�id", "�л��̸�", "��������", "�ְ�����", "��������" };

		Object[][] content = new Object[list.size()][header.length]; // ArrayList�� 2�� ��ü �迭�� ���� --> Jtable �ȿ� �־��ֱ� ���ؼ�

		for (int i = 0; i < list.size(); i++) {
			content[i][0] = list.get(i).getStd_id();
			content[i][1] = list.get(i).getStd_name();
			content[i][2] = list.get(i).getEx_date();
			content[i][3] = list.get(i).getWeekly_test();
			content[i][4] = list.get(i).getMonthly_test();

		}
		;

		DefaultTableModel model = new DefaultTableModel(null, header); // Jtable�ȿ� �־��ֱ� ���ؼ� ����Ʈ ���̺� �� ����
		table.setModel(model);
		
		
		
		
		
		
		
		Button button = new Button("\uC131\uC801\uC785\uB825");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Score_add scoreadd = new Score_add ();
				scoreadd.main(null);
			}
		});
		button.setBounds(487, 395, 76, 23);
		frame.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("\uBA54\uC778\uC73C\uB85C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Teacher_main teacher_m = new Teacher_main();
				teacher_m.main(null);
				frame.dispose();
			}
		});
				btnNewButton.setBounds(504, 12, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\uD559\uC0DD \uAC80\uC0C9 :");
		lblNewLabel_1.setBounds(77, 56, 67, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane txt_search = new JTextPane();
		txt_search.setBounds(156, 56, 268, 23);
		frame.getContentPane().add(txt_search);
		
		JButton btn_search = new JButton("\uAC80\uC0C9");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				ArrayList<ScoreDTO> list1 = dao.Search_score(txt_search.getText());

				System.out.println(list1.size());
				Object[][] content1 = new Object[list1.size()][header.length]; // ArrayList�� 2�� ��ü �迭�� ���� --> Jtable �ȿ�
																				// �־��ֱ� ���ؼ�

				for (int i = 0; i < list1.size(); i++) {
					content1[i][0] = list1.get(i).getStd_id();
					content1[i][1] = list1.get(i).getStd_name();
					content1[i][2] = list1.get(i).getEx_date();
					content1[i][3] = list1.get(i).getWeekly_test();
					content1[i][4] = list1.get(i).getMonthly_test();

				}
				

				DefaultTableModel model = new DefaultTableModel(content1, header); // Jtable�ȿ� �־��ֱ� ���ؼ� ����Ʈ ���̺� �� ����
				table.setModel(model);

			}	
				
			
		});
		btn_search.setBounds(436, 56, 97, 23);
		frame.getContentPane().add(btn_search);
	}
} // �� �κ� �����Ҷ� �����ͺ��̽� ���� ������ ���� �־��ְ� �� ���� ���ؼ� jdbc�� ���� �ڹٿ��� �����ؾ��ϴµ� 
// java�����Ѱ� �ƴ� sql���� ���ؼ� sqldeveloper���� ���� �÷��� ������ �������� �� commit�� �� ������Ѵ�. 
