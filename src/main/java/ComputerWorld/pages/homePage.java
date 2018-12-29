package ComputerWorld.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import ComputerWorld.main.baseClass;

public class homePage extends baseClass {
	String Url = "";
	public WebDriverWait wait = new WebDriverWait(driver, 90);
	CloseableHttpResponse Response;

	public homePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Close Ad']")
	WebElement closeAd;

	@SuppressWarnings("deprecation")
	public void closeAD() {
		wait.pollingEvery(5, TimeUnit.SECONDS);
		if (closeAd.isDisplayed()) {
			wait.until(ExpectedConditions.elementToBeClickable(closeAd));
			closeAd.click();
			System.out.println("Advertisement on the homepage is closed");
		} else {
			System.out.println(" There are no Ads on the webPage ");
		}
	}

	public void LinksValidation() throws ClientProtocolException, IOException {
		List<WebElement> links = driver.findElements(By.tagName("a"));

		Iterator<WebElement> it = links.iterator();
		int count = 1;
		while (it.hasNext()) {
			System.out.println("\n URL Referenced " + count + ". " + Url);
			boolean linkfail = false;
			try {
				Url = it.next().getAttribute("href");

				if (Url == null || Url.isEmpty()) {
					Assert.assertEquals(Url == null, true, "Url is not configured for the anchor tag or is empty.");
					System.out.println("      Url is not configured for the anchor tag or is empty.");
				} else if (!Url.startsWith(prop.getProperty("Url"))) {
					System.out.println("      The link belongs to the EXTERNAL DOMAIN, skipping it. ");

				} /*else if (Url.startsWith(prop.getProperty("Url"))) {
					System.out.println("    The link belongs to the INTERNAL DOMAIN");
					Response = get(Url);
					int responseCode = Response.getStatusLine().getStatusCode();
					if (responseCode > 400) {
						linkfail = true;
						Assert.assertEquals(linkfail, false, "Link is Broken");
					} else {
						Assert.assertEquals(linkfail, false, "Link is not Broken and is working fine");
					}
				}*/ else {
					System.out.println("     The link belongs to the INTERNAL DOMAIN");
					Response = get(Url);
					int responseCode = Response.getStatusLine().getStatusCode();
					if (responseCode > 400) {
						linkfail = true;
						Assert.assertEquals(linkfail, false, "Link is Broken");
					} else {
						Assert.assertEquals(linkfail, false, "Link is not Broken and is working fine");
					}
				}
			} catch (org.openqa.selenium.StaleElementReferenceException ex) {
				
				Assert.assertEquals(ex.toString().contains("element is not attached to the page document"),
						true," Exceptions available");
			}catch (HttpHostConnectException hc) {
				Assert.assertEquals(hc.toString().contains("Connection timed out: connect"),true,"Exception failed");
			}
			count++;
		}

	}

	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse Response = httpclient.execute(httpGet);
		return Response;
	}
	
	

}
