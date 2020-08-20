
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class C206_CaseStudy {
	
	private static final int OPTION_QUIT = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Course> courses = new ArrayList<>();
		
		int option = 0;

		while (option != OPTION_QUIT) {

			//menu
			menu();
			option =  Helper.readInt("Enter an option > ");

			if (option == 1) {
				//view courses
				viewCourses(courses);
				
			} else if (option == 2) {
				// add course
				addCourse(courses);

			} else if (option == 3) {
				// delete course

			} else if (option == 4) {
				//

			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
				
			} else {
				System.out.println("Invalid option");
			}

		}

	} //main
	
	
	private static void menu() {
		setHeader("COURSE APP");
		System.out.println("1. View Courses");
		System.out.println("2. Add Course");
		System.out.println("3. Delete Course");
		//System.out.println("4. ");
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	//Member 1
	 
	//Member 2
	
	//Member 3 - Daryl
	private static String retrieveCourses(List<Course> courses) {
		String output =  String.format("%-10s %-20s %-20s %-20s %-10s %-20s\n", 
				"Id", "Title", "Category", "Decription", "Duration", "Pre-requisite Course");
		for (Course c : courses) {
			output += c.toString();
		}
		return output;
	}
	
	public static void viewCourses(List<Course> courses) {
		setHeader("Courses");
		System.out.println(retrieveCourses(courses));
	}
	
	public static void addCourse(List<Course> courses) {
		setHeader("Add Course");
		System.out.println("Enter Course Information\n");
		//course information
		String id = Helper.readString("ID : ");
		String title = Helper.readString("Title : ");
		String category = Helper.readString("Category Name : ");
		String desc = Helper.readString("Description : ");
		double duration = Helper.readDouble("Duration : ");
		String preCourse = Helper.readString("Pre-requisite Course : ");
		//add course
		Course newCourse = new Course(id, title, category, desc, duration, preCourse);
		courses.add(newCourse);
	}
	
	
	//Member 4 - Sabrina
	//Add course schedule with the following information
	//course schedule id, price, start date/time, end date/time, location
	String scheduleid = Helper.readString("Course schedule ID > ");
	double price = Helper.readDouble("Price > ");
	String start = Helper.readString("Start date/time (DD/MM/YYYY)");
	String end = Helper.readString("End date/time (DD/MM/YYYY)");
	String location = Helper.readString("Course location > ");
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy, hh:mm a");
	
	//View course schedule
	
	
	
	
	//Delete course schedule
	
	//- Member 5
	
	

}
