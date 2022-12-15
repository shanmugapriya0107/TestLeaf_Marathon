package Thursday_Marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class SalesForceApplication {
	public static void main(String[] args) throws InterruptedException {
		EdgeOptions ch=new EdgeOptions();
        ch.addArguments("--disable-notifications");
        EdgeDriver driver = new EdgeDriver(ch);
        driver.manage().window().maximize();
        driver.get("https://login.salesforce.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com"); //Using id locator
		driver.findElement(By.id("password")).sendKeys("Testleaf$321"); //Using id locator
		driver.findElement(By.xpath("//input[@class='button r4 wide primary']")).click(); //Using className locator
        driver.findElement(By.xpath("(//div[@class='tooltipTrigger tooltip-trigger uiTooltip'])[6]")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        Thread.sleep(3000);
        WebElement findElement = driver.findElement(By.xpath("//span[text()='Opportunities']"));
        driver.executeScript("arguments[0].click();",findElement);
        driver.findElement(By.xpath("//div[text()='New']")).click();
        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Shanmugapriya");
        
	}
}
