package entities;

public class Patient implements Entity {

	private String p_name;
	private String p_age;
	private String p_weight;
	private int p_gender;
	private int p_bed;
	private int p_doctor;
	private String p_problem;
	private String p_treament;
	private String p_medicine;
	private String p_address;
	private String p_phone;
	
	
	public Patient(String patientName, 
			String patientAge, 
			String patientWeight,
			String patientGender, 
			String bedType, 
			String doctorType, 
			String patientProblem,
			String patientTreatment,
			String patientMedicine,
			String patientAddress,
			String patientPhone) {
		
		
		p_name = patientName;
		p_age = patientAge;
		p_weight = patientWeight;
		p_gender = Integer.valueOf(patientGender);
		p_bed = Integer.valueOf(bedType);
		p_doctor = Integer.valueOf(doctorType);
		p_problem = patientProblem;
		p_treament = patientTreatment;
		p_medicine = patientMedicine;
		p_address = patientAddress;
		p_phone = patientPhone;
		
	}


	public String getP_name() {
		return p_name;
	}


	public void setP_name(String p_name) {
		this.p_name = p_name;
	}


	public String getP_age() {
		return p_age;
	}


	public void setP_age(String p_age) {
		this.p_age = p_age;
	}


	public String getP_weight() {
		return p_weight;
	}


	public void setP_weight(String p_weight) {
		this.p_weight = p_weight;
	}


	public int getP_gender() {
		return p_gender;
	}


	public void setP_gender(String p_gender) {
		this.p_gender = Integer.valueOf(p_gender);
	}


	public int getP_bed() {
		return p_bed;
	}


	public void setP_bed(String p_bed) {
		this.p_bed = Integer.valueOf(p_bed);
	}


	public int getP_doctor() {
		return p_doctor;
	}


	public void setP_doctor(String p_doctor) {
		this.p_doctor = Integer.valueOf(p_doctor);
	}


	public String getP_problem() {
		return p_problem;
	}


	public void setP_problem(String p_problem) {
		this.p_problem = p_problem;
	}


	public String getP_treatment() {
		return p_treament;
	}


	public void setP_treatment(String p_treatment) {
		this.p_treament = p_treatment;
	}


	public String getP_medicine() {
		return p_medicine;
	}


	public void setP_medicine(String p_medicine) {
		this.p_medicine = p_medicine;
	}


	public String getP_address() {
		return p_address;
	}


	public void setP_address(String p_address) {
		this.p_address = p_address;
	}


	public String getP_phone() {
		return p_phone;
	}


	public void setP_phone(String p_phone) {
		this.p_phone = p_phone;
	}



}
