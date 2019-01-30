package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dal.Dao;
import dal.DataAccess;
import dal.DataAccessFactory;
import entities.Address;
import entities.User;

public class UserDAO implements Dao {
	private ArrayList<User> users;
	DataAccess da = DataAccessFactory.getDataAccess();
	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String getSelectSql() {
		String sql = "Select * from Users where userId ='" + user.getUserId() + "' and password='" + user.getPassWord()
				+ "'";
				return sql;
	}

	@Override
	public String getInsertSql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateSql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unpackResultSet(ResultSet rs) throws SQLException {
		users = new ArrayList<User>();
				while (rs.next()) {
			//System.out.println(rs.getString("userId") + rs.getString("userName") + rs.getString("password"));
			users.add(new User(rs.getString("userId"), rs.getString("userName"), rs.getString("password"),
					rs.getString("authLevel")));
		}

	}

	@Override
	public boolean InsertUpdate(Object o) {
		
		return false;
	}

	@Override
	public List<?> Select() {
		
		return null;
	}

	@Override
	public Object SelectFirstOrDefault() {
		try {
			da.read(this);
		} catch (SQLException e) {

		}
		return users.get(0);
	}

}
