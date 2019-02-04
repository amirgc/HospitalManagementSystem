package SqlQueryBuilder;

public class Query {
	private String selectquery;
	private String insertQuery;
	private String updateQuery;
	private String deleteQuery;

	public String getInsertQuery() {
		return insertQuery;
	}

	public void setInsertQuery(String insertQuery) {
		this.insertQuery = insertQuery;
	}

	public String getUpdateQuery() {
		return updateQuery;
	}

	public void setUpdateQuery(String updateQuery) {
		this.updateQuery = updateQuery;
	}

	public String getDeleteQuery() {
		return deleteQuery;
	}

	public void setDeleteQuery(String deleteQuery) {
		this.deleteQuery = deleteQuery;
	}

	public String getSelectquery() {
		return selectquery;
	}

	public void setSelectquery(String selectquery) {
		this.selectquery = selectquery;
	}
}
