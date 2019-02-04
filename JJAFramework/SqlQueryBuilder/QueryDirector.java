package SqlQueryBuilder;

public class QueryDirector {
	private QueryBuilder qb = null;

	public QueryDirector(QueryBuilder qb) {
		this.qb = qb;
	}

	public void constructQuery() {
		qb.buildSelectQuery();
		qb.buildInsertQuery();
		qb.buildUpdateQuery();
		qb.buildDeleteQuery();
	}

	public Query getQuery() {
		return qb.getQuery();
	}
}
