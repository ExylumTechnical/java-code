package customFunctions;
import java.util.*;   

public abstract class customFunctions{

	
	public static int generateRandomInt(int max, int min){		
    // returns a whole number
		Random rand = new Random();
		return (Math.abs(rand.nextInt()) % (max - min + 1)) + min;
	}
	
	public static double generateRandomDouble(double min, double max){
		// returns a decimal number between the min and max values
	    Random rand = new Random();
	    return (Math.abs(rand.nextDouble()) % (max - min + 1)) + min;;
	}
	
	public static int coinFlip(){
		// returns a true or false value based on a coin flip
		Random rand = new Random();
		result=(Math.abs(rand.nextInt()) % 2;
		if(result==1){
			return true;
		}
		else{
			return false;
		}
	}
	public static double generatePercent(){
		// returns an integer less than one and greater than 0 to represent a percentage
	    Random rand = new Random();
	    Double perc = rand.nextDouble();
		while(perc>=1){
			perc = perc/10;
		}
		return perc;
	}
 
	public static boolean getUserInputCompareString(String message,Scanner scan,String compared){
    // compares the user input and the string that was provided
	    System.out.println(message);
	    String userInput = scan.nextLine();
	    return userInput.compareTo(compared) == 0;
	}
	
	public static String getUserInputReturnString(String message,Scanner scan){
    // prints a prompt and returns a string from the user
	    System.out.println(message);
	    return scan.nextLine();
	}

	public static double generatePercent(){
    // returns a flotaing point number reperesentitive of a hundred
	    Random rand = new Random();
	    Double perc = rand.nextDouble();
		while(perc>=1){
			perc = perc/10;
		}
		return perc;
	}
  
	public static int getUserInputInt(String message,Scanner scan, int min, int max){
    // Prints the string provided, gets input from the keyboard, and checks to see if the number
    // is within the minimum and maximum range.
		int returnInt= 0;
		boolean keepAsking = true;
	    while(keepAsking||returnInt < min|| returnInt > max){
	       System.out.println(message);
	       try{
	          returnInt = scan.nextInt();
	          keepAsking = false;
	       }catch(InputMismatchException e){
	          System.out.println("Please enter a number!");
	       }finally{
	          scan.nextLine();
	       }
	    }
	    return returnInt;
	}
	
	public static double getUserInputDouble(String message,Scanner scan, int min, int max){
    // gets a non-whole number from the keyboard and returns it if it is within the minimum and
    // maximum values
		double returnDouble= 0.0;
		boolean keepAsking = true;
	    while(keepAsking||returnDouble < min|| returnDouble > max){
	       System.out.println(message);
	       try{
	          returnDouble = scan.nextDouble();
	          keepAsking = false;
	       }catch(InputMismatchException e){
	          System.out.println("Please enter a number!");
	       }finally{
	          scan.nextLine();
	       }
	    }
	    return returnDouble;
	}
	public static int setVars(int var, int min, int max ) {
		// sets a variuble between the minimum and maximum values
		if (var > max) {
			var = max;
		}
		if (var < min) {
			var = min;
		}
		return var;
	}
	
}
