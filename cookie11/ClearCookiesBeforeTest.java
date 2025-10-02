package CookiesManagement;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


public class ClearCookiesBeforeTest {
	    public static void main(String[] args) throws InterruptedException {

	        // ✅ Set local ChromeDriver path
	        System.setProperty("webdriver.chrome.driver",
	                "C:\\Users\\Jeevan sai\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();

	        try {
	            driver.manage().window().maximize();
	            driver.get("https://the-internet.herokuapp.com/");

	            // 1️⃣ Clear cookies at the start
	            driver.manage().deleteAllCookies();
	            System.out.println("✅ All cookies cleared before starting the test");

	            // Optional: Refresh page to ensure no residual session
	            driver.navigate().refresh();
	            Thread.sleep(1000);

	            // 2️⃣ Perform actions — for example, add a cookie
	            Cookie testCookie = new Cookie("sessionTest", "test123");
	            driver.manage().addCookie(testCookie);
	            System.out.println("✅ Cookie added: " + testCookie);

	            // 3️⃣ Refresh and verify cookie
	            driver.navigate().refresh();
	            Thread.sleep(1000);

	            Cookie retrievedCookie = driver.manage().getCookieNamed("sessionTest");
	            if (retrievedCookie != null && "test123".equals(retrievedCookie.getValue())) {
	                System.out.println("✅ Cookie exists after refresh: " + retrievedCookie);
	            } else {
	                System.out.println("❌ Cookie not found or value incorrect");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            driver.quit();
	        }
	    }
	}
