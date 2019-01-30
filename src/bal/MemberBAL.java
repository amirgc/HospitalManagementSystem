package bal;

import java.util.List;

import dao.MemberDAO;
import entities.Address;
import entities.Member;

public class MemberBAL {

	public void addNewMember(String firstName, String lastName, String street, String city, String state, String zip,
			String phone) {
		MemberDAO mDal = new MemberDAO();
		mDal.InsertUpdate((new Member(firstName, lastName, phone, "0", new Address(street, city, state, zip))));

	}

	public List<Member> loadMembers() {
		MemberDAO mDao = new MemberDAO();
		return mDao.Select();
	}

	public Boolean memberExist(String memberID) {
		MemberDAO mDao = new MemberDAO();
		mDao.member.setMemberID(memberID);
		List<Member> members = mDao.SelectFirstOrDefault();
		if (members.size() > 0)
			return true;
		return false;
	}
}
