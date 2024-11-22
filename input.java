package input;

import java.util.Scanner;

public class input {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean flag=true;
		// how to get input regardless of any errors.
		while(flag==true) {
			System.out.print("Keep going? 1 for yes 0 for no");
			int x = input.nextInt();
			if(x==0) {
				System.out.println("Exiting.");
				flag = false;
			} else if(x==1) {
				System.out.println("Continueing.");
			} else {
				System.out.println("please enter a valid option");
			}
		}
		System.out.println(getStringFromUser(input,"Enter a string:")); 
		System.out.println(getIntFromUser(input,"Enter a number:"));
		input.close();
	}
	public static String getStringFromUser(Scanner input, String prompt) {
		/* Function that will get a string from the user
		 * A scanner must be created in the main function prior to using it here
		 * The prompt is a string that will be printed as a prompt
		 */
		String value =""; 
		int not_sane_flag=50;
		boolean flag=false;
		while(flag==false) {
			value="";
			try {
				System.out.println(prompt);
				value = input.next();
				flag=true;
			} catch (Exception e) {
				System.out.println("Error: Please use a string here");
				not_sane_flag--;
				System.out.println(e);
			} finally{

			}
			if(not_sane_flag<=0) {
				System.out.println("Please contact the developer with details on how this error occured. \n Returning nothing for now");
				flag=true;
				value="";
			}
		}
		return value;
	}
	public static int getIntFromUser(Scanner input, String prompt) {
		/* Get input from the user
		 * A scanner must be created in the main function prior to using it here
		 * The prompt is a string that will be printed as a prompt
		 */
		int value = 0; 
		int not_sane_flag=50;
		boolean flag=false;
		while(flag==false) {
			value=0;
			try {
				System.out.println(prompt);
				value = input.nextInt();
				flag=true;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Error: Please enter a valid intiger (no decimals and must be a number between -2147483648 to 2147483647)");
				not_sane_flag--;
			} catch (Exception e) {
				System.out.println("Error: A wild error was encountred");
				System.out.println(e);				
				not_sane_flag--;
			} finally{
				input.nextLine();
			}
			if(not_sane_flag<=0) {
				System.out.println("Please contact the developer with details on how this error occured. \n Returning 73 for now");
				flag=true;
				value=73;
			} 
		}
		return value;
	}
	
		public static int getIntFromUser(Scanner input, int min, int max) {
		/* Get input from the user without a prompt
		 * A scanner must be created in the main function prior to using it here
		 * The prompt is a string that will be printed as a prompt
		 */
		int value = 0; 
		int not_sane_flag=50;
		boolean flag=false;
		while(flag==false) {
			value=0;
			try {
				value = input.nextInt();
				flag=true;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Error: Please enter a valid intiger (no decimals and must be a number between -2147483648 to 2147483647)");
				not_sane_flag--;
			} catch (Exception e) {
				System.out.println("Error: A wild error was encountred");
				System.out.println(e);				
				not_sane_flag--;
			} finally{
				input.nextLine();
			}
			if(not_sane_flag<=0) {
				System.out.println("Please contact the developer with details on how this error occured. \n Returning 73 for now");
				flag=true;
				value=73;
			}
			if(value > max || value < min){
				System.out.println("The value entered is either below " + min + " or above "+max+". Please enter a number within that range");
			}
		}
		return value;
	}
	
		public static int getIntFromUser(Scanner input) {
		/* Get input from the user without a prompt
		 * A scanner must be created in the main function prior to using it here
		 * The prompt is a string that will be printed as a prompt
		 */
		int value = 0; 
		int not_sane_flag=50;
		boolean flag=false;
		while(flag==false) {
			value=0;
			try {
				value = input.nextInt();
				flag=true;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Error: Please enter a valid intiger (no decimals and must be a number between -2147483648 to 2147483647)");
				not_sane_flag--;
			} catch (Exception e) {
				System.out.println("Error: A wild error was encountred");
				System.out.println(e);				
				not_sane_flag--;
			} finally{
				input.nextLine();
			}
			if(not_sane_flag<=0) {
				System.out.println("Please contact the developer with details on how this error occured. \n Returning 73 for now");
				flag=true;
				value=73;
			} 
		}
		return value;
	}
	
	public static char getCharFromUser(Scanner input, String prompt) {
		/* Function that will get a char from the user
		 * A scanner must be created in the main function prior to using it here
		 * The prompt is a string that will be printed as a prompt
		 */
		String value =""; 
		char returnValue;
		int not_sane_flag=50;
		boolean flag=false;
		while(flag==false) {
			value="";
			try {
				System.out.println(prompt);
				value = input.next();
				flag=true;
			} catch (Exception e) {
				System.out.println("Error: Please enter a string");
				not_sane_flag--;
				System.out.println(e);
			} finally{

			}
			if(not_sane_flag<=0) {
				System.out.println("Please contact the developer with details on how this error occured. \n Returning nothing for now");
				flag=true;
				value="";
			}
		}
		returnValue=value.charAt(0);
		return returnValue;
	}
	
}
