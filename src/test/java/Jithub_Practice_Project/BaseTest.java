package Jithub_Practice_Project;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest 
{
	//All the Reuses utilities will be stored in baseTest
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException 
	{
	
	//Automatically starting the Appium server
			service= new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Anjali.K//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
					.withIPAddress("127.0.0.1").usingPort(4723).build();
			service.start();
			
			// Need to mention the Device capabilities 
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName("Pixel 2 XL API 33");
			//options.setChromedriverExecutable("C:\\chromedriver_win32");
			//options.setChromedriverExecutable("C:\\Users\\Anjali.K\\eclipse-workspace\\Appium_basic\\Driver\\chromedriver.exe");
		
			//options.setCapability("ignoreHiddenApiPolicyError", true);
			//options.setDeviceName("Android Device");
			//options.setUdid("MNFQQKCIZD6HCAAU");
			//options.setPlatformName("Android");
			//options.setPlatformVersion("11");
			
			//Api Demo Site
			//options.setApp("C://Users//Anjali.K//eclipse-workspace//Appium_basic//src//test//resources//Resources//ApiDemos-debug (2).apk");
			
			//E-commerce General store
			options.setApp("C://Users//Anjali.K//Gitstuff//Jithub_Practice_Project//src//test//resource//App//General-Store.apk");
			
			//POC
			//options.setApp("C://Users//Anjali.K//eclipse-workspace//Appium_basic//src//test//resources//Resources//General-Store.apk");
			
			//Create a Object with two arrguments (1 arg Mention URL port no, 2 Device capabilities)
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	}
	
	//Storing long press function is common repository
	/*  Common method require Parameter->WebElement that we will get it from TC [LongPress] and store it here*/ 
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile:longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration",2000));
	}
	
	//Storing swipe function is common repository
		/*  Common method require 2 Parameter->WebElement and string that we will get it from TC [Swipe] and store it here*/ 
		public void SwipeAction(WebElement ele,String direction)
		{
			((JavascriptExecutor)driver).executeScript("mobile:swipeGesture",
					ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
							"direction",direction,"percent",0.75));
		}
		
	//Storing drag and dop function is common repository
		/*  Common method require 2 Parameter->WebElement and string that we will get it from TC [Drag and drop] and store it here*/ 
		public void DragandDropAction(WebElement ele)
		{
			((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				    "elementId", ((RemoteWebElement)ele).getId(),
				    "endX", 830,
				    "endY", 737
			));
		}
		
		public Double getFormattedAmount(String amount)
		{
			Double price=Double.parseDouble(amount.substring(1));
			return price;
		}
		
	
	
	@AfterClass
	public  void tearDown()
	{
		driver.quit();
		service.stop();
	}

}
