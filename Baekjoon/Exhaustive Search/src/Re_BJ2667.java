// 2667번 (복습)
// 단지 번호 붙히기 
// DFS (Depth-First-Search)
// BFS (Breadth-First-Search)

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Re_BJ2667 {
	static int[][] map;
	static int[][] visited;
	static final int[] dx = {0,0,-1,1};
	static final int[] dy = {-1,1,0,0};
	static int cnt = 0; // dfs용 
	static ArrayList<Integer> al = new ArrayList<Integer>();
	public static void main (String[] args) {
		Scanner stdIn = new Scanner (System.in);
		int n = stdIn.nextInt();
		map = new int[n][n];
		visited = new int[n][n];
		stdIn.nextLine();
		for(int i=0;i<n;i++) {
			String s = stdIn.nextLine();
			for(int j=0;j<n;j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.printf("%d ", map[i][j]);
//			}
//			System.out.println();
//		}
		solve(n);
	}
	static void solve(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(visited[i][j] == 0 && map[i][j] == 1) {
					
//					al.add(bfs(i,j,n));
					
					dfs(i,j,n);
					al.add(cnt);
					cnt = 0;
				}
			}
		}
		Collections.sort(al);
		System.out.println(al.size());
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
		}
	}
	static void dfs(int i, int j, int n) {
		cnt ++;
		visited[i][j] = 1;
		for(int k=0;k<4;k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if(nx>=0 && ny>=0 && nx<n & ny<n) {
				if(visited[nx][ny] == 0 && map[nx][ny] == 1) {
					 dfs(nx, ny, n);
				}
			}
		}
	}
	static int bfs(int i, int j, int n) {
		int cnt = 1;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i*n + j);
		visited[i][j] = 1;
		while(!q.isEmpty()) {
			int h = q.remove();
			int x = h/n;
			int y = h%n;
			for(int k=0;k<4;k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx>=0 && ny>=0 && nx<n & ny<n) {
					if(visited[nx][ny] == 0 && map[nx][ny] == 1) {
						q.add(nx*n+ny);
						visited[nx][ny] = 1;
						cnt++;
					}
				}
			}
		}
		return cnt;	
	}
}
