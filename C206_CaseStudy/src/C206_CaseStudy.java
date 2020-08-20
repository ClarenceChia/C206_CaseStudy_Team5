<<<<<<< HEAD
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
=======
import java.util.ArrayList;
>>>>>>> branch 'master' of https://github.com/ClarenceChia/C206_CaseStudy_Team5.git

public class C206_CaseStudy {
	
	private static final int OPTION_QUIT = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int option = 0;

		while (option != OPTION_QUIT) {

			//menu
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				//
				
			} else if (option == 2) {
				// 

			} else if (option == 3) {
				//

			} else if (option == 4) {
				//

			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
				
			} else {
				System.out.println("Invalid option");
			}

		}

	} //main
	
	private static ArrayList<Course> courses = new ArrayList<>();
	
	//Member 1
	
	//Member 2
	
	//Member 3
	public static String retrieveCourses() {
		String output =  String.format("%-10s %-10s %-10s %-10s %-10.2f %-10s\n", 
				"Id", "Title", "Category", "Decription", "Duration", "Pre-requisite Course");
		Helper.line(20, "-");
		for (Course c : courses) {
			output += c.toString() + "\n";
		}
		return output;
	}
	
	public static void viewCourses() {
		String output = "Courses\n";
		output += retrieveCourses();
		System.out.println(output);
	}
	
	public static void addCourse() {
		System.out.println("Enter Course Information\n");
		//read
		String id = Helper.readString("ID : ");
		String title = Helper.readString("Title : ");
		String category = Helper.readString("Category Name : ");
		String desc = Helper.readString("Description : ");
		double duration = Helper.readDouble("Duration : ");
		String preCourse = Helper.readString("Pre-requisite Course : ");
		//insert
		Course newCourse = new Course(id, title, category, desc, duration, preCourse);
		
		
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
