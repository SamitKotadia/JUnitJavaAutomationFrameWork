package locator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorXpathOperator1 {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        // Xpath with 'contains()'
        driver.findElement(By.xpath("//input[contains(@id,'top')]")).sendKeys("T-shirt");

        // Xpath with 'starts-with'
        driver.findElement(By.xpath("//button[starts-with(@type,'s')]")).click();

        //clicking on home page button
        driver.findElement(By.xpath("//i[@class='icon-home']")).click();

        // Xpath with 'text()'
        // on link we can user linktext, partial linktext or text() method
        driver.findElement(By.xpath("//a[text()='Women']")).click(); //this is women tab

        //chained Xpath
        driver.findElement(By.xpath("//div[@id='contact-link']//a")).click();
    }

}
