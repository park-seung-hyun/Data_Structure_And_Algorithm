// 1707번 (복습)
// 이분 그래프 
// DFS (Depth-First-Search)
// BFS (Breadth-First-Search)
// 전에 풀이 무시하고 하던데로 하면 됨. 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Re_BJ1707 {
	static ArrayList<Integer>[] ala;
	static int[] visited;
	static boolean flag = true; // dfs용 
	
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		for(int i=0;i<t;i++) {
			int v = stdIn.nextInt();
			int e = stdIn.nextInt();
			visited = new int[v+1];
			ala = (ArrayList<Integer>[]) new ArrayList[v+1];
			for(int k=1;k<=v;k++) {
				ala[k] = new ArrayList<Integer>();
			}
			for(int j=0;j<e;j++) {
				int a = stdIn.nextInt();
				int b = stdIn.nextInt();
				ala[a].add(b);
				ala[b].add(a);
			}
			isBi();
			flag = true;
		}
	}
	static void isBi() {
		
		for(int i=1;i<ala.length;i++) {
			for(int j=0;j<ala[i].size();j++) {
				if(visited[ala[i].get(j)] == 0) {
//					if(!bfs(ala[i].get(j))) {
//						System.out.println("NO");
//						return;
//					}
					dfs(ala[i].get(j), 1);
					if(flag == false) {
						System.out.println("NO");
						return;
					}
				}
			}
		}
		System.out.println("YES");
	}
	static void dfs(int n, int c) {
		if(flag == false)
			return;
		visited[n] = 3-c;
		for(int i: ala[n]) {
			if(visited[i] == 0) {
				dfs(i, visited[n]);
			}
			if(visited[i] == visited[n])
				flag = false;
		}
	}
	static boolean bfs(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		visited[n] = 1;
		boolean flag = true;
		while(!q.isEmpty()) {
			int h = q.remove();
			for(int i : ala[h]) {
				if(visited[i] == 0) {
					visited[i] = 3 - visited[h];
					q.add(i);
				}
				// 방문한 적이 있었다면 
				// 색깔 확인 
				if(visited[i] == visited[h]) {
					return false;
				}
			}

		}
		return true;
		
	}
}
