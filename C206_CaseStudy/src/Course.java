import java.time.LocalDateTime;

public class Course {

	String id;
	String title;
	String category;
	String description;
	double duration;
	String preCourse;
	double price;
	LocalDateTime startDateTime;
	LocalDateTime endDateTime; 
	String location;
	
	public Course(String id, String title, String category, String description, double duration, String preCourse,
			double price, LocalDateTime startDateTime, LocalDateTime endDateTime, String location) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.description = description;
		this.duration = duration;
		this.preCourse = preCourse;
		this.price = price;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.location = location;
	}
	
	public Course(String id, String title, String category, String description, double duration, String preCourse) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.description = description;
		this.duration = duration;
		this.preCourse = preCourse;
	}
	
	public Course(String category,String description) {
        this.category=category;
        this.description=description;
    }
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getPreCourse() {
		return preCourse;
	}

	public void setPreCourse(String preCourse) {
		this.preCourse = preCourse;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%-10s %-20s %-20s %-20s %-10.2f %-20s", 
				getId(), getTitle(), getCategory(), getDescription(), getDuration(),
				getPreCourse() );
	}

	
	
	
	
	
}