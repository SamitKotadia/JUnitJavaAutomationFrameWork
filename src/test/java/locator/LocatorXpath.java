package locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorXpath {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        // Absolute Xpath (full Xpath)
//        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[2]/form[1]/input[4]")).sendKeys("t-shirt");
//        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")).click();
//
        // Relative Xpath (partial Xpath)
        driver.findElement(By.xpath("//input[@name=\"search_query\"]")).sendKeys("t-shirt");
        //input[@name=\"search_query\"] we can remove \" error by replacing with '
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
//        driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("t-shirt");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//

    }
}
