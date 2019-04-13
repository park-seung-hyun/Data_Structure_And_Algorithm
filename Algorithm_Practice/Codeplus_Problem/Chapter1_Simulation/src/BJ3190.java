// 3190번
// 뱀 
// 시뮬레이션 

//import java.util.ArrayDeque;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Scanner;
//public class BJ3190 {
//	static ArrayDeque<Snake> sn = new ArrayDeque<Snake>();
//	static HashMap<Integer, Character> hm = new HashMap<Integer, Character>();
//	static int[][] map;
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int n = stdIn.nextInt();
//		map = new int[n][n];
//		int k= stdIn.nextInt();
//		for(int i=0;i<k;i++) {
//			int a = stdIn.nextInt();
//			int b = stdIn.nextInt();
//			map[a-1][b-1] = 2;
//		}
//		int l = stdIn.nextInt();
//	
//		for(int i=0;i<l;i++) {
//			int a = stdIn.nextInt();
//			char b = stdIn.next().charAt(0);
//			hm.put(a,b);
// 		}
//		solve(n);
//	}
//	static void print(int n) {
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.printf("%d ", map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
//	static void solve(int n) {
//		
//		int t = 0;
//		int x = 0;
//		int y = 0;
//		
//		map[x][y] = 1;
//		int[] dx = {0,-1,0,1};
//		int[] dy = {1,0,-1,0};
//		int dir = 0;
//		
//		sn.add(new Snake(0,0));
//
//		// L -> +1
//		// R -> -1
//		while(true) {
//			if(hm.containsKey(t)) {
//				if(hm.get(t) == 'L') {
//					dir ++;
//					if(dir == 4) dir = 0;
//				}else {
//					dir --;
//					if(dir == -1) dir = 3;
//				}
//			}
//			t++;
//			x += dx[dir];
//			y += dy[dir];
//			
//			if(x < 0 ||y<0 || x>=n || y>=n) {
//				System.out.println(t);
//				return;
//			}
//			if(map[x][y] == 1) {
//				System.out.println(t);
//				return;
//			}
//			
//			if(map[x][y] == 2) { // 사과 
//				map[x][y] = 1;
//				sn.addFirst(new Snake(x,y));
//			}
//			else { // 빈 공간 
//				map[x][y] = 1;
//				sn.addFirst(new Snake(x,y));
//				Snake tail = sn.removeLast();
//				map[tail.x][tail.y] = 0;
//				// 꼬리가 0 
//			}
//		}	
//	}
//}
//class Snake{
//	int x;
//	int y;
//	Snake(int x, int y){
//		this.x= x;
//		this.y =y ;
//	}
//}
//public class BJ3190{
//	static int[][] map;
//	static int[][] visited;
//	static int[] dx = {-1,0,1,0}; // 시계 
//	static int[] dy = {0,1,0,-1};
//	static HashMap<Integer, Character> hm = new HashMap<Integer, Character>();
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int n = stdIn.nextInt();
//		int k = stdIn.nextInt();
//		map = new int[n][n];
//		visited = new int[n][n];
//		for(int i=0;i<k;i++) {
//			int r = stdIn.nextInt()-1;
//			int c = stdIn.nextInt()-1;
//			map[r][c] = 2; // 사과  
//		}
//		int t = stdIn.nextInt();
//		for(int i=0;i<t;i++) {
//			int time = stdIn.nextInt();
//			char order = stdIn.next().charAt(0);
//			hm.put(time, order);
//		}
//		for(int i=0;i<n;i++) Arrays.fill(visited[i], -1);
//		solve(n,k);
//	}
//	static void solve(int n, int k) {
//		int t = 0;
//		int x = 0;
//		int y = 0;
//		int dir = 1;
//		int len = 1;
//		visited[x][y] = 0;
//		while(true) {
//			t++;
//			x = x + dx[dir];
//			y = y + dy[dir];
//	
//			if(x<0 || y <0 || x >= n || y >= n) {
//				// 벽 
//				System.out.println(t);
//				return;
//			}
//			if(visited[x][y] != -1 && t-len <= visited[x][y]) {
//				// 지 몸통 
//				System.out.println(t);
//				return;
//			}
//			if(map[x][y] == 2) { // 사과 
//				map[x][y] = 0;
//				len++;
//			}
//			visited[x][y] = t;
//			if(hm.containsKey(t)) {
//				char nextDir = hm.get(t);
//				if(nextDir == 'L') { // 반시계 
//					dir = (dir + 3)%4;
//				}else{ // 시계 
//					dir = (dir + 1)%4;
//				}
//			}
//		}
//	}
//	static void print(int n) {
//	for(int i=0;i<n;i++) {
//		for(int j=0;j<n;j++) {
//			System.out.printf("%2d ", visited[i][j]);
//		}
//		System.out.println();
//	}
//	System.out.println();
//}
//}

//import java.util.ArrayDeque;
//import java.util.HashMap;
//import java.util.Scanner;
//public class BJ3190{
//	static int[][] map;
//	static HashMap<Integer, Character> hm = new HashMap<Integer, Character>();
//	static int[] dx = {-1,0,1,0};
//	static int[] dy = {0,1,0,-1};
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int n = stdIn.nextInt();
//		map = new int[n][n];
//		int k= stdIn.nextInt();
//		for(int i=0;i<k;i++) {
//			int x = stdIn.nextInt()-1;
//			int y = stdIn.nextInt()-1;
//			map[x][y] = 2;
//		}
//		int l = stdIn.nextInt();
//		for(int i=0;i<l;i++) {
//			int t = stdIn.nextInt();
//			char c = stdIn.next().charAt(0);
//			hm.put(t, c);
//		}
//		
//		ArrayDeque<Snake> snake = new ArrayDeque<Snake>();
//		snake.add(new Snake(0,0));
//		int t = 0;
//		int x = 0;
//		int y = 0;
//		map[x][y] = 1;
//		int dir = 1;
//		while(true) {
////			print(map,n);
////			System.out.println();
//			if(hm.containsKey(t)) {
//				char c = hm.get(t);
//				if(c == 'L') {
//					dir = (dir+3)%4;
//				}else {
//					dir = (dir+1)%4;
//				}
//			}
//			t++;
//			
//			int nx = x+dx[dir];
//			int ny = y+dy[dir];
//			
//			if(nx < 0 || ny <0 || nx >= n || ny>= n) break;
//			if(map[nx][ny] == 1) break;
//			
//			if(map[nx][ny]==0) { // 빈칸 
//				Snake tail = snake.removeLast();
//				int tx = tail.x;
//				int ty = tail.y;
//				snake.addFirst(new Snake(nx,ny));
//				map[nx][ny] = 1; // 대가리 추가 
//				map[tx][ty] = 0;
//			}else { // 사과 
//				map[nx][ny] = 1;
//				snake.addFirst(new Snake(nx,ny));
//			}
//			x = nx;
//			y = ny;
//		}
//		System.out.println(t);
//	}
//	static void print(int[][] map, int n) {
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.printf("%d ", map[i][j]);
//			}
//			System.out.println();
//		}
//	}
//}
//class Snake{
//	int x;
//	int y;
//	Snake(int x, int y){
//		this.x = x;
//		this.y = y;
//	}
//}


import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class BJ3190{
	static int[][] map;
	static int[][] visited;
	static HashMap<Integer, Character> hm = new HashMap<Integer, Character>();
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		map = new int[n][n];
		visited = new int[n][n];
		int k= stdIn.nextInt();
		for(int i=0;i<k;i++) {
			int x = stdIn.nextInt()-1;
			int y = stdIn.nextInt()-1;
			map[x][y] = 2;
		}
		int l = stdIn.nextInt();
		for(int i=0;i<l;i++) {
			int t = stdIn.nextInt();
			char c = stdIn.next().charAt(0);
			hm.put(t, c);
		}
		
		for(int i=0;i<n;i++) Arrays.fill(visited[i], -1);
		
		int t = 0;
		int x = 0;
		int y = 0;
		int dir = 1;
		int len = 1;
		visited[x][y] = 0;
		while(true) {
//			print(visited,n);
//			System.out.println();
			if(hm.containsKey(t)) {
				char c = hm.get(t);
				if(c == 'L') {
					dir = (dir+3)%4;
				}else {
					dir = (dir+1)%4;
				}
			}
			t++;
			
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			
			if(nx < 0 || ny < 0 || nx >= n || ny >= n) break;
			
			if(visited[nx][ny] >= visited[x][y] - (len - 1)) {
				break;
			}
			
			if(map[nx][ny]==0) { // 빈칸 
				visited[nx][ny] = t;
			}else{ // 사과 
				visited[nx][ny] = t;
				len++;
				map[nx][ny] = 0;
			}
			x = nx;
			y = ny;
		}
		System.out.println(t);
	}
	static void print(int[][] map, int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.printf("%2d ", map[i][j]);
			}
			System.out.println();
		}
	}
}
class Snake{
	int x;
	int y;
	Snake(int x, int y){
		this.x = x;
		this.y = y;
	}
}
