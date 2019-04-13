// 2592번 (복습)
// 부등호 
// DFS (Depth-First-Search)
// Back-Tracking

import java.util.Scanner;
public class Re_BJ2529 {
	static char[] ar;
	static boolean[] visited;
	static int t;
	static boolean flag = true;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		t = stdIn.nextInt();
		ar = new char[t];
		for(int i=0;i<t;i++) {
			ar[i] = stdIn.next().charAt(0);
		}
		solve();
	}
	static void solve() {
		visited = new boolean[10];
		for(int i=9;i>=0;i--) {
			visited[i] = true;
			dfs2(i,0,""+i);
			visited[i] = false;
		}
		flag = true;
		for(int i=0;i<10;i++) {
			visited[i] = true;
			dfs(i,0,""+i);
			visited[i] = false;
		}
	}
	static void dfs2(int i, int cnt, String s) {
		if(flag == false) {
			return;
		}
		if(cnt == t) {
			flag = false;
			System.out.println(s);
			return;
		}
		for(int j=9;j>=0;j--) {
			if(visited[j] == false) {
				if(ar[cnt] == '<') {
					if(i<j) {
						visited[j] = true;
						dfs2(j,cnt+1,s+j);
						visited[j] = false;
					}
				}else {
					if(i>j) {
						visited[j] = true;
						dfs2(j,cnt+1,s+j);
						visited[j] = false;
					}
				}
			}
		}
	}
	static void dfs(int i, int cnt, String s) {
		if(flag == false) {
			return;
		}
		if(cnt == t) {
			flag = false;
			System.out.println(s);
			return;
		}
		for(int j=0;j<10;j++) {
			if(visited[j] == false) {
				if(ar[cnt] == '<') {
					if(i<j) {
						visited[j] = true;
						dfs(j,cnt+1,s+j);
						visited[j] = false;
					}
				}else {
					if(i>j) {
						visited[j] = true;
						dfs(j,cnt+1,s+j);
						visited[j] = false;
					}
				}
			}
		}
	}
}
