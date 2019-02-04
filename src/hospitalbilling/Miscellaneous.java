package hospitalbilling;

import Billing.BillingItem;
import Billing.Visitor;

public class Miscellaneous implements BillingItem {

	public double getPrice() {
		return 17.6;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}



}
