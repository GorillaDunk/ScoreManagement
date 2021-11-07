package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Select {

	public static void main(String[] args) {

		// ���̵� ��й�ȣ�� ��ȸ�ؼ� �̰� ��ġ�ϴ� ȸ���� ��ȸ�Ұ��̴�.
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String name = null;
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���̵� : ");
		String id = sc.next();

		System.out.print("��й�ȣ : ");
		String pw = sc.next();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			String db_id = "gon";

			String db_pw = "1234";

			conn = DriverManager.getConnection(url, db_id, db_pw);

			String sql = "SELECT * FROM student WHERE std_id = ? AND std_pw = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);

			// executeQeury�� ���� ����� ��
			// DB���ִ� ���̺� ���� ������ ���� ��
			rs = psmt.executeQuery();

			// ������ �ۼ��ߴµ� �˻��� �ڷᰡ ���̺� �ȿ� ������ true�� ��� �ƴϸ� false.
			if (rs.next()) {

				// �̸� ���
				name = rs.getString(3); // �̸��� 3��° �÷��� �־ 3��° �÷��� �ִ� ���� ����Ѵ�.

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			
			try {
				rs.close();
				psmt.close();
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		if(name != null) {
			System.out.println(name + "�� ȯ���մϴ�.");
		}else {
			System.out.println("���̵�� ��й�ȣ�� Ȯ�����ּ���");
		}
		

	}

}
