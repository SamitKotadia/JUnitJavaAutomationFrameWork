package mylibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class GetAndNavigate {
    RemoteWebDriver driver;
    //webdriver class belongs to remoteweb driver..for background coding need to put remote
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void myTest() {
        driver.get("https://demo.nopcommerce.com/");
        driver.navigate().to("https://www.next.co.uk/"); //on back this method use get method
        // click on navigate>remotenavigation>to method using get method only
        // ctrl+chick on method to see code
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
