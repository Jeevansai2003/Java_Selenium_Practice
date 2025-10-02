package pages2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActionsExample {
    public static void main(String[] args) throws InterruptedException {
        // Manual ChromeDriver path (matching your Chrome 140)
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jeevan sai\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        // 1. Context Click
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement rightClickBtn = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));

        actions.contextClick(rightClickBtn).perform();
        Thread.sleep(2000);

        // 2. Double Click
        WebElement doubleClickBtn = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        actions.doubleClick(doubleClickBtn).perform();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        // 3. Drag and Drop
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        WebElement source = driver.findElement(By.xpath("//a[text()=' 5000 ']"));
        WebElement target = driver.findElement(By.id("amt7"));
        actions.dragAndDrop(source, target).perform();
        Thread.sleep(2000);

        driver.quit();
    }
}
