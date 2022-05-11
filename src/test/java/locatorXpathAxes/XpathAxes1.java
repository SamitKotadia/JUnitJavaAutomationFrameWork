package locatorXpathAxes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class XpathAxes1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
        driver.manage().window().maximize();

        // self - Selects the current node
        String text = driver.findElement(By.xpath("//a[contains(text(),'GHCL')]/self::a")).getText();
        System.out.println("This value is form Self Xpath " + text);

        //Parent-selects the parent of the node/tag (always one)
        text = driver.findElement(By.xpath("//a[contains(text(),'GHCL')]/parent::td")).getText();
        System.out.println("This value is form Parent Xpath " + text);

        // Child Element-select all children of self(one or many) self Element dont have child/ancestor/all child of ancestor
        List<WebElement> child = driver.findElements(By.xpath("//a[contains(text(),'GHCL')]/ancestor::tr/child::td"));
        System.out.println("Number of Child Element " + child.size());

        //Ancestor - select all ancestor (parent, grandparent, etc)
        text = driver.findElement(By.xpath("//a[contains(text(),'GHCL')]/ancestor::tr")).getText();
        System.out.println("This data form Ancestor Xpath " + text);

        //Descendants - select all descendant (children, grandchildren, etc)
        List<WebElement> descendants = driver.findElements(By.xpath("//a[contains(text(),'GHCL')]/ancestor::tr/descendant::*"));
        System.out.println("Number of total descendants node/Tag " + descendants.size());

        //Following - select everything in document after closing tag of the current node
        List<WebElement> followingNodes = driver.findElements(By.xpath("//a[contains(text(),'GHCL')]/ancestor::tr/following::tr"));
        System.out.println("Number of following Nodes " + followingNodes.size());

        //Following-sibling - select all sibling after the current node
        List<WebElement> followingSibling = driver.findElements(By.xpath("//a[contains(text(),'GHCL')]/ancestor::tr/following-sibling::tr"));
        System.out.println("Number of following sibling " + followingSibling.size());

        //Preceding - select all nodes that appear before the current node in the document
        List<WebElement> precedingNode = driver.findElements(By.xpath("//a[contains(text(),'GHCL')]/ancestor::tr/preceding::tr"));
        System.out.println("Number of preceding Node " + precedingNode.size());

        //Preceding-sibling - select all sibling before the current node
        List<WebElement> precedingSibling = driver.findElements(By.xpath("//a[contains(text(),'GHCL')]/ancestor::tr/preceding-sibling::tr"));
        System.out.println("Number of preceding-sibling Node " + precedingSibling.size());

        driver.close();
    }
}
