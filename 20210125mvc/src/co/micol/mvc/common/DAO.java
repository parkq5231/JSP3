package co.micol.mvc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "hr";
	private String password = "hr";

	public Connection conn;

	public DAO() {	//상위 DAO class
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공!");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB 연결 실패...");
		}
	}
}