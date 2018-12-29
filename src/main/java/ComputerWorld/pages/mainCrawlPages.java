package ComputerWorld.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ComputerWorld.main.baseClass;

public class mainCrawlPages extends baseClass {
	private String xpathroot ="//div[@class='crawl']/div";
	private String figure ="//figure/a";
	private String HyperLink = "/div/h3/a";
	private String HyperLinkText = "/div/h3/a";
	private String BlogText= "/div/p";
	private String Blogger="//div[2]/div[@class='byline']";
	private String BlogName="//div[2]/div[@class='blogname']";
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	public mainCrawlPages() {
		PageFactory.initElements(driver, this);
	}

	//@FindBy(xpath = "//div[@class='crawl']/div[contains(@class,'river-well')]")
	@FindBy(xpath = "//div[@class='crawl']/div")
	List<WebElement> crawl;

	@FindBy(xpath = "//div[contains(@class,'river-well with-img blogpost')]")
	WebElement BlogPost;

	//@FindBy(xpath = "//div[contains(@class,'river-well with-img blogpost')]//figure/a")
	@FindBy(xpath = ".//figure/a")
	WebElement BlogArticleLink;

	@FindBy(xpath = "//div[contains(@class,'river-well with-img blogpost')]//div[@class='blog-byline-wrapper']/div[contains(@class,'byline')]")
	WebElement Blogger1;

	@FindBy(xpath = "//div[contains(@class,'river-well with-img blogpost')]//div[@class='blog-byline-wrapper']/div[contains(@class,'blogname')]/a")
	WebElement BlogName1;

	@FindBy(xpath = "//div[contains(@class,'river-well with-img blogpost')]/div/h3/a")
	WebElement BlogArticle;
	
	//@FindBy(xpath = "//div[@class='river-well with-img']//figure/a")
	@FindBy(xpath = ".//figure/a")
	WebElement NonBlogArticleLink;
	
	@FindBy(xpath = "//div[@class='river-well with-img']/div/h3/a")
	WebElement NonBlogArticle;
	
	@FindBy(xpath = "//div[@class='river-well with-img']/div/p")
	WebElement NotaBlog;

	@FindBy(xpath = "//div[contains(@class,'river-well with-img')]")
	WebElement NonBlogPost;
	
	@FindBy(xpath= "//h1[@itemprop='headline']")
	WebElement headLine;

	public void FindMainCrawlLink() {
		 
		List<WebElement> list = crawl;
		
		Iterator<WebElement> it = list.iterator();
		int count =0;
		
		while (it.hasNext()) {
			int i=count+1;
			
			System.out.println("########## "+count+" ########");
			String xpath = xpathroot+"["+i+"]";
			
			if (it.next().getAttribute("class").contains("blogpost")) {
				getBlogPostDetails(xpath);
			} else {
				getPostDetails(xpath);
			}
			count++;
		}
	}

	public void getPostDetails(String xpath) {
		//js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(xpath+HyperLink)));
		//js.executeScript("scroll(0,600)");
		String hyper = driver.findElement(By.xpath(xpath+figure)).getAttribute("href");		
		System.out.println("hyper is "+hyper);
		String NonBlogArticle = driver.findElement(By.xpath(xpath+HyperLink)).getAttribute("href");
		System.out.println(" Article Link is " + NonBlogArticle);
		String NonBlogArticleText = driver.findElement(By.xpath(xpath+HyperLinkText)).getText();
		System.out.println("Article displayed text is " + NonBlogArticleText);
		String NonBlogArticleText1 = driver.findElement(By.xpath(xpath+BlogText)).getText();
		System.out.println(" If not a blog, the text would have been : " + NonBlogArticleText1);
		
		
		System.out.println("\n\n");
	}

	public void getBlogPostDetails(String xpath) {
		//js.executeScript("scroll(0,600)");
		//js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(xpath+HyperLink)));		
		String hyper = driver.findElement(By.xpath(xpath+figure)).getAttribute("href");		
		System.out.println("hyper is "+hyper);
		String BlogArticle = driver.findElement(By.xpath(xpath+HyperLink)).getAttribute("href");
		System.out.println("Blog Article Link is " + BlogArticle);
		String BlogArticleText = driver.findElement(By.xpath(xpath+HyperLinkText)).getText();
		System.out.println(" Blog Article displayed text is " + BlogArticleText);
		String BlogArticleText1 = driver.findElement(By.xpath(xpath+BlogText)).getText();
		System.out.println(" If not a blog, the text would have been : " + BlogArticleText1);
		String BloggerName = driver.findElement(By.xpath(xpath+Blogger)).getText();
		System.out.println("Blogger Name is " + BloggerName);
		String BlogNameText = driver.findElement(By.xpath(xpath+BlogName)).getText();
		System.out.println(" BlogName is : " + BlogNameText);
		
		/*driver.findElement(By.xpath(xpath+HyperLink)).click();
		WebDriverWait wait = new WebDriverWait(driver,8);
		wait.until(ExpectedConditions.elementToBeClickable(headLine));
		
		String HeadLine = headLine.getText();
		Assert.assertEquals(HeadLine, BlogArticleText);
		System.out.println(" Webpage is Verified");
		driver.navigate().back();*/
		System.out.println("\n\n");

	}

}
