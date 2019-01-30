package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dal.Dao;
import dal.DataAccess;
import dal.DataAccessFactory;
import entities.Address;
import entities.Member;

public class MemberDAO implements Dao {

	public Member member;

	private List<Member> members;
	private String sql;
	DataAccess da = DataAccessFactory.getDataAccess();

	public MemberDAO() {
		member = new Member();
	}

	@Override
	public String getSelectSql() {
		return sql;
	}

	@Override
	public String getInsertSql() {
		String sql = "Insert into Members (FirstName,LastName,PhoneNumber) values('" + member.getFirstName() + "','"
				+ member.getLastName() + "','" + member.getPhone() + "')";
		return sql;
	}

	@Override
	public String getUpdateSql() {
		return null;
	}

	@Override
	public void unpackResultSet(ResultSet rs) throws SQLException {
		members = new ArrayList<Member>();
		while (rs.next()) {
			members.add(new Member(rs.getString("FirstName"), rs.getString("LastName"), rs.getString("PhoneNumber"),
					rs.getString("MemberId"), new Address("", "", "", "")));
		}

	}

	@Override
	public boolean InsertUpdate(Object o) {
		this.member = (Member) o;
		try {
			da.write(this);
			return true;
		} catch (SQLException e) {

		}
		return false;
	}

	@Override
	public List<Member> Select() {
		try {
			this.sql = "Select * from Members";
			da.read(this);
		} catch (SQLException e) {

		}
		return members;
	}

	@Override
	public List<Member> SelectFirstOrDefault() {
		try {
			this.sql = "Select * from Members where MemberId='" + member.getMemberID() + "'";
			da.read(this);
		} catch (SQLException e) {

		}
		return members;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

}
