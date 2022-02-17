package site.metacoding.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//UPDATE
public class DBEx07 {

	public static void main(String[] args) {
		try {
			// 1. connection ���� (���ǻ���) port, ip, id, password, protocal
			Connection conn = DriverManager.getConnection
					  ("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB����Ϸ�");
			
			//2. ���� �޾Ƽ� ��� (ALL:SELECT * FROM emp)
			String sql = "UPDATE userTbl SET username = ? WHERE id = ?"; // emp���� �����ݷ� �ʿ� ����.
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, 4);//����ǥ�� ����, ��
			pstmt.setString(1, "ssa");
			pstmt.setInt(2, 1);
			//���� -1, ���� �����(����,����,����)row����, �ƹ���ȭ�� ������ 0
			int result =pstmt.executeUpdate();// delete, update, insert (���ο� commit ����)
			
			if(result>0) {
				System.out.println("����");//1
			}else {
				System.out.println("����");//0
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}