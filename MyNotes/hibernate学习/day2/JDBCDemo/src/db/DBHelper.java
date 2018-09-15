package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	static {
		try {
			// 加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 建立连接
			String dburl = "jdbc:oracle:thin:@192.168.199.107:1521:orcl";
			String dbuser = "willi";
			String password = "hahaha";
			conn = DriverManager.getConnection(dburl, dbuser, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private static Connection conn;

	public static Connection getConnection() throws Exception {
		return conn;
	}

	public static void destory() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
