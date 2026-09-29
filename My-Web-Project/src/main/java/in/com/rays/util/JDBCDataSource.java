package in.com.rays.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//Iska main kaam hai Connection Pooling.
//Connection lo -> Database ka kaam karo -> Connection close

public final class JDBCDataSource {

	private static JDBCDataSource jdbc = null;
	private ComboPooledDataSource cpds = null; // Ye object database connections ko manage karega.

	private static ResourceBundle rb = ResourceBundle.getBundle("in.com.rays.bundle.system");

	private JDBCDataSource() {

		// Ye private constructor hai. Iska important purpose: Bahari class directly
		// object nahi bana sakti.

		cpds = new ComboPooledDataSource(); // Yahan connection pool create ho raha hai.

		try {
			cpds.setDriverClass(rb.getString("driver"));
			cpds.setJdbcUrl(rb.getString("url"));
			cpds.setUser(rb.getString("username"));
			cpds.setPassword(rb.getString("password"));
			cpds.setMaxPoolSize(30);
			cpds.setMinPoolSize(10);
			cpds.setAcquireIncrement(5);
			cpds.setInitialPoolSize(10);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	private static JDBCDataSource getInstance() {

		// Ye method JDBCDataSource ka object provide karne ke liye hai.

		if (jdbc == null) {
			jdbc = new JDBCDataSource();
		}
		return jdbc;
	}

	public static Connection getConnection() {

		// Ye method application ko database connection provide karta hai.

		try {
			return getInstance().cpds.getConnection();

			// getInstance() ->JDBCDataSource ka object deta hai.
			// .cpds -> us object ka connection pool access karta hai.
			// .getConnection() -> pool se ek connection leta hai.

		} catch (SQLException e) { // Agar database connection lene me problem aaye, SQLException handle hogi.
			e.printStackTrace();
		}
		return null; // Agar connection nahi milta, method null return karega.

	}

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void trnRollBack(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
