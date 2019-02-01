package helper;

import Rules.RuleException;
import Rules.RuleSet;
import controller.UserManagerController;

public class UserManagerControllerRuleSet implements RuleSet{
	private UserManagerController userController;

	@Override
	public void applyRules(Object ob) throws RuleException {
		this.userController = (UserManagerController) ob;
		nonemptyRule();

	}

	private void nonemptyRule() throws RuleException {

		if (this.userController.txtuserID.getText().trim().isEmpty()
				|| this.userController.txtUserName.getText().trim().isEmpty()
				|| this.userController.txtPassword.getText().trim().isEmpty()
				|| this.userController.txtAuthLevel.getText().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}	
	
	}
}
