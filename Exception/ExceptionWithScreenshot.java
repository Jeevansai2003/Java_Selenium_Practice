package ExceptionHandlingScenarios;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class ExceptionWithScreenshot {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Jeevan sai\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

            driver.get("https://the-internet.herokuapp.com/dynamic_controls");

            // Intentionally trying to locate a non-existent element to trigger an exception
            try {
                WebElement missingElement = driver.findElement(By.id("nonExistent"));
                missingElement.click();
            } catch (Exception e) {
                System.out.println("❌ Exception occurred: " + e.getClass().getName());
                System.out.println("Message: " + e.getMessage());

                // Capture screenshot
                takeScreenshot(driver, "Exception_Screenshot.png");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    // Method to take screenshot
    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), Paths.get(fileName));
            System.out.println("✅ Screenshot saved: " + fileName);
        } catch (IOException ioe) {
            System.out.println("❌ Failed to save screenshot: " + ioe.getMessage());
        }
    }
}



