package firstAssignment;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BankDeposit {
	
	WebDriver wd;

	@Before
	public void LunchBrowser() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
		wd = new ChromeDriver ();
		//wd = new FirefoxDriver ();

		wd.get("http://www.techfios.com/ibilling/?ng=admin/");
		wd.manage().window().maximize();
		Thread.sleep(1000);
	}

	@Test
	public void Login() throws InterruptedException {
		wd.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		wd.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");

		
		//Actions myact = new Actions(wd);
		//myact.sendKeys(Keys.ENTER).build().perform();
		
		wd.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
	}

	//@After
	public void Transaction() throws InterruptedException {
		wd.findElement(By.xpath("//span[text()='Transactions']")).click();
		wd.findElement(By.xpath("//a[text()='New Deposit']")).click();

		Select select = new Select(wd.findElement(By.xpath("//select[@id='account']")));
		Thread.sleep(10000);
		//i am commiting this file
		select.selectByVisibleText("Green62");
		Thread.sleep(1000);

		wd.findElement(By.xpath("//input[@id='description']")).sendKeys("Deposit money by Arjun");
		Thread.sleep(1000);
		wd.findElement(By.xpath("//input[@id='amount']")).sendKeys("1200");
		Thread.sleep(1000);
		wd.findElement(By.xpath("//button[@id='submit']")).click();

		wd.close();

	}

}
