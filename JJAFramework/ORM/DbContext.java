package ORM;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SqlQueryBuilder.Query;
import entities.Entity;

public abstract class DbContext extends DbSet {
	private String sql;
	private Query query;
	private List<Entity> lst;
	private Entity entity;

	public DbContext(Entity entity) {
		super(DataAccessFactory.getDataAccess());
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
			dataAccess.read(this);
		} catch (SQLException e) {
		}
		return lst;
	}

	public void unpackResultSet(ResultSet rs) throws SQLException {
		while (rs.next()) {
			try {
				lst.add(EntityFactory.getEntityFactory().createEntity(rs, entity.getClass().getName(), entity));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean Add() {
		this.sql = query.getInsertQuery();
		try {
			dataAccess.write(this);
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
			dataAccess.write(this);
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
			dataAccess.write(this);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<?> CustomReadAction() {
		try {
			dataAccess.read(this);
		} catch (SQLException e) {
		}
		return lst;
	}

	public boolean CustomWriteAction(Object o) {
		try {
			dataAccess.write(this);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public abstract Entity SelectFirstOrDefault();
}
