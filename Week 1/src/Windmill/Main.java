package Windmill;

import java.util.Scanner;

public class Main {
	private Scanner in;
	
	public static void main(String[] args) {
		new Main().solve();
	}
	
	void solve() {
		in = new Scanner(System.in);
		int num = in.nextInt();
		
		for (int i = 0; i < num; i++) {			
			int set = in.nextInt();
			int num_points = in.nextInt();
			
			int pto = in.nextInt();
			int initial = in.nextInt();
			
			double angle = in.nextDouble();
			
			int[][] points = new int[num_points + 1][2];
			
			for (int j = 1; j <= num_points; j++) {				
				points[j][0] = in.nextInt();
				points[j][1] = in.nextInt();
			}
		}
	}

}
