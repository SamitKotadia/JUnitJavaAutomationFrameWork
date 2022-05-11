package nopcommerce;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    String url = "https://demo.nopcommerce.com/";
    WebElement registration;
    String firstName = "samit";
    String lastName = "Kotadia";
    String password = "12345678";
    String confirmPassword = password;
    String myEmail= "samit@samit.co.uk";

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        registration = driver.findElement(By.className("ico-register"));
        registration.click();

    }
    @Test
    public void test1() {
        System.out.println("This is my registration test");
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        driver.findElement(By.id("Email")).sendKeys(myEmail);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
        driver.findElement(By.id("register-button")).submit();
        String text1= driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).getText();
        System.out.println("successfully register "+text1);
        driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
    }
    @Test
    public void test2() {
        System.out.println("This is my login test");
        driver.findElement(By.className("ico-login")).click();
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(myEmail);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).submit();
        String text1= driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).getText();
        System.out.println("i can see \""+text1+"\" button");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
