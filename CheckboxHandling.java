package pages2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class CheckboxHandling {
    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:\\Users\\Jeevan sai\\OneDrive\\Desktop\\checkbox.html");
        // 1. Select All
        WebElement selectAll = driver.findElement(By.id("selectAll"));
        selectAll.click(); // Click "Select All"

        // Verify all options are selected
        List<WebElement> options = driver.findElements(By.cssSelector("input.option"));
        for (WebElement opt : options) {
            if (opt.isSelected()) {
                System.out.println(opt.getAttribute("id") + " is selected ✅");
            }
        }

        // 2. Uncheck one option (Option 2 for example)
        WebElement option2 = driver.findElement(By.id("option2"));
        if (option2.isSelected()) {
            option2.click(); // deselect it
        }

        // When Option 2 is unchecked, disable dependent checkbox
        WebElement dependent = driver.findElement(By.id("dependent"));
        if (!option2.isSelected() && dependent.isEnabled()) {
            // Custom logic (if the app disables it dynamically you may just verify)
            System.out.println("Dependent option should now be disabled ❌");
        }

        // 3. Enable dependent checkbox only if Option 2 is checked
        option2.click(); // re-select Option 2
        Thread.sleep(1000); // wait for frontend JS to enable dependent

        if (dependent.isEnabled()) {
            dependent.click();
            System.out.println("Dependent option is enabled and now selected ✅");
        }

        driver.quit();
    }
}
