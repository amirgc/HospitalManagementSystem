package dao;

import ORM.DbContext;
import SqlQueryBuilder.DynamicQueryBuilder;
import SqlQueryBuilder.QueryDirector;
import entities.Charge;
import entities.Entity;
import entities.Patient;

public class BillDAO extends DbContext {
	private Charge charge;
	
	public BillDAO(Charge charge) {
		super(charge);
		this.charge = charge;
		QueryDirector qd = new QueryDirector(new DynamicQueryBuilder(charge));
		qd.constructQuery();
		super.setQuery(qd.getQuery());
	}

	@Override
	public Entity SelectFirstOrDefault() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
