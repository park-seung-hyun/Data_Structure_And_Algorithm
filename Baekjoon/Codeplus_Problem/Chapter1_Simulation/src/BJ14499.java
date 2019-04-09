// 14499번
// 주사위 굴리기
// 시뮬레이션 

//import java.util.Scanner;
//public class BJ14499 {
//	static int[][] map;
//	static int[] order;
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int n = stdIn.nextInt();
//		int m = stdIn.nextInt();
//		int x = stdIn.nextInt();
//		int y = stdIn.nextInt();
//		int o = stdIn.nextInt();
//		map = new int[n][m];
//		order = new int[o];
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				map[i][j] = stdIn.nextInt();
//			}
//		}
//		// 1,2,3,4 
//		for(int i=0;i<o;i++) order[i] = stdIn.nextInt();
//		solve(n,m,x,y,o);
//	}
//	static void solve(int n, int m,int x, int y, int o) {
//		Dice d = new Dice(0,0,0,0,0,0);
//		
//		// 명령어에 맞게 값 대입 
//		int[] dx = {0,0,-1,1};
//		int[] dy = {1,-1,0,0};
//		for(int i=0;i<o;i++) {
//			int num = order[i];
//			
//			// 이 때는 x,y 값에 변화없음. 
//			int nx = x+dx[num-1]; 
//			int ny = y+dy[num-1];
//			
//			// 범위 밖일 경우 명령 무시
//			if(nx >= n || ny >= m|| nx<0 || ny<0) {
//				nx -= dx[num-1];
//				ny -= dy[num-1];
//				continue;
//			}
//			// x, y 갱신 
//			x = nx;
//			y = ny;
//			control(num, d, x, y, n, m);
//		}
//	}
//	static void control(int num, Dice d, int x, int y, int w, int h) {
//		
//		if(num == 1) { // East // f,b 빼고 
//			int temp = d.up;
//			d.up = d.left;
//			d.left = d.down;
//			d.down = d.right;
//			d.right = temp;
//		}else if(num == 2) { // West // f,b 빼고 
//			int temp = d.up;
//			d.up = d.right;
//			d.right = d.down;
//			d.down = d.left;
//			d.left = temp;
//		}else if(num == 3) { // North // l,r 빼고 
//			int temp = d.up;
//			d.up = d.front;
//			d.front = d.down;
//			d.down = d.back;
//			d.back = temp;
//		}else { // South // l,r 빼고 
//			int temp = d.up;
//			d.up = d.back;
//			d.back = d.down;
//			d.down = d.front;
//			d.front = temp;
//		}
//		if(map[x][y] == 0) map[x][y] = d.down;
//		else { 
//			d.down = map[x][y] ;
//			map[x][y] = 0;
//		}
//		System.out.println(d.up);
//	}
//}
//class Dice{
//	int up;
//	int down;
//	int left;
//	int right;
//	int front;
//	int back;
//	Dice(int u, int d, int l,int r, int f, int b){
//		this.up = u;
//		this.down =d;
//		this.left = l;
//		this.right = r;
//		this.front = f;
//		this.back = b;
//	}
//}

import java.util.Scanner;
public class BJ14499{
	static int[][] map;
	static int[] order;
	
	// 동서북남 
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};

	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt(); // 가로 
		int m = stdIn.nextInt(); // 세로 
		int x = stdIn.nextInt();
		int y = stdIn.nextInt();
		int k = stdIn.nextInt();
		
		order = new int[k];
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = stdIn.nextInt();
			}
		}
		for(int i=0;i<k;i++) {
			order[i] = stdIn.nextInt();
		}
		
		Dice d = new Dice(0,0,0,0,0,0);
		for(int i=0;i<k;i++) {
			int or = order[i] - 1;
			int nx = x + dx[or];
			int ny = y + dy[or];
			if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
			simulate(or,d,x,y);
			if(map[nx][ny] == 0) map[nx][ny] = d.d;
			else {
				d.d = map[nx][ny];
				map[nx][ny] = 0;
			}
			System.out.println(d.u);
			x = nx;
			y = ny;
		}
		
	}
	static void simulate(int or, Dice d, int x, int y) {
		if(or == 0) { // 동 
			int temp = d.u;
			d.u = d.l;
			d.l = d.d;
			d.d = d.r;
			d.r = temp;
		}else if(or == 1) { // 서 
			int temp = d.u;
			d.u = d.r;
			d.r = d.d;
			d.d = d.l;
			d.l = temp;
		}else if(or == 2) { // 북 
			int temp = d.u;
			d.u = d.f;
			d.f = d.d;
			d.d = d.b;
			d.b = temp;
		}else { // 남 
			int temp = d.u;
			d.u = d.b;
			d.b = d.d;
			d.d = d.f;
			d.f = temp;
		}
		
		
		
	}
}
class Dice{
	int u;
	int d;
	int l;
	int r;
	int f;
	int b;
	Dice(int u, int d, int l, int r, int f,int b){
		this.u = u;
		this.d = d ;
		this.l = l;
		this.r = r;
		this.f = f;
		this.b = b;
	}
}