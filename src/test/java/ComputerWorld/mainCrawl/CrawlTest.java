package ComputerWorld.mainCrawl;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ComputerWorld.main.baseClass;
import ComputerWorld.pages.mainCrawlPages;

public class CrawlTest extends baseClass {
	mainCrawlPages mcp;
	public CrawlTest() {
		super();
		
	}
	
	@BeforeTest
	public void Setup() {
		initialization();
		mcp = new mainCrawlPages();
	}
	
	@Test(priority=1,description=" Validating all the article link under the main-crawl section")
	public void mainCrawlLinkTest() {
		mcp.FindMainCrawlLink();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
