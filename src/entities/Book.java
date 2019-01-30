package entities;

public class Book {
	private String title;
	private String ISBN;
	private String allowedDays;
	private String availability;
	private String authorName;
	private String numberOfCopy;

	public Book()
	{
		
	}
	public Book(String title, String ISBN, String allowedDays, String availability, String authorName,
			String numberOfCopy) {
		this.title = title;
		this.ISBN = ISBN;
		this.allowedDays = allowedDays;
		this.availability = availability;
		this.authorName = authorName;
		this.numberOfCopy = numberOfCopy;

	}

	public String getNumberOfCopy() {
		return numberOfCopy;
	}

	public void setNumberOfCopy(String numberOfCopy) {
		this.numberOfCopy = numberOfCopy;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getAllowedDays() {
		return allowedDays;
	}

	public void setAllowedDays(String allowedDays) {
		this.allowedDays = allowedDays;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
