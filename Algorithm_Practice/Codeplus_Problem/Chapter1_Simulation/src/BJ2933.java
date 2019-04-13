// 2933번
// 미네랄  
// 시뮬레이션 

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//public class BJ2933 {
//	static char[][] map;
//	static int[] stick;
//	static int[][] visited;
//	static int[] dx = {1,-1,0,0};
//	static int[] dy = {0,0,1,-1};
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int r = stdIn.nextInt();
//		int c = stdIn.nextInt();
//		map = new char[r][c];
//		stdIn.nextLine();
//		for(int i=0;i<r;i++) {
//			String s = stdIn.nextLine();
//			for(int j=0;j<c;j++) {
//				map[i][j] = s.charAt(j);
//			}
//		}
//		int t = stdIn.nextInt();
//		stick = new int[t];
//		for(int i=0;i<t;i++) stick[i] = stdIn.nextInt();
//		
//		solve(t,r,c);
//	}
//	static void solve(int t, int r, int c) {
//		int cnt = 0;
//		while(cnt<t) {
//			throwStick(cnt,r,c);
//			afterThrowStick(r,c);
//			cnt++;
//		}
//		print(r,c);
//	}
//	static void print(int r, int c) {
//		for(int i=0;i<r;i++) {
//			for(int j=0;j<c;j++) {
//				System.out.printf("%c",map[i][j]);
//			}
//			System.out.println();
//		}
//	}
//	static void throwStick(int cnt, int r, int c) {
//		if(cnt%2 == 0) { // l->
//			for(int i=0;i<c;i++) {
//				if(map[r-stick[cnt]][i] == 'x') {
//					map[r-stick[cnt]][i] = '.';
//					break;
//				}
//			}
//		}else { // <-r
//			for(int i=c-1;i>=0;i--) {
//				if(map[r-stick[cnt]][i] == 'x') {
//					map[r-stick[cnt]][i] = '.';
//					break;
//				}
//			}
//		}		
//	}
//	static void afterThrowStick(int r, int c) {
//		visited = new int[r][c];
//		for(int i=0;i<r;i++) {
//			for(int j=0;j<c;j++) {
//				if(visited[i][j] == 0 && map[i][j] == 'x') {
//					if(bfs(i,j,r,c)) return;
//				}
//			}
//		}	
//
//	}
//	static boolean bfs(int i, int j, int r, int c) {
//		Queue<Pos> q = new LinkedList<Pos>();
//		q.add(new Pos(i,j));
//		visited[i][j] = 1;
//		int maxX = 0;
//		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
//		ArrayList<Integer> al = new ArrayList<Integer>();
//		while(!q.isEmpty()) {
//			Pos h = q.remove();
//			int x = h.x;
//			int y = h.y;
//			if(hm.containsKey(y)) {
//				if(hm.get(y) < x) hm.replace(y, x);
//			}else {
//				hm.put(y, x);
//			}
//			al.add(x*c+y);
//			if(x > maxX) maxX = x;
//			for(int k=0;k<4;k++) {
//				int nx = x+ dx[k];
//				int ny = y+ dy[k];
//				if(nx>=0 && ny>=0 && nx<r && ny<c) {
//					if(visited[nx][ny] == 0 && map[nx][ny] == 'x') {
//						q.add(new Pos(nx,ny));
//						visited[nx][ny] = 1;
//					}
//				}
//			}
//		}
//		if(maxX != r-1) {
//			fall(hm,al,r,c);
//			return true;
//		}
//		return false;
//	}
//	// 얼마나 떨어질지 찾는 함수
//	
//	// 해쉬 맵을 통해 연결 요소 중 가장 아래에 있는 미네랄을 구함. 
//	// 또 다른 풀이로 low 배열을 선언함. 
//	static void fall(HashMap<Integer, Integer>hm,ArrayList<Integer> al, int r, int c){
//
//		int[] low = new int[c];
//		Arrays.fill(low, -1);
//		
//		for(int  n : al) {
//			int x = n/c;
//			int y = n%c;
//			low[y] = Math.max(low[y], x);
//			map[x][y] = '.';
//		}
//		int fallHeight = r-1;
//		
//		for(int i=0;i<c;i++) {
//			if(low[i] == -1 ) continue;
//			for(int j=1;j+low[i] < r;j++) {
//				if(map[low[i] + j][i] == 'x') {
//					if(fallHeight > j-1) fallHeight = j-1;
//					break;
//				}
//			}
//		}
//		for(int p : al) {
//			int x = p/c;
//			int y = p%c;
//			map[x+fallHeight][y] = 'x';
//		}
//		
//		
////		for(int k: hm.keySet()){
////			int x = hm.get(k);
////			int y = k;
////			boolean flag = true;
////			for(int i=1;i+x<r;i++) {
////				if(map[i+x][y] == 'x') {
////					if(fallHeight > i-1) fallHeight = i-1;
////					flag = false;
////					break;
////				}
////			}
////			if(flag == true) {
////				if(fallHeight > r-x-1)
////					fallHeight = r-x-1;
////			}
////		}
////		
////		for(int p : al) {
////			int x = p/c;
////			int y = p%c;
////			map[x][y] = '.';
////		}
////		for(int p : al) {
////			int x = p/c;
////			int y = p%c;
////			map[x+fallHeight][y] = 'x';
////		}
//	}
//}
//class Pos{
//	int x;
//	int y;
//	Pos(int x, int y){
//		this.x = x;
//		this.y = y;
//	}
//}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ2933{
	static char[][] map;
	static int[][] visited;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int r = stdIn.nextInt();
		int c = stdIn.nextInt();
		map = new char[r][c];
		stdIn.nextLine();
		for(int i=0;i<r;i++) {
			String s = stdIn.nextLine();
			for(int j=0;j<c;j++) {
				map[i][j] = s.charAt(j);
				
			}
		}
		int n = stdIn.nextInt();
		for(int i=0;i<n;i++) {
			int o = stdIn.nextInt();
			simulate(o,i%2,r,c);
			check(r,c);
		}
		print(r,c);
		
		
	}
	static void print(int r, int c) {
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.printf("%c", map[i][j]);
			}
			System.out.println();
		}
	}
	static void check(int r, int c) {
		visited = new int[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j] == 'x' && visited[i][j] == 0) {
					if(bfs(i,j,r,c)) return;
				}
			}
		}
	}
	static boolean bfs(int x, int y, int r, int c) {
		final int[] dx = {-1,0,1,0};
		final int[] dy = {0,1,0,-1};
		Queue<Po> q= new LinkedList<Po>();
		q.add(new Po(x,y));
		visited[x][y] = 1;
		int minX = 0;
		ArrayList<Po> al = new ArrayList<Po>();
		while(!q.isEmpty()) {
			Po h = q.remove();
			al.add(h);
			x = h.x;
			y = h.y;
			if(x > minX) minX = x; 
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny>=0 && nx < r&& ny < c) {
					if(visited[nx][ny] == 0 && map[nx][ny] == 'x') {
						q.add(new Po(nx,ny));
						visited[nx][ny] = 1;
					}
				}
			}
		}
		if(minX != r-1) {
			falling(r,c,al);
			return true;
		}else {
			return false;
		}
		
	}
	static void falling(int r, int c, ArrayList<Po> al) {
		int[] check = new int[c];
		Arrays.fill(check, -1);
		for(Po p : al) {
			int x = p.x;
			int y = p.y;
			map[x][y] = '.';
			if(check[y] < x) check[y] = x;
		}
		
		int minF = r;
		
		for(int i=0;i<c;i++) {
			if(check[i] != -1) {
				int cnt = 0;
				for(int j=check[i]+1;j<r;j++) {
					if(map[j][i] == '.') {
						cnt++;
					}else {
						break;
					}
				}
				if(minF > cnt) minF = cnt;
			}
		}
//		System.out.println(minF);
		for(Po p : al) {
			int x = p.x + minF;
			int y = p.y;
			map[x][y] = 'x';
		}

		
	}
	static void simulate(int o, int w, int r, int c) {
		if(w==0) {
			for(int i=0;i<c;i++) {
				if(map[r-o][i] == 'x') {
					map[r-o][i] = '.';
					return;
				}
			}
		}else {
			for(int i=c-1;i>=0;i--) {
				if(map[r-o][i] == 'x') {
					map[r-o][i] = '.';
					return;
				}
			}
		}
	}
}
class Po{
	int x;
	int y;
	Po(int x, int y){
		this.x =x;
		this.y =y ;
	}
}