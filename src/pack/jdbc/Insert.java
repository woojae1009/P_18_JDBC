package pack.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

	private static Connection conn;

	public static void main(String[] args) {
		PreparedStatement pstmt;
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/Store?useSSL=false&";
			url += "useUnicode=true&";
			url += "characterEncoding=utf8&";
			url += "serverTimezone=UTC&";
			url += "allowPublicKeyRetrieval=true";
						
		String uid = "root";
		String upw = "1234";
		conn = DriverManager.getConnection(url, uid, upw);
		// System.out.println("DB 접속 OK!!!");
		
		String sql = "insert into product (num, goodCode, goodsName, price, stock) values (?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, "abc");
		pstmt.setString(2, "크래커");
		pstmt.setInt(3, 1500);
		pstmt.setInt(4, 26);
		pstmt.executeUpdate();
		
		System.out.println("입력 완료!!");
		
	} catch (ClassNotFoundException | SQLException e) {
		System.out.println("드라이버 오류발생 : " + e.getMessage());
	}	

	}

}
