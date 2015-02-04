package pdm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InversionCounter {

	public static void main(String args[]) {
		int[] elements = fileOfIntegersToArray();
		
		Inversion inversion = new Recursive(); 
		long actual = inversion.count(elements);

		System.out.println(actual);
	}

	private static int[] fileOfIntegersToArray() {
		int [] elements = new int [100000];
		try {
			Scanner scanner = new Scanner(new File("IntegerArray.txt"));
			int i = 0;
			while(scanner.hasNextInt()){
			   elements[i++] = scanner.nextInt();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening file: " + e.getMessage());
		}

		return elements;
	}
}
