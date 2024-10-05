package demo;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = -12;
		int y = x/2;
		char a = 'a';
		char quote = '\'';
		char array[] = {'x','y'} ;
		double z =(double) x/7;// must typecast variubles and even then they are not always accurate
		float b = (float) 10.1;
		System.out.println("x : "+x);
		System.out.println("y : "+y);
		System.out.println("z : "+z);
		System.out.println("a : "+a);
		System.out.println("b : "+b);
		System.out.println("single quote : "+quote);
		System.out.println("char array: "+array[0]+array[1]);
		
		if(x>10) {
			System.out.println("x is greater than 10");
		} else if (x<10) {
			System.out.println("x is less than 10");
		} else if(x==10) {
			System.out.println("x is equal to 10");
		} else {
			System.out.println("x is something that cannot be compared to 10");
		}
		
		if(x>10 && x < 12) {
			System.out.println("X is 10 because it is less than 12 and greater than 10");
		}
		
		for(int i=0; i<20; i=i+2) {
			System.out.println("The value of i: "+i);
		}
		
		/*The following is a weird situation, so java allows for charicters to be added to
		 * but adding a value to a variuble that is a char will return an intiger. additionally
		 * the charicter as a variuble cannot be added to when being assigned to a variuble
		 * char ch = 'a';
		 * char ci = ch +1; // not valid
		 */
		char charShift = 'a' + 1;
		System.out.println(charShift);
	}

}
