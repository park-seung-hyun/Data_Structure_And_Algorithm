// 15685번
// 드래곤 커브 
// 시뮬레이션 

//import java.util.ArrayList;
//import java.util.Scanner;
//public class BJ15685 {
//	
//	static int[] dx = {0,-1,0,1}; // r, u, l, d
//	static int[] dy = {1,0,-1,0}; // 반시계 ->
//	
//	static int[][] map = new int[101][101];
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int t = stdIn.nextInt();
//		for(int i=0;i<t;i++) {
//			int x = stdIn.nextInt();
//			int y = stdIn.nextInt();
//			int d = stdIn.nextInt();
//			int g = stdIn.nextInt();
//			solve(y,x,d,g);
//		}
//		check();
//	}
//	static void check() {
//		int cnt = 0;
//		for(int i=0;i<100;i++) {
//			for(int j=0;j<100;j++) {
//				if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1]==1 && map[i+1][j+1] == 1) {
//					cnt ++;
//				}
//			}
//		}
//		System.out.println(cnt);
//	}
//	static void solve(int x, int y, int d ,int g) {
//	
//		ArrayList<Integer> ar = new ArrayList<Integer>();
//		ar.add(d);
//		map[x][y] = 1;
//		int nx = x+dx[d];
//		int ny = y+dy[d];
//		map[nx][ny] = 1;
//		dragon(nx,ny,ar,g);
//		
//	}
//	static void dragon(int x, int y, ArrayList<Integer> ar, int g) {
//		if(g==0) return;
//		g--;
//		ArrayList<Integer> temp = new ArrayList<Integer>();
//		for(int i= ar.size()-1;i>=0;i--) {
//			int newd = ar.get(i) +1;
//			if(newd>3) newd = 0;
//			x += dx[newd];
//			y += dy[newd];
//			map[x][y] = 1;
//			temp.add(newd);
//		}
//		for(int i : temp) {
//			ar.add(i);
//		}
//		dragon(x,y,ar,g);
//	}
//}

import java.util.ArrayList;
import java.util.Scanner;
public class BJ15685{
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static int[][] map = new int[101][101];
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		for(int i=0;i<n;i++) {
			int y = stdIn.nextInt();
			int x = stdIn.nextInt();
			int d = stdIn.nextInt();
			int g = stdIn.nextInt();
			dragonCurve(x,y,d,g);
//			System.out.println();
//			for(int k=0;k<10;k++) {
//				for(int j=0;j<10;j++) {
//					System.out.printf("%d ",map[k][j]);
//				}
//				System.out.println();
//			}
		}
		System.out.println(squareNum());
		
	}
	static int squareNum() {
		int sum = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j] == 1 && map[i+1][j] == 1&& map[i][j+1] == 1 && map[i+1][j+1] == 1) sum++;
			}
		}
		return sum;
	}
	static void dragonCurve(int x, int y, int d, int g) {
		ArrayList<Integer> ds = new ArrayList<Integer>();
		ArrayList<Integer> temp;
		ds.add(d);
		map[x][y] = 1;
		x+=dx[d];
		y+=dy[d];
		map[x][y] = 1;
		for(int i=1;i<=g;i++) {
			temp = new ArrayList<Integer>();
			for(int j = ds.size()-1;j>=0;j--) {
				int newd = (ds.get(j)+1)%4;
				temp.add(newd);
				x += dx[newd];
				y += dy[newd];
				map[x][y] = 1;
			}
			for(int h : temp) {
				ds.add(h);
			}
		}
	}
}
