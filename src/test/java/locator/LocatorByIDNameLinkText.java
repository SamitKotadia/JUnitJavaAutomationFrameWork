package locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorByIDNameLinkText {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup(); //run chrome driver setup
        driver = new ChromeDriver(); //created object
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize(); //maximize webpage

        // ID locator
//      driver.findElement(By.id("search_query_top")).sendKeys("T-shirts"); //1st method
        WebElement searchBox = driver.findElement(By.id("search_query_top")); //2nd method
        searchBox.sendKeys("T-Shirts"); //enter value in search box

        // Name locator
        driver.findElement(By.name("submit_search")).click(); //hit submit button

        // link test and partial link test
        // driver.findElement(By.linkText("Printed Chiffon Dress")).click(); //specified full text
        driver.findElement(By.partialLinkText("Chiffon Dress")).click(); //specified partial text
    }
}
