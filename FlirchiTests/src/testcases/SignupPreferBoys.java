package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignupPreferBoys {
	WebDriver driver;
	public SignupPreferBoys(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
		if (!"https://flirchi.com/sign/inter?fr=1&p=1232".equals(driver.getCurrentUrl())) {
            throw new IllegalStateException("This is not the signup page");
		}
	}
	@FindBy(xpath=".//*[@id='slide-1']/div[2]/div[2]")
	WebElement boyButton;

	@FindBy(xpath=".//*[@id= 'slide-2' and contains(@class, 'inter-slide m visible')]/div[2]/div[1]")
	WebElement darkHairBoyButton;
	
	@FindBy(xpath=".//*[@id= 'slide-2' and contains(@class, 'inter-slide m visible')]/div[2]/div[2]")
	WebElement lightHairBoyButton;
	
	@FindBy(xpath=".//*[@id= 'slide-3' and contains(@class, 'inter-slide m visible')]/div[2]/div[1]")
	WebElement darkEyeBoyButton;
	
	@FindBy(xpath=".//*[@id= 'slide-3' and contains(@class, 'inter-slide m visible')]/div[2]/div[2]")
	WebElement lightEyeBoyButton;
	
	@FindBy(xpath=".//*[@id= 'slide-4' and contains(@class, 'inter-slide m visible')]/div[2]/div[1]")
	WebElement curvyBoyButton;
	
	@FindBy(xpath=".//*[@id= 'slide-4' and contains(@class, 'inter-slide m visible')]/div[2]/div[2]")
	WebElement slimBoyButton;
	
	@FindBy(xpath=".//*[@id= 'form-signup-name' and contains(@class, 'land-form-control inter-name-input-m')]")
	WebElement nameBoy;

	@FindBy(xpath=".//*[@id= 'form-signup-email' and contains(@class, 'land-form-control inter-mail-input-m')]")
	WebElement emailBoy;

	@FindBy(xpath=".//*[@id= 'field-gender-select' and contains(@class, 'field-gender-select-m land-form-control')]")
	WebElement genderBoy;
	
	@FindBy(xpath=".//*[@id= 'field-age-select' and contains(@class, 'field-age-select-m land-form-control')]")
	WebElement ageBoy;
	
	@FindBy(id="submit_sign_up_m")
	WebElement signUpButton;
	
	@FindBy(xpath=".//*[@id= 'slide-6' and contains(@class, 'slide-6 inter-slide m form-container visible')]")
	WebElement regForm;
	
	
	public void selectBoys()
	{
		boyButton.click();
	}
	
	public void selectDarkHairBoy()
	{
		darkHairBoyButton.click();
	}
	
	public void selectLightHairBoy()
	{
		lightHairBoyButton.click();
	}

	public void selectDarkEyeBoy()
	{
		darkEyeBoyButton.click();
	}
	
	public void selectLightEyeBoy()
	{
		lightEyeBoyButton.click();
	}
	
	public void selectCurvyBoy()
	{
		curvyBoyButton.click();
	}
	
	public void selectSlimBoy()
	{
		slimBoyButton.click();
	}
	
	public void inputName(String name)
	{
		nameBoy.sendKeys(name);	
	}
	
	public void inputEmail(String email)
	{
		emailBoy.sendKeys(email);	
	}
	
	public void selectGender(String gender)
	{
		Select genderSelect = new Select(genderBoy);
		genderSelect.selectByValue(gender);
	}
	
	public void selectAge(String age)
	{
		Select ageSelect = new Select(ageBoy);
		ageSelect.selectByValue(age);
	}
	
	public void waitForElement(WebElement element)
	{
		WebDriverWait explWait =new WebDriverWait(driver,5);
		explWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void submitSignUp()
	{
		signUpButton.click();
	}
}



