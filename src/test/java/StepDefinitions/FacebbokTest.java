package StepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebbokTest {
	public static String Cdriver="webdriver.chrome.driver";
	public static String Path="D:\\QA\\Selenium Automation\\1st Class\\chromedriver_win32\\chromedriver.exe";
	public static String ural="https://www.facebook.com/";
	static WebDriver Chromedri;
	
  @Given("^I enter user name \"([^\"]*)\"$")
	public void i_enter_user_name(String v1) {
	  System.setProperty(Cdriver, Path);
		Chromedri= new ChromeDriver();
		Chromedri.get(ural);
		Chromedri.manage().window().maximize();
		WebElement TextBox =Chromedri.findElement(By.xpath("//input[@name='email']"));		
	    TextBox.sendKeys(v1);
	    System.out.println("Google Chrome is opening and navigate to facebook ");
	}

  
   @When("I enter password \\\"([^\\\"]*)\\\"$")
   public void i_enter_password(String v2) {
	   WebElement TextBox =Chromedri.findElement(By.xpath("//input[@name='pass']"));		
	   TextBox.sendKeys(v2);
    System.out.println("Send to Gmail and password ");
}
   

   @Then("^login failed$")
   public void login_failed() throws Exception {
	  WebElement TextBox =Chromedri.findElement(By.xpath("//input[@value='Log In']"));		
	  TextBox.click();
	  System.out.println("Login is Failed");
	  
	  //ScreenShot
	  File TextBox1=  ((TakesScreenshot)Chromedri)
				.getScreenshotAs(OutputType.FILE);
	
			String ScreenLocation= "D:\\QA\\Selenium Automation\\ScreenshotFacebook.png";
			
			FileUtils.copyFile(TextBox1 , new File(ScreenLocation));
			System.out.println("Screenshot Done ");
			
	 
	  
   
}


}
