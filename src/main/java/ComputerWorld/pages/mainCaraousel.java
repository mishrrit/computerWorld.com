package ComputerWorld.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import ComputerWorld.main.baseClass;

public class mainCaraousel extends baseClass {
	WebDriverWait wait;

	public mainCaraousel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='homepageCarousel']/div/div/a[2]")
	WebElement leftCarouselclick;

	@FindBy(id = "slick-slide20")
	WebElement leftradio;

	@FindBy(xpath = "//*[@id='homepageCarousel']/div/div/a[3]")
	WebElement centerCarouselclick;

	@FindBy(id = "slick-slide21")
	WebElement centerradio;

	@FindBy(xpath = "//*[@id='homepageCarousel']/div/div/a[1]")
	WebElement rightCarouselclick;

	@FindBy(id = "slick-slide22")
	WebElement rightradio;

	@FindBy(id = "homepageCarousel")
	WebElement mainCarousel;

	@FindBy(xpath = "//div[@class='feature-carousel-wrapper']")
	WebElement mainCar;

	@FindBy(xpath = "//i[@class='ss-icon ss-navigateright']")
	WebElement nextArrow;

	@FindBy(xpath = "//i[@class='ss-icon ss-navigateleft']")
	WebElement previousArrow;

	@FindBy(xpath = "//h1[@itemprop='headline']")
	WebElement headline;

	@FindBy(xpath = "//h1[@itemprop='headline']//preceding-sibling::div/span")
	WebElement Insider;

	@FindBy(xpath = "//div[text()='IT In-Depth']//following::ul/li/h4/a")
	List<WebElement> ItinDepth;

	public void carouselDisplay() {

		HashMap<WebElement, WebElement> map = new HashMap<WebElement, WebElement>();

		map.put(leftCarouselclick, leftradio);
		map.put(centerCarouselclick, centerradio);
		map.put(rightCarouselclick, rightradio);

		for (Entry<WebElement, WebElement> map1 : map.entrySet()) {
			CarouselAttributes(map1.getKey(), map1.getValue());

		}

	}

	private void CarouselAttributes(WebElement ele, WebElement radio) {
		String href = ele.getAttribute("href");
		System.out.println("Href asscoicated with the mmainCarousel is " + href);
		WebDriverWait waitforcenter = new WebDriverWait(driver, 10);
		waitforcenter.until((ExpectedConditions.elementToBeClickable(ele)));
		if (ele.isDisplayed()) {
			System.out.println(" element is displayed ");
		}

		ele.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlToBe(href));

		if (href.contains(driver.getCurrentUrl())) {
			Assert.assertTrue(true, "");
			System.out.println("Web Page is opened " + href);
			System.out.println("Headline is " + headline.getText());
		
		} else {
			System.out.println(" Web Page is not opened ");
		}

		driver.navigate().back();
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("Url"));
		System.out.println(" User navigated back to HomePage");

	}

	public void leftCarouselAttributes() throws InterruptedException {

		String href = leftCarouselclick.getAttribute("href");
		System.out.println("Href asscoicated with the Left Panel Carousel is " + href);
		WebDriverWait waitforcenter = new WebDriverWait(driver, 10);
		waitforcenter.until((ExpectedConditions.elementToBeClickable(leftCarouselclick)));
		if (leftCarouselclick.isDisplayed()) {
			System.out.println(" element is displayed ");
		}
		leftCarouselclick.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlToBe(href));

		if (href.contains(driver.getCurrentUrl())) {
			Assert.assertTrue(true);
			System.out.println("Web Page is opened " + href);
		} else {
			System.out.println(" Web Page is not opened ");
		}

		driver.navigate().back();
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("Url"));
		System.out.println(" User navigated back to HomePage");

	}

	public void centerCarouselAttributes() {

		String href = centerCarouselclick.getAttribute("href");
		System.out.println("Href asscoicated with the Center Panel Carousel is " + href);

		WebDriverWait waitforcenter = new WebDriverWait(driver, 10);
		waitforcenter.until((ExpectedConditions.elementToBeClickable(centerCarouselclick)));

		if (centerCarouselclick.isDisplayed()) {
			System.out.println(" element is displayed ");
		}
		centerCarouselclick.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlToBe(href));

		if (href.contains(driver.getCurrentUrl())) {
			Assert.assertTrue(true);
			System.out.println("Web Page is opened " + href);
		} else {
			System.out.println(" Web Page is not opened ");
		}

		driver.navigate().back();
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("Url"));
		System.out.println(" User navigated back to HomePage");
	}

	public void rightCarouselAttributes() {
		String href = rightCarouselclick.getAttribute("href");
		System.out.println("Href asscoicated with the Center Panel Carousel is " + href);
		
		rightCarouselclick.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlToBe(href));

		if (href.contains(driver.getCurrentUrl())) {
			Assert.assertTrue(true);
			System.out.println("Web Page is opened " + href);
		} else {
			System.out.println(" Web Page is not opened ");
		}

		driver.navigate().back();
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("Url"));
		System.out.println(" User navigated back to HomePage");

	}

	public void mainCarouselfucntionality() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(leftCarouselclick));
		Actions action = new Actions(driver);
		action.moveToElement(leftCarouselclick).build().perform();

		if (leftradio.getAttribute("aria-hidden").equalsIgnoreCase("false")) {
			System.out.println("Left radio is selected");
		} else {
			System.out.println("Left radio is not selected");
		}
		WebDriverWait waitforArrow1 = new WebDriverWait(driver, 20);
		waitforArrow1.until(ExpectedConditions.elementToBeClickable(nextArrow));

		action.click(nextArrow).build().perform();

		if (centerradio.getAttribute("aria-hidden").equalsIgnoreCase("false")) {
			System.out.println("Center radio is selected");
		} else {
			System.out.println("Center radio is not selected");
		}

		WebDriverWait waitforArrow2 = new WebDriverWait(driver, 20);
		waitforArrow2.until(ExpectedConditions.elementToBeClickable(nextArrow));
		action.click(nextArrow).build().perform();

		if (rightradio.getAttribute("aria-hidden").equalsIgnoreCase("false")) {
			System.out.println("Right radio is selected");
		} else {
			System.out.println("Right radio is not selected");
		}
		WebDriverWait waitforArrow3 = new WebDriverWait(driver, 20);
		waitforArrow3.until(ExpectedConditions.elementToBeClickable(nextArrow));

		action.click(nextArrow).build().perform();

		if (leftradio.getAttribute("aria-hidden").equalsIgnoreCase("false")) {
			System.out.println("Navigated back to the home carousel and Left radio is selected");
		} else {
			System.out.println("Navigated back to the hoem carusel and Left radio is not selected");
		}
		
		System.out.println("\n\n");

	}

	public void ItinDepthArticles() {

		List<WebElement> list = driver.findElements(By.xpath("//div[text()='IT In-Depth']//following::ul/li/h4/a"));
		
		Iterator<WebElement> it = list.iterator();

		int count = 1;
		while (it.hasNext()) {

			String url = it.next().getAttribute("href");
			System.out.println("URL Refernced is "+count + ". " + url);
			System.out.println("Article context : "+it.next().getText());
			count++;
		}

	}

}
