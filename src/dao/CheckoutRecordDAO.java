package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dal.Dao;
import dal.DataAccess;
import dal.DataAccessFactory;
import entities.CheckoutRecord;

public class CheckoutRecordDAO implements Dao {

	private String sql;
	private List<CheckoutRecord> records;
	public CheckoutRecord record;
	DataAccess da = DataAccessFactory.getDataAccess();

	@Override
	public String getSelectSql() {
		return sql;
	}

	@Override
	public String getInsertSql() {
		this.sql = "Insert into CheckoutRecord (memberId, bookCopyId, checkOutdate,checkInDate,finePaid,finePaidDate, dueDate )"
				+ "values('" + record.getMemberId() + "','" + record.getBookCopyId() + "','" + record.getCheckOutdate()
				+ "','" + record.getCheckInDate() + "','" + record.getFinePaid() + "','" + record.getFinePaidDate()
				+ "','" + record.getDueDate() + "')";
		//System.out.println(sql);
		return sql;
	}

	@Override
	public String getUpdateSql() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unpackResultSet(ResultSet rs) throws SQLException {
		records = new ArrayList<CheckoutRecord>();
		while (rs.next()) {
			records.add(new CheckoutRecord(rs.getString("memberId"), rs.getString("bookCopyId"),
					rs.getString("checkOutdate"), rs.getString("checkInDate"), rs.getString("finePaid"),
					rs.getString("finePaidDate"), rs.getString("dueDate")));
		}

	}

	@Override
	public boolean InsertUpdate(Object o) {
		this.record = (CheckoutRecord) o;
		try {
			da.write(this);
		} catch (SQLException e) {

		}
		return false;
	}

	@Override
	public List<CheckoutRecord> Select() {
		try {
			this.sql = "Select * from CheckoutRecord";
			da.read(this);
		} catch (SQLException e) {

		}
		return records;
	}

	@Override
	public Object SelectFirstOrDefault() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CheckoutRecord> SelectByUserId(String memberId) {
		try {
			this.sql = "Select * from CheckoutRecord where memberId='"+memberId+"'";
			//System.out.println("SelectByUserId CheckoutRecordDAO "+this.sql);
			da.read(this);
		} catch (SQLException e) {

		}
		return records;
	}

}
