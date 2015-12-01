package testcases;


import java.io.IOException;
import java.util.Random;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegistrationBoysAndGirls{
	WebDriver driver;
	
 	@BeforeTest
	@Parameters("browser")
    public void beforeTest(String browser) throws IOException {
 	
		if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else
		{
			    throw new IllegalArgumentException("The Browser Type is Undefined");
		}
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void clearCache()
	{
		driver.manage().deleteAllCookies();
	}
	
	
	@Test
	@Parameters({"name","age","gender"})
    public void registrationPreferGirls(String name,String age,String gender) throws InterruptedException
	{
		driver.get("https://flirchi.com/sign/inter?fr=1&p=1232");		
		
		SignupPreferGirls preferGirl = new SignupPreferGirls(driver);
		
		preferGirl.selectGirls();
		preferGirl.selectLightHairGirl();
		preferGirl.selectDarkEyeGirl();
		preferGirl.selectCurvyGirl();
		
		preferGirl.waitForElement(preferGirl.regForm);
		
		preferGirl.inputName(name);
		preferGirl.inputEmail(generateEmail());
		preferGirl.selectGender(gender);
		preferGirl.selectAge(age);
		
//		preferGirl.submitSignUp();
    	
//		waitForUrl("https://flirchi.com/u");
//		Assert.assertTrue("Registration was not succesful!",driver.getCurrentUrl().contains("https://flirchi.com/u"));
		
	}

	@Test
	@Parameters({"name","age","gender"})
	public void registrationPreferBoys(String name,String age,String gender) throws InterruptedException
	{
		driver.get("https://flirchi.com/sign/inter?fr=1&p=1232");		
		
		SignupPreferBoys preferBoys = new SignupPreferBoys(driver);
		
		preferBoys.selectBoys();
		preferBoys.selectLightHairBoy();
		preferBoys.selectDarkEyeBoy();
		preferBoys.selectSlimBoy();
		
		preferBoys.waitForElement(preferBoys.regForm);
	
		preferBoys.inputName(name);
		preferBoys.inputEmail(generateEmail());
		preferBoys.selectGender(gender);
		preferBoys.selectAge(age);
		
//		preferBoys.submitSignUp();
		
//		waitForUrl("https://flirchi.com/u");
//		Assert.assertTrue("Registration was not succesful!",driver.getCurrentUrl().contains("https://flirchi.com/u"));

	}
	
	public String generateEmail()
	{
		Random rnd = new Random();
		return "flirchitest+"+rnd.nextInt(2000)+"@gmail.com";
	}
	
	public void waitForUrl(String url) {
		WebDriverWait explWait =new WebDriverWait(driver,5);
		explWait.until(ExpectedConditions.urlContains(url));
	}
	
	@AfterTest
	public void tearUp()
	{
		driver.quit();		
	}
		
}