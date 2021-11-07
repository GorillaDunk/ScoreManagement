package Class_mg;

import java.awt.Color;
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
import javax.swing.table.DefaultTableModel;

import Model.MemberDAO;
import Teacher.Teacher_main;

public class Class_mg {

	private JFrame frame;
	private JTable table;
	private String val = null;
	private static String login_id = null;
	private String sub_id ;
	private String std_id;
	private String std_name;
	
	/**
	 * Launch the application.
	 */
	public static void main(String id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_id = id;
					Class_mg window = new Class_mg();
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
	public Class_mg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 702, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uBC18 \uAD00\uB9AC");
		lblNewLabel.setBounds(12, 10, 57, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uACFC\uBAA9 \uC120\uD0DD :");
		lblNewLabel_1.setBounds(127, 62, 73, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(122, 97, 492, 177);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.GRAY);
		table.setModel(new DefaultTableModel());
		scrollPane.setViewportView(table);
		
		
		String header[] = { // �Ӽ� �÷� ����

				"�л� id", "�л� �̸�" };

		
		
		
		
		JButton btnNewButton = new JButton("\uBA54\uC778\uC73C\uB85C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Teacher_main teacher_m = new Teacher_main();
				teacher_m.main(null);
				frame.dispose();
			}
		});
		
		btnNewButton.setBounds(577, 6, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
			
				
				  JComboBox cb = (JComboBox) e.getSource(); // �޺��ڽ� �˾Ƴ���

                  val = (String) cb.getSelectedItem();// ���õ� �������� ��
                  
              	ArrayList<ClassDTO> list = new ArrayList<ClassDTO>();
            
                  ClassDTO dto1 = new ClassDTO(std_id, std_name);
                  
                  MemberDAO dao = new MemberDAO();
                  
                  list = dao.get_select_sub(val);
                  
                  
               Object[][] content1 = new Object[list.size()][header.length];
               
               for(int i = 0; i < list.size(); i++) {
            	   content1[i][0] = list.get(i).getStd_id();
       				content1[i][1] = list.get(i).getStd_name();
               }
                  
      			DefaultTableModel model = new DefaultTableModel(content1 , header); // Jtable�ȿ� �־��ֱ� ���ؼ� ����Ʈ ���̺� �� ����
				table.setModel(model);
	

			}
			
			
		});
		
		
		MemberDAO dao = new MemberDAO();
		
		ClassDTO dto = new ClassDTO(sub_id);
		
		ArrayList<ClassDTO> list =dao.show_sub_code(login_id);
		
		String[] content = new String[list.size()];
		for(int i=0; i<list.size();i++) {
			content[i]=list.get(i).getSub_id();
		}
		
		comboBox.setModel(new DefaultComboBoxModel(content));
		
		
		// �ߺ� �����ؼ� sub_id�� �����´� DAO --> distinct
		// ������ sub_id�� ����� �˼� �ִ� --> count()
		// sub_id�� ũ�⸸ŭ �迭 ���� --> ArrayList<>/size
		// ������ �迭 comboBox�� �ֱ�
		
		
		//actionperformedEvent
		
				
		comboBox.setBounds(205, 58, 43, 23);
		frame.getContentPane().add(comboBox);
	}
}
