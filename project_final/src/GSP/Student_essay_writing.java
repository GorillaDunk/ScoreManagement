package GSP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import Model.MemberDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;

public class Student_essay_writing {

	private JFrame frame;
	private static String login_id = null;
	/**
	 * Launch the application.
	 */
	public static void main(String id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					login_id = id;
					System.out.println(login_id);
					Student_essay_writing window = new Student_essay_writing();
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
	public Student_essay_writing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 639, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(12, 10, 599, 331);
		frame.getContentPane().add(splitPane);
		
		JLabel lblNewLabel = new JLabel("\uC5D0\uC138\uC774\uC785\uB825");
		splitPane.setLeftComponent(lblNewLabel);
		
		TextArea textArea = new TextArea();
		splitPane.setRightComponent(textArea);
		
		JButton btnNewButton = new JButton("\uC800\uC7A5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				MemberDAO dao = new MemberDAO();
				dao.save_essay(login_id, textArea.getText());
				JOptionPane.showMessageDialog(null, "등록완료","안내메시지",JOptionPane.PLAIN_MESSAGE);
				frame.dispose();
				//db에 저장 시켜야됨
				frame.setVisible(true);
				
			
			}
		});
		btnNewButton.setBounds(402, 351, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC218\uC815");
		btnNewButton_1.setBounds(510, 351, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_GSP gsp= new Student_GSP();
				gsp.main(null);
//				
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(18, 351, 97, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
