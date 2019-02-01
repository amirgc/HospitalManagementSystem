package bal;

import java.util.List;

import dao.UserDAO;
import entities.User;

public class UserManagerBAL {

	public List<User> getListOfUser() {
		UserDAO dao = new UserDAO(new User("", "", "", ""));
		return (List<User>) dao.Select();
	}

	public boolean AddUser(String userId,String userName,String passWord,String authLevel)
	{
		UserDAO dao = new UserDAO(new User(userId,userName,passWord,authLevel));
		return dao.Add();
	}
}
