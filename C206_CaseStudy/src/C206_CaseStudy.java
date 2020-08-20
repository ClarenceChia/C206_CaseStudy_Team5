
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class C206_CaseStudy {
	
	private static final int OPTION_QUIT = 5;
	private static final int OPTION_QUIT = 10;
	static ArrayList <registerSchedule> list = new ArrayList<registerSchedule>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Course> courses = new ArrayList<>();
		ArrayList<CourseSchedule> scheduleList = new ArrayList<CourseSchedule>();

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
				addCourse(courses)
			} else if (option == 3) {
				// delete course

			} else if (option == 4) {
				//course schedule app
				scheduleMenu();


			} else if (option == OPTION_QUIT) {
=======
			}
			else if (option == 5) {
				//Add new Course Category
				AddCourseCategory(CategoryList);
			}
			else if (option == 6) {
				//View all Course Category
				viewAllCourseCategory(CategoryList);
			}
			else if (option == 7) {
				//Delete Course Category
				DeleteACourseCategory(CategoryList);
			}
			else if (option == OPTION_QUIT) {
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
		System.out.println("4. Course Schedule");
		System.out.println("5. Quit");
		System.out.println("4. Register ");
		System.out.println("5. Add new Course Category ");
		System.out.println("6. View Course Category ");
		System.out.println("7. Delete Course Category ");
		System.out.println("10. Quit");
		Helper.line(80, "-");
	}
	
	private static void scheduleMenu() {
		setHeader("COURSE SCHEDULE APP");
		System.out.println("1. View Course Schedule");
		System.out.println("2. Add Course Schedule");
		System.out.println("3. Delete Course Schedule");
		System.out.println("4. Quit");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	//Member 1
	 
	//Member 2
	ArrayList<Course> CategoryList = new ArrayList<Course>();
	public static void AddCourseCategory(ArrayList<Course> CategoryList) {
		String category=Helper.readString("Enter a new category name");
		String description=Helper.readString("Enter description for the new category");
		Course newCategory= new Course(category,description);
		CategoryList.add(newCategory);
		for (int i = 0; i < CategoryList.size(); i++) {
			String output = String.format("%-10s %-30s\n", "Category name ", "DESCRIPTION"
					);
			output+=String.format("%-10s %-30s\n",CategoryList.get(i).getDescription(),CategoryList.get(i).getDescription());
			System.out.println(output);
		}
		
	}
	

	public static void viewAllCourseCategory(ArrayList<Course> CategoryList) {
		for (int i = 0; i < CategoryList.size(); i++) {
			String output = String.format("%-10s %-30s\n", "Category name ", "DESCRIPTION"
					);
			output+=String.format("%-10s %-30s\n",CategoryList.get(i).getDescription(),CategoryList.get(i).getDescription());
			System.out.println(output);
		}
		
		String categoryChoose=Helper.readString("Enter the category name to view category");
		for (int i = 0; i < CategoryList.size(); i++) {
			if(CategoryList.get(i).getCategory().equalsIgnoreCase(categoryChoose)) {
				System.out.println("Category Found !");
				System.out.println("Category name:"+CategoryList.get(i).getCategory()+"\n"+"Category description:"+CategoryList.get(i).getDescription());
				
			}
			else {
				System.out.println("No such Category Found !");
			}}}

	//Member 2 - Caven
	public static void AddCourseCategory(ArrayList<Course> CategoryList) {
		setHeader("Add Course Category");
		String category=Helper.readString("Enter a new category name");
		String description=Helper.readString("Enter description for the new category");
		Course newCategory= new Course(category,description);
		CategoryList.add(newCategory);
		for (int i = 0; i < CategoryList.size(); i++) {
			String output = String.format("%10s %30s\n", "Category name ", "DESCRIPTION"
					);
			output+=String.format("%10s %30s\n",CategoryList.get(i).getCategory(),CategoryList.get(i).getDescription());
			System.out.println(output);
		}
		
	}
	

	public static void viewAllCourseCategory(ArrayList<Course> CategoryList) {
		setHeader("Viewing Course Category");
		String output = String.format("%-10s %-30s\n", "Category name ", "DESCRIPTION"
				);
		for (int i = 0; i < CategoryList.size(); i++) {
			output+=String.format("%-10s %-30s\n",CategoryList.get(i).getCategory(),CategoryList.get(i).getDescription());
			System.out.println(output);
		}
		
		String categoryChoose=Helper.readString("Enter the category name to view category");
		for (int i = 0; i < CategoryList.size(); i++) {
			if(CategoryList.get(i).getCategory().equalsIgnoreCase(categoryChoose)) {
				System.out.println("Category Found !");
				System.out.println("Category name:"+CategoryList.get(i).getCategory()+"\n"+"Category description:"+CategoryList.get(i).getDescription());
				
			}
			else {
				System.out.println("No such Category Found !");
			}
		}
	}

	
	public static void DeleteACourseCategory(ArrayList<Course> CategoryList) {
		setHeader("Deleting Course Category");
		String output = String.format("%-10s %-30s\n", "Category name ", "DESCRIPTION"
				);
		for (int i = 0; i < CategoryList.size(); i++) {
			output+=String.format("%-10s %-30s\n",CategoryList.get(i).getCategory(),CategoryList.get(i).getDescription());
			System.out.println(output);
		}
		String category=Helper.readString("Enter a  category name to delete from ");
		for (int i = 0; i < CategoryList.size(); i++) {
			if(CategoryList.get(i).getCategory().equalsIgnoreCase(category)) {
				CategoryList.remove(i);
			}
		}
		for (int i = 0; i < CategoryList.size(); i++) {
			output+=String.format("%-10s %-30s\n",CategoryList.get(i).getCategory(),CategoryList.get(i).getDescription());
			System.out.println(output);
		}
		
		
	}

	
	
	

	

	//Member 3 - Daryl
	private static String retrieveCourses(List<Course> courses) {
		String output =  String.format("%-10s %-20s %-20s %-20s %-20s %-20s\n",
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
	public static String retrieveCourseSchedule(ArrayList<CourseSchedule> scheduleList) {
		String output = "";

		for (int i = 0; i < scheduleList.size(); i++) {

			output += String.format("%-15s %-15d %-15s %-15s %-15s\n", 
					scheduleList.get(i).getScheduleID(),
					scheduleList.get(i).getPrice(),
					scheduleList.get(i).getStartDateTime(),
					scheduleList.get(i).getEndDateTime(),
					scheduleList.get(i).getLocation());
		}
		return output;
	}
	
	//Add course schedule with the following information
	public static void addCourseSchedule(ArrayList<CourseSchedule> scheduleList) {
		String scheduleid = Helper.readString("Course schedule ID > ");
		double price = Helper.readDouble("Price > ");
		String start = Helper.readString("Start date/time (DD/MMM/YYY  HH:MM)");
		String end = Helper.readString("End date/time (DD/MMM/YYY  HH:MM)");
		String location = Helper.readString("Course location > ");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy, hh:mm a");
		LocalDateTime startDT = LocalDateTime.parse(start, formatter);
		LocalDateTime endDT = LocalDateTime.parse(end, formatter);
		
		CourseSchedule cc= new CourseSchedule(scheduleid, price, startDT, endDT, location);
		scheduleList.add(cc);
		System.out.println("Schedule added");	
	}
	
	//View course schedule
	public static void viewCourseSchedule(ArrayList<CourseSchedule> scheduleList) {
		String output = String.format("%-15s %-15s %-15s %-15s %-15s\n", 
				"COURSE SCHEDULE ID", "PRICE", "START DATE TIME", "END DATE TIME","LOCATION");
		output += retrieveCourseSchedule(scheduleList);	
		System.out.println(output);
	}
	
	//Delete course schedule
	public static void deleteCourseSchedule(ArrayList<CourseSchedule> scheduleList) {
		String scheduleid = Helper.readString("Course schedule ID > ");
		char yOrN = Helper.readChar("Are you sure you want to delete? (Y/N) > ");
		
		if (yOrN == 'Y' && yOrN == 'y') {
			for (int i = 0; i < scheduleList.size(); i++) {
				if (scheduleid.equals(scheduleList.get(i).getScheduleID())) 
				{scheduleList.remove(i);}
			}
		}	
	}
	
	//- Member 5
	
	

}
