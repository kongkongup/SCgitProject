package VO;

import java.io.Serializable;

public class Users implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5919292518797642821L;
	private String user_ID;
	private String Password;
	private String name;
	private String gender;
	private String jumin;
	private String e_Mail;
	private String period;
	private String classRoom;
	private int age;
	private String birth;
	
	

	public Users(String user_ID, String password, String name, String gender, String jumin, String e_Mail,
			String period, String classRoom) {
		super();
		this.user_ID = user_ID;
		Password = password;
		this.name = name;
		this.gender = gender;
		this.jumin = jumin;
		this.e_Mail = e_Mail;
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

	public String getE_Mail() {
		return e_Mail;
	}

	public void setE_Mail(String e_Mail) {
		this.e_Mail = e_Mail;
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
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Users [user_ID=" + user_ID + ", Password=" + Password + ", name=" + name + ", gender=" + gender
				+ ", jumin=" + jumin + ", e_Mail=" + e_Mail + ", period=" + period + ", classRoom=" + classRoom
				+ ", age=" + age + ", birth=" + birth + "]";
	}

	
	
	
}
