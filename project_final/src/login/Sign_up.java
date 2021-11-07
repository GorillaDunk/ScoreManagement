package login;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.MemberDAO;

public class Sign_up {

   private JFrame frame;
   private final ButtonGroup buttonGroup = new ButtonGroup();

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
                Sign_up window = new  Sign_up();
               window.frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }

            // mouseExited:마우스가 컴포넌트 밖으로 나갈때 이벤트 발생

         }
      });
   }

   /**
    * Create the application.
    */
   public Sign_up() {
      initialize();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
      frame = new JFrame();
      frame.setBounds(100, 100, 450, 583);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);

      JPanel panel = new JPanel();
      panel.setBounds(0, 0, 434, 544);
      frame.getContentPane().add(panel);
      panel.setLayout(null);

      JLabel lblNewLabel = new JLabel("JOIN");
      lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 26));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setBounds(74, 37, 269, 49);
      panel.add(lblNewLabel);

      JLabel lbl_id = new JLabel("ID :");
      lbl_id.setBounds(30, 108, 49, 41);
      panel.add(lbl_id);

      JTextField tf_id = new JTextField();
      tf_id.setBounds(74, 106, 233, 45);
      panel.add(tf_id);
      tf_id.setColumns(10);

      JLabel lbl_pw = new JLabel("PW :");
      lbl_pw.setBounds(30, 169, 49, 41);
      panel.add(lbl_pw);

      JTextField txt_name = new JTextField();
      txt_name.setColumns(10);
      txt_name.setBounds(74, 238, 233, 45);
      panel.add(txt_name);

      JLabel lbl_name = new JLabel("NAME :");
      lbl_name.setBounds(27, 240, 49, 41);
      panel.add(lbl_name);

      JTextField txt_pw = new JPasswordField();
      txt_pw.setBounds(74, 166, 233, 47);
      panel.add(txt_pw);

      JButton btn_join = new JButton("Join");
      btn_join.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            // join 버튼을 눌렀을 때 이벤트 발생
            // 입력한 값을 DB에 넣을 것이다.
            String id = tf_id.getText();
            String pw = txt_pw.getText();
            String name = txt_name.getText();

      
            // 5가지가 전부 적혀야 가입이 가능하다.
            // 5가지가 다 안 적히면 경고 메세지가 뜨게 할 것이다.

            if (!id.equals("") && !pw.equals("") && !name.equals("")) {
               // 5개의 값이 입력이 됐을 때 , DB에 값 저장
               // 이때만 데이터베이스에 값을 집어넣을것이다

               Student_signDTO dto = new Student_signDTO(id, pw, name);

               MemberDAO dao = new MemberDAO();

               // true면 db에 값이 정상적으로 저장이 된 것
               // false면 db에 값 저장 안됨
               boolean result = dao.sign_up(dto);

               // 이때 result만 적어도상관 없지만 가독성을 위해 == true 넣은것
               if (result == true) {
                  JOptionPane.showMessageDialog(null, "회원가입 성공");

                  //회원가입을 했으면 다시 로그인 페이지로 돌아가야한다.
                                    
                  Login login = new Login();
                  login.main(null);
                  
                  // 회원가입 버튼 누르면 기존 회원가입 창은 안뜨게 하기 (= 기존 창 닫기)
                  // 현재 frame 안에 회원가입에 들어가는 모든것들이 들어가있다. 
                  
                  frame.dispose();
                  
               } else {
                  JOptionPane.showMessageDialog(null, "회원가입 실패");

               }

               JOptionPane.showMessageDialog(null, "회원가입 성공");

            } else {
               JOptionPane.showMessageDialog(null, "모든 정보를 입력하세요", "회원가입", JOptionPane.ERROR_MESSAGE);

            }

         }
      });
      
      //중복확인 버튼클릭시
      btn_join.setBounds(37, 361, 355, 34);
      panel.add(btn_join);
      
      JButton btn_checkId = new JButton("\uC911\uBCF5\uD655\uC778");
      btn_checkId.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            MemberDAO dao = new MemberDAO();
            if( dao.findExistID( tf_id.getText() ) ) {
               JOptionPane.showMessageDialog(null, "사용중인 아이디입니다","등록불가",JOptionPane.ERROR_MESSAGE);
               tf_id.setText( "" );
            } else {
               JOptionPane.showMessageDialog(null,"사용가능한ID입니다.", "안내메시지",JOptionPane.PLAIN_MESSAGE);
            }

         }
      });
            
      btn_checkId.setBounds(319, 112, 103, 32);
      panel.add(btn_checkId);
   }
}