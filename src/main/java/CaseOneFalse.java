import jdk.jfr.Description;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Checkout;
import pages.LoginPage;
import pages.Products;


public class CaseOneFalse {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\paulz\\Desktop\\SimbirSoftTest\\SimbirSoftTest\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterTest
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void testOrder() {
        LoginPage login = new LoginPage(driver);
        Checkout checkout = new Checkout(driver);
        Products products = new Products(driver);

        //Login
        login.login("standard_user", "secret_sauce");
        login.click();

        //Products
        products.clickProducts();

        //Checkout
        checkout.clickcheckoutButton();
        checkout.addKeys("test", "test", "test");
        checkout.clickContinue();

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
    }

}
