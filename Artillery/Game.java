﻿package src;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		Plane newPlane = new Plane();
		newPlane.initalizePlane();
		// print the backstory of the game
		newPlane.printStory();
		// print the initial dialogue
		newPlane.printStartGame();
		// while the continue game is set to true then keep going
		while(newPlane.continueGame) {
			// print the player locations at the beginning of each round
			newPlane.printLocations();
			// Get some data from the user
			System.out.println("Enter the angle to fire at : ");
			newPlane.setAngle(getIntFromUser(userInput,1,89));
			System.out.println("Enter the pressure to fire the projectile : ");
			newPlane.setvelocity(getIntFromUser(userInput,1,100));
			// Have the player take their turn
			newPlane.playerTurn();
			// Have the computer take their turn with a error margin of 100 meters 
			newPlane.computerTurn(100);
			// check to see if anyone was hit
			newPlane.checkDamage();
			// if the game has ended then check to see if the player wants to play once more.
			if(newPlane.continueGame==false) {
				newPlane.printStats(0);
				System.out.println("Would you like to hide in another bunker or continue the fight? 1 to run and 2 to fight");
				int decision = getIntFromUser(userInput, 1,2);
				if(decision==2) { 
					// if the player wants to continue set the continueGame var to true, print the start round dialogue and reinitialize the field
					newPlane.continueGame=true;
					newPlane.printStartGame();
					newPlane.initalizePlane();
				}			
			}
		}
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
}
