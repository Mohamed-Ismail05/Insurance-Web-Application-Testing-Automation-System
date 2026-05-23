package InsuranceAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HealthInsurancePage {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	public HealthInsurancePage(WebDriver driver) {
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

	@FindBy(xpath = "//button[ contains(@class , 'w--button--orange') and text()='Get Started']")
	WebElement btn_getStarted_loc;
	@FindBy(xpath = "//div[@class='next-btn' and text()=' Next ']")
	WebElement btn_next_loc;
	@FindBy(id = "Age-You")
	WebElement dropdown_age_loc;
	@FindBy(xpath = "//div[@class='next-btn' and text()='Next']")
	WebElement btn_ageNext_loc;
	@FindBy(xpath = "//input[@placeholder='6 Digit Pincode']")
	WebElement txt_pincode_loc;
	@FindBy(id = "want-expert")
	WebElement txt_mobileNumber_loc;
	@FindBy(xpath = "//div[@class='next-btn']")
	WebElement btn_continue_loc;
	@FindBy(xpath = "//div[@class='hin-title']//div")
	WebElement txt_result_loc;
	@FindBy(xpath = "//div[@id='plans-list']")
	List<WebElement> list_planlist_loc;

	public void clickGetStarted() {
		highlightElement(btn_getStarted_loc);
		btn_getStarted_loc.click();
	}

	public void clickNext() {
		highlightElement(btn_next_loc);
		btn_next_loc.click();
	}

	public void setAge() {
		Select ageOptions = new Select(dropdown_age_loc);
		ageOptions.selectByValue("25y");
	}

	public void clickAgeNext() {
		highlightElement(btn_ageNext_loc);
		btn_ageNext_loc.click();
	}

	public void setPincode(String pin) {
		highlightElement(txt_pincode_loc);
		txt_pincode_loc.sendKeys(pin);
	}

	public void setMobileNumber(String mobile) {
		highlightElement(txt_mobileNumber_loc);
		txt_mobileNumber_loc.sendKeys(mobile);
	}

	public void clickContinue() {
		highlightElement(btn_continue_loc);
		btn_continue_loc.click();
	}

	public String getErrorMessages() {
		wait.until(ExpectedConditions.visibilityOfAllElements(list_planlist_loc));
		highlightElement(txt_result_loc);
		return txt_result_loc.getText();
	}
}
