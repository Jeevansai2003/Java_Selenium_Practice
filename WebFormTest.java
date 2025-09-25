package pages1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebFormTest {

    private WebDriver driver;
    private WebFormPage webFormPage;

    @BeforeMethod
    public void setup() {
        // ✅ No driver path needed — Selenium Manager handles it!
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        webFormPage = new WebFormPage(driver);
    }

    @Test
    public void testAllSevenLocators() {
        System.out.println("🚀 Starting test...");

        // 1. Text input
        System.out.println("📝 Entering text...");
        webFormPage.enterText("Hello Selenium!");

        // 2. Password input
        System.out.println("🔒 Entering password...");
        webFormPage.getPasswordInput().sendKeys("secret123");
        sleep(1000);

        // 3. Checkbox
        System.out.println("☑️ Checking checkbox...");
        webFormPage.checkCheckbox();

        // 4. Dropdown
        System.out.println("🔽 Selecting dropdown option...");
        webFormPage.selectDropdownOption("Option 2");

        // 5. Submit button
        System.out.println("📤 Submitting form...");
        webFormPage.submitForm();

        // 6. Form element (verify presence)
        System.out.println("📋 Verifying form element...");
        Assert.assertNotNull(webFormPage.getFormElement(), "Form element should be present");

        // 7. Partial link text — still exists!
        System.out.println("🔗 Verifying documentation link...");
        Assert.assertTrue(webFormPage.getDocumentationLink().isDisplayed(), "Documentation link should be visible");

        System.out.println("✅ ALL 7 LOCATORS WORKED WITH DELAYS — TEST PASSED!");
    }

    // Helper to add delay — used in test for visibility
    private void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}