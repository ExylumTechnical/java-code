package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class files {

	private static int[] numbers;
	public static void main(String[] args) {
		String fileName = "/Path/to/your/file.txt";
		readFile(fileName);
	}

	public static void readFile(String fileName) {
		File file = new File(fileName);
		Scanner file_reader = null;
		int validNumbers =0;
		boolean continueReading=true;
		try {
			file_reader = new Scanner(file);
			while(continueReading){
				try {// try to get an int from the file
					file_reader.nextInt();
					validNumbers++;
					continueReading=file_reader.hasNextLine();
				} catch (java.util.InputMismatchException e) {// if a string is found then discard it and move along
					System.out.println("String found... 1");
					file_reader.nextLine();
				} catch (Exception e) {// if there is another error stop processing input from the file
					continueReading=false;
					System.out.println(e);
				} finally{ // finaly do nothing
				}
			}
			numbers = new int [validNumbers];
			file_reader.close();
			file_reader = new Scanner(file);
			validNumbers =0;
			continueReading=true;
			while(continueReading){
				try {// try to get an int from the file
					numbers[validNumbers]=file_reader.nextInt();
					validNumbers++;
					continueReading=file_reader.hasNextLine();
				} catch (java.util.InputMismatchException e) { // if a string is found then discard it and move along
//					System.out.println("String found...");
					file_reader.nextLine();
				} catch (Exception e) { // if there is another error stop processing input from the file
					continueReading=false;
					System.out.println(e);
				} finally{ // finally do nothing
				}
			}
			printIntArray(numbers);
			
			System.out.println(validNumbers);

		} catch (FileNotFoundException e) {
			System.out.println("File "+fileName+" not found");
		
		} catch (Exception e) {
			System.out.println("Another error was encountered");
			e.printStackTrace();
		
		} finally {
			System.out.println("File supplied: "+fileName);
		}
		
		file_reader.close(); // close the file regardless
	}
	
	public static int[] bubbleSortIntArray(int[] arr) {
		/* Inefficient but effective sorting algorithm.
		 * the value of the original array is changed if the data is altered
		 * because the memory address is passed to the function
		 */

		int size=arr.length;
		int buffer=0;
		for(int i=0; i<size; i++) {
			for(int j=1; j<size; j++) {
				if(arr[j-1]>arr[j]) {
					buffer=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=buffer;
				}
			}
		}
		return arr;
	}
	
public static int getIntFromFile(Scanner input) {
	/* Get input from a file and try to handle invalid input
	 * The only input required is the input scanner
	 * ### This will only get the first integer on the line ###
	 */
	int value=0;
	try {
			value = input.nextInt(); // next line will get the next integer
		} catch (java.util.InputMismatchException e) {
			value=73;
			System.out.println("Error: Input Mismatch occured");
		} catch (Exception e) {
			value=73;
			System.out.println("Error: A wild error was encountred");
			System.out.println(e);
		} finally{
			input.nextLine();
		}
	return value;
	}

public static int getNumberOfIntigers(Scanner input) {
	/* Get input from a file and try to handle invalid input
	 * The only input required is the input scanner
	 * ### This will only get the first integer on the line ###
	 */
	int countOfValidNumbers=0; // count of valid integers
	while(input.hasNextLine()){
		try {
			input.nextInt();
			countOfValidNumbers++;
		} catch (java.util.InputMismatchException e) {
			System.out.println("String found...");
		} catch (Exception e) {
			System.out.println(e);
		} finally{
			input.nextLine();
		}
	}
	return countOfValidNumbers;	
	}

	public static void printIntArray(int[] arr) {
		/*
		* Simple function to print an array supplied to the function
		* prints 20 elements per row and only accepts an intiger array.
		*/
		int size = arr.length;
		for(int i=0, j=1; i<size; i++, j++) {
			System.out.printf("%d \t",arr[i]);
			if(j%20==0) {
				System.out.println();
			}
		}
	}

}
