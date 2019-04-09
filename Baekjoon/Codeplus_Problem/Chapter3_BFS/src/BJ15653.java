// 15653번
// 구슬 탈출4  
// BFS

//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//public class BJ15653 {
//	static char[][] map;
//	static int[][] visited;
//	static final int[] dx = {1,-1,0,0};
//	static final int[] dy = {0,0,1,-1};
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int w = stdIn.nextInt();
//		int h = stdIn.nextInt();
//		map = new char[w][h];
//		visited = new int[w*h][w*h];
//		stdIn.nextLine();
//		for(int i=0;i<w;i++) {
//			String s = stdIn.nextLine();
//			for(int j=0;j<h;j++) {
//				map[i][j]  = s.charAt(j);
//			}
//		}
//		solve(w, h);
//	}
//	static void solve(int w, int h) {
//		Queue<Ball> q = new LinkedList<Ball>();
//		int x = 0;
//		int y = 0;
//		int x2 = 0;
//		int y2 = 0;
//		for(int i=0;i<w;i++) {
//			for(int j=0;j<h;j++) {
//				if(map[i][j] == 'R') {
//					x = i;
//					y = j;
//				}
//				if(map[i][j] == 'B') {
//					x2 = i;
//					y2 = j;
//				}
//			}
//		}
//		q.add(new Ball(x,y,x2,y2));
//		visited[x*h+y][x2*h+y2] = 1;
//		
//		while(!q.isEmpty()) {
//			
//			Ball b1 = q.remove();
//			
//			// R
//			x = b1.x;
//			y = b1.y;
//			// B
//			x2 = b1.x2;
//			y2 = b1.y2;
//			
//			if(map[x][y] == 'O' && map[x2][y2] != 'O') {
//				System.out.println(visited[x*h+y][x2*h+y2] - 1);
//				return;
//			}
//			
//			// 파란공이 빠지면 해당 경우는 무시 (다음 경우 없음.)
//			if(map[x2][y2] == 'O') continue;
//			
//			for(int i=0;i<4;i++) {
//				// 일단 끝까지 보내?
//				// R
//				int nx = x + dx[i];
//				int ny = y + dy[i];
//				
//				while(nx > 0 && ny > 0 && nx < w-1 && ny < h-1 && map[nx][ny] != '#') {
//					if(map[nx][ny] == 'O') { 
//						nx += dx[i];
//						ny += dy[i];
//						break;
//					}
//					nx += dx[i];
//					ny += dy[i];
//				}
//				nx -= dx[i];
//				ny -= dy[i];
//				
//				// B
//				int nx2 = x2 + dx[i];
//				int ny2 = y2 + dy[i];
//				
//				while(nx2 > 0 && ny2 > 0 && nx2 < w-1 && ny2 < h-1 && map[nx2][ny2] != '#') {
//					if(map[nx2][ny2] == 'O') { 
//						nx2 += dx[i];
//						ny2 += dy[i];
//						break;
//					}
//					nx2 += dx[i];
//					ny2 += dy[i];
//				}
//				nx2 -= dx[i];
//				ny2 -= dy[i];
//				
//				
//				// 둘이 겹칠 경우 
//				if(nx == nx2 && ny == ny2 && map[nx][ny] != 'O') {
//
//					if(i == 0) {
//						// 우
//						if(x < x2) {
//							nx -=dx[i];
//							ny -=dy[i];
//						}else {
//							nx2 -=dx[i];
//							ny2 -=dy[i];
//						}
//					}
//					if(i==1) {
//						//좌
//						if(x < x2) {
//							nx2 -=dx[i];
//							ny2 -=dy[i];
//						}else {
//							nx -=dx[i];
//							ny -=dy[i];
//						}
//					}
//					if(i==2) {
//						//상
//						if(y < y2) {
//							nx -=dx[i];
//							ny -=dy[i];
//						}else {
//							nx2 -=dx[i];
//							ny2 -=dy[i];
//						}
//					}
//					if(i==3) { //
//						if(y < y2) {
//							nx2 -=dx[i];
//							ny2 -=dy[i];
//						}else {
//							nx -=dx[i];
//							ny -=dy[i];
//						}
//					}
//				}
//				
//				if(visited[nx*h+ny][nx2*h+ny2] == 0) {
//					q.add(new Ball(nx, ny, nx2,ny2));
//					visited[nx*h+ny][nx2*h+ny2]  = visited[x*h+y][x2*h+y2] + 1;	
//				}
//			}
//			
//		}
//		System.out.println(-1);
//	}
//}
//class Ball{
//	int x;
//	int y;
//	int x2;
//	int y2;
//	Ball(int x, int y, int x2, int y2){
//		this.x = x;
//		this.y = y;
//		this.x2 = x2;
//		this.y2 = y2;
//	}
//}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ15653{
	static final int[] dx = {-1,0,1,0};
	static final int[] dy = {0,1,0,-1};
	static char[][] map;
	static int[][] visited;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		map = new char[n][m];
		visited = new int[n*m][n*m];
		stdIn.nextLine();
		for(int i=0;i<n;i++) {
			String s = stdIn.nextLine();
			for(int j=0;j<m;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		solve(n,m);
	}
	static void solve(int n, int m) {
		// 초기 위치 
		int rx = 0;
		int ry = 0;
		int bx = 0;
		int by = 0;
		int hx = 0;
		int hy = 0;
		
		// 초기 공 위치, 구멍 위치 
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 'R') {
					rx = i;
					ry = j;
					map[i][j] = '.';
				}else if(map[i][j] == 'B') {
					bx = i;
					by = j;
					map[i][j] = '.';
				}else if(map[i][j] == 'O') {
					hx = i;
					hy = j;
					map[i][j] = '.';
				}
			}
		}
		visited[rx*m + ry][bx*m + by] = 1;
		Queue<Balls> q = new LinkedList<Balls>();
		q.add(new Balls(rx,ry,bx,by));
		
		while(!q.isEmpty()) {
			Balls h = q.remove();
			int x1 = h.rx;
			int y1 = h.ry;
			int x2 = h.bx;
			int y2 = h.by;
			int time = visited[x1*m+y1][x2*m+y2];
//			System.out.println(x1 + " " + y1 + " " + x2 + " " + y2 );
			if(x2 == hx && y2 == hy) continue;
			if(x1 == hx && y1 == hy) {
				System.out.println(time-1);
				return;
			}
			// 북동남서 방향 기울이기 
			for(int i=0;i<4;i++) {
				
				// 빨간 공 
				int nx = x1 + dx[i];
				int ny = y1 + dy[i];
				while(nx>=0 && ny>=0 && nx < n && ny < m && map[nx][ny] != '#') {
					if(nx == hx && ny == hy) { // 구멍에 빠질 경우 .. 
						nx += dx[i];
						ny += dy[i];
						break;
					}
					nx += dx[i];
					ny += dy[i];
				}
				nx -= dx[i];
				ny -= dy[i];
				
				// 파란 공 
				int nx2 = x2 + dx[i];
				int ny2 = y2 + dy[i];
				while(nx2>=0 && ny2>=0 && nx2 < n && ny2 < m && map[nx2][ny2] != '#') {
					if(nx2 == hx && ny2 == hy) { // 구멍에 빠질 경우 .. 
						nx2 += dx[i];
						ny2 += dy[i];
						break;
					}
					nx2 += dx[i];
					ny2 += dy[i];
				}
				nx2 -= dx[i];
				ny2 -= dy[i];
				
				// 구멍에 빠지지 않았고, 같은 위치일 경우 .. 
				if(nx == nx2 && ny == ny2 && !(nx == hx && ny == hy)) {
					// 북으로 기울임...  더 아래 있는 사람이 뒤로 물러남..
					int dir = i;
					if(dir == 0) {
						if(x1 > x2) {
							nx -= dx[dir];
							ny -= dy[dir];
						}else {
							nx2 -= dx[dir];
							ny2 -= dy[dir];
						}
					}
					// 동으로 기울임... 더 왼쪽에 있던 사람이 왼쪽으로 물러남..
					else if(dir == 1) {
						if(y1 < y2) {
							nx -= dx[dir];
							ny -= dy[dir];
						}else {
							nx2 -= dx[dir];
							ny2 -= dy[dir];
						}
					}
					// 남으로 기울임... 더 위에 있던 사람이 위로 물러남..
					else if(dir == 2) {
						if(x1 < x2) {
							nx -= dx[dir];
							ny -= dy[dir];
						}else {
							nx2 -= dx[dir];
							ny2 -= dy[dir];
						}
					}
					// 서로 기울임... 더 오른쪽에 있던 사람이 오른쪽으로 물러남..
					else {
						if(y1 > y2) {
							nx -= dx[dir];
							ny -= dy[dir];
						}else {
							nx2 -= dx[dir];
							ny2 -= dy[dir];
						}
					}
				}
				if(visited[nx*m + ny][nx2*m + ny2] == 0) {
					visited[nx*m + ny][nx2*m + ny2] = time + 1;
					q.add(new Balls(nx,ny,nx2,ny2));
				}
			}
		}
		System.out.println(-1);
		
	}
	static void changePos(int x1, int y1, int x2, int y2, int nx, int ny, int nx2, int ny2, int dir) {
		// 북으로 기울임...  더 아래 있는 사람이 뒤로 물러남..
		if(dir == 0) {
			if(x1 > x2) {
				nx -= dx[dir];
				ny -= dy[dir];
			}else {
				nx2 -= dx[dir];
				ny2 -= dy[dir];
			}
		}
		// 동으로 기울임... 더 왼쪽에 있던 사람이 왼쪽으로 물러남..
		else if(dir == 1) {
			if(y1 < y2) {
				nx -= dx[dir];
				ny -= dy[dir];
			}else {
				nx2 -= dx[dir];
				ny2 -= dy[dir];
			}
		}
		// 남으로 기울임... 더 위에 있던 사람이 위로 물러남..
		else if(dir == 2) {
			if(x1 < x2) {
				nx -= dx[dir];
				ny -= dy[dir];
			}else {
				nx2 -= dx[dir];
				ny2 -= dy[dir];
			}
		}
		// 서로 기울임... 더 오른쪽에 있던 사람이 오른쪽으로 물러남..
		else {
			if(y1 > y2) {
				nx -= dx[dir];
				ny -= dy[dir];
			}else {
				nx2 -= dx[dir];
				ny2 -= dy[dir];
			}
		}

	}
}
class Balls{
	int rx;
	int ry;
	int bx;
	int by;
	Balls(int rx, int ry, int bx, int by){
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
	}
}