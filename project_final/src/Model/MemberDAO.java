package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BookList.BookDTO;
import Class_mg.ClassDTO;
import GSP.GSPDTO;
import Score.ScoreDTO;
import Teacher.MainDTO;
import login.Student_signDTO;

public class MemberDAO {

	boolean result = false;

	Connection conn = null;

	PreparedStatement psmt = null;

	ResultSet rs = null;

	Student_signDTO dto = new Student_signDTO(null, null, null);
	StringToDate date = new StringToDate();
	
	
	
	

	public void conn() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";

			String db_id = "gon";

			String db_pw = "1234";

			conn = DriverManager.getConnection(url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	
	
	
	
	
	public void close() {

		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("close에러");
		}

	}

	
	
	public String login_teacher_id(Student_signDTO dto) {
		//선생님으로 로그인 했을 때 선생님 창으로 뜨게하기 위해서 선생님 id 조회
		
		conn();
		
		String id = null;
		String pw = null;
		
		String sql = "Select teacher_id, teacher_pw from teacher";
		try {

			psmt = conn.prepareStatement(sql);

			
			rs = psmt.executeQuery();

			while (rs.next()) {

				id = rs.getString(1);
				pw = rs.getString(2);
			
			}
			;
			// 쿼리문 작성했는데 검색한 자료가 테이블 안에 있으면 true를 출력 아니면 false.

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close();
		}

		return id;
	};

	
	
	public String login_teacher_pw(Student_signDTO dto) {
		//선생님으로 로그인 했을 때 선생님 창으로 뜨게하기 위해서 선생님 id 조회
		
		conn();
		
		String id = null;
		String pw = null;
		
		String sql = "Select teacher_id, teacher_pw from teacher";
		try {

			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {

				id = rs.getString(1);
				pw = rs.getString(2);
			
			}
			;
			// 쿼리문 작성했는데 검색한 자료가 테이블 안에 있으면 true를 출력 아니면 false.

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close();
		}

		return pw;
	};

	
	
	
	public String login_Student_id(Student_signDTO dto) {
		//선생님으로 로그인 했을 때 선생님 창으로 뜨게하기 위해서 선생님 id 조회
		
		conn();
		
		
		String id = null;
		String pw = null;
		
		String sel_id = dto.getId();
		String sel_pw = dto.getPw();
		
		
		
		String sql = "Select std_id, std_pw from student where std_id = ? and std_pw = ?";
		try {

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, sel_id);
			psmt.setString(2, sel_pw);
			
			rs = psmt.executeQuery();

			if (rs.next()) {

				id = rs.getString(1);
				pw = rs.getString(2);
			
			}
			;
			// 쿼리문 작성했는데 검색한 자료가 테이블 안에 있으면 true를 출력 아니면 false.

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close();
		}

		return id;
	};
	
	
	
	
	
	
	public String login_Student_pw(Student_signDTO dto) {
		//선생님으로 로그인 했을 때 선생님 창으로 뜨게하기 위해서 선생님 id 조회
		
		conn();
		
		String id = null;
		String pw = null;
		
		String sel_id = dto.getId();
		String sel_pw = dto.getPw();
		
		
		
		String sql = "Select std_id, std_pw from student where std_id = ? and std_pw = ?";
		try {

			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, sel_id);
			psmt.setString(2, sel_pw);
			
			rs = psmt.executeQuery();

			if (rs.next()) {

				id = rs.getString(1);
				pw = rs.getString(2);
			
			}
			;
			// 쿼리문 작성했는데 검색한 자료가 테이블 안에 있으면 true를 출력 아니면 false.

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close();
		}
		return pw;
	};

	
	
	
	
	
	
	
	public boolean sign_up(Student_signDTO dto) {
		// 회원가입시 입력한 정보를 DB에 저장

		conn();

		String sql = "insert into student values(?,?,?, sysdate, null)";

		
		
		try {
			

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(3, dto.getName());
			psmt.setString(2, dto.getPw());

			int cnt = psmt.executeUpdate();

			if (cnt > 0) {
				result = true;
				System.out.println("생성 완료");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;

	}

	
	
	
	
	
	
	
	//---------------------------------------------------------------------------------------
	
	//한나에게 받은 DAO들
	
	
	
	public boolean student_add(MainDTO dto){
		
		conn();
		

		
//		String sql="insert into Student( std_id, std_pw, std_name, join_date, SCORE_id) "
//				+ "values(?, ?, ?, to_date(?,'dd/mm/yyyy'), null)";
		
		
		String sql="insert into student(std_id, std_pw, std_name, join_date) values(?,?,?,to_date(?,'dd/mm/yyyy'))";
		
		
		try {
			
			psmt = conn.prepareStatement(sql);
			
			 StringToDate st = new StringToDate();
			 
			
			 
			psmt.setString(1,dto.getStd_id());
			psmt.setString(2,dto.getStd_pw());
			psmt.setString(3,dto.getStd_name());
			psmt.setString(4,dto.getJoin_date());
			
			System.out.println(dto.getStd_id());
			System.out.println(dto.getStd_pw());
			System.out.println(dto.getStd_name());
			System.out.println(dto.getJoin_date());
			
			int cnt=psmt.executeUpdate();
		
			if(cnt>0) {
				result= true;
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return result;
		
		
	}
	




	public boolean book_add(BookDTO dto) {
	      
	      conn();
	      String sql="insert into Book(book_id, book_name, writer, publisher, lev) values(?,?,?,?,?)";

	      
	      try {
	    	  
	    	  psmt = conn.prepareStatement(sql);
	    	  
	         psmt.setString(1,dto.getBook_id());
	         psmt.setString(2, dto.getBook_name());
	         psmt.setString(3, dto.getWriter());
	         psmt.setString(4, dto.getPublisher());
	         psmt.setString(5, dto.getLev());
	         
	         int cnt= psmt.executeUpdate();
	         
	         if(cnt>0) {
	            result = true;
	         }
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         close();
	      }
	      return result;
	       
	   }
	
	
	   

	public boolean score_add(ScoreDTO dto) {
	      conn();
	      
	      //조인문 필요
	      String sql="insert into score(score_id, std_id, std_name, ex_date, weekly_test, monthly_test) values(score_id.nextval,?,?,to_date(?,'dd/mm/yyyy'), ?,?)";
	      
	      
	      try {
	           psmt = conn.prepareStatement(sql);
	           
	           StringToDate st = new StringToDate();
	            
	         psmt.setString(1,dto.getStd_id());
	         psmt.setString(2,dto.getStd_name());
	         psmt.setString(3, dto.getEx_date());
	         psmt.setString(4, dto.getWeekly_test());
	         psmt.setString(5, dto.getMonthly_test());

	         int cnt = psmt.executeUpdate();
	         
	         if(cnt>0) {
	            result=true;
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         close();
	      }
	      return result;
	   
	      
	      
	   }
	   
	


	

	
	//중복아이디체크
	   public boolean findExistID(String id) {
	      conn();
	      String sql="select count(*) cnt from Student where std_id=?";
	   
	      try {
	         psmt=conn.prepareStatement(sql);
	         psmt.setString(1,id);
	         rs=psmt.executeQuery();
	        
	         if(rs.next()) {
	            
	        	 int cnt= rs.getInt("cnt");
	            
	            if(cnt>0) {
	               return true;
	            }
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close();
	      }return false;
	   
	   }// find
	   
	
	
	//----------------------------------------------------------------------------------------
	
	public ArrayList<MainDTO> Search_student(String std_name) {
		// 학생 정보 조회시 정보 조회

		ArrayList<MainDTO> list = new ArrayList<MainDTO>();

		conn();

//		// String name = null;
//		String std_id = null;
//		String std_pw = null;
//		String join_date = null;

		String sql = "SELECT std_id, std_pw , std_name, join_date from student WHERE std_name = ?";

		try {

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, std_name);

			rs = psmt.executeQuery();

			while (rs.next()) {

				String Std_id = rs.getString(1);
				String Std_pw = rs.getString(2);
				String Std_name = rs.getString(3);
				String Join_date = rs.getString(4);

				MainDTO dto = new MainDTO(Std_id, Std_pw, Std_name, Join_date);

				list.add(dto);

			}
			;
			// 쿼리문 작성했는데 검색한 자료가 테이블 안에 있으면 true를 출력 아니면 false.

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		
		}

		return list;

	}

	
	
	
	
	

	public ArrayList<ScoreDTO> Search_score(String std_name) {
		// 학생 정보 조회시 정보 조회

		ArrayList<ScoreDTO> list = new ArrayList<ScoreDTO>();
		conn();

//		// String name = null;
//		String std_id = null;
//		String std_pw = null;
//		String join_date = null;

		String sql = " SELECT sc.STD_ID, std.STD_NAME, sc.Ex_date, sc.Weekly_Test, sc.monthly_test\r\n"
				+ "				 FROM SCORE sc, STUDENT std \r\n"
				+ "             WHERE sc.SCORE_ID = std.SCORE_ID AND std.std_name = ?";

		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, std_name);

			rs = psmt.executeQuery();
			while (rs.next()) {

				String Std_id = rs.getString(1);
				String Std_name = rs.getString(2);
				String Ex_date = rs.getString(3);
				String Weekly_test = rs.getString(4);
				String Monthly_test = rs.getString(5);

				ScoreDTO dto = new ScoreDTO(Std_id, Std_name, Ex_date, Weekly_test, Monthly_test);

				list.add(dto);

			}
			
			// 쿼리문 작성했는데 검색한 자료가 테이블 안에 있으면 true를 출력 아니면 false.

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		
		}

		return list;

	}
	
	
	
	
	
	
	
	
	
	// 학생 정보 모든 레코드 조회
	public ArrayList<MainDTO> show_student_table() {

		ArrayList<MainDTO> list = new ArrayList<MainDTO>();

		conn();

		String sql = "SELECT std_id, std_pw , std_name, join_date from student";

		try {
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {

				String std_id = rs.getString(1);
				String std_pw = rs.getString(2);
				String std_name = rs.getString(3);
				String join_date = rs.getString(4);

				MainDTO dto = new MainDTO(std_id, std_pw, std_name, join_date);

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	

	
	// 학생 성적 모든 레코드 조회
		public ArrayList<ScoreDTO> show_score_table() {

			ArrayList<ScoreDTO> list = new ArrayList<ScoreDTO>();

			conn();

			String sql = "SELECT sc.SCORE_ID, std.STD_NAME, sc.ex_date, sc.Weekly_Test, sc.monthly_test FROM SCORE sc, STUDENT std WHERE sc.SCORE_ID = std.SCORE_ID";
			try {
				psmt = conn.prepareStatement(sql);

				rs = psmt.executeQuery();

				while (rs.next()) {

					String std_id = rs.getString(1);
					String std_name = rs.getString(2);
					String ex_date = rs.getString(3);
					String weekly_test = rs.getString(4);
					String monthly_test = rs.getString(5);
					
					
					ScoreDTO dto = new ScoreDTO(std_id, std_name, ex_date, weekly_test, monthly_test);

					list.add(dto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return list;
		}
		
	
	
	
	// 책 전체 조회
	public ArrayList<BookDTO> show_book_table() {

		ArrayList<BookDTO> list = new ArrayList<BookDTO>();

		conn();

		String sql = "SELECT book_id, book_name, writer, publisher, lev from Book ORDER BY BOOK_ID";

		try {
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {

				String book_id = rs.getString(1);
				String book_name = rs.getString(2);
				String writer = rs.getString(3);
				String publisher = rs.getString(4);
				String lev = rs.getString(5);
				
				BookDTO dto = new BookDTO(book_id, book_name, writer, publisher, lev);

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	
	
	
	

	// level로 book 조회하는 기능

	public ArrayList<BookDTO> Search_book_name(String book_name) {
	

		
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		
		conn();
		
		
		String book_id;
		 String lev;
		 String writer;
		 String publisher;

		String sql = "SELECT book_id, book_name, writer, publisher, lev from Book WHERE book_name = ? ";
		
		
		try {

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, book_name);

			rs = psmt.executeQuery();

			while (rs.next()) {
				book_id = rs.getString(1);				
				book_name = rs.getString(2);
				writer = rs.getString(3);
				publisher = rs.getString(4);
				lev = rs.getString(5);
				
				BookDTO dto = new BookDTO(book_id, book_name, writer, publisher, lev);
				
				list.add(dto);

			}
			;
			// 쿼리문 작성했는데 검색한 자료가 테이블 안에 있으면 true를 출력 아니면 false.

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close();
		}

		return list;

	}

	
	
	
	
	
	
	
	

	// level로 book 조회하는 기능

	public ArrayList<BookDTO> Search_book_level(String lev) {
	

		
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		conn();
		String book_id;
		 String book_name;
		 String writer;
		 String publisher;

		String sql = "SELECT book_id, book_name , writer, publisher, lev from Book WHERE level = ?";
		
		try {

			psmt = conn.prepareStatement(sql);

			psmt.setString(1,lev);

			rs = psmt.executeQuery();

			while (rs.next()) {
				
				book_id = rs.getString(1);
				book_name = rs.getString(2);
				writer = rs.getString(3);
				publisher = rs.getString(4);
				lev = rs.getString(5);
				
				BookDTO dto = new BookDTO(book_id, book_name, writer, publisher, lev);
				
				list.add(dto);

			}
			;
			// 쿼리문 작성했는데 검색한 자료가 테이블 안에 있으면 true를 출력 아니면 false.

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close();
		}

		return list;

	}

	
	
	
	
	
	
	
	
	
	// 책 writer로 북 조회하는기능

	public ArrayList<BookDTO> Search_book_writer(String writer)  {
	

		
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		conn();
		String book_id ;
		
		 String book_name;
		
		 String publisher;
		 String lev;
		 
		String sql = "SELECT book_id, book_name , writer, publisher, lev from Book WHERE writer = ?";
		
		try {

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, writer);

			rs = psmt.executeQuery();

			while (rs.next()) {
			
				book_id = rs.getString(1);
				
				book_name = rs.getString(2);
				writer = rs.getString(3);
				publisher = rs.getString(4);
				lev = rs.getString(5);
				BookDTO dto = new BookDTO(book_id, book_name, writer, publisher, lev);
				
				list.add(dto);

			}
			;
			// 쿼리문 작성했는데 검색한 자료가 테이블 안에 있으면 true를 출력 아니면 false.

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close();
		}

		return list;

	}
	
	
	
	
	
	
	
	
	// 책 출판사로 북 조회하는기능

	public ArrayList<BookDTO> Search_book_publisher(String publisher) {
	

		
		ArrayList<BookDTO> list = new ArrayList<BookDTO>();
		
		conn();
		String book_id;
		 String lev;
		String book_name;
		 String writer;
		 

		String sql = "SELECT book_id, book_name , writer, publisher, lev from Book WHERE publisher = ?";
		
		try {

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, publisher);

			rs = psmt.executeQuery();

			while (rs.next()) {
				book_id =rs.getString(1);
		
				book_name = rs.getString(2);
				writer = rs.getString(3);
				publisher = rs.getString(4);
				lev = rs.getString(5);
				BookDTO dto = new BookDTO(book_id, book_name, writer, publisher, lev);
				
				list.add(dto);

			}
			;
			// 쿼리문 작성했는데 검색한 자료가 테이블 안에 있으면 true를 출력 아니면 false.

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close();
		}

		return list;

	}
	
	
	
	
	

	// psg 학생가 에세이 검색기능

	public ArrayList<GSPDTO> Search_name_GSP(String std_name) {
	

		
		ArrayList<GSPDTO> list = new ArrayList<GSPDTO>();
		
		
		conn();
		
		
		String std_id;
		 String essay;
		 String feedback;

		String sql = "SELECT s.std_id, s.std_name, e.essay, e.feedback\r\n"
				+ "FROM ESSAY e, STUDENT s\r\n"
				+ "WHERE e.std_id = s.std_id\r\n"
				+ "AND std_name = ?";
		
		try {

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, std_name);

			rs = psmt.executeQuery();

			while (rs.next()) {
				std_id = rs.getString(1);
				std_name = rs.getString(2);				
				essay =rs.getString(3);
				feedback=rs.getString(4);
				
				GSPDTO dto = new GSPDTO(std_id,std_name, essay, feedback);
				
				list.add(dto);

			}
			;
			// 쿼리문 작성했는데 검색한 자료가 테이블 안에 있으면 true를 출력 아니면 false.

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close();
		}

		return list;

	}

	
	
	
	// 책 전체 조회
	public ArrayList<GSPDTO> show_GSP_table() {

		ArrayList<GSPDTO> list = new ArrayList<GSPDTO>();

		conn();

		String sql = "\r\n"
				+ "SELECT s.std_id, s.std_name, e.essay, e.feedback\r\n"
				+ "FROM ESSAY e, STUDENT s\r\n"
				+ "WHERE e.std_id = s.std_id";

		try {
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String std_id = rs.getString(1);
				String std_name = rs.getString(2);
				String essay = rs.getString(3);
				String feedback = rs.getString(4);
				
				GSPDTO dto = new GSPDTO(std_id,std_name, essay, feedback);

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	
	
	
	
	
	public boolean save_essay (String login_id , String write_essay) {
		// 회원가입시 입력한 정보를 DB에 저장

		conn();

		String sql = "SELECT SJ.TEACHER_ID, SC.STD_ID FROM SUBJECT SJ, SCORE SC WHERE sc.std_id = ? and SJ.SUB_ID = SC.sub_ID";

		
		
		try {
			

			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, login_id);

			rs = psmt.executeQuery();

			if (rs.next()) {
				
			String teacher_id = rs.getString(1);
			
			sql = "insert into essay(teacher_id,std_id,ESSAY_ID,essay) values(?,?, ESSAY_ID.nextval,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, teacher_id);
			psmt.setString(2, login_id);
			psmt.setString(3, write_essay);
			
			int cnt = psmt.executeUpdate();
			// 확인은 필요하면 만들것
			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;

	}
	
	public boolean edit_feedback(String feedback, String essay) {
		conn();
		
		String sql = "UPDATE essay SET  feedback = ? WHERE essay = ?";
				try {
					

					psmt = conn.prepareStatement(sql);
					psmt.setString(1, feedback);
					psmt.setString(2, essay);

					int cnt = psmt.executeUpdate();

					if(cnt > 0 ) {
						System.out.println("성공");
						result = true;
					}

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close();
				}

				return result;
	}



	
	// 반 전체 조회 --> 반 코드
	public ArrayList<ClassDTO> show_sub_code(String teacher_id) {

		
		
		ArrayList<ClassDTO> list = new ArrayList<ClassDTO>();

		
		conn();

		String sql ="select sub_id from subject where teacher_id = ?";
 
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, teacher_id);
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String Sub_id = rs.getString(1);
			
				ClassDTO dto = new ClassDTO(Sub_id);

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	
	
	
	
	
	
	// 반 전체 조회  --> 학생 아이디, 학생 이름
	public ArrayList<ClassDTO> show_class_table() {

		ArrayList<ClassDTO> list = new ArrayList<ClassDTO>();

		
		conn();

		String sql ="select sc.std_id,sc.std_name from score sc, subject sj"
				+ " where sc.sub_id= sj.sub_id";
 
		try {
			psmt = conn.prepareStatement(sql);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String std_id = rs.getString(1);
				String std_name = rs.getString(2);
				
				ClassDTO dto = new ClassDTO(std_id,std_name);

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	



	public ArrayList<ClassDTO> get_select_sub(String val) {
		
		
	ArrayList<ClassDTO> list = new ArrayList<ClassDTO>();

		
		conn();

		String sql ="select sc.std_id, sc.std_name \r\n"
				+ " from score sc, subject sj\r\n"
				+ "	where sc.sub_id= sj.sub_id"
				+ " AND sj.SUB_ID = ?";
		try {
			psmt = conn.prepareStatement(sql);

	
			
			psmt.setString(1, val);
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String std_id = rs.getString(1);
				String std_name = rs.getString(2);
				
				ClassDTO dto = new ClassDTO(std_id, std_name);

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
		
		
		
		
		
		// val을 통해서 해당 학생 값들을 가져와
		// return으로 학생 값들 반환
		
		
	}


}
