package variousConcepts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Dropdown {

	WebDriver driver;
	WebDriverWait wait;
	By Customer_tab = By.xpath("//span[text()='Customers']");
	By Add_customer = By.xpath("//a[contains(text(),'Add Customer')]");
	By Account_name = By.xpath("//input[@id='account']");
	By Submit = By.xpath("//button[@id='submit'and @class='md-btn md-btn-primary waves-effect waves-light']");

	@Before
	public void init() {
		{
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.get("https://techfios.com/billing/?ng=login/after/dashboard");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	@Test
	public void drop() throws InterruptedException, Exception,StaleElementReferenceException {

		WebElement USERNAME_ELEMENT = driver.findElement(By.id("username"));
		USERNAME_ELEMENT.sendKeys("demo@techfios.com");

		WebElement PASSWORD_ELEMENT = driver.findElement(By.name("password"));
		PASSWORD_ELEMENT.sendKeys("abc123");

		WebElement LOGIN = driver.findElement(By.name("login"));
		LOGIN.click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".loader-overlay.loaded"))));

		driver.findElement(Customer_tab).click();
		driver.findElement(Add_customer).click();
		Thread.sleep(2000);

		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='ibox-title']")).isDisplayed()); // Assertion

		driver.findElement(Account_name).sendKeys("Rohini Rathinakumar");
		WebElement drop = driver.findElement(By.xpath("//select[@id=\"cid\"and @class='form-control']"));
		drop.click();

		Select select = new Select(drop); // To access Dropdown webElement
		select.selectByVisibleText("Bank Of America");
		driver.findElement(Submit).click();
		List<WebElement> dropoption1 = select.getOptions();

		List<String>techfiosList = new ArrayList<String>();

		for (WebElement item : dropoption1) {

			techfiosList.add(item.getText());
		}

		Readingtext rc = new Readingtext();
		List<String> myFileList = rc.Read();

		System.out.println("abc.txt List" + "\t\t\t" + "Techfios Dropdown List" + "\t\t" + "  Result");
		System.out.println(" ");
		
		for (int i = 0; i <= myFileList.size(); i++) {

			if (myFileList.get(i).equals(techfiosList.get(i))) {
				System.out.printf("%-35s %-20s %15s%n", myFileList.get(i), techfiosList.get(i), "match ");

			} else {
				System.out.printf("%-35s %-20s %15s%n", myFileList.get(i), techfiosList.get(i), "not match");
			}

		}

	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}
}

/*
 * paste to line 72 for understanding System.out.println("******************");
 * System.out.println("List from Techfios website"); System.out.println("");
 * 
 * for (int i = 0; i < dropList.size(); i++) {
 * System.out.println(dropList.get(i)); } System.out.println("");
 * System.out.println("******************");
 * System.out.println("List from my abc.text file");
 */
