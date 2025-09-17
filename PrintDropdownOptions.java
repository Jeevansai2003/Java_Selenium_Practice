package maven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class PrintDropdownOptions {
		    public static void main(String[] args) {
		    	
		    	        WebDriver driver = new ChromeDriver();
		    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    	        try {
		    	            // Navigate to Select Menu page
		    	            driver.get("https://demoqa.com/select-menu");
		    	            driver.manage().window().maximize();

		    	            // Wait for the dropdown to be present
		    	            wait.until(d -> d.findElement(By.id("oldSelectMenu")));

		    	            // Locate the dropdown element
		    	            WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));

		    	            // Get all options inside the dropdown
		    	            List<WebElement> options = dropdown.findElements(By.tagName("option"));

		    	            System.out.println("Dropdown options in 'Old Style Select Menu':");
		    	            System.out.println("===========================================");

		    	            for (WebElement option : options) {
		    	                String value = option.getAttribute("value");
		    	                String text = option.getText();
		    	                System.out.println("Value: " + value + " | Text: " + text);
		    	            }

		    	        } catch (Exception e) {
		    	            System.err.println("An error occurred: " + e.getMessage());
		    	            e.printStackTrace();
		    	        } finally {
		    	            try {
		    	                Thread.sleep(3000);
		    	            } catch (InterruptedException e) {
		    	                Thread.currentThread().interrupt();
		    	            }
		    	            driver.quit();
		    	        }
		    	    }
		    	}