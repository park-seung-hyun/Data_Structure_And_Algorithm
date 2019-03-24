// 2206번 
// 벽 부수고 이동하기 
// 어려움...
// 큐에서 add, offer 차이 
// -> add는 add가 불가할 경우 예외를 던지고, offer은 던지지 않음. 

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pair{
	int x,y,z;
	Pair(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
public class BJ2206 {
	static int[][] room;
	static int[][][] visited;
	
	static final int[] dx = {0,0,-1,1};
	static final int[] dy = {-1,1,0,0};
	
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int m = stdIn.nextInt();
		room = new int[n][m];
		visited = new int[n][m][2];

		stdIn.nextLine();
		
		for(int i=0;i<n;i++) {
			String s = stdIn.nextLine();
			for(int j=0;j<m;j++) {
				room[i][j] = s.charAt(j) - '0';
			}
		}
		
		bfs(n,m);
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.printf("%d ",visited[i][j][0] );
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.printf("%d ",visited[i][j][1] );
//			}
//			System.out.println();
//		}
		
		if(visited[n-1][m-1][0] != 0 && visited[n-1][m-1][1] != 0) {
			System.out.println(Math.min(visited[n-1][m-1][0], visited[n-1][m-1][1]));
		}else if(visited[n-1][m-1][0] != 0) {
			System.out.println(visited[n-1][m-1][0]);
		}else if(visited[n-1][m-1][1] != 0) {
			System.out.println(visited[n-1][m-1][1]);
		}else {
			System.out.println(-1);
		}
	}
	static void bfs(int n,int m) {
		
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(0,0,0));
		
		visited[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			Pair p = q.remove();
			
			int x = p.x;
			int y = p.y;
			int z = p.z;
			
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny < m) {
					if(room[nx][ny] == 0 && visited[nx][ny][z] == 0 ) {
						visited[nx][ny][z] = visited[x][y][z] +1;
						q.add(new Pair(nx,ny,z));
					}
					if(z == 0 && room[nx][ny] == 1 && visited[nx][ny][z+1] == 0) {
						visited[nx][ny][z+1] = visited[x][y][z] + 1;
						q.add(new Pair(nx,ny,z+1));
					}
					
				}
			}
		}
	}
}
//public class BJ2206{
//	static int[][] map;
//	static int[][][] visited;
//	static final int[] dx = {0,0,-1,1};
//	static final int[] dy = {1,-1,0,0};
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		int n = stdIn.nextInt();
//		int m =stdIn.nextInt();
//		map = new int[n][m];
//		visited = new int[n][m][2];
//		stdIn.nextLine();
//		for(int i=0;i<n;i++) {
//			String s= stdIn.nextLine();
//			for(int j=0;j<m;j++) {
//				map[i][j] = s.charAt(j) - '0'; 
//			}
//		}
//		solve(n,m);
//	}
//	static void solve(int n,int m) {
//		Queue<Dot> q = new LinkedList<Dot>();
//		q.add(new Dot(0,0,false));
//		visited[0][0][0] = 1;
//		while(!q.isEmpty()) {
//			Dot h = q.remove();
//			int x = h.x;
//			int y = h.y;
//			boolean b = h.b;
//			for(int i=0;i<4;i++) {
//				int nx = x+dx[i];
//				int ny = y+dy[i];
//				if(nx>=0 &&  ny>=0 && nx < n&& ny <m) {
//					if(b==false) { // 현재 상태 벽 뿌신적 없는 경우 
//						
//						// 다음 방이 빈칸인 경우 
//						if((visited[nx][ny][0] == 0) && map[nx][ny] == 0) {
//							visited[nx][ny][0] = visited[x][y][0] + 1;
//							q.add(new Dot(nx,ny,false));
//						}
//						// 다음 방이 벽인 경우 
//						if((visited[nx][ny][1] == 0) && map[nx][ny] == 1) {
//							visited[nx][ny][1] = visited[x][y][0] + 1;
//							q.add(new Dot(nx,ny,true));
//						}
//						
//					}else { // 벽 뿌신적 있는 경우 
//						
//						if((visited[nx][ny][1] == 0) && map[nx][ny] == 0) {
//							visited[nx][ny][1] = visited[x][y][1] + 1;
//							q.add(new Dot(nx,ny,true));
//						}
//					}
//				}
//			}
//					
//		}
//		int ans1 = (visited[n-1][m-1][0] == 0 ? Integer.MAX_VALUE : visited[n-1][m-1][0]);
//		int ans2 = (visited[n-1][m-1][1] == 0 ? Integer.MAX_VALUE : visited[n-1][m-1][1]);
//		int ans  =  ans1;
//		if(ans > ans2) ans = ans2;
//		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
//	}
//}
//class Dot{
//	int x;
//	int y;
//	boolean b;
//	Dot(int x, int y, boolean b){
//		this.x = x;
//		this.y =y;
//		this.b = b;
//		
//	}
//	
//}
