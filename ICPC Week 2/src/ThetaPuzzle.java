import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ThetaPuzzle {
	Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		new ThetaPuzzle().solve();
	}
	
	public void solve() {
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			
			int c = s.nextInt();
			String input = s.next();
			input += " ";
			
			Map<String, Integer> seen = new HashMap<String, Integer>();
			Map<String, String > path = new HashMap<String, String>();
			Map<String, String> path2 = new HashMap<String, String>();
			Queue<String> q = new LinkedList<String>();
			
			seen.put(input, 0);
			path.put(input, "");
			path2.put(input, "");
			
			q.offer(input);
			
			while (!seen.containsKey("ABCDEF ")) {
				input = q.poll();
				ArrayList<String[]> nextMoves = generateMoves(input);
				
				for (String[] next : nextMoves) {
					if (!seen.containsKey(next[0])) {
						seen.put(next[0], seen.get(input) + 1);
						path.put(next[0], next[1]);
						path2.put(next[0], input);
						q.offer(next[0]);
					}
				}
			}
			
			input = "ABCDEF ";
			ArrayList<String> moves = new ArrayList<String>();
			do {
				moves.add(path.get(input));
				input = path2.get(input);
				if (input == null) {
					break;
				}
			}
			while (input != null && seen.get(input) != 0);
			//Collections.reverse(moves);
			for (String g : moves) {
				System.out.print(g + " ");
			}
		}
	}

	private ArrayList<String[]> generateMoves(String input) {
		int space = input.indexOf(' ');
		
		ArrayList<String[]> f = new ArrayList<String[]>();
		if (space == 6) {			
			f.add(swap(input, space, 1));			
			f.add(swap(input, space, 4));
		}
		else {
			f.add( swap(input, space, space - 1));			
			f.add(swap(input, space, space + 1));
		}
		return f;
		
	}
	
	private String[] swap(String cur, int index, int i2) {
		if (i2 >= cur.length()) {
			i2 -= cur.length();
		}
		if (i2 < 0) {
			i2 += cur.length();
		}
		
		char[] val = cur.toCharArray();
		
		char t = val[i2];
		val[i2] = val[index];
		val[index] = t;
		
		String[] res = new String[2];
		res[0] = new String(val);
		res[1] = "" + t;
		
		return res;
	}
		
}
