package fishmaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class MemberDAO {

	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String user = "scott";
	static String password = "1234";
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pstmt; // 4개다 DB접근에 필요

	public void mclass() {
		try {
			connDB();//()는 메소드를 호출하겠는 표시
		Scanner scan = new Scanner(System.in);//스케너로 입력받겠다
			
		String query="INSERT INTO Minformation VALUES(mnum.nextval,?,?,?,?,?)"; //쿼리문으로 시퀀스사용,?에 값넣어주겠다
		pstmt=conn.prepareStatement(query); //pstmt사용 준비됐다고 알려줌
		
		System.out.println("회원가입을 진행하겠습니다.");
		System.out.println("가입자의 이름을 입력하세요.");
		String mname= scan.next(); 
		pstmt.setString(1, mname); // 첫번째에 ?에 mname 넣어줄거다
		System.out.println("가입자의 거주지를 입력하세요.");
		String area= scan.next();	
		pstmt.setString(2, area);
		System.out.println("가입자의 휴대폰 번호를 입력하세요.");
		String mphone= scan.next();
		pstmt.setString(3, mphone);
		System.out.println("가입자의 성별을 입력하세요.");
		String msex= scan.next();
		pstmt.setString(4, msex);
		System.out.println("가입자의 낚시 경력을 입력하세요.");
		String mcareer= scan.next();
		pstmt.setString(5, mcareer);
		
		pstmt.executeUpdate(); //입력받은 값들을 쿼리문을 사용해 업데이트 시켜주겠다.
		
	  	stmt.close();
	  	conn.close();
		}catch(SQLException e) {
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