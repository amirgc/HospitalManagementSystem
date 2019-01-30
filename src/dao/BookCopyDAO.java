package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.BookCopy;
import dal.Dao;
import dal.DataAccess;
import dal.DataAccessFactory;

public class BookCopyDAO implements Dao {
	DataAccess da = DataAccessFactory.getDataAccess();
	public BookCopy bkCpy;
	List<BookCopy> bookCopies;
	private String sql;

	public BookCopyDAO() {
		this.bkCpy = new BookCopy();
	}

	@Override
	public String getSelectSql() {
		return sql;
	}

	@Override
	public String getInsertSql() {
		return sql;
	}

	@Override
	public String getUpdateSql() {
		return null;
	}

	@Override
	public void unpackResultSet(ResultSet rs) throws SQLException {

		bookCopies = new ArrayList<BookCopy>();
		while (rs.next()) {
			bookCopies.add(new BookCopy(rs.getString("copyNumber"), rs.getString("bookISBN"), rs.getString("status")));
		}
	}

	@Override
	public List<BookCopy> Select() {
		try {
			this.sql = "Select * from BookCopy";
			da.read(this);
		} catch (SQLException e) {
		}
		return bookCopies;
	}

	@Override
	public boolean InsertUpdate(Object copy) {
		this.bkCpy = (BookCopy) copy;

		this.sql = "Insert into Bookcopy (CopyNumber, BookISBN, Status) values('" + bkCpy.getCopyNumber() + "','"
				+ bkCpy.getISBN() + "','" + bkCpy.getStatus() + "')";

		try {
			da.write(this);
		} catch (SQLException e) {

		}
		return false;
	}

	public boolean Update(Object copy) {
		this.bkCpy = (BookCopy) copy;
		this.sql = "Update  Bookcopy set status='" + bkCpy.getStatus() + "' Where CopyNumber='" + bkCpy.getCopyNumber()
				+ "'";
		try {
			da.write(this);
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public List<BookCopy> SelectFirstOrDefault() {
		this.sql = "Select * from BookCopy where BookISBN='" + bkCpy.getISBN() + "'";
		// System.out.println("bc dao" + this.sql);
		try {
			da.read(this);
		} catch (SQLException e) {

		}
		return bookCopies;
	}

	public List<BookCopy> SelectWhere() {
		this.sql = "Select * from BookCopy where status='Available'";
		try {
			da.read(this);
		} catch (SQLException e) {

		}
		return bookCopies;
	}

}
