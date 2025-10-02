package CacheClearingScenarios;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ClearCacheBeforePageLoad {

    public static void main(String[] args) throws InterruptedException {

        // Set local ChromeDriver path
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Jeevan sai\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // ChromeOptions for incognito (fresh session)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--disable-application-cache");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

            // Navigate to the target page directly (HTTPS)
            driver.get("https://the-internet.herokuapp.com/");
            System.out.println("✅ Page loaded");

            // Clear cookies, localStorage, sessionStorage
            driver.manage().deleteAllCookies();
            ((JavascriptExecutor) driver).executeScript("window.localStorage.clear(); window.sessionStorage.clear();");
            System.out.println("✅ Cookies, localStorage, and sessionStorage cleared");

            // Add a cookie and verify
            Cookie testCookie = new Cookie("cacheTest", "freshLoad123");
            driver.manage().addCookie(testCookie);
            System.out.println("✅ Cookie added: " + testCookie);

            driver.navigate().refresh();

            Cookie retrievedCookie = driver.manage().getCookieNamed("cacheTest");
            if (retrievedCookie != null) {
                System.out.println("✅ Cookie exists after refresh: " + retrievedCookie);
            } else {
                System.out.println("❌ Cookie not found after refresh");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
