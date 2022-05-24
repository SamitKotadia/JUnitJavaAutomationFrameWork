package mylibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class Element {
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void myTest() {
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();

        // find only 1 element
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        searchBox.sendKeys("samit");
        // find only first element in all the listed element
        //we can directly access element
        WebElement footer=driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
        System.out.println(footer.getText());
        //when no element found its throw exception --> no_such_element.html
        // WebElement search=driver.findElement(By.xpath("//button[normalize-space()='login']"));


        //find multi elements
        //list<Element> its store into list and list is collection form java
        List<WebElement> footer1=driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
        System.out.println(footer1.size());
        // we need to iterate the list of element
        for(WebElement element:footer1){
            System.out.println(element.getText());
        }
        // we can use elements method to find single element
        List<WebElement> logo=driver.findElements(By.xpath("//img[@alt='nopCommerce demo store']"));
        System.out.println(logo.size());
        //when no element found its return 0 value
        List<WebElement> search1=driver.findElements(By.xpath("//button[normalize-space()='login']"));
        System.out.println(search1.size());
    }

    @After
    public void tearDown() {
        //driver.close();
    }

}

