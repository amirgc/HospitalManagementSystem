package SqlQueryBuilder;

import java.lang.reflect.Field;
import entities.Entity;

public class DynamicQueryBuilder implements QueryBuilder {
	private Query query;
	private Entity entity;
	private String tableName;
	private Field[] fs;

	public DynamicQueryBuilder(Entity e) {
		query = new Query();
		this.entity = e;
		this.tableName = entity.getClass().getSimpleName().toLowerCase();
		fs = entity.getClass().getDeclaredFields();
	}

	@Override
	public void buildSelectQuery() {
		// System.out.println(this.tableName);
		query.setSelectquery("SELECT * FROM  " + this.tableName);
	}

	@Override
	public void buildInsertQuery() {

		String insertQuery = "Insert Into " + this.tableName + " (";
		for (Field field : fs) {
			insertQuery += field.getName() + ",";
		}
		insertQuery = insertQuery.substring(0, insertQuery.length() - 1);
		insertQuery += ") Values (";
		Object value = null;

		for (Field field : fs) {
			field.setAccessible(true);
			try {
				value = field.get(entity);
			} catch (IllegalArgumentException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			insertQuery += "'" + value.toString() + "',";
		}
		insertQuery = insertQuery.substring(0, insertQuery.length() - 1);
		insertQuery += ")";

		query.setInsertQuery(insertQuery);
	}

	@Override
	public void buildUpdateQuery() {

		Object entityId = null;
		try {
			entityId = fs[0].get(entity);
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}

		String upadteQuery = "Update " + this.tableName + " Set ";
		Object value = null;
		for (Field field : fs) {
			field.setAccessible(true);
			upadteQuery += field.getName() + " = ";
			try {
				value = field.get(entity);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			upadteQuery += "'" + value.toString() + "',";
		}
		upadteQuery = upadteQuery.substring(0, upadteQuery.length() - 1);
		upadteQuery += " Where " + fs[0].getName() + "='" + entityId + "'";

		query.setUpdateQuery(upadteQuery);
	}

	@Override
	public void buildDeleteQuery() {
		Object entityId = null;
		try {
			entityId = fs[0].get(entity);
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		String deleteQuery = "Delete From " + this.tableName;
		deleteQuery += " Where " + fs[0].getName() + "='" + entityId + "'";
		query.setDeleteQuery(deleteQuery);
	}

	@Override
	public Query getQuery() {
		return query;
	}

}
