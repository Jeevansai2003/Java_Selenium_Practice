package pages2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class ActionsExampleFixed {
    public static void main(String[] args) {

        // Point directly to chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe"); // Path to downloaded ChromeDriver

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://example.com/actions-demo"); // Replace with your test URL

            Actions actions = new Actions(driver);

            // Context click (right click)
            WebElement rightClickElement = driver.findElement(By.id("rightClickBtn"));
            actions.contextClick(rightClickElement).perform();

            // Double click
            WebElement doubleClickElement = driver.findElement(By.id("doubleClickBtn"));
            actions.doubleClick(doubleClickElement).perform();

            // Drag and drop
            WebElement source = driver.findElement(By.id("dragSource"));
            WebElement target = driver.findElement(By.id("dropTarget"));
            actions.dragAndDrop(source, target).perform();

            System.out.println("✅ Actions performed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
