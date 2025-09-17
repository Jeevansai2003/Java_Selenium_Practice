package maven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class SelectAllCheckboxes {

	public static void main(String[] args) {
		
		        WebDriver driver = new ChromeDriver();
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		        try {
		            // Open the DemoQA checkbox page
		            driver.get("https://demoqa.com/checkbox"); // Fixed URL (extra spaces removed)

		            // Optional: Maximize window
		            driver.manage().window().maximize();

		            // Wait for at least one checkbox icon to be visible
		            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".rct-checkbox")));

		            // Find all VISIBLE checkbox icons (not hidden <input>)
		            List<WebElement> checkboxIcons = driver.findElements(By.cssSelector(".rct-checkbox"));

		            System.out.println("Found " + checkboxIcons.size() + " checkbox icons.");

		            // Loop through each checkbox icon and click it
		            for (int i = 0; i < checkboxIcons.size(); i++) {
		                WebElement icon = checkboxIcons.get(i);

		                // Scroll into view
		                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", icon);

		                icon.click();
		                System.out.println("Clicked checkbox #" + (i + 1));

		                // Pause to allow UI to update
		                Thread.sleep(500);
		            }

		            System.out.println("All checkboxes have been selected.");

		        } catch (Exception e) {
		            System.err.println("An error occurred: " + e.getMessage());
		            e.printStackTrace();
		        } finally {
		            try {
		                // Safe sleep before quitting
		                Thread.sleep(4000);
		            } catch (InterruptedException e) {
		                System.err.println("Sleep interrupted in finally block: " + e.getMessage());
		                Thread.currentThread().interrupt(); // Restore interrupted state
		            }
		            driver.quit(); // Close browser
		        }
		    }
		}