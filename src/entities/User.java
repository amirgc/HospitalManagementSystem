package entities;

public class User {
	private String userId;
	private String userName;
	private String passWord;
	private String roles;

	public User (String userId,String userName,String passWord,String roles)
	{
		this.userId=userId;
		this.userName=userName;
		this.passWord=passWord;
		this.roles=roles;
				
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
