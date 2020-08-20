import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	} //main
	
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
	
	
	//Member 4
	
	//Add course schedule with the following information
	//course schedule id, price, start date/time, end date/time, location
	
	
	//View course schedule
	
	//Delete course schedule
	
	//- Member 5
	
	

}
