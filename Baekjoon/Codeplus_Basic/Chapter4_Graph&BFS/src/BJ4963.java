// 4963번 
// 섬의 개수  

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ4963 {
	static int[][] ar;
	static boolean[][] visited;
	static final int[] dx = {1,-1,0,0,1,1,-1,-1};
	static final int[] dy = {0,0,1,-1,1,-1,1,-1};
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int b = stdIn.nextInt();
		int a = stdIn.nextInt();
		while(!(a==0 && b==0)){
			ar = new int[a][b];
			visited = new boolean[a][b];
			for(int i=0;i<a;i++) {
				for(int j=0;j<b;j++) {
					ar[i][j] = stdIn.nextInt();
				}
			}
			solve(a,b);
			b = stdIn.nextInt();
			a = stdIn.nextInt();
		};
	}
	static void solve(int a, int b) {
		int cnt = 0;
		for(int i=0;i<a;i++) {
			for(int j=0;j<b;j++) {
				if(ar[i][j] == 1 && visited[i][j] == false) {
//					dfs(i,j,a,b);
					bfs(i,j,a,b);
					cnt ++;	
				}
			}
		}
		System.out.println(cnt);
	}
	static void dfs(int x, int y, int a, int b) {
		visited[x][y] = true;
		for(int i=0;i<8;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0&&ny>=0&&nx<a&&ny<b) {
				if(ar[nx][ny] == 1 && visited[nx][ny] == false)
					dfs(nx, ny, a,b);
			}
		}
	}
	static void bfs(int x, int y, int a, int b) {
		int n = x*b + y;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		visited[x][y] = true;
		while(!q.isEmpty()) {
			int h = q.remove();
			int ox = h/b;
			int oy = h%b;
			for(int i=0;i<8;i++) {
				int nx = ox + dx[i];
				int ny = oy + dy[i];
				if(nx>=0 && ny >=0 && nx<a && ny < b) {
					if(ar[nx][ny] == 1 && visited[nx][ny] == false) {
						visited[nx][ny] = true;
						q.add(nx*b + ny);
					}
				}
			}
		}
		
	}
}
