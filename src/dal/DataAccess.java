package dal;

import java.sql.SQLException;

public interface DataAccess {
	void read(Dao dao) throws SQLException;

	boolean write(Dao dao) throws SQLException;

}
