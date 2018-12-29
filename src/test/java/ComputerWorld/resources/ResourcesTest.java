package ComputerWorld.resources;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ComputerWorld.main.baseClass;
import ComputerWorld.pages.mainResourcesPage;

public class ResourcesTest extends baseClass {
	mainResourcesPage main;

	public ResourcesTest() {
		super();
	}

	@BeforeTest
	public void Setup() {
		initialization();
		main = new mainResourcesPage();
	}

	@Test(priority = 1, description = " Validating Resource Library")
	public void ResourceLibraryTest() {
		main.ResourcesClick();
		driver.navigate().back();
	}

	@Test(priority = 2, description = "Validating Filter By Topic in the Resource Library")
	public void FilterByTopicTest() throws InterruptedException {
		main.FilterByTopic();
	}

	@Test(priority = 3, description = "Validating Filter By Sponser in the Resource Library")
	public void FilterBySponsorTest() throws InterruptedException {

		main.FilterBySponsor();
	}

	@Test(priority = 4, description = "Validating Filter By Resource Type in the Resource Library")
	public void FilterByResourceTypeTest() throws InterruptedException {

		main.FilterByResourceType();
	}

	@Test(priority = 5, description = "Validating Blank  Search in the Resource Library")
	public void BlankSearchResourceTest() {
		main.BlankSearch();
	}

	@Test(priority = 6, description = "Validating Valid  Search in the Resource Library")
	public void PositiveSearchResourceTest() {
		main.PositiveSearch();
	}

	@Test(priority = 7, description = "Validating InValid  Search in the Resource Library")
	public void NegativeSearchResourceTest() {
		main.NegativeSearch();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
