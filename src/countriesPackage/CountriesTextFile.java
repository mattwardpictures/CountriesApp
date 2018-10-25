package countriesPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CountriesTextFile {
	Scanner scan = new Scanner(System.in);

	public static void createFile(String fileName) {
		Path filePath = Paths.get(fileName);
		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("File was created successfully!");
			} catch (IOException e) {
				System.out.println("Something went wrong with the file creation! \nContact customer service.");
			}
		} else {
			System.out.println("File already exists. You are free to sit pretty.\n");
		}
	}

	public static void writeToFile(String fileName, String countryInput) {
		Path filePath = Paths.get(fileName);
		File file = filePath.toFile();

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
			outW.println("\n" + countryInput); // I added the \n because the program would write the next country to the
												// end of the last line on the existing list.
			outW.close();
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found.");
		}
	}

	public static void readFromFile(String fileName) {
		Path filePath = Paths.get(fileName);
		File file = filePath.toFile();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("Contact customer service.");
		}
	}

}
