package CookiesManagement;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class addcookietest {
	    public static void main(String[] args) throws InterruptedException {

	        // ✅ Set local ChromeDriver path
	        System.setProperty("webdriver.chrome.driver",
	                "C:\\Users\\Jeevan sai\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();

	        try {
	            driver.manage().window().maximize();
	            driver.get("https://the-internet.herokuapp.com/"); // any page for testing

	            // 1️⃣ Create a new cookie
	            Cookie myCookie = new Cookie("testCookie", "cookieValue123");
	            driver.manage().addCookie(myCookie);
	            System.out.println("✅ Cookie added: " + myCookie);

	            // 2️⃣ Refresh the page
	            driver.navigate().refresh();
	            Thread.sleep(1000); // small wait for refresh

	            // 3️⃣ Verify cookie exists
	            Cookie retrievedCookie = driver.manage().getCookieNamed("testCookie");
	            if (retrievedCookie != null && "cookieValue123".equals(retrievedCookie.getValue())) {
	                System.out.println("✅ Cookie exists and has correct value after reload: " + retrievedCookie);
	            } else {
	                System.out.println("❌ Cookie not found or value incorrect");
	            }

	            // Optional: print all cookies
	            Set<Cookie> allCookies = driver.manage().getCookies();
	            System.out.println("All cookies on the page:");
	            for (Cookie c : allCookies) {
	                System.out.println(c);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            driver.quit();
	        }
	    }
	}
