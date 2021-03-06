package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBEx01 {

	public static void main(String[] args) {
		try {
			// 1. connection 연결 (세션생성) port, ip, id, password, protocal
			Connection conn = DriverManager.getConnection
					  ("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB연결완료");
			
			//2. 버퍼 달아서 통신 (ALL:SELECT * FROM emp)
			String sql = "SELECT empno, ename FROM emp"; // emp끝에 세미콜론 필요 없음.
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs =pstmt.executeQuery();// SELLECT
			//pstmt.executeUpdate();// INSERT, UPDATE, DELETE
			//rs.next();//커서 한칸 내리기
			//System.out.println(rs.next());
			
			while (rs.next()) {
				System.out.println("empno : "+ rs.getInt("empno"));
				System.out.println("ename : "+rs.getString("ename"));
				System.out.println("==========");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
