package login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Model.MemberDAO;
import StudentMain.Student_main;
import Teacher.Teacher_main;

public class Login {

	private JFrame frame;
	private JTextField tf_id;
	private JTextField tf_pw;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { // 여기를 실행시키면 login객체를 먼저 생성하고 setVisible(true)로 이 창을 보이게 만든다. 이후
												// initialize로 넘어간다.
		EventQueue.invokeLater(new Runnable() { // Main도 마찬가지로 Main창 띄우려면 객체를 먼저 생성해야한다. Main클래스의 Main부분을 지워버려서 아이디 로그인
												// 부분if문 안에 Main객체를 생성해준다.
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(); // creates a frame
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("로그인");
		frame.setBounds(100, 100, 450, 300); // sets title of frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exite out of application
		frame.getContentPane().setLayout(null);
		// frame.setSize(420,420));
		frame.setVisible(true); // make frame visible

		ImageIcon image = new ImageIcon("logo.jpg");
		frame.setIconImage(image.getImage());

		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(62, 73, 97, 30);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PW :");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel_1.setBounds(62, 121, 97, 30);
		frame.getContentPane().add(lblNewLabel_1);

		tf_id = new JTextField();
		tf_id.setBounds(127, 78, 155, 25);
		frame.getContentPane().add(tf_id);
		tf_id.setColumns(10);

		tf_pw = new JTextField();
		tf_pw.setBounds(129, 125, 156, 25);
		frame.getContentPane().add(tf_pw);
		tf_pw.setColumns(10);

		JButton btn_join = new JButton("\uD559\uC0DD \uAC00\uC785");
		btn_join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 회원가입 버튼 눌렀을 때 sign_up화면으로 이동

				Sign_up sign_up = new Sign_up();
				sign_up.main(null);

				// 기존 창 닫기
				frame.dispose();

			}
		});
		btn_join.setBounds(180, 170, 97, 23);
		frame.getContentPane().add(btn_join);

		JRadioButton rdbtn_teacher = new JRadioButton("Teacher");
		buttonGroup.add(rdbtn_teacher);
		rdbtn_teacher.setBackground(Color.WHITE);
		rdbtn_teacher.setBounds(90, 32, 121, 23);
		frame.getContentPane().add(rdbtn_teacher);

		JRadioButton rdbtn_student = new JRadioButton("Student");
		buttonGroup.add(rdbtn_student);
		rdbtn_student.setBackground(Color.WHITE);
		rdbtn_student.setBounds(234, 32, 121, 23);
		frame.getContentPane().add(rdbtn_student);

	
		
		
		
		
		JButton btn_login = new JButton("\uB85C\uADF8\uC778");
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id = tf_id.getText();
				String pw = tf_pw.getText();
				
				
				Student_signDTO dto = new Student_signDTO(id, pw, null);
				MemberDAO dao = new MemberDAO();
				
				if (rdbtn_teacher.isSelected()) {

					if (id.equals(dao.login_teacher_id(dto)) && pw.equals(dao.login_teacher_pw(dto))) {

						Teacher_main teacher_main = new Teacher_main();
						teacher_main.main(tf_id.getText());

						frame.dispose();
				
					}else {
						JOptionPane.showMessageDialog(null, "로그인 실패");
					
				}
				}
					
				if (rdbtn_student.isSelected()) {
						

						if (id.equals(dao.login_Student_id(dto)) && pw.equals(dao.login_Student_pw(dto))) {

							Student_main student_main = new Student_main();
						
							student_main.main(tf_id.getText());
							
							
							frame.dispose();
						
					}else {
						JOptionPane.showMessageDialog(null, "로그인 실패");
					
						}
				}
			
		
			}
		}
			
			);
		btn_login.setBounds(297, 170, 97, 23);
		frame.getContentPane().add(btn_login);
	}
}
