package maven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class AmazonSelectBook {

	public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");

        // Locate the dropdown element
        WebElement categoryDropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // Create Select object
        Select select = new Select(categoryDropdown);

        // Select 'Books' from dropdown
        select.selectByVisibleText("Books");

        System.out.println("Books category selected!");

        // Optionally, search something
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
        driver.findElement(By.id("nav-search-submit-button")).click();

	}

}
