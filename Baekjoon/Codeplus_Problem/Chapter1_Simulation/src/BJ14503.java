// 14503번
// 로봇 청소기 
// 시뮬레이션

import java.util.Scanner;
public class BJ14503 {
	static int[][] map;
	static int[][] visited;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m= stdIn.nextInt();
		map = new int[n][m];
		visited = new int[n][m];
		int sx = stdIn.nextInt();
		int sy = stdIn.nextInt();
		int dir = stdIn.nextInt();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = stdIn.nextInt();
			}
		}
		solve(n,m,sx,sy,dir);
	}
	static void solve(int n, int m, int sx, int sy, int dir) {
		
		clean2(sx,sy,dir,n,m);
		int sum = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(visited[i][j] == 1) sum++;
			}
		}
		System.out.println(sum);
		
	}
	// 재귀 없이 반복문 하나로 구현 
	static void clean2(int x, int y, int dir, int n, int m) {
	
		int[] dx = {-1,0,1,0}; // nesw
		int[] dy = {0,1,0,-1};
		
		while(true) {
			visited[x][y] = 1;
			boolean flag = false;
			int cnt = 3;
			for(int i=dir-1;cnt>=0;i--) {
				cnt--;
				if(i == -1) i = 3;
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
				if(map[nx][ny] != 1 && visited[nx][ny] == 0) {
					x = nx;
					y = ny;
					dir = i;
					flag = true;
					break;
				}
			}
			if(flag == false) {
				int nx = x - dx[dir];
				int ny = y - dy[dir];
				if(map[nx][ny]!=1) {
					x = nx;
					y = ny;
				}else {
					return;
				}
			}
		}
	}
	static void clean(int x, int y, int dir, int n, int m) {
		visited[x][y] = 1;
		int d = dir;
		int[] dx = {-1,0,1,0}; // nesw
		int[] dy = {0,1,0,-1};
		int c = 4;
		while(c != 0) {
			c--;
			d--;
			if(d == -1) d = 3;
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
			if(map[nx][ny] != 1 && visited[nx][ny] == 0) {
				clean(nx,ny,d,n,m);
				return;
			}
		}
		int nx = x - dx[dir];
		int ny = y - dy[dir];
		if(map[nx][ny]!=1) {
			clean(nx,ny,dir,n,m);
		}else {
			return;
		}
		
	}
}
