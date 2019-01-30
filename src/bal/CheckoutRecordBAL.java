package bal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.CheckoutRecordDAO;
import entities.CheckoutRecord;

public class CheckoutRecordBAL {
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

	public boolean CheckIfAvailable(String memberId, String iSBN) {
		MemberBAL mBal = new MemberBAL();
		BookBAL bBal = new BookBAL();
		if (mBal.memberExist(memberId) && bBal.bookExist(iSBN))
			return true;

		return false;
	}

	public List<CheckoutRecord> getCheckoutRecors() {
		CheckoutRecordDAO chkDao = new CheckoutRecordDAO();
		return chkDao.Select();
	}

	public boolean addCheckOutRecord(String bookCopyNumber, String memberId, String BookISBN) {

		BookBAL bBal = new BookBAL();
		String bookReturnDays = bBal.getBookReturnTimeByBookISBN(BookISBN);
		Date currentDate = new Date();
		CheckoutRecordDAO chkDao = new CheckoutRecordDAO();
		CheckoutRecord rec = new CheckoutRecord(memberId, bookCopyNumber, dateFormat.format(currentDate), "", "", "",
				calculateDueDate(bookReturnDays));
		chkDao.InsertUpdate(rec);
		updateBookCopyStatus(bookCopyNumber);
		return true;

	}

	private void updateBookCopyStatus(String bookCopyNumber) {
		BookCopyBAL copy = new BookCopyBAL();
		copy.updateBookCopyStatus(bookCopyNumber);
	}

	private String calculateDueDate(String bookReturnDays) {
		int days = Integer.parseInt(bookReturnDays);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, days);
		Date currentDatePlusOne = c.getTime();
		return dateFormat.format(currentDatePlusOne);
	}

	public void viewCheckOutRecord(String memberId) {
		CheckoutRecordDAO chkDao = new CheckoutRecordDAO();
		List<CheckoutRecord> records = chkDao.SelectByUserId(memberId);
		System.out.println("Member Id	BookCopyNumber	Checkout Date");
		for (CheckoutRecord record : records) {
			System.out.printf("%s \t\t %s\t\t %s\t\t \n", record.getMemberId(), record.getBookCopyId(),
					record.getCheckOutdate());
		}
	}

}
// String memberId, String bookCopyId, String checkOutdate, String checkInDate,
// String finePaid,
// String finePaidDate, String dueDate