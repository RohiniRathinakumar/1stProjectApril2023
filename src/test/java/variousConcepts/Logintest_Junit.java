package variousConcepts;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import variousConcepts.Description;

public class Logintest_Junit {
	WebDriver driver;
	WebDriverWait wait;

	String descr = Description.getInput1(); // Invoking the input from methods in other class
	int money = Description.getInput2();

	// Xpath using Xpath Axes
	By TRANSACTION = By.xpath("//ul[@class='nav']/child::li[5]/child::a[1]/child::span[1]");

	// Xpath using Xpath Axes
	By NEW_DEPOSIT = (By.xpath("//ul[@class=\"nav nav-second-level collapse in\"]/child::li[1]"));

	By SELECTOR = By.xpath("//option[contains(text(),'Rohini Rathinakumar')]");
	By DESCRIPTION = By.xpath("//input[@class='form-control'and@id='description']");
	By AMOUNT = By.xpath("//input[@id='amount']");
	By SUBMIT = By.xpath("//button[@class='btn btn-primary']");

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

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

	@Test
	public void positiveLoginTest() throws InterruptedException {

		WebElement USERNAME_ELEMENT = driver.findElement(By.id("username"));
		USERNAME_ELEMENT.sendKeys("demo@techfios.com");

		WebElement PASSWORD_ELEMENT = driver.findElement(By.name("password"));
		PASSWORD_ELEMENT.sendKeys("abc123");

		WebElement LOGIN = driver.findElement(By.name("login"));
		LOGIN.click();
		wait = new WebDriverWait(driver, 30);

		// org.openqa.selenium.ElementClickInterceptedException: element click
		// intercepted: Element <span class="nav-label">...</span> is not clickable at
		// point (85, 384).
		// Other element would receive the click: <div class="loader-overlay
		// loaded">...</div>

		// Thread.sleep(2000);
		// wait.until(ExpectedConditions.elementToBeClickable(TRANSACTION));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".loader-overlay.loaded"))));
		driver.findElement(TRANSACTION).click();

		driver.findElement(NEW_DEPOSIT).click();

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".loader-overlay.loaded"))));

		driver.findElement(SELECTOR).click();
		driver.findElement(DESCRIPTION).sendKeys(descr);
		driver.findElement(AMOUNT).sendKeys("" + money);
		driver.findElement(SUBMIT).click();

	}
}

//////My practice

/*
 * // CSS selector // By NEW_DEPOSIT = // By.cssSelector(
 * "a[href$='https://techfios.com/billing/?ng=transactions/deposit/']"); //By
 * CHOOSE_ACCOUNT = By.xpath("//span[@class='select2-selection__arrow']");
 * //Xpath using Xpath Axes //By CHOOSE_ACCOUNT =
 * By.xpath("//ul[@class='nav']/child::li[5]/child::a[1]/child::span[1]");
 * //driver.findElement(CHOOSE_ACCOUNT).click();
 */

/*
 * Thread.sleep(2000); Created and found Xpath myself
 * driver.findElement(By.xpath("//ul[@id='side-menu']/li[10]")).click();
 * driver.findElement(By.xpath("//ul[@id='side-menu']/li[10]/ul[1]/li[1]/a")).
 * click();
 * 
 * driver.findElement(By.id("account")).sendKeys("Rohini Rathinakumar");
 * driver.findElement(By.id("description")).sendKeys("My first acount");
 * driver.findElement(By.id("balance")).sendKeys("500");
 * driver.findElement(By.id("account_number")).sendKeys("2345678923");
 * driver.findElement(By.id("contact_person")).sendKeys("Rathina");
 * driver.findElement(By.id("contact_phone")).sendKeys("875568934");
 * driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
 */

/*
 * from copying Xpath
 * driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[10]")).click();
 * driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a")).
 * click(); driver.findElement(By.xpath("//*[@id=\"account\"]")).
 * sendKeys("Rohini Rathinakumar");
 * driver.findElement(By.xpath("//*[@id=\"description\"]")).
 * sendKeys("My first acount");
 * driver.findElement(By.xpath("//*[@id=\"balance\"]")).sendKeys("500");
 * driver.findElement(By.xpath("//*[@id=\"account_number\"]")).sendKeys(
 * "2345678923");
 * driver.findElement(By.xpath("//*[@id=\"contact_person\"]")).sendKeys(
 * "Rathina");
 * driver.findElement(By.xpath("//*[@id=\"contact_phone\"]")).sendKeys(
 * "875568934"); driver.findElement(By.xpath(
 * "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/button/i")).
 * click();
 */
