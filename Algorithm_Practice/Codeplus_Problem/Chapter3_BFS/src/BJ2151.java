// 2151번
// 거울 설치 
// BFS 

//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//public class BJ2151 {
//	static char[][] map;
//	static int[][] visited;
//	static final int[] dx = {1,-1,0,0};
//	static final int[] dy = {0,0,-1,1};
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int n = stdIn.nextInt();
//		map = new char[n][n];
//		visited = new int[n][n];
//		stdIn.nextLine();
//		for(int i=0;i<n;i++) {
//			String s = stdIn.nextLine();
//			for(int j=0;j<n;j++) {
//				map[i][j] = s.charAt(j);
//			}
//		}
//		solve(n);
//	}
//	static void solve(int n) {
//		Queue<XY> q= new LinkedList<XY>();
//		boolean flag = false;
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				if(map[i][j] == '#') {
//					q.add(new XY(i,j,0));
//					visited[i][j] = 1;
//					flag = true;
//					break;
//				}
//			}
//			if(flag == true)break;
//		}
//		
//		
//		while(!q.isEmpty()) {
//			XY h = q.remove();
//			int x = h.x;
//			int y = h.y;
//			int m = h.m;
//			for(int i=0;i<4;i++) {
//				int nx = x + dx[i];
//				int ny = y + dy[i];
//				while(nx >=0 && ny >=0 && nx < n && ny < n && map[nx][ny] != '*') {
//					
//					if(map[nx][ny] == '#' && visited[nx][ny] == 0) {
//						System.out.println(m);
//						return;
//					}
//					if(map[nx][ny] == '!' && visited[nx][ny] == 0) {
//						q.add(new XY(nx,ny,m+1));
//						visited[nx][ny] = 1;
//					}
//					nx += dx[i];
//					ny += dy[i];
//				}
//			}
//
//		}	
//	}
//}
//class XY{
//	int x;
//	int y;
//	int m;
//	XY(int x, int y, int m){
//		this.x = x;
//		this.y = y;
//		this.m = m;
//	}
//}

//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//public class BJ2151{
//	static char[][] map;
//	static int[][] visited;
//	static int[] dx = {-1,0,1,0};
//	static int[] dy = {0,1,0,-1};
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int n = stdIn.nextInt();
//		map = new char[n][n];
//		visited = new int[n][n];
//		stdIn.nextLine();
//		for(int i=0;i<n;i++) {
//			String s = stdIn.nextLine();
//			for(int j=0;j<n;j++) {
//				map[i][j] = s.charAt(j);
//			}
//		}
//		
//		Queue<PP> q= new LinkedList<PP>();
//		
//		int cnt = 0;
//		int mx = 0;
//		int my = 0;
//		boolean flag = false;
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				if(map[i][j] == '#' && cnt == 0) {
//					q.add(new PP(i,j));
//					visited[i][j] = 1;
//					cnt++;
//				}
//				if(map[i][j] == '#' && cnt == 1) {
//					mx = i;
//					my = j;
//				}
//			}
//		}
//		
//		while(!q.isEmpty()) {
//			PP h = q.remove();
//			int x = h.x;
//			int y = h.y;
//			for(int i=0;i<4;i++) {
//				int nx = x + dx[i];
//				int ny = y + dy[i];
//				while(nx >= 0 && ny >=0 && nx < n && ny < n && map[nx][ny] != '*') {
//					if(map[nx][ny] == '!' && visited[nx][ny] == 0) {
//						q.add(new PP(nx,ny));
//						visited[nx][ny] = 1 + visited[x][y];
//					}
//					if(map[nx][ny] == '#' && visited[nx][ny] == 0) {
//						q.add(new PP(nx,ny));
//						visited[nx][ny] = visited[x][y];
//					}
//					nx += dx[i];
//					ny += dy[i];
//				}
//			}
//		}
//		System.out.println(visited[mx][my] - 1);
//	}
//}
//class PP{
//	int x;
//	int y;
//	PP(int x, int y){
//		this.x = x;
//		this.y = y;
//	}
//}


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ2151{
	static char[][] map;
	static int[][] num;
	static int[] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static  ArrayList<PPP> al = new ArrayList<PPP>();
	public static void main(String[] args) {
		Scanner stdIn= new Scanner (System.in);
		int n = stdIn.nextInt();
		map = new char[n][n];
		num = new int[n][n];
		stdIn.nextLine();
		int dx1 = 0;
		int dy1 = 0;
		int dx2 = 0;
		int dy2 = 0;
		int cnt = 0;
		al.add(new PPP(0,0));
		for(int i=0;i<n;i++) {
			String s = stdIn.nextLine();
			for(int j=0;j<n;j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == '#') {
					if(cnt == 0) {
						dx1 = i;
						dy1 = j;
						cnt ++;
					}else {
						dx2 = i;
						dy2 = j;
					}
				}
				else if(map[i][j] == '!') {
					al.add(new PPP(i,j));
					num[i][j] = al.size()-1;
				}
			}
		}
		al.set(0, new PPP(dx1,dy1));
		num[dx1][dy1] = 0;
		al.add(new PPP(dx2, dy2));
		num[dx2][dy2] = al.size()-1;
		
		int[][] adj = new int[al.size()][al.size()];
		for(int i=0;i<al.size();i++) {
			int x = al.get(i).x;
			int y = al.get(i).y;
			for(int k=0;k<4;k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				while(nx >=0 && ny >=0 && nx < n && ny < n && map[nx][ny] != '*') {
					if(map[nx][ny] == '!' || map[nx][ny] == '#') {
						adj[i][num[nx][ny]] = 1;
						adj[num[nx][ny]][i] = 1;
					}
					nx += dx[k];
					ny += dy[k];
				}
			}
		}
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.printf("%d ", num[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for(int i=0;i<al.size();i++) {
//			for(int j=0;j<al.size();j++) {
//				System.out.printf("%d ", adj[i][j]);
//			}
//			System.out.println();
//		}
		visited = new int[al.size()];
		Queue<Integer> q= new LinkedList<Integer>();
		q.add(0);
		visited[0] = 1;
		while(!q.isEmpty()) {
			int h = q.remove();
			for(int i=0;i<al.size();i++) {
				if(adj[h][i] == 1 && visited[i] == 0) {
					q.add(i);
					visited[i] = visited[h] + 1;
				}
			}
		}
		System.out.println(visited[al.size()-1] - 2);
	}
}
class PPP{
	int x;
	int y;
	PPP(int x, int y){
		this.x = x;
		this.y = y;
	}
}