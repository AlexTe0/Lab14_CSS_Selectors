import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    public void loginWithValidData()  {

        driver.findElement(By.cssSelector(".login .input")).sendKeys("Ciuflea_Regele");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("regeleBanilor3");
        driver.findElement(By.cssSelector("input[type=submit]")).click();

        WebElement welcomeTextElement = driver.findElement(By.cssSelector("#rightPanel > h1"));
        String expectedText = "Welcome!";
        String actualText = welcomeTextElement.getText();

        Assert.assertEquals(expectedText, actualText);

    }

    @After
    public void quit(){
        driver.close();
    }
}
