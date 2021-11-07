package StudentMain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import GSP.Student_GSP;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_main {

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
					Student_main window = new Student_main();
					window.frame.setVisible(true);
					
					System.out.println(id);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	
	/**
	 * Create the application.
	 */
	public Student_main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 854, 544);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("\uB85C\uADF8\uC778(\uD559\uC0DD)");
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel.setBounds(125, 89, 102, 20);
		frame.getContentPane().add(lblNewLabel);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(125, 52, -22, -29);
		frame.getContentPane().add(separator);
		
		
		JButton btnNewButton_1 = new JButton("\uC131\uC801 \uC870\uD68C");
		btnNewButton_1.setBounds(190, 163, 155, 170);
		frame.getContentPane().add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("\uACFC\uC81C \uC870\uD68C");
		btnNewButton_2.setBounds(484, 163, 155, 170);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_GSP gsp= new Student_GSP();
				gsp.main(login_id);
				frame.dispose();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_score std_s = new Student_score();
				std_s.main(null);
				frame.dispose();
				
			}
		});
	}
}
