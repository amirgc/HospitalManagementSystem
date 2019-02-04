package hospitalbilling;

import Billing.BillingItem;
import Billing.Visitor;

public class Tax implements BillingItem {
	
	private double price;
	
	public Tax(double price) {
		this.price = price;
	}

	public double getPrice() {
		return this.price * 1.07;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
