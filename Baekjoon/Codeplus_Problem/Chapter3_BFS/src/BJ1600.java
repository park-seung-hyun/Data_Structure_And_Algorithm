// 1600번
// 말이 되고픈 원숭이   
// BFS

//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//public class BJ1600 {
//	static int[][] map;
//	static int[][][] visited;
//	static final int[] dx = {0,0,-1,1,  -2,-2,-1,-1,1,1,2,2}; // 0~3 일반, 나머지 말 
//	static final int[] dy = {1,-1,0,0,  1,-1,2,-2,2,-2,1,-1};
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int k=stdIn.nextInt();
//		int h = stdIn.nextInt();
//		int w = stdIn.nextInt();
//		map = new int[w][h];
//		visited = new int[w][h][k+1];
//		for(int i=0;i<w;i++) {
//			for(int j=0;j<h;j++) {
//				map[i][j] = stdIn.nextInt();
//			}
//		}
//		solve(k,w,h);
//	}
//	static void solve(int k,int w, int h) {
//		Queue<Monkey> q= new LinkedList<Monkey>();
//		q.add(new Monkey(0,0,0));
//		visited[0][0][0] = 1;
//		while(!q.isEmpty()) {
//			Monkey m = q.remove();
//			int x = m.x;
//			int y = m.y;
//			int hm = m.hm;
//			for(int i=0;i<12;i++) {
//				int nx = x + dx[i];
//				int ny = y + dy[i];
//				if(nx >=0 && ny>=0 && nx<w && ny < h && map[nx][ny] != 1) {		
//					if(i<4) { // 일반 
//						if(visited[nx][ny][hm] == 0) {
//							q.add(new Monkey(nx,ny,hm));
//							visited[nx][ny][hm] = visited[x][y][hm] + 1;
//						}
//					}else { // 말 
//						if(hm >= k) break; // 더이상 말 능력 없음 
//						if(visited[nx][ny][hm + 1] == 0) {
//							q.add(new Monkey(nx,ny,hm+1));
//							visited[nx][ny][hm+1] = visited[x][y][hm] + 1;
//						}
//					}
//				}
//			}
//		}
//		
//		int ans = Integer.MAX_VALUE;
//		for(int i=0;i<=k;i++) {
//			if(ans > visited[w-1][h-1][i]-1 && visited[w-1][h-1][i] != 0)
//				ans = visited[w-1][h-1][i]-1;
//		}
//		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
//	}
//}
//class Monkey{
//	int x;
//	int y;
//	int hm;
//	Monkey(int x,int y, int hm) {
//		this.x =x ;
//		this.y = y;
//		this.hm = hm ;
//	}
//}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ1600{
	static int[][] map;
	static int[][][] visited;
	static final int[] dx = {-1,0,1,0  ,-2,-2,-1,-1,2,2,1,1};
	static final int[] dy = {0,1,0,-1  ,-1,1,-2,2,-1,1,-2,2};
	public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in);
		int k = stdIn.nextInt();
		int h = stdIn.nextInt();
		int w = stdIn.nextInt();
		map = new int[w][h];
		visited = new int[w][h][k+1];
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++){
				map[i][j] = stdIn.nextInt();
			}
		}
		Queue<M> q= new LinkedList<M>();
		q.add(new M(0,0,0));
		visited[0][0][0] = 1;
		while(!q.isEmpty()) {
			M r = q.remove();
			int x = r.x;
			int y = r.y;
			int t = r.t;
			for(int i=0;i<12;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny>=0 && nx < w && ny<h) {
					if(i<4) {
						if(map[nx][ny] != 1 && visited[nx][ny][t] == 0) {
							visited[nx][ny][t] = visited[x][y][t]+1;
							q.add(new M(nx,ny,t));
						}
					}
					if(i>=4 && t < k) {
						if(map[nx][ny] != 1 && visited[nx][ny][t+1] == 0) {
							visited[nx][ny][t+1] = visited[x][y][t]+1;
							q.add(new M(nx,ny,t+1));
						}
					}
					
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<=k;i++) {
			if(min > visited[w-1][h-1][i]-1 && visited[w-1][h-1][i] != 0) min = visited[w-1][h-1][i]-1;
		}	
		System.out.println(min == Integer.MAX_VALUE ? -1: min);
	}
}
class M{
	int x;
	int y;
	int t;
	M(int x, int y,int t) {
		this.x = x;
		this.y = y;
		this.t = t;
	}
}