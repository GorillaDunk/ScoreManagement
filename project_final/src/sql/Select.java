package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Select {

	public static void main(String[] args) {

		// 아이디 비밀번호를 조회해서 이게 일치하는 회원을 조회할것이다.
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String name = null;
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String id = sc.next();

		System.out.print("비밀번호 : ");
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

			// executeQeury는 값을 출력할 때
			// DB에있는 테이블에 값이 변하지 않을 때
			rs = psmt.executeQuery();

			// 쿼리문 작성했는데 검색한 자료가 테이블 안에 있으면 true를 출력 아니면 false.
			if (rs.next()) {

				// 이름 출력
				name = rs.getString(3); // 이름이 3번째 컬럼에 있어서 3번째 컬럼에 있는 값을 출력한다.

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
			System.out.println(name + "님 환영합니다.");
		}else {
			System.out.println("아이디와 비밀번호를 확인해주세요");
		}
		

	}

}
