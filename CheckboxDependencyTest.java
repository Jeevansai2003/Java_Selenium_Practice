package pages2;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckboxDependencyTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/Jeevan%20sai/OneDrive/Desktop/checkbox.html");
    }

    @Test
    public void testCheckboxDependencies() throws InterruptedException {
        WebElement selectAll = driver.findElement(By.id("selectAll"));
        WebElement option2 = driver.findElement(By.id("option2"));
        WebElement dependent = driver.findElement(By.id("dependent"));

        // Select All
        selectAll.click();
        Assert.assertTrue(driver.findElement(By.id("option1")).isSelected());
        Assert.assertTrue(option2.isSelected());
        Assert.assertTrue(driver.findElement(By.id("option3")).isSelected());

        // Uncheck Option2
        option2.click();
        Assert.assertFalse(option2.isSelected());
        Assert.assertFalse(dependent.isEnabled());

        // Re-check Option2
        option2.click();
        Thread.sleep(500);
        Assert.assertTrue(dependent.isEnabled());

        // Select dependent
        dependent.click();
        Assert.assertTrue(dependent.isSelected());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
