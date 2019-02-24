// 2592번 
// 부등호 
// DFS (Depth-First-Search)

// 코드 좀 더 깔끔히 해볼 것 
// 위상 정렬로 풀어볼 것 

// https://mygumi.tistory.com/279

import java.util.ArrayList;
import java.util.Scanner;
public class BJ2529 {
	static boolean[] visited = new boolean[10]; // 0~9
	static char[] c;
	static int t;
	static ArrayList<String> list;
	public static void main (String[] args) {
		// 입출력 
		Scanner stdIn = new Scanner(System.in);
		t = stdIn.nextInt();
		c = new char[t];
		for(int i=0;i<t;i++) {
			c[i] = stdIn.next().charAt(0);
		}
		solve();
	}
	static void solve() {
		
		for(int i=9;i>=0;i--) {
			visited = new boolean[10];
			list = new ArrayList<String>();
			list.add(i+"");
			visited[i] = true;
			dfs2(i,0);
		}
		
	}
	// dfs 
	// Depth-First-Search 
	// 최솟값 탐색 
	static void dfs(int n, int cnt) {
		// 종료 조건 
		if(cnt == t) {
			String anw = "";
			for(int i=0;i<list.size();i++) {
				anw += list.get(i);
			}
			System.out.println(anw);
			System.exit(0);
			return;
		}
		
		Character w = c[cnt];
		
		for(int i=0;i<10;i++) {
			if(visited[i]==false && i!=n) {
				if(w.equals('<')) {
					if(n<i) {
						visited[i] = true;
						list.add(i+"");
						dfs(i, cnt+1);
						// Back-Tracking
						visited[i] = false;
						
					}
				}else {
					if(n>i) {
						visited[i] = true;
						list.add(i+"");
						dfs(i, cnt+1);
						// Back-Tracking
						visited[i] = false;
					}
				}
			}
		}
		// Back-Tracking
		list.remove(list.size()-1);
		
	}
	// dfs2
	// Depth-First-Search 
	// 최댓값 탐색 
	static void dfs2(int n, int cnt) {
		// 종료 조건 
		if(cnt == t) {
			String anw = "";
			for(int i=0;i<list.size();i++) {
				anw += list.get(i);
			}
			System.out.println(anw);
			for(int i=0;i<10;i++) {
				list = new ArrayList<String>();
				visited = new boolean[10];
				list.add(i+"");
				visited[i] = true;
				dfs(i,0);
			}
			System.exit(0);
			return;
		}
		
		Character w = c[cnt];
		
		for(int i=9;i>=0;i--) {
			if(visited[i]==false && i!=n) {
				if(w.equals('<')) {
					if(n<i) {	
						visited[i] = true;
						list.add(i+"");
						dfs2(i, cnt+1);
						// Back-Tracking
						visited[i] = false;
						
					}
				}else {
					if(n>i) {
						visited[i] = true;
						list.add(i+"");
						dfs2(i, cnt+1);
						// Back-Tracking
						visited[i] = false;
					}
				}
			}
		}
		// Back-Tracking
		list.remove(list.size()-1);
	}
}
