// 4991번 
// 로봇청소기 
// BFS
// 더러운 방의 순서가 중요함.
// 최대 10개 -> 10! 
// 순열을 사용해서 모든 경우의 거리 구하기.
// 매우 어렵다.. 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//public class BJ4991 {
//	
//	static char[][] map;
//	static int[][] visited;
//	
//	static final int[] dx = {0,0,1,-1};
//	static final int[] dy = {1,-1,0,0};
//	
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		
//		int w = 0;
//		int h = 0;
//		
//		do {
//			h = stdIn.nextInt();
//			w = stdIn.nextInt();
//			
//			if(w==0 && h==0) break;
//			
//			map = new char[w][h];
//			visited = new int[w][h];
//			
//			stdIn.nextLine();
//			
//			for(int i=0;i<w;i++) {
//				String s = stdIn.nextLine();
//				for(int j =0;j<h;j++) {
//					map[i][j] = s.charAt(j);
//				}
//			}
//			
//			solve(w,h);
//			
//		}while(!(w==0 && h==0));
//	}
//	static boolean nextPermutation(int[] ar) {
//		int n = ar.length;
//		int i = n-1;
//		while(i>0 && ar[i-1] >= ar[i]) i-=1;
//		if(i==0) return false;
//		int j = n-1;
//		while(ar[i-1] >= ar[j]) j-=1;
//		swap(ar, i-1, j);
//		j = n-1;
//		while(i<j) {
//			swap(ar, i, j);
//			i++;
//			j--;
//		}
//		return true;	
//	}
//	static void swap(int[] ar, int id1,int id2) {
//		int temp = ar[id1];
//		ar[id1] = ar[id2];
//		ar[id2] = temp;
//	}
//	static int bfs(int w, int h, int x1, int y1, int x2, int y2) {
//		Queue<Pos2> q = new LinkedList<Pos2>();
//		q.add(new Pos2(x1,y1));
//		visited[x1][y1] = 1;
//		while(!q.isEmpty()) {
//			Pos2 p = q.remove();
//			int x = p.x;
//			int y = p.y;
//			if(x == x2 && y == y2) break;
//			
//			for(int i=0;i<4;i++) {
//				int nx = x + dx[i];
//				int ny = y + dy[i];
//				if(nx >=0 &&ny>=0 && nx <w && ny < h) {
//					if(visited[nx][ny] == 0 && map[nx][ny] != 'x') {
//						q.add(new Pos2(nx, ny));
//						visited[nx][ny] = visited[x][y] +1;
//					}
//				}
//			}	
//		}
//		return visited[x2][y2] -1;
//	}
//	static void solve(int w, int h) {
//
//		ArrayList<Pos2> al = new ArrayList<Pos2>();
//		al.add(new Pos2(0,0));
//		for(int i=0;i<w;i++) {
//			for(int j=0;j<h;j++) {
//				if(map[i][j] == 'o') {
//					Pos2 p = new Pos2(i,j);
//					// 처음에 넣어놓은 (0,0)을 (i,j)로 대체 
//					al.set(0, p);
//				}
//				if(map[i][j] == '*') {
//					Pos2 p = new Pos2(i,j);
//					al.add(p);
//				}
//			}
//		}
//
//		// distMap에 각 노드 사이 거리를 저장 (bfs로 최단 거리 저장)
//		int[][] distMap = new int[al.size()][al.size()];
//		for(int i=0;i<al.size();i++) {
//			for(int j =0;j<al.size();j++) {
//				visited = new int[w][h];
//				distMap[i][j] = bfs(w,h,al.get(i).x,al.get(i).y,al.get(j).x,al.get(j).y);
//				
//			}
//		}
//
//		int[] permu = new int[al.size()-1];
//		for(int i=0;i<al.size()-1;i++) {
//			permu[i] = i+1;
//		}
//		int min = 2000000000;
//		
//		do {
//			// 시작점부터 시작 
//			int dist = distMap[0][permu[0]];
//			for(int i=0;i<al.size()-2;i++) {
//				int temp = distMap[permu[i]][permu[i+1]];;
//				if(temp == -1) { // 닿을 수 없는 거리면 -1 
//					System.out.println(-1);
//					return;
//				}
//				dist += temp;
//			}
//			if(min >dist)
//				min = dist;
//		}while(nextPermutation(permu));
//		
//		System.out.println(min);
//	
//	}
//}
//class Pos2{
//	int x;
//	int y;
//	Pos2(int x, int y){
//		this.x = x;
//		this.y = y;
//	}
//}


public class BJ4991{
	static char[][] map;
	static int[][] visited;
	static final int[] dx = {0,0,-1,1};
	static final int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		while(true) {
			int h = stdIn.nextInt();
			int w = stdIn.nextInt();
			
			if(h == 0 && w ==0) return;
			
			map = new char[w][h];
			stdIn.nextLine();
			for(int i=0;i<w;i++) {
				String s = stdIn.nextLine();
				for(int j=0;j<h;j++) {
					map[i][j] = s.charAt(j);
				}
			}
			solve(w,h);
		}
	}
	static int bfs(int x, int y, int x2, int y2, int w,int h) {
		Queue<GPS> q = new LinkedList<GPS>();
		q.add(new GPS(x,y));
		visited = new int[w][h];
		visited[x][y] = 1;
		while(!q.isEmpty()) {
			GPS r = q.remove();
			int ox = r.x;
			int oy = r.y;
			if(ox == x2 && oy == y2) return visited[ox][oy]-1;
			for(int i=0;i<4;i++) {
				int nx = ox + dx[i];
				int ny = oy + dy[i];
				if(nx>=0 && ny >=0 && nx < w && ny < h) {
					if(visited[nx][ny] == 0 && map[nx][ny] != 'x') {
						q.add(new GPS(nx, ny));
						visited[nx][ny] = visited[ox][oy] + 1;
					}	
				}
			}
		}
		return -1;
	}
	static void solve(int w, int h) {
		ArrayList<GPS> al = new ArrayList<GPS>();
		al.add(new GPS(0,0));
		int startX = 0;
		int startY = 0;
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				if(map[i][j] == '*') {
					al.add(new GPS(i,j));
				}
				if(map[i][j] == 'o') {
					startX = i;
					startY = j;
				}
			}
		}
		al.set(0, new GPS(startX, startY));
		
		int[] ar = new int[al.size()-1];
		for(int i=0;i<al.size()-1;i++) ar[i] = i+1;
		
		
		int[][] dist = new int[al.size()][al.size()];
		
		for(int i=0;i<al.size();i++) {
			for(int j=0;j<al.size();j++) {
				dist[i][j] = bfs(al.get(i).x,al.get(i).y,
						al.get(j).x,al.get(j).y,w,h);
			}
		}
		
		int min = Integer.MAX_VALUE;
		do {
			int sum = 0;
			sum += dist[0][ar[0]];
			for(int i=0;i<ar.length-1;i++) {
				int temp = dist[ar[i]][ar[i+1]];
				if(temp == -1) {
					System.out.println(-1);
					return;
				}
				sum+=temp;
			}
			if(sum < min) min = sum;
		}while(next_Permutation(ar));
		
		System.out.println(min);
	}
	static void swap(int[] ar, int id1, int id2) {
		int temp = ar[id1];
		ar[id1] = ar[id2];
		ar[id2] = temp;
	}
	static boolean next_Permutation(int[] ar) {
		int n= ar.length;
		int i= n-1;
		while(i>0 && ar[i-1] >= ar[i]) i--;
		if(i==0) return false;
		int j = n-1;
		while(ar[i-1]>=ar[j]) j--;
		swap(ar, i-1, j);
		j = n-1;
		while(i<j) {
			swap(ar,i,j);
			i++;
			j--;
		}
		return true;
	}
}
class GPS{
	int x;
	int y;
	GPS(int x, int y){
		this.x = x;
		this. y= y;
	}
}