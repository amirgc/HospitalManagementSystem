package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dal.Dao1;
import entities.Address;
import dal.DataAccess1;
import dal.DataAccessFactory1;

public class AddressDAO implements Dao1 {
	DataAccess1 da = DataAccessFactory1.getDataAccess();
	private String street;
	private String city;
	private String state;
	private String zip;
	private ArrayList<Address> allAddress;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String getSelectSql() {
		return "SELECT * from MemberAddress";
	}

	@Override
	public String getInsertSql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateSql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unpackResultSet(ResultSet rs) throws SQLException {
		allAddress = new ArrayList<Address>();
		while (rs.next()) {
			allAddress.add(new Address(rs.getString("street"), rs.getString("city"), rs.getString("state"),
					rs.getString("zip")));
		}
	}

	@Override
	public List<Address> Select() {
		try {
			da.read(this);
		} catch (SQLException e) {
			// handle
		}
		return this.allAddress;
	}


	@Override
	public boolean InsertUpdate(Object o) {
		try {
			da.write(this);
			// allAddresses = (List<Address>) getResults();
		} catch (SQLException e) {
			// handle
		}
		return false;
		
	}

	@Override
	public Object SelectFirstOrDefault() {
		// TODO Auto-generated method stub
		return null;
	}
}
