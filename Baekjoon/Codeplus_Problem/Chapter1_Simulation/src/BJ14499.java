// 14499번
// 주사위 굴리기
// 시뮬레이션 

import java.util.Scanner;
public class BJ14499 {
	static int[][] map;
	static int[] order;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		int x = stdIn.nextInt();
		int y = stdIn.nextInt();
		int o = stdIn.nextInt();
		map = new int[n][m];
		order = new int[o];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = stdIn.nextInt();
			}
		}
		// 1,2,3,4 
		for(int i=0;i<o;i++) order[i] = stdIn.nextInt();
		solve(n,m,x,y,o);
	}
	static void solve(int n, int m,int x, int y, int o) {
		Dice d = new Dice(0,0,0,0,0,0);
		
		// 명령어에 맞게 값 대입 
		int[] dx = {0,0,-1,1};
		int[] dy = {1,-1,0,0};
		for(int i=0;i<o;i++) {
			int num = order[i];
			
			// 이 때는 x,y 값에 변화없음. 
			int nx = x+dx[num-1]; 
			int ny = y+dy[num-1];
			
			// 범위 밖일 경우 명령 무시
			if(nx >= n || ny >= m|| nx<0 || ny<0) {
				nx -= dx[num-1];
				ny -= dy[num-1];
				continue;
			}
			// x, y 갱신 
			x = nx;
			y = ny;
			control(num, d, x, y, n, m);
		}
	}
	static void control(int num, Dice d, int x, int y, int w, int h) {
		
		if(num == 1) { // East // f,b 빼고 
			int temp = d.up;
			d.up = d.left;
			d.left = d.down;
			d.down = d.right;
			d.right = temp;
		}else if(num == 2) { // West // f,b 빼고 
			int temp = d.up;
			d.up = d.right;
			d.right = d.down;
			d.down = d.left;
			d.left = temp;
		}else if(num == 3) { // North // l,r 빼고 
			int temp = d.up;
			d.up = d.front;
			d.front = d.down;
			d.down = d.back;
			d.back = temp;
		}else { // South // l,r 빼고 
			int temp = d.up;
			d.up = d.back;
			d.back = d.down;
			d.down = d.front;
			d.front = temp;
		}
		if(map[x][y] == 0) map[x][y] = d.down;
		else { 
			d.down = map[x][y] ;
			map[x][y] = 0;
		}
		System.out.println(d.up);
	}
}
class Dice{
	int up;
	int down;
	int left;
	int right;
	int front;
	int back;
	Dice(int u, int d, int l,int r, int f, int b){
		this.up = u;
		this.down =d;
		this.left = l;
		this.right = r;
		this.front = f;
		this.back = b;
	}
}
