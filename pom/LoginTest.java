package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class LoginTest {

    WebDriver driver;
    HomePage home;
    LoginPage login;

    @BeforeMethod
    public void setup() {
        // Set path if necessary: System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");

        home = new HomePage(driver);
        login = new LoginPage(driver);
    }

    @Test
    public void testInvalidLogin() {
        home.clickSignIn(); // Clicks "Signup / Login"
        login.login("fake@example.com", "wrongpassword"); // Attempt invalid login
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
