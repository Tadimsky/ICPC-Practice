import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class FlashMob {

		public static void main(String[] args ) {
			new FlashMob().solve();
		}

		private void solve() {
			Scanner s = new Scanner(System.in);
			
			int caseN = 1;
			
			while (true) {
				int n = s.nextInt();
				if (n == 0) {
					return;
				}
				
				List<Integer> x = new ArrayList<Integer>();
				List<Integer> y = new ArrayList<Integer>();
				
				for (int i = 0; i < n; i++) {
					x.add(s.nextInt());
					y.add(s.nextInt());					
				}
				
				Collections.sort(x);
				Collections.sort(y);
				
				int mX = x.get(n/2);
				int mY = y.get(n/2);
				
				
				int numSteps = 0;
				for (int i = 0; i<n; i++){
					numSteps += Math.abs(mX - x.get(i)) + Math.abs(mY - y.get(i));
				}
				System.out.println("Case " + caseN + ": (" + mX + "," + mY + ") " + numSteps);
				caseN++;
			}
			
		}
}
