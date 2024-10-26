package letters;

public class letters {
	public static void main(String[] args) {
		char a='a';
		for(int i =0; i<20; i++) {
			char shift=(char) (i+a);
			System.out.println("char shifted to: "+shift);
			System.out.println('a'+i);
		}
	}
}
