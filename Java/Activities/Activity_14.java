package my_activities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Activity_14 {

	public static void main(String[] args) throws IOException {

		//created new file
		File file = new File("src/main/java/Files/myFile.txt");
		boolean Status = file.createNewFile();
		if (Status) {
			System.out.println("File created");
		} else {
			System.out.println("File already exist.");
		}
		//get file from location
		File fileUtil = FileUtils.getFile("src/main/java/Files/myFile.txt");
		System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));
		File destDir = new File("resources");
		try {
			FileUtils.copyFileToDirectory(file, destDir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		File newFile = FileUtils.getFile(destDir, "myFile.txt");
		String newFileData = FileUtils.readFileToString(newFile, "UTF8");
		System.out.println("Data in new file: " + newFileData);
	}

}
