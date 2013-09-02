package RandomWalk;

import java.util.Scanner;

public class Main {

	private Scanner s;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("lol");
		new Main().solve();
	}
	
	void solve() {
		s = new Scanner(System.in);
		int num = s.nextInt();
		
		for (int i = 0; i < num; i++) {
			int set = s.nextInt();
			int steps = s.nextInt();
			
			double left = s.nextDouble();
			double right = s.nextDouble();
			double none = 1 - left - right;			
			
			double sum = 0;
			
			
			for (int j = 0; j < steps; j++) {			
				sum += (left * -1) + (right * 1);
			}
			
			
			/*
			 
			for (int k = 0; k < 1000000; k++) {
				double max_right = 0;			
				int start = 0;
				for (int j = 0; j < steps; j++) {				
					double ran = Math.random();				
					if (ran > 0 && ran < left) {
						start--;
					}
					else {
						if (ran >= left && ran < none) {
							start++;
							
							if (start > max_right) {
								max_right = start;
							}
						}
						else {
							
						}
					}
				}
				sum += max_right;
			}
			*/
			System.out.println(sum);
		}
	}

}
