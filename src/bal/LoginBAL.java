package bal;
import ORM.EntityFactory;
import dao.UserDAO;
import entities.User;

public class LoginBAL {

	public User IsAuthentiCated(String userId, String password) {
		{
			UserDAO usrDao = new UserDAO(EntityFactory.createUser(userId, "Jack", password, ""));
			usrDao.Update();
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
		// AddUser(new User(userId, "Shyam", password, "DOCTOR"));
		UserDAO usrDao = new UserDAO(user);
		usrDao.Add();
	}
}
