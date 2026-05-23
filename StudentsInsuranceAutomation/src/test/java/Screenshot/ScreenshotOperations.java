package Screenshot;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class ScreenshotOperations {
    public static void takeScreenshot(WebDriver driver, String fileName) {
        // Cast the WebDriver instance to TakesScreenshot
        TakesScreenshot sc = (TakesScreenshot) driver;
        // Capture the screenshot and store it as a file
        File screenshot = sc.getScreenshotAs(OutputType.FILE);
        // Define the destination file path
        File destination = new File(System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".png");
        try {
            // Copy the file to the destination path
            FileUtils.copyFile(screenshot, destination);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
