package Teacher;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BookList.Book_mg;
import Class_mg.Class_mg;
import GSP.Teacher_GSP;
import Score.Score_mg;

public class Teacher_main {

	public JFrame frame;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	private static String login_id = null;

	/**
	 * Launch the application.
	 */
	public static void main(String id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_id = id;
					Teacher_main window = new Teacher_main();
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
	public Teacher_main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB85C\uADF8\uC778(\uAC15\uC0AC)");
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(49, 65, 76, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(76, 152, 626, 127);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btn_std = new JButton("\uD559\uC0DD\uAD00\uB9AC");
		btn_std.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Teacher_student_mg std_mg = new Teacher_student_mg();
				std_mg.main(null);
				frame.dispose();
			}
		});
		panel.add(btn_std);
		
		JButton btnNewButton = new JButton("\uC131\uC801\uAD00\uB9AC");
		panel.add(btnNewButton);
		
		JButton btn_bk = new JButton("\uB3C4\uC11C\uAD00\uB9AC");
		panel.add(btn_bk);
		
		JButton btn_cla = new JButton("\uBC18\uAD00\uB9AC/\uAC15\uC0AC");
		btn_cla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Class_mg class_mg = new Class_mg();
				class_mg.main(login_id);
				frame.dispose();
			}
		});
		panel.add(btn_cla);
		
		JButton btnNewButton_1 = new JButton("\uACFC\uC81C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Teacher_GSP gsp = new Teacher_GSP();
				gsp.main(login_id);
				frame.dispose();
			}
		});
		panel.add(btnNewButton_1);
		btn_bk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Book_mg bookmg= new Book_mg();
				bookmg.main(null);
				
				
				frame.dispose();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Score_mg scoremg = new Score_mg();
				scoremg.main(null);
				frame.dispose();
			}
		});
		
		
	
	}
}
