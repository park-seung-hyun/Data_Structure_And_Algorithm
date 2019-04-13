// 9328번 
// 열쇠 
// BFS
// solve -> 매번 키를 찾을때마다 visited를 초기화하여 다시 bfs 
// solve2 -> 큐 26개 선언하여 키가 생길 떄 원래 큐에 삽입. 
// 사실 wallet도 문자 배열로 선언하여 0~25에 0,1로 할 수 있음. 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ9328 {
	static char[][] map;
	static int[][] visited;
	
	static String key;
	static ArrayList<Character> wallet;
	
	static int ans = 0;
	static final int[] dx = {0,0,1,-1};
	static final int[] dy = {1,-1,0,0};
	static String Alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String alpha = "abcdefghijklmnopqrstuvwxyz";
	
	static Queue<Position>[] ql = (Queue<Position>[]) new LinkedList[26];
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int t = stdIn.nextInt();
		for(int k=0;k<t;k++) {
			int w= stdIn.nextInt();
			int h = stdIn.nextInt();
			map = new char[w+2][h+2];
			visited = new int[w+2][h+2];
			wallet = new ArrayList<Character>();
			ans = 0;
			for(int i=0;i<w+2;i++) {
				for(int j=0;j<h+2;j++) {
					map[i][j] = '.';
				}
			}
			stdIn.nextLine();
			for(int i=1;i<w+1;i++) {
				String s = stdIn.nextLine();
				for(int j=1;j<h+1;j++) {
					map[i][j] = s.charAt(j-1);
				}
			}
			
			key = stdIn.nextLine();
			if(!key.equals("0")) {
				for(int i=0;i<key.length();i++) {
					wallet.add(key.charAt(i));
				}
			}
//			solve(w,h);
			solve2(w,h);
		}
		
	}
	static void solve2(int w, int h) {
		
		for(int i=0;i<26;i++) 
			ql[i] = new LinkedList<Position>();
		
		Queue<Position> q = new LinkedList<Position>();		
		q.add(new Position(0,0));
		visited[0][0] = 1;
		
		while(!q.isEmpty()) {
			Position p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny >=0 && nx < w+2 && ny < h+2) {
					if(visited[nx][ny] == 0 && map[nx][ny] != '*') {
						
						if(map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') {							
							ql[map[nx][ny] - 'A'].add(new Position(nx,ny));
							visited[nx][ny] = 1;
							
							if(wallet.contains(Character.toLowerCase(map[nx][ny]))) {
								if(!ql[map[nx][ny] - 'A'].isEmpty()) {
									while(!ql[map[nx][ny] - 'A'].isEmpty()) {
										q.add(ql[map[nx][ny] - 'A'].remove());
									}
								}
							}
						}
						
						if(map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
							
							wallet.add(map[nx][ny]);
							q.add(new Position(nx, ny));
							visited[nx][ny] = 1;	
							
							if(!ql[map[nx][ny]  - 'a'].isEmpty()) {
								while(!ql[map[nx][ny]  - 'a'].isEmpty()) {
									q.add(ql[map[nx][ny]  - 'a'].remove());
								}
							}
						}
						
						if(map[nx][ny] == '.') {
							q.add(new Position(nx, ny));
							visited[nx][ny] = 1;
						}
						if(map[nx][ny] == '$') {
							ans++;
							map[nx][ny] = '.';
							q.add(new Position(nx, ny));
							visited[nx][ny] = 1;
						}
						
//						for(char c: wallet) {
//							if(!ql[c - 'a'].isEmpty()) {
//								while(!ql[c - 'a'].isEmpty()) {
//									q.add(ql[c - 'a'].remove());
//								}
//							}
//						}
					}
				}
			}
			
		}
		System.out.println(ans);
	}
	static void solve(int w, int h) {
		Queue<Position> q = new LinkedList<Position>();
		q.add(new Position(0,0));
		visited[0][0] = 1;
		
		while(!q.isEmpty()) {
			Position p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny >=0 && nx < w+2 && ny < h+2) {
					if(visited[nx][ny] == 0 && map[nx][ny] != '*') {
						
						if(Alpha.contains(map[nx][ny]+"") && wallet.contains(Character.toLowerCase(map[nx][ny]))){
							char c = Character.toLowerCase(map[nx][ny]);
	
							map[nx][ny] = '.';
							q.add(new Position(nx, ny));
							visited[nx][ny] = 1;
						}
						
						if(alpha.contains(map[nx][ny]+"")) {
							wallet.add(map[nx][ny]);
							map[nx][ny] = '.';
							visited = new int[w+2][h+2];
							q = new LinkedList<Position>();
							q.add(new Position(nx, ny));
							visited[nx][ny] = 1;
							
						}
						if(map[nx][ny] == '.') {
							q.add(new Position(nx, ny));
							visited[nx][ny] = 1;
						}
						if(map[nx][ny] == '$') {
							ans++;
							map[nx][ny] = '.';
							q.add(new Position(nx, ny));
							visited[nx][ny] = 1;
						}
						
					}
				}
			}
		}
		System.out.println(ans);
		
	}
}
class Position{
	int x;
	int y;
	Position(int x, int y){
		this.x = x;
		this.y = y;
	}
}

//public class BJ9328{
//	static char[][] map;
//	static int[][] visited;
//	static String key = "";
//	static int[] dx = {0,0,1,-1};
//	static int[] dy = {1,-1,0,0};
//	public static void main (String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int t = stdIn.nextInt();
//		for(int i=0;i<t;i++) {
//			int w = stdIn.nextInt();
//			int h = stdIn.nextInt();
//			map = new char[w+2][h+2];
//			visited = new int[w+2][h+2];
//			stdIn.nextLine();
//			for(int j=0;j<w+2;j++) {
//				for(int k=0;k<h+2;k++) {
//					map[j][k] = '.';
//				}
//			}
//			for(int j=1;j<=w;j++) {
//				String s = stdIn.nextLine();
//				for(int k=1;k<=h;k++) {
//					map[j][k] = s.charAt(k-1);
//				}
//			}
//			key = stdIn.nextLine();
//			if(key.equals("0")) key = "";
//			solve(w,h);
//		}
//	}
//	static void solve(int w, int h) {
//		
//		
//		ArrayList<Character> keyWallet = new ArrayList<Character>();
//		for(char c: key.toCharArray()) {
//			keyWallet.add(c);
//		}
//		
//		Queue<W2>[] qa = new LinkedList[26];
//		for(int i=0;i<26;i++) qa[i] = new LinkedList<W2>();
//		Queue<W2> q = new LinkedList<W2>();
//		q.add(new W2(0,0));
//		visited[0][0] = 1;
//		int Doc = 0;
//		while(!q.isEmpty()) {
//			
//			W2 r = q.remove();
//			int x = r.x;
//			int y = r.y;
//			for(int i=0;i<4;i++) {
//				int nx = x+ dx[i];
//				int ny = y+ dy[i];
//				
//				if(nx>=0 && ny>=0 && nx <w+2 && ny<h+2) {
//					
//					if(visited[nx][ny] == 0) {
//						if(map[nx][ny] == '.') {
//							q.add(new W2(nx,ny));
//							visited[nx][ny] = 1;
//						}
//						if(map[nx][ny] == '$') {
//							q.add(new W2(nx,ny));
//							visited[nx][ny] = 1;
//							Doc++;
//						}
//						if(map[nx][ny]>='a' && map[nx][ny]<='z') {
//							q.add(new W2(nx,ny));
//							visited[nx][ny] = 1;
//							keyWallet.add(map[nx][ny]);
//							while(!qa[map[nx][ny]-'a'].isEmpty()) {
//								q.add(qa[map[nx][ny]-'a'].remove());
//							}
//						}
//						if(map[nx][ny]>='A' && map[nx][ny]<='Z' ) {
//					
//							if(keyWallet.contains(Character.toLowerCase(map[nx][ny]))) {	
//								q.add(new W2(nx,ny));
//								visited[nx][ny] = 1;
//							}else {
//								qa[map[nx][ny] - 'A'].add(new W2(nx,ny));
//								visited[nx][ny] = 1;
//							}
//						}
//						
//					}
//				}
//			}
//			
//			
//			
//		}
//		System.out.println(Doc);
//
//	}
//}
//class W2{
//	int x;
//	int y;
//	W2(int x, int y){
//		this.x =x;
//		this.y =y;
//	}
//}