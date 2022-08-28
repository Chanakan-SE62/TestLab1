import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class SerachTest {

	@BeforeAll //1
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll //4
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach //2
	void setUp() throws Exception {
	}

	@AfterEach //3
	void tearDown() throws Exception {
	}

	@SuppressWarnings("static-access")
	@Test
	void testSerachByKeyword() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		
		browser.get("https://th.indeed.com");
		browser.findElement(By.id("text-input-what")).click();
		browser.findElement(By.id("text-input-what")).sendKeys("Selenium");
		browser.findElement(By.id("text-input-where")).click();
		browser.findElement(By.id("text-input-where")).sendKeys("Bangkok");
		browser.findElement(By.xpath("//*[@type='submit']")).click();
		browser.manage().window().setSize(new Dimension(1920,1080));
		try {
			this.takeSnapShot(browser, "c://test.png") ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		browser.close();
	}
	
	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}

}
