package Palindrometer;

import java.util.Scanner;

public class Main {
	Scanner s;
	
	public static void main(String[] args) {
		
	}
	
	void solve() {
		s = new Scanner(System.in);
		
		while (true) {
			String f = s.nextLine().trim();
			if (f == "0") {
				break;
			}
			
			if (is_pal(f)) {
				// done;
				continue
			}
			
			int start2 = f.length() / 2;
			int mid = start2 -1;
			if (f.length() % 2 != 0) {
				mid = start2;
				start2++;
			}
			
			String first = f.substring(0, mid);
			String second = f.substring(start2);
			
		}
		
	}
	
	boolean is_pal(String f) {
		StringBuilder s = new StringBuilder(f);
		return (s.reverse().toString().equals(s.toString()));
	}
	
	String get_digit(String left, String right) {
		int l = Integer.parseInt(left);
		int r = Integer.parseInt(right);
		
		int diff = Math.abs(l - r);
	}
}
