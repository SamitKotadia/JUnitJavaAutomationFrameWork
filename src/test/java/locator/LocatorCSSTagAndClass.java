package locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorCSSTagAndClass {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://en-gb.facebook.com/");
        driver.manage().window().maximize(); //maximize webpage

        // Customized CCS locator by Tag and Class
        // tag and Class (name of tag.value of Class) tag and id separated by . key
        driver.findElement(By.cssSelector("input.inputtext")).sendKeys("smith"); //Tag is optional
//      driver.findElement(By.cssSelector(".inputtext")).sendKeys("smith");
    }
}
