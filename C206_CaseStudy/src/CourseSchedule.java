import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * ArrayList<CourseSchedule> scheduleList = new ArrayList<CourseSchedule>();
	 * 
	 * int option4 = 0; while (option4 != 4) { //insert menu courseScheduleMenu();
	 * option4 = Helper.readInt("Enter an option > "); if (option4 == 1) {
	 * viewCourseSchedule(scheduleList); } else if (option4 == 2) {
	 * addCourseSchedule(scheduleList); } else if (option4 == 3) {
	 * deleteCourseSchedule(scheduleList); } else if (option4 == 4) {
	 * System.out.println("Bye!"); } else { System.out.println("Invalid option"); }
	 * }
	 * 
	 * }
	 * 
	 * private static void courseScheduleMenu() { setHeader("COURSE SCHEDULE APP");
	 * System.out.println("1. View Course Schedules");
	 * System.out.println("2. Add Course Schedule");
	 * System.out.println("3. Delete Course Schedule");
	 * System.out.println("4. Quit"); Helper.line(80, "-"); }
	 * 
	 * public static void setHeader(String header) { Helper.line(80, "-");
	 * System.out.println(header); Helper.line(80, "-"); }
	 * 
	 * // Add course schedule public static void
	 * addCourseSchedule(ArrayList<CourseSchedule> scheduleList) { String scheduleid
	 * = Helper.readString("Course schedule ID > "); double price =
	 * Helper.readDouble("Price > "); String start =
	 * Helper.readString("Start date/time (yyyy-MM-dd HH:mm) > "); String end =
	 * Helper.readString("End date/time (yyyy-MM-dd HH:mm) > "); String location =
	 * Helper.readString("Course location > ");
	 * 
	 * DateTimeFormatter formatter =
	 * DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); LocalDateTime startDT =
	 * LocalDateTime.parse(start, formatter); LocalDateTime endDT =
	 * LocalDateTime.parse(end, formatter);
	 * 
	 * CourseSchedule cc = new CourseSchedule(scheduleid, price, startDT, endDT,
	 * location); scheduleList.add(cc); System.out.println("Schedule added"); }
	 * 
	 * // View course schedule public static void
	 * viewCourseSchedule(ArrayList<CourseSchedule> scheduleList) { String output =
	 * String.format("%-20s %-10s %-20s %-20s %-15s\n", "COURSE SCHEDULE ID",
	 * "PRICE", "START DATE TIME", "END DATE TIME", "LOCATION");
	 * 
	 * for (int i = 0; i < scheduleList.size(); i++) { DateTimeFormatter formatter =
	 * DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); String start =
	 * scheduleList.get(i).getStartDateTime().format(formatter); String end =
	 * scheduleList.get(i).getEndDateTime().format(formatter);
	 * 
	 * output += String.format("%-20s $%-10.2f %-29s %-20s %-15s\n",
	 * scheduleList.get(i).getScheduleID(), scheduleList.get(i).getPrice(), start,
	 * end, scheduleList.get(i).getLocation()); } System.out.println(output); }
	 * 
	 * // Delete course schedule public static void
	 * deleteCourseSchedule(ArrayList<CourseSchedule> scheduleList) {
	 */
	/*
	 * String scheduleid = Helper.readString("Course schedule ID > "); char yOrN =
	 * Helper.readChar("Are you sure you want to delete? (Y/N) > ");
	 * 
	 * if (yOrN == 'Y' && yOrN == 'y') { for (int i = 0; i < scheduleList.size();
	 * i++) { if (scheduleid.equals(scheduleList.get(i).getScheduleID())) {
	 * scheduleList.remove(i); } } } }
	 */
}
