package com.GoogleDropBox;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleDriveSteps
{
	WebDriver driver;
	String root;
	GoogleDrive googleDrive;
	GeneralUtilities utils;
	public static String folderName;
	public static String fileName = "Selenium.txt";
	public GoogleDriveSteps()
	{
		try {
			root = new File(".").getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.setProperty("webdriver.chrome.driver", root+"//Drivers//chromedriver-win32-80//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		googleDrive = new GoogleDrive(driver);
		utils = new GeneralUtilities("FilesToUpload//Data.properties");
	}
	@Given("^I Login to Google Drive account$")
	public void i_Login_to_Google_account()  {
		googleDrive.launchApplication(utils.readValue("URL"));
		googleDrive.loginToApplication(utils.readValue("UserName"),utils.readValue("PassWord"));
	}
	@When("^I Create a folder in google drive$")
	public void i_Create_a_folder_in_google_drive(){
		folderName = "BDD-Cucumber-"+ new Random().nextInt(9999);
		googleDrive.createFolder(folderName);
	}
	@When("^I upload multiple files in to google drive$")
	public void i_upload_multiple_files_in_to_google_drive() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		googleDrive.openFolder(folderName);
		googleDrive.addFiles("Selenium.txt");
		googleDrive.addFiles("Cucumber.txt");
	}
	@When("^I logout from google account$")
	public void i_logout_from_google_account(){
		googleDrive.logoutFromApplication();
	}
	@Then("^I should close google$")
	public void i_should_close_google(){
		googleDrive.closeApplication();
	}
	@When("^I Create a \"([^\"]*)\" in google drive$")
	public void i_Create_a_in_google_drive(String folder) {
		folderName = folder+ new Random().nextInt(9999);
		googleDrive.createFolder(folderName);
	}
	@When("^I upload \"([^\"]*)\" in to google drive$")
	public void i_upload_in_to_google_drive(String file) throws IOException {
		fileName = file;
		googleDrive.openFolder(folderName);
		utils.fixedWait(5);
		googleDrive.addFiles(fileName);
	}
}
