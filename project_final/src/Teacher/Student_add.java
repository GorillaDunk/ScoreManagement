package Teacher;

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



public class Student_add {

public static void main(String[]args) {
	Dimension dim = new Dimension(400,300);
	
	JFrame frame= new JFrame();
	frame.setLocation(200,400);
	frame.setPreferredSize(dim);
	
	String header[]= {"학생 아이디","학생 비밀번호","학생 이름","등록일자"};
	String contents[][]= {
			{"smhrd","123","류한나","21/05/2021"}
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
	
	panel.add(nameField);
	panel.add(subject1);
	panel.add(subject2);
	panel.add(subject3);
	
	JButton addBtn= new JButton("추가");
	addBtn.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			

			String inputStr[]=new String[4];
			
			inputStr[0]= nameField.getText();
			inputStr[1]=subject1.getText();
			inputStr[2]=subject2.getText();
			inputStr[3]=subject3.getText();
			model.addRow(inputStr);
	
//	nameField.setText("");
//	subject1.setText("");
//	subject2.setText("");
//	subject3.setText("");
			
			
			String std_id = nameField.getText();
			String std_pw= subject1.getText();
			String std_name= subject2.getText();
			String join_date= subject3.getText();
			
			
			
			MemberDAO dao= new MemberDAO();
			
			MainDTO dto = new MainDTO(std_id, std_pw, std_name, join_date);
			
			
			
			boolean result = dao.student_add(dto);
		
			
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