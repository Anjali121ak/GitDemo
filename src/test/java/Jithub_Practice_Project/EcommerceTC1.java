package Jithub_Practice_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class EcommerceTC1 extends BaseTest
{
	@Test
	public void Login() throws InterruptedException
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"));		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Australia']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Anjali");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		/*On Appium inspector we cant see the message, we will use Tagname toast message based on which toast i want we should mention
		 * we will call xpath message of the toast can be retrived from get attribut
		 we should grab the toast message using gett attribute by calling xpath msg of the widget toast tagname and stor it in string*/
		
		/*ToastMessage
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage,"Please enter your name");*/
		
		/*When we have same id but user wants to select any specific item and add to cart then we will scann all the product name 
		 * using FindElements - It will get all the id which have same text, Size- Method which will give no of items returns with plural findelements
		 * it will pass the size into variable [product name]*/
		 
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"));"));
		
		//Listing all the items and storing it in productname variable
		int productCount= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for (int i=0; i<productCount; i++)
		{
			//checking the matching productname name if its matching moving to if condition and clicking on add to cart link
			String productName= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productName.equalsIgnoreCase("Jordan Lift Off"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//Explicitliy waiting till the next page gets losdded
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		String lastProduct= driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(lastProduct,"Jordan Lift Off");
			
		
	}
	

	// Change the reflect in gitdemo user
	// Change the reflect in gitdemo user
	// Change the reflect in gitdemo use
	
	@Test
	public void Gitdemo1action()
	{
		System.out.println("today work on gitdemoproject");
		System.out.println("today work on gitdemoproject");
		
	}
	
	@Test
	public void Gitdemo1action2()
	{
		System.out.println("today work on gitdemoproject");
		System.out.println("today work on gitdemoproject");
		
	}
	
	@Test
	public void Gitstuffaction()
	{
		System.out.println("Updated work on gitstuff 8 feb 2023");
		
	}
	
	@Test
	public void developaction()
	{
		System.out.println("new update from develop branch 8 feb 2023 by gitdemo");
		System.out.println("new update from develop branch 8 feb 2023 by gitdtuff as final commit");
		
	}


}
