package VO;



public class Client {
	
	private int member_ID;
	private String member_Password;
	private int member_Age;
	private String birth;
	private String member_Gender;
	private String member_Phone;
	private String member_Address;
	private String member_Email;
	
	
	
	public Client(int member_ID, String member_Password, String birth, String member_Gender,
			String member_Phone, String member_Address, String member_Email) {
		super();
		this.member_ID = member_ID;
		this.member_Password = member_Password;
		this.birth = birth;
		this.member_Gender = member_Gender;
		this.member_Phone = member_Phone;
		this.member_Address = member_Address;
		this.member_Email = member_Email;

	}

	public Client() {
		super();
	}
	
	public int getMember_ID() {
		return member_ID;
	}
	public void setMember_ID(int member_ID) {
		this.member_ID = member_ID;
	}
	public int getMember_Age() {
		return member_Age;
	}
	public void setMember_Age(int member_Age) {
		this.member_Age = member_Age;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getMember_Gender() {
		return member_Gender;
	}
	public void setMember_Gender(String member_Gender) {
		this.member_Gender = member_Gender;
	}
	public String getMember_Phone() {
		return member_Phone;
	}
	public void setMember_Phone(String member_Phone) {
		this.member_Phone = member_Phone;
	}
	public String getMember_Address() {
		return member_Address;
	}
	public void setMember_Address(String member_Address) {
		this.member_Address = member_Address;
	}
	public String getMember_Email() {
		return member_Email;
	}
	public void setMember_Email(String member_Email) {
		this.member_Email = member_Email;
	}	
	public String getMember_Password() {
		return member_Password;
	}

	public void setMember_Password(String member_Password) {
		this.member_Password = member_Password;
	}

	@Override
	public String toString() {
		return "Client [member_ID=" + member_ID + ", member_Age=" + member_Age + ", birth=" + birth + ", member_Gender="
				+ member_Gender + ", member_Phone=" + member_Phone + ", member_Address=" + member_Address
				+ ", member_Email=" + member_Email + "]";
	}
	
}
