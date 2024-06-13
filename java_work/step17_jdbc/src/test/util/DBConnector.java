package test.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	public DBConnector(String id, String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", id, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return conn;
	}

	private Connection conn;
}