import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgotLoginInfoTest {
    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }
    @Test
    public void forgotLoginInfo() {
        driver.findElement(By.cssSelector("a[href^='lookup']")).click();
        driver.findElement(By.cssSelector("input#firstName")).sendKeys("Ciuflea");
        driver.findElement(By.cssSelector("input#lastName")).sendKeys("Spataru");
        driver.findElement(By.cssSelector("input#address\\.street")).sendKeys("Str.Smecheriei nr.2");
        driver.findElement(By.cssSelector("input#address\\.city")).sendKeys("Dolaresti");
        driver.findElement(By.cssSelector("input#address\\.state")).sendKeys("Smecheresti");
        driver.findElement(By.cssSelector("input#address\\.zipCode")).sendKeys("222333");
        driver.findElement(By.cssSelector("input#ssn")).sendKeys("123456789");
        driver.findElement(By.cssSelector("input.button[value='Find My Login Info']"));

        WebElement welcomeTextElement = driver.findElement(By.cssSelector("h1.title"));
        String expectedText = "Successfully retrieved login info!";
        String actualText = welcomeTextElement.getText();

        Assert.assertEquals(expectedText, actualText);

    }

    @After
    public void quit(){
        driver.close();
    }
}
