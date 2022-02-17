package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBEx02 {

	//dept ���̺��� ��� ������ ����Ͻÿ�.
	//SELECT deptno, dname, loc FROM dept
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection
					  ("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB����Ϸ�");
			
			String sql = "SELECT deptno, dname, loc FROM dept";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println("deptno : "+rs.getInt("deptno"));
				System.out.println("dname : "+rs.getString("dname"));
				System.out.println("loc : "+rs.getString("loc"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
