package locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorXpathOperator {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        // Xpath with 'or'
        driver.findElement(By.xpath("//input[@id=\"search_query_top\" or @name=\"search_query1\"]")).sendKeys("T-shirt");
        // 2nd condition is false but it's still locate element

        // Xpath with 'and'
        driver.findElement(By.xpath("//button[@type=\"submit\" and @name=\"submit_search\"]")).click();
        //Both condition is true
    }

}
