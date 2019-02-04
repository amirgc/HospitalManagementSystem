package hospitalbilling;

import Billing.BillingItem;
import Billing.Visitor;
import entities.Charge;

public class Service implements BillingItem {
	
	private IServiceCharge type;
	private Charge charge;
	
	
	private Service(Charge charge) {
		this.charge = charge;
	}
	
	Service(IServiceCharge patientType) {
		this.type = patientType;
	}

	public double getTotalPrice() {
		
		return this.type.getServiceCharge(charge);
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
