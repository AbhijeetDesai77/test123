package POMPackage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pomclass {
	
	
	
	@FindBy(xpath="//a[@href=\"https://www.tendable.com/our-story\"]")private WebElement  ourStoryMenu;
	@FindBy(xpath="//a[@href=\"https://www.tendable.com/our-solution\"]")private WebElement ourSolutionMenu;
	@FindBy(xpath="//a[@href=\"https://www.tendable.com/why-tendable\"]")private WebElement whyTendableMenu;
	@FindBy(xpath="//a[@href=\"https://www.tendable.com/book-a-demo\"])[2]")private WebElement requestDemoButton;
	@FindBy(xpath="//button[@class=\"body-button bg-plain-600 toggle-control\"])[1]") private WebElement marketingOption;
	@FindBy(xpath="//button[@type=\"submit\"])[5]")private WebElement submitButton;
	@FindBy(xpath="//div[@class=\"ff-form-errors\"]")private WebElement ErrorMessage;
	
	public pomclass(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void ourStoryMenu() {
		ourStoryMenu.click();
		
	}
	
	public void ourSolutionMenu() {
		ourSolutionMenu.click();
	}
	
	public void whyTendableMenu() {
		whyTendableMenu.click();
	}
	
	public void requestDemoButton() {
		requestDemoButton.click();
	}
	
	public void marketingOption() {
		
		marketingOption.click();
	}
	
	public void submitButton() {
		submitButton.click();
	       if (ErrorMessage.isDisplayed()) {
	            System.out.println("Test Passed - Error message is displayed.");
	        } else {
	            System.out.println("Test Failed - Error message is not displayed.");
	        }
	}
	

}
