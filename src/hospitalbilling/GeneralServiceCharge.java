package hospitalbilling;

import entities.Charge;

public class GeneralServiceCharge implements IServiceCharge {
	private Charge charge;
	public GeneralServiceCharge (Charge charge)
	{
	this.charge = charge;
	
	}
	@Override
	public double getServiceCharge() {
		// TODO Auto-generated method stub
		return charge.getPrice();
	}

}
