// 1967번 (복습) 
// 트리의 지름 
// 트리 (Tree)
// dfs (Depth First Search)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Re_BJ1967 {
	static ArrayList<Node>[] al;
	static int[] visited;
	static int max = 0;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		visited = new int[n+1];
		al = (ArrayList<Node>[])new ArrayList[n+1];
		for(int i=0;i<=n;i++) {
			al[i] = new ArrayList<Node>();
		}
		for(int i=0;i<n-1;i++) {
			int a = stdIn.nextInt();
			int b = stdIn.nextInt();
			int w = stdIn.nextInt();
			al[a].add(new Node(b,w));
			al[b].add(new Node(a,w));
		}
		solve(n);
	}
	static void solve(int n) {
		visited = new int[n+1];
		Arrays.fill(visited, -1);
		bfs(1);
//		dfs(1,0);
		int maxId = 0;
		for(int j=1;j<=n;j++) {
			if(max < visited[j]) {
				max = visited[j];
				maxId = j;
			}
		}
		
		visited = new int[n+1];
		Arrays.fill(visited, -1);
		bfs(maxId);
//		dfs(maxId,0);
		
		for(int j=1;j<=n;j++) {
			if(max < visited[j]) {
				max = visited[j];
			}
		}
		
		System.out.println(max);
	}
	static void dfs(int n, int w) {
		visited[n] = w;
		for(Node node: al[n]) {
			if(visited[node.id] == -1) {
				dfs(node.id, w + node.w);
			}
		}
	}
	static void bfs(int n) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		visited[n] = 0;
		
		while(!q.isEmpty()) {
			int h = q.remove();
			for(Node node : al[h]) {
				if(visited[node.id] == -1) {
					q.add(node.id);
					visited[node.id] = visited[h] + node.w;
				}
			}
		}		
	}
	static class Node{
		int id;
		int w;
		Node(int id, int w){
			this.id = id;
			this.w = w;
		}
	}
}

