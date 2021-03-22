import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JUMIATest {
    public WebDriver driver;

    @BeforeTest
    public void Chrome() {

        System.setProperty("webdriver.chrome.driver",
                "./driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.jumia.com.eg/customer/account/login/");

    }
    @Test(priority = 0)
    public void JUMIALogin() {

        WebElement username = driver.findElement(By.id("fi-email"));
        username.sendKeys("nariman@yahoo.com");

       WebElement password = driver.findElement(By.id("fi-password"));
       password.sendKeys("dog");

        WebElement Login = driver.findElement(By.xpath("//button[@class='btn _prim _i -mts']"));
        Login.click();



        WebElement checkbox = driver.findElement(By.xpath("//label[text()='Remember me']"));
        boolean flag2 = checkbox.isSelected();
        System.out.println(flag2);
        if(flag2)      //true
        {
            System.out.println("checkbox is already selected");
        }
        else  //false

            System.out.println("select checkbox");
            checkbox.click();

        String actualUrl="https://www.jumia.com.eg/customer/account/login/";
        String expectedUrl=driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

    }



 @Test(priority = 1)
    public void SearchCart() {
        WebElement pressCart=driver.findElement(By.id("ci"));
        pressCart.click();
     WebElement startShopping=driver.findElement(By.xpath("//span[@class='-fs-14']"));
         startShopping.click();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

     WebElement searchInput =driver.findElement(By.id("fi-q"));
         searchInput.sendKeys("Garnier");
     WebElement search =driver.findElement(By.xpath("//button[@class='btn _prim _md -mls -fsh0']"));
    search.click();





 }




    @Test(priority = 2)
    public void NegativeScenario() {

        WebElement pass = driver.findElement(By.id("fi-password"));
        pass.sendKeys("password");

        WebElement Login = driver.findElement(By.xpath("//button[@class='btn _prim _i -mts']"));
        Login.click();

        WebElement checkbox = driver.findElement(By.xpath("//label[text()='Remember me']"));
        boolean flag2 = checkbox.isSelected();
        System.out.println(flag2);
        if(flag2)      //true
        {
            System.out.println("checkbox is already selected");
        }
        else  //false

            System.out.println("select checkbox");
        checkbox.click();


        WebElement username = driver.findElement(By.id("fi-email"));
        if(username.isDisplayed()) {
            username.sendKeys("email");
            System.out.println("required field ");
        }else{
            System.out.println("username is  clear");

        }
    }





    }


