// 삼성 기출 
// 17135번
// 캐슬 디펜스 
// 못품.. 

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ17135 {
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,-1,0};
	static int[][] map;
	static int n;
	static int m;
	static int d;
	static int cnt;
	static int kill;
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		n = stdIn.nextInt();
		m = stdIn.nextInt();
		d = stdIn.nextInt();
		map = new int[n][m];
		
		int[][] tempMap = new int[n][m];
		int temp = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				tempMap[i][j] = stdIn.nextInt();
				if(tempMap[i][j]==1) { 
					temp++; // 총 적의 수 
				}
			}
		}
		
		int[] vow = new int[m];
		vow[0] = 1;
		vow[1] = 1;
		vow[2] = 1;
		int ans = 0;
		do {
			kill = 0;
			cnt = temp;
			for(int i=0;i<n;i++) {
				map[i] = tempMap[i].clone();
			}
			while(cnt > 0) {
				bfs(vow);
				simulate();
			}
			if(kill > ans) ans = kill;
		}while(np(vow));
		System.out.println(ans);
	}
	static void simulate() {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j] == 1) temp.add(i*m+j);
			}
		}
		for(int i: temp) {
			int x = i/m;
			int y = i%m;
			map[x][y] = 0;
		}
		for(int i: temp) {
			int x = i/m + 1;
			int y = i%m;
			if(x >= n) cnt--; // 성에 침범한 적 
			else map[x][y] = 1;
		}
	}
	static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.printf("%d ", map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	static void bfs(int[] vow) {
		Queue<Vow> q = new LinkedList<Vow>();
		int[][] visited= new int[m][n*m];
		for(int i=0;i<m;i++) {
			if(vow[i] == 1) {
				q.add(new Vow(n-1,i,i));
				visited[i][(n-1)*m+i] = 1;
			}
		}
		int[] v = new int[m];
		ArrayList<Integer> al = new ArrayList<Integer>();
		while(!q.isEmpty()) {
			Vow h = q.remove();
			int x = h.x;
			int y = h.y;
			int id = h.id;
			if(visited[id][x*m+y] > d) break;
			if(v[id] == 1) continue;
			if(map[x][y] == 1) {
//				System.out.println(x + " " + y);
//				print();
				al.add(x*m+y);
//				cnt--; // 잡은 놈들 
//				kill++;
//				map[x][y] = 0;
				v[id] = 1;
			}
			for(int j=0;j<4;j++) {
				int nx = x+dx[j];
				int ny =y+dy[j];
			
				if(nx>=0 && ny>=0 && nx <n && ny<m) {
					if(visited[id][nx*m+ny] == 0) {
						q.add(new Vow(nx,ny,id));
						visited[id][nx*m+ny] = visited[id][x*m+y] + 1;
					}
				}
			}
		}
		for(int i : al) {
			int x = i/m;
			int y = i%m;
			if(map[x][y] == 1) {
				map[x][y] = 0;
				cnt--; // 잡은 놈들 
				kill++;
			}
		}
		
//		ArrayList<Can>[] temp = (ArrayList<Can>[]) new ArrayList[d+1];
//		for(int i=0;i<=d;i++) temp[i] = new ArrayList<Can>();
//		for(int i=0;i<m;i++) {
////			ArrayList<Can> temp = new ArrayList<Can>();
//			if(vow[i] == 1) {
//				int vx = n-1;
//				int vy = i;
//				Queue<Integer> q= new LinkedList<Integer>();
//				int[] visited = new int[n*m];
//				q.add(vx*m+vy);
//				visited[vx*m+vy] = 1;
//				int bound = Integer.MAX_VALUE;
//				while(!q.isEmpty()) {
//					int h = q.remove();
//					int x = h/m;
//					int y = h%m;
//					if(visited[x*m+y] > d) break; // 사거리 안닿을 경우 
//					if(map[x][y] == 1) {
//						if(bound >= visited[x*m+y]) {
//							bound = visited[x*m+y];
////							temp.add(new Can(x,y,i));
//							temp[visited[x*m+y]].add(new Can(x,y,i));
//						}
//					}
//					for(int j=0;j<4;j++) {
//						int nx = x+dx[j];
//						int ny =y+dy[j];
//						if(nx>=0 && ny>=0 && nx <n && ny<m) {
//							if(visited[nx*m+ny] == 0) {
//								visited[nx*m+ny] = visited[x*m+y] + 1;
//								q.add(nx*m+ny);
//							}
//						}
//					}
//					
//				}
//			}
//			if(temp.isEmpty()) continue;
//			Collections.sort(temp);
//			int x = temp.get(0).x;
//			int y = temp.get(0).y;
//			cnt--; // 잡은 놈들 
//			kill++;
//			map[x][y] = 0;
//		}
//		int v = 3;
//		int[] vv = new int[m];
//		for(int i=0;i<=d;i++) {
//			if(v == 0) break;
//			Collections.sort(temp[i]);
//			for(Can c : temp[i]) {
//				int x = c.x;
//				int y = c.y;
//				int j = c.i;
//				if(vv[j]==0 && map[x][y] == 1) {
//					v--;
//					vv[j] =1;
//					cnt--; // 잡은 놈들 
//					kill++;
//					map[x][y] = 0;
//				}
//			}
//		}	
//		if(vow[1] == 1 && vow[2] == 1 && vow[3] == 1 )
//			System.out.println(kill);
	}
	static void swap(int[] ar, int id1, int id2) {
		int temp = ar[id1];
		ar[id1] = ar[id2];
		ar[id2] = temp;
	}
	static boolean np(int[] ar) {
		int n = ar.length;
		int i = n-1;
		while(i>0 && ar[i-1]<=ar[i])i--;
		if(i==0)return false;
		int j = n-1;
		while(ar[i-1]<=ar[j])j--;
		swap(ar,i-1,j);
		j = n-1;
		while(i<j) {
			swap(ar,i,j);
			i++;
			j--;
		}
		return true;
	}
}
class Can implements Comparable<Can>{
	int x;
	int y;
	int i;
	Can(int x, int y, int i){
		this.x = x;
		this.y = y;
		this.i = i;
	}
	public int compareTo(Can o) {
		return o.y > this.y ? -1 : 1;
	}
}
class Vow{
	int x;
	int y;
	int id;
	Vow(int x, int y, int id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
}