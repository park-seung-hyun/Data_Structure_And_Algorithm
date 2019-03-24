// 3055번 
// 탈출
// 최소 비용 문제의 조건 -> 모든 가중치가 1
// 홍수로 인한 물이 차는 시간 즉 물의 최소 경로를 구한다. 
// 그 후 비버의 최소 경로를 계산한다. (물이 차는 시간과 겹치지 않도록 조건을 준다.)

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ3055 {
	static char[][] town;
	static int[][] flood;
	static int[][] visited;
	static final int[] dx = {0,0,-1,1};
	static final int[] dy = {1,-1,0,0};
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int r = stdIn.nextInt();
		int c = stdIn.nextInt();
		town = new char[r][c];
		flood = new int[r][c];
		visited = new int[r][c];
		for(int i=0;i<r;i++) {
			Arrays.fill(flood[i], -1);
			Arrays.fill(visited[i], -1);
		}
		stdIn.nextLine();
		for(int i=0;i<r;i++) {
			String s = stdIn.nextLine();
			for(int j= 0;j<c;j++) {
				town[i][j] = s.charAt(j);
			}
		}
		solve(r,c);
	}
	static void solve(int r, int c) {
		 bfsFlood(r, c);
		 bfs(r, c);
		 for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(town[i][j] == 'D') {
						System.out.println(visited[i][j] == -1 ? "KAKTUS":visited[i][j]);
				}
			}
		}
	}
	static void bfs(int r,int c) {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(town[i][j] == 'S') {
					q.add(i*c + j);
					visited[i][j] = 0;
					break;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int h = q.remove();
			int x = h/c;
			int y = h%c;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny >=0 && nx<r && ny < c) {
					if(visited[nx][ny] == -1 && (town[nx][ny] == '.' || town[nx][ny] == 'D')) {
						if(flood[nx][ny] > visited[x][y] +1 || flood[nx][ny] == -1) {
							q.add(nx*c + ny);
							visited[nx][ny] = visited[x][y] +1;
						}
					}
				}
			}
		}
	}
	static void bfsFlood(int r, int c) {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(town[i][j] == '*') {
					q.add(i*c + j);
					flood[i][j] = 0;
				}
			}
		}
		while(!q.isEmpty()) {
			int h = q.remove();
			int x = h/c;
			int y = h%c;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny >=0 && nx<r && ny < c) {
					if(flood[nx][ny] == -1 && (town[nx][ny] == '.' || town[nx][ny] == 'S')) {
						q.add(nx*c + ny);
						flood[nx][ny] = flood[x][y]+1;
					}
				}
			}
		}
	}
}
//public class BJ3055{
//	static char[][] map ;
//	static int[][] visited;
//	static int[][] visited2;
//	static final int[] dx = {0,0,-1,1};
//	static final int[] dy = {1,-1,0,0};
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int n = stdIn.nextInt();
//		int m = stdIn.nextInt();
//		map = new char[n][m];
//		visited = new int[n][m];
//		visited2 = new int[n][m];
//		stdIn.nextLine();
//		for(int i=0;i<n;i++) {
//			String s= stdIn.nextLine();
//			for(int j=0;j<m;j++) {
//				map[i][j] = s.charAt(j);
//			}
//		}
//		solve(n, m);
//	}
//	static void solve(int n, int m) {
//		bfs1(n,m);
////		for(int i=0;i<n;i++) {
////			for(int j=0;j<m;j++) {
////				System.out.printf("%d ", visited[i][j]);
////			}
////			System.out.println();
////		}
//		bfs2(n,m);
////		for(int i=0;i<n;i++) {
////			for(int j=0;j<m;j++) {
////				System.out.printf("%d ", visited2[i][j]);
////			}
////			System.out.println();
////		}
//	}
//	static void bfs2(int n, int m) {
//		Queue<Integer> q= new LinkedList<Integer>();
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				if(map[i][j] == 'S') {
//					q.add(i*m+j);
//					visited2[i][j] = 1;
//				}
//			}
//		}
//		while(!q.isEmpty()) {
//			int h = q.remove();
//			int x = h/m;
//			int y = h%m;
//			if(map[x][y] == 'D') {
//				System.out.println(visited2[x][y]-1);
//				return;
//			}
//			for(int i=0;i<4;i++) {
//				int nx = x+ dx[i];
//				int ny = y+dy[i];
//				if(nx>=0 && ny >=0 && nx < n && ny < m) {
//						 // 물 차는 시간보다 빠를 경우, 물이 방문 하지 않은 경우(물이 막혀있을때)
//						if(visited[nx][ny] > visited2[x][y] + 1 || visited[nx][ny] == 0) {
//							q.add(nx*m+ny);
//							visited2[nx][ny] = visited2[x][y] + 1;
//						}
//					}
//				}
//		}
//		
//		System.out.println("KAKTUS");		
//	}	
//	static void bfs1(int n, int m){
//		Queue<Integer> q= new LinkedList<Integer>();
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				if(map[i][j] == '*') {
//					q.add(i*m+j);
//					visited[i][j] = 1;
//				}
//			}
//		}
//		while(!q.isEmpty()) {
//			int h = q.remove();
//			int x = h/m;
//			int y = h%m;
//			for(int i=0;i<4;i++) {
//				int nx = x+ dx[i];
//				int ny = y+dy[i];
//				if(nx>=0 && ny >=0 && nx < n && ny < m) {
//					// 돌, 비버 집 아닐 경우 
//					if(visited[nx][ny] == 0 && map[nx][ny]!= 'X' && map[nx][ny]!= 'D') {
//						q.add(nx*m+ny);
//						visited[nx][ny] = visited[x][y] + 1;
//					}
//				}
//			}
//		}
//	}
//}