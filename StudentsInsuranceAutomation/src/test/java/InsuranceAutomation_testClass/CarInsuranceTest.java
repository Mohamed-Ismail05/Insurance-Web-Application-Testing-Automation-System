package InsuranceAutomation_testClass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import InsuranceAutomation.CarInsurancePage;
import Screenshot.ScreenshotOperations;
import Utilities.ExcelOperations;

public class CarInsuranceTest {

    WebDriver driver;
    CarInsurancePage cp;
    
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
    public void testHomePage() throws IOException {
            driver.get("https://www.coverfox.com/");
            
            cp = new CarInsurancePage(driver);
       
    }

    @Test(priority = 2, dependsOnMethods = {"testHomePage"})
    public void testCarNavigation() {
        cp.clickCar();
        ScreenshotOperations.takeScreenshot(driver, "CarNavigation");
    }

    @Test(priority = 3, dependsOnMethods = {"testCarNavigation"})
    public void testCarDetailsEntry() throws IOException {
        cp.clickClickHere();
        cp.clickFord();
        cp.clickMustang();
        cp.clickPetrol();
        cp.clickV8();
        cp.clickChennai();
        cp.click2023();
        cp.clickNotExpired();
        cp.clickNo();

        // Read test data from Excel
        String mobile = ExcelOperations.searchtext(11, 1);
        AssertJUnit.assertNotNull(mobile, "Mobile number is missing in the Excel file.");
        cp.setMobileNumber(mobile);

        ScreenshotOperations.takeScreenshot(driver, "testCarDetailsEntry");
        cp.clickViewQuotes();
    }

    @Test(priority = 4, dependsOnMethods = {"testCarDetailsEntry"})
    public void testCarErrorMessages() throws IOException {
        String result = cp.getErrorMessages();
        System.out.println("Error found: " + result);
        AssertJUnit.assertNotNull(result, "Error messages are empty.");
        ExcelOperations.writeData(result, 3, 2);
        ScreenshotOperations.takeScreenshot(driver, "testCarErrorMessages");
    }

    @AfterClass
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
