// 삼성 기출 
// 16236번
// 아기 상어 
// 상어가 물고기를 먹으면 위치 갱신 후 다시 bfs.. (visited 초기화 )

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//public class BJ16236 {
//	static int[][] map;
//	static int[][] visited;
//	static final int[] dx = {-1,0,1,0};
//	static final int[] dy = {0,1,0,-1};
//	static int time = 0;
//	public static void main(String[] args) {
//		Scanner stdIn= new Scanner(System.in);
//		int n = stdIn.nextInt();
//		map = new int[n][n];
//		int sx = 0;
//		int sy = 0;
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				map[i][j] = stdIn.nextInt();
//				if(map[i][j] == 9) {
//					sx = i;
//					sy = j;
//					map[i][j] = 0;
//				}
//			}
//		}
//		int scale = 2;
//		int cnt = 0;
//		while(true) {
//			Shark s = bfs(sx,sy,scale,n);
//			if(s!=null) {
//				cnt++;
//				sx = s.x;
//				sy = s.y;
//			}else {
//				break;
//			}
//			if(cnt == scale) {
//				cnt = 0;
//				scale++;
//			}
//		}
//		System.out.println(time);
//	}
//	static Shark bfs(int sx, int sy, int scale, int n) {
//		visited = new int[n][n];
//		Queue<Shark> q = new LinkedList<Shark>();
//		q.add(new Shark(sx,sy,n));
//		visited[sx][sy] = 1;
//		int minDist = Integer.MAX_VALUE;
//		ArrayList<Integer> eatable = new ArrayList<Integer>();
//		ArrayList<Shark> test = new ArrayList<Shark>();
//		while(!q.isEmpty()) {
//			Shark h = q.remove();
//			int x = h.x;
//			int y = h.y;
//			if(minDist < visited[x][y]) break;
//			if(map[x][y] > 0 && scale > map[x][y]) { // 먹을 수 있는 경우 .. 
//				minDist = visited[x][y];
//				eatable.add(x*n+y); // 왼쪽 위 기준.. 
//				test.add(new Shark(x,y,n));
//			}
//			for(int i=0;i<4;i++) {
//				int nx = x + dx[i];
//				int ny = y + dy[i];
//				if(nx>=0 && ny>=0 && nx<n && ny<n) {
//					if(visited[nx][ny] == 0) {
//						if(scale >= map[nx][ny]) { 
//							q.add(new Shark(nx,ny,n));
//							visited[nx][ny] = visited[x][y] +1;
//						}
//					}
//				}
//			}	
//		}
//		if(eatable.size() == 0) return null;
//		if(test.size() == 0) return null;
//		Collections.sort(test);
//		Collections.sort(eatable);
//		int x = test.get(0).x;
//		int y = test.get(0).y;
////		int x = eatable.get(0)/n;
////		int y = eatable.get(0)%n;
//		time += visited[x][y]-1;
//		map[x][y] = 0;
//		return new Shark(x,y,n);
//	}
//}
//class Shark implements Comparable<Shark>{
//	int x;
//	int y;
//	int n;
//	Shark(int x, int y, int n){
//		this.x = x;
//		this.y = y;
//		this. n = n;
//	}
//	public int compareTo(Shark o) {
//		// 내가 더 크면 1 (오름차순 기준)
//		return this.x*n+y > o.x * n + o.y ? 1 : -1;
//	}
//}

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ16236{
	static int[][] map;
	static int[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int n;
	static int time;
 	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		n = stdIn.nextInt(); // 가로, 세로 길이 
		map = new int[n][n]; // 지도 
		visited = new int[n][n]; 
		
		// 상어 위치 
		int sx = 0;
		int sy = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = stdIn.nextInt();
				if(map[i][j] == 9) {
					sx = i;
					sy = j;
					map[i][j] = 0;
				}
			}
		}
		int size = 2;
		int cnt = 0;
		while(true) {
			Shark s = bfs(sx,sy,size);
			if(s == null) {
				System.out.println(time);
				return;
			}else { // 한마리 시식 완료 
				sx = s.x;
				sy = s.y;
				cnt++;
				if(cnt == size) {
					size++;
					cnt = 0;
				}
			}
		}
	}
 	// null을 반환하지 않으면 한마리 시식 완료 
 	static Shark bfs(int sx, int sy, int size) {
 		visited = new int[n][n];
 		Queue<Shark> q = new LinkedList<Shark>();
		q.add(new Shark(sx,sy));
		visited[sx][sy] = 1;
		ArrayList<Integer> closest = new ArrayList<Integer>();
		int bound = Integer.MAX_VALUE; // 허용 거리 .. 
		while(!q.isEmpty()) {
			Shark h = q.remove();
			int x = h.x;
			int y = h.y;
			// 먹을 수 있음 
			if(map[x][y] < size && map[x][y] != 0) {
				// 바운드 조정됨.. 앞으로 같은 거리까지만 반복문이 돔. 
				if(bound >= visited[x][y]) {
					bound = visited[x][y];
					closest.add(x*n+y);
				}
			}
			if(bound  <  visited[x][y]) { 
				break;
			}
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >=0 && ny >=0 && nx < n && ny < n) {
					if(visited[nx][ny] == 0 && map[nx][ny] <= size) {
						q.add(new Shark(nx,ny));
						visited[nx][ny] = visited[x][y] + 1;
					}
				}
			}
		}
		if(closest.size() == 0) return null;
		Collections.sort(closest);
		int nx = closest.get(0)/n;
		int ny = closest.get(0)%n;
		map[nx][ny] = 0;
		time += visited[nx][ny]-1;
		return new Shark(closest.get(0)/n, closest.get(0)%n);
 	}
}
class Shark{
	int x;
	int y;
	Shark(int x, int y){
		this.x = x;
		this.y = y;
	}
}