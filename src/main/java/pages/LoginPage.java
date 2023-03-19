package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginPage {


    private WebDriver driver;
    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement loginButton;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
        // Найти поле Username
        this.usernameField = driver.findElement(By.cssSelector("input#user-name"));

        // Найти поле Password
        this.passwordField = driver.findElement(By.id("password"));

        // Найти кнопку Login
        this.loginButton = driver.findElement(By.cssSelector("input[value='Login']"));
    }


    public void login(String login, String pass) {
        usernameField.sendKeys(login);
        passwordField.sendKeys(pass);
    }

    public void click() {
        loginButton.click();
    }
}
