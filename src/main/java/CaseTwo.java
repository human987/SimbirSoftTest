import jdk.jfr.Description;
import jdk.jfr.Name;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class CaseTwo {

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
    @Name("Кейс 2")
    @Description("Проверка ошибки входа")
    public void testErrorLogin() {
        LoginPage login = new LoginPage(driver);

        //Login
        login.login("test", "test");
        login.click();

        // Найти сообщение об ошибке
        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));

        // Проверить, что сообщение соответствует ожидаемому
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        if (errorMessage.getText().equals(expectedErrorMessage)) {
            System.out.println("Тест успешно пройден");
        } else {
            System.out.println("Тест не пройден");
        }

    }

}
