package bal;

import java.util.List;

import dao.BookDAO;
import entities.Book;
import entities.Member;

public class BookBAL {

	public List<Book> getListOfBook() {
		BookDAO bkDao = new BookDAO();
		return bkDao.Select();
		// return null;
	}

	public void addBook(String isbn, String authorName, String title, String availableDays, String numberOfCopy) {
		BookDAO bkDao = new BookDAO();
		bkDao.InsertUpdate(new Book(title, isbn, availableDays, "Available", authorName, numberOfCopy));
	}

	public boolean bookExist(String iSBN) {
		BookDAO bDao = new BookDAO();
		bDao.book.setISBN(iSBN);
		List<Book> books = bDao.SelectFirstOrDefault();
		if (books.size() > 0)
			return true;
		return false;
	}

	public String getBookReturnTimeByBookISBN(String bookISBN) {
		BookDAO bDao = new BookDAO();
		bDao.book.setISBN(bookISBN);
		List<Book> books = bDao.SelectFirstOrDefault();
		String returnTime;
		if (books != null) {
			Book bk = new Book();
			bk = books.get(0);
			
			return bk.getAllowedDays();
		} else {
			return "0";
		}
		
	}
}
