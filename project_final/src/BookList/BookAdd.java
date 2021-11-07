package BookList;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.MemberDAO;

public class BookAdd {

   public static void main(String[] args) {
      Dimension dim = new Dimension(400, 300);

      JFrame frame = new JFrame();
      frame.setLocation(200, 400);
      frame.setPreferredSize(dim);
      
      

      String header[] = { "도서코드", "도서이름", "저자", "출판사","도서레벨" };
      String contents[][] = { 
            { "S01", "연금술사", "파울로코엘료", "문학동네","1"} 
      };

      
      
      DefaultTableModel model = new DefaultTableModel(contents, header);
      JTable table = new JTable(model);
      JScrollPane scrollpane = new JScrollPane(table);

      JPanel panel = new JPanel();
      panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

      JTextField nameField = new JTextField(5);
      JTextField subject1 = new JTextField(3);
      JTextField subject2 = new JTextField(3);
      JTextField subject3 = new JTextField(3);
      JTextField subject4 = new JTextField(3);

      panel.add(nameField);
      panel.add(subject1);
      panel.add(subject2);
      panel.add(subject3);
      panel.add(subject4);
      
      JButton addBtn = new JButton("추가");
      addBtn.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {
            
            String inputStr[] = new String[5];

            inputStr[0] = nameField.getText();
            inputStr[1] = subject1.getText();
            inputStr[2] = subject2.getText();
            inputStr[3] = subject3.getText();
            inputStr[4] = subject4.getText();
            model.addRow(inputStr);
            
            String book_id=nameField.getText();
            String book_name= subject1.getText();
            String writer= subject2.getText();
            String publisher= subject3.getText();
            String lev= subject4.getText();
            
            MemberDAO dao= new MemberDAO();
            BookDTO dto = new BookDTO(book_id, book_name, writer, publisher, lev);
            
            boolean result = dao.book_add(dto);
            
         }

      });
      JButton cancelBtn = new JButton("삭제");
      cancelBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (table.getSelectedRow() == -1) {
               return;
            } else {
               model.removeRow(table.getSelectedRow());
            }
         }
      });
      panel.add(addBtn);
      panel.add(cancelBtn);

      frame.add(scrollpane, BorderLayout.CENTER);
      frame.add(panel, BorderLayout.SOUTH);
      frame.pack();
      frame.setVisible(true);

   }
}