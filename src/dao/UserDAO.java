package dao;

import java.util.List;

import ConcreteBuilder.UserQueryBuilder;
import ORM.DbContext;
import SqlQueryBuilder.QueryDirector;
import entities.User;

public class UserDAO extends DbContext {
	private User user;

	public UserDAO(User user) {
		super(user);
		this.user = user;
		QueryDirector qd = new QueryDirector(new UserQueryBuilder(user));
		qd.constructQuery();
		super.setQuery(qd.getQuery());
	}

	public User SelectFirstOrDefault() {
		String sql = "Select * from Users where userId ='" + user.getUserId() + "' and password='" + user.getPassWord()
				+ "'";
		super.setSql(sql);
		List<User> users = (List<User>) super.CustomReadAction();
		return users.get(0);

	}

	public void setUser(User user) {
		this.user = user;
	}

}
