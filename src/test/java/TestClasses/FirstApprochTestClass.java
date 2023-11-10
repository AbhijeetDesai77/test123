package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.LaunchBrowser;
import POMPackage.pomclass;

public class FirstApprochTestClass {
	
	WebDriver driver;
	LaunchBrowser browser =new LaunchBrowser();
	pomclass pom =new pomclass(driver);
	
	@BeforeClass
	public void Browser() {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\Tendae\\src\\main\\resources\\Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Dell\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
         driver = new ChromeDriver(options);
		
	}
	@AfterMethod
	public void refresh() {
		driver.navigate().refresh();
	}
	@BeforeMethod
	public void getUrl() {
		driver.get("https://www.tendable.com/");
	}
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void tc01() throws InterruptedException {
		pom.ourStoryMenu();
		Thread.sleep(2000);
		pom.ourSolutionMenu();
		Thread.sleep(2000);
		pom.whyTendableMenu();
		Thread.sleep(2000);
		pom.requestDemoButton();
		Thread.sleep(2000);
		pom.marketingOption();
		Thread.sleep(2000);
		pom.submitButton();
		Thread.sleep(2000);
	}

}
