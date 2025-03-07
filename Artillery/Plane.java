﻿package src;

import java.util.Random;
import java.util.Scanner;

public class Plane {
	int locations[] = {0,0}; // where each player is located
	int angle[]= {0,0}; // last angle entered for each player
	int velocity[]= {0,0}; // last velocity entered for each player
	int fallpoint[]= {0,0}; // last fallpoint for each players shot
	int distances[]= {0,0}; // distances of each shot fired
	int wins[]= {1,1}; // total wins for each player start out with 1 to avoid the divide by zero error
	int losses[]= {1,1}; // total losses for each player start out with 1 to avoid the divide by zero error
	public boolean continueGame=true; // continue game variable
	int turnNumber; // turn number
	int fieldSize, midPoint, blastRadius; // plane stats
	
	public Plane() {
		
		this.initalizePlane();
	}
	
	// #################################################################################################### Game Functions
	
	public void initalizePlane() {
		// set the turn number to zero, set the field size, calculate the midpoint and blast radius based on the field size.
		this.turnNumber=0;
		this.fieldSize=1500;
		this.midPoint=fieldSize/2;
		this.blastRadius=fieldSize/30;
		this.setPlayerLocations();
		// set player locations
	}
	
	public void setPlayerLocations() {
		/* Set player locations to be random but on two separate sides of the field and allow for each player to be out of each others blast zone
		 * so that a MADD situation does not happen
		 * Currently supports two players
		 */
		locations[0]=generateRandom(0,midPoint-(blastRadius/2)); // player is 0
		locations[1]=generateRandom(midPoint+(blastRadius/2),fieldSize); // computer is 1
	}
	
	public void playerTurn() {
		// set the fall point for the players shot to land at their current location plus the distance of the shot variables
		this.distances[0]=getLaunchDistance(this.angle[0], this.velocity[0]);
		// add the distance of the shot to the players current location
		this.fallpoint[0]=this.locations[0]+this.distances[0];
		// print the last shot before the turn number is incremented forward
		this.printLastShot();
		this.turnNumber++;
	}
	
	public void computerTurn(int errorMargin) {
		// Have the computer take a turn
		
		// for later logic to work set all the variables to be far outside of the possible return values.
		int potentialLanding=100000000;
		int newAngle=100000000;
		int newvelocity=100000000;
		int distance=100000000;
		boolean goodFallpoint=false;
		// could have just had the computer generate a random number where it could fall on the plane but had to do it the 
		// complex way by computing each shot then determining if it falls within the error margin
		
		// output something while the computer generates numbers in case it takes a long time.
		System.out.println("\nOposition is plotting....\n");
		while(!goodFallpoint) {
			// generate a velocity and angle of the shot
			newAngle= generateRandom(1, 89);
			newvelocity = generateRandom(1, 100);
			// get the launch distance
			distance = getLaunchDistance(newAngle, newvelocity);
			// the shot is traveling backwards on the number line so therefore it is subtracted from the current location of the computer
			potentialLanding = (this.locations[1])-distance;
			// if the potential landing place is less than the players location minus the error margin
			
			if((this.locations[0]-errorMargin) < potentialLanding && potentialLanding < (this.locations[0]+errorMargin)) { 
				goodFallpoint = true;
			} else {
				goodFallpoint = false;
			}
		}
		// set all the global variables for the computer
		this.angle[1]=newAngle;
		this.velocity[1]=newvelocity;
		this.fallpoint[1] = potentialLanding;
		this.distances[1]=distance;
		// We dont really need to know about the opposition shots it was mainly used for debugging.
		System.out.println("You hear a shot explode somewehere on the surface...\n");
		//this.printLastShot();
		this.turnNumber++;
	}
	
	public void checkDamage() {
		// check if anyone was hit in separate if statements and end the game if it is the case
		if(fallpoint[0] > locations[0]-(blastRadius/2) && fallpoint[0] < locations[0]+(blastRadius/2) ) { // did the player hit themself?
			this.continueGame=false;
			this.losses[0]++;
			System.out.println("You have made a fatal error and struck yourself upon the head.");
		}
		if(fallpoint[1] > locations[1]-(blastRadius/2) && fallpoint[1] < locations[1]+(blastRadius/2) ) { // did the computer hit themself?
			this.continueGame=false;
			this.losses[1]++;
			System.out.println("The opposition seems to have made a fatal error and struck themselves upon the head.");
		}
		if(fallpoint[1] > locations[0]-(blastRadius/2) && fallpoint[1] < locations[0]+(blastRadius/2) ) { // did the computer hit the player?
			this.continueGame=false;
			this.losses[0]++;
			this.wins[1]++;
			System.out.println("Time to move... It seems the bunker has taken a direct hit.");
		}
		if(fallpoint[0] > locations[1]-(blastRadius/2) && fallpoint[1] < locations[0]+(blastRadius/2) ) { // did the player hit computer?
			this.continueGame=false;
			this.losses[1]++;
			this.wins[0]++;
			System.out.println("Bully for you you have hit the opposition, they are probably scurrying to another hidey hole.");
		}
	}
	// #################################################################################################### Print Functions
	public void printLocations() {
		/*
		 * Print the player locations
		 */
		String result = "";
		result = result +"\n You are currently located   : "+locations[0];
		result = result +"\n The Opposition bunker is at : "+locations[1];
		System.out.println(result);
	}
	
	public void printLastShot() {
		/*
		 * Print attributes of the last shot that was fired.
		 */
		String result = "";
		result = result +"Turn: "+turnNumber ;
		result = result +"\n Fired at angle of       : "+angle[turnNumber%2];
		result = result +"\n Applied velocity             : "+velocity[turnNumber%2];
		result = result +"\n Landed at               : "+fallpoint[turnNumber%2];
		result = result +"\n It Travelled            : "+distances[turnNumber%2]+" units";
		result = result +"\n Blast Radius of shot    : "+blastRadius;
		System.out.println(result);
	}
	
	public void printStats(int player) {
		/*
		 * Print the win loss ratio for the player specified
		 */
		
		float winLossRatio = wins[player]/losses[player];
		String results ="Opposition Artillery destroyed: "+wins[player] + "\nBunkers Lost: "+ losses[player];
		if(winLossRatio>=.9) {
			// if the player has won 90 percent of games or more say nice things
				results = results +"Nova: Keep this up and we might just get two bases!";
		} else if (winLossRatio>=.75 && winLossRatio<.9) {
			// if the player has not lost more than 75 percent of the time be nice but not like super nice
			results = results +"Barney: We have them on the run!";
		} else {
			// if the player has lost more than 75 percent of the time then say less nice things
			results = results +"Barney: Do you want to take your chances on the surface!?"
					+ "\nNova: If he keeps on like this I might just take my chances now."
					+ "\nFletch: We are not out of options or bunkers... yet";
		}
		System.out.println(results);
	}
	
	
	public void printStory() {
    	/* 
    	 * Prints the story the user is putting themselves into  
    	 */
    	System.out.print("You, Fletch a would be homesteader and former champion archer find yourself in the rural north 6 months after the end of the war to end all wars. The fallout and environmental\n"
    			+ "conditions have made the land untraversable and too harsh to survive for more than a couple weeks. As Dr. Ian Malcolm once said \"Life finds a way\". Just before the end of the\n"
    			+ "war Fletch found himself the lucky owner of a skeleton key to an abandoned para military holdout. There were a few of these groups out here before the war after they fell victim\n"
    			+ "to the flames of infighting over the spoils of war.\r\n"
    			+ "\r\n"
    			+ "It was quiet for the first few months, Fletch and a couple other survivors, Nova and Barney, were able to live comfortably off of the stored provisions. One day Nova, a sharp\n"
    			+ "witted survivor who used technology to tactfully navigate her way around the wastes, got the bright idea to switch on the CB radio and start scanning for broadcasts on a bigger\n"
    			+ "antenna than the cheap scavenged shortwaves lifted from the last time they were on the surface, unfortunately the opposition had gotten to the radios before the base builders\n"
    			+ "had.\r\n"
    			+ "\r\n"
    			+ "Nova switches the ham on, lights illuminate and a frequency number is illuminated. A few seconds later A loud crackling voice came over the radio \"Ha a couple of you that\n"
    			+ "escaped us have been laying low over there? We will see to that, you wont be able to talk your way around us this time.\" This was followed by a menacing buzz emanating from\n"
    			+ " the radio then smoke began slithering from the holes for the speaker just as slowly as the smell of solder and burning insects crept into the room. \"damn\" Nova whispers.\n"
    			+ "\"I still have a couple tricks up my sleeve, ill start rigging a few of our shortwaves to triangulate the static on their channel.\" \r\n"
    			+ "\r\n"
    			+ "Dust gently falls from the celling as a distant explosion sounds from the surface. Alarmed you scramble over to the prewar computer console labeled Weapons System. I guess the\n"
    			+ "radios are not the only thing the misinformed brutes got to. Barney another survivor swings around the corner and says \"We gotta get out of here! Before whoever that is blow\n"
    			+ "us to bits, I was reading about those people and if they get us we will wish the celling collapse had. There are access tunnels to the other stations we can hide out in.\" You\n"
    			+ "look at him and say \"I got this how much different can this be than archery?\" swiveling fiercely back to the console whipping a pencil and scratchpad ready to math your way\n"
    			+ "out of oblivion. A green cursor flashes thrice on the screen and prints the single word \"Artillery\" then another message sprints across the screen \"The coordinates of the\n"
    			+ "enemy have been determined but velocity and angle calculations are not able to be determined. Switching to manual operator entry.\" You think to yourself \"Okay maybe a lot\n"
    			+ "different than archery...\"\n");
    }
	
    public void printStartGame() {
    	/*
    	 * Print a light hearted opening statement each time a new round is played
    	 */
        System.out.println("When the bombs fell it partially knocked out the guidance system for the arillery, it was able to lock onto the direction the artillery is coming from but it is not\n"
        		+ "able to calculate the velocity or trajectory of the projectile. This will need to be manually entered into the system.\n");	
    }
    
	// #################################################################################################### Trajectory Functions
	int getvelocity() {
		// gets the velocity of the shot for the current player
		int player = turnNumber%2;
		return velocity[player];
	}
	int setvelocity( int newvelocity) {
		// sets the velocity of the shot for the current player.
		int player = turnNumber%2;
		return velocity[player]=newvelocity;
	}
	int getAngle() {
		// get the angle for the shot of the current player
		int player = turnNumber%2;
		return angle[player];
	}
	int setAngle(int newAngle) {
		// set the angle for the shot of the current player
		int player = turnNumber%2;
		return angle[player]=newAngle;
	}
	
    public int getLaunchDistance(int setAngle, int setvelocity) {
    	/* 
    	 * Return the point where a thing will fall based on initial velocity and the launch angle set in the function
    	 */
    	if(setAngle > 45.0) {
    		setAngle=45-(setAngle-45);
    	} else { }
        double angle = Math.toRadians(setAngle);
        double angleTheta = Math.atan(angle);
    	double distance=(setvelocity*setvelocity*Math.sin(angleTheta));
        return (int) distance;
        /*
         * For a given angle theta ( in radians ) and a given speed s, the horizontal distance for a shell is given by the equation d = (s*s*sin(2*theta))/9.8
         * The user inputs angles in degrees, but the Math.sin function assumes that the angle is in radians. Given that there are 2*3.14 radians for every 360 degrees,
         *  you could write a handy conversion function. Or, you could sniff around and see if the Math class has a neat function for you.
         */
    }


	
	// #################################################################################################### Standard Functions
	public int generateRandom(int min, int max) {
		/*
		 * Generate a random number by subtracting the minimum value from the maximum value
		 * adding one and then adding the minimum value back to the random number
		 */
		if(min<=max) {
			Random rand = new Random();// Create random number generator class
			return (int) Math.abs(rand.nextInt()% (max-min +1))+min; 
		} else {
			// print an error message
			System.out.println("Error: maximum is smaller than or equal to the minimum returning 0 for now");
			return 0;
		}
	}
	
	public static int getIntFromUser(Scanner input, int min, int max, String prompt) {
		/* Get input from the user without a prompt
		 * A scanner must be created in the main function prior to using it here
		 * The prompt is a string that will be printed as a prompt
		 */
		System.out.println(prompt);
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
