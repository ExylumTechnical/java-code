package demo;

import java.util.Scanner;

public class Input {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean flag=true;
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
		System.out.println(get_string_from_user(input, "Enter a string:")); 
		System.out.println(get_number_from_user(input));
	}
	public static String get_string_from_user(Scanner scan, String prompt) {
		String value =""; 
		try {
			System.out.println(prompt);
			value = scan.next();
		} catch (Exception e) {
			System.out.println("Please enter a valid string as the prompt or into the input");
		}
		return value;
	}
	public static int get_number_from_user(Scanner scan) {
		int value = 0; 
		try {
			System.out.println("Enter a number:");
			value = scan.nextInt();
		} catch (Exception e) {
			System.out.println("Please enter a valid intiger, returning 0 for now");
		}
		return value;
	}
}
