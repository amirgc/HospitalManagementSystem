package ORM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccessSystem implements DataAccess {
	DataAccessSystem() {
	}

	public void read(DbContext dc) throws SQLException {
		String query = dc.getSql();

		Connection con = null;
		try {
			con = ConnectManager.getConnectionByType("MSSQL");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			dc.unpackResultSet(rs);
		} catch (Exception e) {
			con.close();
			System.out.println(e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public boolean write(DbContext dc) {
		String query = dc.getSql();
		Connection con = null;
		try {
			con = ConnectManager.getConnectionByType("MSSQL");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
			return true;
		} finally {
			if (con != null) {
				try {
					con.close();
					return false;
				} catch (Exception e) {
					return false;
				}
			}
		}
	}

}
