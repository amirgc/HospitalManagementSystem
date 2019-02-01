package ORM;

import java.util.List;

public interface DbSet {
	public List<?> Select();
	public boolean Add();
	public boolean Update();
	public boolean Remove();
}
