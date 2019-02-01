package entities;

public class Author extends Person {
	private String credentials;
	private String biography;

	public Author(String fName, String lName, String phone, String credentials, String biography) {
		super(fName, lName, phone, new Address());
		this.credentials = credentials;
		this.biography = biography;

	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

}
