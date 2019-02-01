package ORM;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SqlQueryBuilder.Query;
import Utils.Converter;
import entities.Entity;

public class DbContext implements DbSet {
	private String sql;
	private Query query;
	private List<Entity> lst;
	private Entity entity;
	DataAccess da = DataAccessFactory.getDataAccess();

	public DbContext(Entity entity) {
		this.entity = entity;
		lst = new ArrayList<Entity>();
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
				// lst.add(instantiate(rs, entity.getClass().getName()));
				lst.add(EntityFactory.getEntityFactory().createEntity(rs, entity.getClass().getName(), entity));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean Add() {
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
	public boolean Update() {
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
	public boolean Remove() {
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

}
