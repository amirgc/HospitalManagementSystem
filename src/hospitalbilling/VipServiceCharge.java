package hospitalbilling;

import entities.Charge;

public class VipServiceCharge implements IServiceCharge {
	private Charge charge;
	
	public VipServiceCharge(Charge charge) {
		this.charge = charge;
	}
	
	@Override
	public double getServiceCharge() {
		return charge.getPrice();
	}



}
