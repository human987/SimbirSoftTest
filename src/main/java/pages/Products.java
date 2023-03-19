package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Products {

    private WebDriver driver;
    private WebElement addToCartButton;
    private WebElement cartIcon;


    public Products(WebDriver driver) {
        this.driver = driver;
        this.addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        this.cartIcon = driver.findElement(By.cssSelector("a.shopping_cart_link"));
    }

    public void clickProducts() {
        addToCartButton.click();
        cartIcon.click();
    }
}