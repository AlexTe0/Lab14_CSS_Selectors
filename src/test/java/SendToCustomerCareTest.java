import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendToCustomerCareTest {
    private WebDriver driver;
    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }
    @Test
    public void sendToCustomerCare(){
        driver.findElement(By.cssSelector("#footerPanel ul:first-of-type li:nth-of-type(8) > a")).click();
        driver.findElement(By.cssSelector("#name")).sendKeys("Ciuflea Spataru");
        driver.findElement(By.cssSelector("#email")).sendKeys("sefulabani@bombardiermail.com");
        driver.findElement(By.cssSelector("#phone")).sendKeys("Samsung S24 Ultra");
        driver.findElement(By.cssSelector("#message")).sendKeys("I am escape from polis, giv me free money");
        driver.findElement(By.cssSelector("#contactForm > table > tbody > tr:nth-child(5) > td:nth-child(2) > input")).click();

        WebElement welcomeTextElement = driver.findElement(By.cssSelector("#rightPanel p:nth-of-type(2)"));
        String expectedText = "A Customer Care Representative will be contacting you.";
        String actualText = welcomeTextElement.getText();
    }
    @After
    public void quit(){
        driver.close();
    }
}
