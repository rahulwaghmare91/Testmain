package Utility;

import java.io.File;
import java.nio.file.Files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CommnMethods {
public WebDriver driver;
public static File folder =new File("data download");
public CommnMethods(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	public void folderForDownloadile() {
		folder.mkdir();
	}


public String getAbsulateFilePath(String DirPath) {
	File dir=new File(DirPath);
	File[] files=dir.listFiles();
	if(files==null || files.length==0) {
		return null;
	}
	File lastmodifiled=files[0];
	for(int i=1;i<files.length;i++) {
		if(lastmodifiled.lastModified()<files[i].lastModified()) {
			lastmodifiled=files[i];
		}
	}return lastmodifiled.getName();
	}
}	

