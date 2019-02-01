package entities;

public class CheckoutRecord {
	private String memberId;
	private String bookCopyId;
	private String checkOutdate;
	private String checkInDate;
	private String finePaid;
	private String finePaidDate;
	private String dueDate;

	public CheckoutRecord() {

	}

	public CheckoutRecord(String memberId, String bookCopyId, String checkOutdate, String checkInDate, String finePaid,
			String finePaidDate, String dueDate) {
		this.memberId = memberId;
		this.bookCopyId = bookCopyId;
		this.checkOutdate = checkOutdate;
		this.checkInDate = checkInDate;
		this.finePaid = finePaid;
		this.finePaidDate = finePaidDate;
		this.dueDate = dueDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBookCopyId() {
		return bookCopyId;
	}

	public void setBookCopyId(String bookCopyId) {
		this.bookCopyId = bookCopyId;
	}

	public String getCheckOutdate() {
		return checkOutdate;
	}

	public void setCheckOutdate(String checkOutdate) {
		this.checkOutdate = checkOutdate;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getFinePaid() {
		return finePaid;
	}

	public void setFinePaid(String finePaid) {
		this.finePaid = finePaid;
	}

	public String getFinePaidDate() {
		return finePaidDate;
	}

	public void setFinePaidDate(String finePaidDate) {
		this.finePaidDate = finePaidDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
}
