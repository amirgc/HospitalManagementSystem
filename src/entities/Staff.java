package entities;

public class Staff implements Entity {

	String s_name;
	String s_dob;
	int s_gender;
	String s_address;
	String s_phone;
	int s_designation;
	
	public Staff(String s_name, String s_dob, int s_gender, String s_address, String s_phone, int s_designation) {
		
		this.s_name = s_name;
		this.s_dob = s_dob;
		this.s_gender = s_gender;
		this.s_address = s_address;
		this.s_phone = s_phone;
		this.s_designation = s_designation;
		
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_dob() {
		return s_dob;
	}

	public void setS_dob(String s_dob) {
		this.s_dob = s_dob;
	}

	public int getS_gender() {
		return s_gender;
	}

	public void setS_gender(int s_gender) {
		this.s_gender = s_gender;
	}

	public String getS_address() {
		return s_address;
	}

	public void setS_address(String s_address) {
		this.s_address = s_address;
	}

	public String getS_phone() {
		return s_phone;
	}

	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}

	public int getS_designation() {
		return s_designation;
	}

	public void setS_designation(int s_designation) {
		this.s_designation = s_designation;
	}
	
	
	
}
