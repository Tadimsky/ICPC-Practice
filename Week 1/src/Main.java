

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {		
		Main test = new Main();
		test.solve();
		System.exit(0);
	}	
	
	void solve() {
		Scanner input;
		input = new Scanner(System.in);
		long num = input.nextInt();
		
		for (int i = 0; i < num; i++) {
			long set = input.nextInt();
			long value = input.nextInt();
			value = this.calculate(value);
			System.out.printf("%d %d\n", set, value);
		}
		input.close();		
	}
	
	long calculate(long start) {
		long max = start;
		long val = start;
		while (val != 1) {
			if (val > max) {
				max = val;
			}
			if (val % 2 == 0) {
				val /= 2;
			}
			else {
				val = val * 3 + 1;
			}
		}
		return max;
	}
}
