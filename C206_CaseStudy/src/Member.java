
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
		return String.format("%-30s %-10s %-10d %-30s %-10s %-20s", getName(), getGender(), getMobile(), getEmail(), getDob(), getCountry());
	}
}
