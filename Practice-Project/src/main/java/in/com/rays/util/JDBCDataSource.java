package in.com.rays.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

	public final class JDBCDataSource {

		private static final JDBCDataSource jdbc = null;
		private ComboPooledDataSource cpds = null;

		private static ResourceBundle rb = ResourceBundle.getBundle("in.com.rays.bundle.system");

		private JDBCDataSource() {

			cpds = new ComboPooledDataSource();

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

			if (jdbc == null) {
				return new JDBCDataSource();
			}
			return jdbc;
		}

		public static Connection getConnection() {

			try {
				return getInstance().cpds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;

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
	
