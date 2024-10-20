package dataTypes;

import java.util.Random;

public class dataTypes {
	public static void main(String[] args) {		
		// create an array and give it a bunch of random values
		int[] rand=createRandomIntArray(200,1,100);
		// print the random values in the array.
		printArray(rand);
	}
	public static int[] createRandomIntArray(int length,int min, int max) {
		/*
		* Generates a bunch of random numbers returns it as an array
		* length is the number of random numbers to generate.
		* min is the minimum value of the list of random values.
		* max is the maximum value in the list of random values.
		*/
		int[] arr= new int [length];
		for(int i=0; i<length; i++) {
			arr[i]=(generate_random(min,max));
		}
		
		return arr;
	}
	public static boolean compareArrays(int[] arr1, int[] arr2) {
		boolean result=true;
		if(arr1.length!=arr2.length) {
			return false;
		}
		for(int i = 0; i<arr1.length;i++) {
			if(result!=false && arr1[i] == arr2[i]) {
				result=true;
			}
			else {
				result=false;		
			}
		}
		return result;
	}

	public static int[] printArray(int[] arr) {
		/*
		* Simple function to print an array supplied to the function
		* prints 20 elements per row
		*/
		int size = arr.length;
		for(int i=0, j=1; i<size; i++, j++) {
			System.out.printf("%d \t",arr[i]);
			if(j%20==0) {
				System.out.println();
			}
		}
		
		return arr;
	}
	
	public static int generate_random(int min, int max) {
		/*
		 * Generate a random number by subtracting the minimum value from the maximum value
		 * adding one and then adding the minimum value back to the random number
		 */
		int random_number=0;
		if(min<=max) {
			Random rand = new Random();// Create random number generator class
			random_number= Math.abs(rand.nextInt()% (max-min +1))+min; 
		} else {
			// print an error message
			System.out.println("Error: maximum is smaller than or equal to the minimum returning 0 for now");
			random_number=0;
		}

		return random_number;
	}
}
