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

public class Feedback {

	private JFrame frame;
	private static String write_essay = null;

	/**
	 * Launch the application.
	 */
	public static void main(String essay) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println(essay);
					write_essay = essay;
					Feedback window = new Feedback();
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
	public Feedback() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 717, 518);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(64, 71, 568, 307);
		frame.getContentPane().add(splitPane);
		
		JLabel lblNewLabel = new JLabel("\uD53C\uB4DC\uBC31\uC785\uB825");
		splitPane.setLeftComponent(lblNewLabel);
		
		TextArea textArea = new TextArea();
		splitPane.setRightComponent(textArea);
		
		JButton btnNewButton = new JButton("\uC800\uC7A5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				System.out.println(textArea.getText());
				System.out.println(write_essay);
				MemberDAO dao = new MemberDAO();
				dao.edit_feedback(textArea.getText(), write_essay);
				JOptionPane.showMessageDialog(null, "등록완료","안내메시지",JOptionPane.PLAIN_MESSAGE);
				frame.dispose();
				//db에 저장 시켜야됨
				frame.setVisible(true);}
		});
		btnNewButton.setBounds(422, 418, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC218\uC815");
		btnNewButton_1.setBounds(535, 418, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Teacher_GSP gsp= new Teacher_GSP();
			
				
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(577, 38, 97, 23);
		frame.getContentPane().add(btnNewButton_2);
	}

}
