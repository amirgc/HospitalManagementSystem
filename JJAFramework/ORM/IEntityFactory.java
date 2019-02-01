package ORM;

import java.sql.ResultSet;

import entities.Entity;

public interface IEntityFactory {
	public Entity createEntity(ResultSet rs, String type, Entity entity);
}
