package locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorCSSTagAndAttribute {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://en-gb.facebook.com/");
        driver.manage().window().maximize(); //maximize webpage

        // Customized CCS locator by Tag and Attribute
        // tag and Attribute (name of tag[Attribute name = attribute value])
        // We can select any Attribute
        //driver.findElement(By.cssSelector("input[data-testid=royal_email]")).sendKeys("john"); //Tag is optional
        driver.findElement(By.cssSelector("[data-testid=royal_email]")).sendKeys("john1");
    }
}
