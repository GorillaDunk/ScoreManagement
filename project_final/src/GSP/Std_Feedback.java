package GSP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;

public class Std_Feedback {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Std_Feedback window = new Std_Feedback();
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
	public Std_Feedback() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 710, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(58, 74, 545, 284);
		frame.getContentPane().add(splitPane);
		
		JLabel lblNewLabel = new JLabel("\uD53C\uB4DC\uBC31\uC5F4\uB78C");
		splitPane.setLeftComponent(lblNewLabel);
		
		TextArea textArea = new TextArea();
		splitPane.setRightComponent(textArea);
		
		JButton btnNewButton_2 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton_2.setBounds(585, 28, 97, 23);
		frame.getContentPane().add(btnNewButton_2);
	}

}
