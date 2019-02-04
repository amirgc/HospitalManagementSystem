package hospitalbilling;

import Billing.BillingItem;
import Billing.Visitor;
import entities.Charge;

public class Service implements BillingItem {
	
	private IServiceCharge type;
	private Charge charge;
	private double price;
	
	
	public Service(double price) {
		this.price = price;
	}
	
	private Service(IServiceCharge patientType) {
		this.type = patientType;
	}

	public double getTotalPrice() {
		return this.price;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
