// 2667번 
// 단지 번호 붙히기  

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BJ2667 {
	static int[][] ar;
	static int[][] visited;	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		ar = new int[n][n];
		visited = new int[n][n];
		 stdIn.nextLine();
		for(int i=0;i<n;i++) {
			String s = stdIn.nextLine();
			for(int j=0;j<n;j++) {
				ar[i][j] = s.charAt(j) - '0';
			}
		}
		solve(n);
	}
	static void solve(int n) {
		int cnt = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(ar[i][j] == 1 && visited[i][j] == 0) {
					bfs(i,j,n, ++cnt);
//					dfs(i,j,n, ++cnt);
				}
			}
		}
		// 각각 연결 요수의 개수를 담는 배열 생성 
		System.out.println(cnt);
		int[] forPrint = new int[cnt];
		for(int i=0;i<n;i++) {
			for(int j =0;j<n;j++) {
				if(visited[i][j]!=0) {
					forPrint[visited[i][j]-1] ++;
				}
			}
		}
		Arrays.sort(forPrint);
		for(int i=0;i<cnt;i++) {
			System.out.println(forPrint[i]);
		}

	}
	static void dfs(int x, int y, int n, int cnt) {
		visited[x][y] = cnt;
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		for(int i=0;i<4;i++) {
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			if(nx>=0 && nx<n && ny>=0 && ny<n) {
				if(ar[nx][ny] == 1 && visited[nx][ny] == 0) {
					dfs(nx, ny, n, cnt);
				}
			}
		}
	}
	static void bfs(int i, int j, int n, int cnt) {
		int s = i+j*n;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[i][j] = cnt;
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		while(!q.isEmpty()) {
			int h = q.remove();
			int x = h%n;
			int y = h/n;
			for(int k=0;k<4;k++) {
				int nx = dx[k] + x;
				int ny = dy[k] + y;
				if(nx>=0 && ny >=0 && nx<n && ny<n) {
					if(ar[nx][ny] == 1 && visited[nx][ny] == 0) {
						visited[nx][ny] = cnt;
						q.add(nx+ny*n);
					}
				}
				
			}
		}
		
	}
}
