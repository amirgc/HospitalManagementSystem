package bal;

import java.util.List;

import dao.UserDAO;
import entities.User;

public class LoginBAL {

	public User IsAuthentiCated(String userId, String password) {
		{
			UserDAO usrDao = new UserDAO(new User(userId, "", password, ""));
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

	public void AddUser() {
//		UserDAO usrDao = new UserDAO("");
//		usrDao.Add(usrDao);
	}
}
