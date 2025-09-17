package maven;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class first_mavenproject {
	  private static final String username = "rsjeevansai2003@gmail.com";
	    private static final String PASSWORD = "Jeevansai#07";
		    public static void main(String[] args) {

		    	        ChromeOptions options = new ChromeOptions();
		    	        options.addArguments("--start-maximized");
		    	        // options.addArguments("--headless"); // Optional

		    	        WebDriver driver = new ChromeDriver(options); // Selenium auto-downloads chromedriver
		    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    	        try {
		    	            driver.get("https://www.linkedin.com/login");
		    	            System.out.println("Opened LinkedIn.");

		    	            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));

		    	            WebElement usernameField = driver.findElement(By.id("username"));
		    	            usernameField.sendKeys(username);

		    	            WebElement passwordField = driver.findElement(By.id("password"));
		    	            passwordField.sendKeys(PASSWORD);

		    	            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		    	            loginButton.click();

		    	            wait.until(ExpectedConditions.titleContains("LinkedIn"));
		    	            String title = driver.getTitle();
		    	            System.out.println("Logged in. Title: " + title);

		    	            if (title.contains("Feed") || title.contains("Home")) {
		    	                System.out.println("✅ Login successful.");
		    	            } else {
		    	                System.out.println("⚠️ Unexpected title.");
		    	            }
		    	            Thread.sleep(5000); // Observe
		    	        } catch (Exception e) {
		    	            System.err.println("❌ Error: " + e.getMessage());
		    	            e.printStackTrace();
		    	        } finally {
		    	            if (driver != null) driver.quit();
		    	            System.out.println("Browser closed.");
		    	        }
	}
}
