import jdk.jfr.Description;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class CaseOneTrue {

    @Test
    @Name("Кейс 1")
    @Description("Проверка успешной покупки")
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\paulz\\Desktop\\SimbirSoftTest\\SimbirSoftTest\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.saucedemo.com/");

        // Заполнение поля Username значением standard_user, используя XPath
        WebElement usernameField = driver.findElement(By.cssSelector("input#user-name"));
        usernameField.sendKeys("standard_user");

        // Заполнение поля Password значением secret_sauce, используя ID
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        // Нажатие на кнопку LOGIN, используя CSS-селектор
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        // Положить первый продукт в корзину
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();

        // Нажимаем на иконку корзины
        WebElement cartIcon = driver.findElement(By.cssSelector("a.shopping_cart_link"));
        cartIcon.click();

        // Нажимаем кнопку CHECKOUT на странице корзины
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        //Заполняем поля
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        firstNameField.sendKeys("test");

        WebElement lastNameField = driver.findElement(By.id("last-name"));
        lastNameField.sendKeys("test");

        WebElement zipCodeField = driver.findElement(By.id("postal-code"));
        zipCodeField.sendKeys("test");

        // Нажать на кнопку CONTINUE
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        // Нажать на кнопку FINISH
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();

        // Ожидание для загрузки страницы завершения покупки
         Thread.sleep(500);

        // Проверка перехода на страницу "https://www.saucedemo.com/checkout-complete.html"
        String expectedUrl = "https://www.saucedemo.com/checkout-complete.html";
        String actualUrl = driver.getCurrentUrl();
        assert expectedUrl.equals(actualUrl);

        if (expectedUrl.equals(actualUrl)) {
            System.out.println("Переход осуществлен");
        } else {
            System.out.println("Переход не осуществлен");
        }

        // Проверка наличия сообщения об успешном оформлении заказа
        WebElement messageElement = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']"));
        String message = messageElement.getText();
        assert message.equals("Thank you for your order!");

        if (message.equals("Thank you for your order!")) {
            System.out.println("Тест успешно пройден");
        } else {
            System.out.println("Тест не пройден");
        }

        // Закрыть браузер
        driver.quit();
    }
}
