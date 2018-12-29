package ComputerWorld.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ComputerWorld.main.baseClass;

public class mainResourcesPage extends baseClass {
	private String ResLib = "//section[@class='bodee']/div/div[contains(@class,'river-well')]";
	private String ResLiblink1 = "//div/div/a[1]";
	//private String ResLiblinkPresentedBy = "//div/div/a[1]";
	private String ResourceLink = "//div/h3";
	private String ResourceDescription = "//div/p";
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//div[@class='promo-wrapper resources-wrapper']//div[@class='hed']/a")
	WebElement Resources;

	@FindBy(xpath = "//div[@class='more']//a[contains(text(),'See All')]")
	WebElement SeeAll;

	@FindBy(xpath = "//section[@class='bodee']/div/div[contains(@class,'river-well')]")
	List<WebElement> ResourcesLibraryLinks;

	@FindBy(xpath = "//section[@role='main']//h1")
	WebElement ResourcesLibHeading;

	@FindBy(xpath = "//section[@role='main']//h2")
	WebElement ResourcesLibSyntax;

	@FindBy(id = "topicSelect")
	WebElement FilterbyTopic;

	@FindBy(xpath = "//select[@id='topicSelect']/option")
	List<WebElement> topics;

	@FindBy(id = "sponsorSelect")
	WebElement FilterbySponsor;

	@FindBy(xpath = "//select[@id='sponsorSelect']/option")
	List<WebElement> sponsors;

	@FindBy(id = "rtypeSelect")
	WebElement FilterbyResourceType;

	@FindBy(xpath = "//select[@id='rtypeSelect']/option")
	List<WebElement> resourceType;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement SubmitButton;

	@FindBy(xpath = "//div[@class='results-count']")
	WebElement ResultsCount;

	@FindBy(xpath = "//a[@class='btn btn-resources']")
	WebElement ClearButton;

	@FindBy(xpath = "//input[@placeholder='Search Resources']")
	WebElement SearchField;

	@FindBy(xpath = "//button[text()='Go']")
	WebElement GoButton;

	public mainResourcesPage() {
		PageFactory.initElements(driver, this);
	}

	public void ResourcesClick() {
		Resources.click();
		ResourceCheck();
	}

	public void ResourceCheck() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButton));
		List<WebElement> list = ResourcesLibraryLinks;

		Iterator<WebElement> iterate = list.iterator();
		int i = 1;
		while (iterate.hasNext()) {
			iterate.next();
			System.out.println("######" + i + "#######");
			String xpath = ResLib + "[" + i + "]";
			ResourceLinkWithoutImage(xpath);
			i++;

		}
	}

	public void ResourceLinkWithoutImage(String xpath) {

		String HyperLink = driver.findElement(By.xpath(xpath + ResLiblink1)).getAttribute("href");
		String HyperLinktext = driver.findElement(By.xpath(xpath + ResLiblink1)).getText();

		/*
		 * try { if (driver.findElement(By.xpath(xpath + ResLiblinkPresentedBy)) !=
		 * null) { String ResourcePresentedBy = driver.findElement(By.xpath(xpath +
		 * ResLiblinkPresentedBy)) .getAttribute("href"); String ResourcePresentedByText
		 * = driver.findElement(By.xpath(xpath + ResLiblinkPresentedBy)).getText();
		 * 
		 * System.out.println("Presented By " + ResourcePresentedBy);
		 * System.out.println("Presented By Text: " + ResourcePresentedByText); } }
		 * catch (org.openqa.selenium.NoSuchElementException nse) {
		 * nse.printStackTrace();
		 * 
		 * }
		 */

		String Resources = driver.findElement(By.xpath(xpath + ResourceLink)).getAttribute("href");
		String Context = driver.findElement(By.xpath(xpath + ResourceDescription)).getText();

		System.out.println(" Hyperlink :" + HyperLink);
		System.out.println(" Text :" + HyperLinktext);

		System.out.println("Resources " + Resources);
		System.out.println("Context :\n" + Context);

		System.out.println("\n\n");

	}

	public void ResourceFilterByTopic() throws InterruptedException {
		Resources.click();
		try {
			List<WebElement> listTopic = topics;
			Iterator<WebElement> iterate = listTopic.iterator();
			int count = 0;
			while (iterate.hasNext()) {

				js.executeScript("return document.readyState").toString().equals("complete");

				Select selectTopic = new Select(FilterbyTopic);

				selectTopic.selectByIndex(count);

				System.out.println("Topic Selected is " + selectTopic.getFirstSelectedOption().getText());

				WebDriverWait wait = new WebDriverWait(driver, 20);

				wait.until(ExpectedConditions.elementToBeClickable(SubmitButton));
				FilterResult();
				count++;
				System.out.println("\n\n");
			}
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			ex.printStackTrace();
		}

	}

	public void ResourceFilterBy(List<WebElement> Filter, WebElement Category) throws InterruptedException {

		try {
			List<WebElement> listTopic = Filter;
			Iterator<WebElement> iterate = listTopic.iterator();
			int count = 0;
			js.executeScript("return document.readyState").toString().equals("complete");
			while (iterate.hasNext()) {
				iterate.next();
				
				js.executeScript("return document.readyState").toString().equals("complete");

				Select selectTopic = new Select(Category);

				selectTopic.selectByIndex(count);

				System.out.println(
						"Topic/Sponsor/Resource Type  Selected is " + selectTopic.getFirstSelectedOption().getText());

				WebDriverWait wait = new WebDriverWait(driver, 20);

				wait.until(ExpectedConditions.elementToBeClickable(SubmitButton));
				FilterResult();

				count++;
			}
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			ex.printStackTrace();
		}

	}

	public void FilterByTopic() throws InterruptedException {
		SeeAll.click();
		ResourceFilterBy(topics, FilterbyTopic);
		driver.navigate().back();

	}

	public void FilterBySponsor() throws InterruptedException {
		SeeAll.click();
		ResourceFilterBy(sponsors, FilterbySponsor);
		driver.navigate().back();
	}

	public void FilterByResourceType() throws InterruptedException {
		SeeAll.click();
		ResourceFilterBy(resourceType, FilterbyResourceType);
		driver.navigate().back();
	}

	public void FilterResult() {

		SubmitButton.click();
		js.executeScript("return document.readyState").toString().equals("complete");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(ClearButton));
		String result = ResultsCount.getText();

		if (result.equalsIgnoreCase("No results found")) {
			System.out.println(" No results found for the given Filter \n");

		} else {

			ResourceCheck();

		}

	}

	public void BlankSearch() {
		driver.get(prop.getProperty("Url"));
		GoButton.click();
		ResourceCheck();
		System.out.println(" Blank Search Validation  in Popular Resource");
		driver.navigate().back();

	}

	public void PositiveSearch() {

		driver.get(prop.getProperty("Url"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButton));
		System.out.println(" Valid Search Validation  in Popular Resource");
		SearchField.sendKeys("Apple");
		GoButton.click();
		ResourceCheck();
		driver.navigate().back();
	}

	public void NegativeSearch() {
		driver.get(prop.getProperty("Url"));
		System.out.println(" InValid Search Validation  in Popular Resource");
		SearchField.sendKeys("12341234");
		GoButton.click();
		ResourceCheck();
		driver.navigate().back();
	}

}
