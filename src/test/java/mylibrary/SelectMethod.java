package mylibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;


public class SelectMethod {
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
        //select method by using index value
        Select selectDate = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        selectDate.selectByIndex(3);
        ////select method by using direct value number
        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        selectMonth.selectByValue("4");
        // select method without using any direct method
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        List<WebElement> allOption=selectYear.getOptions();
        for (WebElement option :allOption){
            if (option.getText().equals("2021")){
                option.click();
                break;
            }
        }
        //select method using visible value of dropdown
        Select selectMonth1 = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        selectMonth1.selectByVisibleText("March");
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
