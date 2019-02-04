package dao;

import java.util.List;

import ORM.DbContext;
import SqlQueryBuilder.DynamicQueryBuilder;
import SqlQueryBuilder.QueryDirector;
import entities.Charge;
import entities.Entity;
import entities.Patient;
import entities.User;

public class BillDAO extends DbContext {
	private Charge charge;
	
	public BillDAO(Charge charge) {
		super(charge);
		this.charge = charge;
		QueryDirector qd = new QueryDirector(new DynamicQueryBuilder(charge));
		qd.constructQuery();
		super.setQuery(qd.getQuery());
	}
	
	public List<Charge> getBillDetailsByName(String name) {
		String query = "SELECT FROM CHARGE WHERE patientId= '"+name+"'";
		super.setSql(query);
		List<Charge> charges = (List<Charge>) super.CustomReadAction();
		return charges;
		
	}

	@Override
	public Entity SelectFirstOrDefault() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
