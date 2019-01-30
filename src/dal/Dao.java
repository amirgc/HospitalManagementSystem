package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Dao {
	public String getSelectSql();
	public String getInsertSql();
	public String getUpdateSql();
	public void unpackResultSet(ResultSet rs) throws SQLException;
	public boolean InsertUpdate(Object o)  ;
	public List<?> Select();
	public Object SelectFirstOrDefault();
}
