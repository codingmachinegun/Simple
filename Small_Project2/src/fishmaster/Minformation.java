package fishmaster;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Minformation {
	
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String user = "scott";
	static String password = "1234";
	public static void main(String[] args) {
		Connection conn;
		Statement stmt;
		ResultSet rs;
		
	try {
		Class.forName(driver);
		  System.out.println("Oracle 드라이버 로딩 성공");
		  conn=DriverManager.getConnection(url, user, password);
		
		  stmt =conn.createStatement();
		  System.out.println("Statement 객체 생성 성공");
		  
		  String query="select * from Minformation";
		  System.out.println(query);		 
		  rs=stmt.executeQuery(query);
		 
		  while(rs.next()) {
	      System.out.println("회원번호>>"+rs.getString("mnum"));
  		  System.out.println(",회원이름>>"+rs.getString("mname"));
		  System.out.println(",사는지역>>"+rs.getString("area"));
		  System.out.println(",전화번호>>"+rs.getString("mphone"));
		  System.out.println(",성별>>"+rs.getString("msex"));
		  System.out.println(",경력>>"+rs.getString("mcareer"));
		  			  
		  System.out.println();
		  }
		  rs.close();
		  stmt.close();
		  conn.close();
		  
		  
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
	}
	}
	}
