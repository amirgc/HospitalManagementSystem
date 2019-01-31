package helper;

import java.awt.Component;

import Rules.RuleException;
import Rules.RuleSet;
import controller.AddNewMemberController;

public class AddNewMemberControllerRuleSet implements RuleSet {
	private AddNewMemberController addMbr;

	@Override
	public void applyRules(Object ob) throws RuleException {
		this.addMbr = (AddNewMemberController) ob;
		nonemptyRule();
		this.addMbr.txtCity.getText();
	}

	private void nonemptyRule() throws RuleException {
		
		if (this.addMbr.txtFirstName.getText().trim().isEmpty() || this.addMbr.txtLastName.getText().trim().isEmpty()
				|| this.addMbr.txtStreet.getText().trim().isEmpty() || this.addMbr.txtCity.getText().trim().isEmpty()
				|| this.addMbr.txtState.getText().trim().isEmpty() || this.addMbr.txtZip.getText().trim().isEmpty()
				|| this.addMbr.txtPhone.getText().trim().isEmpty()) {
						throw new RuleException("All fields must be non-empty!");
		}
	}

}
