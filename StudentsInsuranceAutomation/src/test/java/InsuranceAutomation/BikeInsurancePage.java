package InsuranceAutomation;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BikeInsurancePage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	public BikeInsurancePage(WebDriver driver) {
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

	@FindBy(xpath = "//li[text()='Bike']")
	WebElement btn_bike_loc;
	@FindBy(xpath = "//button[text()='Not sure of your bike number?']")
	WebElement btn_notSure_loc;
	@FindBy(xpath = "//div[@class='bike_make_name box-shadow-pos ']//div[@class='w--lrcard--left__text']")
	WebElement btn_whichBike_loc;
	@FindBy(xpath = "//div[@class='cf--pill cf--pill--medium  ']//span[text()='Royal Enfield']")
	WebElement btn_royalEnfield_loc;
	@FindBy(xpath = "//h5[text()='Classic 350']")
	WebElement btn_classic350_loc;
	@FindBy(xpath = "//div[text()='350 (349 CC)']")
	WebElement btn_350cc_loc;
	@FindBy(xpath = "//span[text()='2024']")
	WebElement btn_2024_loc;
	@FindBy(xpath = "//div[@class='bike_reg_city_name box-shadow-pos']//div[@class='w--lrcard--left__text']")
	WebElement btn_bikeRegistration_loc;
	@FindBy(xpath = "//h5[text()='Chennai']/parent::div")
	WebElement btn_chennai_loc;
	@FindBy(xpath = "//h5[text()='TN-11']")
	WebElement btn_TN11_loc;
	@FindBy(xpath = "//div[@class='bike_expired_dropdown  fill_height fallback']//div[@class='bike_expired_dropdown__arrow']")
	WebElement btn_policyExpired_loc;
	@FindBy(xpath = "//div[@class='bike_policy_details__item has_arrow ' or text()='Expired']")
	WebElement btn_expired_loc;
	@FindBy(xpath = "//div[text()='Expired before Jan 1, 2025']")
	WebElement btn_expiredBefore_loc;
	@FindBy(xpath = "//button[@class='w--button w--button--orange w--button--large  ' or text()='View Quotes']")
	WebElement btn_viewQuotes_loc;
	@FindBy(xpath = "//div[@class='bph__plans']//span")
	WebElement txt_planResult_loc;

	public void clickBike() {
		highlightElement(btn_bike_loc);
		btn_bike_loc.click();
	}

	public void clickNotSure() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_notSure_loc));
		highlightElement(btn_notSure_loc);
		js.executeScript("arguments[0].click();", btn_notSure_loc);
	}

	public void clickWhichBike() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_whichBike_loc));
		highlightElement(btn_whichBike_loc);
		js.executeScript("arguments[0].click();", btn_whichBike_loc);
	}

	public void clickRoyalEnfield() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_royalEnfield_loc));
		highlightElement(btn_royalEnfield_loc);
		js.executeScript("arguments[0].click();", btn_royalEnfield_loc);
	}

	public void clickClassic350() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_classic350_loc));
		highlightElement(btn_classic350_loc);
		js.executeScript("arguments[0].click();", btn_classic350_loc);
	}

	public void click350CC() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_350cc_loc));
		highlightElement(btn_350cc_loc);
		js.executeScript("arguments[0].click();", btn_350cc_loc);
	}

	public void click2024() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_2024_loc));
		highlightElement(btn_2024_loc);
		js.executeScript("arguments[0].click();", btn_2024_loc);
	}

	public void clickBikeRegistration() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_bikeRegistration_loc));
		highlightElement(btn_bikeRegistration_loc);
		js.executeScript("arguments[0].click();", btn_bikeRegistration_loc);
	}

	public void clickChennai() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_chennai_loc));
		highlightElement(btn_chennai_loc);
		js.executeScript("arguments[0].click();", btn_chennai_loc);
	}

	public void clickTN11() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_TN11_loc));
		highlightElement(btn_TN11_loc);
		js.executeScript("arguments[0].click();", btn_TN11_loc);
	}

	public void clickPolicyExpired() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_policyExpired_loc));
		highlightElement(btn_policyExpired_loc);
		js.executeScript("arguments[0].click();", btn_policyExpired_loc);
	}

	public void clickExpired() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_expired_loc));
		highlightElement(btn_expired_loc);
		js.executeScript("arguments[0].click();", btn_expired_loc);
	}

	public void clickExpiredBefore() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_expiredBefore_loc));
		highlightElement(btn_expiredBefore_loc);
		js.executeScript("arguments[0].click();", btn_expiredBefore_loc);
	}

	public void clickViewQuotes() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_viewQuotes_loc));
		highlightElement(btn_viewQuotes_loc);
		js.executeScript("arguments[0].click();", btn_viewQuotes_loc);
	}

	public String getPlanResult() {
		wait.until(ExpectedConditions.visibilityOf(txt_planResult_loc));
		highlightElement(txt_planResult_loc);
		return txt_planResult_loc.getText();
	}
}
