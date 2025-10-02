package ExceptionHandlingScenarios;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandleStaleElement {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Jeevan sai\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

            driver.get("https://the-internet.herokuapp.com/dynamic_controls"); // Example page

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            int retries = 3;
            while (retries > 0) {
                try {
                    // Locate element
                    WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(
                            By.cssSelector("button[onclick='swapCheckbox()']")));

                    removeButton.click(); // Perform action
                    System.out.println("✅ Button clicked successfully.");
                    break; // Exit loop if successful

                } catch (StaleElementReferenceException e) {
                    System.out.println("⚠ Element became stale. Retrying...");
                    retries--;
                } catch (TimeoutException e) {
                    System.out.println("❌ Element not found within timeout.");
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
