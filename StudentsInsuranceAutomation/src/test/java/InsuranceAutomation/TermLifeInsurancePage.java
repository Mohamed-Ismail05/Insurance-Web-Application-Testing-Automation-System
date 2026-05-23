package InsuranceAutomation;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TermLifeInsurancePage {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	public TermLifeInsurancePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js = (JavascriptExecutor) driver;
	}

	public void highlightElement(WebElement element) {
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		try {
            Thread.sleep(500); // Pause for visual clarity
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		js.executeScript("arguments[0].style.border=''", element); // Remove highlight
	}

	@FindBy(xpath = "//li[text()='Term Life']")
	WebElement btn_termLife_loc;

	@FindBy(xpath = "//div[text()='Male']")
	WebElement btn_male_loc;

	@FindBy(xpath = "//div[@class='w--multi_select_handle ']")
	WebElement btn_ageDropDown_loc;

	@FindBy(xpath = "//span[text()='25 years']")
	WebElement btn_25years_loc;

	@FindBy(xpath = "//div[contains(@class,'w--text_input  ')]//input")
	WebElement txt_name_loc;

	@FindBy(xpath = "//div[@class='w--text_input w--text_input-mobile   ']//input")
	WebElement txt_mobileNumber_loc;

	@FindBy(xpath = "//button[text()='View Quotes']")
	WebElement btn_viewQuotes_loc;

	@FindBy(xpath = "//div[@class='error-label ']")
	WebElement txt_errorMessages_loc;

	public void clickTermLife() {
		highlightElement(btn_termLife_loc);
		btn_termLife_loc.click();
	}

	public void clickMale() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_male_loc));
		highlightElement(btn_male_loc);
		btn_male_loc.click();
	}

	public void clickAgeDropDown() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_ageDropDown_loc));
		highlightElement(btn_ageDropDown_loc);
		btn_ageDropDown_loc.click();
	}

	public void click25Years() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_25years_loc));
		highlightElement(btn_25years_loc);
		btn_25years_loc.click();
	}

	public void setName(String name) {
		highlightElement(txt_name_loc);
		txt_name_loc.sendKeys(name);
	}

	public void setMobileNumber(String mobileNumber) {
		highlightElement(txt_mobileNumber_loc);
		txt_mobileNumber_loc.sendKeys(mobileNumber);
	}

	public void clickViewQuotes() {
		highlightElement(btn_viewQuotes_loc);
		btn_viewQuotes_loc.click();
	}

	public String getErrorMessages() {
		wait.until(ExpectedConditions.visibilityOf(txt_errorMessages_loc));
		highlightElement(txt_errorMessages_loc);
		return txt_errorMessages_loc.getText();
	}

}
