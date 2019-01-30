package helper;

import controller.CheckOutController;

public class CheckOutControllerRuleSet implements RuleSet {
	private CheckOutController checkoutController;

	@Override
	public void applyRules(Object ob) throws RuleException {
		this.checkoutController = (CheckOutController) ob;

		nonemptyRule();

	}

	private void nonemptyRule() throws RuleException {

		if (this.checkoutController.txtMemberID.getText().trim().isEmpty()
				|| this.checkoutController.txtIsbnNumber.getText().trim().isEmpty()) {

			throw new RuleException("All fields must be non-empty!");
		}

		// if (!this.checkoutController.txtMemberID.getText().trim().isEmpty()
		// && !this.checkoutController.txtIsbnNumber.getText().trim().isEmpty() &&
		// this.checkoutController.ddBookCopyNumber.getValue().toString().isEmpty()) {
		//
		// throw new RuleException("Select Copy Number!");
		// }
	}
}
