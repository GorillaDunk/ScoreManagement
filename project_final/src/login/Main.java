package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class Main {

	private JFrame frame;
	String id;
// ���θ޼ҵ�� �α����� �ؾ߸� ����� �� �ִ� �κ��̶� ����������

	/**
	 * Create the application.
	 */
	public Main(String id) {
		
		this.id = id;
		initialize(); // ���� â�� �ִ� ��� ������Ʈ�� �ʱ�ȭ�����ش�. �׻� �Ű����ڷ� �ʱ�ȭ ��Ű�°� initialize ���� ������Ѵ�. ���� �ʱ�ȭ�� ������� �󺧿� id�� �� �� �ֱ� �����̴�. 
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	}

}
