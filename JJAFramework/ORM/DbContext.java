package ORM;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SqlQueryBuilder.Query;
import entities.Entity;

public class DbContext implements DbSet {
	private String sql;
	private Query query;
	private List<Object> lst;
	private static Entity entity;
	DataAccess da = DataAccessFactory.getDataAccess();

	public DbContext(Entity entity) {
		DbContext.entity = entity;
		lst = new ArrayList<Object>();
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	@Override
	public List<?> Select() {
		try {
			this.sql = query.getSelectquery();
			da.read(this);
		} catch (SQLException e) {
		}
		return lst;
	}

	public void unpackResultSet(ResultSet rs) throws SQLException {
		while (rs.next()) {
			try {
				lst.add(instantiate(rs, entity.getClass().getName()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean Add(Object o) {
		this.sql = query.getInsertQuery();
		try {
			da.write(this);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean Update(Object o) {
		this.sql = query.getUpdateQuery();
		try {
			da.write(this);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean Remove(Object o) {
		this.sql = query.getDeleteQuery();
		try {
			da.write(this);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<?> CustomReadAction() {
		try {
			da.read(this);
		} catch (SQLException e) {
		}
		return lst;
	}

	public boolean CustomWriteAction(Object o) {
		try {
			da.write(this);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	static Object instantiate(ResultSet rs, String className) throws Exception {
		// Load the class.
		Class<?> clazz = Class.forName(className);
		// Search for an "appropriate" constructor.
		for (Constructor<?> ctor : clazz.getConstructors()) {
			Class<?>[] paramTypes = ctor.getParameterTypes();
			Field[] fs = entity.getClass().getDeclaredFields();
			Object[] convertedArgs = new Object[entity.getClass().getDeclaredFields().length];
			for (int i = 0; i < convertedArgs.length; i++) {
				convertedArgs[i] = convert(paramTypes[i], rs.getString(fs[i].getName()));
			}
			// Instantiate the object with the converted arguments.
			return ctor.newInstance(convertedArgs);
		}

		throw new IllegalArgumentException("Don't know how to instantiate " + className);
	}

	static Object convert(Class<?> target, String s) {
		if (target == Object.class || target == String.class || s == null) {
			return s;
		}
		if (target == Character.class || target == char.class) {
			return s.charAt(0);
		}
		if (target == Byte.class || target == byte.class) {
			return Byte.parseByte(s);
		}
		if (target == Short.class || target == short.class) {
			return Short.parseShort(s);
		}
		if (target == Integer.class || target == int.class) {
			return Integer.parseInt(s);
		}
		if (target == Long.class || target == long.class) {
			return Long.parseLong(s);
		}
		if (target == Float.class || target == float.class) {
			return Float.parseFloat(s);
		}
		if (target == Double.class || target == double.class) {
			return Double.parseDouble(s);
		}
		if (target == Boolean.class || target == boolean.class) {
			return Boolean.parseBoolean(s);
		}
		throw new IllegalArgumentException("Don't know how to convert to " + target);
	}
}
