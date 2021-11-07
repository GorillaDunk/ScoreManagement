package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) {

		// 아이디를 입력받아서 비밀번호 or 이름 or 나이 수정

		Connection conn = null;

		PreparedStatement psmt = null;

		String pw = null;
		int age = 0;
		String sql = null;

		Scanner sc = new Scanner(System.in);

		System.out.print("아이디 : ");
		String id = sc.next();

		System.out.print("비밀번호 : ");
		pw = sc.next();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			String db_id = "hr";

			String db_pw = "hr";

			conn = DriverManager.getConnection(url, db_id, db_pw);

//-------------------------------------------------------------------------------------------
			System.out.println("수정할 정보");
			System.out.println("1. 비밀번호 / 2. 이름/ 3. 나이 >>");
			int num = sc.nextInt();

			if (num == 1) {
				System.out.println("수정할 비밀번호 : ");
				pw = sc.next();
				sql = "UPDATE member SET  pw = ? WHERE id = ?";
				psmt = conn.prepareStatement(sql);

				psmt.setString(1, pw);
				psmt.setString(2, id);

				int cnt = psmt.executeUpdate();

				if (cnt > 0) {
					System.out.println("비밀번호 수정 성공");
				} else {
					System.out.println("비밀번호 수정 실패");
				}

			} else if (num == 2) {

				System.out.println("수정할 이름 : ");
				String name = sc.next();
				sql = "UPDATE member SET name = ? WHERE id = ?";
				psmt = conn.prepareStatement(sql);

				psmt.setString(1, name);
				psmt.setString(2, id);

				int cnt = psmt.executeUpdate();

				if (cnt > 0) {
					System.out.println("이름 수정 성공");
				} else {
					System.out.println("이름 수정 실패");
				}

			} else if (num == 3) {

				System.out.println("수정할 나이 : ");
				age = sc.nextInt();
				sql = "UPDATE member SET age = ? WHERE id = ?";
				psmt = conn.prepareStatement(sql);

				psmt.setInt(1, age);
				psmt.setString(2, id);

				int cnt = psmt.executeUpdate();

				if (cnt > 0) {
					System.out.println("나이 수정 성공");
				} else {
					System.out.println("나이 수정 실패");
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
