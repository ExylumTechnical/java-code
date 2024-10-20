package random;
//get the libraries explicitly to reduce the chance of inherited vulnerabilities
import java.util.Random;

public class random {

	public static void main(String[] args) {
		generate_random(0,10) // generate a random number below or above 10

	}

	public static int generate_random(int min, int max) {
		/*
		 * Generate a random number by subtracting the minimum value from the maximum value
		 * adding one and then adding the minimum value back to the random number
		 */
		if(min<=max) {
			Random rand = new Random();// Create random number generator class
			int random_number= Math.abs(rand.nextInt()% (max-min +1))+min; 
		} else {
			// print an error message
			System.out.println("Error: maximum is smaller than or equal to the minimum returning 0 for now");
			int random_number=0;
		}

		return random_number;
	}
}