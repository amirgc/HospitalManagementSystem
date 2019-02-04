package SqlQueryBuilder;

public interface QueryBuilder {
	public void buildSelectQuery();

	public void buildInsertQuery();

	public void buildUpdateQuery();

	public void buildDeleteQuery();

	public Query getQuery();

}
