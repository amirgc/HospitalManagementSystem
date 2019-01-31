package helper;

import Rules.RuleException;
import Rules.RuleSet;
import controller.BookCopyController;

public class BookCopyControllerRuleSet implements RuleSet {
	private BookCopyController bookCopyController;

	@Override
	public void applyRules(Object ob) throws RuleException {
		this.bookCopyController = (BookCopyController) ob;
		nonemptyRule();
	}

	private void nonemptyRule() throws RuleException {

		if (this.bookCopyController.copyNumber.getText().trim().isEmpty()) {
			throw new RuleException("Provide CopyNumber!");
		}
		if (this.bookCopyController.cmbBoxISBN.getValue().toString().trim().isEmpty()) {
			throw new RuleException("Select ISBN Number from the dropdown!!!");
		}
	}
}
