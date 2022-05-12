package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Main {

    static String DRIVER_TYPE = "webdriver.chrome.driver";
    static String DRIVER_FILE = "./drivers/chromedriver_v101.exe";
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello Selenium World.");

        // Chrome
        System.setProperty(DRIVER_TYPE, DRIVER_FILE);
        ChromeDriver driver = new ChromeDriver();

        // Maximizes window to show the full content (the "Try for free" button)
        driver.manage().window().maximize();

        driver.get("https://actitime.com");
        System.out.println(driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        String text = "Try Free";
        driver.findElement(By.linkText(text)).click();

        Thread.sleep(300);

        // First Name
        driver.findElement(By.xpath("/html//input[@id='First Name']")).sendKeys("Todd");

        // Last Name
        String LAST_NAME = "Last Name";
        driver.findElement(By.id(LAST_NAME)).sendKeys("Booth");

        // Email
        driver.findElement(By.cssSelector("input#Email")).sendKeys("SomeEmail@Gmail.Com");

        // Company
        String COMPANY = "Company";
        driver.findElement(By.id(COMPANY)).sendKeys("Luleå University of Technology");

        // Submit button
        driver.findElement(By.xpath("/html//a[@id='confirm-button']")).click();

        // Clean up manually
        driver.manage().deleteAllCookies();
        driver.close();
    }
}