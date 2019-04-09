// 5213번
// 과외맨  
// BFS

//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//public class BJ5213 {
//	static Tile[] ts;
//	static int[] visited;
//	static int[] track;
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int n= stdIn.nextInt();
//		visited = new int[n*n-n/2+1];
//		track = new int[n*n-n/2+1];
//		ts = new Tile[n*n-n/2+1];
//		
//		for(int i=1;i<= n*n-n/2;i++) {
//			int a = stdIn.nextInt();
//			int b = stdIn.nextInt();
//			ts[i]= new Tile(a,b);
//		}
//		solve(n);
//	}
//	static void solve(int n) {
//		Queue<Integer> q = new LinkedList<Integer>();
//		q.add(1);
//		visited[1] = 1;
//		track[1] = -1;
//		while(!q.isEmpty()) {
//			int h = q.remove();
//			if(h == n*n-n/2) {
//				break;
//			}
//			Tile t = ts[h];
//			int f = t.f;
//			int s = t.s;
//			ArrayList<Integer> fc = getFirstConnected(h,n);
//			for(int i : fc) {
//				if(visited[i] == 0 && ts[h].f == ts[i].s) {
//					visited[i] = visited[h] + 1;
//					track[i] = h;
//					q.add(i);
//				}
//			}
//			ArrayList<Integer> sc = getSecondConnected(h,n);
//			for(int i : sc) {
//				if(visited[i] == 0 && ts[h].s == ts[i].f) {
//					visited[i] = visited[h] + 1;
//					track[i] = h;
//					q.add(i);
//				}
//			}
//			
//		}
//		int i = n*n-n/2;
//		for(i= n*n-n/2;i>0;i--) {
//			if(visited[i] != 0) break;
//		}
//		System.out.println(visited[i]);
//		track(i);
//	}
//	static void track(int n) {
//		if(n == -1) return;
//		track(track[n]);
//		System.out.printf("%d ",n);
//	}
//	static ArrayList<Integer> getFirstConnected(int h, int n){
//		ArrayList<Integer> connect = new ArrayList<Integer>();
//		int[] dx = {-n, -1, n-1};
//		for(int i=0;i<3;i++) {
//			if((i==0 || i==2) && (h-1)%(2*n-1) != 0 && h+dx[i] > 0 && h+dx[i] <= n*n-n/2)
//				connect.add(h+dx[i]);
//			if(i==1 && (h-1)%(2*n-1) != 0 && (h-(n+1)) % (2*n-1) !=0)
//				connect.add(h+dx[i]);
//		}
//		return connect;
//	}
//	static ArrayList<Integer> getSecondConnected(int h, int n){
//		ArrayList<Integer> connect = new ArrayList<Integer>();
//		int[] dx = {1-n, 1, n};
//		for(int i=0;i<3;i++) {
//			if((i==0 || i==2) && (h-n)%(2*n-1) != 0 && h+dx[i] > 0 && h+dx[i] <= n*n-n/2)
//				connect.add(h+dx[i]);
//			if(i==1 && (h-n)%(2*n-1) != 0 && h % (2*n-1) !=0)
//				connect.add(h+dx[i]);
//		}
//		return connect;
//	}
//}
//class Tile{
//	int f;
//	int s;
//	Tile(int f, int s){
//		this.f = f;
//		this.s = s;
//	}
//}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ5213{
	static int[][][] map;
	static int[][] visited;
	static int[][] track;
	static int[][] tileNum;
	// 해당 셀의 front(0~2), back(3~5) 
	static final int[] dx2 = {-1,0,1, -1,0,1};
	static final int[] dy2 = {0,-1,0, 1,1,1};
	
	static final int[] dx = {-1,0,1, -1,0,1};
	static final int[] dy = {-1,-1,-1, 0,1,0};
	
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		map = new int[n][n][2];
		visited = new int[n][n];
		track = new int[n][n];
		tileNum = new int[n][n];
		
//		int x = -1;
//		int y = 0;
//		
//		for(int i=0;i<n*n-n/2;i++) {
//			int a = stdIn.nextInt();
//			int b = stdIn.nextInt();
//			if(i%(n+n-1) == 0 || (i-n)%(n+n-1) == 0) {
//				x++;
//				y = 0;
//			}	
//			map[x][y][0] = a;
//			map[x][y][1] = b;
//			tileNum[x][y] = i+1;
//			y++;
//		}
		
		int id = 1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1;j++) {
				int a = stdIn.nextInt();
				int b = stdIn.nextInt();
				map[i][j][0] = a;
				map[i][j][1] = b;
				tileNum[i][j] = id++;
			}
			if(i%2==0) {
				int a = stdIn.nextInt();
				int b = stdIn.nextInt();
				map[i][n-1][0] = a;
				map[i][n-1][1] = b;
				tileNum[i][n-1] = id++;
			}
		}
		int x = 0;
		int y = 0;

		
		Queue<Tile> q = new LinkedList<Tile>();
		q.add(new Tile(0,0));
		visited[0][0] = 1;
		track[0][0] = -1;
		while(!q.isEmpty()) {
			Tile h = q.remove();
			x = h.x;
			y = h.y;
			int[] ndx;
			int[] ndy;
			if(x%2 ==0) {
				ndx = dx;
				ndy = dy;
			}else {
				ndx = dx2;
				ndy = dy2;
			}
			for(int i=0;i<6;i++) {
				int nx = x + ndx[i];
				int ny = y + ndy[i];
				if(nx >=0 && ny>=0 && nx <n && ny <n && map[nx][ny][0] != 0) {
					if(visited[nx][ny] != 0) continue;
					move(x,y,nx,ny,i,q, n);
				}
			}
		}
		for(int i=n-1;i>=0;i--) {
			for(int j=n-1;j>=0;j--) {
				if(visited[i][j] == 0) continue;
				System.out.println(visited[i][j]);
				trackNum(i*n+j,n);
				return;
			}
		}
	}
	static void move(int x, int y, int nx, int ny, int dir, Queue<Tile> q, int n) {
		
		if(dir <= 2) {
			if(map[nx][ny][1] == map[x][y][0]) {
				q.add(new Tile(nx,ny));
				visited[nx][ny] =  visited[x][y] + 1;
				track[nx][ny] = x*n + y;
			}
		}else {
			if(map[nx][ny][0] == map[x][y][1]) {
				q.add(new Tile(nx,ny));
				visited[nx][ny] =  visited[x][y] + 1;
				track[nx][ny] = x*n + y;
			}
		}
	}
	static void trackNum(int num,int n) {
		if(num == -1) return;
		int x = num/n;
		int y = num%n;
		trackNum(track[x][y], n);
		System.out.printf("%d ", tileNum[x][y]);
	}
}
class Tile{
	int x;
	int y;
	Tile(int x, int y){
		this.x = x;
		this.y = y;
	}
}