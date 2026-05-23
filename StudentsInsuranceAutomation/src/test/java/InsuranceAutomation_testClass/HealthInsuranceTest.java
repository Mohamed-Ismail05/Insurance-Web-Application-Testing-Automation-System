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

import InsuranceAutomation.HealthInsurancePage;
import Screenshot.ScreenshotOperations;
import Utilities.ExcelOperations;

public class HealthInsuranceTest {

	WebDriver driver;
	HealthInsurancePage hi;
	
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
            hi = new HealthInsurancePage(driver);
	}

	@Test(priority = 2, dependsOnMethods = { "testHomePage" })
	public void testHealthDetailsEntry() throws IOException {

		hi.clickGetStarted();
		hi.clickNext();
		hi.setAge();
		hi.clickAgeNext();
		String pin = ExcelOperations.searchtext(1, 1);
        hi.setPincode(pin);
        String mobile = ExcelOperations.searchtext(2, 1);
        hi.setMobileNumber(mobile);
		ScreenshotOperations.takeScreenshot(driver, "testHealthDetailsEntry");
		hi.clickContinue();
	}

	@Test(priority = 3, dependsOnMethods = { "testHealthDetailsEntry" })
	public void testHealthErrorMessages() throws FileNotFoundException, IOException {
		String result = hi.getErrorMessages();
		System.out.println("Plan found for bike insurance : "+result);
		ExcelOperations.writeData(result,2,1);
		ScreenshotOperations.takeScreenshot(driver, "testHealthErrorMessages");
	}

	@AfterClass
	public void close() {
		driver.quit();
	}
}
