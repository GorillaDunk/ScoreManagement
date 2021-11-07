package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class Main {

	private JFrame frame;
	String id;
// 메인메소드는 로그인을 해야만 사용할 수 있는 부분이라 지워버리자

	/**
	 * Create the application.
	 */
	public Main(String id) {
		
		this.id = id;
		initialize(); // 현재 창에 있는 모든 컴포넌트를 초기화시켜준다. 항상 매개인자로 초기화 시키는건 initialize 전에 해줘야한다. 먼저 초기화를 시켜줘야 라벨에 id가 뜰 수 있기 때문이다. 
		
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
