package dal;

public class DataAccessFactory1 {
	public static DataAccess1 getDataAccess() {
		return new DataAccessSystem1();
	}
}
