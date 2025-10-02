package ExceptionHandlingScenarios;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SafeElementHandling {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Jeevan sai\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

            driver.get("https://the-internet.herokuapp.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            try {
                // Wait for the element to be visible
                WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("div#content h1"))); // adjust selector

                System.out.println("✅ Element found: " + header.getText());

            } catch (TimeoutException | NoSuchElementException e) {
                // Handle element not found within expected time
                System.out.println("⚠ Element not found or not loaded in time. Continuing test...");
            }

            // Continue with other test steps safely
            System.out.println("✅ Test continues even if element is missing.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
