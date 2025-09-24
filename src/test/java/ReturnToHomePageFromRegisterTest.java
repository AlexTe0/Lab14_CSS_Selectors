import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReturnToHomePageFromRegisterTest {
    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }
    @Test
    public void returnToHomePageFromRegister(){
        driver.findElement(By.cssSelector("a[href^='register']")).click();
        driver.findElement(By.cssSelector("ul.button li.home a")).click();

        WebElement atmServices = driver.findElement(By.cssSelector("li.captionone"));
        Assert.assertTrue(atmServices.isDisplayed());
    }

    @After
    public void quit(){
        driver.close();
    }
}
