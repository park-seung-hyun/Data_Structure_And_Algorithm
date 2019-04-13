// 9376번 
// 탈옥 
// BFS
// Deque 사용

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
public class BJ9376 {
	static char[][] map;
	static int[][] visited;
	static int[][] visited2;
	static int[][] visited3;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		for(int i=0;i<t;i++) {
			int w = stdIn.nextInt();
			int h = stdIn.nextInt();
			map = new char[w+2][h+2];
			visited = new int[w+2][h+2];
			visited2 = new int[w+2][h+2];
			visited3 = new int[w+2][h+2];
			stdIn.nextLine();
			
			for(int j=0;j<=w+1;j++) {
				for(int m=0;m<=h+1;m++) {
					map[j][m] = '.';
				}
			}
			
			for(int j=1;j<=w;j++) {
				String s =  stdIn.nextLine();
				for(int m=1;m<=h;m++) {
					map[j][m] = s.charAt(m-1);
				}
			}
//			for(int j=0;j<=w+1;j++) {
//				for(int m=0;m<=h+1;m++) {
//					System.out.printf("%c ",map[j][m] );
//				}
//				System.out.println();;
//			}
			solve(w,h);
		}
	}
	static void solve(int w, int h) {
		for(int j=0;j<=w+1;j++) {
			for(int m=0;m<=h+1;m++) {
				visited[j][m] = -1;	
				visited2[j][m] = -1;	
				visited3[j][m] = -1;	
			}
		}
		bfs(w,h,0,0, visited);
		int cnt = 0;
		for(int j=0;j<=w+1;j++) {
			for(int m=0;m<=h+1;m++) {
				if(map[j][m] == '$') {
					if(cnt == 0) {
						bfs(w,h,j,m, visited2);
						cnt ++;
					}else
						bfs(w,h,j,m, visited3);
				}				
			}
		}
//		for(int j=0;j<=w+1;j++) {
//			for(int m=0;m<=h+1;m++) {
//				System.out.printf("%3d ",visited[j][m] );
//			}
//			System.out.println();;
//		}
//		System.out.println();;
//		for(int j=0;j<=w+1;j++) {
//			for(int m=0;m<=h+1;m++) {
//				System.out.printf("%3d ",visited2[j][m] );
//			}
//			System.out.println();;
//		}
//		System.out.println();;
//		for(int j=0;j<=w+1;j++) {
//			for(int m=0;m<=h+1;m++) {
//				System.out.printf("%3d ",visited3[j][m] );
//			}
//			System.out.println();;
//		}
		int ans = 10000000;
		for(int j=0;j<=w+1;j++) {
			for(int m=0;m<=h+1;m++) {
				if(map[j][m] != '*') {
					int cur = visited[j][m] + visited2[j][m] + visited3[j][m];
					
					if(map[j][m] == '#') cur -=2;
					
					if(cur<ans) {
						ans = cur;
					}
				}
				
		
			}
		}
		System.out.println(ans);
	}
	// bfs 함수화 
	// 시작점 인자로 받음. 
	static void bfs(int w, int h, int a, int b, int[][] visited) {
		
		Deque<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(a,b));
		visited[a][b] = 0;
		while(!q.isEmpty()) {
			
			Pos p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx>=0 && ny >=0 && nx < w+2 && ny < h+2) {
			
					if(visited[nx][ny] == -1 && map[nx][ny] != '*') {
						if(map[nx][ny] == '.' || map[nx][ny] == '$') {
							visited[nx][ny] = visited[x][y];
							q.addFirst(new Pos(nx,ny));
						}else if(map[nx][ny] == '#') {
							visited[nx][ny] = visited[x][y]+1;
							q.addLast(new Pos(nx,ny));
						}
					}
				
				}
			}
			
			
			
		}
		
	}
	
}
class Pos{
	int x;
	int y;
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}

//public class BJ9376 {
//	
//	static char[][] map;
//	static int[][] visited;
//	static int[][] visited2;
//	static int[][] visited3;
//	static int[] dx = {0,0,1,-1};
//	static int[] dy = {1,-1,0,0};
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int t = stdIn.nextInt();
//		for(int i=0;i<t;i++) {
//			int w = stdIn.nextInt();
//			int h = stdIn.nextInt();
//			map = new char[w+2][h+2];
//			visited = new int[w+2][h+2];
//			visited2 = new int[w+2][h+2];
//			visited3 = new int[w+2][h+2];
//			stdIn.nextLine();
//		
//			for(int j=0;j<=w+1;j++) {
//				for(int m=0;m<=h+1;m++) {
//					map[j][m] = '.';
//				}
//			}
//			
//			for(int j=1;j<=w;j++) {
//				String s =  stdIn.nextLine();
//				for(int m=1;m<=h;m++) {
//					map[j][m] = s.charAt(m-1);
//				}
//			}	
//
//			solve(w,h);
//		}
//	}
//	static void bfs(int x, int y, int w, int h, int which) {
//		int[][][] v = {visited, visited2, visited3};
//		ArrayDeque<P> dq = new ArrayDeque<P>();
//		dq.add(new P(x,y));
//		v[which][x][y] = 1;
//		while(!dq.isEmpty()) {
//			P r = dq.remove();
//			int ox = r.x;
//			int oy = r.y;
//			for(int i=0;i<4;i++) {
//				int nx = ox + dx[i];
//				int ny = oy + dy[i];
//				if(nx >= 0 && ny >= 0 && nx < w+2 && ny < h+2) {
//					if(v[which][nx][ny] == 0) {
//						
//						if(map[nx][ny] == '.' || map[nx][ny] == '$') {
//							dq.addFirst(new P(nx, ny));
//							v[which][nx][ny] = v[which][ox][oy];
//						}
//						if(map[nx][ny] == '#') {
//							dq.addLast(new P(nx, ny));
//							v[which][nx][ny] = v[which][ox][oy] + 1;
//						}
//
//					}
//					
//				}
//			}
//			
//		}
//		visited = v[0];
//		visited2 = v[1];
//		visited3 = v[2];
//	}
//	static void solve(int w, int h) {
//		bfs(0,0,w,h,0);
//		int cnt = 0;
//		for(int i=0;i<w+2;i++) {
//			for(int j=0;j<h+2;j++) {
//				if(map[i][j] == '$') {
//					if(cnt == 0) {
//						bfs(i,j,w,h,1);
//						cnt++;
//					}else {
//						bfs(i,j,w,h,2);
//					}
//				}
//			}
//		}
//		
//		int[][][] v= {visited, visited2,visited3};
////		for(int k=0;k<3;k++) {
////			for(int i=0;i<w+2;i++) {
////				for(int j=0;j<h+2;j++) {
////					System.out.printf("%d ", v[k][i][j]);
////				}
////				System.out.println();
////			}
////			System.out.println();
////			System.out.println();
////		}
//		
//		int min = Integer.MAX_VALUE;
//		
//		for(int i=0;i<w+2;i++) {
//			for(int j=0;j<w+2;j++) {
//				if(map[i][j] != '*' && visited[i][j] != 0) {
//					int sum = 0;
//					for(int k=0;k<3;k++) {
//						sum += v[k][i][j] - 1;
//					}
//					if(map[i][j] == '#') sum -= 2;
//					if(sum < min) min = sum;
//				}
//			
//			}
//		}
//		System.out.println(min);
//		
//	}
//}
//class P{
//	int x;
//	int y;
//	P(int x, int y){
//		this.x = x;
//		this.y = y;
//	}
//}
//
