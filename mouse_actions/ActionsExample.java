package pages2;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class ActionsExample {

	    public static void main(String[] args) {

	        // Setup ChromeDriver
	        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Jeevan sai\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe"); // Update path
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        try {
	            driver.get("https://example.com/actions-demo"); // Replace with your test URL

	            Actions actions = new Actions(driver);

	            // 1️⃣ Context Click (Right Click) Example
	            WebElement rightClickElement = driver.findElement(By.id("rightClickBtn"));
	            actions.contextClick(rightClickElement).perform();
	            System.out.println("Context click performed.");

	            // 2️⃣ Double Click Example
	            WebElement doubleClickElement = driver.findElement(By.id("doubleClickBtn"));
	            actions.doubleClick(doubleClickElement).perform();
	            System.out.println("Double click performed.");

	            // 3️⃣ Drag and Drop Example
	            WebElement source = driver.findElement(By.id("dragSource"));
	            WebElement target = driver.findElement(By.id("dropTarget"));
	            actions.dragAndDrop(source, target).perform();
	            System.out.println("Drag and drop performed.");

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            driver.quit();
	        }
	    }
	}


