package bal;

import ORM.EntityFactory;
import dao.UserDAO;
import entities.User;

public class LoginBAL {

	public User IsAuthentiCated(String userId, String password) {
		{
			UserDAO usrDao = new UserDAO(EntityFactory.createUser(userId, "", password, ""));
			// usrDao.Update();
			// AddUser(new User("10001", "Shyam", "test1234", "DOCTOR"));
			// UpdateUser(new User("10001", "HareRam", "test1234", "DOCTOR"));
			 DeleteUser(new User("10001", "Shyam", "test1234", "DOCTOR"));
			User usr = (User) usrDao.SelectFirstOrDefault();
			if (usr.getUserId() != null) {
				if (usr.getUserId() != null) {
					return usr;
				} else
					return null;
			} else
				return null;
		}
	}

	public void AddUser(User user) {
		UserDAO usrDao = new UserDAO(new User("10001", "Shyam", "test1234", "DOCTOR"));
		usrDao.Add();
	}

	public void UpdateUser(User user) {
		UserDAO usrDao = new UserDAO(new User("10001", "HareRam", "test1234", "DOCTOR"));
		usrDao.Update();
	}

	public void DeleteUser(User user) {
		UserDAO usrDao = new UserDAO(new User("10001", "Shyam", "test1234", "DOCTOR"));
		usrDao.Remove();
	}
}
