package CacheClearingScenarios;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerifyFreshContentAfterCacheClear {

    public static void main(String[] args) {

        // 1️⃣ Set local ChromeDriver path
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Jeevan sai\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // 2️⃣ ChromeOptions: incognito session, disable cache
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-application-cache");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

            // 3️⃣ Navigate to page
            driver.get("https://the-internet.herokuapp.com/"); // example page
            System.out.println("✅ Page loaded");

            // 4️⃣ Clear cookies and local/session storage
            driver.manage().deleteAllCookies();
            ((JavascriptExecutor) driver).executeScript(
                    "window.localStorage.clear(); window.sessionStorage.clear();");
            System.out.println("✅ Cookies, localStorage, and sessionStorage cleared");

            // 5️⃣ Refresh page to load fresh content
            driver.navigate().refresh();

            // 6️⃣ Verify a dynamic element (example: "Available Examples" header)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("div#content h1"))); // adjust selector based on page
            String headerText = header.getText();
            System.out.println("✅ Header text after cache clear: " + headerText);

            // Example assertion: check if header text is correct (fresh)
            if (headerText.equals("Welcome to the-internet")) {
                System.out.println("✅ Page content is fresh after cache clear.");
            } else {
                System.out.println("❌ Page content may be stale.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
    