import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ3197 {
	static char[][] map;
	static int[][] visited; // 물이 차오르는 속도 
	static boolean[][] visited2; // 백조 -> 백조 시간 
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int r = stdIn.nextInt();
		int c = stdIn.nextInt();
		stdIn.nextLine();
		map = new char[r][c];
		visited = new int[r][c];
		visited2 = new boolean[r][c];
		for(int i=0;i<r;i++) {
			String s =stdIn.nextLine();
			for(int j=0;j<c;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		solve(r,c);
	}
	static void solve(int r, int c) {
		
		// 물이 차는 시간 계
		Queue<Water> q = new LinkedList<Water>();
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j] != 'X') {
					q.add(new Water(i,j));
					visited[i][j] = 1;
				}
			}
		}
		while(!q.isEmpty()) {
			Water h = q.remove();
			int x = h.x;
			int y = h.y;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny >=0 && nx < r && ny < c) {
					if(visited[nx][ny] == 0) {
						q.add(new Water(nx,ny));
						visited[nx][ny] = visited[x][y] + 1;
					}
				}
			}
		}
		
		// 백조 투더 백조 
		ArrayDeque<Water2> dq = new ArrayDeque<Water2>();
		for(int i=0;i<r;i++) {
			boolean flag = false;
			for(int j=0;j<c;j++) {
				if(map[i][j] == 'L') {
					// 첫 백조 dq에 삽입 
					dq.addFirst(new Water2(i,j,0));
					map[i][j] = '.';
					visited2[i][j] = true;
					flag = true;
					break;
				}
			}
			if(flag == true) break;
		}
		while(!dq.isEmpty()) {
			Water2 h = dq.removeFirst();
			int x = h.x;
			int y = h.y;
			int t = h.t;
			if(map[x][y] == 'L') { // 백조 발견 
				System.out.println(t);
//				return;
			}
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny >=0 && nx < r && ny < c) {
					if(visited[nx][ny] <= visited[x][y]) {
						if(visited2[nx][ny] == false) {
							dq.addFirst(new Water2(nx,ny,t));
							visited2[nx][ny] = true;
						}
					}
					else {
						if(visited2[nx][ny] == false) {
							dq.addLast(new Water2(nx,ny,t+1));
							visited2[nx][ny] = true;
						}
					}
				}
			}
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.printf("%d ", visited[i][j]);
			}
			System.out.println();;
		}
//		System.out.println();;
//		for(int i=0;i<r;i++) {
//			for(int j=0;j<c;j++) {
//				System.out.printf("%d ", visited2[i][j]);
//			}
//			System.out.println();;
//		}
		
	}
}
class Water{
	int x;
	int y;
	Water(int x,int y){
		this.x = x;
		this.y = y;
	}
}
class Water2{
	int x;
	int y;
	int t;
	Water2(int x,int y, int t){
		this.x = x;
		this.y = y;
		this.t=t ;
	}
}

//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class BJ3197{
//	static char[][] map;
//	static final int[] dx = {1,-1,0,0};
//	static final int[] dy = {0,0,1,-1};
//	static int[][] visited;
//	static int[][] visited2;
//	
//	static Queue<Bird> bq = new LinkedList<Bird>();
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int w = stdIn.nextInt();
//		int h = stdIn.nextInt();
//		
//		map = new char[w][h];
//		visited = new int[w][h];
//		stdIn.nextLine();
//		for(int i=0;i<w;i++) {
//			String s = stdIn.nextLine();
//			for(int j=0;j<h;j++) {
//				map[i][j] = s.charAt(j);
//			}
//		}
//		solve(w,h);
//	}
//	static boolean check(int sx, int sy, int ex, int ey, int w, int h) {
//
//		Queue<Bird> q = new LinkedList<Bird>();
//		q = bq;
//		bq = new LinkedList<Bird>();
//		while(!q.isEmpty()) {
//			Bird r= q.remove();
//			int x = r.x;
//			int y = r.y;
//			if(x == ex && y == ey) {
//				return true;
//			}
//			for(int i=0;i<4;i++) {
//				int nx = x + dx[i];
//				int ny = y + dy[i];
//				if(nx>=0 && ny>=0 && nx< w && ny < h) {
//					if(visited2[nx][ny] == 0 && (map[nx][ny] == '.' || map[nx][ny] == 'L')) {
//						q.add(new Bird(nx, ny));
//						visited2[nx][ny] = 1;
//					}else if(visited2[nx][ny] == 0 && map[nx][ny] == 'X') {
//						bq.add(new Bird(nx,ny)); // 다음 임시 저장 
//						visited2[nx][ny] = 1;
//					}
//				}
//			}
//		}
//		return false;
//		
//	}
//	static void solve(int w, int h) {
//		int sx =0;
//		int sy =0;
//		int ex =0;
//		int ey =0;
//		
//		// 백조 위치 찾기 
//		int cnt = 1;
//		for(int i=0;i<w;i++) {
//			for(int j=0;j<h;j++) {
//				if(map[i][j]=='L') {
//					if(cnt == 1) {
//						sx = i;
//						sy = j;
//						cnt--;
//					}else {
//						ex = i;
//						ey = j;
//					}
//				}
//			}
//		}
//
//		visited2 = new int[w][h];
//		bq.add(new Bird(sx,sy));
//		visited2[sx][sy] = 1;
//		
//		// 물녹이기 
//		Queue<Water> q= new LinkedList<Water>();
//		for(int i=0;i<w;i++) {
//			for(int j=0;j<h;j++) {
//				if(map[i][j]=='.' || map[i][j] == 'L') {
//					q.add(new Water(i,j,0));
//					visited[i][j] = 1;
//				}
//			}
//		}
//		int day = 0;
//		while(!q.isEmpty()) {
//			Water r = q.remove();
//			int x = r.x;
//			int y=  r.y;
//			int t = r.t;
//			if(t == day +1) {
//				if(check(sx,sy,ex,ey,w,h)) {
//					System.out.println(t);
//					return;
//				}			
//				day++;
//			}
//			
//			for(int i=0;i<4;i++) {
//				int nx = x + dx[i];
//				int ny = y+ dy[i];
//				if(nx >=0 && ny >= 0 && nx <w && ny < h) {
//					
//					if(visited[nx][ny] == 0 && map[nx][ny] == 'X') {
//						q.add(new Water(nx,ny,t+1));
//						visited[nx][ny] = 1;
//						map[nx][ny] = '.';
//					}
//				}
//			}
//			
//		}
//		
//	}
//}
//class Water{
//	int x;
//	int y;
//	int t;
//	Water(int x, int y, int t){
//		this.x = x;
//		this.y = y;
//		this.t = t;
//	}
//}
//class Bird{
//	int x;
//	int y;
//	Bird(int x, int y){
//		this.x = x;
//		this.y = y;
//	}
//}
