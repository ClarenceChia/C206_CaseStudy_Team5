import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	//member2-caven
	private Category c1;
	private Category c2;
	private ArrayList<Category> categoryList;
	

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
