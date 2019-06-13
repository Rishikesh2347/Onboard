import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateProposal extends Exceldata {	
	public static void main(String[] args) throws IOException, Exception{	
		CreateProposal p= new CreateProposal();
		Exceldata XLobj=new Exceldata();
		String username=XLobj.getusername();
		String password=XLobj.getpassword();
		String URL=XLobj.geturl();
		String PT=XLobj.ProposalType();
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebDriverWait wait= new WebDriverWait(driver,60);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("submit-button")).click();
		WebElement Addbutton;
		Addbutton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dark-button_add_proposals")));
		Addbutton.click();
		driver.findElement(By.id("header-agency-listBox")).click();
		driver.findElement(By.xpath("//*[@style=\"display: inline-block; width: 261px;\"]")).sendKeys("OMD canada - T");
		driver.findElement(By.xpath("//*[@class=\"k-virtual-item k-item k-state-focused\"]")).click();
		driver.findElement(By.id("header-advertiser-listBox")).click();
		List<WebElement> Advertiserlist =	driver.findElements(By.xpath("//*[@id=\"header-advertiser_listbox\"]//li"));
		for(int i=0;i<=Advertiserlist.size();i++) {
			if(Advertiserlist.get(i).getText().contains("Acura")) {
				Advertiserlist.get(i).click();
				break;
			}
		}
		driver.findElement(By.id("header-prposal-type-listBox")).click();
		driver.findElement(By.xpath("//*[@id=\"header-prposal-type-list\"]//span//input")).sendKeys(PT);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"header-prposal-type_listbox\"]//li")).click();
		driver.findElement(By.xpath("//*[@id=\"header-channels-listBox\"]/div")).click();
		List<WebElement> channellist =driver.findElements(By.xpath("//*[@id=\"header-channels_listbox\"]//li"));
		for(int i=0;i<channellist.size();i++) {
			if(channellist.get(i).getText().contains("CTV National Network")) {
				channellist.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//*[@id=\"header-brands-listBox\"]//div")).click();
		List<WebElement> brandslist=driver.findElements(By.xpath("//*[@id=\"header-brands_listbox\"]//li"));
		for(int i=0;i<brandslist.size();i++) {
			if (brandslist.get(i).getText().contains("Aco")){
				brandslist.get(i).click();
				break;

			}
		}
		driver.findElement(By.id("decimals")).click();
		driver.findElement(By.xpath("//td[contains(@data-relateelement,\"header-primary-demo\")]")).click();
		List<WebElement> primedemolist=driver.findElements(By.xpath("//*[@id=\"header-primary-demo-list\"]//div[3]//ul//li"));
		for(int i=0;i<primedemolist.size();i++) {
			if (primedemolist.get(i).getText().contains("P25-54")){
				primedemolist.get(i).click();
				break;

			}
		}
		driver.findElement(By.xpath("//td[contains(@data-relateelement,\"header-start\")]//button")).click();
		driver.findElement(By.xpath("//*[contains(@class,\"ui-state-default ui-state-highlight ui-state-active\")]")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[3]/table/tbody/tr[2]/td[7]")).click();
		driver.findElement(By.xpath("//div[contains(@class,\"num-3\")]")).click();
		WebElement Plusbutton;
		Plusbutton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-line-network")));
		Plusbutton.click();
		driver.findElement(By.xpath("//*[@id=\"linearSearchResult\"]/div[3]/table/tbody/tr[1]/td[1]/input")).sendKeys("2");
		driver.findElement(By.xpath("//*[@id=\"linearSearchResult\"]/div[3]/table/tbody/tr[2]/td[1]/input")).sendKeys("4");
		driver.findElement(By.id("lines-search-btn-add-selected")).click();
		driver.findElement(By.xpath("//*[@id=\"requirement-tree-structure-close-btn\"]/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"pSummary\"]/div")) .click();

	}
}
