package hospitalbilling;

import Billing.BillingItem;
import Billing.Visitor;

public class Tax implements BillingItem {

	public double getPrice() {
		return 0;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
