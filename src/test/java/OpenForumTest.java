import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenForumTest {
    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }
    @Test
    public void openForumTest(){
        driver.findElement(By.cssSelector("a[href='http://forums.parasoft.com/']")).click();
        driver.findElement(By.cssSelector("div.linkContentClassName")).click();

        WebElement atmServices = driver.findElement(By.cssSelector("#page > div.page-minHeight > div.Frame > div > main > div.Frame-content > div > div > div > div:nth-child(1) > nav > span > span > a > span"));
        Assert.assertTrue(atmServices.isDisplayed());
    }

    @After
    public void quit(){
        driver.close();
    }
}
