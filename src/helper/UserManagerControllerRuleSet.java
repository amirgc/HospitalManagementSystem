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

		if (this.userController.txtName.getText().trim().isEmpty()
				|| this.userController.txtAge.getText().trim().isEmpty()
				|| this.userController.txtAddress.getText().trim().isEmpty()
				|| this.userController.txtPhone.getText().trim().isEmpty()
				||this.userController.txtWeight.getText().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}	
	
	}
}
