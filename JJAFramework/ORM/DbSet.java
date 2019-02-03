package ORM;

import java.util.List;

public abstract class DbSet {
	protected DataAccess dataAccess;

	protected DbSet(DataAccess da) {
		this.dataAccess = da;
	}

	public abstract List<?> Select();

	public abstract boolean Add();

	public abstract boolean Update();

	public abstract boolean Remove();
}
