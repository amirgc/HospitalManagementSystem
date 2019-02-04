package entities;

public class Charge implements Entity {

	
	private String patientId;
	
	private String serviceType;
	
	private double price;
	
	public Charge(String patientId, String serviceType, double price) {
		this.patientId = patientId;
		this.serviceType = serviceType;
		this.price = price;
		
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
