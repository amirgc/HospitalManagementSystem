package dal;

import java.sql.SQLException;

public interface DataAccess1 {
	void read(Dao1 dao) throws SQLException;

	boolean write(Dao1 dao) throws SQLException;

}
