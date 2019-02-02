package SqlQueryBuilder;

import entities.User;

public class UserQueryBuilder implements QueryBuilder {
	private Query query;
	private QueryHelper qh;

	public UserQueryBuilder(User user) {
		query = new Query();
		qh = new QueryHelper(user);
	}

	@Override
	public void buildSelectQuery() {
		query.setSelectquery("Select * from Users");
	}

	@Override
	public void buildInsertQuery() {
		String insertQuery = "Insert Into Users " + qh.getInsertQueryString();
		query.setInsertQuery(insertQuery);
	}

	@Override
	public void buildUpdateQuery() {
		query.setUpdateQuery("Update Users Set ");
	}

	@Override
	public void buildDeleteQuery() {
		query.setDeleteQuery("Delete From Users Where  ");
	}

	@Override
	public Query getQuery() {
		return query;
	}

	public static String getSelectQueryByUserNameAndPassword(String UserName, String Password) {
		return "Select * from Users where userId ='" + UserName + "' and passWord='" + Password + "'";
	}
}
