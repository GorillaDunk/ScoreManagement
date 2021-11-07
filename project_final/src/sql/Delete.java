package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {

	public static void main(String[] args) {

		// 아이디 비밀번호 입력해서 회워정보 삭제

		Connection conn = null;

		PreparedStatement psmt = null;

		String name = null;

		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String id = sc.next();

		System.out.print("비밀번호 : ");
		String pw = sc.next();

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			String db_id = "hr";

			String db_pw = "hr";

			conn = DriverManager.getConnection(url, db_id, db_pw);



			
			
			String sql = "DELETE FROM member WHERE id = ? and pw = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);

			int cnt = psmt.executeUpdate();
			
			
			
			if(cnt >0) {
				System.out.println("삭제성공");
			} else {
				System.out.println("삭제실패");
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
