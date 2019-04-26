package testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class Simplesel {
	public WebDriver driver;
	@BeforeMethod
	public void baseopp() {
		System.setProperty("webdriver.gecko.driver","./exef/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.seleniumhq.org/");
	}
	@Test
	public void testcase1() throws InterruptedException {
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//li[@id='menu_download']")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.findElement(By.id("q")).sendKeys("chrome");
		driver.findElement(By.id("submit"));
		driver.findElement(By.xpath("//li[@id='menu_download']")).click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
