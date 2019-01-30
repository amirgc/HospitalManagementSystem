package entities;

public class Member extends Person {
	private String memberID;

	public Member(String fName, String lName, String phone, String memberID, Address add) {
		super(fName, lName, phone, add);
		this.memberID = memberID;
	}

	public Member() {
		super("", "", "",new Address());
		// TODO Auto-generated constructor stub
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}


}
