package Selenium_Training;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompareIphonePrice {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		String parent = driver.getWindowHandle();
		driver.findElement(By.xpath("//span[text()='Hello, Sign in']/..")).click();
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("9482928782",Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("Prabhatshetty@",Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(" Apple iPhone 13 (128GB) - Starlight ",Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Apple iPhone 13 (256GB) - Starlight']")).click();
		//Set<String> windowIds = driver.getWindowHandles();
		for(String windowId:driver.getWindowHandles()) {
			driver.switchTo().window(windowId);
		}
		 WebElement a = driver.findElement(By.xpath("//span[text()=' 83,900.00 ']"));
		 Thread.sleep(5000);
			String price = a.getText();
			
			
			String Amazamount = price.replaceAll("[,a-zA-Z0-9]", "");
		System.out.println(Amazamount);
		
			//String realprice = price.substring(0,9);
		//char[] Amazarrayrate=realprice.toCharArray();
	//	String Amazamount="";
		/*for(char z:Amazarrayrate)
		{
			if(z>=48 && z<=57)
			{
				Amazamount=Amazamount+z;
			}
		}*/	
			double finalamazcost = Double.parseDouble(Amazamount); 
			//int finalamazcost = Integer.parseInt(Amazamount);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
		search.sendKeys(" Apple iPhone 13 (128GB) - Starlight ",Keys.ENTER);
		driver.navigate().refresh();
		driver.findElement(By.xpath("//div[text()='APPLE iPhone 13 (Starlight, 256 GB)']")).click();
		Set<String> windowIdss = driver.getWindowHandles();
		//windowIds.remove(parent);
		for(String windowId:windowIdss) {
			driver.switchTo().window(windowId);
		}
		
		WebElement b = driver.findElement(By.xpath("//div[.='₹84,900']"));
		
		String priceF = b.getText();
		char[] arrayrate=priceF.toCharArray();
		String amount="";
		for(char z:arrayrate)
		{
			if(z>=48 && z<=57)
			{
				amount=amount+z;
			}
		}
		double finalflipcost = Double.parseDouble(Amazamount);
		//double finalflipcost = Integer.parseInt(amount);
		System.out.println("cost of iPhone 13 (256GB) - Starlight on flipkart Rs:"+finalflipcost);
		System.out.println("cost of iPhone 13 (256GB) - Starlight on Amazon Rs:"+Amazamount);
		double d=finalamazcost-finalflipcost;
		double e=finalflipcost-finalamazcost;
		if(finalflipcost<finalamazcost)
		{
			System.out.println("Price of iPhone 13 (256GB) - Starlight price on flipkart is RS."+d+"than Amazon");
		}
		else
		{
			System.out.println("Price of iPhone 13 (256GB) - Starlight on Amazon is RS."+e+" less than flipkart");

		}
		driver.quit();
			
	}	
}
