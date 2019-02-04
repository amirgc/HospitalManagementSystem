package hospitalbilling;

import entities.Charge;

public class StaffServiceCharge implements IServiceCharge {

	private Charge charge;
	
	public StaffServiceCharge(Charge charge) {
		this.charge = charge;
		
	}
	
	@Override
	public double getServiceCharge() {
		return charge.getPrice();
	}

}
