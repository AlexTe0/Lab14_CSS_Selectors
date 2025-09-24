import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCartAndRemoveTest {
    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void addToCartAndRemoveTest() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.cssSelector("div[data-test='inventory-item-name']")).click();
        driver.findElement(By.id("add-to-cart")).click();
        driver.findElement(By.id("remove")).click();
        driver.findElement(By.id("add-to-cart")).click();
        driver.findElement(By.cssSelector("a[data-test='shopping-cart-link']")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Ciuflea");
        driver.findElement(By.id("last-name")).sendKeys("Spataru");
        driver.findElement(By.id("postal-code")).sendKeys("123456");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();

        WebElement welcomeTextElement = driver.findElement(By.cssSelector("h2[data-test='complete-header']"));
        String expectedText = "Thank you for your order!";
        String actualText = welcomeTextElement.getText();

        Assert.assertEquals(expectedText, actualText);

    }
    @After
    public void quit(){
        driver.close();
    }
}
