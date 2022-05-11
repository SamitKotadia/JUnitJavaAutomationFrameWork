package locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorCSSTagAndID {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://en-gb.facebook.com/");
        driver.manage().window().maximize(); //maximize webpage

        // Customized CCS locator by Tag and ID
        // tag and ID (name of tag#vlaue of ID) tag and id separated by # key
        driver.findElement(By.cssSelector("#email")).sendKeys("David"); //Tag is optional
//      driver.findElement(By.cssSelector("input#email")).sendKeys("David");
    }
}
