package locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorCSSTagClassAndAttribute {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://en-gb.facebook.com/");
        driver.manage().window().maximize(); //maximize webpage

        // Customized CCS locator by Tag ,Class and Attribute
        // tag,class and Attribute (Tag Name.Class value[Attribute name = attribute value])
        // we can use to identified unique element
        driver.findElement(By.cssSelector("input.inputtext[data-testid=royal_email]")).sendKeys("myemail");
        // inserting value if ID
        driver.findElement(By.cssSelector("input.inputtext[data-testid=royal_pass]")).sendKeys("xyz");
        // inserting value of password
    }
}
