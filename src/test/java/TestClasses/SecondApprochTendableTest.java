package TestClasses;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SecondApprochTendableTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\Tendae\\src\\main\\resources\\Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Dell\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver(options);

        try {
            // Task 1: Confirm accessibility of the top-level menus
            checkTopLevelMenus(driver);

            // Task 2: Verify "Request a Demo" button presence and activity
            checkRequestDemoButton(driver);

            // Task 3: Navigate to "Contact Us" section, choose "Marketing", and submit the form
            submitContactUsForm(driver);

        } finally {
            driver.quit();
        }
    }

    private static void checkTopLevelMenus(WebDriver driver) throws InterruptedException {
        driver.get("https://www.tendable.com");

        //Find out the WebElement by using Xpath
        WebElement ourStoryMenu = driver.findElement(By.xpath("//a[@href=\"https://www.tendable.com/our-story\"]"));
        WebElement ourSolutionMenu = driver.findElement(By.xpath("//a[@href=\"https://www.tendable.com/our-solution\"]"));
        WebElement whyTendableMenu = driver.findElement(By.xpath("//a[@href=\"https://www.tendable.com/why-tendable\"]"));

        ourStoryMenu.click();
        Thread.sleep(2000);
        ourSolutionMenu.click();
        Thread.sleep(2000);
        whyTendableMenu.click();
        Thread.sleep(2000);
        
    }

    private static void checkRequestDemoButton(WebDriver driver) {
        // Assuming "Request a Demo" button has a specific ID or class, modify this accordingly
        WebElement requestDemoButton = driver.findElement(By.xpath("(//a[@href=\"https://www.tendable.com/book-a-demo\"])[2]"));
        
        requestDemoButton.click();

        // Your code to verify the presence and activity of the "Request a Demo" button
        // For example, you can check if the button is displayed and clickable
    }

    private static void submitContactUsForm(WebDriver driver) throws InterruptedException {
        driver.get("https://www.tendable.com/contact-us");

        // Assuming the form elements have specific IDs or classes, modify this accordingly
        WebElement marketingOption = driver.findElement(By.xpath("(//button[@class=\"body-button bg-plain-600 toggle-control\"])[1]"));
        WebElement submitButton = driver.findElement(By.xpath("(//button[@type=\"submit\"])[5]"));

        // Choose "Marketing" in the "Contact Us" section
        marketingOption.click();
        
        Thread.sleep(2000);

        // Submit the form without filling in the "Message" field
        submitButton.click();
        
        Thread.sleep(2000);

        // Assuming the error message has a specific ID or class, modify this accordingly
        WebElement errorMessage = driver.findElement(By.id("errorMessage"));

        // Check if the error message is displayed
        if (errorMessage.isDisplayed()) {
            System.out.println("Test Passed - Error message is displayed.");
        } else {
            System.out.println("Test Failed - Error message is not displayed.");
        }
    }
}
