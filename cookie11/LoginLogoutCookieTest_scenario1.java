package CookiesManagement;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginLogoutCookieTest_scenario1 {

    public static void main(String[] args) {

        // ✅ Use local ChromeDriver
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Jeevan sai\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/login");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Login
            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            username.sendKeys("tomsmith");

            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("SuperSecretPassword!");

            WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
            loginBtn.click();

            wait.until(ExpectedConditions.urlContains("/secure"));
            System.out.println("✅ Login successful!");

            // Logout
            WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/logout']")));
            logoutBtn.click();

            Thread.sleep(1000); // wait for logout

            // Delete cookies and refresh
            driver.manage().deleteAllCookies();
            driver.navigate().refresh();

            // Verify login page
            try {
                WebElement loginForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
                System.out.println("✅ Cookies cleared, login form visible.");
            } catch (TimeoutException e) {
                System.out.println("❌ User still logged in or login form not visible.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
