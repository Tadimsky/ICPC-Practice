

import java.util.Scanner;


public class NewWay {
	
	Scanner s;
	
	public static void main(String[] args) {
		new NewWay().solve();
	}
	
	void solve() {
		s = new Scanner(System.in);
		
		while (true) {
			String f = s.nextLine().trim();
			if (f.equals("0")) {
				return;
			}
			
			int original_num = Integer.parseInt(f);			
			
			if (is_pal(f)) {
				// done;
				System.out.printf("0\n");
				continue;
			}
			
			
			int start2 = f.length() / 2;
			int mid = start2;
			if (f.length() % 2 != 0) {
				mid = start2;
				start2++;
			}			
			String first = f.substring(0, mid);
			String rev_first = new StringBuilder(first).reverse().toString();

			String second = f.substring(start2);
			
			
			int fi = Integer.parseInt(rev_first);
			int la = Integer.parseInt(second);
			
			if (fi > la) {
				System.out.printf("%d\n", fi - la);
			}
			else {
				int add = 1;
				for (int i = 0; i < first.length(); i++) {
					add *= 10;
				}
				
				fi = fi + add;
				int diff = fi - la;
				int new_num = original_num + diff;
				if (f.length() % 2 == 0) {
					new_num = new_num + add / 10;
				}
				diff = new_num - original_num;
				System.out.printf("%d\n", diff);
			}
		}
		
	}
	
	boolean is_pal(String f) {
		StringBuilder s = new StringBuilder(f);		
		String g = s.reverse().toString();
		return (g.equals(f));
	}
	
	
}
