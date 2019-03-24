// 1707번 
// 이분 그래프 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ1707 {
	static ArrayList<Integer>[] adj;
	static int[] visited;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		for(int i=0;i<t;i++) {
			int n = stdIn.nextInt();
			int e = stdIn.nextInt();
			adj = (ArrayList<Integer>[]) new ArrayList[n+1];
			visited = new int[n+1];
			
			for(int k=1;k<=n;k++) {
				adj[k] = new ArrayList<Integer>();
			}
			for(int j=0;j<e;j++) {
				int a = stdIn.nextInt();
				int b = stdIn.nextInt();
				adj[a].add(b);
				adj[b].add(a);
			}
			System.out.println(solve(n)?"YES":"NO");
		}
	}
	static boolean solve(int n) {
		// 그래프의 연결요소가 1개라는 말이 없으므로 전체 정점에 대해 다 해봐야됨.
		for(int i=1;i<=n;i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				if(bfs(i)== false)
					return false;
			}
		}
		return true;
	}
	static boolean bfs(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		visited[n] = 1;
		while(!q.isEmpty()) {
			int h = q.remove();
			for(int i : adj[h]) {
				if(visited[i] == 0) {
					// 이전 것의 반대로 색칠 
					visited[i] = 3 - visited[h];
					q.add(i);
				}else if(visited[i]==visited[h]) { // 색이 같은 경우 
					return false;
				}
			}
		}
		return true;
	}
	static boolean dfs(int n) {
		for(int i : adj[n]) {
			if(visited[i] == 0) {
				visited[i] = 3 - visited[n];
				if(dfs(i)==false)
					return false;
			}else if(visited[i] == visited[n]){
				return false;
			}
		}
		return true;
	}
}
