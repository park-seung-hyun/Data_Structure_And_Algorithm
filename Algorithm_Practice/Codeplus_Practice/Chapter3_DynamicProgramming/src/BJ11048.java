// 11048번 
// 이동하기  
// DP
// BFS로 시도했으나 visited가 의미없어 시간초과 뜸.
// 이전 칸 (3개)의 Max값이 해당 칸에서도 유효함. -> DP가 가능함. (아닐경우 BF)

import java.util.Arrays;
import java.util.Scanner;
public class BJ11048 {
	static int[][] map;
	static int[][] d;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		map = new int[n+1][m+1];
		d = new int[n+1][m+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				map[i][j] = stdIn.nextInt();
			}
		}
		// Bottom-Up
//		dp(n,m);
		dp2(n,m);
		
		// Top-Down
//		for(int i=0;i<=n;i++) Arrays.fill(d[i], -1);
//		dp3(n,m);
//		System.out.println(d[n][m]);
	}
	// Bottom-Up
	static void dp(int n, int m) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				// 최대값을 구하는 문제에서 대각선은 무시해도됨.
				// 옆으로, 아래로 보다 무조건 대각선이 비용이 더 작음.
				d[i][j] = max2(d[i-1][j], d[i][j-1]) + map[i][j];
			}
		}
		System.out.println(d[n][m]);
	}
	static void dp2(int n, int m) {
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {	
				if(i+1 <= n)
					d[i+1][j] = max2(d[i+1][j], d[i][j] + map[i+1][j]);
				if(j+1 <= m)
					d[i][j+1] = max2(d[i][j+1], d[i][j] + map[i][j+1]);
			}
		}
		System.out.println(d[n][m]);
	}
	// Top-Down 
	static int dp3(int i, int j) {
		if(i <1 || j <1) return 0;
		if(d[i][j] != -1) return d[i][j];
		d[i][j] = max2(dp3(i-1, j), dp3(i, j-1)) + map[i][j];
		return d[i][j];
	}
	static int max3(int a, int b,int c) {
		int max = a;
		if(b>max) max = b;
		if(c>max) max = c;
		return max;
	}
	static int max2(int a, int b) {
		int max = a;
		if(max < b) max = b;
		return max;
	}
}

//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class BJ11048 {
//	static int[][] map;
//	static int[] visited = new int[1000001];
//	static final int[] dx = {1,0,1};
//	static final int[] dy = {1,1,0};
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int n = stdIn.nextInt();
//		int m = stdIn.nextInt();
//		map = new int[n][m];
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				map[i][j] = stdIn.nextInt();
//			}
//		}
//		solve(n,m);
//	}
//	static void solve(int n, int m) {
//		Queue<Integer> q = new LinkedList<Integer>();
//		q.add(0);
//		visited[0] = map[0][0];
//		while(!q.isEmpty()) {
//			int h = q.remove();
//			int x = h/m;
//			int y = h%m;
//			for(int i=0;i<3;i++) {
//				int nx = x + dx[i];
//				int ny = y + dy[i];
//				if(nx>=0 && ny>=0 && nx < n && ny <m) {
//					if(visited[nx*m+ny] < map[nx][ny] + visited[h]) {
//						q.add(nx*m+ny);
//						visited[nx*m+ny] = map[nx][ny] + visited[h];
//					}
//				}
//			}		
//		}
//		System.out.println(visited[(n-1)*m+m-1]);
//		
//	}
//}
