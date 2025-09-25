package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    By header = By.xpath("//h1[@class='page-heading']");

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }
}
