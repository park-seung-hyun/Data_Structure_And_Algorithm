// 7576번 (복습)  
// 토마토 
// BFS (Breadth-First-Search)

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Re_BJ7576 {
	static int n;
	static int m;
	static int[][] map;
	static final int[] dx = {0,0,-1,1};
	static final int[] dy = {1,-1,0,0};
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		m = stdIn.nextInt();
		n = stdIn.nextInt();
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				 map[i][j] = stdIn.nextInt();
			}
		}
		solve();
	}
	static void solve() {
		int t = bfs();
		System.out.println(isDone()?t-1:-1);
	}
	static int bfs() {
		int time = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 1)
					q.add(i*m+j);
			}
		}
		while(!q.isEmpty()) {
			int h = q.remove();
			int x = h/m;
			int y = h%m;
			if(time < map[x][y]) {
				time = map[x][y];
			}
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny >=0 && nx<n && ny < m) {
					if(map[nx][ny] == 0) {
						q.add(nx*m + ny);
						map[nx][ny] = map[x][y] + 1;
					}
				}
			}
		}
		return time;
	}
	static boolean isDone() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 0)
					return false;
			}
		}
		return true;
	}
}
