package nopcommerce;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Navigation {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void myTest() {
        driver.findElement(By.xpath("//li//a[contains(text(),'Computers ')][1]")).click();
        driver.findElement(By.cssSelector("a[title='Show products in category Desktops']")).click();
        driver.findElement(By.xpath("//a[text()='Build your own computer']")).click();
        String productName = driver.findElement(By.cssSelector("div[class='product-name'] h1")).getText();
        System.out.println("you are on " + productName);
        driver.findElement(By.xpath("//option[contains(text(),'2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]')]")).click();
        driver.findElement(By.cssSelector("option[data-attr-value='5']")).click();
        driver.findElement(By.cssSelector("[for='product_attribute_3_7']")).click();
        WebElement os = driver.findElement(By.xpath("//label[contains(text(),'Vista Premium')]"));
        os.click();
        System.out.println(os.isSelected());
        driver.findElement(By.xpath("//label[contains(text(),'Acrobat Reader [+$10.00]')]")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']")).click();
        String noti = driver.findElement(By.xpath("//div[@id='bar-notification']")).getText();
        System.out.println(noti);
        driver.findElement(By.xpath("//a[@class='ico-cart']")).click();
        String cart = driver.findElement(By.xpath("//a[@class='product-name']")).getText();
        System.out.println(cart);


    }

    @After
    public void tearDown() {
        driver.close();
    }

}
