package Thursday_Marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedbusApplication {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions ch=new ChromeOptions();
        ch.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(ch);
        driver.manage().window().maximize();
        driver.get("https://www.redbus.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
        driver.findElement(By.xpath("//li[text()='Chennai']")).click();
        driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bengaluru");
        driver.findElement(By.xpath("//li[text()='Bengaluru']")).click();
        driver.findElement(By.xpath("//td[@class='wd day']")).click();
        driver.findElement(By.id("search_btn")).click();
        String text = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
        System.out.println(text+ " " +"found");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//i[@class='icon icon-close']")).click();
        WebElement findElement = driver.findElement(By.xpath("//label[text()='SLEEPER']"));
        driver.executeScript("arguments[0].click();",findElement);
        String text2 = driver.findElement(By.xpath("//div[text()='V2K Travels']")).getText();
        System.out.println("The Name of the Second bus in the Resulting list is " +text2);
        driver.findElement(By.xpath("(//div[@class='button view-seats fr'])[2]")).click();

	}

}
