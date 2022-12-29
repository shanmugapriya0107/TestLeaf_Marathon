package Marathon_1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SalesForceApplication {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ch);
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
		String text = "Salesforce Automation by Shanmugapriya";
		driver.findElement(By.xpath("(//input[contains(@class,'slds-input')])[3]"));
		driver.findElement(By.xpath("//input[contains(@name,'CloseDate')]")).sendKeys("12/15/2022");
		driver.findElement(By.xpath("//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		String out = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		if(text.equals(out)) {
			System.out.println("Opportunities are same");
		}
		else 
		{
			System.out.println("Opportunities are not same");
		}

	}

}
