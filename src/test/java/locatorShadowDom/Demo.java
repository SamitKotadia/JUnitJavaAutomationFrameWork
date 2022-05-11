package locatorShadowDom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://books-pwakit.appspot.com/");
        driver.manage().window().maximize();
//        driver.findElement(By.xpath("//input[@id='input']")).sendKeys("testing"); //http://seleniumhq.org/exceptions/no_such_element.html
//        driver.findElement(By.cssSelector("input#input")).sendKeys("testing1"); //http://seleniumhq.org/exceptions/no_such_element.html
        WebElement root=driver.findElement(By.tagName("book-app")); //shadow host / root element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadowDom1 = (WebElement) js.executeScript("return argument[0].shadowRoot",root);

        WebElement appHeader = shadowDom1.findElement(By.tagName("app-header"));
        WebElement appToolbar = appHeader.findElement(By.cssSelector("app-toolbar.toolbar-bottom"));
        WebElement bookInput = appToolbar.findElement(By.tagName("book-input-decorator"));
        bookInput.findElement(By.cssSelector("input#input")).sendKeys("testing123");


//        driver.close();
    }
}
