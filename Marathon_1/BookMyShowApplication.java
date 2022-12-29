package Marathon_1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BookMyShowApplication {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions ch = new ChromeOptions();
        ch.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(ch);
        driver.manage().window().maximize();
        driver.get("https://in.bookmyshow.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("(//img[@class='sc-fQkuQJ ciyWra'])[4]")).click();
        driver.findElement(By.xpath("//span[@class='sc-fcdeBU cNeUMt']")).click();
        driver.findElement(By.xpath("//input[@class='sc-hCaUpS cLnzvB']")).sendKeys("Love Today");
        driver.findElement(By.xpath("//strong[text()='Love Today']")).click();
        driver.findElement(By.xpath("//span[text()='Book tickets']")).click();
        String text = driver.findElement(By.xpath("(//a[@class='__venue-name'])[1]")).getText();
        System.out.println("The First Theater name displayed in the list is - " +text);
        driver.findElement(By.xpath("(//div[@class='venue-info-text'])[1]")).click();
        String text2 = driver.findElement(By.xpath("(//div[@class='facility-text'])[4]")).getText();
        //System.out.println(text2);
        String text3 = driver.findElement(By.xpath("//div[text()='            Parking Facility        ']")).getText();
        //System.out.println(text3);
        if(text2.equals(text3))
        {
        	System.out.println("Parking Available");
        }
        driver.findElement(By.className("cross-container")).click();
        driver.findElement(By.xpath("(//div[@class='__details'])[1]")).click();
        driver.findElement(By.id("btnPopupAccept")).click();
        driver.findElement(By.id("pop_1")).click();
        driver.findElement(By.id("proceed-Qty")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='seatI'])[20]/a")).click();
        driver.findElement(By.id("btnSTotal_reserve")).click();
        Thread.sleep(3000);
        String text4 = driver.findElement(By.xpath("//span[@id='ttPrice']")).getText();
        System.out.println("The Subtotal is " +text4);
        File screenshotAs = driver.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
        File dest = new File("./snap/bookMyShow.jpg");
        FileUtils.copyFile(screenshotAs, dest);
        driver.close();       

	}

}
