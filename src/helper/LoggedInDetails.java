package helper;

public class LoggedInDetails {

	private static String AuthLevel;
	private static String UserName;

	public static String getAuthLevel() {
		return AuthLevel;
	}

	public static void setAuthLevel(String authLevel) {
		AuthLevel = authLevel;
	}

	public static String getUserName() {
		return UserName;
	}

	public static void setUserName(String userName) {
		UserName = userName;
	}
}
