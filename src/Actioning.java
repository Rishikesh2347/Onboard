import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Actioning {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("1234");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		alert.accept();
		driver.get("http://jqueryui.com/droppable/");
		Actions action =new Actions(driver);
		driver.switchTo().frame(0);
		WebElement From=driver.findElement(By.id("draggable"));
		WebElement TO=driver.findElement(By.id("droppable"));
		action.dragAndDrop(From, TO).build().perform();	
		String Adrop=driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText();
		System.out.println(Adrop);
		String Edrop="Dropped!";	
		SoftAssert sassert=new SoftAssert();
		sassert.assertEquals(Adrop, Edrop);
			if(Adrop.equals(Edrop)) {
			System.out.println("PASS");
		}
		else{
			System.out.println("Fail");
			Assert.assertEquals(Adrop, Edrop);

		}

		driver.get("http://jqueryui.com/tooltip/");
		driver.switchTo().frame(0);
		WebElement age=driver.findElement(By.id("age"));
		action.moveToElement(age).build().perform();
		String Text= driver.findElement(By.xpath("//*[contains(@aria-live,\"assertive\")]//div[1]")).getText();
		System.out.println(Text);
		String Text1="We ask for your age only for statistical purposes.";
			Assert.assertEquals(Text, Text1);
		if(Text.equals(Text1)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("Fail");
		}
		sassert.assertEquals(Text,Text1);
		 
	}

}

