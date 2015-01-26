package pdm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InversionCounter {

	public static void main(String args[]) {
		int[] tall = getElementsToCount();
		
		Inversion inversion = new Recursive(); 
		long actual = inversion.count(tall);

		System.out.println(actual);
	}

	private static int[] getElementsToCount() {
		try {
			Scanner scanner = new Scanner(new File("IntegerArray.txt"));
			int [] elements = new int [100000];
			int i = 0;
			while(scanner.hasNextInt()){
			   elements[i++] = scanner.nextInt();
			}
			scanner.close();

//			assertEquals(100000, i);
//			assertEquals(91901, tall[100000-1]);

			return elements;
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening file: " + e.getMessage());
			return null;
		}
		
	}
}
