import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	} //main
	
	private static ArrayList<Course> courses = new ArrayList<>();
	
	//Member 1
	
	//Member 2
	
	//Member 3
	public static String retrieveCourses() {
		String output =  String.format("%-10s %-10s %-10s %-10s %-10.2f %-10s\n", 
				"Id", "Title", "Category", "Decription", "Duration", "Pre-requisite Course") ;
		
		for (Course c : courses) {
			output += c.toString() + "\n";
		}
		
		return output;
	}
	
	
	//Member 4
	
	//Add course schedule with the following information
	//course schedule id, price, start date/time, end date/time, location
	
	
	//View course schedule
	
	//Delete course schedule
	
	//- Member 5
	
	

}
