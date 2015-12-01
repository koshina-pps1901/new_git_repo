package Remote;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegistrationBoysAndGirls {
	WebDriver driver;
	Properties properties;
	
	
	@BeforeTest
	public void setBrowser1() throws IOException
	{
		properties = new Properties();
		FileInputStream fileProperties= new FileInputStream("C:\\Users\\CMI-UA-User\\workspace\\FlirchiTests\\src\\Remote\\Test.properties");
		properties.load(fileProperties);
	
		DesiredCapabilities capabilities =  DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.BINARY,new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
		 driver = new RemoteWebDriver(new URL("http://10.10.0.60:5556/wd/hub"),capabilities);//node machine	
	
		
		driver.manage().window().maximize();
	}
	
	
//	@BeforeTest
	public void setBrowser() throws IOException
	{
		properties = new Properties();
		FileInputStream fileProperties= new FileInputStream("C:\\Users\\Julia\\workspace\\Flirchi\\src\\testcases\\Test.properties");
		properties.load(fileProperties);
		
		if(properties.getProperty("browser").equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(properties.getProperty("browser").equals("chrome"))
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
	public void clearCash()
	{
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void registrationPreferGirls() throws InterruptedException
	{
		driver.get(properties.getProperty("url"));
		
		SignupPreferGirls preferGirl = new SignupPreferGirls(driver);
		
		preferGirl.selectGirls();
		preferGirl.selectLightHairGirl();
		preferGirl.selectDarkEyeGirl();
		preferGirl.selectCurvyGirl();
		
		preferGirl.waitForElement(preferGirl.regForm);
		
		preferGirl.inputName(properties.getProperty("name"));
		preferGirl.inputEmail(generateEmail());
		preferGirl.selectGender(properties.getProperty("gender"));
		preferGirl.selectAge(properties.getProperty("age"));
		
		//preferGirl.submitSignUp();
    	
	//	waitForUrl(properties.getProperty("partofurl"));
		//Assert.assertTrue("Registration was not succesful!",driver.getCurrentUrl().contains(properties.getProperty("partofurl")));
		
	}

	@Test
	public void registrationPreferBoys() throws InterruptedException
	{
		driver.get(properties.getProperty("url"));
		
		SignupPreferBoys preferBoys = new SignupPreferBoys(driver);
		
		preferBoys.selectBoys();
		preferBoys.selectLightHairBoy();
		preferBoys.selectDarkEyeBoy();
		preferBoys.selectSlimBoy();
		
		preferBoys.waitForElement(preferBoys.regForm);
	
		preferBoys.inputName(properties.getProperty("name"));
		preferBoys.inputEmail(generateEmail());
		preferBoys.selectGender(properties.getProperty("gender"));
		preferBoys.selectAge(properties.getProperty("age"));
		
		//preferBoys.submitSignUp();
		
		//waitForUrl(properties.getProperty("partofurl"));
		//Assert.assertTrue("Registration was not succesful!",driver.getCurrentUrl().contains(properties.getProperty("partofurl")));
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