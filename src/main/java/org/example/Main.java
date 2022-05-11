package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World.");

        // Chrome
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_v101.exe");
        ChromeDriver driver = new ChromeDriver();

        // Maximizes window to show the full content (the "Try for free" button)
        driver.manage().window().maximize();

        driver.get("https://actitime.com");
        System.out.println(driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        String text = "Try Free";
        driver.findElement(By.linkText(text)).click();

        Thread.sleep(300);

        String first_name = "First Name";
        driver.findElement(By.xpath("/html//input[@id='First Name']")).sendKeys("Todd");

        String last_name = "Last Name";
        driver.findElement(By.id(last_name)).sendKeys("Booth");

        String email = "Email";
        driver.findElement(By.id(email)).sendKeys("SomeEmail@Gmail.Com");

        String company = "Company";
        driver.findElement(By.id(company)).sendKeys("Luleå University of Technology");
    }
}