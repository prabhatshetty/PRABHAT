package Selenium_Training;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RelAddCart {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
		driver.get("https://www.reliancedigital.in/");
		String parent = driver.getWindowHandle();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='Cameras']"))).perform();
		driver.findElement(By.id("wzrk-confirm")).click();
		actions.moveToElement(driver.findElement(By.xpath("//div[text()='Cameras']"))).perform();
		driver.findElement(By.xpath("//a[text()='DSLR Cameras']")).click();
		//Thread.sleep(5000);
		//Alert alertPopUp1 = driver.switchTo().alert();
	//	alertPopUp1.dismiss();
		driver.findElement(By.xpath("//p[text()='Nikon D810 DSLR Camera with 24 - 120 mm NIKKOR VR Lens Kit']")).click();
		//driver.switchTo().window(parent);
		Set<String> windowIds = driver.getWindowHandles();
		windowIds.remove(parent);
		for(String windowId:windowIds) {
			driver.switchTo().window(windowId);
		}
		String a = driver.getTitle();
		System.out.println(a);
		driver.findElement(By.id("RIL_PDPInputPincode")).sendKeys("560070");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("add_to_cart_main_btn")));
		driver.findElement(By.id("add_to_cart_main_btn")).click();
		driver.findElement(By.id("btn-goto-checkout")).click();
		driver.quit();
		
		
		
		
		
		//driver.quit();
		//div[contains(@class,'sp grid')])[1]
		//actions.moveToElement(driver.findElement(By.xpath("//div[text()='Cameras']"))).perform();
		
		
		
		//driver.findElement(By.xpath("//div[contains(text(),'Yes, Notify me')]")).click();
		//driver.findElement(By.id("validationMessage")).getText();
		//actions.doubleClick(addIcon).perform();
		//driver.findElement(By.xpath("//div[text()='Selenium Practise']")).click();
		//driver.quit();
	}

}
