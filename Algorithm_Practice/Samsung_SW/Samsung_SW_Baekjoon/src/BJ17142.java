// 삼성 2019/4/14 역량테스트 오후 2번 
// 17142번
// 연구소3 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ17142 {
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static ArrayList<Integer> al = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner stdIn= new Scanner(System.in);
		int n = stdIn.nextInt();
		map = new int[n][n];
		int m = stdIn.nextInt();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = stdIn.nextInt();
			}
		}
		int totalBlank = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j] == 2) {
					al.add(i*n+j);
				}
				if(map[i][j] == 0) {
					totalBlank++;
				}
			}
		}
		int[] perm = new int[al.size()];
		for(int i=0;i<m;i++) perm[i] = 1;
		
		int time = Integer.MAX_VALUE;
		do {
			int t = bfs(perm, n,m,totalBlank);
			if(t < time) time = t;			
		}while(np(perm));
		if(time == Integer.MAX_VALUE) time = -1;
		System.out.println(time);
	}
	static int bfs(int[] perm, int n, int m, int totalBlank) {
		Queue<Integer> q= new LinkedList<Integer>();
		int[][] visited = new int[n][n];
		for(int i=0;i<al.size();i++) {
			if(perm[i]==1) {
				int num = al.get(i);
				int x = num/n;
				int y = num%n;
				q.add(x*n+y);
				visited[x][y] =1;
			}
		}
		int tempBlank = 0;
		int time = 0;
		while(!q.isEmpty()) {
			int h = q.remove();
			int x = h/n;
			int y = h%n;
			if(time < visited[x][y]-1) time = visited[x][y]-1;
			if(map[x][y] == 0) tempBlank ++;
			if(totalBlank == tempBlank) break;
			for(int i=0;i<4;i++) {
				int nx = x+ dx[i];
				int ny = y+ dy[i];
				if(nx>=0 && ny>=0 && nx < n && ny< n) {
					if(visited[nx][ny] == 0 && map[nx][ny] != 1) {
						q.add(nx*n+ny);
						visited[nx][ny] = visited[x][y] + 1;
					}
				}
			}
		}
		if(totalBlank == tempBlank) return time;
		else return Integer.MAX_VALUE;
	}
	
	
	static void swap(int[] ar, int id1, int id2) {
		int temp = ar[id1];
		ar[id1] = ar[id2];
		ar[id2] = temp;
	}
	static boolean np(int[] ar) {
		int n = ar.length;
		int i = n-1;
		while(i>0 && ar[i-1] <= ar[i]) i--;
		if(i==0) return false;
		int j = n-1;
		while(ar[i-1] <= ar[j])j--;
		swap(ar, i-1, j);
		j = n-1;
		while(i<j) {
			swap(ar, i, j);
			i++;
			j--;
		}
		return true;
	}
	
}
