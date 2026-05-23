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
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.util.Assert;

import InsuranceAutomation.TermLifeInsurancePage;
import Screenshot.ScreenshotOperations;
import Utilities.ExcelOperations;
@Listeners
public class TermLifeInsuranceTest {
	WebDriver driver;
	TermLifeInsurancePage tp;
   
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
		tp = new TermLifeInsurancePage(driver);
		
	}

	@Test(priority = 2, dependsOnMethods = { "testHomePage" })
	public void testTermLifeNavigation() {
		tp.clickTermLife();
		ScreenshotOperations.takeScreenshot(driver, "testTermLifeNavigation");
	}

	@Test(priority = 3, dependsOnMethods = { "testTermLifeNavigation" })
	public void testTermLifeDetailsEntry() throws IOException {

		tp.clickMale();
		tp.clickAgeDropDown();
		tp.click25Years();
		String name = ExcelOperations.searchtext(6, 1);
        tp.setName(name);
		String mobile = ExcelOperations.searchtext(7, 1);
        tp.setMobileNumber(mobile);
		ScreenshotOperations.takeScreenshot(driver, "testTermLifeDetailsEntry");
		tp.clickViewQuotes();

	}

	@Test(priority = 3, dependsOnMethods = { "testTermLifeDetailsEntry" })
	public void testTermLifeErrorMessages() throws FileNotFoundException, IOException {
		String result = tp.getErrorMessages();
		System.out.println("Error found :"+result);
		ExcelOperations.writeData(result,4,2);
		ScreenshotOperations.takeScreenshot(driver, "testTermLifeErrorMessages");
	}

	@AfterClass
	public void close() {
		driver.quit();
	}
}


