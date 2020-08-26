
import java.time.LocalDateTime;


/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * roccoyu, 20 Aug 2020 10:43:09 am
 */

/**
 * @author roccoyu
 *
 */
public class registerSchedule {
	String registrationNumber;
	String scheduleId; 
	String memberEmail;
	String status;
	LocalDateTime registerDatetime;
	
	public registerSchedule(String registrationNumber,
	String scheduleId,
	String memberEmail,
	String status,
													LocalDateTime registerDatetime) {
		this.registrationNumber = registrationNumber;
		this.scheduleId = scheduleId;
		this.memberEmail = memberEmail;
		this.status = status;
		this.registerDatetime = registerDatetime;
	}

	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param registrationNumber the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return the scheduleId
	 */
	public String getScheduleId() {
		return scheduleId;
	}

	/**
	 * @param scheduleId the scheduleId to set
	 */
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	/**
	 * @return the memberEmail
	 */
	public String getMemberEmail() {
		return memberEmail;
	}

	/**
	 * @param memberEmail the memberEmail to set
	 */
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getRegisterDatetime() {
		return registerDatetime;
	}

	public void setRegisterDatetime(LocalDateTime registerDatetime) {
		this.registerDatetime = registerDatetime;
	}

	@Override
	public String toString() {
		return "registerSchedule{" +
			"registrationNumber='" + registrationNumber + '\'' +
			", scheduleId='" + scheduleId + '\'' +
			", memberEmail='" + memberEmail + '\'' +
			", status='" + status + '\'' +
			", registerDatetime=" + registerDatetime +
			'}';
	}
}
