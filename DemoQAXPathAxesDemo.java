package maven;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

	public class DemoQAXPathAxesDemo {

	    private WebDriver driver;
	    private WebDriverWait wait;

	    public DemoQAXPathAxesDemo() {
	        // Optional: Set chromedriver path if not in PATH
	        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        this.driver = new ChromeDriver();
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Increased timeout
	    }

	    public void launch() {
	        driver.get("https://demoqa.com/text-box");
	        driver.manage().window().maximize();
	        System.out.println("Page loaded: https://demoqa.com/text-box");
	    }

	    public void fillUserName() {
	        try {
	            // Directly find by ID or placeholder
	            WebElement userNameInput = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.id("userName"))
	            );
	            userNameInput.sendKeys("Jeevan sai");
	            System.out.println("Filled Username using ID.");
	        } catch (Exception e) {
	            System.err.println("Failed to fill username: " + e.getMessage());
	        }
	    }

	    public void fillUserEmail() {
	        try {
	            WebElement emailInput = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.id("userEmail"))
	            );
	            emailInput.sendKeys("jeevansai@example.com");
	            System.out.println("Filled Email using ID.");
	        } catch (Exception e) {
	            System.err.println("Failed to fill email: " + e.getMessage());
	        }
	    }

	    public void fillCurrentAddress() {
	        try {
	            WebElement addressTextarea = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.id("currentAddress"))
	            );
	            addressTextarea.sendKeys("789 Oak Avenue, bangalore");
	            System.out.println("Filled Current Address.");
	        } catch (Exception e) {
	            System.err.println("Failed to fill address: " + e.getMessage());
	        }
	    }

	    public void clickSubmitButton() {
	        try {
	            WebElement submitButton = wait.until(
	                ExpectedConditions.elementToBeClickable(By.id("submit"))
	            );

	            // Scroll into view to avoid ad overlay
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);

	            // Wait again after scroll
	            wait.until(ExpectedConditions.elementToBeClickable(submitButton));

	            // Try normal click first
	            submitButton.click();
	            System.out.println("Submit button clicked successfully.");
	        } catch (ElementClickInterceptedException e) {
	            System.out.println("Normal click blocked. Using JavaScript click as fallback.");
	            WebElement submitButton = driver.findElement(By.id("submit"));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
	        } catch (Exception e) {
	            System.err.println("Failed to click submit: " + e.getMessage());
	        }
	    }

	    public void verifyOutput() {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));

	            String nameOutput = driver.findElement(By.id("name")).getText();
	            String emailOutput = driver.findElement(By.id("email")).getText();
	            String addressOutput = driver.findElement(By.xpath("//p[@id='currentAddress']")).getText();

	            System.out.println("Output - Name: " + nameOutput);
	            System.out.println("Output - Email: " + emailOutput);
	            System.out.println("Output - Current Address: " + addressOutput);
	        } catch (Exception e) {
	            System.err.println("Failed to verify output: " + e.getMessage());
	        }
	    }

	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	            System.out.println("Browser closed.");
	        }
	    }

	    public static void main(String[] args) {
	        DemoQAXPathAxesDemo demo = new DemoQAXPathAxesDemo();

	        try {
	            demo.launch();
	            demo.fillUserName();
	            demo.fillUserEmail();
	            demo.fillCurrentAddress();
	            demo.clickSubmitButton();
	            demo.verifyOutput();

	            Thread.sleep(3000); // Pause to view results

	        } catch (InterruptedException e) {
	            System.err.println("Test interrupted: " + e.getMessage());
	        } finally {
	            demo.tearDown();
	        }
	    }
	}

