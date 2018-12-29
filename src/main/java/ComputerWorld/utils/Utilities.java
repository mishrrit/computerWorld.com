package ComputerWorld.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ComputerWorld.main.baseClass;

public class Utilities extends baseClass {

	public static void takeScreenshotAtEndOfTest() throws IOException {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		File DestinationFile = new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(srcFile, DestinationFile);

	}
}
