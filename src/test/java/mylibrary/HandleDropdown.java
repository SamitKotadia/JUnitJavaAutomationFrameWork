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


public class HandleDropdown {
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
        WebElement selectDate = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        option(selectDate, "5");
        WebElement selectMonth = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        option(selectMonth, "April");
        WebElement selectYear = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        option(selectYear, "2020");
    }

    public void option(WebElement ele, String value) {
        Select drop = new Select(ele);
        List<WebElement> allOption = drop.getOptions();
        for (WebElement option : allOption)
            if (option.getText().equals(value)) {
                option.click();
                break;
            }
    }

    @After
    public void tearDown() {
        driver.close();
    }
}

