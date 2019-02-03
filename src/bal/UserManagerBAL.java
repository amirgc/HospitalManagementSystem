package bal;

import java.util.List;

import ORM.EntityFactory;
import dao.UserDAO;
import entities.User;

public class UserManagerBAL {

	@SuppressWarnings("unchecked")
	public List<User> getListOfUser() {
		UserDAO dao = new UserDAO(new User("", "", "", ""));
		return (List<User>) dao.Select();
	}

	public boolean AddUser(String userId, String userName, String passWord, String authLevel) {
		UserDAO dao = new UserDAO(EntityFactory.createUser(userId, userName, passWord, authLevel));
		return dao.Update();
	}
}
