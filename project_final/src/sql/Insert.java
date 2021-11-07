package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {

	public static void main(String[] args) {
		// 아이디, 비밀번호, 이름, 나이를 입력받아서 DB에 저장시키기

		Connection conn = null;
		PreparedStatement psmt = null;

		Scanner sc = new Scanner(System.in);

		System.out.print("아이디 : ");
		String id = sc.next();

		System.out.print("비밀번호 : ");
		String pw = sc.next();

		System.out.print(" 이름 : ");
		String name = sc.next();

		System.out.print(" 나이 : ");
		int age = sc.nextInt();

		// 아이디 : smhrd
		// 비밀번호 : 1234
		// 위의 아이디 비밀번호를 입력했을 때 로그인 되었습니다!

		// 예외처리 --> 만약 아래 경로를 통해서 driver를 못 가지고 온다면 어떻게 할 것인지 보여주는 try/catch문을 만들어워야한다.
		// catch문에서 추적을 종료해라라는 명령문이 있다.

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// DB 접근할 때 필요한 id, 비번, 그리고 경로 입력
			// 경로, 아이디, 비번
			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			String db_id = "hr";

			String db_pw = "hr";

			try {

				// 경로, 아이디, 비번을 적어서 db에 접근!
				conn = DriverManager.getConnection(url, db_id, db_pw);

				// 접근했으니 이제 명령해보자
				// 명령을 내릴 sql문
				

				String sql = "insert into member values(?, ?, ?, ?)"; // String sql = "insert into member values() + id
																		// + pw + name + age"; 이렇게도 가능

				psmt = conn.prepareStatement(sql);

				psmt.setString(1, id);
				psmt.setString(2, pw);
				psmt.setString(3, name);
				psmt.setInt(4, age);

				// 위에서 sql문 채웠으니 이제 sql문 실행
				// 실행을 시켰을 때 테이블에 변화가 일어날때 executeUpdate를 사용

				int cnt = psmt.executeUpdate();

				if(cnt > 0) {
					System.out.println("회원가입 성공");
				}else {
					System.out.println("회원가입 실패");
				}
				
			} catch (SQLException e) {

				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			
		//DB사용안 할 시 DB를 끄기 위한 명령문
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
