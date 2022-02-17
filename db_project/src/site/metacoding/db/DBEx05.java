package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBEx05 {

	//dept 테이블의 모든 내용을 출력하시오.
	//SELECT deptno, dname, loc FROM dept
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection
					  ("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB연결완료");
			
			String sql = "SELECT deptno, dname, loc FROM dept";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			List<Dept> depts = new ArrayList<>(); 
			while (rs.next()) {
				Dept dept = new Dept(
						rs.getInt("deptno"),
						rs.getString("dname"),
						rs.getString("loc")
						);
				depts.add(dept);
				
			}
			
			//for each 문 사용해서 출력
			for(Dept dept : depts) {
				System.out.println("deptno : "+dept.getDeptno());
				System.out.println("dename : "+dept.getDname());
				System.out.println("loc : "+dept.getLoc());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
