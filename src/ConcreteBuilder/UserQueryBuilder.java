package ConcreteBuilder;

import SqlQueryBuilder.Query;
import SqlQueryBuilder.QueryBuilder;
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
		query.setSelectquery("Select * from users");
	}

	@Override
	public void buildInsertQuery() {
		String insertQuery = "Insert Into Users " + qh.getInsertQueryString();
		query.setInsertQuery(insertQuery);
	}

	@Override
	public void buildUpdateQuery() {
		query.setSelectquery("Select * From Users");
	}

	@Override
	public void buildDeleteQuery() {
		query.setSelectquery("Delete From Users Where  ");
	}

	@Override
	public Query getQuery() {
		return query;
	}

}
