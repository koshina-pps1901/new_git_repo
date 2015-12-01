package Remote;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPreferGirls {
	WebDriver driver;
	public SignupPreferGirls(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
		if (!"https://flirchi.com/sign/inter?fr=1&p=1232".equals(driver.getCurrentUrl())) {
            throw new IllegalStateException("This is not the signup page");
		}
	}
	
	@FindBy(xpath=".//*[@id='slide-1']/div[2]/div[1]")
	WebElement girlButton;

	@FindBy(xpath=".//*[@id= 'slide-2' and contains(@class, 'inter-slide f visible')]/div[2]/div[1]")
	WebElement darkHairGirlButton;
	
	@FindBy(xpath=".//*[@id= 'slide-2' and contains(@class, 'inter-slide f visible')]/div[2]/div[2]")
	WebElement lightHairGirlButton;
	
	@FindBy(xpath=".//*[@id= 'slide-3' and contains(@class, 'inter-slide f visible')]/div[2]/div[1]")
	WebElement darkEyeGirlButton;
	
	@FindBy(xpath=".//*[@id= 'slide-3' and contains(@class, 'inter-slide f visible')]/div[2]/div[2]")
	WebElement lightEyeGirlButton;
	
	@FindBy(xpath=".//*[@id= 'slide-4' and contains(@class, 'inter-slide f visible')]/div[2]/div[1]")
	WebElement curvyGirlButton;
	
	@FindBy(xpath=".//*[@id= 'slide-4' and contains(@class, 'inter-slide f visible')]/div[2]/div[2]")
	WebElement slimGirlButton;
	
	@FindBy(xpath=".//*[@id= 'form-signup-name' and contains(@class, 'land-form-control inter-name-input-f')]")
	WebElement nameGirl;

	@FindBy(xpath=".//*[@id= 'form-signup-email' and contains(@class, 'land-form-control inter-mail-input-f')]")
	WebElement emailGirl;

	@FindBy(xpath=".//*[@id= 'field-gender-select' and contains(@class, 'field-gender-select-f land-form-control')]")
	WebElement genderGirl;
	
	@FindBy(xpath=".//*[@id= 'field-age-select' and contains(@class, 'field-age-select-f land-form-control')]")
	WebElement ageGirl;
	
	@FindBy(id="submit_sign_up_f")
	WebElement signUpButton;
	
	@FindBy(xpath=".//*[@id= 'slide-6' and contains(@class, 'slide-6 inter-slide f form-container visible')]")
	WebElement regForm;
	
	
	public void selectGirls()
	{
		girlButton.click();
	}
	
	public void selectDarkHairGirl()
	{
		darkHairGirlButton.click();
	}
	
	public void selectLightHairGirl()
	{
		lightHairGirlButton.click();
	}

	public void selectDarkEyeGirl()
	{
		darkEyeGirlButton.click();
	}
	
	public void selectLightEyeGirl()
	{
		lightEyeGirlButton.click();
	}
	
	public void selectCurvyGirl()
	{
		curvyGirlButton.click();
	}
	
	public void selectSlimGirl()
	{
		slimGirlButton.click();
	}
	
	public void inputName(String name)
	{
		nameGirl.sendKeys(name);	
	}
	
	public void inputEmail(String email)
	{
		emailGirl.sendKeys(email);	
	}
	
	public void selectGender(String gender)
	{
		Select genderSelect = new Select(genderGirl);
		genderSelect.selectByValue(gender);
	}
	
	public void selectAge(String age)
	{
		Select ageSelect = new Select(ageGirl);
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



