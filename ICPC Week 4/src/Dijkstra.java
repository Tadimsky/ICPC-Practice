import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class Dijkstra {
	
	HashMap<Integer, List<Integer>> adjList;
	int[][] weightMatrix;

	public static void main(String[] args) {
		new Dijkstra().solve();
	}

	private void solve() {
		Scanner s = new Scanner(System.in);
		// vertices
		int n = s.nextInt();
		// edges
		int m = s.nextInt();
		
		adjList = new HashMap<Integer, List<Integer>>();
		
		weightMatrix = new int[n + 1][n + 1];
		
		for (int i = 0; i < m; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			int w = s.nextInt();
			
			List<Integer> l = adjList.get(a);
			if (l == null) {
				l = new LinkedList<Integer>();
			}
			l.add(b);
			adjList.put(a, l);
			weightMatrix[a][b] = w;
		}
		
		List<Integer> p = dijskstra(1, n);
		for (int f : p) {
			System.out.print(f + " ");
		}
	}
	
	private List<Integer> dijskstra(int from, int to) {
		List<Integer> path = new ArrayList<Integer>();
		
		HashSet<Integer> visited = new HashSet<Integer>();
		
		HashMap<Integer, Integer> prev = new HashMap<Integer, Integer>();
		int[] pathW = new int[weightMatrix.length];
		for (int i =0; i < pathW.length; i++) {
				pathW[i] = Integer.MAX_VALUE;
		}
		pathW[from] = 0;
		prev.put(from, 0);
		
		Queue<Integer> process = new LinkedList<Integer>();
		process.add(from);
		
		while (!process.isEmpty()) {
			int cur = findMin(pathW, visited);
			if (cur == -1) {
				break;
			}
			process.remove(cur);
			visited.add(cur);
			if (adjList.containsKey(cur)) {
			for (int ne : adjList.get(cur)) {
				int d = pathW[cur] + weightMatrix[cur][ne];
				if (d < pathW[ne]) {
					pathW[ne] = d;
					prev.put(ne, cur);
					if (!visited.contains(ne)) {
						process.add(ne);
					}
				}
			}
			}
		}
		int cur = to;
		while (cur != 0) {
			path.add(cur);
			cur = prev.get(cur);
		}
		Collections.reverse(path);
		return path;
	}
	
	int findMin(int[] s, HashSet<Integer> visited ) {
		int min = Integer.MAX_VALUE;
		int key = -1;
		for (int i = 0; i < s.length; i++) {
			if (visited.contains(i)) {
				continue;
			}
			if (s[i] < min) {
				key = i;
				min = s[i];
			}
		}
		return key;
	}
	
	

}
