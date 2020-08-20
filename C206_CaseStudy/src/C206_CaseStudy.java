
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

import java.util.ArrayList;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class C206_CaseStudy {
	
	private static final int OPTION_QUIT = 5;
	static ArrayList <registerSchedule> list = new ArrayList<registerSchedule>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Course> courses = new ArrayList<>();
		ArrayList<Course> CategoryList = new ArrayList<Course>();
		
		int option = 0;

		while (option != OPTION_QUIT) {

			//menu
			menu();
			option =  Helper.readInt("Enter an option > ");

			if (option == 1) {
				//view courses
				viewCourses(courses);
				
			} else if (option == 2) {

				//
				// add course
				addCourse(courses);


			} else if (option == 3) {
				// delete course
				deleteCourse(courses);

			} else if (option == 4) {
				//d
				regSche();
				viewAllr();

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
		System.out.println("4. Register ");
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	//Member 1 - Clarence
	private static String retrieveMembers(List<Member> members) {
		String output = String.format("%-10s %-10s %-10s %-10s %-20s %-10s", "Name", "Gender", "Mobile", "Email", "Date of Birth", "Country");
		for (Member m : members) {
			output+= m.toString();
		}
		return output;
	}
	
	public static void viewMembers(List<Member> members) {
		setHeader("Members");
		System.out.println(retrieveMembers(members));
	}
	
	public static void addMembers(List<Member> members) {
		setHeader("Register Member");
		System.out.println("\n");
		
		String name = Helper.readString("Enter name > ");
		char gender = Helper.readChar("Enter gender (M/F) > ");
		int mobile = Helper.readInt("Enter mobile number > ");
		String email = Helper.readString("Enter email > ");
		String dob = Helper.readString("Enter date of birth(DD/MM/YYYY) > ");
		String country = Helper.readString("Enter Country of residence > ");
		
		Member newMember = new Member(name, gender, mobile, email, dob, country);
		members.add(newMember);
		System.out.println("Member added");
	}
	
	public static void deleteMember(List<Member> members) {
		setHeader("Delete Member");
		viewMembers(members);
		
		String name = Helper.readString("Name > ");
		boolean isFound = false;
		Member member = null;
		for (Member m : members) {
			if(m.getName().equals(name)) {
				isFound = true;
				member = m;
				break;
			}
		}
		if (isFound) {
			members.remove(member);
			System.out.println("Member Deleted");
		} else {
			System.out.println("Invalid Member");
		}
	}


	//Member 2 - Caven
	public static void AddCourseCategory(ArrayList<Course> CategoryList) {
		setHeader("Add Course Category");
		String category=Helper.readString("Enter a new category name");
		String description=Helper.readString("Enter description for the new category");
		String newCat="";
		Boolean duplicateName=false;
		
		// check for duplicates name
		for(int i=0 ;i<CategoryList.size();i++) {
			if(CategoryList.get(i).getCategory().equalsIgnoreCase(category)) {
				duplicateName=true;
				System.out.println("Duplicate names Found!");
				newCat+=Helper.readString("Enter another non-duplicate category name");
			}
			else {
				duplicateName=false;
			}
		}
		//create constructor based on whether there is duplicate
		if(duplicateName== true) {
			Course newCategory=new Course(newCat,description);
			CategoryList.add(newCategory);
		}
		else if(duplicateName == false) {
			Course newCategory=new Course(category,description);
			CategoryList.add(newCategory);
		}
		
		String output = String.format("%10s %30s\n", "Category name ", "DESCRIPTION"
				);
		for (int i = 0; i < CategoryList.size(); i++) {
			output+=String.format("%10s %30s\n",CategoryList.get(i).getCategory(),CategoryList.get(i).getDescription());
			
		}
		System.out.println(output);
		
	}
	

	public static void viewAllCourseCategory(ArrayList<Course> CategoryList) {
		setHeader("Viewing Course Category");
		String output = String.format("%-10s %-30s\n", "Category name ", "DESCRIPTION"
				);
		boolean exist= false;
		for (int i = 0; i < CategoryList.size(); i++) {
			output+=String.format("%-10s %-30s\n",CategoryList.get(i).getCategory(),CategoryList.get(i).getDescription());
			
		}
		System.out.println(output);
		
		String categoryChoose=Helper.readString("Enter the category name to view category");
		for (int i = 0; i < CategoryList.size(); i++) {
			if(CategoryList.get(i).getCategory().equalsIgnoreCase(categoryChoose)) {
				System.out.println("Category Found !");
				System.out.println("Category name:"+CategoryList.get(i).getCategory()+"\n"+"Category description:"+CategoryList.get(i).getDescription());
				exist=true;
			}
			
		}
		if(exist== false) {
			System.out.println("No such category name!");
		}
		
			
		}

	
	public static void DeleteACourseCategory(ArrayList<Course> CategoryList) {
		setHeader("Deleting Course Category");
		String result="";
		boolean exist=false;
		String output = String.format("%-10s %-30s\n", "Category name ", "DESCRIPTION"
				);
		for (int i = 0; i < CategoryList.size(); i++) {
			output+=String.format("%-10s %-30s\n",CategoryList.get(i).getCategory(),CategoryList.get(i).getDescription());
			
		}
		System.out.println(output);
		int numberToDelete=0;
		String category=Helper.readString("Enter a  category name to delete from ");
		for (int i = 0; i < CategoryList.size(); i++) {
			if(CategoryList.get(i).getCategory().equalsIgnoreCase(category)) {
				numberToDelete=i;
				exist=true;
			}
			
		}
		if(exist == true) {
			CategoryList.remove(numberToDelete);
			result+="Category removed!";
		}
		else {
			result+="No such category found!";
		}
		System.out.println(result);
		
		
		
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
		System.out.println("Course Added.");
	}
	
	public static void deleteCourse(List<Course> courses) {
		setHeader("Delete Course");
		viewCourses(courses);
		//course id 
		String id = Helper.readString("Course ID : ");
		//check course id is valid
		boolean isFound = false;
		Course course = null;
		for (Course c : courses) {
			if (c.getId().equals(id)) {
				isFound = true;
				course = c;
				break;
			}
		}
		//delete course
		if (isFound) {
			courses.remove(course);
			System.out.println("Course Deleted.");
		} else {
			System.out.println("Invalid Course.");
		}
		
	}
	
	
	// Member 4 - Sabrina
	public static String retrieveCourseSchedule(ArrayList<CourseSchedule> scheduleList) {
		String output = "";

		for (int i = 0; i < scheduleList.size(); i++) {

			output += String.format("%-15s %-15d %-15s %-15s %-15s\n", scheduleList.get(i).getScheduleID(),
					scheduleList.get(i).getPrice(), scheduleList.get(i).getStartDateTime(),
					scheduleList.get(i).getEndDateTime(), scheduleList.get(i).getLocation());
		}
		return output;
	}

	// Add course schedule with the following information
	public static void addCourseSchedule(ArrayList<CourseSchedule> scheduleList) {
		String scheduleid = Helper.readString("Course schedule ID > ");
		double price = Helper.readDouble("Price > ");
		String start = Helper.readString("Start date/time (DD/MMM/YYY  HH:MM)");
		String end = Helper.readString("End date/time (DD/MMM/YYY  HH:MM)");
		String location = Helper.readString("Course location > ");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy, hh:mm a");
		LocalDateTime startDT = LocalDateTime.parse(start, formatter);
		LocalDateTime endDT = LocalDateTime.parse(end, formatter);

		CourseSchedule cc = new CourseSchedule(scheduleid, price, startDT, endDT, location);
		scheduleList.add(cc);
		System.out.println("Schedule added");
	}

	// View course schedule
	public static void viewCourseSchedule(ArrayList<CourseSchedule> scheduleList) {
		String output = String.format("%-15s %-15s %-15s %-15s %-15s\n", "COURSE SCHEDULE ID", "PRICE",
				"START DATE TIME", "END DATE TIME", "LOCATION");
		output += retrieveCourseSchedule(scheduleList);
		System.out.println(output);
	}

	// Delete course schedule
	public static void deleteCourseSchedule(ArrayList<CourseSchedule> scheduleList) {
		String scheduleid = Helper.readString("Course schedule ID > ");
		char yOrN = Helper.readChar("Are you sure you want to delete? (Y/N) > ");

		if (yOrN == 'Y' && yOrN == 'y') {
			for (int i = 0; i < scheduleList.size(); i++) {
				if (scheduleid.equals(scheduleList.get(i).getScheduleID())) {
					scheduleList.remove(i);
				}
			}
		}
	}
	//Member 5 - Rongxin 
public static void regSche() {
		
		String rn = Helper.readString("Enter a registration number > ");
		String sid = Helper.readString("Enter a course schedule id > ");
		String memail = Helper.readString("Enter your email > ");
		Date rdate = Helper.readDate("Enter a today's date > " );
		boolean flag = false;
		String op = "";
		
		for(registerSchedule i :list) {
			if(!rn.equalsIgnoreCase(i.getRegistrationNumber())) {
			i.setRegistrationNumber(rn);
			i.setScheduleId(sid);
			i.setMemberEmail(memail);
			i.setRegisterDate(rdate);
			op+= String.format("\n%s\n%s\n%s\n%s\n%s", i.getRegistrationNumber(),i.getScheduleId(),
					i.getMemberEmail(),i.getStatus(),i.getRegisterDate());
			flag = true;
			System.out.println("Register triumph");
			}else {
				System.out.println("Registration number existed");
			}
		}
		if(flag == true) {
			saveDetail(op);
		
		}
	}
	
	static void saveDetail(String result) {
		System.out.println("Saving to file...");
		try {
			File file = new File("RegistrationDetails.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(result);
			bw.close();
			
			System.out.println("Detail saved successful!");

		} catch (IOException io) {
			System.out.println("There was an error saving to the detail.");
		}
	}
	static void viewAllr() {
		System.out.printf("%-30s %-20s %-20s %-35s %-20s\n","Registration Number",
				"Schedule ID","Member Email","Status","Registerion Date");
		for(registerSchedule i :list) {
			System.out.printf("%-30s %-20s %-20s %-35s %-20s\n",i.getRegistrationNumber(),i.getScheduleId(),
					i.getMemberEmail(),i.getStatus(),i.getRegisterDate());
		}
	}
	static void delr() {
		String del = Helper.readString("Enter the registration number to delete > ");
		for(registerSchedule i :list) {
			if(del.equalsIgnoreCase(i.registrationNumber)) {
				i.setRegistrationNumber(null);
				i.setScheduleId(null);
				i.setMemberEmail(null);
				i.setStatus("Deleted");
				i.setRegisterDate(null);
				
			}else {
				System.out.println("Invalid registration numbe entered");
			}
		}
	}
	

}
