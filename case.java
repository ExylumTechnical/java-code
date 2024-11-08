package switchCase;

import java.util.Scanner;

public class SwitchCase {
	public static void main(String[] args) {
		Scanner userIn = new Scanner(System.in);
		char option = getCharFromUser(userIn, "Enter A or B");
		System.out.println(option);
		String result=optionSwitch(option);
		System.out.println(result);
		
	}
	public static String optionSwitch(char choice){
		String output = "Unknown option";
		switch(choice){
			case 'A':
				output="Option A chosen";
				break;
			case 66:
				output="Option B chosen";
				break;
			default:
				output = "Unknown option enter either A or B";
				break;
		}
		return output;
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
