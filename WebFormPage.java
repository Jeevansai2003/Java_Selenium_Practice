package pages1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class WebFormPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public WebFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ✅ All 7 working locators — NO LINK TEXT!
    public WebElement getTextInput() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("my-text-id")));
    }

    public WebElement getPasswordInput() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.name("my-password")));
    }

    public WebElement getSubmitButton() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn")));
    }

    public WebElement getFormElement() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("form")));
    }

    public WebElement getDropdown() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name='my-select']")));
    }

    public WebElement getCheckBox() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']")));
    }

    // ✅ Partial link text — still works on the page!
    public WebElement getDocumentationLink() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("documentation")));
    }

    // Helper methods
    public void enterText(String text) {
        getTextInput().clear();
        getTextInput().sendKeys(text);
        sleep(1000); // 👈 Delay after typing
    }

    public void selectDropdownOption(String value) {
        getDropdown().sendKeys(value);
        sleep(1000); // 👈 Delay after selecting
    }

    public void submitForm() {
        getSubmitButton().click();
        sleep(1500); // 👈 Delay after submit — page may respond
    }

    public void checkCheckbox() {
        getCheckBox().click();
        sleep(1000); // 👈 Delay after clicking checkbox
    }

    // Utility method to pause execution
    private void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Sleep interrupted: " + e.getMessage());
        }
    }
}