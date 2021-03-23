import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SOUQTest {

    public WebDriver driver;
    @BeforeTest
    public void Chrome() {

        System.setProperty("webdriver.chrome.driver",
                "./driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://egypt.souq.com/eg-en/auth_portal.php?action=index");

    }


    @Test(priority = 0)
    public void SOUQLogin() {

        WebElement Email = driver.findElement(By.id("email"));
        Email.sendKeys("nariman@yahoo.com");

 String expectedHeading = "nariman@yahoo.com";

        String email = driver.findElement(By.id("email")).getText();

        if(expectedHeading.equalsIgnoreCase(email))
            System.out.println("the InputField is empty  --- "+email);
        else
            System.out.println("the InputField is not empty --- "+email);

        WebElement LOGIN = driver.findElement(By.id("siteLogin"));
        LOGIN.click();



        String actualUrl="https://egypt.souq.com/eg-en/auth_portal.php?action=index";
        String expectedUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }

    @Test(priority = 1)
    public void NegativeScenario(){

        if (driver.findElement(By.id("email")).isDisplayed() == false) {
            driver.findElement(By.id("siteLogin")).click();
            System.out.println("The Button is present. Exiting!!");

        }
        else
        {
            System.out.println("The Button isn't present. Exiting!!");

        }
    }




}
