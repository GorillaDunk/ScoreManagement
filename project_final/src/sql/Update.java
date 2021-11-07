package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) {

		// ���̵� �Է¹޾Ƽ� ��й�ȣ or �̸� or ���� ����

		Connection conn = null;

		PreparedStatement psmt = null;

		String pw = null;
		int age = 0;
		String sql = null;

		Scanner sc = new Scanner(System.in);

		System.out.print("���̵� : ");
		String id = sc.next();

		System.out.print("��й�ȣ : ");
		pw = sc.next();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			String db_id = "hr";

			String db_pw = "hr";

			conn = DriverManager.getConnection(url, db_id, db_pw);

//-------------------------------------------------------------------------------------------
			System.out.println("������ ����");
			System.out.println("1. ��й�ȣ / 2. �̸�/ 3. ���� >>");
			int num = sc.nextInt();

			if (num == 1) {
				System.out.println("������ ��й�ȣ : ");
				pw = sc.next();
				sql = "UPDATE member SET  pw = ? WHERE id = ?";
				psmt = conn.prepareStatement(sql);

				psmt.setString(1, pw);
				psmt.setString(2, id);

				int cnt = psmt.executeUpdate();

				if (cnt > 0) {
					System.out.println("��й�ȣ ���� ����");
				} else {
					System.out.println("��й�ȣ ���� ����");
				}

			} else if (num == 2) {

				System.out.println("������ �̸� : ");
				String name = sc.next();
				sql = "UPDATE member SET name = ? WHERE id = ?";
				psmt = conn.prepareStatement(sql);

				psmt.setString(1, name);
				psmt.setString(2, id);

				int cnt = psmt.executeUpdate();

				if (cnt > 0) {
					System.out.println("�̸� ���� ����");
				} else {
					System.out.println("�̸� ���� ����");
				}

			} else if (num == 3) {

				System.out.println("������ ���� : ");
				age = sc.nextInt();
				sql = "UPDATE member SET age = ? WHERE id = ?";
				psmt = conn.prepareStatement(sql);

				psmt.setInt(1, age);
				psmt.setString(2, id);

				int cnt = psmt.executeUpdate();

				if (cnt > 0) {
					System.out.println("���� ���� ����");
				} else {
					System.out.println("���� ���� ����");
				}

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

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
