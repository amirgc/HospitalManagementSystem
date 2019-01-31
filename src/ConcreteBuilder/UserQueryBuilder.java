package ConcreteBuilder;

import SqlQueryBuilder.Query;
import SqlQueryBuilder.QueryBuilder;
import entities.User;

public class UserQueryBuilder implements QueryBuilder {
	private Query query;

	public UserQueryBuilder()
	{
		query = new Query();
	}
	@Override
	public void buildSelectQuery() {
		query.setSelectquery("Select * from users");
	}

	@Override
	public void buildInsertQuery() {
		query.setSelectquery("Select * from users");
	}

	@Override
	public void buildUpdateQuery() {
		query.setSelectquery("Select * from users");
	}

	@Override
	public void buildDeleteQuery() {
		query.setSelectquery("Select * from users");
	}

	@Override
	public Query getQuery() {
		return query;
	}

}
