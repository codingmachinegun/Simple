package fishmaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Finfo {
	
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
public void fclass() {
		
		try {
			connDB();
			stmt= conn.createStatement();
			String query= "select * from finfo"; //지역변수 선언
			System.out.println("query"+query);
			rs=stmt.executeQuery(query); //select문장
			System.out.println("rs"+rs);
			
			//finfo 테이블에서 불러오기
			while(rs.next()) {
			String fname=rs.getString("fname");
			String FLENGTH=rs.getString("FLENGTH");
			String FFORBI=rs.getString("FFORBI");
			String BAIT=rs.getString("BAIT");
			String SEASON=rs.getString("SEASON");	
				
			
			System.out.println("물고기 이름 >>"+rs.getString("Fname"));	
			System.out.println("물고기 금지체장 >>"+rs.getString("FLENGTH"));	
			System.out.println("물고기 금어기 >>"+rs.getString("FFORBI"));	
			System.out.println("물고기 추천미끼 >>"+rs.getString("BAIT"));	
			System.out.println("물고기 철 >>"+rs.getString("SEASON"));	
			}
			
			rs.close();
		  	stmt.close();
		  	conn.close();
				
		}catch(SQLException e) {
			e.printStackTrace();
		
		}	
}
	
}
