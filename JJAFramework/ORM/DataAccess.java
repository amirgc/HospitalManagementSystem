package ORM;

import java.sql.SQLException;

public interface DataAccess {	
	void read(DbContext dc) throws SQLException;	
	boolean write(DbContext dc) throws SQLException;
}
