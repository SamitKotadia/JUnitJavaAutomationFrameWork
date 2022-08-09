package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyPrestice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://admin-demo.nopcommerce.com/login");
        driver.manage().window().maximize();

        WebElement email= driver.findElement(By.id("Email"));
        email.clear();
        email.sendKeys("samit");
        Thread.sleep(5000);
        driver.close();
    }
}
