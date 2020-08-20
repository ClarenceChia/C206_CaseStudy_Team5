import java.util.ArrayList;

public class C206_CaseStudy {
	
	private static final int OPTION_QUIT = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int option = 0;

		while (option != OPTION_QUIT) {

			//menu
			menu();
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
		setHeader("Courses");
		System.out.println(retrieveCourses();
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
	
	
	//Member 4
	
	//Add course schedule with the following information
	//course schedule id, price, start date/time, end date/time, location
	
	
	//View course schedule
	
	//Delete course schedule
	
	//- Member 5
	
	

}
