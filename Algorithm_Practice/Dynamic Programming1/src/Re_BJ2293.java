// 2293번 (복습)
// 동전 1 
// 동적 계획법 (Dynamic Programming) 

import java.util.Scanner;
public class Re_BJ2293 {
	static int[][] d;
	static int[] w;
	static int n;
	static int k;
	public static void main(String[] args) {
		Scanner stdIn =new Scanner(System.in);
		n = stdIn.nextInt();
		k = stdIn.nextInt();
		w = new int[n+1];
		d = new int[n+1][k+1];
		for(int i=1;i<=n;i++) {
			w[i] = stdIn.nextInt();
		}
		solve();

		System.out.println(d[n][k]);
	}
	static void solve() {

		for(int i=1;i<=n;i++) {
			d[i][0] = 1;
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				d[i][j] += d[i-1][j];
				if(j-w[i]>=0)
					d[i][j] += d[i][j-w[i]];
			}
		}
	}
}
