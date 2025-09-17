package maven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AmazonParentAxisExample {
	public static void main(String[] args) {
        // Set up WebDriver (make sure chromedriver is in PATH)
        WebDriver driver = new ChromeDriver();
        
        // Open Amazon
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        // Locate the search input box
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        System.out.println("Search box placeholder: " + searchBox.getAttribute("placeholder"));

        // Locate the parent <div> of the input using parent axis
        WebElement parentDiv = driver.findElement(
            By.xpath("//input[@id='twotabsearchtextbox']/parent::div")
        );
        System.out.println("Parent DIV class: " + parentDiv.getAttribute("class"));

        // Locate the parent <form> of the input (two levels up)
        WebElement parentForm = driver.findElement(
            By.xpath("//input[@id='twotabsearchtextbox']/parent::div/parent::form")
        );
        System.out.println("Parent FORM tag name: " + parentForm.getTagName());

        // Close browser
        driver.quit();
    }

}
