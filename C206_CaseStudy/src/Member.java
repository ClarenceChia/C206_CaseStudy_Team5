
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * Admin, 20 Aug 2020 12:38:06 pm
 */

public class Member {
	String name;
	char gender;
	int mobile;
	String email;
	String dob;
	String country;
	
	public Member(String name, char gender, int mobile, String email, String dob, String country) {
		this.name = name;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.dob = dob;
		this.country = country;
	}
	public Member(int mobile, String country) {
		this.mobile = mobile;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public char getGender() {
		return gender;
	}

	public int getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public String getDob() {
		return dob;
	}

	public String getCountry() {
		return country;
	}
	
	public String toString() {
		return String.format("%-30s %-10s %-10d %-30s %-10s %-20s\n", getName(), getGender(), getMobile(), getEmail(), getDob(), getCountry());
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
