package BCasting;

import java.util.Scanner;

public class Main {

	Scanner in;

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main().solve();
	}
	
	void solve() {
		in = new Scanner(System.in);
		int num = in.nextInt();
		
		while (true) {
		// for (int i =0; i < num; i++) {
			//int set = in.nextInt();
			int length = in.nextInt();
			
			int a = 0;
			int b = 0;
			int c = 0;
			
			int found = 0;
						
			for (a = 1; a <= Math.ceil(length / 2); a++) {
				for (b = 1; b <= Math.ceil(length / 2); b++) {
					for (c = 1; c <= Math.ceil(length / 2); c++) {
						if (a+b+c == length) {				
							if (a+b>c && a+c>b && b+c>a){
								found++;
								System.out.printf("Triangle %d %d %d\n", a,b,c);
							}							
						}
					}
				}
			}
			System.out.println("Triangles found: " + found);
		}
		
	}

}
