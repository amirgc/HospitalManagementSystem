package bal;

import java.util.List;

import dao.BookCopyDAO;
import entities.BookCopy;

public class BookCopyBAL {

	public List<BookCopy> getListOfCopy() {
		BookCopyDAO cDal = new BookCopyDAO();
		return cDal.Select();
	}

	public void addBookCopy(String copyNumber, String bookISBN) {
		BookCopyDAO cDal = new BookCopyDAO();
		cDal.InsertUpdate(new BookCopy(copyNumber, bookISBN, "Available"));

	}

	public List<BookCopy> getListOfCopyNumnerByISBN(String isbn) {
		BookCopyDAO cDao = new BookCopyDAO();
		cDao.bkCpy.setISBN(isbn);
		return cDao.SelectFirstOrDefault();
	}
	public List<BookCopy> getListOfAvailableBook(String isbn) {
		BookCopyDAO cDao = new BookCopyDAO();
		cDao.bkCpy.setISBN(isbn);
		return cDao.SelectWhere();
	}
	
	public void updateBookCopyStatus(String bookCopyNumber) {
		BookCopyDAO cDao = new BookCopyDAO();
		cDao.bkCpy.setCopyNumber(bookCopyNumber);
		cDao.Update(new BookCopy(bookCopyNumber, "", "Unavailable"));
	}
}
