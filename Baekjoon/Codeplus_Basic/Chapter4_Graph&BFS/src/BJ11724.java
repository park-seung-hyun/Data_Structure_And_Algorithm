// 11724번 
// 연결 요소 
// 연결 요소란 하나의 연결 그래프를 의미 
// 즉 주어진 그래프의 연결 요소 개수는 dfs(또는 bfs) 탐색 횟수다. 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ11724 {
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		visited = new boolean[n+1];
		adj = (ArrayList<Integer>[])new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<m;i++) {
			int a = stdIn.nextInt();
			int b = stdIn.nextInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		System.out.println(solve(n));
	}
	static int solve(int n) {
		int cnt = 0;
		for(int i=1;i<=n;i++) {
			if(visited[i]==false) {
				dfs(i);
				cnt++;
			}
		}
		return cnt;
	}
	static void dfs(int n) {
		visited[n] = true;
		for(int i: adj[n]) {
			if(visited[i]== false)
				dfs(i);
		}
	}
	static void bfs(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		visited[n] = true;
		while(!q.isEmpty()) {
			int h = q.remove();
			for(int i:adj[h]) {
				if(visited[i]==false) {
					q.add(i);
					visited[i] = true;
				}
					
			}
		}
	}
}
