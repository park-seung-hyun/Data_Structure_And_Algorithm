// 1260번 
// DFS와 BFS 
// 인접 행렬, 인접 리스트, 간선 리스트를 사용한 DFS, BFS 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ1260 {
	// 간선 리스트 
	static Edge[] edge;
	static int[] cnt;
	// 인접 행렬 
	static int[][] adj;
	// 인접 리스트 
	static ArrayList<Integer>[] adj2;
	
	static boolean[] visited;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int e = stdIn.nextInt();
		int s = stdIn.nextInt();
		
		adj = new int[n+1][n+1];
		adj2 =  (ArrayList<Integer>[]) new ArrayList[n+1];
		
		for(int i=1;i<=n;i++) {
			adj2[i] = new ArrayList<Integer>();
		}
		
		edge = new Edge[2*e];
		cnt = new int[n+1];
		
		for(int i=0;i<e;i++) {
			int a = stdIn.nextInt();
			int b = stdIn.nextInt();
			adj[a][b] = 1;
			adj[b][a] = 1;
			
			adj2[a].add(b);
			adj2[b].add(a);
			
			edge[i] = new Edge(a, b);
			edge[e+i] = new Edge(b, a);
		}
		// 작은 것 부터 방문하므로 
		for(int i=1;i<=n;i++) {
			Collections.sort(adj2[i]);
		}
		
		e*=2;
		Arrays.sort(edge);
		for(int i=0;i<e;i++) {
			cnt[edge[i].from]+=1;
		}
		for(int i=1;i<=n;i++) {
			cnt[i] += cnt[i-1];
		}
		
//		visited = new boolean[n+1];
//		dfs(n,s);
//		System.out.println();
//		visited = new boolean[n+1];
//		bfs(n,s);
		
//		visited = new boolean[n+1];
//		dfs2(n,s);
//		System.out.println();
//		visited = new boolean[n+1];
//		bfs2(n,s);
		
		visited = new boolean[n+1];
		dfs2(n,s);
		System.out.println();
		visited = new boolean[n+1];
		bfs2(n,s);
	}
	// dfs
	// 깊이 우선 탐색 
	// 인접 행렬 사용 
	static void dfs(int n, int s) {
		visited[s] = true; // 방문 
		System.out.printf("%d ", s);
		for(int i=1;i<=n;i++) {
			if(visited[i] == false && adj[s][i] == 1)
				dfs(n, i);
		}
	}
	// bfs 
	// 넓이 우선 탐색 
	// 인접 행렬 사용 
	static void bfs(int n, int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s] = true;		
		while(!q.isEmpty()) {
			int h = q.remove();
			System.out.printf("%d ", h);
			for(int i=1;i<=n;i++) {
				if(visited[i]==false && adj[h][i] ==1) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
	// dfs2
	// 깊이 우선 탐색 
	// 인접 리스트 
	static void dfs2(int n, int s) {
		if(visited[s] == true)
			return; 
		
		visited[s] = true;
		System.out.printf("%d ",s);
		for(int i : adj2[s]) {
			if(visited[i]==false)
				dfs2(n, i);
		}
	}
	// bfs2 
	// 넓이 우선 탐색 
	// 인접 리스트 
	static void bfs2(int n, int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s] = true;
		while(!q.isEmpty()) {
			int h = q.remove();
			System.out.printf("%d ",h);
			for(int i : adj2[h]) {
				if(visited[i] == false) {
					visited[i] = true;
					q.add(i);	
				}
			}
		}
	}
	// dfs3 
	// 깊이 우선 탐색 
	// 간선 리스트 
	static void dfs3(int n, int s) {
		visited[s] = true;
		System.out.printf("%d ", s);
		for(int i= cnt[s-1];i<cnt[s];i++) {
			int next = edge[i].to;
			if(visited[next] == false) {
				dfs3(n,next);
			}
		}
	}
	// bfs3 
	// 넓이 우선 탐색 
	// 간선 리스트 
	static void bfs3(int n, int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s] = true;
		while(!q.isEmpty()) {
			int h = q.remove();
			System.out.printf("%d ", h);
			for(int i=cnt[h-1];i<cnt[h];i++) {
				int next = edge[i].to;
				if(visited[next]==false) {
					q.add(next);
					visited[next] = true;
				}
			}
		}
	}
}
class Edge implements Comparable<Edge>{
	int from, to;
	
	Edge(int from, int to){
		this.from = from;
		this.to = to;
	}
	public int compareTo(Edge that) {
		if(this.from < that.from) {
			return -1;
		}
		else if(this.from == that.from) {
			if(this.to < that.to) {
				return -1;
			}
			else if(this.to == that.to) {
				return 0;
			}
			else {
				return 1;
			}
		}
		else {
			return 1;
		}
	}
}
