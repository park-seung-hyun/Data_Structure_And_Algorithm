// 그래프 

import java.util.ArrayList;
import java.util.LinkedList;
public class Graph {
	// 인접 리스트 
	static ArrayList<Integer>[] adj ;
	static int[] visited;
	public static void main(String[] args) {
		adj = (ArrayList<Integer>[]) new ArrayList[4];
		for(int i=0;i<4;i++) {
			adj[i] = new ArrayList<Integer>();
		}
		adj[0].add(2);
		adj[2].add(0);
		
		adj[1].add(3);
		adj[3].add(1);
		
		adj[0].add(3);
		adj[3].add(0);
		visited = new int[4];
		System.out.println("DFS");
		dfs(0);
		visited = new int[4];
		System.out.println("BFS");
		bfs(0);

	}
	// 깊이 우선 탐색 
	static void dfs(int n) {
		visited[n] = 1;
		System.out.println(n);
		for(int w : adj[n]) {
			if(visited[w] == 0) {
				dfs(w);
			}
		}
	}
	// 너비 우선 탐색 
	static void bfs(int n) {
		Queue<Integer> q = new Queue<Integer>();
		q.add(n);
		visited[n] = 1;
		while(!q.isEmpty()) {
			int h = q.remove();
			System.out.println(h);
			for(int w : adj[h]) {
				if(visited[w] == 0) {
					q.add(w);
					visited[w] = 1;
				}
			}
		}
	}
}
