package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaveenAuto {
    WebDriver driver;
    String url = "https://naveenautomationlabs.com/opencart/index.php?route=common/home";
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
        registration = driver.findElement(By.xpath("//a[title='My Account']"));
        registration.click();
    }

    //Successful regisation Testcase
    @Test
    public void test1() {
        System.out.println("This is my 1 test");

    }


    @After
    public void tearDown() throws InterruptedException {
//        Thread.sleep(3000);
        driver.close();
    }
}
