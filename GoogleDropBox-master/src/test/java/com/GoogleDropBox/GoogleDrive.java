package com.GoogleDropBox;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GoogleDrive
{
	WebDriver driver;
	GeneralUtilities utils;
	Actions actions;
	String folderName;
	String root;
	public GoogleDrive(WebDriver driver)	{
		this.driver = driver;
		utils = new GeneralUtilities("FilesToUpload//Data.properties");
		actions = new Actions(driver);
		try {
			root = new File(".").getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void createFolder(String folder)
	{
		folderName = folder;
		WebElement myDrive = driver.findElement(By.xpath("//div[text()='My Drive'  and @class='h-sb-Ic h-R-w-d-ff']"));
		actions.moveToElement(myDrive).click().sendKeys(Keys.ARROW_DOWN).build().perform();
		utils.fixedWait(1);
		actions.sendKeys(Keys.ENTER).build().perform();
		utils.fixedWait(3);
		WebElement textBox = driver.findElement(By.xpath("//input[@class='lb-k-Kk g-Gh']"));
		textBox.clear();
		textBox.sendKeys(folderName);
		driver.findElement(By.xpath("//button[@name='ok']")).click();
	}
	
	public void openFolder(String folderName) throws IOException
	{
		utils.fixedWait(3);
		WebElement folder = driver.findElement(By.xpath("//div[@class='Q5txwe'  and @aria-label='"+folderName+"' ]"));
		actions.moveToElement(folder).doubleClick().build().perform();
		utils.fixedWait(3);
	}
	public void addFiles(String fileName) throws IOException
	{
		actions.moveToElement(driver.findElement(By.xpath("//div[@class='ab-o-Zm']"))).contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
		utils.fixedWait(2);
		actions.sendKeys(Keys.ENTER).build().perform();
		String exepath = root+"\\FilesToUpload\\Selenium.exe";
		System.out.println("Exe path :" + exepath);
		Runtime.getRuntime().exec(exepath+"  "+ (root+"\\FilesToUpload\\"+fileName));
		utils.fixedWait(10);
	}
	public void launchApplication(String url)	{
		System.out.println("Launch Application");
		driver.get(url);
	}
	public void loginToApplication(String userName,String passWord)	{
		System.out.println("Login To Application");
		driver.findElement(By.name("identifier")).sendKeys(userName);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		utils.fixedWait(2);
		driver.findElement(By.name("password")).sendKeys(passWord);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
	}
	public void logoutFromApplication()	{
		System.out.println("Logout From Application");
		driver.findElement(By.xpath("//a[@class='gb_D gb_Oa gb_i']")).click();
		driver.findElement(By.xpath("//a[@class='gb_Fb gb_8f gb_gg gb_Qe gb_Wc']")).click();
	}
	public void closeApplication()	{
		System.out.println("Close Application");
		driver.quit();
	}

}
