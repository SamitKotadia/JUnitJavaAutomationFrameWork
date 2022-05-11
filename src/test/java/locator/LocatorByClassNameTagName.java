package locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorByClassNameTagName {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize(); //maximize webpage

        // className locator
        // created int object and store value in sliders
        int sliders = driver.findElements(By.className("homeslider-container")).size();
        // size count how many element is returning by this statement // counting slide
        System.out.println("in this webpage we have " + sliders + " sliders");
        // printing total number of slides in webpage

        //tegName locator
        //a href = refer to anchor tag i.e always refer to links
        int links = driver.findElements(By.tagName("a")).size();
        System.out.println("in this webpage we have total " + links + " links");
    }
}
