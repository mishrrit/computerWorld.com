package ComputerWorld.homePage;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ComputerWorld.main.baseClass;
import ComputerWorld.pages.homePage;

public class homePageTest extends baseClass {

	homePage home;
	public homePageTest() {
		super();
	}

	@BeforeTest
	public void Setup() {
		initialization();
		home = new homePage();
	}

	@Test(priority =1)
	public void homePageAttributes() {

		Assert.assertEquals(driver.getTitle(), "IT news, careers, business technology, reviews | Computerworld","Title mismatch");
		System.out.println(" Title of the webpage is " + driver.getTitle());

	}

	@Test(priority =2)
	public void getLinks() throws ClientProtocolException, IOException {
		//home.closeAD();
		home.LinksValidation();

	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
