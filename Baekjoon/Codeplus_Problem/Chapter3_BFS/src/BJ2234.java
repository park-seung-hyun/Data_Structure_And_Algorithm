// 2234번
// 성곽 
// BFS 

//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//public class BJ2234 {
//	static Room[][] map;
//	static int[][] visited;
//	static final int[] dx = {1,-1,0,0};
//	static final int[] dy = {0,0,1,-1};
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int h = stdIn.nextInt();
//		int w = stdIn.nextInt();
//		map = new Room[w][h];
//		visited = new int[w][h];
//		for(int i=0;i<w;i++) {
//			for(int j=0;j<h;j++) {
//				int n = stdIn.nextInt();
//				getWall(i,j,n);
//			}
//		}
//		solve(w,h);
//	}
//	static void solve(int w, int h) {
//		int ans = 1;
//		int ans2 = 0;
//		ArrayList<Integer> al = new ArrayList<Integer>();
//		al.add(-1);
//		for(int i=0;i<w;i++) {
//			for(int j=0;j<h;j++) {
//				if(visited[i][j] == 0) {
//					int temp = bfs(i,j,ans,w,h);
//					al.add(temp);
//					if(ans2 < temp) ans2 = temp;
//					ans++;
//				}
//			}
//		}
//		System.out.println(ans-1);
//		System.out.println(ans2);
//		System.out.println(getAns3(w, h, al));
//	}
//	static int getAns3(int w, int h, ArrayList<Integer> al) {
//		int max = 0;
//		for(int i=0;i<w;i++) {
//			for(int j=0;j<h;j++) {
//				for(int k=0;k<4;k++) {
//					int nx = i + dx[k];
//					int ny = j + dy[k];
//					if(nx>=0 && ny>=0 && nx <w && ny < h) {
//						if(visited[nx][ny] != visited[i][j]) {
//							if(max < al.get(visited[nx][ny]) + al.get(visited[i][j])) {
//								max = al.get(visited[nx][ny]) + al.get(visited[i][j]);
//							}
//						}
//						
//					}
//				}
//			}
//		}
//		return max;
//		
//	}
//	static void printMap(int w, int h) {
//		for(int i=0;i<w;i++) {
//			for(int j=0;j<h;j++) {
//				System.out.printf("%d ", visited[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
//	static void getWall(int i, int j, int num) {
//		int w = 0;
//		int e = 0;
//		int s = 0;
//		int n = 0;
//		if(num >= 8) {
//			num -= 8;
//			s = 1;
//		}
//		if(num >= 4) {
//			num -= 4;
//			e = 1;
//		}
//		if(num >= 2) {
//			num -=2;
//			n = 1;
//		}
//		if(num >= 1) {
//			num -=1;
//			w = 1;
//		}
////		System.out.printf("%d %d %d %d\n", s,e,n,w);
//		map[i][j] = new Room(w,e,n,s);
//	}
//	static int bfs(int i, int j, int cnt, int w, int h) {
//		Queue<P> q = new LinkedList<P>();
//		q.add(new P(i,j));
//		visited[i][j] = cnt;
//		
//		int count = 0;
//		while(!q.isEmpty()) {
//			P cur = q.remove();
//			count ++ ;
//			int x= cur.x;
//			int y = cur.y;
//			Room curRoom = map[x][y];
//			for(int k = 0;k<4;k++) {
//				int nx = x + dx[k];
//				int ny = y + dy[k];
//				
//				if(k == 0 && curRoom.s == 1) {
//					continue;
//				}
//				if(k == 1 && curRoom.n == 1) {
//					continue;
//				}
//				if(k == 2 && curRoom.e == 1) {
//					continue;
//				}
//				if(k == 3 && curRoom.w == 1) {
//					continue;
//				}
//				
//				if(nx>=0 && ny >=0 && nx < w && ny < h) {
//					if(visited[nx][ny] == 0) {
//						q.add(new P(nx,ny));
//						visited[nx][ny] = cnt;
//					}
//				}
//			}
//		}
//		return count;
//	}
//}
//class P{
//	int x;
//	int y;
//	P(int x, int y){
//		this.x = x;
//		this.y = y; 
//	}
//}
//class Room{
//	int w;
//	int e;
//	int n;
//	int s;
//	Room(int w, int e, int n, int s){
//		this.w = w;
//		this.e = e;
//		this.n = n;
//		this.s = s;
//	}
//}

import java.util.HashMap;
import java.util.Scanner;
public class BJ2234{
	static int[][] map;
	static int[][] visited;
	static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
	static final int[] dx = {0,-1,0,1};
	static final int[] dy = {-1,0,1,0};
	static int cnt =0;
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int m = stdIn.nextInt();
		int n = stdIn.nextInt();
		map = new int[n][m];
		visited = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = stdIn.nextInt();
			}
		}
		
		int ans1 = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(visited[i][j] == 0) {
					cnt = 0;
					dfs(i,j,n,m, ++ans1);
					hm.put(ans1, cnt);
				}
			}
		}
		System.out.println(ans1);
		int ans2 = 0;
		for(int k : hm.keySet()) {
			if(ans2 < hm.get(k)) ans2 = hm.get(k); 
		}
		System.out.println(ans2);
		
		int ans3 = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int room = hm.get(visited[i][j]);
				for(int k=0;k<4;k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if(nx >=0 && ny>=0 && nx < n && ny < m) {
						if(visited[i][j] == visited[nx][ny]) continue;
						if(ans3 < room + hm.get(visited[nx][ny]))
							ans3 = room + hm.get(visited[nx][ny]);
					}
				}
			}
		}
		System.out.println(ans3);
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.printf("%d ", visited[i][j]);
//			}
//			System.out.println();
//		}
	}
	static void dfs(int x, int y, int n, int m, int c) {
		visited[x][y] = c;
		cnt++;
		for(int i=0;i<4;i++) {
			if((map[x][y] & (1 << i)) != 0) continue;
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >=0 && ny >=0 && nx< n && ny < m) {
				if(visited[nx][ny] == 0) {
					dfs(nx,ny,n,m,c);
				}
			}
		}
	}
}