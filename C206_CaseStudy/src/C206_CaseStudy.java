
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 6;
	private static final int OPTION1_QUIT = 4;



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Course> courseList = new ArrayList<>();
		ArrayList<Member> memberList = new ArrayList<>();
		ArrayList<registerSchedule> reglist = new ArrayList<registerSchedule>();
		ArrayList<CourseSchedule> scheduleList = new ArrayList<CourseSchedule>();
		ArrayList<Category> CategoryList = new ArrayList<Category>();

		int option = 0;
		while (option != OPTION_QUIT) {
			mainMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				
				//--- M e m b e r  1   M E N U ---
				
				int option1 = 0;
				while (option1 != OPTION1_QUIT) {
					// insert menu
					membersMenu();
					option1 = Helper.readInt("Enter an option > ");
					if (option1 == 1) {
						setHeader("View Members");
						viewMembers(memberList);
					} else if (option1 == 2) {
						Member newMember = inputMemberInfo();
						boolean isAdded = addMembers(memberList, newMember);
						
						if(isAdded) {
							System.out.println("Member Added.");
						} else {
							System.out.println("Invalid Member Details.");
						}
					} else if (option1 == 3) {
						setHeader("Delete a Member");
						String countryName = inputCountryName();
						boolean isDeleted = deleteMember(memberList, countryName);
						if(isDeleted) {
							System.out.println("Member Deleted");
						} else {
							System.out.println("Invalid Member");
						}
					} else if (option1 == 4) {
						setHeader("Update a Member");
						
						viewMembers(memberList);
						String countryName = inputCountryName();
						String[] newMemberInfo = inputNewMemberInfo();
						boolean isUpdated = updateMember(memberList, countryName, newMemberInfo);
						
						if(isUpdated) {
							System.out.println("Member Updated");
						} else {
							System.out.println("Invalid Member");
						}
					} else if (option1 == 5) {
						setHeader("Search a Member by Country");
						
						viewMembers(memberList);
						String countryName = inputCountryName();
						viewMembersByCountry(memberList, countryName);
					} else if (option1 == OPTION1_QUIT) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid option");
					}
				}
			} else if (option == 2) {
				
				//--- M e m b e r  2   M E N U ---
				
				int option2 = 0;
				while (option2 != 5) {
					// insert menu
					courseCategoryMenu();
					option2 = Helper.readInt("Enter an option > ");
					if (option2 == 1) {
						viewAllCourseCategory(CategoryList);
					} else if (option2 == 2) {
						AddCourseCategory(CategoryList);
					} else if (option2 == 3) {
						DeleteACourseCategory(CategoryList);
					} 
					else if(option2 ==4) {
						UpdateCourseCategory(CategoryList);
					}
					else if (option2 == 5) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid option");
					}
				}
			} else if (option == 3) {
				
				//--- M e m b e r  3   M E N U ---
				
				int option3 = 0;
				while (option3 != 6) {
					// insert menu
					courseMenu();
					option3 = Helper.readInt("Enter an option > ");
					if (option3 == 1) {

                        setHeader("Add a Course\nEnter Course Information\n");
						addCourse(courseList, CategoryList);
						
					} else if (option3 == 2) {
						
						setHeader("View a Course");
						viewCourses(courseList);
						viewCourse(courseList);
						
					} else if (option3 == 3) {
						
						setHeader("Delete a Course");
						viewCourses(courseList);
						deleteCourse(courseList);
						
					} else if (option3 == 4) {
						
						setHeader("Update a Course");
						
						viewCourses(courseList);
						updateCourse(courseList);
						
					} else if (option3 == 5) {
						
						setHeader("Search a Course by Category");
						
						viewCategories(CategoryList);
						String category = inputCategoryName();
						viewCoursesByCat(courseList, CategoryList, category);
						
					} else if (option3 == 6) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid option");
					}
				}
			} else if (option == 4) {
				
				//--- M e m b e r  4   M E N U ---
				
				int option4 = 0;
				while (option4 != OPTION_QUIT) {
					// insert menu
					courseScheduleMenu();
					option4 = Helper.readInt("Enter an option > ");
					if (option4 == 1) {
						viewCourseSchedule(scheduleList);
					} else if (option4 == 2) {
						searchPriceCourseSchedule(scheduleList);
					} else if (option4 == 3) {
						addCourseSchedule(scheduleList);
					} else if (option4 == 4) {
						deleteCourseSchedule(scheduleList, reglist);
					} else if (option4 == 5) {
						updateCourseSchedule(scheduleList);
					} else if (option4 == OPTION_QUIT) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid option");
					}
				}
			} else if (option == 5) {
				
				//--- M e m b e r  5   M E N U ---
				
				int option5 = 0;
				while (option5 != OPTION1_QUIT) {
					// insert menu
					registerScheduleMenu();
					option5 = Helper.readInt("Enter an option > ");
					if (option5 == 1) {
						viewAllr(reglist);
					} else if (option5 == 2) {
						registerSchedule newReg = add();
						regSche(reglist,newReg);
					} else if (option5 == 3) {
						delr(reglist);
					} else if (option5 == 4){
						selRegisterScheduleByScheduleId(reglist);
					} else if(option5==5) {
						setStatusByScheduleId(reglist);
					} else if(option5==6){
						selRegisterEmail(reglist);
					} else if (option5 == OPTION1_QUIT) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid option");
					}
					
				}
			}
		}
	} // - END OF MAIN METHOD -
	

	//--- MAIN  MENU ---
	private static void mainMenu() {
		setHeader("MAIN MENU");
		System.out.println("1. Members Menu");
		System.out.println("2. Course Category Menu");
		System.out.println("3. Course Menu");
		System.out.println("4. Course Schedule Menu ");
		System.out.println("5. Register Menu");
		System.out.println("6. Quit");
		Helper.line(80, "-");
	}
 
	//--- Member 1 MENU ---
	private static void membersMenu() {
		setHeader("MEMBERS APP");
		System.out.println("1. View Members");
		System.out.println("2. Add Members");
		System.out.println("3. Delete Members");
		System.out.println("4. Update Member");
		System.out.println("5. Search Member by Country");
		System.out.println("6. Quit ");
		Helper.line(80, "-");
	}

	//--- Member 2 MENU ---
	private static void courseCategoryMenu() {
		setHeader("COURSE CATEGORY APP");
		System.out.println("1. View Course Categories");
		System.out.println("2. Add Course Category");
		System.out.println("3. Delete Course Category");
		System.out.println("4. Update Course Category");
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}

	//--- Member 3 MENU ---
	private static void courseMenu() {
		setHeader("MANAGES COURSES");
		System.out.println("1. Add a Course");
		System.out.println("2. View a Course");
		System.out.println("3. Delete a Course");
		System.out.println("4. Update a Course");
		System.out.println("5. Search a Course by Category");
		System.out.println("6. Quit");
		Helper.line(80, "-");
	}

	//--- Member 4 MENU ---
	private static void courseScheduleMenu() {
		setHeader("COURSE SCHEDULE APP");
		System.out.println("1. View Course Schedule");
		System.out.println("2. Search Course Schedule by Price");
		System.out.println("3. Add Course Schedule");
		System.out.println("4. Delete Course Schedule");
		System.out.println("5. Update Course Schedule");
		System.out.println("6. Quit");
		Helper.line(80, "-");
	}

	//--- Member 5 MENU ---
	private static void registerScheduleMenu() {
		setHeader("COURSE SCHEDULE APP");
		System.out.println("1. View Register");
		System.out.println("2. Add Register");
		System.out.println("3. Delete Register");
		System.out.println("4. Search by schedule Id");
		System.out.println("5. Set status with schedule id");
		System.out.println("6. Display detail of the member by the email");
		System.out.println("7. Quit");
		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	//--- Member 1 - Clarence METHODS ---

	public static String retrieveMembers(List<Member> members) {
		String output = String.format("%-10s %-10s %-10s %-10s %-20s %-10s", "Name", "Gender", "Mobile", "Email",
				"Date of Birth", "Country");
		for (Member m : members) {
			output += m.toString();
		}
		return output;
	}

	public static void viewMembers(List<Member> members) {
		setHeader("Members");
		System.out.println(retrieveMembers(members));
	}

	public static boolean addMembers(List<Member> members, Member newMember) {
		//check duplicate
		boolean isDuplicate = false;
		for (Member m : members) {
			if(m.getName().equals(newMember.getName())) {
				isDuplicate = true;
				break;
			}
		}
		
		//add member if valid
		boolean isAdded = false;
		if(!isDuplicate) {
			members.add(newMember);
			isAdded =true;
		}
		return isAdded;
	}

	public static boolean deleteMember(List<Member> members, String countryName) {
		setHeader("Delete Member");
		viewMembers(members);

		String name = Helper.readString("Name > ");
		//check if member name is valid
		boolean isFound = false;
		Member member = null;
		for (Member m : members) {
			if (m.getName().equals(name)) {
				isFound = true;
				member = m;
				break;
			}
		}
		
		boolean isDeleted = false;
		if(isFound) {
			members.remove(member);
			isDeleted = true;
		}
		return isDeleted;
	}
	
	public static String inputMember() {
		String name = Helper.readString("Enter name: ");
		return name;
	}
	
	public static Member inputMemberInfo() {
		setHeader("Register Member");
		System.out.println("\n");

		String name  = Helper.readString("Enter name > ");
		char gender = Helper.readChar("Enter gender (M/F) > ");
		int mobile = Helper.readInt("Enter mobile number > ");
		String email = Helper.readString("Enter email > ");
		String dob = Helper.readString("Enter date of birth(DD/MM/YYYY) > ");
		String country = Helper.readString("Enter Country of residence > ");

		Member newMember = new Member(name, gender, mobile, email, dob, country);
		return newMember;
	}
	
	//update Member
	public static boolean updateMember(List<Member> members, String countryName, String[] infoList) {
		boolean isFound = false;
		Member member = null;
		for(Member m : members) {
			if(m.getCountry().equals(countryName)) {
				isFound = true;
				member = m;
				break;
			}
		}
		
		//check if new info is valid
		boolean isValid = true;
		for(String info : infoList) {
			if(info.isEmpty()) {
				isValid = false;
				break;
			}
		}
		
		//update member if member name and new info is valid
		boolean isUpdated = false;
		if(isFound && isValid) {
			member.setMobile(Integer.parseInt(infoList[0]));
			member.setCountry(infoList[1]);
			
			isUpdated = true;
		}
		return isUpdated;
	}
	
	public static String[] inputNewMemberInfo() {
		String[] infoList = new String [3];
		
		//member info
		int mobile = Helper.readInt("Mobile: ");
		String country = Helper.readString("Country of Residence: ");
		
		//add into member info list
		infoList[0] = String.valueOf(mobile);
		infoList[1] = country;
		
		return infoList;
	}
	
	//Search Member by Country

	public static String retrieveMember(List<Member> members) {
		String output = "";
		for(Member m: members) {
			output += m.getCountry() + "\n";
		}
		return output;
	}
	
	public static String inputCountryName() {
		String countryName = Helper.readString("Enter country name: ");
		return countryName;
	}
	
	public static String retrieveMembersByCountry(List<Member> members, String country) {
		String output = String.format("%-10s %-10s %-10s %-10s %-20s %-10s", "Name", "Gender", "Mobile", "Email",
				"Date of Birth", "Country");
		for(Member m: members) {
			if(m.getCountry().equalsIgnoreCase(country)) {
				output += m.toString();
			}
		}
		return output;
	}
	
	public static void viewMembersByCountry(List<Member> members, String country) {
		System.out.println(retrieveMembersByCountry(members, country));
	}
	
	//--- Member 2 - Caven METHODS ---
	public static void AddCourseCategory(ArrayList<Category> CategoryList) {
		setHeader("Add Course Category");
		String category = Helper.readString("Enter a new category name");
		String description = Helper.readString("Enter description for the new category");
		String newCat = "";
		Boolean duplicateName = false;

		// check for duplicates name
		for (int i = 0; i < CategoryList.size(); i++) {
			if (CategoryList.get(i).getName().equalsIgnoreCase(category)) {
				duplicateName = true;
				System.out.println("Duplicate names Found!");
				newCat += Helper.readString("Enter another non-duplicate category name");
			} else {
				duplicateName = false;
			}
		}
		// create constructor based on whether there is duplicate
		if (duplicateName == true) {
			Category newCategory = new Category(newCat, description);
			CategoryList.add(newCategory);
		} else if (duplicateName == false) {
			Category newCategory = new Category(category, description);
			CategoryList.add(newCategory);
		}

		String output = String.format("%-20s %-40s\n", "Category name ", "DESCRIPTION");
		for (int i = 0; i < CategoryList.size(); i++) {
			output += String.format("%-20s %-40s\n", CategoryList.get(i).getName(), CategoryList.get(i).getDescription());

		}
		System.out.println(output);

	}
	// update course category description
	public static void UpdateCourseCategory(ArrayList<Category> CategoryList) {
		setHeader("Updating Course Category");
		String output = String.format("%-20s %-40s\n", "Category name ", "DESCRIPTION");
		for (int i = 0; i < CategoryList.size(); i++) {
			output += String.format("%-20s %-40s\n", CategoryList.get(i).getName(),
					CategoryList.get(i).getDescription());

		}
		
		System.out.println(output);
		int numberToUpdate=0;
		boolean exist=false;
		String categoryChoose = Helper.readString("Enter the category name to update category description");
		String newDescription = Helper.readString("Enter a new category description");
		for (int i = 0; i < CategoryList.size(); i++) {
			if (CategoryList.get(i).getName().equalsIgnoreCase(categoryChoose)) {
				numberToUpdate = i;
				exist = true;
			}
	}
		if(exist == true) {
			CategoryList.get(numberToUpdate).setDescription(newDescription);
			System.out.println("Category Description updated!");
			
		}
		else {
			System.out.println("No such category found");
		}
	}

	public static void viewAllCourseCategory(ArrayList<Category> CategoryList) {
		setHeader("Viewing Course Category");
		String output = String.format("%-20s %-40s\n", "Category name ", "DESCRIPTION");
		boolean exist = false;
		for (int i = 0; i < CategoryList.size(); i++) {
			output += String.format("%-20s %-40s\n", CategoryList.get(i).getName(),
					CategoryList.get(i).getDescription());

		}
		System.out.println(output);

		String categoryChoose = Helper.readString("Enter the category name to view category");
		for (int i = 0; i < CategoryList.size(); i++) {
			if (CategoryList.get(i).getName().equalsIgnoreCase(categoryChoose)) {
				System.out.println("Category Found !");
				System.out.println("Category name:" + CategoryList.get(i).getName() + "\n" + "Category description:"
						+ CategoryList.get(i).getDescription());
				exist = true;
			}

		}
		if (exist == false) {
			System.out.println("No such category name!");
		}

	}

	public static void DeleteACourseCategory(ArrayList<Category> CategoryList) {
		setHeader("Deleting Course Category");
		String result = "";
		boolean exist = false;
		String output = String.format("%-20s %-40s\n", "Category name ", "DESCRIPTION");
		for (int i = 0; i < CategoryList.size(); i++) {
			output += String.format("%-20s %-40s\n", CategoryList.get(i).getName(),
					CategoryList.get(i).getDescription());

		}
		System.out.println(output);
		int numberToDelete = 0;
		String category = Helper.readString("Enter a  category name to delete from ");
		for (int i = 0; i < CategoryList.size(); i++) {
			if (CategoryList.get(i).getName().equalsIgnoreCase(category)) {
				numberToDelete = i;
				exist = true;
			}

		}
		if (exist == true) {
			CategoryList.remove(numberToDelete);
			result += "Category removed!";
		} else {
			result += "No such category found!";
		}
		System.out.println(result);

	}

    //--- Member 3 - Daryl METHODS ---
   
	// 3.2 : View a Course

    // View all Courses
	public static String retrieveCourses(List<Course> courses) {
		String output = String.format("%-10s %-20s %-20s %-20s %-20s %-20s\n", "Id", "Title", "Category", "Decription",
				"Duration", "Pre-requisite Course");
		for (Course c : courses) {
			output += c.toString();
		}
		return output;
	}
	
	public static void viewCourses(List<Course> courses) {
		String output = retrieveCourses(courses);
		System.out.println(output);
	}
	
	// View a Course
	public static String retrieveCourse(List<Course> courses, Course course) {
		String output = "";
		if (course != null) {
			output = String.format("%-10s %-20s %-20s %-20s %-20s %-20s\n", "Id", "Title", "Category", "Decription",
					"Duration", "Pre-requisite Course");
			output += course.toString();
		} else {
			output = "Course not found.";
		}
		return output;
	}
	
	public static void viewCourse(List<Course> courses) {
		String id = inputCourse();
		Course course = findCourse(courses, id);
		String output = retrieveCourse(courses, course);
		System.out.println(output);
	}
	
	public static String inputCourse() {
		String id = Helper.readString("Course ID : "); 
		return id;
	}
	
	public static Course findCourse(List<Course> courses, String id) {
		Course course = null;
		for (Course c : courses) {
			if (c.getId().equals(id)) {
				course = c;
				break;
			}
		}
		return course;
	}
	
	// 3.1 : Add a Course
	
	public static void addCourse(List<Course> courses, List<Category> categories) {
		Course newCourse = inputCourseInfo();
		String output = doAddCourse(courses, categories, newCourse);
		System.out.println(output);
	}
	
	public static String doAddCourse(List<Course> courses, List<Category> categories, Course newCourse) {
		
		String output = "";
		String category = searchCategory(categories, newCourse);
		Course courseResult = findCourse(courses, newCourse.getId());
		
		//courseResult == null -> no duplicate
		//category     == ""   -> no category
		if (courseResult != null && category != "") {
			output = "Course ID not unique.";
		} else if (category == "" && courseResult == null) {
			output = "Category not found.";
		} else if (category == "" && courseResult != null) {
			output = "Category not found. Course ID not unique.";
		} else {
			courses.add(newCourse);
			output = "Course added.";
		}
		
		return output;
	}
	
	public static String searchCategory(List<Category> categories, Course newCourse) {
		// check category exists
		String category = "";
		for (Category cat : categories) {
			if (cat.name.equalsIgnoreCase(newCourse.getCategory())) {
				category = cat.name;
				break;
			}
		}
		return category;
	}
	
	public static Course inputCourseInfo() {
		
		// course information
		String id = Helper.readString("ID : ");
		String title = Helper.readString("Title : ");
		String category = Helper.readString("Category Name : ");
		String desc = Helper.readString("Description : ");
		double duration = Helper.readDouble("Duration : ");
		String preCourse = Helper.readString("Pre-requisite Course : ");
		Course newCourse = new Course(id, title, category, desc, duration, preCourse);
		
		return newCourse;
		
	}
	
	// 3.3 : Delete a Course
	
	public static void deleteCourse(List<Course> courses) {
		String id = inputCourse();
		String output = doDeleteCourse(courses, id);
		System.out.println(output);
	}
	
    public static String doDeleteCourse(List<Course> courses, String id) {
		
		String output = "";
		Course courseResult = findCourse(courses, id);
		
		//courseResult == null -> course doesn't exist
		if (courseResult == null) {
			output = "Course not found.";
		} else {
			courses.remove(courseResult);
			output = "Course deleted.";
		}
		
		return output;
	}
	
	// 3.4 : Update a Course
    
	public static void updateCourse(List<Course> courses) {
		String id = inputCourse();
		String[] infoList = inputNewCourseInfo();
		String output = doUpdateCourse(courses, id, infoList);
		System.out.println(output);
	}
	
	public static String doUpdateCourse(List<Course> courses, String id, String[] infoList) {
		
		String output = "";
		Course courseResult = findCourse(courses, id);
		boolean areValidInfo = areValidInfo(infoList);
		
		//courseResult == null -> course doesn't exist
		if (courseResult == null && !areValidInfo) {
			output = "Course not found. Empty field/s found.";
		} else if (courseResult != null && !areValidInfo) {
			output = "Empty field/s found.";
		} else if (courseResult == null && areValidInfo) {
			output = "Course not found.";
		} else  {
			courseResult.setTitle(infoList[0]);
			courseResult.setCategory( infoList[1]);
			courseResult.setDescription(infoList[2]);
			courseResult.setDuration(Double.parseDouble(infoList[3]));
			courseResult.setPreCourse(infoList[4]);
			output = "Course updated.";
		}
		
		return output;
	}
	
	
	public static String[] inputNewCourseInfo() {
		
		String[] infoList = new String[5];
		
		// course information
		String title     = Helper.readString("Title : ");
		String category  = Helper.readString("Category Name : ");
		String desc      = Helper.readString("Description : ");
		double duration  = Helper.readDouble("Duration : ");
		String preCourse = Helper.readString("Pre-requisite Course : ");
		
		//add to course information list
		infoList[0] = title;
		infoList[1] = category;
		infoList[2] = desc;
		infoList[3] = String.valueOf(duration);
		infoList[4] = preCourse;
		
		return infoList;
	}
	
	public static boolean areValidInfo(String[] infoList) {
    	boolean areValid = true;
    	// check new info are valid (no empty fields)
    	for (String info : infoList) {
    		if (info.isEmpty())  {
    			//end loop
    			areValid = false;
    			break;	
    	    } 
      	}
    	return areValid;
    }
	
	// 3.5 : Search Course by Category
	
	// Search Course By Category
	public static String retrieveCategories(List<Category> categories) {
		String output = "";
		for (Category cat : categories) {
			output += cat.getName() + "\n";
		}
		return output;
	}
	
	public static void viewCategories(List<Category> categories) {
		System.out.println(retrieveCategories(categories));
	}
	
	public static String inputCategoryName() {
		String catName = Helper.readString("Category Name : ");
		return catName;
	}
	
	public static boolean searchCategory(List<Category> categories, String category) {
		// check category exists
		boolean isFound = false;
		for (Category cat : categories) {
			if (cat.name.equalsIgnoreCase(category)) {
				isFound = true;
				break;
			}
		}
		return isFound;
	}
	
	public static String retrieveCoursesByCat(List<Course> courses, List<Category> categories, String category) {
		
		String output = "";
		boolean validCat = searchCategory(categories, category);
		
		if (validCat) {
			output = String.format("%-10s %-20s %-20s %-20s %-20s %-20s\n", "Id", "Title", "Category", "Decription",
			        "Duration", "Pre-requisite Course");
			
			int count = 0;
			for (Course c : courses) {
				if (c.getCategory().equalsIgnoreCase(category)) {
					output += c.toString();
					count++;
				}
			}
			
			if (count == 0) 
				output = "No Course/s found.";
			
		} else {
			output = "Category not found.";
		}
		
		return output;
	}
	
	public static void viewCoursesByCat(List<Course> courses, List<Category> categories, String category) {
		String output = retrieveCoursesByCat(courses, categories, category);
		System.out.println(output);
	}

	//--- Member 4 - Sabrina METHODS ---
	// Add course schedule
	public static void addCourseSchedule(ArrayList<CourseSchedule> scheduleList) {
		String scheduleid = Helper.readString("Course schedule ID > ");
		double price = Helper.readDouble("Price > ");
		String start = Helper.readString("Start date/time (yyyy-MM-dd HH:mm) > ");
		String end = Helper.readString("End date/time (yyyy-MM-dd HH:mm) > ");
		String location = Helper.readString("Course location > ");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime startDT = LocalDateTime.parse(start, formatter);
		LocalDateTime endDT = LocalDateTime.parse(end, formatter);

		CourseSchedule cc = new CourseSchedule(scheduleid, price, startDT, endDT, location);
		scheduleList.add(cc);
		System.out.println("Schedule added");
	}

	public static String retrieveCourseSchedule(ArrayList<CourseSchedule> scheduleList) {
		String output = "";
		for (int i = 0; i < scheduleList.size(); i++) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			String start = scheduleList.get(i).getStartDateTime().format(formatter);
			String end = scheduleList.get(i).getEndDateTime().format(formatter);

			output += String.format("%-20s $%-10.2f %-20s %-20s %-15s\n", scheduleList.get(i).getScheduleID(),
					scheduleList.get(i).getPrice(), start, end, 
					scheduleList.get(i).getLocation());
		}
		return output;
	}
	
	// View course schedule
	public static void viewCourseSchedule(ArrayList<CourseSchedule> scheduleList) {
		String output = String.format("%-20s %-10s %-20s %-20s %-15s\n", 
				"COURSE SCHEDULE ID", "PRICE",
				"START DATE TIME", "END DATE TIME", "LOCATION");
		output += retrieveCourseSchedule(scheduleList);
		System.out.println(output);
	}

	// Delete course schedule
	public static void deleteCourseSchedule(ArrayList<CourseSchedule> scheduleList, ArrayList<registerSchedule> reglist) {
		String scheduleid = Helper.readString("Course schedule ID > ");
		char yOrN = Helper.readChar("Are you sure you want to delete? (Y/N) > ");
		
		boolean emptylist = false;
		if ((viewAllr(reglist)).length() == 0) {
			emptylist = true;
		}
		
		if (yOrN == 'Y' || yOrN == 'y') {
			for (int i = 0; i < scheduleList.size(); i++) {
				if (scheduleid.equals(scheduleList.get(i).getScheduleID())) {
					if (emptylist == true) {
						scheduleList.remove(i);
						System.out.println("Deleted!");	
					} 
				} else {
					System.out.println("Delete failed");
				}
			}
		}
	}
	
	//searchPriceCourseSchedule
	public static void searchPriceCourseSchedule(ArrayList<CourseSchedule> scheduleList) {
			double price = Helper.readDouble("Enter price > ");
			
			for (int a = 0; a < scheduleList.size(); a++) {
				
				if (price == scheduleList.get(a).getPrice()) {
					String output = String.format("%-20s %-10s %-20s %-20s %-15s\n", 
							"COURSE SCHEDULE ID", "PRICE",
							"START DATE TIME", "END DATE TIME", "LOCATION");
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
						String start = scheduleList.get(a).getStartDateTime().format(formatter);
						String end = scheduleList.get(a).getEndDateTime().format(formatter);

						output += String.format("%-20s $%-10.2f %-20s %-20s %-15s\n", 
								scheduleList.get(a).getScheduleID(),
								scheduleList.get(a).getPrice(), start, end, 
								scheduleList.get(a).getLocation());
						
						System.out.println(output);
				}		
			}
	}
			
	//updateCourseSchedule
	public static void updateCourseSchedule(ArrayList<CourseSchedule> scheduleList) {
		String scheduleid = Helper.readString("Course schedule ID to update > ");
		
		for (int i = 0; i < scheduleList.size(); i++) {
			if (scheduleid.equalsIgnoreCase(scheduleList.get(i).getScheduleID())) {
				scheduleList.get(i).setPrice(Helper.readDouble("Price > "));
				
				String start = Helper.readString("Start date/time (yyyy-MM-dd HH:mm) > ");
				String end = Helper.readString("End date/time (yyyy-MM-dd HH:mm) > ");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				LocalDateTime startDT = LocalDateTime.parse(start, formatter);
				LocalDateTime endDT = LocalDateTime.parse(end, formatter);
				
				scheduleList.get(i).setStartDateTime(startDT);
				scheduleList.get(i).setEndDateTime(endDT);
				scheduleList.get(i).setLocation(Helper.readString("Course location > "));
			}
		}	
	}

	//--- Member 5 - Rongxin METHODS ---
	public static registerSchedule add() {
		String rn = Helper.readString("Enter a registration number > ");
		String sid = Helper.readString("Enter a course schedule id > ");
		int pick = Helper.readInt("Pick status:1.Accepted 2.Pending > ");
		String status=null;
		if(pick==1){
			status="Accepted";
		}else if(pick==2){
			status="Pending";
		}else{
			System.out.println("Invalid input");
		}
		String memail = Helper.readString("Enter your email > ");


		registerSchedule newReg = new registerSchedule(rn, sid, memail,status, LocalDate.now());
		return newReg;
	}
	public static void regSche(ArrayList<registerSchedule> reglist, registerSchedule newReg) {
		for (registerSchedule i : reglist) {
			// check for same registrationNumber
			if(i.getRegistrationNumber().equalsIgnoreCase(newReg.getRegistrationNumber())){
				System.out.println("Registration number existed");
				return;
			}
		}
		// no same registrationNumber.
		reglist.add(newReg);
		System.out.println("Register triumph");
			}
  
   // update 2(sprint 2)
	public static void selRegisterScheduleByScheduleId(ArrayList<registerSchedule> reglist){
		String scheduleId = Helper.readString("Enter the schedule id > ");
		registerSchedule rr=null;
		for (registerSchedule r : reglist) {
			if(r.getScheduleId().equals(scheduleId)){
				rr=r;
				//end the loop when find r
				break;
			}
		}

		if(rr==null){
			System.out.println("No matched schedule id as "+scheduleId);
		}else {
			System.out.println(rr.toString());
		}
	}

	public static void selRegisterEmail(ArrayList<registerSchedule> reglist){
		String email = Helper.readString("Enter the email of the person >");
		registerSchedule rr=null;

		for (registerSchedule r : reglist) {
			if(r.getMemberEmail().equals(email)){

				rr=r;
				break;
			}
		}

		if(rr==null){
			System.out.println("No matched email as "+email);
		}else {
			System.out.println(rr.toString());
		}
	}


	public static void setStatusByScheduleId(ArrayList<registerSchedule> reglist){
	
		String scheduleId = Helper.readString("Enter the schedule id to update the status > ");
		registerSchedule registerSchedule=null;
		for (registerSchedule schedule : reglist) {
			if(schedule.getScheduleId().equals(scheduleId)){
				registerSchedule=schedule;
				break;
			}
		}
		if(registerSchedule==null){
			System.out.println("No match result as "+scheduleId);
			return;
		}

		Helper.line(30, "-");;
		System.out.println("1.Accepted");
		System.out.println("2.Pending");
		int i = Helper.readInt("Enter you option > ");
		
		if(i==1){
			
			if(registerSchedule.getStatus().equals("Pending")){
				registerSchedule.setStatus("Accepted");
			}
		}else if(i==2){
		
			if(registerSchedule.getStatus().equals("Accepted")){
				Duration duration=Duration.between(registerSchedule.getRegisterDatetime(),LocalDateTime.now());
				long l = duration.toDays();
				if(l>0){
					System.out.println("Sorry! It is more than one day");
					return;
				}
				registerSchedule.setStatus("Pending");
				System.out.println("Successful updated to Pending");
			}
		}else {
			System.out.println("Invalid input");
		}
	}

	
	

	static String viewAllr(ArrayList<registerSchedule> reglist) {
		String op = String.format("%-30s %-20s %-20s %-15s %-20s\n", "Registration Number", "Schedule ID", "Member Email",
				"Status", "Registerion Date");
		for (registerSchedule i : reglist) {
			op += String.format("%-30s %-20s %-20s %-15s %-20s\n", i.getRegistrationNumber(), i.getScheduleId(),
					i.getMemberEmail(), i.getStatus(), i.getRegisterDatetime());
		}
		
		System.out.println(op);
		return op;

	}

	static void delr(ArrayList<registerSchedule> reglist) {
		String del = Helper.readString("Enter the registration number to delete > ");
		for (registerSchedule i : reglist) {
			if (del.equalsIgnoreCase(i.registrationNumber)) {
				i.setStatus("Deleted");
				System.out.println("Deleted !");
 
			} else {
				System.out.println("Invalid registration number entered");
			}
		}
	}

}
