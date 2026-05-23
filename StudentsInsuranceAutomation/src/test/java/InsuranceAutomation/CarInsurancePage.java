package InsuranceAutomation;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarInsurancePage {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	public CarInsurancePage(WebDriver driver) {
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

	@FindBy(xpath = "//li[text()='Car']")
	WebElement btn_car_loc;
	@FindBy(xpath = "//span[text()=\"Don't know your car number?\"]/following-sibling::span[text()='Click here']")
	WebElement btn_clickHere_loc;
	@FindBy(xpath = "//div[text()='Ford']")
	WebElement btn_ford_loc;
	@FindBy(xpath = "//span[text()='Mustang']")
	WebElement btn_mustang_loc;
	@FindBy(xpath = "//li[text()='Petrol']")
	WebElement btn_petrol_loc;
	@FindBy(xpath = "//span[text()='V8']/parent::div")
	WebElement btn_v8_loc;
	@FindBy(xpath = "//span[text()='TN-01  Chennai Ayanavaram']")
	WebElement btn_chennai_loc;
	@FindBy(xpath = "//span[text()='2023']")
	WebElement btn_2023_loc;
	@FindBy(xpath = "//div[text()='Not Expired']")
	WebElement btn_notExpired_loc;
	@FindBy(xpath = "//div[@class='claim-mopro']//div[ text()='No']")
	WebElement btn_no_loc;
	@FindBy(xpath = "//input[@type='tel' and @maxlength='10']")
	WebElement btn_mobileNumber_loc;
	@FindBy(xpath = "//button[@title='View Quotes']")
	WebElement btn_viewQuotes_loc;
	@FindBy(xpath = "//div[@class='error-label ']")
	WebElement txt_errorMessages_loc;

	public void clickCar() {
		highlightElement(btn_car_loc);
		btn_car_loc.click();
	}

	public void clickClickHere() {
		highlightElement(btn_clickHere_loc);
		btn_clickHere_loc.click();
	}

	public void clickFord() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_ford_loc));
		highlightElement(btn_ford_loc);
		btn_ford_loc.click();
	}

	public void clickMustang() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_mustang_loc));
		highlightElement(btn_mustang_loc);
		btn_mustang_loc.click();
	}

	public void clickPetrol() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_petrol_loc));
		highlightElement(btn_petrol_loc);
		btn_petrol_loc.click();
	}

	public void clickV8() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_v8_loc));
		highlightElement(btn_v8_loc);
		js.executeScript("arguments[0].click();", btn_v8_loc);
	}

	public void clickChennai() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_chennai_loc));
		highlightElement(btn_chennai_loc);
		js.executeScript("arguments[0].click();", btn_chennai_loc);
	}

	public void click2023() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_2023_loc));
		highlightElement(btn_2023_loc);
		btn_2023_loc.click();
	}

	public void clickNotExpired() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_notExpired_loc));
		highlightElement(btn_notExpired_loc);
		btn_notExpired_loc.click();
	}

	public void clickNo() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_no_loc));
		highlightElement(btn_no_loc);
		btn_no_loc.click();
	}

	public void setMobileNumber(String mobileNumber) {
		wait.until(ExpectedConditions.elementToBeClickable(btn_mobileNumber_loc));
		highlightElement(btn_mobileNumber_loc);
		btn_mobileNumber_loc.sendKeys(mobileNumber);
	}

	public void clickViewQuotes() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_viewQuotes_loc));
		highlightElement(btn_viewQuotes_loc);
		btn_viewQuotes_loc.click();
	}

	public String getErrorMessages() {
		highlightElement(txt_errorMessages_loc);
		return txt_errorMessages_loc.getText();
	}
}
