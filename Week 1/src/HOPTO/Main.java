package HOPTO;

import java.util.Scanner;

public class Main {
	
	private Scanner input;
	
	public static void main(String[] args) {
		new Main().solve();
	}	
	
	private void solve() {
		input = new Scanner(System.in);
		int num = input.nextInt();
		
		for (int i = 0; i < num; i++) {
			int set = input.nextInt();
			int value = input.nextInt();
			value = this.calculate(value);
			System.out.printf("%d %d", set, value);
		}
	}
	
	private int calculate(int start) {
		int max = start;
		int val = start;
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
