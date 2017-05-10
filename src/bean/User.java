package bean;

import java.sql.Date;


public class User {
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord="
				+ passWord + ", fullName=" + fullName + ", birthDay="
				+ birthDay + ", addDress=" + addDress + ", phoneNumber="
				+ phoneNumber + ", isMember=" + isMember + "]";
	}
	private int id;
	private String userName;
	private String passWord;
	private String fullName;
	private Date birthDay;
	private String addDress;
	private String phoneNumber;
	private boolean isMember;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getAddDress() {
		return addDress;
	}
	public void setAddDress(String addDress) {
		this.addDress = addDress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isMember() {
		return isMember;
	}
	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}
	public User(int id, String userName, String passWord, String fullName,
			Date birthDay, String addDress, String phoneNumber, boolean isMember) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.addDress = addDress;
		this.phoneNumber = phoneNumber;
		this.isMember = isMember;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String userName, String passWord, String fullName,
			Date birthDay, String addDress, String phoneNumber) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.addDress = addDress;
		this.phoneNumber = phoneNumber;
	}
	
	
}
