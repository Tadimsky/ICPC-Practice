package Theta;

import java.util.*;

public class Main {

	Scanner s ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("lo");
		new Main().solve();
		
	}
	
	void solve() {
		s = new Scanner(System.in);
		int num = s.nextInt();
		
		for (int i = 0; i < num; i++) {			
			/*
			 * The string pattern and the weight to get here.
			 */
			HashMap<String, Integer> list = new HashMap<String, Integer>();
			HashMap<String, String> path = new HashMap<String, String>();
			HashMap<String, String> path2 = new HashMap<String, String>();
			
			int set = s.nextInt();			
			String order = s.next();
			String moves = (order + "_");		
			list.put(moves, 0);
			
			Queue<String> bfs = new LinkedList<String>();
			bfs.add(moves);			
			
			int index = moves.length() - 1;
			
			while (!list.containsKey("ABCDEF_")) {
				moves = bfs.poll();
				if (moves == null) {
					System.out.println("Invalid");
					return;
				}
				
				ArrayList<String[]> new_moves = get_moves(moves);
				for (String[] s : new_moves) {				
					if (!list.containsKey(s[0])) {
						System.out.println(s[0]);	
						list.put(s[0], list.get(moves) + 1);
						bfs.add(s[0]);
					}					
				}				
			}
		}
	}
	
	ArrayList<String[]> get_moves(String current) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		int index = current.indexOf('_');
		if (index == -1) {
			return result;
		}
		char[] move = current.toCharArray();
		
		/*
		 * If it's in a position where there are 3 choices
		 */
		
		if (index == 6) {
			result.add(string_swap(current, 1, index));
			result.add(string_swap(current, 4, index));
		}
		else {
			if (index == 1 || index == 4) {
				result.add(string_swap(current, 6,  index));
			}			
			if (index == 0) {
				result.add(string_swap(current, current.length() - 2,  index));
				result.add(string_swap(current, index+1,  index));
			}
			else {
				if (index == current.length() - 2) {
					result.add(string_swap(current, 0,  index));
					result.add(string_swap(current, index-1,  index));
				}
				else {
					result.add(string_swap(current, index-1,  index));
					result.add(string_swap(current, index+1,  index));		
				}
			}	
		}
		return result;
	}
	
	String[] string_swap(String s, int character, int space) {
		String[] arr = new String[2];
		if (character < 0) {
			character = s.length() - character;
		}
		if (space < 0) {
			space = s.length() - space;
		}
		if (character >= s.length() - 1) {
			character = character - s.length();
		}
		if (space >= s.length() - 1) {
			space = space - s.length();
		}		
		
		
		char[] next = s.toCharArray();
		char f = next[character];
		next[character] = '_';
		next[space] = f;
		
		arr[0] = new String(next);
		arr[1] = s.substring(character,character + 1);
		return arr;
	}

}
