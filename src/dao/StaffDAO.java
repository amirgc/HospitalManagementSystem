package dao;

import java.util.List;

import ORM.DbContext;
import SqlQueryBuilder.DynamicQueryBuilder;
import SqlQueryBuilder.QueryDirector;
import entities.Entity;
import entities.Patient;
import entities.Staff;

public class StaffDAO extends DbContext {
	private Staff staff;
	
	public StaffDAO(Staff staff) {
		super(staff);

		this.staff = staff;
		QueryDirector qd = new QueryDirector(new DynamicQueryBuilder(staff));
		qd.constructQuery();
		super.setQuery(qd.getQuery());
	}

	
	public Staff SelectFirstOrDefault() {
		String sql = "Select * from staff where s_name ='" + staff.getS_name()+ "' and s_designation='" + staff.getS_designation()
				+ "'";
		super.setSql(sql);
		List<Staff> staff = (List<Staff>) super.CustomReadAction();
		return staff.get(0);
	}

	public void setUser(Staff staff) {
		this.staff = staff;
	}
}
