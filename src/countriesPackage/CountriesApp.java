package countriesPackage;

import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String fileName = "countries.txt";
		CountriesTextFile.createFile(fileName);
		int userInput1 = 0;

		System.out.println("Welcome to World Factbook 2018");
		System.out.println("==============================");

		userInput1 = Validator.getInt(scan,
				"Please choose from three options: \n1. Display Country List \n2. Enter a country name \n3. Exit program\n");
		if (userInput1 == 1) {
			CountriesTextFile.readFromFile(fileName);
		} else if (userInput1 == 2) {
			String countryInput;
			countryInput = Validator.getString(scan, "Please enter a country name: ");
			CountriesTextFile.writeToFile(fileName, countryInput);
		} else {
			System.out.println("Shutting down... ");
		}

	}

}
