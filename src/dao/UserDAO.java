package dao;

import java.util.List;

import ORM.DbContext;
import SqlQueryBuilder.QueryDirector;
import SqlQueryBuilder.UserQueryBuilder;
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
		super.setSql(UserQueryBuilder.getSelectQueryByUserNameAndPassword(user.getUserId(), user.getPassWord()));
		List<User> users = (List<User>) super.CustomReadAction();
		return users.get(0);
	}

	public void setUser(User user) {
		this.user = user;
	}

}
