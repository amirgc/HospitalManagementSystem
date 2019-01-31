package ORM;

import java.util.List;

public interface DbSet {
	public List<?> Select();
	public boolean Add(Object o);
	public boolean Update(Object o);
	public boolean Remove(Object o);
}
