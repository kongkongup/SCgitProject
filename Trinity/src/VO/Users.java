package VO;



public class Users {
	
	private String user_ID;
	private String Password;
	private String name;
	private String jumin;
	private String period;
	private String classRoom;
	private int age;
	private String birth;
	
	public Users(String user_ID, String password, String name, String jumin, String period, String classRoom) {
		super();
		this.user_ID = user_ID;
		this.Password = password;
		this.name = name;
		this.jumin = jumin;
		this.period = period;
		this.classRoom = classRoom;
	}

	public String getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	@Override
	public String toString() {
		return "Users [user_ID=" + user_ID + ", Password=" + Password + ", name=" + name + ", jumin=" + jumin
				+ ", period=" + period + ", classRoom=" + classRoom + ", age=" + age + ", birth=" + birth + "]";
	}
	
	
	
	
	
}
