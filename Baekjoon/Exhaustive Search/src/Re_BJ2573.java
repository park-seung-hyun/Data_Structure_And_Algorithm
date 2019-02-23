// 2573번 (복습)
// 빙산
// DFS (Depth-First-Search)
// BFS (Breadth-First-Search)

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Re_BJ2573 {
	static int[][] ice;
	static int[][] visited;
	
	static final int[] dx = {-1,1,0,0};
	static final int[] dy = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		ice = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				ice[i][j] = stdIn.nextInt();
			}
		}
		solve(n,m);
	}
	static void solve(int n, int m) {
		int year = 0;
		
		while(!moreThanTwo(n,m)) {
			year++;
			oneYearAfter(n, m);
			if(allMelt(n,m)) {
				System.out.println(0);
				return;
			}
				
			
		}
		System.out.println(year);
	}
	static boolean allMelt(int n, int m) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(ice[i][j] >0)
					return false;
			}
		}
		return true;
	}
	static void oneYearAfter(int n, int m) {
		int[][] nextIce = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				nextIce[i][j] = ice[i][j];
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(ice[i][j]>0) {
					int cnt = 0;
					for(int k=0;k<4;k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(nx>=0 && ny >=0 && nx<n && ny < m) {
							if(ice[nx][ny] == 0)
								cnt ++;
						}
					}
					nextIce[i][j] -= cnt;
					if(nextIce[i][j]<0)
						nextIce[i][j] = 0;
				}
			}
		}
		ice = nextIce;
	}
	static boolean moreThanTwo(int n, int m) {
		visited = new int[n][m];
		int cnt = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(visited[i][j] == 0 && ice[i][j]>0) {
					cnt ++;
					dfs(i,j,n,m);
					if(cnt > 1)
						return true;
				}
			}
		}
		return false;
	}
	static void dfs(int i, int j, int n, int m) {
		visited[i][j] = 1;
		for(int k=0;k<4;k++) {
			int nx = dx[k] + i;
			int ny = dy[k] + j;
			if(nx>=0 && ny >=0 && nx<n && ny < m) {
				if(visited[nx][ny] == 0 && ice[nx][ny] >0) {
					dfs(nx,ny,n,m);
				}
			}
		}
	}
	static void bfs(int i, int j, int n, int m) {
		int c = i*m + j;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(c);
		visited[i][j] = 1;
		
		while(!q.isEmpty()) {
			int h = q.remove();
			int x = h/m;
			int y = h%m;
			
			for(int k=0;k<4;k++) {
				int nx = dx[k] + x;
				int ny = dy[k] + y;
				if(nx>=0 && ny >=0 && nx<n && ny < m) {
					if(visited[nx][ny] == 0 && ice[nx][ny] >0) {
						q.add(nx*m + ny);
						visited[nx][ny] = 1;
					}
				}
			}
		}
		
	}
}
