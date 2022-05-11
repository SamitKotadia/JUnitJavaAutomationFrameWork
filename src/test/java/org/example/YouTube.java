package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YouTube {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//tp-yt-paper-button[@id='button' and @aria-label='Accept the use of cookies and other data for the purposes described']")).click();
        driver.findElement(By.xpath("//yt-icon[@id='guide-icon']")).click();
        //driver.findElement(By.xpath("//input[@id='search']")).sendKeys("why does it always rain on me");
        //driver.findElement(By.cssSelector("input#search")).sendKeys("abc");
       // driver.close();
      //  driver.findElement(By.xpath("//*[@id=\"video-title\"]")).click();
    }
}
