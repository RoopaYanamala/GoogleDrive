package com.GoogleDropBox;

import java.io.FileInputStream;
import java.util.Properties;

public class GeneralUtilities{
	String fileName;
	FileInputStream myFile;
	Properties myProp;
	public GeneralUtilities(String fileName){
		this.fileName = fileName;
	}
	public String readValue(String myKey){
		try {
			myFile = new FileInputStream(fileName);
			myProp = new Properties();
			myProp.load(myFile);
		} catch (Exception  exceptionmsg) {
			exceptionmsg.printStackTrace();
		}
		return myProp.getProperty(myKey);
	}
	
	public void fixedWait(int timeInSec){
		try {
			Thread.sleep(timeInSec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
