package SqlQueryBuilder;

import java.lang.reflect.Field;

import entities.Entity;

public class QueryHelper {

	private Entity entity;
	private Field[] fs;

	public QueryHelper(Entity entity) {
		this.entity = entity;
		fs = entity.getClass().getDeclaredFields();
	}

	public String getInsertQueryString() {
		String queryPart = "(";
		for (Field field : fs) {
			queryPart += field.getName() + ",";
		}
		queryPart = queryPart.substring(0, queryPart.length() - 1);
		queryPart += ") Values (";
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
			queryPart += "'" + value.toString() + "',";
		}
		queryPart = queryPart.substring(0, queryPart.length() - 1);
		queryPart += ")";
		return queryPart;
	}

	public String getUpdateQueryString() {
		String queryPart = "";
		Object value = null;
		for (Field field : fs) {
			field.setAccessible(true);
			queryPart += field.getName() + "=";
			try {
				queryPart += value = field.get(entity);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			queryPart += "'" + value.toString() + "',";
		}
		queryPart = queryPart.substring(0, queryPart.length() - 1);
		queryPart += ")";
		return queryPart;
	}

	public String getDeleteQueryString() {
		return "";
	}

}
