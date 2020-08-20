
import java.util.ArrayList;


import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

import java.util.ArrayList;


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
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				//view courses
				viewCourses(courses);
				
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
			}
		}
		
			
		}
	
	
	
	
		
	//Member 3
	public static String retrieveCourses() {
		String output =  String.format("%-10s %-10s %-10s %-10s %-10.2f %-10s\n", 

	//Member 3 - Daryl
	private static String retrieveCourses(List<Course> courses) {
		String output =  String.format("%-10s %-10s %-10s %-10s %-10s %-10s\n", 

				"Id", "Title", "Category", "Decription", "Duration", "Pre-requisite Course");
		for (Course c : courses) {
			output += c.toString() + "\n";
		}
		return output;
	}
	
	public static void viewCourses(List<Course> courses) {
		setHeader("Courses");
		System.out.println(retrieveCourses(courses));
	}
	
	public static void addCourse() {
		System.out.println("Enter Course Information\n");
		//course information
		String id = Helper.readString("ID : ");
		String title = Helper.readString("Title : ");
		String category = Helper.readString("Category Name : ");
		String desc = Helper.readString("Description : ");
		double duration = Helper.readDouble("Duration : ");
		String preCourse = Helper.readString("Pre-requisite Course : ");
		//insert course
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
