package ConcreteBuilder;

import java.lang.reflect.Field;

import entities.Entity;

public class QueryHelper {

	private Entity entity;
	private Field[] fs;
	private String queryPart;

	public QueryHelper(Entity entity) {
		this.entity = entity;
		fs = entity.getClass().getDeclaredFields();
	}

	public String getInsertQueryString() {
		queryPart = "(";
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
		return "";
	}

	public String getDeleteQueryString() {
		return "";
	}

}
