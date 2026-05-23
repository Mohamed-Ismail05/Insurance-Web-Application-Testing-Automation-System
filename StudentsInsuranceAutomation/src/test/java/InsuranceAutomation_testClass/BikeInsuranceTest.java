package InsuranceAutomation_testClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import InsuranceAutomation.BikeInsurancePage;
import Screenshot.ScreenshotOperations;
import Utilities.ExcelOperations;

public class BikeInsuranceTest {

	WebDriver driver;
	BikeInsurancePage bp;
	   
	    @BeforeClass
	    @Parameters({"browser"})
	    public void driverSetup(String browser) throws IOException {
	          switch (browser.toLowerCase()) {
	                    case "chrome":
	                        driver = new ChromeDriver();
	                        break;

	                    case "edge":
	                        driver = new EdgeDriver();
	                        break;

	                    default:
	                        AssertJUnit.fail("Invalid Browser Provided: " + browser);

	        }
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	            driver.manage().window().maximize();
	    }

	@Test(priority = 1)
	public void testHomePage() throws FileNotFoundException, IOException {
            driver.get("https://www.coverfox.com/");
            bp = new BikeInsurancePage(driver);
	
	}

	@Test(priority = 2, dependsOnMethods = { "testHomePage" })
	public void testBikeNavigation() {
		bp.clickBike();
		ScreenshotOperations.takeScreenshot(driver, "testBikeNavigation");
	}

	@Test(priority = 3, dependsOnMethods = { "testBikeNavigation" })
	public void testBikeDetailsEntry() {

		bp.clickBike();
		bp.clickNotSure();
		bp.clickWhichBike();
		bp.clickRoyalEnfield();
		bp.clickClassic350();
		bp.click350CC();		
		bp.click2024();	
		ScreenshotOperations.takeScreenshot(driver, "testBikeDetailsEntry");

	}
	
	@Test(priority = 4, dependsOnMethods = { "testBikeDetailsEntry" })
	public void testBikeRegistrationDetailsEntry() {

		bp.clickBikeRegistration();
		bp.clickChennai();
		bp.clickTN11();
		ScreenshotOperations.takeScreenshot(driver, "testBikeRegistrationDetailsEntry");

	}
	
	@Test(priority = 5 , dependsOnMethods = { "testBikeRegistrationDetailsEntry" })
	public void testBikePolicyExpiredDetailsEntry() {

		bp.clickPolicyExpired();
		bp.clickExpired();
		bp.clickExpiredBefore();
		ScreenshotOperations.takeScreenshot(driver, "testBikePolicyExpiredDetailsEntry");
		bp.clickViewQuotes();	

	}
	
	@Test(priority = 6, dependsOnMethods = { "testBikePolicyExpiredDetailsEntry" })
	public void testBikePlanResult() throws FileNotFoundException, IOException {
		String result = bp.getPlanResult();
		System.out.println("Plan found for bike insurance : "+result);
		ExcelOperations.writeData(result,1,1 );
		ScreenshotOperations.takeScreenshot(driver, "testBikePlanResult");
	}

	@AfterClass
	public void close() {
		driver.quit();
	}
}
