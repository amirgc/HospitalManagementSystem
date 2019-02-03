package dao;

import java.util.List;

import ORM.DbContext;
import SqlQueryBuilder.DynamicQueryBuilder;
import SqlQueryBuilder.QueryDirector;
import entities.User;

public class UserDAO extends DbContext {
	private User user;

	public UserDAO(User user) {
		super(user);
		this.user = user;
		QueryDirector qd = new QueryDirector(new DynamicQueryBuilder(user));
		qd.constructQuery();
		super.setQuery(qd.getQuery());
	}

	@Override
	public User SelectFirstOrDefault() {
		String sql = "Select * from user where userId ='" + user.getUserId() + "' and passWord='" + user.getPassWord()
				+ "'";
		super.setSql(sql);
		List<User> users = (List<User>) super.CustomReadAction();
		return users.get(0);
	}

	public void setUser(User user) {
		this.user = user;
	}

}
