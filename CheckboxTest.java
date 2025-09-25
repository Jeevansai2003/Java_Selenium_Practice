package pages2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class CheckboxTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/Jeevan%20sai/OneDrive/Desktop/checkbox.html");

        // Select "Select All"
        WebElement selectAll = driver.findElement(By.id("selectAll"));
        selectAll.click(); // Click on "Select All"
        Thread.sleep(1000);

        // Verify all options are checked
        List<WebElement> options = driver.findElements(By.cssSelector("input.option"));
        for (WebElement opt : options) {
            System.out.println(opt.getAttribute("id") + " -> " + opt.isSelected());
        }

        // Uncheck Option 2
        WebElement option2 = driver.findElement(By.id("option2"));
        option2.click(); // uncheck it
        System.out.println("Option2 after uncheck: " + option2.isSelected());

        // Check dependent option
        WebElement dependent = driver.findElement(By.id("dependent"));

        if (dependent.isEnabled()) {
            dependent.click();
            System.out.println("Dependent checkbox clicked ✅");
        } else {
            System.out.println("Dependent checkbox is disabled ❌");
        }

        // Re-check Option2 to enable dependent
        option2.click();
        Thread.sleep(1000); // wait for frontend JS to enable it

        if (dependent.isEnabled()) {
            dependent.click();
            System.out.println("Dependent checkbox enabled and selected ✅");
        }

        driver.quit();
    }
}
