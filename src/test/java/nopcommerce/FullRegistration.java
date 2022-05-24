package nopcommerce;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import static org.openqa.selenium.By.cssSelector;


public class FullRegistration {
    WebDriver driver;
    double myNumber = Math.random();
    String password = "samit123";
    String confirmPassword = password;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void myTest1() {
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.xpath("//div[@class='page-title']/child::h1")).getText();
        WebElement maleBtn = driver.findElement(cssSelector("#gender-male"));
        maleBtn.click();
        System.out.println("Male radio Btn is selected -- " + maleBtn.isSelected());
        driver.findElement(By.id("FirstName")).sendKeys("Samit");
        driver.findElement(By.id("LastName")).sendKeys("kotadia");
        Select selectDate = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        selectDate.selectByIndex(3);
        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        selectMonth.selectByValue("4");
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        selectYear.selectByVisibleText("2000");
        WebElement findEmailBox = driver.findElement(By.id("Email"));
        String email = "samit" + myNumber + "@" + "sk.co.uk";
        System.out.println(email);
        findEmailBox.sendKeys(email);
        driver.findElement(By.id("Company")).sendKeys("Marvel");
        WebElement newsLetter = driver.findElement(cssSelector("input#Newsletter"));
        newsLetter.click();
        newsLetter.click();
        System.out.println(newsLetter.isSelected());
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
        driver.findElement(By.id("register-button")).submit();
        String regi = driver.findElement(By.xpath("//div[text()='Your registration completed']")).getText();
        System.out.println(regi);
        String display = driver.findElement(By.cssSelector("a.ico-logout")).getText();
        System.out.println(display);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
