package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// PrepareStatement 변수 바인딩 하기
public class DBEx03 {

	public static void login(String username, String password) {
		try {
			// 1. connection 연결 (세션생성) port, ip, id, password, protocal
			Connection conn = DriverManager.getConnection
					  ("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB연결완료");
			
			//2. 버퍼 달아서 통신 (ALL:SELECT * FROM emp)
			String sql = "SELECT * FROM userTbl WHERE username = ? AND password = ?"; // emp끝에 세미콜론 필요 없음.
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// ?의 시작번지는 1이다.
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs =pstmt.executeQuery();// SELLECT
			//pstmt.executeUpdate();// INSERT, UPDATE, DELETE
			//rs.next();//커서 한칸 내리기
			//System.out.println(rs.next());
			
			while (rs.next()) {
				Session.isLogin=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		login("ssar", "1234");
		
		System.out.println(Session.isLogin);

	}

}
