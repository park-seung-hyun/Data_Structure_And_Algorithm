// 7576번 
// 토마토  
// bfs
// -> 최소 비용 문제
// -> 간선의 가중치가 1개 
// -> 정점과 간선 개수 적어야함.
// 처음에 익은 토마토(1)의 위치를 모두 큐에 넣어야함. 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ7576 {
	static int[][] ar;
	static boolean[][] visited;
	static int[][] day;
	static final int[] dx = {0,0,-1,1};
	static final int[] dy = {1,-1,0,0};
	static int max = 0;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int m = stdIn.nextInt();
		int n = stdIn.nextInt();
		ar = new int[n][m];
		day = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				ar[i][j] = stdIn.nextInt();
			}
		}
		solve(n,m);
	}
	static void solve(int n, int m) {
		bfs(n,m);
		System.out.println(check(n,m));
	}
	static int check(int n, int m) {
		int max = 0;
		for(int i=0;i<n;i++) {
			for(int j =0;j<m;j++) {
				if(max<day[i][j])
					max = day[i][j];
				if(ar[i][j] == 0 && visited[i][j] == false)
					return -1;
			}
		}
		return max;
	}
	static void bfs(int n, int m ) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		// 가장 중요한 작업 
		// 처음에 1인 토마토의 위치를 모두 큐에 넣어야함. 
		// 실수 반복.. 
		for(int i=0;i<n;i++) {
			for(int j= 0;j<m;j++) {
				if(ar[i][j] == 1) {
					visited[i][j] = true;
					q.add(i*m + j);
				}	
			}
		}
		while(!q.isEmpty()) {
			int h =q.remove();
			int ox = h/m;
			int oy = h%m;
			for(int i=0;i<4;i++) {
				int nx = ox + dx[i];
				int ny = oy + dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if(ar[nx][ny] == 0 && visited[nx][ny] == false) {
						visited[nx][ny] = true;
						day[nx][ny] = day[ox][oy] + 1;
						q.add(nx*m + ny);
					}
				}
			}
		}
	}
}
