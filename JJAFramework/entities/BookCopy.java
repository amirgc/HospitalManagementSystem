package entities;

public class BookCopy {
	
	private String copyNumber;
	private String ISBN;
	private String status;
	public BookCopy(String copyNumber,String isbn,String status)
	{
		this.copyNumber=copyNumber;
		this.ISBN=isbn;
		this.status=status;		
	}
	public BookCopy() {
		// TODO Auto-generated constructor stub
	}
	public String getCopyNumber() {
		return copyNumber;
	}
	
	public void setCopyNumber(String copyNumber) {
		this.copyNumber = copyNumber;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	
}
