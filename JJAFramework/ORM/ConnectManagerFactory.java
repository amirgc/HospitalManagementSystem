package ORM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectManagerFactory {
	private static Connection connection = null;
	// private static final String DB_URL =
	// "jdbc:ucanaccess:Server=myServerAddress;Port=3306;Database=sql3276627;Uid=sql3276627;Pwd=zQZRhxc9tp;";

	public static Connection getMsAccessConnect() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

		} catch (ClassNotFoundException cnfex) {
			System.out.println("Problem in loading or " + "registering MS Access JDBC driver");
			cnfex.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection("jdbc:ucanaccess://src/MsAccessDb/LibraryManagementSystem.accdb");
		} catch (SQLException e) {

		}
		return connection;
	}

	public static Connection getMySqlConnect() {

		String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3276627";
		String user = "sql3276627";
		String password = "zQZRhxc9tp";

		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException cnfex) {
			System.out.println("Problem in loading or " + "registering My Sql JDBC driver");
			cnfex.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(url, user, password);
			// DriverManager.getConnection("jdbc:mysql://Server=sql3.freemysqlhosting.net;Port=3306;Database=sql3276627;Uid=sql3276627;Pwd=zQZRhxc9tp;");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Exception on making connection");
		}
		return connection;
	}
}
