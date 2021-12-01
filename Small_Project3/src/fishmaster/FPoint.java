package fishmaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FPoint {

	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String user = "scott";
	static String password = "1234";
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");

			stmt = conn.createStatement();
			System.out.println("Statement 객체 생성 성공");

		} catch (Exception e) {
			e.printStackTrace();
          }
             }
public void fpoint() {
		
		try {
			connDB();
			stmt= conn.createStatement();
			String query= "select * from fpoint"; //지역변수 선언
			System.out.println("query"+query);
			rs=stmt.executeQuery(query); //select문장
			System.out.println("rs"+rs);
			
			//finfo 테이블에서 불러오기
			while(rs.next()) {
			String pointname=rs.getString("pointname");
			String pointlocation=rs.getString("pointlocation");
			String fname=rs.getString("fname2");
	
			
			System.out.println("물고기 맛집 포인트 >>"+rs.getString("pointname"));	
			System.out.println("포인트 주소 >>"+rs.getString("pointlocation"));	
			System.out.println("잘 잡히는 물고기 >>"+rs.getString("fname2"));	

			}
			
			rs.close();
		  	stmt.close();
		  	conn.close();
				
		}catch(SQLException e) {
			e.printStackTrace();
		
		}	
}
	
}

	

