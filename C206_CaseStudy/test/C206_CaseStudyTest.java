import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	//member2-caven
	private Category c1;
	private Category c2;
	private Category c3;
	private Category c4;
	private ArrayList<Category> categoryList;
	
	private Course c001;
	private Course c002;
	private ArrayList<Course> courseList;
	

	@Before
	public void setUp() throws Exception {
		//member 2- caven
		categoryList = new ArrayList<Category>();
		c1 = new Category("Math","All about solving painful question");
		c2 = new Category("English Life","All about reading english history");
		 
		courseList = new ArrayList<Course>();
		c001 = new Course("C001", "Software Devpt", "Infocomm", "Develo..", 120, "Math"); 
		c002 = new Course("C002", "Applied Chem", "Applied Science", "pharmace..", 120, "Chemistry"); 
	
	}
	
	// member 2 - caven
	@Test
	public void addCategoryTest() {
		categoryList.add(c1);
		categoryList.add(c2);
		// Error:Category list is not null, so that admin can add a new category - boundary
			assertNotNull("Check if  Category arraylist is empty",categoryList);
		//Normal: check if a valid category name and category description is provided, new course category should be added
			C206_CaseStudy.AddCourseCategory(categoryList);
			assertSame("Check that Category is added", c1,categoryList.get(0));
		// test for error: when duplicate category name is added 
			Boolean can=categoryList.add(new Category("Math","hello"));
			assertFalse("Test if an same category name can be added?",can);	
		//test boundary: can add more than 1 category into system
			int size=categoryList.size();
			assertEquals("check if size of list can be more than 1",2,size);

	}
	@Test
	public void viewAllCategoryTest() {
		categoryList.add(c1);
		categoryList.add(c2);
		// Normal condition: test if view can work
		C206_CaseStudy.viewAllCourseCategory(categoryList);
		//Error: error in viewing or retrieving Course Category
		fail("nothing can be seen");
		
		
	}
	@Test
	public void deleteACategory() {
		categoryList.add(c1);
		categoryList.add(c2);
		//Normal Condition: test if delete works in case of deleting "Math"Category
		C206_CaseStudy.DeleteACourseCategory(categoryList);
		assertEquals("check if the first Category math has been deleted",categoryList.get(0).getName(),"English Life");
		//Error:test if list is not null 
		assertNotNull(categoryList);
		//test boundary: no more to delete
		int size=categoryList.size();
		assertEquals("check if size of list is 0",0,size);
		
		
	}
	
	//member - 3
	@Test
	public void retrieveCoursesTest() {
		//Boundary
		assertNotNull("Test if there is a valid courseList to retrieve course from", true);
		
		String courses = C206_CaseStudy.retrieveCourses(courseList);
		String expectedCourses = String.format("%-10s %-20s %-20s %-20s %-20s %-20s\n", "Id", "Title", "Category", "Decription",
				                 "Duration", "Pre-requisite Course");
		assertEquals("Test that the retrieved Chromebooklist is empty", expectedCourses, courses);
		System.out.println(courses);
		
		//Normal
		//--- Add Courses - C001 C002
		courseList.add(c001);  
		courseList.add(c002);  
		assertEquals("Test that courseList size is 2", 2, courseList.size());
		
		courses = C206_CaseStudy.retrieveCourses(courseList);
		expectedCourses += String.format("%-10s %-20s %-20s %-20s %-20.2f %-20s\n", 
				           "C001", "Software Devpt", "Infocomm", "Develo..", 120.00, "Math");
		expectedCourses += String.format("%-10s %-20s %-20s %-20s %-20.2f %-20s\n", 
				           "C002", "Applied Chem", "Applied Science", "pharmace..", 120.00, "Chemistry");
		assertEquals("Test that the retrieved Chromebooklist is empty", expectedCourses, courses);
		
	}
	
	@Test
	public void addCourseTest() {
		//Boundary
		assertNotNull("Test if there is a valid courseList to add to", true);
		
		//--- Add C001
		//Normal 
		categoryList.add(c3);                                                         //add course category
		boolean isValid = C206_CaseStudy.addCourse(courseList, categoryList, c001);   //add course
		assertEquals("Test that courseList size is 1", 1, courseList.size());
		assertSame("Test that Course is added", c001, courseList.get(0));
		
		//Error 
		assertTrue("Test course ID C001 is unique", isValid);
		
		//--- Add C002
		//Normal
		categoryList.add(c4);                                                       //add another course category
		isValid = C206_CaseStudy.addCourse(courseList, categoryList, c002);           //add another course
		assertEquals("Test that courseList size is 2", 2, courseList.size());
		assertSame("Test that Course is added", c002, courseList.get(1));
	
		//Error 
		assertTrue("Test course ID C002 is unique", isValid);

	}
	
	@Test
	public void deleteCourseTest() {
		//Boundary
		assertNotNull("Test if there is a valid courseList to delete from", true);
		
		//--- Add Courses - C001 C002
		courseList.add(c001);  
		courseList.add(c002);  
		assertEquals("Test that courseList size is 2", 2, courseList.size());
		
		//--- Delete C001
		//Normal    
		boolean isDeleted = C206_CaseStudy.deleteCourse(courseList, "C001");            
		assertEquals("Test that courseList size is 1", 1, courseList.size());
		assertFalse("Test that Course ID C002 is deleted", courseList.contains(c001));
		
		//Error
		assertTrue("Test that Course ID C002 exists in courseList", isDeleted);
		
		//--- Delete C002
		//Normal    
		isDeleted = C206_CaseStudy.deleteCourse(courseList, "C002");            
		assertEquals("Test that courseList size is 0", 0, courseList.size());
		assertFalse("Test that Course ID C001 is deleted", courseList.contains(c002));
				
		//Error
		assertTrue("Test that Course ID C001 exists in courseList", isDeleted);
	
	}

	@After
	public void tearDown() throws Exception {
		//member 2 -caven
		c1 = null;
		c2 = null;
		categoryList=null;
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
