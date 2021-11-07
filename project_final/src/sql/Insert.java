package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {

	public static void main(String[] args) {
		// ���̵�, ��й�ȣ, �̸�, ���̸� �Է¹޾Ƽ� DB�� �����Ű��

		Connection conn = null;
		PreparedStatement psmt = null;

		Scanner sc = new Scanner(System.in);

		System.out.print("���̵� : ");
		String id = sc.next();

		System.out.print("��й�ȣ : ");
		String pw = sc.next();

		System.out.print(" �̸� : ");
		String name = sc.next();

		System.out.print(" ���� : ");
		int age = sc.nextInt();

		// ���̵� : smhrd
		// ��й�ȣ : 1234
		// ���� ���̵� ��й�ȣ�� �Է����� �� �α��� �Ǿ����ϴ�!

		// ����ó�� --> ���� �Ʒ� ��θ� ���ؼ� driver�� �� ������ �´ٸ� ��� �� ������ �����ִ� try/catch���� ���������Ѵ�.
		// catch������ ������ �����ض��� ��ɹ��� �ִ�.

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// DB ������ �� �ʿ��� id, ���, �׸��� ��� �Է�
			// ���, ���̵�, ���
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			String db_id = "hr";

			String db_pw = "hr";

			try {

				// ���, ���̵�, ����� ��� db�� ����!
				conn = DriverManager.getConnection(url, db_id, db_pw);

				// ���������� ���� ����غ���
				// ����� ���� sql��
				

				String sql = "insert into member values(?, ?, ?, ?)"; // String sql = "insert into member values() + id
																		// + pw + name + age"; �̷��Ե� ����

				psmt = conn.prepareStatement(sql);

				psmt.setString(1, id);
				psmt.setString(2, pw);
				psmt.setString(3, name);
				psmt.setInt(4, age);

				// ������ sql�� ä������ ���� sql�� ����
				// ������ ������ �� ���̺� ��ȭ�� �Ͼ�� executeUpdate�� ���

				int cnt = psmt.executeUpdate();

				if(cnt > 0) {
					System.out.println("ȸ������ ����");
				}else {
					System.out.println("ȸ������ ����");
				}
				
			} catch (SQLException e) {

				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			
		//DB���� �� �� DB�� ���� ���� ��ɹ�
		} finally {
			
			try {
				psmt.close();
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
