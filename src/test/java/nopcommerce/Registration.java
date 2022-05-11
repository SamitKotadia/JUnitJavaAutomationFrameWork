package nopcommerce;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.ServerRequestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class Registration {
    WebDriver driver;
    String url = "https://demo.nopcommerce.com/";
    WebElement registration;
    String firstName = "samit";
    String lastName = "Kotadia";
    double randomNumber = Math.random();
    String password = "12345678";
    String confirmPassword = password;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        registration = driver.findElement(By.className("ico-register"));
        registration.click();
    }

    //Successful regisation Testcase
    @Test
    public void test1() {
        System.out.println("This is my 1 test");
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
//        System.out.println("My FirstName "+firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
//        System.out.println("My LastName "+lastName);
        WebElement findEmailBox = driver.findElement(By.id("Email"));
        String email = firstName + randomNumber + "@" + firstName + ".co.uk";
        System.out.println(email);
        findEmailBox.sendKeys(email);
//        findEmailBox.sendKeys(firstName+randomNumber+"@"+firstName+".co.uk");
//        System.out.println(findEmailBox);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
        driver.findElement(By.id("register-button")).submit();
        String text1= driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).getText();
        System.out.println("Successful login -"+text1);
        driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
    }
    //Adding special char in first name and last name
    @Test
    public void test2(){
        System.out.println("This is my 2 test");
        driver.findElement(By.id("FirstName")).sendKeys("1234@321");
        driver.findElement(By.id("LastName")).sendKeys("@234");
        WebElement findEmailBox = driver.findElement(By.id("Email"));
        String email = firstName + randomNumber + "@" + firstName + ".co.uk";
        System.out.println(email);
        findEmailBox.sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
        driver.findElement(By.id("register-button")).submit();
//        String text2= driver.findElement(By.xpath("//span[contains(text(),'First name is required.')]")).getText();
//        System.out.println("Unsuccessful Login -"+text2);
    }
    //enter blank spaces in mandatory field i.e First Name, Last Name
    @Test
    public void test3(){
        System.out.println("This is my 3 test");
        driver.findElement(By.id("FirstName")).sendKeys("      ");
        driver.findElement(By.id("LastName")).sendKeys("       ");
        WebElement findEmailBox = driver.findElement(By.id("Email"));
        String email = firstName + randomNumber + "@" + firstName + ".co.uk";
        System.out.println(email);
        findEmailBox.sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
        driver.findElement(By.id("register-button")).submit();
        String text3= driver.findElement(By.xpath("//span[contains(text(),'First name is required.')]")).getText();
        System.out.println("Unsuccessful Login -"+text3);
    }
    // enter password less then min password length i.e 6 character
    @Test
    public void test4(){
        System.out.println("This is my 4 test");
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        WebElement findEmailBox = driver.findElement(By.id("Email"));
        String email = firstName + randomNumber + "@" + firstName + ".co.uk";
        System.out.println(email);
        findEmailBox.sendKeys(email);
        String pass = "sam";
        driver.findElement(By.id("Password")).sendKeys(pass);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(pass);
        driver.findElement(By.id("register-button")).submit();
        String text4= driver.findElement(By.xpath("//li[contains(text(),'must have at least 6 characters')]")).getText();
        System.out.println("Unsuccessful Login -"+text4);
    }
    //enter invalid confirm password
    @Test
    public void test5(){
        System.out.println("This is my 5 test");
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        WebElement findEmailBox = driver.findElement(By.id("Email"));
        String email = firstName + randomNumber + "@" + firstName + ".co.uk";
        System.out.println(email);
        findEmailBox.sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys("samitkot");
        driver.findElement(By.id("register-button")).submit();
        String text5= driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText();
        System.out.println("Unsuccessful Login -"+text5);
    }
    //enter Email text field that has an Email address without @ symbol dot (.)
    @Test
    public void test6(){
        System.out.println("This is my 6 test");
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        driver.findElement(By.id("Email")).sendKeys("sam@sacom");
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        driver.findElement(By.id("register-button")).submit();
        String text6= driver.findElement(By.xpath("//li[contains(text(),'Wrong email')]")).getText();
        System.out.println("Unsuccessful Login -"+text6);
    }
    //enter duplicate email address
    @Test
    public void test7(){
        System.out.println("This is my 7 test");
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        driver.findElement(By.id("Email")).sendKeys("samit@samit.com");
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        driver.findElement(By.id("register-button")).submit();
        String text7= driver.findElement(By.xpath("//li[contains(text(),'The specified email already exists')]")).getText();
        System.out.println("Unsuccessful Login -"+text7);
    }

    @After
    public void tearDown() throws InterruptedException {
//        Thread.sleep(3000);
        driver.close();
    }
}
