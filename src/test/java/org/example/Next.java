package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Next {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.next.co.uk/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[text()='Accept All']")).click();
        driver.findElement(By.xpath("//input[@id='header-big-screen-search-box']")).sendKeys("T-shirt");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }
}
