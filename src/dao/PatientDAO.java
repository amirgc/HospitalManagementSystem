package dao;

import java.util.List;

import ORM.DbContext;
import SqlQueryBuilder.DynamicQueryBuilder;
import SqlQueryBuilder.QueryDirector;
import entities.Entity;
import entities.Patient;
import entities.User;

public class PatientDAO extends DbContext{

	private Patient patient;
	
	public PatientDAO(Patient patient) {
		super(patient);
		this.patient = patient;
		QueryDirector qd = new QueryDirector(new DynamicQueryBuilder(patient));
		qd.constructQuery();
		super.setQuery(qd.getQuery());
	}
	
	public Patient SelectFirstOrDefault() {
		String sql = "Select * from patient where p_name ='" + patient.getP_name()+ "' and p_age='" + patient.getP_bed()
				+ "'";
		super.setSql(sql);
		List<Patient> patient = (List<Patient>) super.CustomReadAction();
		return patient.get(0);
	}

	public void setUser(Patient patient) {
		this.patient = patient;
	}

}
