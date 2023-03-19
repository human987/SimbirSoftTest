package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Checkout {

    private WebDriver driver;
    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement zipCodeField;
    private WebElement continueButton;
    private WebElement finishButton;
    private WebElement checkoutButton;


    public Checkout (WebDriver driver) {
        this.driver = driver;
        this.firstNameField = driver.findElement(By.id("first-name"));
        this.lastNameField = driver.findElement(By.id("last-name"));
        this.zipCodeField = driver.findElement(By.id("postal-code"));
        this.continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        this.finishButton = driver.findElement(By.id("finish"));
        this.checkoutButton = driver.findElement(By.id("checkout"));
    }

    public void clickcheckoutButton() {
        checkoutButton.click();
    }

    public void addKeys (String firstName, String  lastName, String zipCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        zipCodeField.sendKeys(zipCode);
    }

    public void clickContinue() {
        continueButton.click();
        finishButton.click();
    }
}