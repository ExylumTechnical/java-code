package caseSwitch;

public class caseSwitch {
	public static void main(String[] args) {
		Scanner userIn = new Scanner(System.in);
		optionSwitch(getStringFromUser(userIn, "Enter option A or option B"));
	}
	public static char optionSwitch(char choice){
		switch(choice){
			case A:
				return "Option A chosen";
			case B:
				return "Option B chosen";
		}
	}
	public static String getStringFromUser(Scanner input, String prompt) {
		/* Function that will get a number from the user
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
}
