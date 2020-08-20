import java.time.LocalDateTime;

public class CourseSchedule {
	
	String scheduleID;
	double price;
	LocalDateTime startDateTime;
	LocalDateTime endDateTime; 
	String location;
	
	public CourseSchedule(String scheduleID, double price, LocalDateTime startDateTime, LocalDateTime endDateTime, String location) {
		this.scheduleID = scheduleID;
		this.price = price;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.location = location;
	}
	
	public String getScheduleID() {
		return scheduleID;
	}

	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
