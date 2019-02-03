package entities;

public class User implements Entity{
	private String userId;
	private String userName;
	private String passWord;
	private String authLevel;

	public User (String userId,String userName,String passWord,String authLevel)
	{
		this.userId=userId;
		this.userName=userName;
		this.passWord=passWord;
		this.setAuthLevel(authLevel);				
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAuthLevel() {
		return authLevel;
	}
	public void setAuthLevel(String authLevel) {
		this.authLevel = authLevel;
	}
}
