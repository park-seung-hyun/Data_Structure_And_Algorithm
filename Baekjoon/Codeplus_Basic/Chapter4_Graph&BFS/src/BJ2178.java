// 2178번 
// 미로 탐색 
// bfs
// -> 최소 비용 문제
// -> 간선의 가중치가 1개 
// -> 정점과 간선 개수 적어야함. 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ2178 {
	static int[][] ar;
	static boolean[][] visited;
	static int[][] dist;
	static final int[] dx = {-1,1,0,0};
	static final int[] dy = {0,0,1,-1};
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		ar = new int[n][m];
		visited = new boolean[n][m];
		dist = new int[n][m];
		stdIn.nextLine();
		for(int i=0;i<n;i++) {
			String s = stdIn.nextLine();
			for(int j =0;j<m;j++) {
				ar[i][j] = s.charAt(j) -'0';
			}
		}
		solve(n,m);
	}
	static void solve(int n, int m) {
		bfs(n,m,0);
		System.out.println(dist[n-1][m-1]);
	}
	static void bfs(int n, int m,int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		int x = s/m;
		int y = s%m;
		visited[x][y] = true;
		dist[x][y] = 1;
		q.add(s);
		
		while(!q.isEmpty()) {
			int h = q.remove();
			int ox = h/m;
			int oy = h%m;
			for(int i=0;i<4;i++) {
				int nx = ox + dx[i];
				int ny = oy + dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny < m) {
					if(ar[nx][ny] == 1  && visited[nx][ny] == false) {
						q.add(nx*m + ny);
						visited[nx][ny] = true;
						dist[nx][ny] = dist[ox][oy] + 1;
					}
				}
			}
		}
	}
}

//public class BJ2178 {
//static int[][] map;
//static int[][] visited;
//static final int[] dx = {0,0,1,-1};
//static final int[] dy = {1,-1,0,0};
//public static void main (String[] args) {
//	Scanner stdIn = new Scanner(System.in);
//	int n = stdIn.nextInt();
//	int m = stdIn.nextInt();
//	map = new int[n][m];
//	visited = new int[n][m];
//	stdIn.nextLine();
//	for(int i=0;i<n;i++) {
//		String s = stdIn.nextLine();
//		for(int j=0;j<m;j++) {
//			map[i][j] = s.charAt(j) - '0';
//		}
//	}
//	solve(n,m);
//}
//static void solve(int n, int m) {
//	Queue<Integer> q = new LinkedList<Integer>();
//	q.add(0);
//	visited[0][0] = 1;
//	while(!q.isEmpty()) {
//		int h = q.remove();
//		int x = h/m;
//		int y = h%m;
//		for(int i=0;i<4;i++) {
//			int nx = x + dx[i];
//			int ny = y + dy[i];
//			if(nx >=0 && ny >=0 && nx <n && ny<m) {
//				if(visited[nx][ny] == 0 && map[nx][ny] == 1) {
//					q.add(nx*m + ny);
//					visited[nx][ny] = visited[x][y] + 1;
//				}
//			}
//		}
//	}
//	System.out.println(visited[n-1][m-1]);
//}
//}