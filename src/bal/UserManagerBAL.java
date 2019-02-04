package bal;

import java.util.List;

import ORM.EntityFactory;
import dao.UserDAO;
import entities.User;

public class UserManagerBAL implements BAL{
	String userId,  userName,  passWord,  authLevel;
	@SuppressWarnings("unchecked")
	public List<User> getData() {
		UserDAO dao = new UserDAO(new User("", "", "", ""));
		return (List<User>) dao.Select();
	}

	public boolean addData(String ...data) {
		userId = data[0];
		userName = data[1];
		passWord = data[2];
		authLevel = data[3];
		UserDAO dao = new UserDAO(EntityFactory.createUser(userId, userName, passWord, authLevel));
		return dao.Add();
	}
}
