package helper;

import controller.BookController;

public class BookControllerRuleSet implements RuleSet {
	private BookController bookController;

	@Override
	public void applyRules(Object ob) throws RuleException {
		this.bookController = (BookController) ob;
		nonemptyRule();

	}

	private void nonemptyRule() throws RuleException {

		if (this.bookController.isbnNumber.getText().trim().isEmpty()
				|| this.bookController.txtNumberOfCopy.getText().trim().isEmpty()
				|| this.bookController.authorName.getText().trim().isEmpty()
				|| this.bookController.bookTitle.getText().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
		if (this.bookController.cmbBoxMaxCheckOutLength.getValue().toString().trim().isEmpty()) {
			throw new RuleException("Select checkput duration!!!");
		}

		if (!(this.bookController.isbnNumber.getText().trim().length() == 10
				|| this.bookController.isbnNumber.getText().trim().length() == 13)) {
			throw new RuleException("ISBN length mjst be 10 or 13");
		}
	}
}
