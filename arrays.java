package arrays;

import java.util.Random;

public class arrays {
	public static void main(String[] args) {		
		// create an array and give it a bunch of random values
		int[] rand=createRandomIntArray(200,1,100);
		// print the random values in the array.
		print1DArray(rand);
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
	public int[][] returnBlankArray(int row, int column){
		int arr[][]= {};
		for(int k=0; k<row; k++) {
			for(int i=0; i<column; i++) {
				arr[k][i]=0;
			}
		}
		
		return arr;
	}
	public int[] returnBlankArray(int row){
		int arr[]= {};
		for(int k=0; k<row; k++) {
			arr[k]=0;
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

	public static void print1DArray(int[] arr) {
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
	}
	public static void print2DCharArray(char[][] arr, int row, int column) {
	/*
	* Simple function to print an array supplied to the function
	* prints 20 elements per row
	*/	
	for(int k=0; k<row; k++) {
		//System.out.println("printing line "+k+":");
		for(int i=0, j=1; i<column; i++, j++) {
			System.out.printf("%c \t",arr[k][i]);
			if(j%20==0) {
				System.out.println();
			}
		}
		System.out.println();
	}
}
	public static void print2DintArray(int[][] arr, int row, int column) {
	/*
	* Simple function to print an array supplied to the function
	* prints 20 elements per row
	*/	
	for(int k=0; k<row; k++) {
		//System.out.println("printing line "+k+":");
		for(int i=0, j=1; i<column; i++, j++) {
			System.out.printf("%d \t",arr[k][i]);
			if(j%20==0) {
				System.out.println();
			}
		}
		System.out.println();
	}
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
