package Score;

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
import Teacher.MainDTO;

public class Score_add {

public static void main(String[]args) {
   Dimension dim = new Dimension(400,300);
   
   JFrame frame= new JFrame();
   frame.setLocation(200,400);
   frame.setPreferredSize(dim);
   String header[]= {"학생코드","학생이름","시험날짜","WeeklyTest","MonthlyTest"};
   String contents[][]= {
         {"smhrd01","류한나","21/05/2021","100","85"}
   };
   DefaultTableModel model= new DefaultTableModel(contents,header);
   JTable table= new JTable(model);
   JScrollPane scrollpane = new JScrollPane(table);
   
   JPanel panel = new JPanel();
   panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
   
   JTextField nameField = new JTextField(5);
   JTextField subject1= new JTextField(3);
   JTextField subject2= new JTextField(3);
   JTextField subject3= new JTextField(3);
   JTextField subject4= new JTextField(3);
   
   panel.add(nameField);
   panel.add(subject1);
   panel.add(subject2);
   panel.add(subject3);
   panel.add(subject4);
   
   JButton addBtn= new JButton("추가");
   addBtn.addActionListener(new ActionListener() {
      
      public void actionPerformed(ActionEvent e) {
       
    	  String inputStr[]=new String[5];
         
         inputStr[0]= nameField.getText();
         inputStr[1]=subject1.getText();
         inputStr[2]=subject2.getText();
         inputStr[3]=subject3.getText();
         inputStr[4]=subject4.getText();
         model.addRow(inputStr);
         
         String std_id = nameField.getText();
            String std_name= subject1.getText();
            String ex_date= subject2.getText();
            String weekly_test= subject3.getText();
            String monthly_test= subject3.getText();
            
            MemberDAO dao= new MemberDAO();
            
            ScoreDTO dto = new  ScoreDTO(std_id,std_name,ex_date,weekly_test,monthly_test);
            
            
            
            boolean result = dao.score_add(dto);
   
}
   
});
JButton cancelBtn= new JButton("삭제");
cancelBtn.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
      if(table.getSelectedRow()==-1)
      {
         return;
      }else {
         model.removeRow(table.getSelectedRow());
      }
   }
});
      panel.add(addBtn);
      panel.add(cancelBtn);
      
      frame.add(scrollpane,BorderLayout.CENTER);
      frame.add(panel,BorderLayout.SOUTH);
      frame.pack();
      frame.setVisible(true);

}
}