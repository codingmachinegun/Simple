package fishmaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Result {
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String user = "scott";
	static String password = "1234";
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pstmt;
	
	public void fresult() {
		try {
			connDB();//()는 메소드를 호출하겠는 표시
		Scanner scan = new Scanner(System.in);//스케너로 입력받겠다
			
		String query="INSERT INTO RESULT VALUES(RESULT_SEQ01.NEXTVAL,?,?,?,SYSDATE,?,?)"; //쿼리문으로 시퀀스사용,?에 값넣어주겠다
		pstmt=conn.prepareStatement(query); //pstmt사용 준비됐다고 알려줌
		
		System.out.println("조과 등록");
		
		System.out.println("회원 번호를 입력하세요.");
		int res_mnum= scan.nextInt();
		pstmt.setInt(1, res_mnum); // 첫번째에 ?에 mname 넣어줄거다
		
		
		System.out.println("물고기 이름을 입력하세요");
		String res_fname= scan.next();
		pstmt.setString(2, res_fname);
		
		System.out.println("낚시 포인트를 입력하세요.");
		String res_pointname= scan.next();
		pstmt.setString(3, res_pointname);
		
		System.out.println("잡은 물고기의 체장을 입력하세요.");
		int getlength= scan.nextInt();
		pstmt.setInt(4, getlength);
		
		System.out.println("잡은 물고기의 마릿수를 입력하세요.");
		int getnum= scan.nextInt();
		pstmt.setInt(5, getnum);
		
		pstmt.executeUpdate(); //입력받은 값들을 쿼리문을 사용해 업데이트 시켜주겠다.
		
		
		
	  	pstmt.close();
	  	conn.close();
		}catch(SQLException e) {
			System.out.println("항목을 잘못 입력했습니다");
			e.printStackTrace();
		}
		
	}
	
	
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

}
