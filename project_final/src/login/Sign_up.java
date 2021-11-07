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

            // mouseExited:���콺�� ������Ʈ ������ ������ �̺�Ʈ �߻�

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
      lblNewLabel.setFont(new Font("����", Font.PLAIN, 26));
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
            // join ��ư�� ������ �� �̺�Ʈ �߻�
            // �Է��� ���� DB�� ���� ���̴�.
            String id = tf_id.getText();
            String pw = txt_pw.getText();
            String name = txt_name.getText();

      
            // 5������ ���� ������ ������ �����ϴ�.
            // 5������ �� �� ������ ��� �޼����� �߰� �� ���̴�.

            if (!id.equals("") && !pw.equals("") && !name.equals("")) {
               // 5���� ���� �Է��� ���� �� , DB�� �� ����
               // �̶��� �����ͺ��̽��� ���� ����������̴�

               Student_signDTO dto = new Student_signDTO(id, pw, name);

               MemberDAO dao = new MemberDAO();

               // true�� db�� ���� ���������� ������ �� ��
               // false�� db�� �� ���� �ȵ�
               boolean result = dao.sign_up(dto);

               // �̶� result�� ������ ������ �������� ���� == true ������
               if (result == true) {
                  JOptionPane.showMessageDialog(null, "ȸ������ ����");

                  //ȸ�������� ������ �ٽ� �α��� �������� ���ư����Ѵ�.
                                    
                  Login login = new Login();
                  login.main(null);
                  
                  // ȸ������ ��ư ������ ���� ȸ������ â�� �ȶ߰� �ϱ� (= ���� â �ݱ�)
                  // ���� frame �ȿ� ȸ�����Կ� ���� ���͵��� ���ִ�. 
                  
                  frame.dispose();
                  
               } else {
                  JOptionPane.showMessageDialog(null, "ȸ������ ����");

               }

               JOptionPane.showMessageDialog(null, "ȸ������ ����");

            } else {
               JOptionPane.showMessageDialog(null, "��� ������ �Է��ϼ���", "ȸ������", JOptionPane.ERROR_MESSAGE);

            }

         }
      });
      
      //�ߺ�Ȯ�� ��ưŬ����
      btn_join.setBounds(37, 361, 355, 34);
      panel.add(btn_join);
      
      JButton btn_checkId = new JButton("\uC911\uBCF5\uD655\uC778");
      btn_checkId.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            MemberDAO dao = new MemberDAO();
            if( dao.findExistID( tf_id.getText() ) ) {
               JOptionPane.showMessageDialog(null, "������� ���̵��Դϴ�","��ϺҰ�",JOptionPane.ERROR_MESSAGE);
               tf_id.setText( "" );
            } else {
               JOptionPane.showMessageDialog(null,"��밡����ID�Դϴ�.", "�ȳ��޽���",JOptionPane.PLAIN_MESSAGE);
            }

         }
      });
            
      btn_checkId.setBounds(319, 112, 103, 32);
      panel.add(btn_checkId);
   }
}