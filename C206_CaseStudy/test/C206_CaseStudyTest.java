import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	//member 1 - Clarence
	private Member m1;
	private Member m2;
	private ArrayList<Member> memberList;
	private String searchCountry01;
	private String searchCountry02;
	private String searchCountry03;
	
	// member 2 - caven
	private Category c1;
	private Category c2;
	private ArrayList<Category> categoryList;
	
	// member 3 - daryl
	private Course c001;
	private Course c002;
	private Course c003;
	private Category c3;
	private Category c4;
	private String searchCat01;
	private String searchCat02;
	private String searchCat03;
	private String[] newCourseinfo01;
	private String[] newCourseinfo02;
	private String[] newCourseinfo03;
	private ArrayList<Course> courseList;

	// member 4 - sabrina
	private CourseSchedule cs1;
	private CourseSchedule cs2;
	private ArrayList<CourseSchedule> scheduleList;
	// member 4 ends

	// member 5 - rongxin
	
	registerSchedule r1;
	registerSchedule r2;
	registerSchedule rf1;
	registerSchedule f;
	ArrayList<registerSchedule> reglist;

	// ends here
	 
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		
		//member 1 - Clarence
		memberList = new ArrayList<Member>();
		m1 = new Member("Anna Bell", 'F', 92225555, "annabell@gmail.com", "06072000", "Australia");
		m2 = new Member("Mike Chang", 'M', 93338888, "mikechang@gmail.com", "21031999", "Singapore");
		searchCountry01 = "Australia";
		searchCountry02 = "Singapore";
		searchCountry03 = "Brazil";
		
		
		//member 2 - caven
		categoryList= new ArrayList<Category>();
		c1= new Category("Math","All about solving painful question");
		c2= new Category("English Life","All about reading english history");
		
		
		//member 3 - daryl
		courseList = new ArrayList<Course>();
		c001 = new Course("C001", "Software Devpt", "Infocomm", "Develo..", 120, "Math"); 
		c002 = new Course("C002", "Applied Chem", "Applied Science", "pharmace..", 120, "Chemistry"); 
		c003 = new Course("C003", "Mobile Devpt", "Tech", "Develo..", 120, "Math"); 
		c3 = new Category("Infocomm", "info..");
		c4 = new Category("Applied Science", "apply..");
				
		newCourseinfo01 = new String[] {"Software Development", "Infocomm", "Develo..", "160.0", "Math"};
		newCourseinfo02 = new String[] {"Applied Chemistry", "Applied Science", "pharmace..", "160.0", "Chemistry"};
		newCourseinfo03 = new String[] {"Applied Chemistry", "Applied Science", "", "160.0", "Chemistry"};
				
		searchCat01 = "Infocomm";
		searchCat02 = "Applied Science";
		searchCat03 = "Medical";
			
		//member 4 - sabrina
		scheduleList= new ArrayList<CourseSchedule>();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String cs1Start = "2020-08-20 12:15"; String cs1End = "2020-08-20 13:15";
		String cs2Start = "2020-08-21 12:15"; String cs2End = "2020-08-21 13:15";
		LocalDateTime cs1StartDT = LocalDateTime.parse(cs1Start, formatter);
		LocalDateTime cs1EndDT = LocalDateTime.parse(cs1End, formatter);
		LocalDateTime cs2StartDT = LocalDateTime.parse(cs2Start, formatter);
		LocalDateTime cs2EndDT = LocalDateTime.parse(cs2End, formatter);
		
		cs1 = new CourseSchedule("DBIS1", 20, cs1StartDT, cs1EndDT, "E22K");
		cs2 = new CourseSchedule("DBIM1", 10, cs2StartDT, cs2EndDT, "E22M");			
		//member 4 ends		
		
		//member 5 - Rongxin
		reglist = new ArrayList <registerSchedule>();

		LocalDate d1 =LocalDate.now();
		LocalDate d2 =LocalDate.now();
		r1 = new registerSchedule("N1","S1","a1@yahoo.com",d1);
		r2 = new registerSchedule("N2","S2","a2@yahoo.com",d2);
		rf1 = new registerSchedule("N1 ","S1","a1@yahoo.com",d1);
		//member 5 ends
		
	}
	/*
	//member 1 - Clarence
	@Test
	public void retrieveMemberTest() {
		//Boundary - Test Valid Member List to Retrieve Members From
		assertNotNull(memberList);
				
		//Normal - Test Member List Size is 0
		assertEquals(0, memberList.size());
				
		//Boundary - Test Course Output Contains the Course Header when Course List is Empty (Size is 0)
		String members = C206_CaseStudy.retrieveMembers(memberList);
		String expectedMembers = String.format("%-30s %-10s %-10s %-20s %-15s %-20s", "Name", "Gender", "Mobile", "Email", "Date of Birth", "Country");
		assertEquals(expectedMembers, members);
				
		//Normal - Test Member List Size is 2 after Adding 2 Members
		memberList.add(m1);  
		memberList.add(m2);  
		assertEquals(2, memberList.size());
				
		//Normal - Test Member Output Contains the 2 Formatted Member Information + Member Header after Adding 2 Members
		members = C206_CaseStudy.retrieveMembers(memberList);
		expectedMembers += String.format("%-30s %-10s %-10d %-20s %-15s %-20s\n", "Anna Bell", 'F', 92225555, "annabell@gmail.com", "06072000", "Australia");
		expectedMembers += String.format("%-30s %-10s %-10d %-20s %-15s %-20s\n", "Mike Chang", 'M', 93338888, "mikechang@gmail.com", "21031999", "Singapore");
		assertEquals(expectedMembers, members);
	}
	
	@Test
	public void addMemberTest() {
		//Boundary - Test Valid Member List to Add Members To
		assertNotNull(memberList);
				
		//Normal - Test Course List Size is 0
		assertEquals(0, memberList.size());
				
		//--- Add C001
		//Normal - Test Member List Size is 1 after Adding 1 Member - m1
		//Normal - Test Member - m1 is the First Member of the Member List
		memberList.add(m1);                                                         //add Member category
		boolean isValid = C206_CaseStudy.addMembers(memberList, m1);   //add Member
		assertEquals(1, memberList.size());
		assertSame(m1, memberList.get(0));
				
		//Error - Test Member ID - m1 doesn't exist
		assertTrue(isValid);
				
		//--- Add m2
		//Normal - Test Member List Size is 2 after Adding 1 Member - m2
		//Normal - Test Member - m2 is the Second Member of the Member List
		memberList.add(m2);                                                       //add another Member category
		isValid = C206_CaseStudy.addMembers(memberList, m2);         //add another Member
		assertEquals(2, memberList.size());
		assertSame(m2, memberList.get(1));
			
		//Error - Test Member ID - m2 exist in the Member List OR Member Category Name doesn't exist in Member List
		assertTrue(isValid);

	}
	
	@Test
	public void deleteMemberTest() {
		//Boundary - Test Valid Member List to Delete Members From
		assertNotNull(memberList);
				
		//Normal - Test Member List Size is 0
		//Normal - Test Member List Size is 2 after Adding 2 Members
		assertEquals(0, memberList.size());
		memberList.add(m1);  
		memberList.add(m2);  
		assertEquals(2, memberList.size());
				    
		//--- Delete m1
		//Normal - Test Member List Size is 1 after Deleting Member - m1
		//Normal - Test Member - m1 doesn't exist in the Member List
		boolean isDeleted = C206_CaseStudy.deleteMember(memberList, "m1");            
		assertEquals(1, memberList.size());
		assertFalse(memberList.contains(m1));
				
		//Error - Test Member ID - m1 doesn't exist
		assertTrue(isDeleted);
				
		//--- Delete m2
		//Normal - Test Member List Size is 0 after Deleting Member - m2
		//Normal - Test Member - C002 doesn't exist in the Member List
		isDeleted = C206_CaseStudy.deleteMember(memberList, "m2");            
		assertEquals(0, memberList.size());
		assertFalse(memberList.contains(m2));
						
		//Error - Test Member ID - m2 exist in the Member List
		assertTrue(isDeleted);
	}
	
	@Test
	public void updateMemberTest() {
		//Boundary - Test Valid Member List to Add Members To
		assertNotNull(memberList);
						
		//Normal - Test Member List Size is 0
		//Normal - Test Member List Size is 2 after Adding 2 Members
		assertEquals(0, memberList.size());
		memberList.add(m1);  
		memberList.add(m2);  
		assertEquals(2, memberList.size());
			
	}
	
	@Test
	public void searchMembersByCountryTest() {
		//Boundary - Test Valid Course List to Retrieve Members From
		assertNotNull(memberList);
						
		//Normal - Test Member List Size is 0
		assertEquals(0, memberList.size());
				
		//Add Member
		memberList.add(m1);  
		memberList.add(m2);  
						
		//--- Search searchMember
		//Boundary - Test Member Output contains the Member Header when No Result for that country
		String members = C206_CaseStudy.retrieveMembersByCountry(memberList, searchCountry03);
		String expectedMembers = String.format("%-30s %-10s %-10s %-20s %-15s %-20s", "Name", "Gender", "Mobile", "Email", "Date of Birth", "Country");
		assertEquals(expectedMembers, members);
						
		//Normal - Test Member List Size is 2 after Adding 2 Members
		memberList.add(m1);  
		memberList.add(m2);  
		assertEquals(2, memberList.size());
						
		//--- Search searchCountry01
		//Normal - Test Member Output contains the Member Header plus the Members Information when 1 result for that country
		members = C206_CaseStudy.retrieveMembersByCountry(memberList, searchCountry01);
		expectedMembers += String.format("%-30s %-10s %-10d %-20s %-15s %-20s\n", "Anna Bell", 'F', 92225555, "annabell@gmail.com", "06072000", "Australia");
		assertEquals(expectedMembers, members);
				
		//--- Search searchCountry02
		//Normal - Test Member Output contains the Member Header plus the Members Information when 1 result for that country
		members = C206_CaseStudy.retrieveMembersByCountry(memberList, searchCountry02);
		expectedMembers = String.format("%-30s %-10s %-10s %-20s %-15s %-20s", "Name", "Gender", "Mobile", "Email", "Date of Birth", "Country");
		expectedMembers += String.format("%-30s %-10s %-10d %-20s %-15s %-20s\n", "Mike Chang", 'M', 93338888, "mikechang@gmail.com", "21031999", "Singapore");
		assertEquals(expectedMembers, members);
				
	}
	
	// member 2 - caven
	@Test
	public void addCategoryTest() {
		
		// Error:Category list is not null, so that admin can add a new category -
		// boundary
		assertNotNull("Check if  Category arraylist is empty", categoryList);
		// Normal: check if a valid category name and category description is provided,
		// new course category should be added
		categoryList.add(c1);
		categoryList.add(c2);
		C206_CaseStudy.AddCourseCategory(categoryList);
		
		assertSame("Check that Category 1 is added", c1, categoryList.get(0));
		assertSame("Check that Category 2 is added", c2, categoryList.get(1));
		// test for error: when duplicate category name is added
		Boolean can = categoryList.add(new Category("Math", "hello"));
		assertFalse("Test if an same category name can be added?", can);
		// test boundary: can add more than 1 category into system
		int size = categoryList.size();
		assertEquals("check if size of list can be more than 1", 2, size);
	}

	@Test
	public void viewAllCategoryTest() {
		categoryList.add(c1);
		categoryList.add(c2);
		// Normal condition: test if view can work
		C206_CaseStudy.viewAllCourseCategory(categoryList);
		// Error: error in viewing or retrieving Course Category
		fail("nothing can be seen");
	}

	@Test
	public void deleteACategoryTest() {
		categoryList.add(c1);
		categoryList.add(c2);
		// Normal Condition: test if delete works in case of deleting "Math" Category
		C206_CaseStudy.DeleteACourseCategory(categoryList);
		assertEquals("check if the first Category math has been deleted", categoryList.get(0).getName(),
				"English Life");
		// Error:test if list is not null
		assertNotNull(categoryList);
		// test boundary: no more to delete
		int size = categoryList.size();
		assertEquals("check if size of list is 0", 0, size);
	}
	
	@Test
	public void UpdateCategoryDescriptionTest() {
		categoryList.add(c1);
		categoryList.add(c2);
		// Normal Condition: test if update  works when Math description is chose to be changed
		C206_CaseStudy.UpdateCourseCategory(categoryList);
		assertNotEquals("check if the first Category math has been deleted","All about solving painful question" ,
				categoryList.get(0).getDescription());
		// Error:test if no such category description is still the same , which shouldn't happen if no error
		assertEquals("check if category description is still the same  in category list","All about solving painful question",categoryList.get(0).getDescription());
		// test boundary: no more to update
		int size = categoryList.size();
		assertEquals("check if size of list is 0", 0, size);
	}
	*/
	
	
	//member 3 - daryl
		@Test
		public void retrieveCoursesTest() {
			// Boundary - Test Valid Course List to Retrieve Courses From
			assertNotNull(courseList);
					
			// Normal - Test Course List Size is 0
			assertEquals(0, courseList.size());
					
			// VIEW ALL COURSES
			// Boundary - Test Course Output Contains the Course Header when Course List is Empty (Size is 0)
			String courses = C206_CaseStudy.retrieveCourses(courseList);
			String expectedCourses = String.format("%-10s %-20s %-20s %-20s %-20s %-20s\n", "Id", "Title", "Category", "Decription", "Duration", "Pre-requisite Course");
			assertEquals(expectedCourses, courses);
					
			// Normal - Test Course List Size is 2 after Adding 2 Courses
			courseList.add(c001);  
			courseList.add(c002);  
			assertEquals(2, courseList.size());
					
			// Normal - Test Course Output Contains the 2 Formatted Course Information + Course Header after Adding 2 Courses
			courses = C206_CaseStudy.retrieveCourses(courseList);
			expectedCourses += String.format("%-10s %-20s %-20s %-20s %-20.2f %-20s\n", "C001", "Software Devpt", "Infocomm", "Develo..", 120.00, "Math");
			expectedCourses += String.format("%-10s %-20s %-20s %-20s %-20.2f %-20s\n", "C002", "Applied Chem", "Applied Science", "pharmace..", 120.00, "Chemistry");
			assertEquals(expectedCourses, courses);
					
			// VIEW A COURSE
			// --- View C001
			// Normal - Test Course Output Contains Course Header + Course Information of the Course Entered
			Course courseId = C206_CaseStudy.findCourse(courseList, "C001");
			String course = C206_CaseStudy.retrieveCourse(courseList, courseId);
			String expectedCourse = String.format("%-10s %-20s %-20s %-20s %-20s %-20s\n", "Id", "Title", "Category", "Decription", "Duration", "Pre-requisite Course");
			expectedCourse += String.format("%-10s %-20s %-20s %-20s %-20.2f %-20s\n", "C001", "Software Devpt", "Infocomm", "Develo..", 120.00, "Math");
			assertEquals(expectedCourse, course);
			
			// --- View C002
			// Normal - Test Course Output Contains Course Header + Course Information of the Course Entered 
			courseId = C206_CaseStudy.findCourse(courseList, "C002");
			course = C206_CaseStudy.retrieveCourse(courseList, courseId);
			expectedCourse = String.format("%-10s %-20s %-20s %-20s %-20s %-20s\n", "Id", "Title", "Category", "Decription", "Duration", "Pre-requisite Course");
			expectedCourse += String.format("%-10s %-20s %-20s %-20s %-20.2f %-20s\n", "C002", "Applied Chem", "Applied Science", "pharmace..", 120.00, "Chemistry");
			assertEquals(expectedCourse, course);
			
			// --- View C003 (non-existent)
			// Error - Test Output is "Course not found" when the Course is not found in Course List
			courseId = C206_CaseStudy.findCourse(courseList, "C003");
			course = C206_CaseStudy.retrieveCourse(courseList, courseId);
			expectedCourse = "Course not found.";
			assertEquals(expectedCourse, course);
			
		}
				
				
		@Test
		public void addCourseTest() {
			// Boundary - Test Valid Course List to Add Courses To
			assertNotNull(courseList);
					
			// Normal - Test Course List Size is 0
			assertEquals(0, courseList.size());
					
			// --- Add C001
			// Normal - Test Course List Size is 1 after Adding 1 Course - C001
			// Normal - Test Course - C001 is the First Course of the Course List
			// Normal - Test it Displays Message After Successful Addition
			categoryList.add(c3);                                                         //add course category
			String result = C206_CaseStudy.doAddCourse(courseList, categoryList, c001);   //add course
			assertEquals(1, courseList.size());
			assertSame(c001, courseList.get(0));
			assertEquals("Course added.", result);
					
			// --- Add C002
			// Normal - Test Course List Size is 2 after Adding 1 Course - C002
			// Normal - Test Course - C002 is the Second Course of the Course List
			// Normal - Test it displays Message after Successful Addition
			categoryList.add(c4);                                                        //add another course category
			result = C206_CaseStudy.doAddCourse(courseList, categoryList, c002);         //add another course
			assertEquals(2, courseList.size());
			assertSame(c002, courseList.get(1));
			assertEquals("Course added.", result);
				
			// --- Add C001
			// Normal - Test Course List Size is still 2 after Failed Addition of the new Course 
			// Normal - Test Course - C002 is still the Second Course of the Course List
			result = C206_CaseStudy.doAddCourse(courseList, categoryList, c001);         //add same course
			assertEquals(2, courseList.size());
			assertSame(c002, courseList.get(1));
			
			// Error - Test Course ID - C003 doesn't exist and display Message
			assertEquals("Course ID not unique.", result);
					
			// --- Add C003
			// Normal - Test Course List Size is still 2 after Failed Addition of the new Course 
			// Normal - Test Course - C002 is still the Second Course of the Course List
			result = C206_CaseStudy.doAddCourse(courseList, categoryList, c003);         //add another course
			assertEquals(2, courseList.size());
			assertSame(c002, courseList.get(1));
					
			// Error - Test Category Name doesn't exist in the Category List and display Message
			assertEquals("Category not found.", result);

		}
				
		@Test
		public void deleteCourseTest() {
			// Boundary - Test Valid Course List to Delete Courses From
			assertNotNull(courseList);
					
			// Normal - Test Course List Size is 0
			// Normal - Test Course List Size is 2 after Adding 2 Courses
			assertEquals(0, courseList.size());
			courseList.add(c001);  
			courseList.add(c002);  
			assertEquals(2, courseList.size());
					    
			// --- Delete C001
			// Normal - Test Course List Size is 1 after Deleting Course - C001
			// Normal - Test Course - C001 doesn't exist in the Course List
			// Normal - Test it displays Message after Successful Deletion
			String result = C206_CaseStudy.doDeleteCourse(courseList, "C001");            
			assertEquals(1, courseList.size());
			assertFalse(courseList.contains(c001));
			assertEquals("Course deleted.", result);
					
			// --- Delete C002
			// Normal - Test Course List Size is 0 after Deleting Course - C002
			// Normal - Test Course - C002 doesn't exist in the Course List
			result = C206_CaseStudy.doDeleteCourse(courseList, "C002");            
			assertEquals(0, courseList.size());
			assertFalse(courseList.contains(c002));
			assertEquals("Course deleted.", result);
							
			// --- Delete C003
			// Normal - Test Course List Size is still 0 after Failed Deletion
			result = C206_CaseStudy.doDeleteCourse(courseList, "C003");            
			assertEquals(0, courseList.size());
			
			// Error - Test Course ID - C003 doesn't exist and display Message
			assertEquals("Course not found.", result);
		}
				
		@Test
		public void updateCourseTest() {
			// Boundary - Test Valid Course List to Add Courses To
			assertNotNull(courseList);
							
			// Normal - Test Course List Size is 0
			// Normal - Test Course List Size is 2 after Adding 2 Courses
			assertEquals(0, courseList.size());
			courseList.add(c001);  
			courseList.add(c002);  
			assertEquals(2, courseList.size());
					
			// --- Update C001
			// Normal - Test Course - C001 have the same information after Update
			// Normal - Test it displays Message after Successful update
			String result = C206_CaseStudy.doUpdateCourse(courseList, "C001", newCourseinfo01);  
			assertEquals(courseList.get(0).getTitle(),                        newCourseinfo01[0]);
			assertEquals(courseList.get(0).getCategory(),                     newCourseinfo01[1]);
			assertEquals(courseList.get(0).getDescription(),                  newCourseinfo01[2]);
			assertEquals(String.valueOf(courseList.get(0).getDuration()),     newCourseinfo01[3]);
			assertEquals(courseList.get(0).getPreCourse(),                    newCourseinfo01[4]);
			assertEquals("Course updated.", result);
					
			//--- Update C002
			//Normal - Test Course - C002 have the same information after Update
			result = C206_CaseStudy.doUpdateCourse(courseList, "C002", newCourseinfo02);  
			assertEquals(courseList.get(1).getTitle(),                        newCourseinfo02[0]);
			assertEquals(courseList.get(1).getCategory(),                     newCourseinfo02[1]);
			assertEquals(courseList.get(1).getDescription(),                  newCourseinfo02[2]);
			assertEquals(String.valueOf(courseList.get(1).getDuration()),     newCourseinfo02[3]);
			assertEquals(courseList.get(1).getPreCourse(),                    newCourseinfo02[4]);
			assertEquals("Course updated.", result);
			
			//--- Update C003
			//Error - Test Course ID C003 doesn't exist in the Course List 
			result = C206_CaseStudy.doUpdateCourse(courseList, "C003", newCourseinfo02);     //non-existent course
			assertEquals("Course not found.", result);             
			
			//--- Update C002
			//Normal - Test Course - C002 still have the same information after Failed Update
			result = C206_CaseStudy.doUpdateCourse(courseList, "C002", newCourseinfo03);      
			assertEquals(courseList.get(1).getTitle(),                        newCourseinfo02[0]);
			assertEquals(courseList.get(1).getCategory(),                     newCourseinfo02[1]);
			assertEquals(courseList.get(1).getDescription(),                  newCourseinfo02[2]);
			assertEquals(String.valueOf(courseList.get(1).getDuration()),     newCourseinfo02[3]);
			assertEquals(courseList.get(1).getPreCourse(),                    newCourseinfo02[4]);
			
			//Error - Test new course information is/are empty 
			assertEquals("Empty field/s found.", result);
		}
				
		@Test
		public void searchCourseByCatTest() {
			//Boundary - Test Valid Course List to Retrieve Courses From
			assertNotNull(courseList);
							
			//Normal - Test Course List Size is 0
			assertEquals(0, courseList.size());
					
			//Add Categories
			categoryList.add(c3);  
			categoryList.add(c4);  
							
			//--- Search searchCat03
			//Boundary - Test Course Output contains the Course Header when No Result for that Category
			String courses = C206_CaseStudy.retrieveCoursesByCat(courseList, searchCat03);
			String expectedCourses = String.format("%-10s %-20s %-20s %-20s %-20s %-20s\n", "Id", "Title", "Category", "Decription", "Duration", "Pre-requisite Course");
			assertEquals(expectedCourses, courses);
							
			//Normal - Test Course List Size is 2 after Adding 2 Courses
			courseList.add(c001);  
			courseList.add(c002);  
			assertEquals(2, courseList.size());
							
			//--- Search searchCat01
			//Normal - Test Course Output contains the Course Header plus the Courses Information when 1 result for that Category
			courses = C206_CaseStudy.retrieveCoursesByCat(courseList, searchCat01);
			expectedCourses += String.format("%-10s %-20s %-20s %-20s %-20.2f %-20s\n", "C001", "Software Devpt", "Infocomm", "Develo..", 120.00, "Math");
			assertEquals(expectedCourses, courses);
					
			//--- Search searchCat02
			//Normal - Test Course Output contains the Course Header plus the Courses Information when 1 result for that Category
			courses = C206_CaseStudy.retrieveCoursesByCat(courseList, searchCat02);
			expectedCourses = String.format("%-10s %-20s %-20s %-20s %-20s %-20s\n", "Id", "Title", "Category", "Decription", "Duration", "Pre-requisite Course");
			expectedCourses += String.format("%-10s %-20s %-20s %-20s %-20.2f %-20s\n", "C002", "Applied Chem", "Applied Science", "pharmace..", 120.00, "Chemistry");
			assertEquals(expectedCourses, courses);
					
		}
/*
	//member 4 - sabrina
	@Test
	public void addCourseScheduleTest() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid CourseSchedule arraylist to add to", scheduleList);
					
		//Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addCourseSchedule(scheduleList);
		scheduleList.add(cs1);
		assertEquals("Test if that scheduleList size is 1?", 1, scheduleList.size());
					
		//The item just added is as same as the first item of the list
		assertSame("Test that course schedule added is same as 1st item of the list?", cs1, scheduleList.get(0));
					
		//Add another item. test The size of the list is 2?
		C206_CaseStudy.addCourseSchedule(scheduleList);
		scheduleList.add(cs2);
		assertEquals("Test that scheduleList size is 2?", 2, scheduleList.size());

	}
	@Test
	public void retrieveAllCourseScheduleTest() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid CourseSchedule arraylist to add to", scheduleList);
			
		//test if the list of schedules retrieved is empty
		String allCourseSchedule = C206_CaseStudy.retrieveCourseSchedule(scheduleList);
		String testOutput = "";
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCourseSchedule);
					
		//Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addCourseSchedule(scheduleList);
		scheduleList.add(cs1);
		scheduleList.add(cs2);
		assertEquals("Test if that Camcorder arraylist size is 2?", 2, scheduleList.size());
			
		//test if the expected output string same as the list of schedules retrieved from the main menu
		allCourseSchedule = C206_CaseStudy.retrieveCourseSchedule(scheduleList);

		testOutput = String.format("%-20s $%-10.2f %-20s %-20s %-15s\n","DBIS1", 20, "2020-08-20 12:15", "2020-08-20 13:15", "E22K");
		testOutput += String.format("%-20s $%-10.2f %-20s %-20s %-15s\n","DBIM1", 10, "2020-08-21 12:15", "2020-08-21 13:15", "E22M");
		
		assertEquals("Check that ViewAllCourseSchedulelist", testOutput, allCourseSchedule);
	}
	@Test
	public void deleteCourseScheduleTest() {
		
		//test if after deleting, the list is 0
		C206_CaseStudy.addCourseSchedule(scheduleList);
		scheduleList.add(cs1);
		String testOutput = String.format("%-20s $%-10.2f %-20s %-20s %-15s\n","DBIS1", 20, "2020-08-20 12:15", "2020-08-20 13:15", "E22K");
		
		C206_CaseStudy.deleteCourseSchedule(scheduleList);
		assertEquals("Check that scheduleList is deleted", testOutput, scheduleList);
	}
	//member 4 ends
	
	// member 5 - rongxin
		@Test
		public void regScheTest() {

			// reglist is not null, so that can add a new item
			assertNotNull("Test if there is valid a arraylist to add to", reglist);

			// Given an empty list, after adding 1 item, the size of the list is 1
			
			//normal
			C206_CaseStudy.regSche(reglist, r1);
			assertEquals("Test if that reg arraylist size is 1?", 1, reglist.size());
			// The reg info just added is as same as the first item of the list
			assertSame("Test that Camcorder is added same as 1st item of the list?", r1, reglist.get(0));
			// Add another item. test The size of the list is 2?
			C206_CaseStudy.regSche(reglist, r2);
			assertEquals("Test that Camcorder arraylist size is 2?", 2, reglist.size());
			
			//Error
			C206_CaseStudy.regSche(reglist, f);
			assertEquals("Check if the false input being added into the list", 2, reglist.size());
			
			//Boundary
			C206_CaseStudy.regSche(reglist, rf1);
			assertEquals("Test that Camcorder arraylist size is 3 while the similar recored"
					+ " being inserted", 3, reglist.size());
		}

		@Test
		public void viewAllrTest() {
			//Normal
			// reglist is not null, so that can add a new item
			assertNotNull("Test if there is valid a arraylist to add to", reglist);
			// test if the list of registerSchedule retrieved from the CaseStudy is empty
			String allr = C206_CaseStudy.viewAllr(reglist);
			String testOutput = String.format("%-30s %-20s %-20s %-15s %-20s\n", "Registration Number", "Schedule ID",
					"Member Email", "Status", "Registerion Date");
			assertEquals("Check that if it is equal", testOutput, allr);
			// Given an empty list, after adding 2 items, test if the size of the list is 2
			C206_CaseStudy.regSche(reglist, r1);
			assertEquals("Test that Camcorder arraylist size is 1?", 1, reglist.size());
			
			
			

		}

		public void delrTest() {
			// reglist is not null, so that can add a new item
						assertNotNull("Test if there is valid a arraylist to add to", reglist);						
						//normal
						// add
						C206_CaseStudy.regSche(reglist, r1);
						// after delete, the size of the list should remain one
						C206_CaseStudy.delr(reglist);
						assertEquals("Test if that reg arraylist size is 1?", 1, reglist.size());
						// after delete, the size of the list should remain two if another is add while the status is set to deleted
						C206_CaseStudy.regSche(reglist, r1);
						assertEquals("Test if that reg arraylist size is 2?", 2, reglist.size());
						// check for status for both r1 and r2
						String x = reglist.get(0).status;
						assertSame("Test has the record status setted to deleted", x, "Deleted");
						String xx = reglist.get(1).status;
						assertSame("Test has the record status setted to deleted", xx, "Deleted");
						
						
						
		}
	*/
	@After
	public void tearDown() throws Exception {
		//member 1 - Clarence
		m1 = null;
		m2 = null;
		memberList = null;
		searchCountry01 = null;
		searchCountry02 = null;
		searchCountry03 = null;
		
		// member 2 -caven
		c1 = null;
		c2 = null;
		categoryList = null;
		
		
		//member 3 - daryl
	    c3 = null;
	    c4 = null;
		c001 = null;
		c002 = null;
		c003 = null;
		courseList = null;
		searchCat01 = null;
		searchCat02 = null;
		searchCat03 = null;
		newCourseinfo01 = null;
		newCourseinfo02 = null;
		newCourseinfo03 = null;

		// member 4 - sabrina
		cs1 = null;
		cs2 = null;
		scheduleList = null;
		
		//member 5 -Rongxin
		r1 = null;
		r2 = null;
		reglist = null;
		
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ",  true);
	}

}
