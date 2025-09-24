import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest{
    private WebDriver driver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Test
    public void registerWithValidData() {

        driver.findElement(By.cssSelector("a[href^='register']")).click();
        driver.findElement(By.id("customer.firstName")).sendKeys("Ciuflea");
        driver.findElement(By.id("customer.lastName")).sendKeys("Spataru");
        driver.findElement(By.id("customer.address.street")).sendKeys("Str.Smecheriei nr.2");
        driver.findElement(By.id("customer.address.city")).sendKeys("Dolaresti");
        driver.findElement(By.id("customer.address.state")).sendKeys("Smecheresti");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("222333");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("0770111222");
        driver.findElement(By.id("customer.ssn")).sendKeys("123456789");
        driver.findElement(By.id("customer.username")).sendKeys("Ciuflea_Regele");
        driver.findElement(By.id("customer.password")).sendKeys("regeleBanilor3");
        driver.findElement(By.id("repeatedPassword")).sendKeys("regeleBanilor3");
        driver.findElement(By.cssSelector("input[value=\"Register\"]")).click();

        WebElement welcomeTextElement = driver.findElement(By.cssSelector("#rightPanel > h1"));
        String expectedText = "Welcome Ciuflea_Regele";
        String actualText = welcomeTextElement.getText();

        Assert.assertEquals(expectedText, actualText);

    }
    @After
    public void quit(){
        driver.close();
    }
}
