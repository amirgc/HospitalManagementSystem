package hospitalbilling;

import Billing.Visitor;

public class HospitalBillPriceVistor implements Visitor {
	private double totalPrice = 0.0;



	@Override
	public void visit(Tax tax) {
		totalPrice += tax.getPrice();
		
	}

	@Override
	public void visit(Miscellaneous misc) {
		totalPrice += misc.getPrice();
		
	}
	
	@Override
	public void visit(Service service) {
		totalPrice = service.getTotalPrice();
	}
	
	public double getTotalPrice()
	{
		return totalPrice;
	}

	

}
