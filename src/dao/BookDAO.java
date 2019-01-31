package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dal.Dao1;
import dal.DataAccess1;
import dal.DataAccessFactory1;
import entities.Book;

public class BookDAO implements Dao1 {
	DataAccess1 da = DataAccessFactory1.getDataAccess();
	public Book book;
	private ArrayList<Book> books;
	private String sql;

	public BookDAO() {
		book = new Book();
	}

	@Override
	public String getSelectSql() {
		return sql;
	}

	@Override
	public String getInsertSql() {
		String sql = "Insert into Books (isbn,AuthorName,title,AllowedDays,Availabilty, NumberOfCopy) values('"
				+ book.getISBN() + "','" + book.getAuthorName() + "','" + book.getTitle() + "','"
				+ book.getAllowedDays() + "','" + book.getAvailability() + "','" + book.getNumberOfCopy() + "')";
		// System.out.println(sql);
		return sql;
	}

	@Override
	public String getUpdateSql() {
		return null;
	}

	@Override
	public void unpackResultSet(ResultSet rs) throws SQLException {
		books = new ArrayList<Book>();
		while (rs.next()) {
			books.add(new Book(rs.getString("title"), rs.getString("ISBN"), rs.getString("allowedDays"),
					rs.getString("availabilty"), rs.getString("authorName"), rs.getString("numberOfCopy")));
		}
	}

	@Override
	public boolean InsertUpdate(Object o) {
		this.book = (Book) o;
		try {
			da.write(this);
			return true;
		} catch (SQLException e) {

		}
		return false;
	}

	@Override
	public List<Book> Select() {
		try {
			this.sql = "Select * from Books";
			da.read(this);
		} catch (SQLException e) {

		}
		return books;
	}

	@Override
	public List<Book> SelectFirstOrDefault() {
		try {
			this.sql = "Select * from Books where ISBN='" + book.getISBN() + "'";
			da.read(this);
		} catch (SQLException e) {

		}
		return books;
	}
}
