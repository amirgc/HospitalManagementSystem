package ORM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectManager {
	private ConnectManager() {
	}

	private static Connection msAccessConnection = null;
	private static Connection mySqlConnection = null;

	public static Connection getConnectionByType(String type) {
		boolean isClosed = true;
		if (type.equals("MSAccess")) {

			if (msAccessConnection == null)
				return getMsAccessConnection();

			try {
				isClosed = msAccessConnection.isClosed();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (isClosed)
				return getMsAccessConnection();
			else
				return msAccessConnection;
		}

		if (mySqlConnection == null) {
			return getMySqlConnection();
		}

		try {
			isClosed = mySqlConnection.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (isClosed)
			return getMySqlConnection();
		else
			return mySqlConnection;

	}

	private static Connection getMsAccessConnection() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		} catch (ClassNotFoundException cnfex) {
			System.out.println("Problem in loading or " + "registering MS Access JDBC driver");
			cnfex.printStackTrace();
		}

		try {
			msAccessConnection = DriverManager
					.getConnection("jdbc:ucanaccess://src/MsAccessDb/LibraryManagementSystem.accdb");
		} catch (SQLException e) {

		}
		return msAccessConnection;
	}

	private static Connection getMySqlConnection() {

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
			mySqlConnection = DriverManager.getConnection(url, user, password);
			// DriverManager.getConnection("jdbc:mysql://Server=sql3.freemysqlhosting.net;Port=3306;Database=sql3276627;Uid=sql3276627;Pwd=zQZRhxc9tp;");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Exception on making connection");
		}
		return mySqlConnection;
	}
}
