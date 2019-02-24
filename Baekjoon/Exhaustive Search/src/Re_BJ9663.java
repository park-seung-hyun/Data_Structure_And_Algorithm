// 9663번 (복습)
// N-Queen
// DFS (Depth-First-Search)
// Back-Tracking

import java.util.Scanner;
public class Re_BJ9663 {
	static int cnt = 0;
	static int N;
	static int[] row;
	static int[] col;
	static int[] cross1;
	static int[] cross2;
	public static void main (String[] args) {
		Scanner stdIn = new Scanner(System.in);
		N = stdIn.nextInt();
		row = new int[N];
		col = new int[N];
		cross1 = new int[(N-1)*2+1];
		cross2 = new int[(N-1)*2+1];
		solve();
		System.out.println(cnt);
	}
	static void solve() {
		for(int i=0;i<N;i++) {
			row[i] = 1;
			col[0] = 1;
			cross1[i+0] =1;
			cross2[i-0 + N-1] =1;
			dfs(1);
			row[i] = 0;
			col[0] = 0;
			cross1[i+0] =0;
			cross2[i-0 + N-1] =0;
		}
	}
	static void dfs(int n) {
		if(n == N) {
			cnt++;
		}
		for(int i=0;i<N;i++) {
			if(row[i] == 0 && col[n] == 0 && cross1[i+n] == 0 && cross2[i-n + N-1] ==0) {
				row[i] = 1;
				col[n] = 1;
				cross1[i+n] =1;
				cross2[i-n + N-1] =1;
				dfs(n+1);
				row[i] = 0;
				col[n] = 0;
				cross1[i+n] =0;
				cross2[i-n + N-1] =0;
			}
		}
	}
}
