package hospitalbilling;

import Billing.BillingItem;
import Billing.Visitor;

public class Doctor implements BillingItem {

	public double getPrice() {
		return 0;
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}

	
}
