package ORM;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.Converter;
import entities.Entity;
import entities.User;

public class EntityFactory implements IEntityFactory {
	
	private static EntityFactory factory = new EntityFactory();

	private EntityFactory() {

	}
	public static EntityFactory getEntityFactory()
	{
		return factory;
	}

	public static User createUser(String userId, String userName, String passWord, String authLevel) {
		return new User(userId, userName, passWord, authLevel);
	}

	@Override
	public Entity createEntity(ResultSet rs, String type, Entity entity) {
		// Load the class.
		Class<?> clazz = null;
		try {
			clazz = Class.forName(type);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Search for an "appropriate" constructor.
		for (Constructor<?> ctor : clazz.getConstructors()) {
			Class<?>[] paramTypes = ctor.getParameterTypes();
			Field[] fs = entity.getClass().getDeclaredFields();
			Object[] convertedArgs = new Object[entity.getClass().getDeclaredFields().length];
			for (int i = 0; i < convertedArgs.length; i++) {
				try {
					convertedArgs[i] = Converter.convertToTarget(paramTypes[i], rs.getString(fs[i].getName()));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// Instantiate the object with the converted arguments.
			try {
				return (Entity) ctor.newInstance(convertedArgs);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		throw new IllegalArgumentException("Don't know how to instantiate " + type);
	}

}
