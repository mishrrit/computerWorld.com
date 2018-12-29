package ComputerWorld.mainCarousel;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ComputerWorld.main.baseClass;
import ComputerWorld.pages.homePage;
import ComputerWorld.pages.mainCaraousel;

public class mainCarouselTest extends baseClass {
	mainCaraousel main;
	homePage home;
	public mainCarouselTest() {
		super();
	}
	
	@BeforeTest
	public void Setup() {
		initialization();
		main = new mainCaraousel();
		home = new homePage();
		//home.closeAD();
		
	}
	
	@Test(priority=1,description ="The Given Method will test the fucntionality of the three panels under the main carousel")
	public void mainCarouselExternalLinkTest() throws InterruptedException {
		main.carouselDisplay();
			
	}
	
	@Test(priority=2,description="The Given test will test the navigation of the panel to left-right-left and verifying the radio button selection ")
	public void mainCarouselFunctionalityTest() {
		
		main.mainCarouselfucntionality();
	}
	
	@Test(priority=3,description=" Validating the different links under the IT in Depth section")
	public void ITinDepthArticlesTest() {
		main.ItinDepthArticles();
		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
