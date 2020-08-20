import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	//member2-caven
	private Category c1;
	private Category c2;
	private ArrayList<Category> categoryList;
	//rongxin part
			ArrayList<registerSchedule> reglist= new ArrayList<registerSchedule>();
				String rn = Helper.readString("Enter a registration number > ");
				String sid = Helper.readString("Enter a course schedule id > ");
				String memail = Helper.readString("Enter your email > ");
				Date rdate = Helper.readDate("Enter a today's date > ");
				
				registerSchedule newReg = new registerSchedule(rn, sid, memail, rdate);
				//ends here


	@Before
	public void setUp() throws Exception {
		//member 2- caven
			categoryList= new ArrayList<Category>();
		 c1= new Category("Math","All about solving painful question");
		 c2= new Category("English Life","All about reading english history");
		 categoryList.add(c1);
		 categoryList.add(c2);
		 
		
	}
	
	
	// member 2 - caven
	@Test
	public void addCategoryTest() {
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
		// Normal condition: test if view can work
		C206_CaseStudy.viewAllCourseCategory(categoryList);
		//Error: error in viewing or retrieving Course Category
		fail("nothing can be seen");
		
		
	}
	@Test
	public void deleteACategory() {
		//Normal Condition: test if delete works in case of deleting "Math"Category
		C206_CaseStudy.DeleteACourseCategory(categoryList);
		assertEquals("check if the first Category math has been deleted",categoryList.get(0).getName(),"English Life");
		//Error:test if list is not null 
		assertNotNull(categoryList);
		//test boundary: no more to delete
		int size=categoryList.size();
		assertEquals("check if size of list is 0",0,size);
		
		
	}@Test
	public void regScheTest() {
		
		// reglist is not null, so that can add a new item
				assertNotNull("Test if there is valid a arraylist to add to", reglist);
				
				//Given an empty list, after adding 1 item, the size of the list is 1
				
				C206_CaseStudy.regSche(reglist,newReg);		
				assertEquals("Test if that reg arraylist size is 1?", 1, reglist.size());
				
				//The reg info just added is as same as the first item of the list
				assertSame("Test that Camcorder is added same as 1st item of the list?", newReg, reglist.get(0));
				
				//Add another item. test The size of the list is 2?
				C206_CaseStudy.regSche(reglist,newReg);	
				assertEquals("Test that Camcorder arraylist size is 2?", 2, reglist.size());
	}
	@Test
	public void viewAllrTest() {
		// reglist is not null, so that can add a new item
			assertNotNull("Test if there is valid a arraylist to add to", reglist);
			
				//test if the list of registerSchedule retrieved from the CaseStudy is empty
						String allr= C206_CaseStudy.viewAllr(reglist);
						String testOutput =String.format("%-30s %-20s %-20s %-15s %-20s\n", "Registration Number", "Schedule ID", "Member Email",
				"Status", "Registerion Date");
						assertEquals("Check that ViewAllCamcorderlist", testOutput, allr);
						
				//Given an empty list, after adding 2 items, test if the size of the list is 2
						C206_CaseStudy.regSche(reglist,newReg);	
						assertEquals("Test that Camcorder arraylist size is 1?", 1, reglist.size());
						
				
		
	}
	public void delrTest() {
		// reglist is not null, so that can add a new item
					assertNotNull("Test if there is valid a arraylist to add to", reglist);
					
			 		//add
					C206_CaseStudy.regSche(reglist,newReg);
					//after delete, the size of the list should remain one
					assertEquals("Test if that reg arraylist size is 1?", 1, reglist.size());
					//after delete, the size of the list should remain two if another
					C206_CaseStudy.regSche(reglist,newReg);
					assertEquals("Test if that reg arraylist size is 2?", 2, reglist.size());
					
					String x = reglist.get(0).status;
					assertSame("Test has the record status setted to deleted", 
							x,"Deleted");
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
