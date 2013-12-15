
import java.util.Scanner;

public class Main {

	private Scanner s;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {		
		new Main().solve();


		
	}
	
	void solve() {
		s = new Scanner(System.in);
		int num = readIntLine();	
		
		for (int i = 0; i < num; i++) {
			int dataset = readIntLine();
			//s.nextLine();			
			char[] value = s.nextLine().toCharArray();
			int letters = readIntLine();
			int marker = 0;
									
			System.out.print(dataset + " ");			
			for (int j = 0; j < letters; j++) {
				int change = s.nextInt();
				marker += change;
				if (marker >= value.length) {
					marker = marker - value.length;
				}
				if (marker < 0) {
					marker = value.length + marker;
				}
				System.out.print(value[marker]);
			}			
			s.nextLine();
			System.out.println();
		}
	}
	
	int readIntLine() {
		int f= Integer.parseInt(s.nextLine().trim());
		//s.nextLine();
		return f;
	}
}
 